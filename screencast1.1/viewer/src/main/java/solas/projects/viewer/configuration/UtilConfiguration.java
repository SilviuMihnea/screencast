package solas.projects.viewer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import solas.projects.common.compresser.CompressingUtils;
import solas.projects.common.converter.ImageConverter;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 19-Jun-19
 * All rights reserved
 */
@Configuration
public class UtilConfiguration {



    @Bean
    public CompressingUtils compressingUtils(){
        return new CompressingUtils();
    }

    @Bean
    public ImageConverter imageConverter(){
        return new ImageConverter();
    }
}
