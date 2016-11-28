package intefaces;

/**
 * Created by Adam Piech on 2016-11-22.
 */

public interface IZIPLibrary {

    public void compress(String source, String destination, String zipFileName, String password);

    public void decompress(String source, String destination, String password);

}
