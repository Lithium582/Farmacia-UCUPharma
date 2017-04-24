/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Interfaces.*;
import java.util.Date;

/**
 *
 * @author Lithium582
 */
public class Venta implements IVenta {
    public static Integer ultimoIDGenerado = 0;
    private Integer id;
    private Date Fecha;
    private Integer idArticulo;
    private Integer cantidad;
    private Double valorFinal;
    
    
    public Integer getID(){
        return this.id;
    }
    
    public String toString(String pSeparador) {
        return "";
    }

    @Override
    public Date GetFecha() {
        return this.Fecha;
    }

    @Override
    public Integer GetIdArticulo() {
        return this.idArticulo;
    }

    @Override
    public void SetIdArticulo(Integer value) {
        this.idArticulo = value;
    }

    @Override
    public Integer GetCantidad() {
        return this.cantidad;
    }

    @Override
    public void SetCantidad(Integer value) {
        this.cantidad = value;
    }

    @Override
    public Double GetValorFinal() {
        return this.valorFinal;
    }
}
