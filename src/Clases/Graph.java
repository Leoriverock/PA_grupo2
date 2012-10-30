/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author Cristian Jesus Torres Pacheco
 */

import java.awt.*;
import javax.swing.*;

public class Graph extends Panel
{
    grafica graph;
    private String Titulo_Graf="",Titulo_Graf1="", NameX="", NameY="";
    public double[] EtiqX[], EtiqY[];
    JLabel Tit_Y=new JLabel("Eje Y");
    JLabel l=new JLabel("Eje Y");
    double Max_X,Max_Y;

    public Graph(int Total_Lineas,int maxX, int maxY)
    {
        setLayout(null);
        this.setBackground(new Color(250,250,250));
        graph=new grafica(Total_Lineas,maxX,maxY);
        graph.setBounds(new Rectangle(50,50,maxX,maxY));
        Max_X=maxX;Max_Y=maxY;

    }
    public void Limites(double MaximoX,double MaximoY,double MinimoX,double MinimoY)
    {
        graph.Limites(MaximoX, MaximoY, MinimoX, MinimoY);
    }
    public void EtiquetasX(double[] x0)
    {
        EtiqX=graph.EtiquetasX(x0);
        graph.LineasHorizontales();
        graph.LineasVerticales();
    }
    public void Intensitys(double A, double B, double C)
    {
        graph.IntensitysReading(A, B, C);
    }
    public void EtiquetasY(double[] y0)
    {
        EtiqY=graph.EtiquetasY(y0);
        graph.LineasHorizontales();
        graph.LineasVerticales();
    }
    public void Datos(double[] x, double[] y)
    {
        graph.Datos(x, y);
    }
    public void MostrarGrafica()
    {
        this.add(graph);
    }
   public void Titulo(String Nombre, String Nombre1)
    {
        Titulo_Graf=Nombre;
        Titulo_Graf1=Nombre1;
    }
    public void Nombres_Ejes(String NombreX, String NombreY)
    {
        NameX=NombreX;
        NameY=NombreY;
    }
    public void Limpiar()
    {
        graph.BorrarLineas();
    }
    public void paint(Graphics g)
    {
       g.setFont(new Font("Times New Roman",0,12));
       int numd=EtiqY.length,i;
       g.setColor(new Color(100,100,100));
       for(i=0; i<numd; i++)
       {
         //g.drawString(Double.toString(etiqx[i]), 25 + posx[i], 20 );
         g.drawString(Integer.toString((int)EtiqX[i][0]),(int)(40 + EtiqX[i][1]), this.getHeight()-15);
         //g.drawLine(25+posx[i], pos_ejey-5,  25+posx[i], pos_ejey+5);

         g.drawString(Integer.toString((int)EtiqY[i][0]), 10, (int)(Max_Y-EtiqY[i][1])+55);
         //g.drawLine(pos_ejex-5, MaxY-posy[i], pos_ejex+5, MaxY-posy[i]);
        }
       g.drawString(Titulo_Graf,((this.getSize().width/2)-(Titulo_Graf.length()*5)/2),18);
       g.drawString(Titulo_Graf1,((this.getSize().width/2)-(Titulo_Graf1.length()*5)/2),30);
       //g.drawString(NameX,((this.getSize().width/2)-(NameX.length()*5)/2),585);
    }
}

