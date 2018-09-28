import java.io.*;
import java.net.*;

/**
 *
 * @author Carlos Andres Castaneda Lozano
 */
public class Cliente {
    public static void main(String[] args) throws Exception {
        URL url = new URL(args[0]);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
