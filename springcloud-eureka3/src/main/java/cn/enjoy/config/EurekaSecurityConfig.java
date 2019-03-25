package cn.enjoy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by zzy on 2019/3/20.
 */
@Configuration
public class EurekaSecurityConfig extends WebSecurityConfigurerAdapter {
    //配置关闭劫持
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);
    }
}
