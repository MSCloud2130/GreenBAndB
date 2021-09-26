/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author estudiantes
 */
@Configuration
public class WebClientConfiguration {
    @LoadBalanced
    @Bean
    public WebClient usersWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .clone()
                .baseUrl("http://users/clients/")
                .build();
    }
    @LoadBalanced
    @Bean
    public WebClient servicesWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .clone()
                .baseUrl("http://services/services??/")
                .build();
    }
}