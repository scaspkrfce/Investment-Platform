package org.investmentplatform.service;

import java.util.Random;

import org.investmentplatform.model.access.Access;
import org.investmentplatform.model.access.AccessRepository;
import org.investmentplatform.model.user.User;
import org.investmentplatform.model.user.UserRepository;
import org.investmentplatform.security.HashGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessRestController 
{
	@Autowired
	AccessRepository accessRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	private SendEmail sendEmail;
	@GetMapping("/access")
	int Access (@RequestParam("email") String email)
	{
		int isOTPActive = 0;
		User user = userRepository.findByEmail(email).get();
		Long id = user.getUserId();
		Access access = accessRepository.findByUserId(id).get();
		if(access.getOtp()!=null)
		{
			isOTPActive = 1;
		}
		else
		{
			Random rnd = new Random();
		    int number = rnd.nextInt(999999);
			access.setOtp(String.format("%06d", number));
			access = accessRepository.save(access);
			sendEmail.sendEmail(email, "Información de Seguridad", "Tu codigo temporal para cambiar tu contraseña es: "+access.getOtp()+". Si no has pedido un codigo de restauración ignora este mensaje");
			isOTPActive = 2;
		}
		return isOTPActive;
	}
	@GetMapping("/access/restore")
	int changedPassword (@RequestParam("email")String email, @RequestParam("code")String recoveryCode, @RequestParam("newPassword")String password, @RequestParam("confirmPassword")String confirmPassword)
	{
		int changedPassword = 4;
		User user = userRepository.findByEmail(email).get();
		Long id = user.getUserId();
		Access access = accessRepository.findByUserId(id).get();
		if(access.getOtp().equals(recoveryCode)&&password.equals(confirmPassword))
		{
			if(HashGenerator.check(password, user.getPasswordHash()))
			{
				changedPassword = 1;
			}
			else
			{
				user.setPasswordHash(HashGenerator.GenerateHashFromPassword(password));
				user = userRepository.save(user);
				access.setOtp(null);
				access = accessRepository.save(access);
				sendEmail.sendEmail(email, "Información de Seguridad", "Tu cambio de contraseña se ha realizado con exito");
				changedPassword = 2;
			}
		}
		return changedPassword;	
	}
}
