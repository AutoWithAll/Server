package AutoWithAll.AutoWithAll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AutoWithAllApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoWithAllApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("OPTIONS","GET","POST","DELETE","PATCH","PUT");
			}
		};
	}

}
