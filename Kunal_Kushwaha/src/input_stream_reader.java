import java.io.IOException;
import java.io.InputStreamReader;

public class input_stream_reader {

    public static void main(String[] args) {

        try (InputStreamReader isr = new InputStreamReader(System.in)) {

            System.out.println("Enter some letters: ");

            int letters;

            while ((letters = isr.read()) != -1) {
                System.out.print((char) letters);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
