package br.com.caelum.clines.shared.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties(CorsConfigurationProperties.class)
public class CorsConfigurations implements WebMvcConfigurer {

	private final CorsConfigurationProperties corsProperties;

	@Autowired
	public CorsConfigurations(CorsConfigurationProperties corsProperties) {
		super();
		this.corsProperties = corsProperties;
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins(corsProperties.getOrigins())
				.allowedMethods(corsProperties.getMethods()).allowedHeaders(corsProperties.getHeaders())
				.allowCredentials(corsProperties.isSendCredentials());
	}
}
