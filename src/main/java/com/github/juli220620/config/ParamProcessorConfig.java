package com.github.juli220620.config;

import com.github.juli220620.dao.impl.AmenityParamProcessor;
import com.github.juli220620.dao.impl.composite.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParamProcessorConfig {

    @Bean
    public PropertyParamProcessorComposite paramProcessor() {
        var root = new NameParamProcessor();

        root.compose(new BrandParamProcessor())
                .compose(new CountryParamProcessor())
                .compose(new CityParamProcessor())
                .compose(new AmenityParamProcessor())
        ;

        return root;
    }
}
