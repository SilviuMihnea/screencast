package solas.projects.viewer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 19-Jun-19
 * All rights reserved
 */

@Configuration
public class SocketConfiguration {

    @Value("${thrift.host}")
    private String host;

    @Value("${thrift.port}")
    private int port;

    @Bean
    public String host() {
        return host;
    }

    @Bean
    public int port() {
        return port;
    }
}
