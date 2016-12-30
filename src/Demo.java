import org.JavaPIO.utility.FileUtility;

import java.io.File;

/**
 * Created by Piotr Dzwiniel on 29.12.2016.
 */
public class Demo {
    public static void main(String[] args) {
        File file = new File("TEST_DATA.txt");
        System.out.println(FileUtility.getFileExtension(file));
    }
}
