package ru.netology.netology_springbootconditional.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.netology_springbootconditional.profile.DevProfile;
import ru.netology.netology_springbootconditional.profile.ProductionProfile;
import ru.netology.netology_springbootconditional.profile.SystemProfile;


@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(prefix = "profile", name = "dev", havingValue = "true", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix = "profile", name = "dev", havingValue = "false", matchIfMissing = true)
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}