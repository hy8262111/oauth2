
package com.ganwei.demo.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
public class TokenStoreConfig {

    /**
     * redis连接工厂
     */
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    /**
     * 用于存放token
     *
     * @return
     */
    @Bean
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }
}

