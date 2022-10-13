package com.ampada.taskmanagementwithmongo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper  modelMapper() {
        return new ModelMapper();
    }
}
