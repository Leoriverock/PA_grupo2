/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas;

/**
 *
 * @author Administrador
 */

import Clases.*;
import Clases.Dats;
import Clases.Graph;
import Clases.VerticalLabelUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;

public class Graficar extends JFrame implements Runnable
{
    //int size_Width=500;
    //int size_Height=300;
    int size_Width=500;
    int size_Height=300;
    //double max_config=70000;
    double max_config=1000;
    double limiteminimo=0;
    double limitemaximo=20;
    Graph g=new Graph(10,size_Width,size_Height);
    Dats dda;
    Thread Hilo;
    //String files="datos/ght00031.txt";
    String files="datos/prueba.txt";
    int i=1;
    JLabel l,l1;
    //Controles para la configuracion de la grafica.
    JPanel Graficas=new JPanel();
    JPanel Calculos=new JPanel();
    JLabel Fuente, Fondo, Retardo;
    JLayeredPane js;

    public Graficar(String Title,String file)
    {
        super(Title);
        js=getLayeredPane();
        dda=new Dats(files);
        this.setSize((int)(size_Width*1.35),(int)(size_Height+290));
        js.setLayout(null);
       g.setBounds(new Rectangle(25,0,(int)(size_Width*1.2),(int)(size_Height+80)));
        this.add(g);
        g.Titulo("Grafica del Monedero","");
        g.Nombres_Ejes("Longitud de onda (nm)","Intensidad (counts)");
        //g.Limites(dda.getmaxX(),max_config, dda.getminX(),0);
        g.Limites(15.00,max_config,1.00,0);
        g.EtiquetasX(dda.gatX());
        g.EtiquetasY(dda.gatY());
        g.Datos(dda.gatX(), dda.gatY());
       
        addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent evt )
            {
                System.exit( 0 );
            }
        } );
        l = new JLabel( "Dinero", null, SwingConstants.CENTER );
        l1=new JLabel("Meses",null,SwingConstants.CENTER);
        l1.setBounds(new Rectangle(0,(int)(size_Height+70),25+(int)(size_Width*1.2),20));
        l.setBounds(new Rectangle(0,0,25,7+(int)(size_Height+80)));
	l.setUI( new VerticalLabelUI(false) );
        l1.setBackground(new Color(250,250,250));
        l.setBackground(new Color(250,250,250));
        l1.setForeground(new Color(100,100,100));
        l.setForeground(new Color(100,100,100));
        l1.setFont(new Font("Times New Roman",0,12));
        l.setFont(new Font("Times New Roman",0,12));
        l.setOpaque(true);
        l1.setOpaque(true);
        g.MostrarGrafica();
        //graficas*******
        /*Graficas.setBounds(new Rectangle(0,g.getHeight()+15,300,150));
        Graficas.setBackground(new Color(250,250,250));
        Graficas.setBorder(new TitledBorder("Grafica"));
        //***************
        //Calculos*******
        Calculos.setBounds(new Rectangle(Graficas.getWidth(),g.getHeight()+15,325,150));
        Calculos.setBackground(new Color(250,250,250));
        Calculos.setBorder(new TitledBorder("Cálculos realizados"));*/
        //***************
	js.add(l,new Integer(2));
	js.add(l1,new Integer(2));
        js.add(g,new Integer(1));
        js.add(Graficas,new Integer(2));
        js.add(Calculos,new Integer(2));
        Hilo=new Thread(this);
        Hilo.start();
        this.show();
    }

  public void run()
  {
        i=2;
        //while(i<=42)
        //{
            if(i>=10)
            {
                //files="datos/ght000"+i+".txt";
                //files="datos/prueba.txt";
            }
            else
            {
                //files="datos/ght0000"+i+".txt";
            dda=new Dats(files);
            g.Limpiar();
            //g.Limites(dda.getmaxX(),max_config, dda.getminX(),0);
            //Escribe minimo y maximo de el eje x, Y el max,conf la altura (y)
            g.Limites(8.00,max_config, 3.00,0);
            g.EtiquetasX(dda.gatX());
            g.EtiquetasY(dda.gatY());
            g.Datos(dda.gatX(), dda.gatY());
            //g.Intensitys(dda.getMaxIntensityRead(), dda.getPromediumIntensityRead(), dda.getMinimusIntensityRead());
            
            //Escribe el Maximo Y Promedio Y Minimo Y
            g.Intensitys(8.00, dda.getPromediumIntensityRead(), dda.getMinimusIntensityRead());
            }
            /*try{
                Hilo.sleep(100);}
            catch(Exception e){}
            if(i==42)
                i=1;
            i++;*/
        //}
  }
   public void windowClosed(WindowEvent event)      {}
   public void windowDeiconified(WindowEvent event) {}
   public void windowIconified(WindowEvent event)   {}
   public void windowActivated(WindowEvent event)   {}
   public void windowDeactivated(WindowEvent event) {}
   public void windowOpened(WindowEvent event)      {}
   public void windowClosing(WindowEvent event)     { dispose();}

  /*public static void main(String Ar[])
   {
       new Graficar("Muestra de graficacion","datos/ght00031.txt");
   }*/
}
