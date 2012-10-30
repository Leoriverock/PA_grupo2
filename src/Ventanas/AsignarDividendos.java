
package Ventanas;

import Clases.ManejadorBD;
import Clases.Partido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class AsignarDividendos extends javax.swing.JDialog {
    String partidos;
    ManejadorBD mbd = ManejadorBD.getInstancia();
    List <Integer> Idselect = new ArrayList<>();
    int ids;
    public AsignarDividendos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Object Id, local, visita;
        try{
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            ResultSet part  = mbd.dividendos();
            
            while (part.next()) {
                Id = part.getObject("ID_Partido");
                local = part.getObject("E.nombre");
                visita = part.getObject("E1.nombre");
                String concat =Id+" - "+ local+" vs "+visita;
                Idselect.add((Integer)part.getObject(2));
                modeloCombo.addElement(concat);
            }  ComboPartidos.setModel(modeloCombo);
        } catch (SQLException ex) {
            System.out.println("Error"+ex.toString());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        LPartido = new javax.swing.JLabel();
        ComboPartidos = new javax.swing.JComboBox();
        LID = new javax.swing.JLabel();
        ShowID = new javax.swing.JLabel();
        LLocal = new javax.swing.JLabel();
        EquipoLocal = new javax.swing.JLabel();
        LVisitante = new javax.swing.JLabel();
        EquipoVisita = new javax.swing.JLabel();
        Local = new javax.swing.JTextField();
        Visitante = new javax.swing.JTextField();
        Lempate = new javax.swing.JLabel();
        Empate = new javax.swing.JTextField();
        Confirmar = new javax.swing.JButton();
        res_exa = new javax.swing.JLabel();
        Res_ex = new javax.swing.JTextField();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignar Dividendos");

        LPartido.setText("Partido: ");

        ComboPartidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPartidosActionPerformed(evt);
            }
        });

        LID.setText("Partido ID: ");

        LLocal.setText("Local:");

        LVisitante.setText("Visitante: ");

        Lempate.setText("Empate:");

        Confirmar.setText("Confirmar");
        Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarActionPerformed(evt);
            }
        });

        res_exa.setText("Resultado exacto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(res_exa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Res_ex, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Confirmar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LID)
                            .addComponent(LLocal)
                            .addComponent(LVisitante)
                            .addComponent(Lempate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Empate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EquipoLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EquipoVisita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Local, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Visitante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ShowID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LPartido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(ComboPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LPartido)
                    .addComponent(ComboPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LID)
                    .addComponent(ShowID, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EquipoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LLocal)
                        .addComponent(Local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EquipoVisita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LVisitante)
                        .addComponent(Visitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lempate)
                    .addComponent(Empate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(res_exa)
                    .addComponent(Res_ex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(Confirmar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboPartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPartidosActionPerformed
        try {
            int Lugar = ComboPartidos.getSelectedIndex();
            Integer id = Idselect.get(Lugar);
            ids = id;
            ResultSet resultado = mbd.selectPartidos(id);
            resultado.next();
            ShowID.setText(resultado.getString(2));
            EquipoLocal.setText(resultado.getString(13));
            EquipoVisita.setText(resultado.getString(15));
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }
        
    }//GEN-LAST:event_ComboPartidosActionPerformed

    private void ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarActionPerformed
        
              
        if(ShowID.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe Seleccionar un partido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(Local.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un valor en el Campo Local", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(!Local.getText().equals("")){
        try{
                double num =Double.parseDouble(Local.getText());
            }catch(NumberFormatException e1){
                Local.setText("");
                JOptionPane.showMessageDialog(this, "Caracter no valido en campo Local", "Error", JOptionPane.ERROR_MESSAGE);    
            }
        
        }
        if(Visitante.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe ingresar un valor en el Campo Visitante", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        /*if(Empate.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe ingresar un valor en el Campo Visitante", "Error", JOptionPane.ERROR_MESSAGE);
            
        }*/
        
        else{
            double l = Double.parseDouble(Local.getText()), v = Double.parseDouble(Visitante.getText()), e = Double.parseDouble(Empate.getText()), rex = Double.parseDouble(Res_ex.getText());
            int id = ids;
            System.out.println(ids);
            mbd.asignarDividendo(id,l,v,e,rex);
            JOptionPane.showMessageDialog(this,"Se ha realizado la operacion exito", "",JOptionPane.INFORMATION_MESSAGE);
            LLocal.setText("");
            LVisitante.setText("");
            ShowID.setText("");
            Local.setText("");
            Visitante.setText("");
            Empate.setText("");
            Res_ex.setText("");
            this.dispose();
        }
    }//GEN-LAST:event_ConfirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboPartidos;
    private javax.swing.JButton Confirmar;
    private javax.swing.JTextField Empate;
    private javax.swing.JLabel EquipoLocal;
    private javax.swing.JLabel EquipoVisita;
    private javax.swing.JLabel LID;
    private javax.swing.JLabel LLocal;
    private javax.swing.JLabel LPartido;
    private javax.swing.JLabel LVisitante;
    private javax.swing.JLabel Lempate;
    private javax.swing.JTextField Local;
    private javax.swing.JTextField Res_ex;
    private javax.swing.JLabel ShowID;
    private javax.swing.JTextField Visitante;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel res_exa;
    // End of variables declaration//GEN-END:variables
}
