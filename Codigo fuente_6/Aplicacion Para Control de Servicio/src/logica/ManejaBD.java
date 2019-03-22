/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author davi1
 */
public class ManejaBD {
    String driver, url, login, password;
    Connection conexion = null;

    public ManejaBD() {
        driver = "com.mysql.jdbc.Driver";
        url = new String("jdbc:mysql://localhost/cbi_bd");
        login = new String("root");
        password = new String("");
        
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(url, login, password);

        } catch (Exception exc) {
            System.err.println("Error al tratar de abrir la Base de Datos");
        }
    }
    
    public boolean insertaAgregaBD (String sql){                
        try{
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Registro agregado!");
                    
            // Cerramos la interfaz Statement
            stmt.close();
                    
        } catch (java.sql.SQLException er) {
            System.out.println(er.getSQLState());
            System.out.println(er.getErrorCode());
            System.out.println(er.getMessage());
            return false;
        }
        return true;
    }
    
    public ArrayList<Congregante> listaCongregantes (String sql){
        ResultSet rs = null;
        ArrayList<Congregante> aLC = new ArrayList<Congregante> ();
        try{
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
               Congregante nuevo = new Congregante ();
               nuevo.setNombres(rs.getString(1));
               nuevo.setApellidos(rs.getString(2));
               nuevo.setDireccion(rs.getString(3));
               nuevo.setCorreo(rs.getString(4));
               nuevo.setNumIdentificacion(rs.getLong(5));
               nuevo.setOcupacion(rs.getString(6));
               nuevo.setTelefono(rs.getLong(7));
               nuevo.setCelular(rs.getLong(8));
               nuevo.setMotivoOracion(rs.getString(9));
               Date f = new Date ();
               f.setDate(rs.getDate(10).getDate());
               f.setMonth(rs.getDate(10).getMonth());
               f.setYear(rs.getDate(10).getYear());
               nuevo.setFechaNacimiento(f);
               nuevo.setFechaIngreso(rs.getDate(11));
               aLC.add(nuevo);
            }
            //System.out.println("Registro agregado!");
                    
            // Cerramos la interfaz Statement
            stmt.close(); 
            rs.close();
        } catch (java.sql.SQLException er) {
            System.out.println(er.getSQLState());
            System.out.println(er.getErrorCode());
            System.out.println(er.getMessage());
        }
        return aLC;
    }
    
    public ArrayList<Asistencia> listaAsistencia (String sql){
        ResultSet rs = null;
        ArrayList<Asistencia> aLA = new ArrayList<Asistencia> ();
        
        try{
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()){
                Asistencia nueva = new Asistencia();
                Date f = new Date ();
                f.setDate(rs.getDate(1).getDate());
                f.setMonth(rs.getDate(1).getMonth());
                f.setYear(rs.getDate(1).getYear());
                nueva.setFecha(f);
                nueva.setAsistentes(listaAsistentes(rs.getDate(1)));
                aLA.add(nueva);
            }                

            stmt.close(); 
            rs.close();
        }catch (java.sql.SQLException er) {
            System.out.println(er.getSQLState());
            System.out.println(er.getErrorCode());
            System.out.println(er.getMessage());
        }
        return aLA;
    }
    
    private Vector<Long> listaAsistentes (java.sql.Date f){
        ResultSet rs = null;
        String sql = "SELECT identificacion FROM asistencia WHERE fecha='"+f+"'";
        Vector<Long> vect = new Vector<Long>();
        try{
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                vect.add(rs.getLong(1));
            }
            stmt.close(); 
            rs.close();
        } catch (java.sql.SQLException er) {
            System.out.println(er.getSQLState());
            System.out.println(er.getErrorCode());
            System.out.println(er.getMessage());
        }
        return vect;
    }
    
    public ArrayList<Ministerio> listaMinisterios (String sql){
        ResultSet rs = null;
        ArrayList<Ministerio> aLM = new ArrayList<Ministerio>();
        try{
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Ministerio min = new Ministerio();
                min.setNombre(rs.getString(1));
                min.setCodigo(rs.getInt(2));
                min.setLider(rs.getLong(4));
                min.setDescripcion(rs.getString(3));
                String sql2 = "SELECT codMiembro FROM miembros_ministerio WHERE codMinisterio='"+min.getCodigo()+"'";
                min.setMiembros(miembros(sql2));
                min.setActividades(actividadesMinisterio(min.getCodigo()));
                aLM.add(min);
            }
            
            stmt.close(); 
            rs.close();
        }catch (java.sql.SQLException er) {
            System.out.println(er.getSQLState());
            System.out.println(er.getErrorCode());
            System.out.println(er.getMessage());
        }
        return aLM;
    }
    
    private Vector<Long> miembros (String sql){
        ResultSet rs = null;
        Vector<Long> mM = new Vector<Long>();
        try{
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                mM.add(rs.getLong(1));
            }
            stmt.close(); 
            rs.close();
        } catch (java.sql.SQLException er) {
            System.out.println(er.getSQLState());
            System.out.println(er.getErrorCode());
            System.out.println(er.getMessage());
        }
        return mM;
    }
    
    private ArrayList<ActividadMinisterio> actividadesMinisterio (int codM){
        String sql = "SELECT * FROM act_ministerio WHERE codMinisterio='"+codM+"'";
        ResultSet rs = null;
        ArrayList<ActividadMinisterio> aLAM = new ArrayList<ActividadMinisterio>();
        try{
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                ActividadMinisterio am = new ActividadMinisterio ();
                am.setNombre(rs.getString(1));
                am.setCodActividad(rs.getInt(2));
                am.setCodMinisterio(rs.getInt(3));
                Date f = new Date ();
                f.setDate(rs.getDate(4).getDate());
                f.setMonth(rs.getDate(4).getMonth());
                f.setYear(rs.getDate(4).getYear());
                am.setFecha(f);
                am.setDescripcion(rs.getString(5));
                aLAM.add(am);
            }
            stmt.close(); 
            rs.close();
        } catch (java.sql.SQLException er) {
            System.out.println(er.getSQLState());
            System.out.println(er.getErrorCode());
            System.out.println(er.getMessage());
        }
        return aLAM;
    }
    
    public ArrayList<Discipulado> listaDiscipulados (String sql){
        ResultSet rs = null;
        ArrayList<Discipulado> aLD = new ArrayList<Discipulado>();
        try{
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Discipulado dis = new Discipulado();
                dis.setIdDiscipulado(rs.getInt(1));
                dis.setInstructor(rs.getLong(2));
                dis.setNombre(rs.getString(3));
                dis.setEstudiantesMatriculados(listaNotas (dis.getIdDiscipulado()));
                aLD.add(dis);
            }
            
            stmt.close(); 
            rs.close();
        }catch (java.sql.SQLException er) {
            System.out.println(er.getSQLState());
            System.out.println(er.getErrorCode());
            System.out.println(er.getMessage());
        }
        return aLD;
    }
    
    private ArrayList<NotaDiscipulado> listaNotas (int id){
        String sql = "SELECT * FROM nota_discipulado WHERE codDiscipulado='"+id+"'";
        ResultSet rs = null;
        ArrayList<NotaDiscipulado> aLND = new ArrayList<NotaDiscipulado>();
        try{
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                NotaDiscipulado nd = new NotaDiscipulado ();
                nd.setIdEstudiante(rs.getLong(1));
                nd.setCodDiscipulado(rs.getInt(2));
                nd.setCorte1(rs.getFloat(3));
                nd.setCorte2(rs.getFloat(4));
                nd.setCorte3(rs.getFloat(5));
                aLND.add(nd);
            }
            stmt.close(); 
            rs.close();
        } catch (java.sql.SQLException er) {
            System.out.println(er.getSQLState());
            System.out.println(er.getErrorCode());
            System.out.println(er.getMessage());
        }
        return aLND;
    }
    
    public boolean verClave(String sql){
        ResultSet rs = null;
        boolean retorno = false;
        try{
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            retorno = rs.next();
            stmt.close(); 
            rs.close();
        } catch (java.sql.SQLException er) {
            System.out.println(er.getSQLState());
            System.out.println(er.getErrorCode());
            System.out.println(er.getMessage());
        }
        return retorno;
    }
}
