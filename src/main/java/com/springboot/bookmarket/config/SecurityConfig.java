package com.springboot.bookmarket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig{



	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		//return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}


	@Bean
	protected UserDetailsService users() {
		UserDetails admin = User.builder()
				.username("Admin")
				.password(passwordEncoder().encode("Admin1234"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(admin);
	}




	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
				.csrf(AbstractHttpConfigurer::disable)

				// 특정 URL에 대한 권한 설정.
				.authorizeHttpRequests(
						authorizeRequests -> authorizeRequests
								.requestMatchers("/books/add").hasRole("ADMIN" )
								.requestMatchers("/order/list").hasRole("ADMIN" )
								//.requestMatchers("/order/**").hasAnyRole("USER", "ADMIN" )
								.anyRequest().permitAll()
				)
				//.formLogin(Customizer.withDefaults());
				.formLogin(
						formLogin->formLogin

								.loginPage("/login") // 사용자 정의 로그인 페이지
								.loginProcessingUrl("/login")
								.defaultSuccessUrl("/books/add")// 로그인 성공 후 이동 페이지
								.defaultSuccessUrl("/order/list")// 로그인 성공 후 이동 페이지
								.failureUrl("/loginfailed") // 로그인 실패 후 이동 페이지
								.usernameParameter("username")
								.passwordParameter("password")

				)

				.logout(
						logout -> logout
								.logoutUrl("/logout")
								.logoutSuccessUrl("/login")
						//  .deleteCookies("JSESSIONID") // 로그아웃 시 JSESSIONID 제거
						//  .invalidateHttpSession(true) // 로그아웃 시 세션 종료
						// .clearAuthentication(true) // 로그아웃 시 권한 제거
				);

		return http.build();

	}





}
