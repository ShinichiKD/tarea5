/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ShinichiKD
 */
public class Operaciones {
    
    private ArrayList<Nodo> listaNodos = new ArrayList();
    
    private double matriz[][];
    
    boolean R[];
        
    double sp[];
        
    int from[];
    
    public Operaciones(){
    
    }
    
    
    public void generarNodoAutomatico(int n,double densidad, int nodoInicio,boolean verboso){
        
        for (int i = 0; i < n; i++) {
            
            double xAux = Math.random()*1;
            double yAux = Math.random()*1;

            double x = Math.floor(xAux*1000)/1000;
            double y = Math.floor(yAux*1000)/1000;
            
            Nodo punto  = new Nodo(x,y);
            listaNodos.add(punto);
        }
        
        generarAristas(n, densidad);
        dijkstra(nodoInicio,verboso);
        
        
    }
    
    public void generarNodoManual(int n,double densidad, int nodoInicio){
        
        Scanner entrada = new Scanner(System.in);
        
        for (int i = 0; i < n; i++) {
            System.out.println("Nodo "+i);
            
            System.out.print("Coordenada X:");
            double x = entrada.nextDouble();
            entrada.nextLine();
            
            System.out.print("Coordenada Y:");
            double y = entrada.nextDouble();
            entrada.nextLine();
            
            System.out.println("");
            
            x = Math.floor(x*1000)/1000;
            y = Math.floor(y*1000)/1000;
            
            System.out.println("Nodo "+i);
            System.out.println(x+","+y);
            
            Nodo punto  = new Nodo(x,y);
            listaNodos.add(punto);
        }
    }
    
    public void generarAristas(int n , double densidad){
        
        matriz = new double[n][n];
        
        for (int i = 0; i < n-1; i++) {
            Nodo nodo1 = listaNodos.get(i);
            for (int j = i+1; j < n; j++) {
                Nodo nodo2 = listaNodos.get(j);
                
                double random = Math.random()*1;
                
                if (random < densidad) {
                    
                    double x1 = nodo1.getX();
                    double y1 = nodo1.getY();

                    double x2 = nodo2.getX();
                    double y2 = nodo2.getY();

                    double num1 = Math.pow(x1-x2,2);
                    double num2 = Math.pow(y1-y2,2);

                    double peso = Math.sqrt(num1+num2);
                    peso = Math.floor(peso*1000)/1000;
           
                    matriz[i][j] = peso;
                }
                else{
                    System.out.println("....");
                    matriz[i][j] = 1000000;
                }

            }
            
        }
        
        imprimirMatriz();

        
    }
    
    public void imprimirMatriz(){
        
        for (int i = 0; i < matriz.length; i++) {
            
            for (int j = 0; j < matriz.length; j++) {
                
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public void dijkstra(int nodoInicio,boolean verboso){
        
        if (verboso) {
            imprimirConecxiones();
        }
        
        int n = matriz.length;
        
        R = new boolean[n];
        
        sp = new double[n];
        
        from = new int[n];
        
        //Inicializar arreglos
        for (int i = 0; i < n; i++) {
            R[i] = false;
            sp[i] = 1000000;
            from[i] = -1;
            
        }
        
        if (verboso) {
            //imprimirVerboso(sp, R, from);
        }
        
        
        sp[nodoInicio] = 0;
 
        adjecentes(nodoInicio);
        int contTrue = 0;
        
        while(contTrue < n){
            
            int indiceMinimo = argMinimo(sp,R);
            
            
            
            for (int i = 0; i < 10; i++) {
                
                
                
                
            }
            
            contTrue++;

        }
        
        
        for (int i = 0; i < n; i++) {
            
            if (sp[nodoInicio-1]+matriz[nodoInicio-1][i]< sp[i]) {
                
                
            }
            
        }
    
    }
    
    public int[] adjecentes(int indice){
        System.out.println("acyectens");
        for (int i = 0; i < matriz.length; i++) {
            
            if (matriz[i][indice]!=1000000 && matriz[i][indice]!=0.0) {
                System.out.println(i+" "+indice);
            
                System.out.println(matriz[i][indice]);
            }
            
            
            
        }
        return null;
        
    
    }
    
    public int argMinimo(double sp[], boolean R[]){
        
        double minimo = 1000000;
        
        int indice = 0;
        
        for (int i = 0; i < sp.length; i++) {
            if (sp[i]<minimo && R[i]==false) {
                minimo = sp[i];
                indice = i;
            }
            
        }
        sp[indice] = minimo;
        R[indice] = true;
        
        return indice;
    }
    
    
    public void imprimirVerboso(double sp[], boolean R[], int from[]){
            
        int n = sp.length;
        
        System.out.print("sp: ");
        for (int i = 0; i < n; i++) {
            System.out.print(sp[i]+" ");
  
        }
        System.out.println("");
        
        System.out.print("from: ");
        for (int i = 0; i < n; i++) {
            System.out.print(from[i]+" ");
            
        }
        System.out.println("");
    }
    
    
    public void imprimirConecxiones(){
    
        System.out.println("GRAFO");
        for (int i = 0; i < matriz.length-1; i++) {
            
            
            for (int j = i+1; j < matriz.length; j++) {
                
                if (matriz[i][j]!=1000000) {
                    Nodo nodo1 = listaNodos.get(i);
                    Nodo nodo2 = listaNodos.get(j);
                    
                    System.out.print(nodo1.getX()+" "+nodo1.getY()+" ");
                    System.out.print(nodo2.getX()+" "+nodo2.getY()+" ");
                    System.out.println(matriz[i][j]);
                    
                }
                
            }
        }
        
    }
}
