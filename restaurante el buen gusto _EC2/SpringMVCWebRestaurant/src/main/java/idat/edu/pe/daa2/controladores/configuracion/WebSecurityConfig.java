package idat.edu.pe.daa2.controladores.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/css/**", "/imagenes/**", "/js/**", "/", "/principal", "/home", "/inicio", "/logeo", "/login","/rest/**")
		.permitAll()
		.antMatchers("/clientes/listarTodoCliente").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
		.antMatchers("/clientes/nuevo").hasAnyRole("ADMIN","CREADOR")
		.antMatchers("/clientes/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		.antMatchers("/clientes/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		.antMatchers("/clientes/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		
		.antMatchers("/productos/listarTodoProducto").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
		.antMatchers("/productos/nuevo").hasAnyRole("ADMIN","CREADOR")
		.antMatchers("/productos/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		.antMatchers("/productos/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		.antMatchers("/productos/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		
		
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/bienvenida", true).permitAll()
		.and().logout()
		.permitAll();
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN").and()
		.withUser("jason").password(encoder.encode("jason")).roles("LECTOR").and();
		

	}
	
}
