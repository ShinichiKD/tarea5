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
    
    public Operaciones(){
    
    }
    
    
    public void generarNodoAutomatico(int n,double densidad){
        
        for (int i = 0; i < n; i++) {
            
            double xAux = Math.random()*1;
            double yAux = Math.random()*1;

            double x = Math.floor(xAux*1000)/1000;
            double y = Math.floor(yAux*1000)/1000;
            
//            System.out.println("Nodo "+i);
//            System.out.println(x+","+y);
            
            Nodo punto  = new Nodo(x,y);
            listaNodos.add(punto);
        }
        
        generarAristas(n, densidad);
        
    }
    
    public void generarNodoManual(){
        
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese cantidad de Nodos: ");
        int n = entrada.nextInt();
        
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
    
}
