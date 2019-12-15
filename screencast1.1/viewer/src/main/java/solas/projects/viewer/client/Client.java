package solas.projects.viewer.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import solas.projects.common.compresser.CompressingUtils;
import solas.projects.common.provider.TService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 19-Jun-19
 * All rights reserved
 */

@Component
public class Client {

    private TFramedTransport transport;

    private TService.Client client;

    private CompressingUtils compressingUtils;

    @Autowired
    public Client(CompressingUtils compressingUtils, String host, int port) {
        this.compressingUtils = compressingUtils;
        TTransport tTransport = new TSocket(host, port);
        transport = new TFramedTransport(tTransport);
        TProtocol protocol = new TBinaryProtocol(transport);
        client = new TService.Client(protocol);
    }

    @PostConstruct
    public void start() {
        try {
            transport.open();
        } catch (TTransportException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void stop() {
        transport.close();
    }

    public byte[] getImageBytes() {
        try {
            byte[] bytes = client.getImage().getData();
            return compressingUtils.decompress(bytes);
        } catch (TException e) {
            throw new RuntimeException(e);
        }
    }
}
