/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea5;

/**
 *
 * @author ShinichiKD
 */
public class Tarea5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Boolean verboso=false;
        Boolean manual=false;
        int cantnodos=5;
        double densidad=0.5;
        int numrepeticiones=0;
        int inicio=0;
//        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//        }
//        if (args[0].equals("[-v]")) {
//            verboso=true;
//            
//        }else{
//            verboso=false;
//        }
//        if (args[1].equals("[-m]")) {
//            manual=true;
//        }else{
//            manual=false;
//        }
//    
//        cantnodos = Integer.parseInt(args[2]);
//        densidad = Double.parseDouble(args[3]);
//        numrepeticiones = Integer.parseInt(args[4]);
//        inicio = Integer.parseInt(args[5]);
        System.out.println("Verboso: "+verboso);
        System.out.println("manual: "+manual);
        System.out.println("Cantidad de nodos: "+cantnodos);
        System.out.println("densidad: "+densidad);
        System.out.println("numero de repeticiones: "+numrepeticiones);
        System.out.println("Nodo inicio: "+inicio);
        Operaciones operaciones = new Operaciones();
        
        
        
        if(manual==true){
            System.out.println("Pedir nodos del grafo");
            //llamar 
            operaciones.generarNodoManual();
        }else{
            operaciones.generarNodoAutomatico(cantnodos,densidad);
           //generar los nodos, con los aristas y la densidad. 
        }
        if (verboso==true) {
            System.out.println("Imprimir lista ,etc");
            
        } else{
            
        }
    }
    
    
    
}
