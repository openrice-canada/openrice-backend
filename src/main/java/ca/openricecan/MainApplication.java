package ca.openricecan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication
@RestController
public class MainApplication {
  @RequestMapping
	public String home() {
		return "Welcome to Open Rice Canada";
	}

  public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

//  @Bean
//  public WebMvcConfigure corsConfigure() {
//    return new WebMvcConfigure() {
//        @Override
//        public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/**").allowedOrigins("http://localhost:3000");
//        }
//    };
//  }
}