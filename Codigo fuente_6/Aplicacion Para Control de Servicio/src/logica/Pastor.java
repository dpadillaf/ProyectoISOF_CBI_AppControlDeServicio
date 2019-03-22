/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author davi1
 */
public class Pastor extends Persona {
    private String clave;

    public Pastor() {
        super ();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }   
    
    public boolean verificaPass (String pass_L){
        String sql = "SELECT * FROM pastor WHERE clave = MD5('"+pass_L+"')";
        ManejaBD add = new ManejaBD ();
        return add.verClave(sql); 
    }
}
