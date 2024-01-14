package com.br.eadnotificationhexagonal.adapters.configs;

import com.br.eadnotificationhexagonal.EadNotificationHexagonalApplication;
import com.br.eadnotificationhexagonal.core.ports.NotificationPersistencePort;
import com.br.eadnotificationhexagonal.core.service.NotificationServicePortImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = EadNotificationHexagonalApplication.class)
public class BeanConfiguration {

    @Bean
    NotificationServicePortImpl notificationServicePort(NotificationPersistencePort persistence){
        return new NotificationServicePortImpl(persistence);
    }

    @Bean
    public ModelMapper modelMapper(){
        return modelMapper();
    }
}
