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
public class Discipulado {
    private ArrayList<NotaDiscipulado> estudiantesMatriculados;
    private int idDiscipulado;
    private long instructor;
    private String nombre;

    public Discipulado() {
    }

    public long getInstructor() {
        return instructor;
    }

    public void setInstructor(long instructor) {
        this.instructor = instructor;
    }

    public ArrayList<NotaDiscipulado> getEstudiantesMatriculados() {
        return estudiantesMatriculados;
    }

    public void setEstudiantesMatriculados(ArrayList<NotaDiscipulado> estudiantesMatriculados) {
        this.estudiantesMatriculados = estudiantesMatriculados;
    }

    public int getIdDiscipulado() {
        return idDiscipulado;
    }

    public void setIdDiscipulado(int idDiscipulado) {
        this.idDiscipulado = idDiscipulado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean agregaDiscipulado (Discipulado d){
        String sql = "INSERT INTO discipulados (instructor, nombre) "
                + "VALUES ('"+d.instructor+"','"+d.nombre+"');";
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    }
    
    public boolean editarDiscipulado (Discipulado d){
        String sql = "UPDATE discipulados SET nombre='"+d.nombre+"', instructor='"+d.instructor+"' "
                + "WHERE idDiscipulado='"+d.idDiscipulado+"';";
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    }

    public boolean eliminarDiscipulado (Discipulado d){
        String sql = "DELETE FROM discipulados WHERE discipulados.idDiscipulado='"+d.idDiscipulado+"';";      
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    }
    
    public boolean agregarEstudiante (int idD, long idE){
        String sql = "INSERT INTO nota_discipulado (idEstudiante, codDiscipulado, corte1, corte2, corte3) "
                + "VALUES ('"+idE+"','"+idD+"','0.0','0.0','0.0');";
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    }
    
    public boolean eliminarEstudiante (int cD, long cE){
        String sql = "DELETE FROM nota_discipulado WHERE nota_discipulado.codDiscipulado='"+cD+"' AND "
                + "nota_discipulado.idEstudiante='"+cE+"';";      
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    }
}
