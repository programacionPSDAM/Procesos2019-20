import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ping {
    public static void main(String[] args) {
        String[] comando = {"ping", "-c3", "www.google.es"};
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(comando);
            process.waitFor();
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null)
                System.out.println(linea);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
