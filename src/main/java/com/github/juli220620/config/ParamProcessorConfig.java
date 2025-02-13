package com.github.juli220620.config;

import com.github.juli220620.dao.impl.composite.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParamProcessorConfig {

    @Bean
    public ParamProcessor paramProcessor() {
        return
                new NameParamProcessor(
                        new BrandParamProcessor(
                                new CityParamProcessor(
                                        new CountryParamProcessor(
                                                new AmenityParamProcessor()
                                        )
                                )
                        )
                );
    }
}
