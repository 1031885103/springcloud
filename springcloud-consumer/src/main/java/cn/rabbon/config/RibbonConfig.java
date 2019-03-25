package cn.rabbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;

/**
 * Created by zzy on 2019/3/23.
 */
public class RibbonConfig {

    @Bean
    public IRule iRule() {
        return new RoundRobinRule();
    }
}
