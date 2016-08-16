/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codility;
import java.util.Random;

/**
 *
 * @author Gangster
 */
public class Prueba1 {
  
  static Random aleatorio = new Random();
  
  public static void main(String[] args)
  {
  	// VALORES DEL EJERCICIO
    // A[0] =  1
  	// A[1] =  4
    // A[2] = -1
  	// A[3] =  3
  	// A[4] =  2
    int[] valores = new int[]{1, 4, -1, 3, 2};
    
    int resultado = resolver(valores);
    
    System.out.println("*****************************");
    System.out.println("********EJERCICIO 4**********");
    
    imprimir(valores);
    
    System.out.println("Resultado: " + resultado);
    
    System.out.println("*****************************");
  	
  }
  
  
  public static int resolver(int[] arreglo) 
  { 
    int N = arreglo.length;
    int i = 0;
    int k = 0;

    for(int num=0; num<N; num++)
    {
      k = arreglo[i];
      if(k>=0 && k<N)
      {
        if(arreglo[k]== -1)
        {
          return i;
        }
        i = i+1;
      }
      else 
      {
        return 0;
      }
    }
    return i;
  }
  
  public static void imprimir(int[] arreglo)
  {
    System.out.print("[ ");
    for(int i=0; i<arreglo.length; i++)
    {
      System.out.print(arreglo[i] + " ");
    }
    System.out.println("]");
  
  }
  
}
