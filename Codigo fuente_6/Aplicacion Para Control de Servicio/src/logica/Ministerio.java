/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author davi1
 */
public class Ministerio {
    private String nombre;
    private int codigo;
    private long lider;
    private String descripcion;
    private Vector<Long> miembros;
    private ArrayList<ActividadMinisterio> actividades; 

    public Ministerio() {
    }

    public long getLider() {
        return lider;
    }

    public void setLider(long lider) {
        this.lider = lider;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Vector<Long> getMiembros() {
        return miembros;
    }

    public void setMiembros(Vector<Long> miembros) {
        this.miembros = miembros;
    }

    public ArrayList<ActividadMinisterio> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<ActividadMinisterio> actividades) {
        this.actividades = actividades;
    }
            
    public boolean agregaMinisterio (Ministerio m){
        String sql = "INSERT INTO ministerios (nombre,descripcion,lider) "
                + "VALUES ('"+m.nombre+"','"+m.descripcion+"','"+m.lider+"');";
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    } 
    
    public boolean editarMinisterio (Ministerio m){
        String sql = "UPDATE ministerios SET nombre='"+m.nombre+"', lider='"+m.lider+"', descripcion='"+m.descripcion+"' "
                + "WHERE codigo='"+m.codigo+"';";
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    }
    
    public boolean eliminarMinisterio (Ministerio m){
        String sql = "DELETE FROM ministerios WHERE ministerios.codigo='"+m.codigo+"';";       
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    }
    
    public boolean agregarMiembro (int codM, long codC){
        String sql = "INSERT INTO miembros_ministerio (codMinisterio, codMiembro) "
                + "VALUES ('"+codM+"','"+codC+"');";
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    }
    
    public boolean eliminarMiembro(int codM, long codC ){
        String sql = "DELETE FROM miembros_ministerio "
                + "WHERE codMinisterio='"+codM+"' AND codMiembro='"+codC+"';";
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    }
}
