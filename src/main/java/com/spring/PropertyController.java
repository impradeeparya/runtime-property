package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pradeep on 15/7/17.
 */

@RestController
@PropertySource("classpath:config.properties")
public class PropertyController {

    @Autowired
    private Environment environment;

    @RequestMapping("/properties")
    public String loadedProperties() {

        String env = environment.getProperty("env");
        System.out.println("Environment : " + env);
        String url = environment.getProperty(env + ".url");
        System.out.println("URL : " + url);

        return url;
    }
}
