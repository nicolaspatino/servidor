/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.concurrenthttprequests;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Carlos Andres Castaneda Lozano
 * 
 * Clase Main crea un servidor web capaz de responder peticiones
 * html y .png
 */
public class Main {
    /**
     *Metodo main, metodo principal de la clase HttpServer.
     * Crea un servidor y un cliente Socket, y asigna un puerto
     * para el servidor web.
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Integer port;
        try { 
            port = new Integer(System.getenv("PORT"));
        } catch (Exception e) {
            port = 35000;
        }
        
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        

        Socket clientSocket = null;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        while (true){
            executor.execute(new ServerThread(serverSocket.accept()));           
        }
    }   
}
