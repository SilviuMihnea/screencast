package solas.projects.common.compresser;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 19-Jun-19
 * All rights reserved
 */

public class CompressingUtils {

    public byte[] compress(byte[] bytes) {
        try {
            return this._compress(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] decompress(byte[] bytes) {
        try {
            return this._decompress(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] _compress(byte[] bytes) throws Exception {
        Deflater deflater = new Deflater();
        deflater.setInput(bytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytes.length);
        deflater.finish();
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        return outputStream.toByteArray();
    }

    public byte[] _decompress(byte[] bytes) throws Exception {
        Inflater inflater = new Inflater();
        inflater.setInput(bytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytes.length);
        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
            int count = 0;
            count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        return outputStream.toByteArray();
    }
}
