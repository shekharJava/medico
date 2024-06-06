package com.oderzy._config_;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@EnableMethodSecurity(prePostEnabled = false)

@EnableJpaRepositories(basePackages = { "com.oderzy.customer.repositery", "com.oderzy.service.general.repositery",
		"com.oderzy.whatsapp", "com.oderzy.staff.repositery", "com.oderzy.doctor", "com.oderzy.stores_offers","com.oderzy._data_.repositery",
		"com.oderzy.pharma", })

public class RestConfig implements WebMvcConfigurer {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}

		};
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()

				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/api/test/**").permitAll().antMatchers("/**").permitAll().anyRequest().authenticated();

		return http.build();
	}

	private Customizer<HttpBasicConfigurer<HttpSecurity>> withDefaults() {
		return null;
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> arg0) {
		// we will apply later

	}

	@Override
	public void addCorsMappings(CorsRegistry registery) {

		registery.addMapping("/**");

	}

	@Override
	public void addFormatters(FormatterRegistry arg0) {

		// we will apply later

	}

	@Override
	public void addInterceptors(InterceptorRegistry arg0) {
		// we will apply later

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry arg0) {
		// we will apply later

	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> arg0) {

		// we will apply later

	}

	@Override
	public void addViewControllers(ViewControllerRegistry arg0) {

		// we will apply later

	}

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer arg0) {

		// we will apply later

	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer arg0) {

		// we will apply later

	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer arg0) {
		// we will apply later

	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> arg0) {
		// we will apply later

	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> arg0) {
		// we will apply later

	}

	@Override
	public void configurePathMatch(PathMatchConfigurer arg0) {
		// we will apply later

	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry arg0) {
		// we will apply later

	}

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> arg0) {
		// we will apply later

	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> arg0) {
		// we will apply later

	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// we will apply later

		return null;
	}

	@Override
	public Validator getValidator() {
		// we will apply later

		return null;
	}

}
