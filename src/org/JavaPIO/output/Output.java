package org.JavaPIO.output;

import java.io.File;

/**
 * Created by Piotr Dzwiniel on 31.12.2016.
 */
public class Output {

    /*
    PRIVATE FIELDS
     */

    private File file;

    /*
    CONSTRUCTORS
     */

    /**
     * Basic constructor.
     */
    public Output() {

    }

    /**
     * Overloaded constructor with java.io.File parameter.
     * @param file the org.JavaPIO.output java.io.File object.
     */
    public Output(File file) {
        this.file = file;
    }

    /*
    FILE METHODS
     */



}
