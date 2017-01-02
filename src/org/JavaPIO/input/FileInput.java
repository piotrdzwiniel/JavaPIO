package org.JavaPIO.input;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Piotr Dzwiniel on 29.12.2016.
 */
public class FileInput {

    /**
     * Get file content as single String. Read file's content and asign it to String variable.
     * @param file the java.io.File object.
     * @return the content of the passed "file" parameter.
     */
    public static String asSingleString(File file) {
        String fileContent = null;
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(file.toURI())));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileContent;
    }

    /**
     * Get file content as String array of individual characters.
     * @param file the java.io.File object.
     * @return the String array of individual characters read from passed "file" parameter.
     */
    public static String[] asIndividualCharacters(File file) {
        String[] fileContent = null;
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(file.toURI()))).split("");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileContent;
    }

    /**
     * Get file content as String array of divided substrings based on a given regex.
     * @param file the java.io.File object.
     * @param regex dividing rule for String content of the file.
     * @return the String array of divided substrings read from passed "file" parameter.
     */
    public static String[] asIndividualCharacters(File file, String regex) {
        String[] fileContent = null;
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(file.toURI()))).split(regex);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileContent;
    }

    /**
     * Read lines from a given file.
     * @param file the java.io.File object.
     * @return ArrayList of individual lines read from file in a form of a Strings.
     */
    public static ArrayList<String> asArrayListOfIndividualLines(File file) {
        ArrayList<String> arrayList = new ArrayList<>();

        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while ((line = bufferedReader.readLine()) != null) {
                arrayList.add(line);
            }
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return arrayList;
    }

    /**
     * Get file content as one-dimensional byte array of individual digits.
     * @param file the java.io.File object.
     * @return the one-dimensional Byte array of individual digits read from passed "file" parameter.
     * @throws IllegalArgumentException when file content do not match regex "[0-9]+".
     */
    public static Byte[] asIndividualDigits(File file) throws IllegalArgumentException {
        String content = asSingleString(file).replaceAll("[^\\d.]", "");
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
     * Get file content as one-dimensional vector of integer values splitted by specific regex.
     * @param file the java.io.File object.
     * @param regex dividing rule for String content of the file.
     * @return one-dimensional vector of integer values.
     * @throws NumberFormatException when Integer.parseInt(String string) throws NumberFormatException.
     */
    public static Integer[] asIntegerValues(File file, String regex) throws NumberFormatException {
        String content = asSingleString(file);
        String[] divided = content.split(regex);
        Integer[] vector = new Integer[divided.length];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = Integer.parseInt(divided[i]);
        }
        return vector;
    }

    /**
     * Get file content as one-dimensional vector of float values splitted by specific regex. Float values in file
     * must be dot-based, e.g. "1.2", "3.14159" etc.
     * @param file the java.io.File object.
     * @param regex dividing rule for String content of the file.
     * @return one-dimensional vector of float values.
     * @throws NumberFormatException when Float.parseFloat(String string) throws NumberFormatException.
     */
    public static Float[] asFloatValues(File file, String regex) throws NumberFormatException {
        String content = asSingleString(file);
        String[] divided = content.split(regex);
        Float[] vector = new Float[divided.length];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = Float.parseFloat(divided[i]);
        }
        return vector;
    }

    /**
     * Get file content as one-dimensional vector of double values splitted by specific regex. Double values in file
     * must be dot-based, e.g. "1.2", "3.14159" etc.
     * @param file the java.io.File object.
     * @param regex dividing rule for String content of the file.
     * @return one-dimensional vector of double values.
     * @throws NumberFormatException when Double.parseDouble(String string) throws NumberFormatException.
     */
    public static Double[] asDoubleValues(File file, String regex) throws NumberFormatException {
        String content = asSingleString(file);
        String[] divided = content.split(regex);
        Double[] vector = new Double[divided.length];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = Double.parseDouble(divided[i]);
        }
        return vector;
    }
}
