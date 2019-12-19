package br.com.escola;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.escola.interceptor.LoginAdminInterceptor;
import br.com.escola.interceptor.LoginInterceptor;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/materias").excludePathPatterns("/login", "/","/fazerLogin");
		registry.addInterceptor(new LoginAdminInterceptor()).addPathPatterns("/menu_admin", "/criar_professor", "/criar_materia", "/criar_aluno", "/criar_materia_aluno");
	}
}