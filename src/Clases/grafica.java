package Clases;

import java.awt.*;

public class grafica extends Canvas
{
    private int Lin_Hor=0,Lin_Ver=0, Cantidad_Total=0;
    private int Ancho,Alto;
    private int CoordenadasXH[][],CoordenadasYH[][];
    private int CoordenadasXV[][],CoordenadasYV[][];
    int x[][], y[][],  numd;
    int n, MaxX, MaxY, posx[], posy[];
    private int numser, inser;
    private double maxy, miny, etiqx[], etiqy[];
    private double maxx, minx;
    private Color Colores[]=new Color[6];
    private double imax,imin,iprom;
    public grafica(int cantidad,int max_X, int max_Y)
    {
        this.setBackground(new Color(250,250,230));
        Cantidad_Total=cantidad;
        MaxX=max_X;
        MaxY=max_Y;
        numd=Cantidad_Total;
        etiqx = new double[numd+1];
        etiqy = new double[numd+1];
        posx  = new int[numd+1];
        posy  = new int[numd+1];
        inser=0;
        numser=300;
        Colores[0]=Color.ORANGE;
        Colores[1]=Color.GREEN;
        Colores[2]=Color.PINK;
        Colores[3]=Color.MAGENTA;
        Colores[4]=Color.YELLOW;
        Colores[5]=Color.CYAN;
        imax=iprom=imin=0;
    }
    public void Cambiar_Cantidad(int Nueva)
    {
        Cantidad_Total=Nueva;
        LineasHorizontales();
        LineasVerticales();
        repaint();
    }
    public void IntensitysReading(double imx, double ipm, double imn)
    {
        imax=imx;iprom=ipm;imin=imn;
    }
    public void LineasHorizontales()
    {
        int Cantidad=Cantidad_Total;
        Ancho=this.getSize().width;
        Alto=this.getSize().height;
        CoordenadasXH=new int[Cantidad][2];
        CoordenadasYH=new int[Cantidad][2];
        for(int i=0; i<Cantidad; i++)
        {
            CoordenadasXH[i][0]=posx[i];
            CoordenadasXH[i][1]=0;
            CoordenadasYH[i][0]=posx[i];
            CoordenadasYH[i][1]=Alto;
        }
    }
    public void LineasVerticales()
    {
        int Cantidad=Cantidad_Total;
        Ancho=this.getSize().width;
        Alto=this.getSize().height;
        CoordenadasXV=new int[Cantidad][2];
        CoordenadasYV=new int[Cantidad][2];
        for(int i=0; i<Cantidad; i++)
        {
            CoordenadasXV[i][0]=0;
            CoordenadasXV[i][1]=posy[i];
            CoordenadasYV[i][0]=Ancho;
            CoordenadasYV[i][1]=posy[i];
        }
    }
    public void Limites(double MaximoX,double MaximoY,double MinimoX,double MinimoY)
    {
        minx=MinimoX;
        miny=MinimoY;
        maxx=MaximoX;
        maxy=MaximoY;
    }
    public void BorrarLineas()
    {
        inser=0;
        repaint();
    }
    public void Datos(double x[], double y[])
    {
        SerieX(x);
        SerieY(y);
        repaint();
    }
   public double[][] EtiquetasX(double[] x0)
   {
     double min, max, inc, aux;
     int i=0;
     n = x0.length;
     if (inser==0)
     {
       n=x0.length;
       x = new int[numser][n];

       inc = (maxx - minx) / numd;
       if (Math.abs(maxx - minx) > 1.0) {
         if (Math.abs(inc) < 1.0)
           inc = (double) 1.0;
         else
           inc = Math.round(inc + 0.5);
       }

       for (i = 0; i <=numd; i++) {
         aux = minx + inc * i;
         aux = (Math.round(aux * 10000.0)) / 10000.0;
         etiqx[i] = aux;
         posx[i] = (int) ( (etiqx[i] - minx) / (maxx - minx) * (MaxX));
       }
     }
     double Etiquetas[][]=new double[numd+1][2];
     for(i=0; i<=numd; i++)
     {
         Etiquetas[i][0]=etiqx[i];
         Etiquetas[i][1]=posx[i];
     }
     return Etiquetas;
   }
   public double[][] EtiquetasY(double y0[])
   {
     double min, max, inc, aux;
     int i=0;
     n=y0.length;
     if(inser == 0)
     {
       y = new int[numser][n];

       inc = (maxy - miny)/numd;

       if( Math.abs(maxy - miny) > 1.0)
       {
          if(Math.abs(inc) < 1.0) inc = (double)1.0;
          else inc = Math.round(inc+0.5);
       }


       for(i=0; i<=numd; i++)
       {
         aux = miny + inc*i;

         aux = (Math.round(aux*100000.0))/100000.0;
         etiqy[i] = aux;
         posy[i]  = (int) ((etiqy[i] - miny)/(maxy - miny)*(MaxY));
       }
     }
     double Etiquetas[][]=new double[numd+1][2];
     for(i=0; i<=numd; i++)
     {
         Etiquetas[i][0]=etiqy[i];
         Etiquetas[i][1]=posy[i];
     }
     return Etiquetas;
   }
   void SerieX(double x0[])
   {
     int i;
     n=x0.length;
     for (i = 0; i < n; i++)
     {
       x[inser][i] = (int) ( (x0[i] - minx) / (maxx - minx) * (MaxX));
     }

   }
   void SerieY(double y0[])
   {
     int i;
     n=y0.length;

     if(inser >= numser) return;

     for(i=0; i<n; i++)
       y[inser][i] = (int) ((y0[i] - miny)/(maxy - miny)*(MaxY));

      inser++;
   }
   public void paint(Graphics g)
    {
        int i, j, mm;
        //Dibujando malla del plano
        g.setColor(new Color(216,225,251));
        //Dibujar Lineas Verticales
        for(i=0; i<CoordenadasXH.length; i++)
            g.drawLine(CoordenadasXH[i][0], CoordenadasXH[i][1],CoordenadasYH[i][0], CoordenadasYH[i][1]);
        //Dibujar Lineas Horizontales
        for(i=0; i<CoordenadasXV.length; i++)
            g.drawLine(CoordenadasXV[i][0], MaxY-CoordenadasXV[i][1],CoordenadasYV[i][0], MaxY-CoordenadasYV[i][1]);
       if(inser> numser) mm = numser;
       else mm = inser;
       //System.out.println(mm);
       for(j=0; j<=inser; j++)
       {
         g.setColor(Color.red);
         for(i=0; i<(n-1); i++)
           g.drawLine(x[j][i], MaxY-y[j][i],  x[j][i+1], MaxY-y[j][i+1]);
       }
       g.setColor(new Color(100,100,100));
       g.drawString("I_max = "+Double.toString(imax), MaxX-110, 20);
       g.drawString("I_prom = "+Double.toString(iprom), MaxX-110, 40);
       g.drawString("I_min = "+Double.toString(imin), MaxX-110, 60);
   }
}
