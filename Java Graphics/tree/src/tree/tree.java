package tree;

//Bonus Implemented. author: Bhavya

import java.awt.*;
import java.awt.event.*;

public class tree extends Frame{

    public static void main(String[] args)
   {  
       if(args.length ==1) new tree(args[0]);
        else 
         new tree("tree1.txt");
   }
    tree(String fileName)
   {  super("Click left or right mouse button to change the level");
      addWindowListener(new WindowAdapter()
         {public void windowClosing(
                 WindowEvent e){System.exit(0);}});
      setSize (800, 600);
      add("Center", new Cvtree(fileName));
      show();
  }
}


class Cvtree extends Canvas
{  String fileName, axiom, strF, strf, strX, strY;
   int maxX, maxY, level = 1;
   double xLast, yLast, dir, rotation,angle, angle1,angle2,angle3, dirStart, fxStart, fyStart,
      lengthFract, widthFact, reductFact, lenfactor1,lenfactor2,lenfactor3, rfactor;

   void error(String str)
   {  System.out.println(str);
      System.exit(1);
   }

   Cvtree(String fileName)
   {  Input inp = new Input(fileName);
      if (inp.fails())
         error("Cannot open input file.");
		 
      axiom = inp.readString(); inp.skipRest();
      strF = inp.readString(); inp.skipRest();
      strf = inp.readString(); inp.skipRest();
      strX = inp.readString(); inp.skipRest();
      strY = inp.readString(); inp.skipRest();
      rotation = inp.readFloat(); inp.skipRest();
      angle1 = rotation;
      angle2 = inp.readFloat(); inp.skipRest();
      angle3 = inp.readFloat(); inp.skipRest();
      dirStart = inp.readFloat(); inp.skipRest();
      fxStart = inp.readFloat(); inp.skipRest();
      fyStart = inp.readFloat(); inp.skipRest();
      lengthFract = inp.readFloat(); inp.skipRest();
      reductFact = inp.readFloat(); inp.skipRest();
      lenfactor1 = reductFact;
      lenfactor2 = inp.readFloat(); inp.skipRest();
      lenfactor3 = inp.readFloat(); 
      widthFact = 0.8;
      if (inp.fails())
         error("Input file incorrect.");

      addMouseListener(new MouseAdapter()
      {  public void mousePressed(MouseEvent evt)
         {  if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) != 0)
            {  level--;      // Right mouse button decreases level
               if (level < 1)
                  level = 1;
            }
            else
               level++;      // Left mouse button increases level
            repaint();
         }
      });

   }

   Graphics g;
   int iX(double x){return (int)Math.round(x);}
   int iY(double y){return (int)Math.round(maxY-y);}

   void drawTo(Graphics g, double x, double y,double width)
   {  g.drawLine(iX(xLast), iY(yLast), iX(x) ,iY(y));
      //for thickness      
      g.drawLine(iX(xLast+0.5), iY(yLast), iX(x+0.5) ,iY(y));
      g.drawLine(iX(xLast-0.5), iY(yLast), iX(x-0.5) ,iY(y));

      xLast = x;
      yLast = y;
   }
   
      void drawRectTo(Graphics g, double x, double y,double width)
   { 
      for(double i = width;i>0;i--)
      {g.drawLine(iX(xLast-i), iY(yLast), iX(x-i/2) ,iY(y));
       g.drawLine(iX(xLast+i), iY(yLast), iX(x+i/2) ,iY(y));
      }
      xLast = x;
      yLast = y;
   }

   void moveTo(Graphics g, double x, double y)
   {  xLast = x;
      yLast = y;
   }			  

public void paint(Graphics g)
   {  Dimension d = getSize();
      maxX = d.width - 1;
      maxY = d.height - 1;
      xLast = fxStart * maxX;
      yLast = fyStart * maxY;
      dir = dirStart;   // Initial direction in degrees
      turtleGraphics(g, axiom, level, lengthFract * maxY,0.01* maxX);
   }

   public void turtleGraphics(Graphics g, String instruction,
      int depth, double len,double width)
   {  double xMark=0, yMark=0, dirMark=0;
      for (int i=0;i<instruction.length();i++)
      {  char ch = instruction.charAt(i);
         switch(ch)
         {
         case 'T': 
                double rad1 = Math.PI/180 * dir, // Degrees -> radians
                  dx1 = len * Math.cos(rad1), dy1 = len * Math.sin(rad1);
               drawRectTo(g, xLast + dx1, yLast + dy1,width);
               break;

         case 'F': // Step forward and draw
            // Start: (xLast, yLast), direction: dir, steplength: len
            if (depth == 0)
            {  double rad = Math.PI/180 * dir, // Degrees -> radians
                  dx = len * Math.cos(rad), dy = len * Math.sin(rad);
               drawTo(g, xLast + dx, yLast + dy,width);
            }
            else
               turtleGraphics(g, strF, depth - 1, reductFact * len,widthFact*width);
            break;
         case 'f': // Step forward without drawing
            // Start: (xLast, yLast), direction: dir, steplength: len
            if (depth == 0)
            {  double rad = Math.PI/180 * dir, // Degrees -> radians
                  dx = len * Math.cos(rad), dy = len * Math.sin(rad);
               moveTo(g, xLast + dx, yLast + dy);
            }
            else
               turtleGraphics(g, strf, depth - 1, reductFact * len,widthFact*width);
            break;
         case 'X':
            if (depth > 0)
               turtleGraphics(g, strX, depth - 1, reductFact * len,widthFact*width);
            break;
         case 'Y':
            if (depth > 0)
            {g.setColor(Color.green); rotation = 16; reductFact = lenfactor1;
                turtleGraphics(g, strY, depth - 1, reductFact * len *0.15,widthFact*width);
                g.setColor(Color.black);
            }
            break;
         case '+': // Turn right
            dir -= rotation; break;
         case '-': // Turn left
            dir += rotation; break;
         case '[': // Save position and direction
            xMark = xLast; yMark = yLast; dirMark = dir; angle = rotation; rfactor = reductFact; break;
         case ']': // Back to saved position and direction
            xLast = xMark; yLast = yMark; dir = dirMark; rotation = angle; reductFact = rfactor; break;
         case 'P':
            rotation = angle1; reductFact = lenfactor1;
            break;
         case 'L':
            rotation = angle2; reductFact = lenfactor2;
            break;
         case 'R':
            rotation = angle3; reductFact = lenfactor3;
            break;
         }
      }
   }
}
