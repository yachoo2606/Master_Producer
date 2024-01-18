package com.example.producer.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModeMapperConfig {

    @Bean
    public static ModelMapper modelMapper(){
        ModelMapper modelmapper = new ModelMapper();
        modelmapper.getConfiguration()
          .setFieldMatchingEnabled(true)
          .setFieldAccessLevel(AccessLevel.PRIVATE);
        return modelmapper;
    }

}
