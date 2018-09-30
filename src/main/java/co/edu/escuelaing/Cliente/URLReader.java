package co.edu.escuelaing.Cliente;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Andres Castaneda Lozano
 */
public class URLReader implements Runnable {

    String[] args;
    
    public URLReader(String[] args) {
        this.args = args;
    }
    
    /**
     * Metodo run, corre los hilos de la clase Cliente y calcula
     * los tiempo de ejecucion de cada hilo.
     */

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        URL url;
        try {
            url = new URL(args[0]);
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()))) {
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    System.out.println(inputLine);
                }
            } catch (IOException x) {
                System.err.println(x);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("tiempo de ejecucion : " + startTime);
    }

}
