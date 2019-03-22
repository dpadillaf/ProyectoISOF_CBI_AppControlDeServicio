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
 * @author david
 */
public class Asistencia {
    private Vector<Long> asistentes;
    private Date fecha;

    public Asistencia() {
    }

    public Vector<Long> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(Vector<Long> asistentes) {
        this.asistentes = asistentes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public boolean agregaAsistencia(long id, Date fecha){
        String dia = Integer.toString(fecha.getDate());
        String mes = Integer.toString(fecha.getMonth()+1);
        String anio = Integer.toString(1900+fecha.getYear());
        String cad = anio+"-"+mes+"-"+dia;
        String sql = "INSERT INTO asistencia (fecha, identificacion) VALUES ('"+cad+"','"+id+"');";
        ManejaBD mbd = new ManejaBD ();
        return mbd.insertaAgregaBD(sql);
    }
}
