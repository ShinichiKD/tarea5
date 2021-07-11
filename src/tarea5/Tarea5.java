/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea5;

/**
 *
 * @author Rodrigo - Pablo
 */
public class Tarea5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Boolean verboso;
        Boolean manual;
        int cantnodos;
        double densidad;
        int numrepeticiones;
        int nodoInicio;

        if (args[0].equals("[-v]")) {
            verboso=true;
            
        }else{
            verboso=false;
        }
        
        if (args[1].equals("[-m]")) {
            manual=true;
        }else{
            manual=false;
        }
        
        cantnodos = Integer.parseInt(args[2]);
        densidad = Double.parseDouble(args[3]);
        numrepeticiones = Integer.parseInt(args[4]);
        nodoInicio = Integer.parseInt(args[5]);

        if(manual==true){
            System.out.println("Numero de Nodos a ingresar: "+cantnodos );
            for (int i = 0; i < numrepeticiones; i++) {
                System.out.println("----Repeticion "+(i+1)+" ----");                
                Operaciones operaciones = new Operaciones();
                operaciones.generarNodoManual(cantnodos, densidad, nodoInicio,verboso);
                
                long inicio = System.nanoTime();
                
                operaciones.dijkstra(nodoInicio, verboso);
                
                long fin = System.nanoTime();
                
                double tiempo = (double) (fin-inicio) *1.0e-9;
                
                System.out.println("El Dijtstra se demoró: "+tiempo+" s");
                
            }
            
            
        }else{
            
            for (int i = 0; i < numrepeticiones; i++) {
                System.out.println("----Repeticion "+(i+1)+" ----");
                Operaciones operaciones = new Operaciones();
                operaciones.generarNodoAutomatico(cantnodos,densidad,nodoInicio,verboso);
                
                long inicio = System.nanoTime();
                
                operaciones.dijkstra(nodoInicio, verboso);
                
                long fin = System.nanoTime();
                
                double tiempo = (double) (fin-inicio)*1.0e-9;
                
                System.out.println("El Dijtstra se demoró: "+tiempo+" s");
            }
 
        }
        
    }
    
    
    
}
