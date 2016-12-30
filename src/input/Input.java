package input;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Piotr Dzwiniel on 29.12.2016.
 */
public class Input {

    /*
    PRIVATE FIELDS
     */
    private File file;
    private BufferedReader bufferedReader;

    /*
    CONSTRUCTORS
     */
    public Input() {

    }

    public Input(File file) {
        this.file = file;
        try {
            this.bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
    FILE METHODS
     */
    public String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    public String getFileExtension() throws NullPointerException {
        String fileName = getFileExtension(file);
        return fileName;
    }

    /*
    LOAD DATA METHODS
     */
    public String asSingleString(File file) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        return content;
    }

    public String asSingleString() throws IOException {
        String content = asSingleString(file);
        return content;
    }

    public String[] asStringDividedIntoCharacters(File file) throws IOException {
        String[] content = new String(Files.readAllBytes(Paths.get(file.toURI()))).split("");
        return content;
    }

    public String[] asStringDividedIntoCharacters() throws IOException {
        String[] content = asStringDividedIntoCharacters(file);
        return content;
    }

    public String[] asStringDividedIntoCharacters(File file, String regex) throws IOException {
        String[] content = new String(Files.readAllBytes(Paths.get(file.toURI()))).split(regex);
        return content;
    }

    public String[] asStringDividedIntoCharacters(String regex) throws IOException {
        String[] content = new String(Files.readAllBytes(Paths.get(file.toURI()))).split(regex);
        return content;
    }

    public byte[] asVectorOfIndividualByteDigits(File file) throws IOException, NullPointerException {
        String content = asSingleString(file);
        if (content.matches("[0-9]+")) {
            String[] individualCharacters = content.split("");
            byte[] individualBytes = new byte[individualCharacters.length];
            for (int i = 0; i < individualCharacters.length; i++) {
                individualBytes[i] = Byte.parseByte(individualCharacters[i]);
            }
            return individualBytes;
        } else {
            throw new NullPointerException();
        }
    }

    public byte[] asVectorOfIndividualByteDigits() throws IOException, NullPointerException {
        String content = asSingleString(file);
        if (content.matches("[0-9]+")) {
            String[] individualCharacters = content.split("");
            byte[] individualBytes = new byte[individualCharacters.length];
            for (int i = 0; i < individualCharacters.length; i++) {
                individualBytes[i] = Byte.parseByte(individualCharacters[i]);
            }
            return individualBytes;
        } else {
            throw new NullPointerException();
        }
    }



    /*
    GETTERS AND SETTERS
     */
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
