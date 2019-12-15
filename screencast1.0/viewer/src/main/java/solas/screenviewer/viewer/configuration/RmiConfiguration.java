package solas.screenviewer.viewer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import solas.screenshare.common.RemoteImageProvider;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */
@Configuration
public class RmiConfiguration {

    @Value( "${rmi.host}" )
    private String hostAddress;

    @Value( "${rmi.port}" )
    private int rmiPort;


    @Bean
    public RmiProxyFactoryBean rmiProxyFactoryBean(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(RemoteImageProvider.class);
        rmiProxyFactoryBean.setServiceUrl(
                "rmi://" + hostAddress + ":" + rmiPort + "/service");
        return rmiProxyFactoryBean;
    }

    Registry registry() throws RemoteException {
        return LocateRegistry.getRegistry(hostAddress, rmiPort);
    }
}
