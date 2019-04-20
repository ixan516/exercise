package cn.ixan.example.configuration;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年4月5日, 0005
 */
//@Configuration
//@EnableWebSecurity
/*public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/home").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.permitAll();
	}

	@Autowired
	private void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
		auth.inMemoryAuthentication()
				.withUser("stackzhang").password("123456").roles("USER");
	}

}*/
