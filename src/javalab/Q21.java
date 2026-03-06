import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Q21 {
    public static void main(String[] args) {
        String text = "Java is Object oriented programming";
        int vowelCount = 0;

        try {
            // Writing to file using FileOutputStream
            FileOutputStream fos = new FileOutputStream("data.txt");
            byte[] bytes = text.getBytes();
            fos.write(bytes);
            fos.close();

            // Reading from file using FileInputStream
            FileInputStream fis = new FileInputStream("data.txt");
            int ch;

            while ((ch = fis.read()) != -1) {
                char c = (char) ch;

                // Check if character is a vowel
                if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||
                    c=='A'||c=='E'||c=='I'||c=='O'||c=='U') {
                    vowelCount++;
                }
            }

            fis.close();

            System.out.println("Total number of vowels in the file: " + vowelCount);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}