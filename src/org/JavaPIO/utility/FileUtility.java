package org.JavaPIO.utility;

import java.io.File;

/**
 * Created by Piotr Dzwiniel on 31.12.2016.
 */
public class FileUtility {

    /**
     * Get file extension, eg. get extension of a file "foo.txt" as "txt".
     * @param file the java.io.File object for which file extension will be checked.
     * @return file extension as a String, eg. "txt", for passed "file" parameter.
     */
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}
