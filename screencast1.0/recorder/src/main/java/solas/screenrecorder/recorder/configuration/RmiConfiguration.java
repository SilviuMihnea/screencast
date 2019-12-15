package solas.screenrecorder.recorder.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import solas.screenrecorder.recorder.remote.RemoteImageProviderImpl;
import solas.screenshare.common.RemoteImageProvider;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */

@Configuration
public class RmiConfiguration {

    private RemoteImageProviderImpl remoteImageProvider;
    private final int rmiPort;

    @Autowired
    public RmiConfiguration(RemoteImageProviderImpl remoteImageProvider, int rmiPort) {
        this.remoteImageProvider = remoteImageProvider;
        this.rmiPort = rmiPort;
    }

    @Bean
    RmiServiceExporter rmiServiceExporter(){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceInterface(RemoteImageProvider.class);
        rmiServiceExporter.setService(remoteImageProvider);
        rmiServiceExporter.setServiceName("service");
        rmiServiceExporter.setServicePort(rmiPort);
        rmiServiceExporter.setRegistryPort(rmiPort);
        return rmiServiceExporter;
    }

}
