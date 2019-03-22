/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author davi1
 */
public class ActividadMinisterio {
    private String nombre;
    private int codMinisterio;
    private int codActividad;
    private Date fecha;
    private String descripcion;

    public ActividadMinisterio() {
    }

    public int getCodMinisterio() {
        return codMinisterio;
    }

    public void setCodMinisterio(int codMinisterio) {
        this.codMinisterio = codMinisterio;
    }

    public int getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(int codActividad) {
        this.codActividad = codActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public boolean agregarActividad (ActividadMinisterio aa){
        String dia = Integer.toString(aa.fecha.getDate());
        String mes = Integer.toString(aa.fecha.getMonth()+1);
        String anio = Integer.toString(1900+aa.fecha.getYear());
        String cad = anio+"-"+mes+"-"+dia;
        
        String sql = "INSERT INTO act_ministerio (nomActividad, codMinisterio, fecha, Descripcion)"
                + " VALUES ('"+aa.nombre+"','"+aa.codMinisterio+"','"+cad+"','"+aa.descripcion+"')";
        
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    }
    
    public boolean eliminarActividad (int cA, int cM){
        String sql = "DELETE FROM act_ministerio "
                + "WHERE codMinisterio='"+cM+"' AND codActividad='"+cA+"';";
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    }
}
