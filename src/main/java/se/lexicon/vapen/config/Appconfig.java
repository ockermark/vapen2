package se.lexicon.vapen.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class Appconfig {
    @Bean
    public ModelMaper modelMaper(){
        return new ModelMaper()



    }



}
