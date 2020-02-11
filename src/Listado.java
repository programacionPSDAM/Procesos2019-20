import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Listado {
    public static void main(String[] args) {
        List <String> comando = new ArrayList<>();
        comando.add("ls");
        comando.add("-la");
        ProcessBuilder processBuilder = new ProcessBuilder(comando);
        processBuilder.directory(new File("/home/manuel"));
        Map<String , String> environ = processBuilder.environment () ;
        try {
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //int c;
            //while ((c = inputStream.read()) != -1)
            //    System.out.print((char) c);
            String linea;
            while ((linea = bufferedReader.readLine()) != null)
                System.out.println(linea);
            for (String variable: environ.keySet()) {
                System.out.println(variable + ": " + environ.get(variable));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
