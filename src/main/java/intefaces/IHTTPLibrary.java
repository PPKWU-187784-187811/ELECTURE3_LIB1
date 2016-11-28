package intefaces;

import java.io.IOException;

/**
 * Created by Adam Piech on 2016-11-22.
 */

public interface IHTTPLibrary {

    public void downloadFile(String url, String file) throws IOException;

}
