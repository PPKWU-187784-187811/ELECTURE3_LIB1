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

    @Override
    public void downloadFile(String url, String file) throws IOException {
        BufferedInputStream bufferStream = null;
        FileOutputStream fileStream = null;
        try {
            bufferStream = new BufferedInputStream(new URL(url).openStream());
            fileStream = new FileOutputStream(file);

            byte data[] = new byte[1024];
            int count;
            while ((count = bufferStream.read(data, 0, 1024)) != -1) {
                fileStream.write(data, 0, count);
            }
        } finally {
            if (bufferStream != null)
                bufferStream.close();
            if (fileStream != null)
                fileStream.close();
        }
    }

}
