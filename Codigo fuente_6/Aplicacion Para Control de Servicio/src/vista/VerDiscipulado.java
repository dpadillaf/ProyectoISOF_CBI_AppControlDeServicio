/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import logica.Congregante;
import logica.Discipulado;
import logica.Iglesia;
import logica.NotaDiscipulado;

/**
 *
 * @author davi1
 */
public class VerDiscipulado extends javax.swing.JDialog {
    private ArrayList<Congregante> aLC;
    private Discipulado d;
    private DefaultListModel lista1;
    private Long foco;
    private int posicion;
    /**
     * Creates new form VerDiscipulado
     */
    public VerDiscipulado(java.awt.Frame parent, boolean modal, ArrayList<Congregante> aLC, Discipulado d) {
        super(parent, modal);
        initComponents();
        this.setResizable(false); //Deshabilita la opción de maximizar la ventana.
        this.setLocationRelativeTo(null); //Centra la ventana
        this.aLC = aLC;
        this.d = d;
        lNombre.setText("<html><b>Nombre discipulado: </b>"+d.getNombre()+"</html>");
        lCodigo.setText("<html><b>Código discipulado: </b>"+d.getIdDiscipulado()+"</html>");
        Congregante c = new Congregante ();
        c = c.buscarC(d.getInstructor(), aLC);
        lInstructor.setText("<html><b>Instructor: </b>"+c.getNombres()+" "+c.getApellidos()+"</html>");
        agregaListaEstudiantes ();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnAgregarA = new javax.swing.JButton();
        btnVerNota = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lEstudiantes = new javax.swing.JList<>();
        lNombre = new javax.swing.JLabel();
        lCodigo = new javax.swing.JLabel();
        lInstructor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Discipulado");

        jLabel2.setText("Alumnos");

        btnAgregarA.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnAgregarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnAgregarA.setText("Agregar alumno");
        btnAgregarA.setToolTipText("");
        btnAgregarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAActionPerformed(evt);
            }
        });

        btnVerNota.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnVerNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exchange.png"))); // NOI18N
        btnVerNota.setText("Agregar o ver nota");
        btnVerNota.setToolTipText("");
        btnVerNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerNotaActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/erase.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow_left1.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setToolTipText("");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lEstudiantes);

        lNombre.setText("Nombre discipulado: ");

        lCodigo.setText("Código discipulado: ");

        lInstructor.setText("Instructor: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lInstructor)
                    .addComponent(lCodigo)
                    .addComponent(lNombre)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVerNota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lInstructor)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarA, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerNota, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAActionPerformed
        AgregarEstudiantesDiscipulado aed = new AgregarEstudiantesDiscipulado(null, true, aLC, d);
        aed.setVisible(true);
        Iglesia ig = new Iglesia();
        for (int i=0; i<ig.getListaDiscipulados().size(); i++){
            if (ig.getListaDiscipulados().get(i).getIdDiscipulado() == d.getIdDiscipulado()){
                d = ig.getListaDiscipulados().get(i);
            }
        }
        agregaListaEstudiantes ();
    }//GEN-LAST:event_btnAgregarAActionPerformed

    private void btnVerNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerNotaActionPerformed
        AgregarVerNota avn = new AgregarVerNota(null, true, d.getEstudiantesMatriculados().get(posicion), aLC, d);
        avn.setVisible(true);
        Iglesia ig = new Iglesia();
        for (int i=0; i<ig.getListaDiscipulados().size(); i++){
            if (ig.getListaDiscipulados().get(i).getIdDiscipulado() == d.getIdDiscipulado()){
                d = ig.getListaDiscipulados().get(i);
            }
        }
        agregaListaEstudiantes ();
    }//GEN-LAST:event_btnVerNotaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (d.eliminarEstudiante(d.getIdDiscipulado(), foco)){
                JOptionPane.showMessageDialog(this, "Estudiante eliminado exitosamente!");
                ArrayList<NotaDiscipulado> aLND = d.getEstudiantesMatriculados();
                for (int i=0; i<aLND.size(); i++){
                    if (foco == aLND.get(i).getIdEstudiante()){
                        aLND.remove(i);
                        d.setEstudiantesMatriculados(aLND);
                        agregaListaEstudiantes ();    
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "No se pudo eliminar Estudiante"
                        , "Error", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void lEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEstudiantesMouseClicked
        try{
            posicion = lEstudiantes.locationToIndex(evt.getPoint());
            foco = d.getEstudiantesMatriculados().get(posicion).getIdEstudiante();
            btnEliminar.setEnabled(true);
            btnVerNota.setEnabled(true);
        }catch(Exception e){}
    }//GEN-LAST:event_lEstudiantesMouseClicked

    private void agregaListaEstudiantes (){
        lista1 = new DefaultListModel();
        this.lEstudiantes.setModel(lista1);

            for( int i = 0 ; i < d.getEstudiantesMatriculados().size() ; i++ ){
                Congregante c = new Congregante ();
                c = c.buscarC(d.getEstudiantesMatriculados().get(i).getIdEstudiante(), aLC);
                lista1.addElement("<html><font color='blue' face='Comic Sans MS' size='4'>"+c.getNombres()+" "+c.getApellidos()+"</font><br><b>Identificación: </b>"
                        + ""+c.getNumIdentificacion()+"</html>");
            }
            btnEliminar.setEnabled(false);
            btnVerNota.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarA;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerNota;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lCodigo;
    private javax.swing.JList<String> lEstudiantes;
    private javax.swing.JLabel lInstructor;
    private javax.swing.JLabel lNombre;
    // End of variables declaration//GEN-END:variables
}
