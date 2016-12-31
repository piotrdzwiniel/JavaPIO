import org.JavaPIO.input.Input;
import org.JavaPIO.utility.FileUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Piotr Dzwiniel on 29.12.2016.
 */
public class Demo {
    public static void main(String[] args) {
        File file = new File("TEST_DATA.txt");
        Input input = new Input(file);
        Byte[] bytes = new Byte[0];
        try {
            bytes = input.asVectorOfIndividualByteDigits();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (byte b: bytes) {
            System.out.println(b);
        }
    }
}
