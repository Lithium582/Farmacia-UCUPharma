/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Interfaces.*;
import java.util.Date;
import java.text.*;

/**
 *
 * @author Lithium582
 */
public class Farmacia implements IFarmacia {
    private final String nombre;
    private String direccion;
    private String telefono;
    private Lista<IArticulo> listaArticulos;
    private Lista<IVenta> listaVentas;
    
    /**
     * Constructor de Farmacia
     */
    public Farmacia(){
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        this.listaArticulos = null;
        this.listaVentas = null;
    }
    
    /**
     * Constructor de Farmacia
     * @param pNombre Nombre de la Farmacia
     * @param pDireccion Direccion de la Farnacia
     * @param pTelefono Teléfono de la Farnacia
    **/
    public Farmacia(String pNombre, String pDireccion, String pTelefono, Lista<IArticulo> pListaArticulos, Lista<IVenta> pListaVentas){
        this.nombre = pNombre;
        this.direccion = pDireccion;
        this.telefono = pTelefono;
        this.listaArticulos = pListaArticulos;
        this.listaVentas = pListaVentas;
    }

    @Override
    public String getDireccion() {
        return this.direccion;
    }

    @Override
    public void setDireccion(String value) {
        this.direccion = value;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public void setTelefono(String value) {
        this.telefono = value;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Lista<IArticulo> getArticulos() {
        return this.listaArticulos;
    }

    @Override
    public Lista<IVenta> getVentas() {
        return this.listaVentas;
    }

    @Override
    public Boolean cargarArticulos(String rutaArchivo) {
        String[] elementos = ManejadorArchivosGenerico.leerArchivo(rutaArchivo);
        
        for (int i = 1; i < elementos.length; i++){
            String[] linea = elementos[i].split(";");
            
            Integer id = Integer.parseInt(linea[0].trim());
            Date fecha_Creacion = FormatoFecha(linea[1].trim());
            Date fecha_Actualizacion = FormatoFecha(linea[2].trim());
            double precio =  Double.parseDouble((linea[3].trim()));
            String nombre = linea[4];
            String descripcion = linea[5];
            boolean estado = VerificarEstado(linea[6]);
            boolean refrigerado = VerificarBooleano(linea[7]);
            boolean receta = VerificarBooleano(linea[8]);
            IArticulo a = new Articulo(id,fecha_Creacion,fecha_Actualizacion,precio,nombre,descripcion,estado,refrigerado,receta);
            this.InsertarArticulo(a);
        }
        
        return true;
    }

    @Override
    public Boolean guardarArticulos() {
        return false;
    }

    @Override
    public IArticulo BuscarXID(Integer id) {
        return new Articulo();
    }

    @Override
    public IArticulo buscarXDescripcion(String descripcion) {
        return new Articulo();
    }

    @Override
    public Boolean InsertarArticulo(IArticulo pArticulo) {
        return false;
    }

    @Override
    public Boolean EliminarArticulo(Integer pId) {
        return false;
    }

    @Override
    public Boolean GuardarVenta(IVenta pVenta) {
        return false;
    }

    @Override
    public Boolean ReintegroVenta(Integer pIdVenta) {
        return false;
    }

    @Override
    public String retornarArticulos() {
        return "";
    }

    @Override
    public String retornarArticulos(String pSeparador) {
        return "";
    }

    @Override
    public Lista<IVenta> ListadoVenta(Date pFechaComienzo, Date pFechaFin) {
        return new Lista<IVenta>();
    }
    
    /**
     * Metodo auxiliar que, dada una string con formato de fecha, la convierte
     * en un dato de tipo Date.
     * @param aDate Fecha a castear.
     * @return Fecha en formato Date.
    **/
    public Date FormatoFecha (String pFecha){
        try {
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = dt.parse(pFecha);
            return date;
        } catch (ParseException e)
            {
                System.err.println("Error de parsing: " + e.getMessage());
            }
        return null;
    }
    
    /**
     * Metodo auxiliar que dada una string verifica que sea "Activo" o "Inactivo"
     * y le asigna valores booleanos correspondientes,
     * donde activo = true e inactivo = false.
     * @param str String a verificar.
     * @return Valor booleano correspondiente.
     */
    private boolean VerificarEstado (String str){
        try {
            if ("Activo".equals(str) || "activo".equals(str)){
                return true; 
            }
            if ("Inactivo".equals(str) || "inactivo".equals(str)){
                return false;
            }
            else {
                throw new Exception("El valor " + str + " no es valido. Debe ser Activo/Inactivo.");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    /**
     * Metodo auxiliar que verifica si una string es "true" or "false",
     * y le asigna valores booleanos en consecuencia.
     * @param str String a verificar.
     * @return Valor booleano correspondiente.
     */
    private boolean VerificarBooleano(String str){
        try {
            if ("True".equals(str) || "true".equals(str)){
                return true;
            }
            if ("False".equals(str) || "false".equals(str)){
                return false;
            }
            else {
                throw new Exception("El valor " + str + " no es valido. Debe ser true/false.");
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            }
        return false;
    }
}
