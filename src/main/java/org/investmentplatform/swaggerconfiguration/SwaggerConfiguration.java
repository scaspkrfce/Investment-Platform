package org.investmentplatform.swaggerconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.google.common.base.Predicate;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration 
{	
	@Bean
	public Docket companyApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("org.investmentplatform.service"))
	        .paths((Predicate<String>) PathSelectors.any())
	        .build()
	        ;
	    }
}
