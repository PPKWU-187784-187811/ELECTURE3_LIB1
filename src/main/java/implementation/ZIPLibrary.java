package implementation;

import intefaces.IZIPLibrary;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;

import static java.io.File.separator;


/**
 * Created by Adam Piech on 2016-11-28.
 */

public class ZIPLibrary implements IZIPLibrary {

    @Override
    public void compress(String source, String destination, String zipFileName, String password) {
        try {
            File file = new File(source);
            ZipFile zipFile = new ZipFile(destination + separator + zipFileName);
            zipFile.addFile(file, prepareParameters(password));
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void decompress(String source, String destination, String password) {
        try {
            ZipFile zipFile = new ZipFile(source);
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(password);
            }
            zipFile.extractAll(destination);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    private ZipParameters prepareParameters(String password) {
        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        parameters.setPassword(password);
        return parameters;
    }

}
