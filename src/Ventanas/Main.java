package Ventanas;
import Clases.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ventanas.VerDetalleUsuario;

public class Main extends javax.swing.JFrame {
   
    private ManejadorBD mbd = ManejadorBD.getInstancia();
    
    public Main() {
        initComponents();
        ImageIcon image = new ImageIcon("imagenes/logo.png");
        ImageIcon imageResize = new ImageIcon(image.getImage());
        Ibet.setIcon(imageResize);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Ibet = new javax.swing.JLabel();
        barra_menu = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        salir = new javax.swing.JMenuItem();
        menu_equipo = new javax.swing.JMenu();
        crear_equipo = new javax.swing.JMenuItem();
        ver_equipo = new javax.swing.JMenuItem();
        menu_jugador = new javax.swing.JMenu();
        menu_admin_jugadores = new javax.swing.JMenuItem();
        menu_comp = new javax.swing.JMenu();
        nueva_competicion = new javax.swing.JMenu();
        individual = new javax.swing.JMenuItem();
        liga = new javax.swing.JMenuItem();
        ver_informacion = new javax.swing.JMenuItem();
        partido = new javax.swing.JMenu();
        partido_individual = new javax.swing.JMenuItem();
        partido_liga = new javax.swing.JMenuItem();
        finalizar_partido = new javax.swing.JMenuItem();
        dividendos = new javax.swing.JMenuItem();
        menu_usuarios = new javax.swing.JMenu();
        menu_verUsuario = new javax.swing.JMenuItem();
        VerRegi = new javax.swing.JMenuItem();
        menu_fechaYhora = new javax.swing.JMenu();
        cargar_datos_prueba = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        Grafica = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicacion Administrador");
        setBounds(new java.awt.Rectangle(200, 100, 800, 600));
        setName("ventana"); // NOI18N
        setResizable(false);

        menu_archivo.setText("Archivo");

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });
        menu_archivo.add(salir);

        barra_menu.add(menu_archivo);

        menu_equipo.setText("Equipo");

        crear_equipo.setText("Crear Equipo");
        crear_equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearEquipo(evt);
            }
        });
        menu_equipo.add(crear_equipo);

        ver_equipo.setText("Ver  Equipo");
        ver_equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEquipo(evt);
            }
        });
        menu_equipo.add(ver_equipo);

        barra_menu.add(menu_equipo);

        menu_jugador.setText("Jugador");

        menu_admin_jugadores.setText("Administrar Jugadores");
        menu_admin_jugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarJugadores(evt);
            }
        });
        menu_jugador.add(menu_admin_jugadores);

        barra_menu.add(menu_jugador);

        menu_comp.setText("Competicion");

        nueva_competicion.setText("Nueva Competicion");

        individual.setText("Individual");
        individual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaCompIndividual(evt);
            }
        });
        nueva_competicion.add(individual);

        liga.setText("Liga");
        liga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaLiga(evt);
            }
        });
        nueva_competicion.add(liga);

        menu_comp.add(nueva_competicion);

        ver_informacion.setText("Ver Informacion");
        ver_informacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInformacion(evt);
            }
        });
        menu_comp.add(ver_informacion);

        partido.setText("Partido");

        partido_individual.setText("Nuevo Individual");
        partido_individual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partidoIndividual(evt);
            }
        });
        partido.add(partido_individual);

        partido_liga.setText("Nuevo de Liga");
        partido_liga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partidoLiga(evt);
            }
        });
        partido.add(partido_liga);

        finalizar_partido.setText("Finalizar");
        finalizar_partido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarPartido(evt);
            }
        });
        partido.add(finalizar_partido);

        menu_comp.add(partido);

        dividendos.setText("Asignar dividendos");
        dividendos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarDividendos(evt);
            }
        });
        menu_comp.add(dividendos);

        barra_menu.add(menu_comp);

        menu_usuarios.setText("Usuarios");

        menu_verUsuario.setText("Ver Informacion");
        menu_verUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verUsuario(evt);
            }
        });
        menu_usuarios.add(menu_verUsuario);

        VerRegi.setText("Ver Registro");
        VerRegi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerRegiActionPerformed(evt);
            }
        });
        menu_usuarios.add(VerRegi);

        barra_menu.add(menu_usuarios);

        menu_fechaYhora.setText("Opciones");

        cargar_datos_prueba.setText("Cargar datos de prueba");
        cargar_datos_prueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDatosPrueba(evt);
            }
        });
        menu_fechaYhora.add(cargar_datos_prueba);

        jMenuItem1.setText("Ver Fecha y hora");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verFechaYhora(evt);
            }
        });
        menu_fechaYhora.add(jMenuItem1);

        Grafica.setText("Grafica");
        Grafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraficaActionPerformed(evt);
            }
        });
        menu_fechaYhora.add(Grafica);

        barra_menu.add(menu_fechaYhora);

        setJMenuBar(barra_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(Ibet, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(Ibet, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearEquipo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearEquipo
        AltaEquipo Ae = new AltaEquipo(this, true);
        Ae.setLocation(350, 250);
        Ae.setVisible(true);
    }//GEN-LAST:event_crearEquipo

    private void verEquipo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verEquipo
        VerEquipo ve = new VerEquipo(this,true);
        ve.setLocation(300,200);
        ve.setVisible(true);
    }//GEN-LAST:event_verEquipo

    private void salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir
        System.exit(0);       
    }//GEN-LAST:event_salir

    private void partidoLiga(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partidoLiga
        AltaPartidoLiga apl = new AltaPartidoLiga(this, true);
        apl.setLocation(300, 200);
        apl.setVisible(true);
    }//GEN-LAST:event_partidoLiga

    private void partidoIndividual(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partidoIndividual
        AltaPartidoIndividual api = new AltaPartidoIndividual(this, true);
        api.setLocation(250, 180);
        api.setVisible(true);
    }//GEN-LAST:event_partidoIndividual

    private void verInformacion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInformacion
       VerCompeticion api = new VerCompeticion(this, true);
        api.setLocation(250, 180);
        api.setVisible(true);
    }//GEN-LAST:event_verInformacion

    private void nuevaCompIndividual(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaCompIndividual
        AltaCompeticionIndividual aci = new AltaCompeticionIndividual(this, true);
        aci.setLocation(300, 180);
        aci.setVisible(true);
    }//GEN-LAST:event_nuevaCompIndividual

    private void nuevaLiga(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaLiga
        AltaCompeticionLiga acl = new AltaCompeticionLiga(this, true);
        acl.setLocation(300, 180);
        acl.setVisible(true);
    }//GEN-LAST:event_nuevaLiga

    private void asignarDividendos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarDividendos
        AsignarDividendos ad = new AsignarDividendos(this, true);
        ad.setLocation(300, 200);
        ad.setVisible(true);
    }//GEN-LAST:event_asignarDividendos

    private void finalizarPartido(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarPartido
        FinalizarPartido fp = new FinalizarPartido(this, true);
        fp.setLocation(300, 200);
        fp.setVisible(true);
    }//GEN-LAST:event_finalizarPartido

    private void verFechaYhora(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verFechaYhora
        FechaYhora fh = new FechaYhora(this, true);
        fh.setLocation(550, 200);
        fh.obtenerFechaHora();
        fh.setVisible(true);
    }//GEN-LAST:event_verFechaYhora

    private void cargarDatosPrueba(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarDatosPrueba
        mbd.cargarDatosDePrueba();
        JOptionPane.showMessageDialog(this, "Los datos de prueba se cargaron exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_cargarDatosPrueba

    private void administrarJugadores(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarJugadores
        GestionJugadores gj = new GestionJugadores(this,true);
        gj.setLocation(200, 150);
        gj.setVisible(true);
    }//GEN-LAST:event_administrarJugadores

    private void verUsuario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verUsuario
        VerDetalleUsuario vdu = new VerDetalleUsuario(this, true);
        vdu.setLocation(200, 200);
        vdu.setVisible(true);
    }//GEN-LAST:event_verUsuario

    private void GraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraficaActionPerformed
        // TODO add your handling code here:
        new Graficar("loquequieras","datos/prueba.txt");
    }//GEN-LAST:event_GraficaActionPerformed

    private void VerRegiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerRegiActionPerformed
        // TODO add your handling code here:
         RegistroSitio reg = new RegistroSitio(this, true);
        reg.setLocationRelativeTo(null);
        reg.setVisible(true);
    }//GEN-LAST:event_VerRegiActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Grafica;
    private javax.swing.JLabel Ibet;
    private javax.swing.JMenuItem VerRegi;
    private javax.swing.JMenuBar barra_menu;
    private javax.swing.JMenuItem cargar_datos_prueba;
    private javax.swing.JMenuItem crear_equipo;
    private javax.swing.JMenuItem dividendos;
    private javax.swing.JMenuItem finalizar_partido;
    private javax.swing.JMenuItem individual;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem liga;
    private javax.swing.JMenuItem menu_admin_jugadores;
    private javax.swing.JMenu menu_archivo;
    private javax.swing.JMenu menu_comp;
    private javax.swing.JMenu menu_equipo;
    private javax.swing.JMenu menu_fechaYhora;
    private javax.swing.JMenu menu_jugador;
    private javax.swing.JMenu menu_usuarios;
    private javax.swing.JMenuItem menu_verUsuario;
    private javax.swing.JMenu nueva_competicion;
    private javax.swing.JMenu partido;
    private javax.swing.JMenuItem partido_individual;
    private javax.swing.JMenuItem partido_liga;
    private javax.swing.JMenuItem salir;
    private javax.swing.JMenuItem ver_equipo;
    private javax.swing.JMenuItem ver_informacion;
    // End of variables declaration//GEN-END:variables
    
}
