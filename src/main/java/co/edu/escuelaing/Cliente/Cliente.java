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
    
    /**
     * 
     * @param args
     * @throws IOException 
     */

    public static void main(String[] args) throws IOException {
        
        ExecutorService executor = Executors.newFixedThreadPool(5);
        int res = 0;
        while (res<5){
            executor.execute(new URLReader(args));
            res+=1;
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
       
    }

}
