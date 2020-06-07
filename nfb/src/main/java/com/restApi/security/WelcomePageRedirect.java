package com.restApi.security;

/**
 * @author : Nelson Flores B.
 * @version: 1.0
 * @created: 07-jun.-2020  10:52
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WelcomePageRedirect implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("forward:/pages/main.xhtml");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }


}


