package Ventanas;

import Clases.ManejadorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VerCompeticion extends javax.swing.JDialog {
    
    private List ListaCompeticion= new ArrayList();
    private List ListaPartidos= new ArrayList();
    private List ListaGoleadores= new ArrayList();
    public VerCompeticion(java.awt.Frame parent, boolean modal) {
        super(parent,"Ver Competicion", modal);
        initComponents();
        listarCompeticiones();
        
    }

    ManejadorBD mbd = ManejadorBD.getInstancia();
    Statement st = mbd.getStatement();
    List <Integer> ids = new ArrayList<>();
    
    private void listarCompeticiones(){
        ManejadorBD Li= ManejadorBD.getInstancia();
        DefaultTableModel modeloCompeticion=(DefaultTableModel) Competiciones.getModel();
        List ListaComp = new ArrayList();
        ListaComp=Li.ListaCompeticion();
        this.ListaCompeticion=ListaComp;
        int cont=0;
        for(int i=0; i < ListaComp.size(); i++){
            i++;
            modeloCompeticion.addRow(new Object[1]);
            Competiciones.setValueAt(ListaComp.get(i),cont , 0);
            i++;
            i++;
            cont++;
        }
        
        
    
    }
    
   /* private void llenarPartidos(){
        
        ResultSet res2;
        
        DefaultListModel modelo = new DefaultListModel();
        DefaultTableModel modeloPartido=(DefaultTableModel) Partido.getModel();
        
        
        int id=0;
        try {
             String nomb = lista_comp.getSelectedValue().toString();
             res2 = st.executeQuery("select ID_Competicion from competiciones where Nombre='"+nomb+"'");
             while(res2.next()){
                id = (int)res2.getObject(1);
             }
             System.out.println("id="+id);
             ResultSet part = mbd.selectPartidosCompeticion(id);
             
             while(part.next()){
                 String item = part.getObject("E.nombre").toString()+" vs "+part.getObject("E1.nombre").toString();
                 ids.add((Integer)part.getObject("p.id_partido"));
                 modelo.addElement(item);
             }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }*/
    public List DatosPartido(List Lista, int fila)
    {
        List Nueva= new ArrayList();
        Nueva.add(Lista.get(fila*12));
        Nueva.add(Lista.get((fila*12)+1));
        Nueva.add(Lista.get((fila*12)+2));
        Nueva.add(Lista.get((fila*12)+3));
        Nueva.add(Lista.get((fila*12)+4));
        Nueva.add(Lista.get((fila*12)+5));
        Nueva.add(Lista.get((fila*12)+6));
        Nueva.add(Lista.get((fila*12)+7));
        Nueva.add(Lista.get((fila*12)+8));
        Nueva.add(Lista.get((fila*12)+9));
        Nueva.add(Lista.get((fila*12)+10));
        Nueva.add(Lista.get((fila*12)+11));
        return Nueva;
    }
    
      public List DatosGoleador(List Lista, int fila)
    {
        List Nueva= new ArrayList();
        Nueva.add(Lista.get(fila*2));
        Nueva.add(Lista.get((fila*2)+1));
        return Nueva;
    }
    
    
    public boolean Validate()
    {
        if(Competiciones.getSelectedRow()==-1)
        {
        JOptionPane.showMessageDialog(this, "Seleccion una Competicion","Error", JOptionPane.INFORMATION_MESSAGE);
        return false;
        }
        if(Partido.getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(this, "Seleccione un Partido","Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        titulo_competicion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        Tipo = new javax.swing.JLabel();
        Anio = new javax.swing.JLabel();
        nombre_comp = new javax.swing.JLabel();
        tipo_comp = new javax.swing.JLabel();
        anio_comp = new javax.swing.JLabel();
        id_comp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boton_partido = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        Partido = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        Competiciones = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        Goleadores = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titulo_competicion.setText("Elija una competicion:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Detalles:");

        Nombre.setText("Nombre:");

        ID.setText("ID:");

        Tipo.setText("Tipo:");

        Anio.setText("Año:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Partidos:");

        boton_partido.setText("Detalles Partido");
        boton_partido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_partidoActionPerformed(evt);
            }
        });

        Partido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Local", "Visitante", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(Partido);
        Partido.getColumnModel().getColumn(2).setHeaderValue("Fecha");

        Competiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Competiciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Competiciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CompeticionesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(Competiciones);

        Goleadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugador", "Goles"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(Goleadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo_competicion)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jLabel2)
                                .addGap(172, 172, 172)
                                .addComponent(jLabel3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(id_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nombre_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Anio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(anio_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tipo_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_partido)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo_competicion)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nombre)
                            .addComponent(nombre_comp))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tipo)
                            .addComponent(tipo_comp))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Anio)
                            .addComponent(anio_comp))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ID)
                            .addComponent(id_comp)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_partido)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_partidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_partidoActionPerformed
        if(Validate())
        {
        try{
        DetallesPartido dp = new DetallesPartido(null, true, this.DatosPartido(this.ListaPartidos, Partido.getSelectedRow()));
        
        dp.setLocation(250, 180);
        dp.setVisible(true);
        } catch (Exception e){            
           System.out.println(e.toString()); 
           JOptionPane.showMessageDialog(this, "Exploto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_partidoActionPerformed

    private void CompeticionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CompeticionesMouseClicked
        ManejadorBD Li= ManejadorBD.getInstancia();
        ManejadorBD Li1= ManejadorBD.getInstancia();
        DefaultTableModel modeloPartido=(DefaultTableModel) Partido.getModel();
        DefaultTableModel modeloGoleadores=(DefaultTableModel) Goleadores.getModel();
        List ListaPartido = new ArrayList(); 
        List ListaGoleadores = new ArrayList();
        int valor=0;
        int cont=0;
        int cont1=0;
        
        while(modeloPartido.getRowCount()!=0)
        {
            modeloPartido.removeRow(0); 
        }
          while(modeloGoleadores.getRowCount()!=0)
        {
            modeloGoleadores.removeRow(0); 
        }
         
        
        valor=Competiciones.getSelectedRow()*4;
        ID.setText(this.ListaCompeticion.get(valor).toString());
        valor=(Competiciones.getSelectedRow()*4)+1;
        Nombre.setText(this.ListaCompeticion.get(valor).toString());
        valor=(Competiciones.getSelectedRow()*4)+2;
        Anio.setText(this.ListaCompeticion.get(valor).toString());
        valor=(Competiciones.getSelectedRow()*4)+3;
        Tipo.setText(this.ListaCompeticion.get(valor).toString());
        this.ListaPartidos=Li.ObtenerTodoPartidosVerCompeticion(Nombre.getText());
        //this.ListaGoleadores=Li1.ObtenerTodoGoleadoresVerCompeticion(Nombre.getText());
        
        
        for(int i=0; i < (this.ListaPartidos.size())/12; i++){
            
            modeloPartido.addRow(new Object[1]);
            valor=cont * 12;
            Partido.setValueAt(this.ListaPartidos.get(valor),cont , 0);
            Partido.setValueAt(this.ListaPartidos.get(valor+1),cont , 1);
            Partido.setValueAt(this.ListaPartidos.get(valor+2),cont , 2);
            
            cont++;
        }
        
        this.ListaGoleadores=Li1.ObtenerTodoGoleadoresVerCompeticion(Nombre.getText());
          for(int i=0; i < (this.ListaGoleadores.size())/2; i++){
            
            modeloGoleadores.addRow(new Object[1]);
            valor=cont1 * 2;
            Goleadores.setValueAt(this.ListaGoleadores.get(valor),cont1 , 0);
            Goleadores.setValueAt(this.ListaGoleadores.get(valor+1),cont1 , 1);
            
            cont1++;
        }
    
        
    }//GEN-LAST:event_CompeticionesMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Anio;
    private javax.swing.JTable Competiciones;
    private javax.swing.JTable Goleadores;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel Nombre;
    private javax.swing.JTable Partido;
    private javax.swing.JLabel Tipo;
    private javax.swing.JLabel anio_comp;
    private javax.swing.JButton boton_partido;
    private javax.swing.JLabel id_comp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel nombre_comp;
    private javax.swing.JLabel tipo_comp;
    private javax.swing.JLabel titulo_competicion;
    // End of variables declaration//GEN-END:variables
}
