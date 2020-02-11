import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Tuberia {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process processLS = runtime.exec("ls", new String[] {}, new File("/home/manuel"));
        Process processGREP = runtime.exec("grep tar.gz"); //mostramos fichero comprimidos tar.gz
        InputStream in = processLS.getInputStream();
        OutputStream out = processGREP.getOutputStream();
        int c;
        while ((c = in.read()) != -1)
            out.write(c);
        processLS.waitFor();
        in.close();
        out.close();

        in = processGREP.getInputStream();
        while ((c = in.read()) != -1)
            System.out.print((char) c);
        processGREP.waitFor();
        in.close();

    }
}
