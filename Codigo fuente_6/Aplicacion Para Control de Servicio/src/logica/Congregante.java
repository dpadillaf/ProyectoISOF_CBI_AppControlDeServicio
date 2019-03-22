/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author davi1
 */
public class Congregante extends Persona {
    private Date fechaIngreso;
    private String motivoOracion;

    public Congregante() {
        super ();
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getMotivoOracion() {
        return motivoOracion;
    }

    public void setMotivoOracion(String motivoOracion) {
        this.motivoOracion = motivoOracion;
    }

    public boolean registrarCongregante (Congregante c, ArrayList<Congregante> aLC){
        if (buscarC (c.numIdentificacion, aLC) != null){ return false; }
        String dia = Integer.toString(c.fechaNacimiento.getDate());
        String mes = Integer.toString(c.fechaNacimiento.getMonth()+1);
        String anio = Integer.toString(1900+c.fechaNacimiento.getYear());
        String cad = anio+"-"+mes+"-"+dia;
        
        String sql = "INSERT INTO congregantes (nombres,apellidos,direccion,correo,numIdentificacion,"
                + "ocupacion,telefono,celular,motivoOracion,fechaNacimiento) VALUES ('"+c.getNombres()+"',"
                + "'"+c.getApellidos()+"','"+c.getDireccion()+"','"+c.getCorreo()+"','"+c.getNumIdentificacion()+"',"
                + "'"+c.getOcupacion()+"','"+c.getTelefono()+"','"+c.getCelular()+"','"+c.getMotivoOracion()+"',"
                + "'"+cad+"');";
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    }
    
    public boolean editarCongregante (Congregante c){
        String dia = Integer.toString(c.fechaNacimiento.getDate());
        String mes = Integer.toString(c.fechaNacimiento.getMonth()+1);
        String anio = Integer.toString(1900+c.fechaNacimiento.getYear());
        String cad = anio+"-"+mes+"-"+dia;
        
        String sql = "UPDATE congregantes SET nombres='"+c.getNombres()+"',"
                + "apellidos='"+c.getApellidos()+"',direccion='"+c.getDireccion()+"',correo='"+c.getCorreo()+"',numIdentificacion='"+c.getNumIdentificacion()+"',"
                + "ocupacion='"+c.getOcupacion()+"',telefono='"+c.getTelefono()+"',celular='"+c.getCelular()+"',motivoOracion='"+c.getMotivoOracion()+"',"
                + "fechaNacimiento='"+cad+"' WHERE numIdentificacion='"+c.getNumIdentificacion()+"';";
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    } 
    
    public Congregante buscarC (long id, ArrayList<Congregante> aLC){
        for( int i = 0 ; i < aLC.size() ; i++ ){
            if (aLC.get(i).getNumIdentificacion() == id){
                return aLC.get(i);
            }
        }
        return null;
    }
    
}
