package solas.projects.recorder.server;

import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import solas.projects.common.provider.TService;
import solas.projects.recorder.service.TServiceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 19-Jun-19
 * All rights reserved
 */

@Component
public class Server {

    private TServiceImpl tService;
    private TNonblockingServerTransport serverTransport;
    private TServer server;

    @Value("${thrift.port}")
    private int port;

    @Autowired
    public Server(TServiceImpl tService) {
        this.tService = tService;
    }

    @PostConstruct
    public void serve() {
        try {
            serverTransport = new TNonblockingServerSocket(port);
            server = new TNonblockingServer(
                    new TNonblockingServer.Args(serverTransport)
                            .processor(new TService.Processor<>(tService)));
            new Thread(() -> {
                System.out.println("Start Serving");
                server.serve();
            }).start();
        } catch (TTransportException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void stop(){
        server.stop();
    }
}
