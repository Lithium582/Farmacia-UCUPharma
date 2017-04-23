/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Interfaces.*;

/**
 *
 * @author Lithium582
 */
public class Venta implements IVenta {
    public static Integer ultimoIDGenerado = 0;
    private Integer id;
    
    public Integer getID(){
        return this.id;
    }
}
