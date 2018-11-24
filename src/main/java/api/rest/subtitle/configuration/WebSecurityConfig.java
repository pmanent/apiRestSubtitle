/**
 * 
 */
package api.rest.subtitle.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.SessionManagementFilter;

/**
 * @author peremanent
 *
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 
	 */
	public WebSecurityConfig() {
	}

	/**
	 * @param disableDefaults
	 */
	public WebSecurityConfig(boolean disableDefaults) {
		super(disableDefaults);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	        .addFilterBefore(myCorsFilter(), 
	                       SessionManagementFilter.class)
		    .cors();
	    

	    
	    http
	    	.httpBasic()
	    .and()
	    	.authorizeRequests()
	    		.anyRequest().authenticated();
	}
	
	@Bean
	WebSecurityCorsFilter myCorsFilter() {
	    return new WebSecurityCorsFilter();
	}

    

}
