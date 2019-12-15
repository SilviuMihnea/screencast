package solas.projects.recorder.service;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import solas.projects.common.compresser.CompressingUtils;
import solas.projects.common.converter.ImageConverter;
import solas.projects.common.provider.InvalidOperationException;
import solas.projects.common.provider.TImage;
import solas.projects.common.provider.TService;
import solas.projects.recorder.recorder.Recorder;

import java.awt.image.BufferedImage;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 19-Jun-19
 * All rights reserved
 */

@Component
public class TServiceImpl implements TService.Iface {

    private final Recorder recorder;
    private ImageConverter converter;
    private CompressingUtils compressingUtils;

    @Autowired
    public TServiceImpl(Recorder recorder,
                        ImageConverter converter,
                        CompressingUtils compressingUtils) {
        this.recorder = recorder;
        this.converter = converter;
        this.compressingUtils = compressingUtils;
    }

    @Override
    public TImage getImage() throws InvalidOperationException, TException {
        BufferedImage bImage = recorder.getLastImage();
        byte[] bytes = converter.convertImage(bImage);
        bytes = compressingUtils.compress(bytes);
        TImage image = new TImage();
        image.setData(bytes);
        return image;
    }
}
