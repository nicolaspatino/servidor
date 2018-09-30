package co.edu.escuelaing.Cliente;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Carlos Andres Castaneda Lozano
 */
public class Cliente {

    public static void main(String[] args) throws IOException {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        while (true) {
            executor.execute(new URLReader(args));

        }
    }

}
