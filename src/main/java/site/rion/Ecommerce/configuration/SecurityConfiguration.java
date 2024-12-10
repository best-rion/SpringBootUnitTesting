package site.rion.Ecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration
{
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http
			.csrf(Customizer.withDefaults())
        	.authorizeHttpRequests((authReq) ->
	        	authReq
	        		.requestMatchers("/cart").hasAuthority("CUSTOMER")
	        		.requestMatchers("/admin").hasAuthority("ADMIN")
	        		.requestMatchers("/", "/page-*", "/about", "/signup", "/css/**", "/js/**", "/images/**").permitAll()
	        		.anyRequest().authenticated()
	    	)
	    	.formLogin((loginCustomizer) ->
	    		loginCustomizer
	        		.loginPage("/login")
	        		.defaultSuccessUrl("/", true)
	        		.permitAll()
	    	)
	    	.logout((logout) -> 
	        	logout
	        		.logoutSuccessUrl("/")
	        		.permitAll()
	        );	
	    
		return http.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
    
    @Bean
	public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder)
    {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);

		return new ProviderManager(authenticationProvider);
	}
}