package com.example.retail.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperUtil
{
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
		/*mapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT)
				.setFieldMatchingEnabled(true)
				.setSkipNullEnabled(true)
				.setFieldAccessLevel(PRIVATE);*/
        return mapper;
    }

}
