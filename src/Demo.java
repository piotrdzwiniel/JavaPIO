import input.Input;

import java.io.File;
import java.io.IOException;

/**
 * Created by Piotr Dzwiniel on 29.12.2016.
 */
public class Demo {
    public static void main(String[] args) {
        Input input = new Input(new File("TEST_DATA.txt"));
        byte[] content = new byte[0];

        try {
            content = input.asVectorOfIndividualByteDigits();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (byte b: content) {
            System.out.println(b);
        }
    }
}
