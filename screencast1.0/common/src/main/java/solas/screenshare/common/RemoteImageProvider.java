package solas.screenshare.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Silviu-Mihnea Cucuiet
 * @since 18-Jun-19
 * All rights reserved
 */
public interface RemoteImageProvider extends Remote {

    byte[] getImageData() throws RemoteException;
}
