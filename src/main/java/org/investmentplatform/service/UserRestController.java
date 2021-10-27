package org.investmentplatform.service;

import java.util.List;

import org.investmentplatform.model.user.User;
import org.investmentplatform.model.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController 
{
	private static final Logger log = LoggerFactory.getLogger(ProjectRestController.class );
	@Autowired
	UserRepository userRepository;
	private AuthenticationRestController authenticationRestController;
	@GetMapping ("/users")
	List<User> users() 
	{
		log.info("found users");
		return userRepository.findAll();
	}
	@GetMapping ("/users/admins")
	List<User> admins() 
	{
		log.info("found admins");
		List<User> userList = userRepository.findAll();
		authenticationRestController = null;
		for(User index: userList)
		{
			if(!authenticationRestController.isAdmin(index))
			{
				userList.remove(index);
			}
		}
		return userList;
	}
	@GetMapping ("/user/{userId}")
	User getUser(@PathVariable Long userId)
	{
		log.info("found user "+userId);
		return userRepository.findById(userId).get();
	}
	@PostMapping ("/user")
	User newUser(@RequestBody User user) 
	{
		
		log.info("created user "+user.getUserId());
		return userRepository.save(user);
	}
	@PatchMapping ("/user/{userId}")
	User updateUser(@RequestBody User user, @PathVariable Long userId)
	{
		log.info("updated user "+user.getUserId());
		return userRepository.findById(userId)
		.map(thisUser->
		{
            if(!user.getFirstName().equals(""))
            	thisUser.setFirstName(user.getFirstName());
            if(!user.getSurname().equals(""))
            	thisUser.setSurname(user.getSurname());
            if(!user.getEmail().equals(""))
            	thisUser.setEmail(user.getEmail());
            if(!(user.getPhoneNumber() == 0))
            	thisUser.setPhoneNumber(user.getPhoneNumber());
            if(!user.getPasswordHash().equals(""))
            	thisUser.setPasswordHash(user.getPasswordHash());

            return this.userRepository.save(thisUser);
        })
        .orElseGet(()->
        {
            user.setUserId(userId);
            return this.userRepository.save(user);
        });
	}
}
