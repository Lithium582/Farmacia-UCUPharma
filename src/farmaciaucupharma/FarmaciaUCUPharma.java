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
                
                System.out.println("Bienvenido a UCUPharma\nIngrese una opción para continuar:");
                System.out.println("1 - Cargar Stock desde archivo CSV");
                System.out.println("2 - Crear un nuevo Artículo");
                System.out.println("3 - Listar todos los artículos");
                System.out.println("4 - Búsqueda");
                System.out.println("5 - Eliminar un artículo");
                System.out.println("6 - Realizar una venta");
                System.out.println("7 - Devolución");
                System.out.println("8 - Reportes");
                System.out.print("Ingrese una opción \n");
                
                try{
                    op = Integer.parseInt(br.readLine());
                }
                catch(Exception ex){
                    op = -1;
                    System.out.println("Opción incorrecta");
                }
                
                switch(op){
                    case 1:{
                        System.out.println("Cargando archivo");
                        
                        Boolean bool = farma.cargarArticulos("C:\\farmacia_articles_small.csv");
                        
                        if(bool){
                            System.out.println("El archivo ha sido cargado con éxito");
                        }
                        
                        System.out.println(farma.getArticulos().Print());
                        break;
                    }
                    case 2:{
                        try{
                            System.out.println("Ingrese el ID del artículo");
                            Integer pID = Integer.parseInt(br.readLine().trim());

                            System.out.println("Ingrese el precio del artículo");
                            Double pPrecio = Double.parseDouble(br.readLine().trim());

                            System.out.println("Ingrese el nombre del artículo");
                            String pNombre = br.readLine().trim();

                            System.out.println("Ingrese la descripción del artículo");
                            String pDescripcion = br.readLine().trim();

                            System.out.println("El artículo necesita refrigeración?\n1 para si\n0 para no");
                            String strRefri = br.readLine().trim();
                            boolean pRefrigeracion = (!(strRefri.equals("0")));

                            System.out.println("El artículo necesita receta?\n1 para si\n0 para no");
                            String strReceta = br.readLine().trim();
                            boolean pReceta = (!(strReceta.equals("0")));

                            Date pFechaCreacion = Calendar.getInstance().getTime();
                            Date pFechaActualizacion = Calendar.getInstance().getTime();

                            Articulo objArticulo = new Articulo(pID,pFechaCreacion,pFechaActualizacion,pPrecio,pNombre,pDescripcion,true,pRefrigeracion,pReceta);
                            if (farma.InsertarArticulo(objArticulo)){
                                System.out.println("Artículo ingresado con éxito");
                            }
                        }
                        catch(Exception ex){
                            System.out.println("Opción incorrecta");
                        }
                        
                        break;
                    }
                    case 3:{
                        System.out.println(farma.retornarArticulos("-"));
                        break;
                    }
                    case 4:{
                        try{
                            System.out.println("Ingrese su opción de búsqueda");
                            System.out.println("1 - Buscar por ID de artículo");
                            System.out.println("2 - Buscar por nombre de artículo");
                            System.out.println("3 - Buscar por descripción de artículo");
                            Integer subOP = Integer.parseInt(br.readLine());

                            switch(subOP){
                                case 1:{
                                    System.out.println("Ingrese el ID del producto buscado");
                                    Integer idBusqueda = Integer.parseInt(br.readLine());
                                    
                                    Articulo a = farma.BuscarXID(idBusqueda);
                                    
                                    if (a == null){
                                        System.out.println("Artículo inexistente");
                                    }
                                    else{
                                        System.out.println(a.toString("-"));
                                    }
                                    
                                    break;
                                }
                                case 2:{
                                    System.out.println("Ingrese el nombre del producto buscado");
                                    String nomBusqueda = (br.readLine());
                                    
                                    String a = farma.buscarXNombre(nomBusqueda);
                                    
                                    if (a == null){
                                        System.out.println("Artículo inexistente");
                                    }
                                    else{
                                        System.out.println(a);
                                    }
                                    
                                    break;
                                }
                                case 3:{
                                    System.out.println("Ingrese la descripción del producto buscado");
                                    String descBusqueda = (br.readLine());
                                    
                                    String a = farma.buscarXDescripcion(descBusqueda);
                                    
                                    if (a == null){
                                        System.out.println("Artículo inexistente");
                                    }
                                    else{
                                        System.out.println(a);
                                    }
                                    
                                    break;
                                }
                            }
                        }
                        catch(Exception ex){
                            System.out.println("Opción incorrecta");
                        }
                        break;
                    }
                    case 5:{
                        System.out.println("Ingrese el ID del producto a borrar");
                        Integer idBorrar = Integer.parseInt(br.readLine());
                        
                        Boolean bBorrado = farma.EliminarArticulo(idBorrar);
                        if (bBorrado){
                            System.out.println("Artículo eliminado con éxito");
                        }
                        else{
                            System.out.println("No se ha podido eliminar el artículo");
                        }
                        
                        break;
                    }
                    case 6:{
                        
                        break;
                    }
                    case 7:{
                        
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
            /*catch(IOException ex){
                System.out.println("Ha habido un error al crear el objeto Buffered");
            }*/
            catch(Exception ex){
                System.out.println("Ha habido un error general");
            }
    }
}
