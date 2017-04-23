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
import java.time.*;
import Clases.*;
import Interfaces.*;
import java.text.*;

/**
 *
 * @author Lithium582
 */

public class FarmaciaUCUPharma {
/*
    DateFormat d = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Calendar cal = Calendar.getInstance();
    System.out.println(d.format(cal.getTime()));
    System.out.println(cal.getTime());
*/
    /**
     * @param args the command line arguments
    **/
    public static void main(String[] args) {
        try{
            Farmacia farma = new Farmacia();
            // TODO code application logic here

            Integer op = -1;
            Boolean b = false;

            while(op != 0){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                if (b){
                    br.readLine();
                }
                else{
                    b = !b;
                }
                
                System.out.println("\n1 - CargarStock \n2 - Ventas \n0 - SALIR \n");

                System.out.print("Ingrese una opción \n");

                op = Integer.parseInt(br.readLine());

                switch(op){
                    case 1:{
                        System.out.println("Cargando archivo");
                        
                        Boolean bool = farma.cargarArticulos("C:\\farmacia_articles_small.csv");
                        
                        if(bool){
                            System.out.println("El archivo ha sido cargado satisfactoriamente");
                        }
                        
                        break;
                    }
                    case 2:{
                        System.out.println("Regresa pronto para poder realizar una venta :D");
                        //date
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
