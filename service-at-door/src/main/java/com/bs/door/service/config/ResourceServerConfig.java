package com.bs.door.service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	private String resourceId="testToken";

	@Override
	public void configure(ResourceServerSecurityConfigurer config) throws Exception {
		config.resourceId(resourceId);
		config.tokenServices(tokenServices());
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

//		ClassPathResource resource = new ClassPathResource("public.txt");
//		String publicKey = null;
//		try {
//			publicKey = IOUtils.toString(resource.getInputStream(), Charset.defaultCharset());
//		} catch (final IOException ex) {
//			System.out.println("unable to read public key" + ex);
//			return null;
//		}
//		converter.setVerifierKey(publicKey);
		return converter;
	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		return defaultTokenServices;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/healthCheck").permitAll()
				// Start - get access to swagger-ui
				.antMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll().antMatchers(HttpMethod.GET, "/webjars/**")
				.permitAll().antMatchers(HttpMethod.GET, "/v2/api-docs").permitAll()
				.antMatchers(HttpMethod.GET, "/swagger-resources/**").permitAll()
				// End - get access to swagger-ui
				.antMatchers("/**").authenticated().and().cors().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// @formatter:on
	}
}
