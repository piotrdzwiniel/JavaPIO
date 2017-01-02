import org.JavaPIO.input.FileInput;
import org.JavaPIO.utility.FileUtility;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Piotr Dzwiniel on 29.12.2016.
 */
public class Demo {
    public static void main(String[] args) {

        // Examples of FileUtility class static methods usage
        File file = new File("DATA_1.txt");
        String extension = FileUtility.getFileExtension(file);

        // Examples of FileInput class static methods usage
        // String asSingleString(File file)
        File fileData_1 = new File("DATA_1.txt");
        String fileContent_1 = FileInput.asSingleString(fileData_1);

        // String[] asIndividualCharacters(File file)
        String[] fileContent_2 = FileInput.asIndividualCharacters(fileData_1);

        // String[] asIndividualCharacters(File file, String regex)
        String[] fileContent_3 = FileInput.asIndividualCharacters(fileData_1, "");

        // ArrayList<String> asArrayListOfIndividualLines(File file)
        ArrayList<String> fileContent_4 = FileInput.asArrayListOfIndividualLines(fileData_1);

        // Byte[] asIndividualDigits(File file)
        File fileData_2 = new File("DATA_2.txt");
        Byte[] fileContent_5 = FileInput.asIndividualDigits(fileData_2);

        // Integer[] asIntegerValues(File file, String regex)
        Integer[] fileContent_6 = FileInput.asIntegerValues(fileData_2, "\\s+");

        // Float[] asFloatValues(File file, String regex)
        File fileData_3 = new File("DATA_3.txt");
        Float[] fileContent_7 = FileInput.asFloatValues(fileData_3, "\\s+");
    }
}
