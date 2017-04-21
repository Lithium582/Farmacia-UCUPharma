/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciaucupharma;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import Clases.*;
import Interfaces.*;

/**
 *
 * @author Lithium582
 */
public class FarmaciaUCUPharma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            // TODO code application logic here
        
            Integer op = -1;
            Date fecha;
            Boolean b = false;

            while(op != 0){
                //Hay que crear un objeto de estos para poder leer de la consola :O
                //C# era más simple :│
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                if (b){
                    br.readLine();
                }
                else{
                    b = !b;
                }

                System.out.println("\n1 - Stock \n2 - Ventas \n0 - SALIR \n");

                System.out.print("Ingrese una opción \n");

                //En vez de usar la consola derecho, se recupera así el valor que ingresa el usuario


                    op = Integer.parseInt(br.readLine());

                switch(op){
                    case 1:{
                        System.out.println("Stock en construcción :D");
                        break;
                    }
                    case 2:{
                        System.out.println("Regresa pronto para poder realizar una venta :D");
                        break;
                    }
                    case 0:{
                        System.out.println("Bai");
                        break;
                    }
                    default:{
                        System.out.println("Pusiste una opción incorrecta :D");
                        break;
                    }
                }
            }
        }
            catch(NumberFormatException ex){
                System.out.println("Ingresaste una letra :/");
            }
            catch(IOException ex){
                System.out.println("Ha habido un error al crear el objeto Buffered");
            }
            catch(Exception ex){
                System.out.println("Ha habido un error general");
            }
    }
}
