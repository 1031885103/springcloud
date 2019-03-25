package cn.enjoy.config;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by zzy on 2019/3/17.
 */
//@Configuration
public class WebCsrfDisable extends WebSecurityConfigurerAdapter {
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);
    }*/
}
