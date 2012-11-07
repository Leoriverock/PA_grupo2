
package Ventanas;
import Clases.Copiar;
import Clases.Equipo;
import Clases.ManejadorBD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AltaEquipo extends javax.swing.JDialog {
    
    JFileChooser fileChooser = new JFileChooser();
    public AltaEquipo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    ManejadorBD mbd = ManejadorBD.getInstancia();
    String inicio="", termina="";
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texto_nombre = new javax.swing.JLabel();
        campo_nombre = new javax.swing.JTextField();
        boton_confirmar = new javax.swing.JButton();
        boton_imagen = new javax.swing.JButton();
        texto_nombre1 = new javax.swing.JLabel();
        panel_imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta Equipo");
        setResizable(false);

        texto_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        texto_nombre.setText("Nombre");

        boton_confirmar.setText("Confirmar");
        boton_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmar_alta(evt);
            }
        });

        boton_imagen.setText("Seleccionar Imagen");
        boton_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_imagenActionPerformed(evt);
            }
        });

        texto_nombre1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        texto_nombre1.setText("Imagen");

        panel_imagen.setToolTipText("Inserte su imagen aqui...");
        panel_imagen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_nombre1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(texto_nombre)
                                .addGap(18, 18, 18)
                                .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_imagen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boton_confirmar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {boton_confirmar, boton_imagen});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_nombre)
                    .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(texto_nombre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_imagen)
                        .addGap(63, 63, 63)
                        .addComponent(boton_confirmar))
                    .addComponent(panel_imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmar_alta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmar_alta
        String nombre = campo_nombre.getText();
        if (nombre.equals("")){
            JOptionPane.showMessageDialog(this, "El campo nombre no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            Equipo eq = new Equipo(nombre);
            mbd.insertEquipo(eq);
            int id = eq.getId();
            if(!inicio.equals(""))
            {
            File archivo = new File(fileChooser.getSelectedFile().getPath());
            String nameC = "Imagen("+id+").jpg";
            termina = "////192.168.56.101//Archivos//Equipos//"+nameC;
            File destino = new File(termina);
            Copiar cp = new Copiar();
            try {
                cp.copy(archivo, destino);
            } catch (IOException ex) {
                System.out.println("Error E/S: "+ex);
            }
            mbd.ActualizarFotoEquipo(termina, id);
            mbd.NombreImagen(nameC, id);
            }
            JOptionPane.showMessageDialog(this, "Se creo el equipo con id: "+eq.getId(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_confirmar_alta

    private void boton_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_imagenActionPerformed
        // TODO add your handling code here:
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".JPG, .GIF & .PNG","png", "jpg", "gif");
        fileChooser.setFileFilter(filtro);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            File name= fileChooser.getSelectedFile();
            ImageIcon image = new ImageIcon(fileChooser.getSelectedFile().getPath());
            if(image.getIconHeight() > 400 || image.getIconWidth() > 250){
                ImageIcon imageResize = new ImageIcon(image.getImage().getScaledInstance(90, 100, 100));
                inicio = fileChooser.getSelectedFile().getPath();
                panel_imagen.setIcon(imageResize);
            }
            else{
                panel_imagen.setIcon(image);
            }
        }       
    }//GEN-LAST:event_boton_imagenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_confirmar;
    private javax.swing.JButton boton_imagen;
    private javax.swing.JTextField campo_nombre;
    private javax.swing.JLabel panel_imagen;
    private javax.swing.JLabel texto_nombre;
    private javax.swing.JLabel texto_nombre1;
    // End of variables declaration//GEN-END:variables
}
