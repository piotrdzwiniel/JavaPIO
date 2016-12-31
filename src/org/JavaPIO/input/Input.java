package org.JavaPIO.input;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Piotr Dzwiniel on 29.12.2016.
 */
public class Input {

    /*
    PRIVATE FIELDS
     */

    private File file; // TODO: Does this field is realy necessary?

    /*
    CONSTRUCTORS
     */

    /**
     * Basic constructor.
     */
    public Input() {

    }

    /**
     * Overloaded constructor with java.io.File parameter.
     * @param file the java.io.File object.
     */
    public Input(File file) {
        this.file = file;
    }

    /*
    LOAD DATA METHODS
     */

    /**
     * Get file content as single String. Read file's content and asign it to String variable.
     * @param file the java.io.File object.
     * @return the content of the passed "file" parameter.
     * @throws IOException when Files.readAllBytes(Path path) method throws IOException.
     */
    public String asSingleString(File file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file.toURI())));
    }

    /**
     * Get file content as single String. Read file's content and asign it to String variable.
     * @return the content of the private "file" field.
     * @throws NullPointerException when private "field" is not initialized.
     * @throws IOException when asSingleString(File file) method throws IOException.
     */
    public String asSingleString() throws NullPointerException, IOException {
        return asSingleString(file);
    }

    /**
     * Get file content as String array of individual characters.
     * @param file the java.io.File object.
     * @return the String array of individual characters read from passed "file" parameter.
     * @throws IOException when Files.readAllBytes(Path path) method throws IOException.
     */
    public String[] asStringDividedIntoCharacters(File file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file.toURI()))).split("");
    }

    /**
     * Get file content as String array of individual characters.
     * @return the String array of individual characters read from private "file" field.
     * @throws NullPointerException when private "field" is not initialized.
     * @throws IOException when asStringDividedIntoCharacters(File file) method throws IOException.
     */
    public String[] asStringDividedIntoCharacters() throws NullPointerException, IOException {
        return asStringDividedIntoCharacters(file);
    }

    /**
     * Get file content as String array of divided substrings based on a given regex.
     * @param file the java.io.File object.
     * @param regex dividing rule for String content of the file.
     * @return the String array of divided substrings read from passed "file" parameter.
     * @throws IOException when Files.readAllBytes(Path path) method throws IOException.
     */
    public String[] asStringDividedIntoCharacters(File file, String regex) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file.toURI()))).split(regex);
    }

    /**
     * Get file content as String array of divided substrings based on a given regex.
     * @param regex dividing rule for String content of the file.
     * @return the String array of divided substrings read from private "file" field.
     * @throws NullPointerException when private "field" is not initialized.
     * @throws IOException when Files.readAllBytes(Path path) method throws IOException.
     */
    public String[] asStringDividedIntoCharacters(String regex) throws NullPointerException, IOException {
        return new String(Files.readAllBytes(Paths.get(file.toURI()))).split(regex);
    }

    /**
     * Read lines from a given file.
     * @param file the java.io.File object.
     * @return ArrayList of individual lines read from file in a form of a Strings.
     * @throws IOException when creation of BufferedReader object throws IOException.
     */
    public ArrayList<String> asArrayListOfIndividualLines(File file) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while (bufferedReader.readLine() != null) {
            arrayList.add(bufferedReader.readLine());
        }
        bufferedReader.close();

        return arrayList;
    }

    /**
     * Read lines from a given file - in this case from private "file" field.
     * @return ArrayList of individual lines read from file in a form of a Strings.
     * @throws NullPointerException when private "field" is not initialized.
     * @throws IOException when readLines(File file) method throws IOException.
     */
    public ArrayList<String> asArrayListOfIndividualLines() throws NullPointerException, IOException {
        return asArrayListOfIndividualLines(file);
    }

    /**
     * Get file content as one-dimensional byte array of individual digits.
     * @param file the java.io.File object.
     * @return the one-dimensional Byte array of individual digits read from passed "file" parameter.
     * @throws IOException when asSingleString(File file) method throws IOException.
     */
    public Byte[] asVectorOfIndividualByteDigits(File file) throws IOException {
        String content = asSingleString(file);
        if (content.matches("[0-9]+")) {
            String[] individualCharacters = content.split("");
            Byte[] individualBytes = new Byte[individualCharacters.length];
            for (int i = 0; i < individualCharacters.length; i++) {
                individualBytes[i] = Byte.parseByte(individualCharacters[i]);
            }
            return individualBytes;
        } else {
            throw new IllegalArgumentException("File content do not match assumed requirements - it must match regex \"[0-9]+\"");
        }
    }

    /**
     * Get file content as one-dimensional byte array of individual digits.
     * @return the one-dimensional Byte array of individual digits read from private "file" field.
     * @throws NullPointerException when private "field" is not initialized.
     * @throws IOException when asVectorOfIndividualByteDigits(File file) method throws IOException.
     */
    public Byte[] asVectorOfIndividualByteDigits() throws NullPointerException, IOException {
        return asVectorOfIndividualByteDigits(file);
    }

    /**
     * Get file content as one-dimensional vector of integer values splitted by specific regex.
     * @param file the java.io.File object.
     * @param regex dividing rule for String content of the file.
     * @return one-dimensional vector of integer values.
     * @throws IOException when asSingleString(File file) method throws IOException.
     * @throws NumberFormatException when Integer.parseInt(String string) throws NumberFormatException.
     */
    public Integer[] asVectorOfIntegerValues(File file, String regex) throws IOException, NumberFormatException {
        String content = asSingleString(file);
        String[] divided = content.split(regex);
        Integer[] vector = new Integer[divided.length];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = Integer.parseInt(divided[i]);
        }
        return vector;
    }

    /**
     * Get file content as one-dimensional vector of integer values splitted by specific regex.
     * @param regex dividing rule for String content of the file.
     * @return one-dimensional vector of integer values.
     * @throws NullPointerException when private "field" is not initialized.
     * @throws IOException when asVectorOfIntegerValues(File file, String regex) method throws IOException.
     * @throws NumberFormatException when asVectorOfIntegerValues(File file, String regex) method throws IOException.
     */
    public Integer[] asVectorOfIntegerValues(String regex) throws NullPointerException, IOException, NumberFormatException {
        return asVectorOfIntegerValues(file, regex);
    }

    /*
    GETTERS AND SETTERS
     */

    /**
     * Get private java.io.File "file" object.
     * @return private java.io.File "file" object.
     */
    public File getFile() {
        return file;
    }

    /**
     * Set private java.io.File "file" object.
     * @param file private java.io.File "file" object.
     */
    public void setFile(File file) {
        this.file = file;
    }
}
