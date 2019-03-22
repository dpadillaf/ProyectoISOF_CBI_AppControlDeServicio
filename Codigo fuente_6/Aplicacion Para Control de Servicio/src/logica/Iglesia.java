/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author davi1
 */
public class Iglesia {
    private String nombre;
    private ArrayList<Congregante> listaCongregantes;
    private ArrayList<Asistencia> listaAsistencia;
    private ArrayList<Ministerio> listaMinisterios;
    private ArrayList<Discipulado> listaDiscipulados;

    public Iglesia() {
       nombre = "Centro bíblico internacional: Un oasis de esperanza";
       listaCongregantes = new ArrayList<Congregante>();
       actListaCongregantes();
       listaAsistencia = new ArrayList<Asistencia>();
       actListaAsistencia();
       listaMinisterios = new ArrayList<Ministerio>();
       actListaMinisterios();
       listaDiscipulados = new ArrayList<Discipulado>();
       actListaDiscipulados ();
    }

    public ArrayList<Discipulado> getListaDiscipulados() {
        return listaDiscipulados;
    }

    public void setListaDiscipulados(ArrayList<Discipulado> listaDiscipulados) {
        this.listaDiscipulados = listaDiscipulados;
    }
    
    public ArrayList<Ministerio> getListaMinisterios() {
        return listaMinisterios;
    }

    public void setListaMinisterios(ArrayList<Ministerio> listaMinisterios) {
        this.listaMinisterios = listaMinisterios;
    }

    public ArrayList<Asistencia> getListaAsistencia() {
        return listaAsistencia;
    }

    public void setListaAsistencia(ArrayList<Asistencia> listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Congregante> getListaCongregantes() {
        return listaCongregantes;
    }

    public void setListaCongregantes(ArrayList<Congregante> listaCongregantes) {
        this.listaCongregantes = listaCongregantes;
    }
    
    public void actListaCongregantes (){
        String sql = "SELECT * FROM congregantes";
        ManejaBD add = new ManejaBD ();
        listaCongregantes = add.listaCongregantes(sql);
    }
    
    public void actListaAsistencia (){
        String sql = "SELECT fecha FROM asistencia GROUP BY fecha";
        ManejaBD add = new ManejaBD ();
        listaAsistencia = add.listaAsistencia(sql);
    }
    
    public void actListaMinisterios (){
        String sql = "SELECT * FROM ministerios";
        ManejaBD add = new ManejaBD ();
        listaMinisterios = add.listaMinisterios(sql);
    }
    
    public void actListaDiscipulados (){
        String sql = "SELECT * FROM discipulados";
        ManejaBD add = new ManejaBD ();
        listaDiscipulados = add.listaDiscipulados(sql);
    }
}
