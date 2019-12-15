package solas.screenrecorder.recorder.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */

@Configuration
public class HostConfiguration {

    @Bean
    public String hostAddress() throws UnknownHostException {
        InetAddress address = Inet4Address.getLocalHost();
        return address.getHostAddress();
    }

    @Bean
    public int rmiPort(){
        return 2003;
    }
}
