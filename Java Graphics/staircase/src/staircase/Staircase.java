/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package staircase;
// Cylinder.java: Generating an input file for a
//                (possibly hollow) cylinder.
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Staircase extends Frame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length ==3) new Staircase(Integer.parseInt(args[0]),Float.parseFloat(args[1]),args[2]);
        else new Staircase(20,20.0f,"stairs.dat");        
    }
    
    Staircase(int nstairs, float stairdeg, String filename)
    {

       try{
            BeamsObj b = new BeamsObj(nstairs, 7, stairdeg * Math.PI / 180, "stairs.dat");
            //DlgCylinder pole = new DlgCylinder(this);
            
            Cylinder pole = new Cylinder(b.finalm+1,nstairs,"stairs.dat");
            //pole.startv = b.finalm+1;
            b.writefaces();
       }
       catch(IOException ioe)
       {}

       
    }
}
/*
class DlgCylinder extends Dialog
{  TextField tfN = new TextField (5);
   TextField tfOuterDiam = new TextField (5);
   TextField tfInnerDiam = new TextField (5);
   Button button = new Button("  OK  ");
   FileWriter fw;

   DlgCylinder(Frame fr)
   {  super(fr, "Cylinder (possibly hollow); height = 1", true);
      addWindowListener(new WindowAdapter()
      {  public void windowClosing(WindowEvent e)
         {  dispose();
            System.exit(0);
         }
      });
      Panel p1 = new Panel(), p2 = new Panel(), p3 = new Panel();
      p1.add(new Label("Number of vertices on outer circle: "));
      p1.add(tfN);
      p2.add(new Label(
         "Diameters D and d (cylinder is hollow if d > 0): "));
      p2.add(tfOuterDiam); p2.add(tfInnerDiam);
      p3.add(new Label("Generate 3D object file?"));
      p3.add(button);
      setLayout(new BorderLayout());
      add("North", p1);
      add("Center", p2);
      add("South", p3);

      button.addActionListener(new ActionListener()
      {  public void actionPerformed(ActionEvent ae)
         {  int n=0;
            float dOuter=0, dInner=0;
            try
            {  n = Integer.valueOf(tfN.getText()).intValue();
               dOuter =
                  Float.valueOf(tfOuterDiam.getText()).floatValue();
               dInner =
                  Float.valueOf(tfInnerDiam.getText()).floatValue();
               if (dInner > 0) dInner = 0;
               if (n < 3 || dOuter <= dInner)
                  Toolkit.getDefaultToolkit().beep();
               else
               {  try
                  {  genCylinder(n, dOuter/2, dInner/2);
                  }
                  catch (IOException ioe){}
                  dispose();
                  System.exit(0);
               }
            }
            catch (NumberFormatException nfe)
            {  Toolkit.getDefaultToolkit().beep();
            }
         }
      });
      Dimension dim = getToolkit().getScreenSize();
      setSize(3 * dim.width/4, dim.height/4);
      setLocation(dim.width/8, dim.height/8);
      show();
   }

   void genCylinder(int n, float rOuter, float rInner)
      throws IOException
   {  int n2 = 2 * n, n3 = 3 * n, n4 = 4 * n;
      fw = new FileWriter("Cylinder.dat");
      double delta = 2 * Math.PI / n;
      for (int i=1; i<=n; i++)
      {  double alpha = i * delta,
            cosa = Math.cos(alpha), sina = Math.sin(alpha);
         for (int inner=0; inner<2; inner++)
         {  double r = (inner == 0 ? rOuter : rInner);
            if (r > 0)
            for (int bottom=0; bottom<2; bottom++)
            {  int k = (2 * inner + bottom) * n + i;
               // Vertex numbers for i = 1:
               // Top:       1 (outer)   2n+1 (inner)
               // Bottom:  n+1 (outer)   3n+1 (inner)
               wi(k); // w = write, i = int, r = real
               wr(r * cosa); wr(r * sina); // x and y
               wi(startz*(1 - bottom)); // bottom: z = 0; top: z = 1
               fw.write("\r\n");
            }
        }
      }
      fw.write("Faces:\r\n");
      // Top boundary face:
      for (int i=1; i<=n; i++) wi(i);
      if (rInner > 0)
      {  wi(-n3); // Invisible edge, see Section 7.5
         for (int i=n3-1; i>=n2+1; i--) wi(i);
         wi(n3); wi(-n); // Invisible edge again.
      }
      fw.write(".\r\n");

      // Bottom boundary face:
      for (int i=n2; i>=n+1; i--) wi(i);
      if (rInner > 0)
      {  wi(-(n3+1));
         for (int i=n3+2; i<=n4; i++) wi(i);
         wi(n3+1); wi(-(n+1));
      }
      fw.write(".\r\n");
      // Vertical, rectangular faces:
      for (int i=1; i<=n; i++)
      {  int j = i % n + 1;
         // Outer rectangle:
         wi(j); wi(i); wi(i + n); wi(j + n); fw.write(".\r\n");
         if (rInner > 0)
         {  // Inner rectangle:
            wi(i + n2); wi(j + n2); wi(j + n3); wi(i + n3);
            fw.write(".\r\n");
         }
      }
      fw.close();
   }

   void wi(int x)
      throws IOException
   {  
       if(x>0) x+=startv;
       else x-=startv;
       fw.write(" " + String.valueOf(x));
   }
   int startv = 200;
   int startz = 25;
   //int startv = 0;
   //int startz = 1;

   void wr(double x)
      throws IOException
   {  if (Math.abs(x) < 1e-9) x = 0;
      fw.write(" " + String.valueOf((float)x));

					  

// float instead of double to reduce the file size
   }
}
*/
class Cylinder
{ 
   FileWriter fw;
   String Fname;

   Cylinder(int v,int z, String fname)
   {  try
        {  startv = v;
           startz = z;
            genCylinder(20,1f,0f,fname);
        }
        catch (IOException ioe)
        {
            System.exit(0);
        }      
   }

   void genCylinder(int n, float rOuter, float rInner, String fname)
      throws IOException
   {  int n2 = 2 * n, n3 = 3 * n, n4 = 4 * n;
      fw = new FileWriter(fname,true);
      double delta = 2 * Math.PI / n;
      for (int i=1; i<=n; i++)
      {  double alpha = i * delta,
            cosa = Math.cos(alpha), sina = Math.sin(alpha);
         for (int inner=0; inner<2; inner++)
         {  double r = (inner == 0 ? rOuter : rInner);
            if (r > 0)
            for (int bottom=0; bottom<2; bottom++)
            {  int k = (2 * inner + bottom) * n + i;
               // Vertex numbers for i = 1:
               // Top:       1 (outer)   2n+1 (inner)
               // Bottom:  n+1 (outer)   3n+1 (inner)
               wi(k+startv); // w = write, i = int, r = real
               wr(r * cosa); wr(r * sina); // x and y
               wi(startz*(1 - bottom)); // bottom: z = 0; top: z = 1
               fw.write("\r\n");
            }
        }
      }
      fw.write(" Faces:\r\n");
      // Top boundary face:
      for (int i=1; i<=n; i++) wi(i+startv);
      if (rInner > 0)
      {  wi(-n3); // Invisible edge, see Section 7.5
         for (int i=n3-1; i>=n2+1; i--) wi(i+startv);
         wi(n3); wi(-n); // Invisible edge again.
      }
      fw.write(".\r\n");

      // Bottom boundary face:
      for (int i=n2; i>=n+1; i--) wi(i+startv);
      if (rInner > 0)
      {  wi(-(n3+1));
         for (int i=n3+2; i<=n4; i++) wi(i+startv);
         wi(n3+1); wi(-(n+1));
      }
      fw.write(".\r\n");
      // Vertical, rectangular faces:
      for (int i=1; i<=n; i++)
      {  int j = i % n + 1;
         // Outer rectangle:
         wi(j+startv); wi(i+startv); wi(i + n + startv); wi(j + n +startv); fw.write(".\r\n");
         if (rInner > 0)
         {  // Inner rectangle:
            wi(i + n2); wi(j + n2); wi(j + n3); wi(i + n3);
            fw.write(".\r\n");
         }
      }
      fw.close();
   }

   void wi(int x)
      throws IOException
   {  
       //if(x>0) x+=startv;
       //else x-=startv;
       fw.write(" " + String.valueOf(x));
   }
   public int startv = 200;
   public int startz = 25;
   //int startv = 0;
   //int startz = 1;

   void wr(double x)
      throws IOException
   {  if (Math.abs(x) < 1e-9) x = 0;
      fw.write(" " + String.valueOf((float)x));

					  

// float instead of double to reduce the file size
   }
}

// Beams.java: Generating input files for a spiral of beams. The
//    values of n, a and alpha (in degrees) as well as the output
//    file name are to be supplied as program arguments.
//    Uses: Point3D (Section 3.9).
//import java.io.*;

class Beams
{  public static void main(String[] args)throws IOException
   {  if (args.length != 4)
      {  System.out.println(
         "Supply n (> 0), a (>= 0.5), alpha (in degrees)\n" +
         "and a filename as program arguments.\n");
        System.exit(1);
      }
      int n = 0;
      double a = 0, alphaDeg = 0;
      try
      {  n = Integer.valueOf(args[0]).intValue();
         a = Double.valueOf(args[1]).doubleValue();
         alphaDeg = Double.valueOf(args[2]).doubleValue();
         if (n <= 0 || a < 0.5)throw new NumberFormatException();
      }
      catch (NumberFormatException e)
      {  System.out.println("n must be an integer > 0");
         System.out.println("a must be a real number >= 0.5");
         System.out.println("alpha must be a real number");
         System.exit(1);
      }
      new BeamsObj(n, a, alphaDeg * Math.PI / 180, args[3]);
   }
}

class BeamsObj
{   int n;
    String fileName;
    int finalm ;
    
   BeamsObj(int nb, double a, double alpha, String fName) throws IOException
   {  
      n =nb; fileName = fName;
      FileWriter fw = new FileWriter(fileName);
      Point3D[] P = new Point3D[11];
      double b = a - 1;
      /*P[1] = new Point3D(a, -a, 0);
      P[2] = new Point3D(a,  a, 0);
      P[3] = new Point3D(b,  a, 0);
      P[4] = new Point3D(b, -a, 0);
      P[5] = new Point3D(a, -a, 1);
      P[6] = new Point3D(a,  a, 1);
      P[7] = new Point3D(b,  a, 1);
      P[8] = new Point3D(b, -a, 1);*/
      b=1;
      P[1] = new Point3D(a, -1, 0);
      P[2] = new Point3D(a,  1, 0);
      P[3] = new Point3D(b,  1, 0);
      P[4] = new Point3D(b, -1, 0);
      P[5] = new Point3D(a, -1, 0.2);
      P[6] = new Point3D(a,  1, 0.2);
      P[7] = new Point3D(b,  1, 0.2);
      P[8] = new Point3D(b, -1, 0.2);
      P[9] = new Point3D(a, 0, 0.1);
      P[10] = new Point3D(a, 0, a-1);

      for (int k=0; k<n; k++)
      {  // Beam k:
         double phi = k * alpha,
            cosPhi = Math.cos(phi), sinPhi = Math.sin(phi);
         int m = 10 * k;
         for (int i=1; i<=10; i++)
         {  double x = P[i].x, y = P[i].y;
            float x1 = (float)(x * cosPhi - y * sinPhi),
                  y1 = (float)(x * sinPhi + y * cosPhi),
                  z1 = (float)(P[i].z + k);
            fw.write((m + i) + " " + x1 + " " + y1 + " " + z1 +
               "\r\n");
         }
      }
      finalm = 10*n;
      fw.close();

   }
   
   void writefaces() throws IOException
   {
      FileWriter fw = new FileWriter(fileName, true);
      //fw.write("Faces:\r\n");
      for (int k=0; k<n; k++)
      {  // Beam k again:
         int m = 10 * k;
         face(fw, m, 1, 2, 6, 5);
         face(fw, m, 4, 8, 7, 3);
         face(fw, m, 5, 6, 7, 8);
         face(fw, m, 1, 4, 3, 2);
         face(fw, m, 2, 3, 7, 6);
         face(fw, m, 1, 5, 8, 4);
         //face(fw, m, 1, 5, 8, 4);
         //face(fw, m, 1, 5, 8, 4);
      }
      fw.close();
   }

   void face(FileWriter fw, int m, int a, int b, int c, int d)throws IOException
   {  a += m; b += m; c += m; d += m;
      fw.write(a + " " + b + " " + c + " " + d + ".\r\n");
   }
}

class Point3D
{  float x, y, z;
   Point3D(double x, double y, double z)
   {  this.x = (float)x;
      this.y = (float)y;
      this.z = (float)z;
   }
}

				