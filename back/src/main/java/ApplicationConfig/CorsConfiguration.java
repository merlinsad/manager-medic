package ApplicationConfig;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Classe responsável por permitir comunicação entre appWeb e appServer
public class CorsConfiguration implements WebMvcConfigurer{

	public void addCorsMapping(CorsRegistry corsRegistry) {
		corsRegistry
		.addMapping("/**")
		.allowedOriginPatterns("aqui irá a url/porta da aplicação web")
		.allowedMethods("GET", "POST", "PUT", "DELETE");
	}
}
