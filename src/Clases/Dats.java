/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author Root
 */
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Dats
{
    Coor start;
    private int num=0;
    private double max_x=0,min_x=0,max_y=0,min_y=0,prom=0,sum=0;
    private double vals[][]=new double[3665-17][2];
    private double X_Dats[]=new double[vals.length];
    private double Y_Dats[]=new double[vals.length];
    
    public Dats(String archivo) {
      String linea = "";
      StringTokenizer st;
      String x;
      Coor c;
      int i,j=0;
      sum=0;
      try
      {
        double minx=0.0, maxx=0.0,miny=0.0, maxy=0.0;
        RandomAccessFile DIS = new RandomAccessFile(archivo, "r");
        maxx = minx = 200;
        maxy = miny = 1000;
        while ( ( (linea = DIS.readLine()) != null) )
        {
          if(num>=17 && num<=3664)
          {
            st=new StringTokenizer(linea,"\t");
            for(i=0;st.hasMoreTokens();i++)
                vals[j][i]=Double.parseDouble(st.nextToken());

            X_Dats[j]=vals[j][0];
            Y_Dats[j]=vals[j][1];
            sum += Y_Dats[j];

            if(j>0)
            {
                if (vals[j][0] > maxx)
                    maxx = vals[j][0];
                if (vals[j][0] < minx)
                    minx =vals[j][0];
                
                if (vals[j][1] > maxy)
                    maxy = vals[j][1];
                if (vals[j][1] < miny)
                    miny =vals[j][1];
            }
            j++;
          }
          else
          {
              x = linea;
              c = new Coor(x);
              c.next = this.start;
              this.start = c;
          }
          num++;
        }
        min_x = minx;
        max_x = maxx*1.005;

        min_y = miny;
        max_y = maxy;
        prom=Math.round((sum/j)*100.0)/100.0;

        DIS.close();
      }
      catch (IOException e)
      {
          JOptionPane.showMessageDialog(null, "Error" + e.toString(), "ERROR",
                                      JOptionPane.ERROR_MESSAGE);
      }
    }
    public double[][] getDats(){return vals;}
    public double[] gatX(){return X_Dats;}
    public double[] gatY(){return Y_Dats;}
    public int length(){return vals.length;}
    public double getminX(){return min_x;}
    public double getminY(){return min_y;}
    public double getmaxX(){return max_x;}
    public double getmaxY(){return max_y;}
    public double getMaxIntensityRead(){return max_y;}
    public double getMinimusIntensityRead(){return min_y;}
    public double getPromediumIntensityRead(){return prom;}
    
    /*public static void main(String arg[])
    {
        Dats v=new Dats("datos/ght00020.txt");
        System.out.println("Minx: "+v.getminX()+", Maxx:"+v.getmaxX());
        System.out.println("Miny: "+v.getminY()+", Maxy:"+v.getmaxY());
    }*/
}
