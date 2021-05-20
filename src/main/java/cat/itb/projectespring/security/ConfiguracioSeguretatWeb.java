package cat.itb.projectespring.security;import cat.itb.projectespring.model.servei.UserDetailsService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.context.annotation.Configuration;import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;import org.springframework.security.config.annotation.web.builders.HttpSecurity;import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;import org.springframework.security.crypto.password.PasswordEncoder;@Configuration@EnableWebSecuritypublic class ConfiguracioSeguretatWeb extends WebSecurityConfigurerAdapter {    @Autowired    private UserDetailsService serveiUsuaris;    public PasswordEncoder passwordEncoder() {        return new BCryptPasswordEncoder();    }    @Override    protected void configure(AuthenticationManagerBuilder auth) throws Exception{        auth.userDetailsService(serveiUsuaris)                .passwordEncoder(passwordEncoder());    }    @Override    protected void configure(HttpSecurity http) throws Exception {        http                .authorizeRequests()                .antMatchers("/", "/registration","/error","/h2-console/**").permitAll()                .antMatchers("/userList","/update/**","/delete/**").hasRole("ADMIN") //només poden editar usuaris els "ADMIN"                .anyRequest().authenticated()                .and()                .formLogin()                .permitAll()                .and()                .logout()                .logoutSuccessUrl("/")//redirecció a /login?logout                .permitAll();        http.csrf().disable(); //per h2-console        http.headers().frameOptions().disable();    }}