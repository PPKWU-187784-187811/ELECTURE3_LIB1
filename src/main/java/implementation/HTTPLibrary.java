package implementation;

import intefaces.IHTTPLibrary;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Adam Piech on 2016-11-28.
 */

public class HTTPLibrary implements IHTTPLibrary {

    private static int BUFFER_SIZE = 1024;
    private static int OFFSET = 0;
    private static int END_OF_FILE = -1;

    @Override
    public void downloadFile(String url, String file) throws IOException {
        BufferedInputStream bufferStream = null;
        FileOutputStream fileStream = null;
        try {
            bufferStream = new BufferedInputStream(new URL(url).openStream());
            fileStream = new FileOutputStream(file);
            readData(bufferStream, fileStream);
        } finally {
            if (bufferStream != null) {
                bufferStream.close();
            }
            if (fileStream != null) {
                fileStream.close();
            }
        }
    }

    private void readData(BufferedInputStream bufferStream, FileOutputStream fileStream) throws IOException {
        byte data[] = new byte[BUFFER_SIZE];
        int count;
        while ((count = bufferStream.read(data, OFFSET, BUFFER_SIZE)) != END_OF_FILE) {
            fileStream.write(data, OFFSET, count);
        }
    }

}
