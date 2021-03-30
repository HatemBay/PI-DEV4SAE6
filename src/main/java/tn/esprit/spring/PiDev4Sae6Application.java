package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PiDev4Sae6Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(PiDev4Sae6Application.class, args);
	}
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/").setViewName("landing-page");
	    }
}
