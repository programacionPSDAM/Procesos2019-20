import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Firefox {
    public static void main(String[] args) {
        List<String> comandos = new ArrayList<>();
        comandos.add("firefox");
        ProcessBuilder processBuilder = new ProcessBuilder(comandos);
        try {
            Process process = processBuilder.start();
            process.waitFor () ;

            System.out.printf("Salida del proceso %d%n", process.exitValue());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
