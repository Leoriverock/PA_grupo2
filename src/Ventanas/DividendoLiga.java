
package Ventanas;

import Clases.ManejadorBD;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class DividendoLiga extends javax.swing.JDialog {
    public DividendoLiga(java.awt.Frame parent, boolean modal, String nom_liga ,List <String> nom_eq, List <Integer> ids_agr, int posib_id_c) {
        super(parent,"Dividendos Campeon", modal);
        nom_equipos = nom_eq;
        ids_agregados = ids_agr;
        posible_id_c = posib_id_c;
        nom_comp = nom_liga;
        initComponents();
        llenarListaDisponibles();
        for (int i=1; i<=nom_equipos.size(); i++){
            dividendos.add(1.0);
        }
    }
    
    List <String> nom_equipos = new ArrayList<>();; 
    List <Integer> ids_agregados = new ArrayList<>();; 
    List <Double> dividendos = new ArrayList<>();;
    int posible_id_c;
    String nom_comp;
    ManejadorBD mbd = ManejadorBD.getInstancia();
    Statement st = mbd.getStatement();
    DefaultListModel modelo = new DefaultListModel();
    
    private void llenarListaDisponibles(){
        
        equipos.setModel(modelo);
        try{
            for (int i=0; i<nom_equipos.size(); i++){
                modelo.addElement(nom_equipos.get(i));
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    private void asignarDividendo(){        
        try{
        Double aux = Double.parseDouble(texto_dividendo.getText());
        if (texto_dividendo.getText() != "1.00" && aux > 1){
            Object nombre_seleccionado = equipos.getSelectedValue();
            int posicion = nom_equipos.indexOf(nombre_seleccionado);
            
            dividendos.add(posicion, aux);
            modelo.removeElementAt(equipos.getSelectedIndex());
            //equipos.remove(equipos.getSelectedIndex());
            if (modelo.getSize() == 0){
                try{
                mbd.insertCompeticion(nom_comp, "Liga");
                ResultSet resx = st.executeQuery("select max(ID_Competicion) from competiciones");
                int id_cmp=0;
                while (resx.next()){
                    id_cmp = Integer.parseInt(resx.getObject(1).toString());
                }
                mbd.insertEquiposALiga(id_cmp, ids_agregados, dividendos);
                DividendoGoleador g = new DividendoGoleador(null,true,posible_id_c);
                g.setVisible(true);
                g.setLocation(200, 200);
                
                JOptionPane.showMessageDialog(null, "Competicion creada! ID = "+id_cmp+".", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                } catch (Exception e){
                    System.out.println("señal1"+e);
                }
            }
            
           
        } else{
            JOptionPane.showMessageDialog(this, "El dividendo asignado es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "El formato del dividendo no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("señan2"+e.toString());
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_equipos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        equipos = new javax.swing.JList();
        boton_asignar_dividendo = new javax.swing.JButton();
        texto_dividendo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        label_equipos.setText("Seleccione equipo");

        jScrollPane1.setViewportView(equipos);

        boton_asignar_dividendo.setText("Asignar Dividendo");
        boton_asignar_dividendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarDividendo(evt);
            }
        });

        texto_dividendo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        texto_dividendo.setText("1.00");

        jLabel1.setText("Dividendo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_equipos)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(boton_asignar_dividendo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(texto_dividendo))))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(label_equipos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(texto_dividendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boton_asignar_dividendo)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void asignarDividendo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarDividendo
        asignarDividendo();
        
    }//GEN-LAST:event_asignarDividendo

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_asignar_dividendo;
    private javax.swing.JList equipos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_equipos;
    private javax.swing.JTextField texto_dividendo;
    // End of variables declaration//GEN-END:variables
}
