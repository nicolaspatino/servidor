package co.edu.escuelaing.reflexwebserver;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *
 * @author Carlos Andres Castaneda Lozano
 */
public class Reflexwebserver {
    
    /**
     * @param args
     * @throws Exception 
     */
     public static void main(String[] args) throws Exception {
        
        Class c = Class.forName("concurrenthttprequests.Main");
        for (Method m : c.getMethods()) {
            Constructor cons = c.getConstructor();
            if (m.isAnnotationPresent(Mapping.class)) {
                try {
                    Mapping anot = m.getAnnotation(Mapping.class);
                    System.out.println( anot.value());
                    Object o = cons.newInstance();
                    Object a = m.invoke(o);
                    String resp = a.toString();
                    System.out.println("La respuesta es: " + resp);

                } catch (Throwable ex) {
                    System.out.printf("error on %s: %s %n", m, ex.getCause());
                    ;
                }
            }
        }
        System.out.printf("Finished");
    }
}
