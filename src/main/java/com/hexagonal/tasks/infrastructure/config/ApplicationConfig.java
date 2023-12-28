package com.hexagonal.tasks.infrastructure.config;

import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.application.usecases.*;
import com.hexagonal.tasks.domain.ports.in.GetAdditionalTaksInfoUseCase;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonal.tasks.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaksInfoUseCase getAdditionalTaksInfoUseCase){
        return new TaskService(new TaskUseCasesImpl(taskRepositoryPort), getAdditionalTaksInfoUseCase);
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaksInfoUseCase getAdditionalTaksInfoUseCase(ExternalServicePort externalServicePort){
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter(new RestTemplate());
    }

}


