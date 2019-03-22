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
public class NotaDiscipulado {
    private float corte1;
    private float corte2;
    private float corte3;
    private long idEstudiante;
    private int codDiscipulado;

    public NotaDiscipulado() {
    }

    public NotaDiscipulado(int codDiscipulado, long idEstudiante) {
        this.idEstudiante = idEstudiante;
        this.codDiscipulado = codDiscipulado;
    }

    public int getCodDiscipulado() {
        return codDiscipulado;
    }

    public void setCodDiscipulado(int codDiscipulado) {
        this.codDiscipulado = codDiscipulado;
    }

    public float getCorte1() {
        return corte1;
    }

    public void setCorte1(float corte1) {
        this.corte1 = corte1;
    }

    public float getCorte2() {
        return corte2;
    }

    public void setCorte2(float corte2) {
        this.corte2 = corte2;
    }

    public float getCorte3() {
        return corte3;
    }

    public void setCorte3(float corte3) {
        this.corte3 = corte3;
    }

    public long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    
    public boolean agregarNota (NotaDiscipulado nD){
        String sql = "UPDATE nota_discipulado SET corte1='"+nD.corte1+"', corte2='"+nD.corte2+"', corte3='"+nD.corte3+"' "
                + "WHERE codDiscipulado='"+nD.codDiscipulado+"' AND idEstudiante='"+nD.idEstudiante+"';";
        ManejaBD ag = new ManejaBD ();
        return ag.insertaAgregaBD(sql);
    }
}
