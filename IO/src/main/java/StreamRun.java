import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class StreamRun {

    public static void main(String[] args) throws IOException {
        try ( BufferedReader bufferedReader = new BufferedReader( new FileReader("d:\\Projects\\JavaTech\\IO\\zoo-data.txt"))) {
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
        }

        Set<String> set = new HashSet<>();

        set.add("test");

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        InputStream is;
        InputStreamReader isr;
        BufferedReader br;

        try {
            is = new FileInputStream("d:\\Projects\\JavaTech\\IO\\zoo-data.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            int value = 0;

            while ((value = br.read()) != -1) {
                char c = (char)value;
                System.out.print(c);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("201".substring(4));



    }
}
