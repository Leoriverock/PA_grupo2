package Ventanas;

import Clases.ManejadorBD;
import Clases.Partido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class AltaCompeticionLiga extends javax.swing.JDialog {

    public AltaCompeticionLiga(java.awt.Frame parent, boolean modal) {
        super(parent,"Alta Competicion Tipo Liga", modal);
        initComponents();
        llenarListaDisponibles();
        
    }

    ManejadorBD mbd = ManejadorBD.getInstancia();
    List <Integer> ids = new ArrayList<>();
    List <Integer> ids_agregados = new ArrayList<>();
    List <String> nom_equipos = new ArrayList<>();
    List <String> nom_equipos_agr = new ArrayList<>();
    List <String> id_equipos_agr = new ArrayList<>();
    DefaultListModel modelo2 = new DefaultListModel();
    int id_posible;
    
    private void llenarListaDisponibles(){
        Statement st = mbd.getStatement();
        ResultSet res;
        Object nombre, id;
        DefaultListModel modelo = new DefaultListModel();
        eq_disponibles.setModel(modelo);
        
        eq_agregados.setModel(modelo2);
        
        try {
             res = st.executeQuery("select ID_Equipos, Nombre from equipos");
             while(res.next()){
                 nombre = res.getObject(2);
                 id = res.getObject(1);
                 modelo.addElement(nombre);
                 nom_equipos.add(nombre.toString());
                 id_equipos_agr.add(id.toString());
                 ids.add((Integer)res.getObject(1));
             }
        } catch (SQLException ex) {
            System.out.println("Error");
        }
        
    }
    
    private void agregarEquipoALiga(){
        int flag=0;
        for (int i=0; i<ids_agregados.size(); i++){
            if (ids_agregados.get(i) == ids.get(eq_disponibles.getSelectedIndex()) ){
                JOptionPane.showMessageDialog(this, "Este equipo ya fue agregado!", "Error", JOptionPane.ERROR_MESSAGE);
            flag=1;
            }
        }
        if (flag==0){
        ids_agregados.add(ids.get(eq_disponibles.getSelectedIndex()));
        modelo2.addElement(nom_equipos.get(eq_disponibles.getSelectedIndex()));
        nom_equipos_agr.add(nom_equipos.get(eq_disponibles.getSelectedIndex()));
        
        }
      }
    
    public List <Integer> getListaEquipos(){
        return ids_agregados;
    }
    
    public List <String> getListaNombreEquipos(){
        return nom_equipos_agr;
    }
    
    public int getPosibleID(){
        return id_posible;
    }
    
    public String getNombreComp(){
        return txtfield_nombre.getText();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        eq_disponibles = new javax.swing.JList();
        txtfield_nombre = new javax.swing.JTextField();
        label_nombre = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        eq_agregados = new javax.swing.JList();
        boton_agregar = new javax.swing.JButton();
        boton_quitar = new javax.swing.JButton();
        boton_cancelar = new javax.swing.JButton();
        boton_donfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        eq_disponibles.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(eq_disponibles);

        label_nombre.setText("Nombre");

        eq_agregados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(eq_agregados);

        boton_agregar.setText("Agregar  >>");
        boton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEquipo(evt);
            }
        });

        boton_quitar.setText("<<  Quitar   ");
        boton_quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarEquipo(evt);
            }
        });

        boton_cancelar.setText("Cancelar");
        boton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        boton_donfirmar.setText("Confirmar");
        boton_donfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmar(evt);
            }
        });

        jLabel1.setText("Equipos Disponibles:");

        jLabel2.setText("Equipos Agregados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(boton_donfirmar)
                                .addGap(36, 36, 36)
                                .addComponent(boton_cancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boton_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton_quitar))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(label_nombre)
                        .addGap(47, 47, 47)
                        .addComponent(txtfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre)
                    .addComponent(txtfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(boton_agregar)
                        .addGap(18, 18, 18)
                        .addComponent(boton_quitar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_donfirmar)
                    .addComponent(boton_cancelar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitarEquipo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarEquipo
        // TODO add your handling code here:
        
       int sel = eq_agregados.getSelectedIndex();
       System.out.println(sel);      
       ids_agregados.remove(ids.get(sel));
       modelo2.removeElement(nom_equipos.get(sel));
       nom_equipos_agr.remove(nom_equipos.get(sel));
      
    }//GEN-LAST:event_quitarEquipo

    private void confirmar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmar
        
        
        String nombre = txtfield_nombre.getText();
        if (nombre.equals("")){
            javax.swing.JOptionPane.showMessageDialog(this, "El campo nombre no puede estar vacio", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        else{
            Statement st = mbd.getStatement();
            try{
            ResultSet max_id = st.executeQuery("select max(ID_Competicion) from competiciones");
            max_id.next();
            id_posible = max_id.getInt(1)+1;
            
            DividendoLiga dl = new DividendoLiga(null, true, getNombreComp(),getListaNombreEquipos(), getListaEquipos(), getPosibleID());
            dl.setLocation(350, 220);
            dl.setVisible(true); 
            mbd.CrearPenca(id_posible);
            
            for(int i=0;i<ids_agregados.size();i++){
                for(int j=i+1;j<ids_agregados.size();j++)
                {
                    
                    mbd.CrearPartidoLiga(id_posible, Integer.parseInt(id_equipos_agr.get(i)),Integer.parseInt(id_equipos_agr.get(j)));
                    System.out.println("ID: "+id_posible +"Local: "+Integer.parseInt(id_equipos_agr.get(i))+"Visita: "+Integer.parseInt(id_equipos_agr.get(j)));
                    mbd.CrearPartidoLiga(id_posible,Integer.parseInt(id_equipos_agr.get(j)),Integer.parseInt(id_equipos_agr.get(i)));
                    System.out.println("Uno"+i +"Dos" +j);
                }
            }
            dispose();
            } catch (SQLException e){
                System.out.println(e);
            }
        }
        
    }//GEN-LAST:event_confirmar

    private void cancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelar

    private void agregarEquipo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEquipo
        agregarEquipoALiga();
        System.out.println(ids_agregados.size());
        
    }//GEN-LAST:event_agregarEquipo

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_agregar;
    private javax.swing.JButton boton_cancelar;
    private javax.swing.JButton boton_donfirmar;
    private javax.swing.JButton boton_quitar;
    private javax.swing.JList eq_agregados;
    private javax.swing.JList eq_disponibles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JTextField txtfield_nombre;
    // End of variables declaration//GEN-END:variables
}
