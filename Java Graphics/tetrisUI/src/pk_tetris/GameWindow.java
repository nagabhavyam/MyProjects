package pk_tetris;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameWindow extends Frame{
      
    GameWindow()
    {   //calling frame Constructor
        super();
        //creates a window listener when the object is created
        this.addWindowListener(
                new WindowAdapter()
                {   //defining the methods of abstract class Window Adapter
                    @Override
                    public void windowClosing(WindowEvent e)
                    {System.exit(0);
                    }
                }       
            );
         //setting frame size
        
        setSize(500,500);
        
        //adding Canvas to the frame
        add("Center",new gameCanvas());
        setCursor(Cursor.getPredefinedCursor((Cursor.CROSSHAIR_CURSOR)));
       show();
    }
    public static void main(String[] args)
    {
        new GameWindow();
    }

}

class gameCanvas extends Canvas implements MouseListener, MouseMotionListener,MouseWheelListener
{
    int maxX,maxY,centerX,centerY;
    float pixelSize, rWidth = 500.0f, rHeight = 500.0f;
        
    box gameRec,pause,quit,nextBox;
    Vector filled = new Vector();
    poly[] shapes;
    poly curShape,nextShape;
    int randomi;    
    boolean pauseVisible=false;
    Label MainArea;
          
    gameCanvas()
    {   
      
        createGUI();
        this.timer.scheduleAtFixedRate(this.task, 1000, 500);

    }

        
    void createGUI()
    {    

        gameRec = new box();
        nextBox = new box();
        pause = new box();
        quit = new box();
        
        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
    
        shapes = new poly[5];
        for(int i =0; i<5;i++)
            shapes[i]= new poly();
                
        curShape = new poly();
        nextShape = new poly();
        
        initgr();
        setGUI();
        randomNextShape();
        changeCurShape();
        randomNextShape();
        
    }
    
    float old_pixelSize = 0;
    float old_centerX =0,old_centerY =0;
    public void initgr()
    {   
       Dimension d = getSize();
        int maxX = d.width - 1, maxY = d.height - 1;
        float new_pixelsize = Math.max(rWidth/maxX, rHeight/maxY); 
        
        if(pixelSize != new_pixelsize)
        {   pixelSizeChanged =true;       
            //resizeFilled();
            old_pixelSize = pixelSize;
            pixelSize = new_pixelsize;            
            
            old_centerX = centerX; old_centerY = centerY; 
            centerX = maxX/2; centerY = maxY/2;  
        }

       
    }

    int iX(float x){return Math.round(centerX + x/pixelSize);}
    int iY(float y){return Math.round(centerY - y/pixelSize);}
    float fx(int x){return (x - centerX) * pixelSize;}
    float fy(int y){return (centerY - y) * pixelSize;}
    int iWH(float wh){return Math.round(wh/pixelSize);}
    
    int iX_old(float x){return Math.round(old_centerX + x/old_pixelSize);}
    int iY_old(float y){return Math.round(old_centerY - y/old_pixelSize);}
    float fx_old(int x){return (x - old_centerX) * old_pixelSize;}
    float fy_old(int y){return (old_centerY - y) * old_pixelSize;}
    int iWH_old(float wh){return Math.round(wh/old_pixelSize);}
    
    Point levelP,linesP,scoreP;
    void setGUI()
    {
        
        gameRec.set(iX(-225),iY(225),iWH(250),iWH(425));
        nextBox.set(iX(75),iY(225),iWH(150),iWH(100));
        pause.set(iX(-150),iY(-50),iWH(100),iWH(50));
        quit.set(iX(100),iY(-50),iWH(100),iWH(50));
        levelP =new Point(iX(100),iY(75));
        linesP =new Point(iX(100),iY(50));
        scoreP =new Point(iX(100),iY(25));
        
        setshapes();
     }
    void setshapes()
    {
        float x=50.0f,y=50.0f;
        float xhalf=x/2,yhalf=y/2;
        
        shapes[0].set_org(-xhalf,yhalf,xhalf,-yhalf,-xhalf,-yhalf,-xhalf,yhalf,Color.red);
        shapes[1].set_org(-xhalf,yhalf,xhalf,yhalf,xhalf,-yhalf,-xhalf,-yhalf,Color.blue);
        shapes[2].set_org(0,yhalf,x,-yhalf,0,-yhalf,-x,-yhalf,Color.yellow);
        shapes[3].set_org(0,yhalf,x,-yhalf,0,-yhalf,-x,yhalf,Color.green);
        shapes[4].set_org(0,yhalf,x,yhalf,0,-yhalf,-x,-yhalf,Color.orange);      

    }
    
    void randomNextShape()
    {   Random ran = new Random();
        randomi = ran.nextInt(5);
        nextShape.copy_org(shapes[randomi]);
        movePolyTo(nextShape,150, 175);        
    } 
    void changeCurShape()
    {   curShape = new poly();
        curShape.copy_org(nextShape);
        movePolyTo(curShape,-100, 200);
        stopmoving =false;        
    }
        
    void movePolyTo(poly p,float newx,float newy)
    {

            for(int i =0; i<4;i++)
            {p.new_Xpoints[i] = iX(newx + p.org_xpoints[i]);
             p.new_Ypoints[i] = iY(newy + p.org_ypoints[i]);
            }

    }
    
    void movePolyBy(poly p,float x,float y)
    {

       //System.out.println(stopmoving);
      //System.out.println("new pos");
       poly dummyp = new poly();

          for(int i =0; i<4;i++)
            {dummyp.new_Xpoints[i] = iX(x + fx(p.new_Xpoints[i]));
             dummyp.new_Ypoints[i] = iY(y + fy(p.new_Ypoints[i]));
             
            }
            if (!checkCollision(dummyp))
            {
                for(int i =0; i<4;i++)
                {p.new_Xpoints[i] = dummyp.new_Xpoints[i];
                 p.new_Ypoints[i] = dummyp.new_Ypoints[i];
                }                
            }
            repaint();
        
    }
    
    boolean checkCollision(poly p)
    {
            if(isColliding(p))
            {   poly fp = new poly(); 
                    fp = curShape;
                    filled.addElement(fp);
                    changeCurShape();
                    for(int v =0; v<4; v++)
                    { if(p.new_Ypoints[v]<iY(200))
                      { gameEnded = true; System.exit(0);                
                      }
                    }
                    randomNextShape();  
                return true;
            }
            return false;
    }
    
    void rotatePolyBy(poly p, boolean clockwise)
    {  float[] pointVec = {0,0};
       float[] newpointVec = {0,0};
       float[][] rotationMat = {{0,1},{-1,0}};
           
       if(!clockwise)
       {
           rotationMat[0][1]=-1;
           rotationMat[0][1]=1;
       }

       
        float startx = fx(p.new_Xpoints[0])-p.org_xpoints[0];
        float starty = fy(p.new_Ypoints[0])-p.org_ypoints[0];
        System.out.println("new Vertex");
              poly dummyp = new poly();
       for(int v =0; v<4;v++)
       {    
          // System.out.println("new Vertex");

           pointVec[0] = p.org_xpoints[v];
           pointVec[1] = p.org_ypoints[v];
            newpointVec[0]=0;newpointVec[1]=0;
            
            //System.out.println("Before "+pointVec[0]+","+pointVec[1]);
            
            for(int i=0;i<2;i++)
            {    for(int k=0;k<2;k++)
                {newpointVec[i] += rotationMat[i][k] * pointVec[k];
                }               
            }
            
            dummyp.org_xpoints[v]= newpointVec[0];
            dummyp.org_ypoints[v]= newpointVec[1];
            
            //System.out.println("After "+newpointVec[0]+","+newpointVec[1]);
            
            dummyp.new_Xpoints[v] = iX(dummyp.org_xpoints[v] + startx);
            dummyp.new_Ypoints[v] = iY(dummyp.org_ypoints[v] + starty);          
       }
       
            if (!checkCollision(dummyp))
            {
                for(int i =0; i<4;i++)
                {
                    
                  p.org_xpoints[i] = dummyp.org_xpoints[i];  
                  p.org_ypoints[i] = dummyp.org_ypoints[i];    
                  p.new_Xpoints[i] = dummyp.new_Xpoints[i];
                  p.new_Ypoints[i] = dummyp.new_Ypoints[i];
                }                
            }
            repaint();

    }

    boolean pixelSizeChanged =true;
    boolean gamePaused =false;
    boolean stopmoving =false;

    void resizeFilledShapes()
    {
        int n = filled.size();
        
        
        if (n>0)
        {
            for (int i=0; i<n; i++)
            {  poly fp = (poly)(filled.elementAt(i));
               poly fp1 = (poly)(filled.elementAt(i));
               
               
               
               for(int j=0;j<4;j++)
               {fp.new_Xpoints[j] = iX(fx_old(fp.new_Xpoints[j]));
                fp.new_Ypoints[j] = iY(fy_old(fp.new_Ypoints[j]));
                System.out.println(fp.new_Xpoints[j]+","+fp.new_Ypoints[j]);
                System.out.println(fp1.new_Xpoints[j]+","+fp1.new_Ypoints[j]);
               }
            }
        }
        
    }
    
    public void paint(Graphics g) {        
        
        initgr();
        if(pixelSizeChanged)
        {   setGUI();              
            movePolyTo(nextShape,150, 175);
            movePolyTo(curShape,-100, 200);
            resizeFilledShapes();
            stopmoving =false;        
            pixelSizeChanged = false;
        }
       
        g.drawRect(gameRec.left,gameRec.top,gameRec.width,gameRec.height); 
        g.drawRect(quit.left,quit.top,quit.width,quit.height);
        g.setFont(new Font("TimesRoman", Font.BOLD, 19));
        g.drawString("QUIT", quit.left+iWH(25), quit.top+iWH(30));
             
        g.drawRect(nextBox.left,nextBox.top,nextBox.width,nextBox.height);
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
	g.drawString("Level: "+0, levelP.x, levelP.y);
	g.drawString("Lines: "+0, linesP.x, linesP.y);
	g.drawString("Score: "+0, scoreP.x, scoreP.y);

        if(pauseVisible)
        {   g.drawRect(pause.left,pause.top,pause.width,pause.height);
            g.setFont(new Font("TimesRoman", Font.BOLD, 19));
            g.drawString("PAUSE", pause.left+iWH(15), pause.top+iWH(30));
        }      
        
        nextShape.draw(g);
        curShape.draw(g);

        int n = filled.size();
       
        if (n>0)
        {
            for (int i=0; i<n; i++)
            {  poly fp = (poly)(filled.elementAt(i));
               fp.draw(g);
            }
        }
        
      
    }
    
    public Timer timer = new Timer();
    private class TTask extends TimerTask {
            @Override
            public void run() {
                           movePolyBy(curShape,0,-5.0f);
                           //repaint();
            }
    }
    
    public TTask task = new TTask();

    private static final class Lock { }
    private final Object lock = new Lock();

    boolean isWakeupNeeded = true;
    public void pause() {
       
        synchronized (this.timer) {

            try {
                this.timer.wait(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(gameCanvas.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
        }

    

    public void resume() {
        synchronized (this.timer) {
            this.timer.notifyAll();
        }
    }
    boolean gameEnded = false;
    boolean isColliding(poly p)
    {
        //System.out.println("Calling is Colliding");
        //boolean colliding = false;
        

        for(int v=0;v<4;v++)
        {
            
            //System.out.println("Checking Vertex "+v+"for box");
            if(!gameRec.contains(p.new_Xpoints[v],p.new_Ypoints[v]))
                return true;
        }
        
        int n = filled.size();
        //System.out.println("n "+n);
        if (n>0)
        {
            Polygon polygon1 = new Polygon(p.new_Xpoints,p.new_Ypoints,4);
            
            Area area1 = new Area(polygon1);
            for (int i=0; i<n; i++)
            {  //System.out.println("for polygon "+i);
                    poly fp = (poly)(filled.elementAt(i));
                    Polygon polygon2 = new Polygon(fp.new_Xpoints,fp.new_Ypoints,4);
                    Area area2 = new Area(polygon2);
                    area2.intersect(area1);
                    if(!area2.isEmpty())
                    {return true;}
                    
                  
            }
            
            
            /*System.out.println("n>0");
            //for each vertex, check if it is inside any one polygon
            for(int v=0;v<4;v++)
            {
                System.out.println("Checking Vertex "+v);
                Point vertex = new Point(p.new_Xpoints[v],p.new_Ypoints[v]);
                for (int i=0; i<n; i++)
                {  System.out.println("for polygon "+i);
                    poly fp = (poly)(filled.elementAt(i));
                    if(fp.contains(vertex))
                    { return true;
                    }
                    
                }
            }
                    */
            
        }    
        return false;
    }
    
    public boolean containsIn(int left,int top, int width, int height, int px, int py)
    {  
        if(px>=left && px<=left+width &&
           py>=top && py<=top+height)
           return true;
        else
            return false;       
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        System.out.println("mouseWheelMoved");
       int notches = mwe.getWheelRotation();
       if (notches < 0) {
           //fwd scroll - rotate clockwise
           rotatePolyBy(curShape,true);
           repaint();
       } else {
           //bck scroll - rotate anticlockwise
           rotatePolyBy(curShape,false);
           repaint();
       }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("mouseClicked");
        int mx = me.getX();int my = me.getY();
       
        if(gameRec.contains(mx,my))
        {   if(!gamePaused)
            {gamePaused = true;pause();}
            else
            {gamePaused = false;resume();}
            
        }
        else if(quit.contains(mx,my))
                System.exit(0);
            else
            {   if(!gamePaused)
                {System.out.println(me.getModifiers()+","+MouseEvent.BUTTON1);
                    if(me.getModifiers()==InputEvent.BUTTON1_MASK) 
                    {
                       System.out.println("Left button");
                       movePolyBy(curShape,-5,0);
                       //repaint();
                    }

                    if(me.getModifiers()==MouseEvent.BUTTON3_MASK) 
                    {
                       System.out.println("Right button");
                       movePolyBy(curShape,5,0);
                       //repaint();
                    }
                }
            }
        }
    

    @Override
    public void mousePressed(MouseEvent me) {

       System.out.println("mouse Pressed");

    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        System.out.println("mouseExited");
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        System.out.println("mouseDragged");
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        //System.out.println("mouseMoved");
        pauseVisible = false;
        if(gameRec.contains(me.getX(),me.getY()))
            pauseVisible = true;
        repaint();
        
    }
}
class box extends Component
{
    public int left,right,top,bottom;
    public int height,width;
    
    box()
    {
        left=0;top=0;height=1;width=1; right =1;bottom =1;
    }
    public void set(int l,int t,int w, int h)
    {   left =l; top =t;
        width =w; height =h;
        right = left+width;
        bottom = top+height;
    }

    public boolean contains(int px, int py)
    {   if(px>left && px<right &&
           py>top && py<bottom)
           return true;
        else
            return false;       
    }
}
    class poly
    {public float[] org_xpoints={0,0,0,0};
     public float[] org_ypoints={0,0,0,0};
     public int[] new_Xpoints={0,0,0,0};
     public int[] new_Ypoints={0,0,0,0};
     public int npoints=4;
     Color c= Color.yellow;
     
     poly()
     {
     }

     void set_org(float x0,float y0,float x1,float y1,float x2,float y2,float x3,float y3,Color c)
     {
         org_xpoints[0]=x0;     org_ypoints[0]=y0;
         org_xpoints[1]=x1;     org_ypoints[1]=y1;
         org_xpoints[2]=x2;     org_ypoints[2]=y2;
         org_xpoints[3]=x3;     org_ypoints[3]=y3;  
         this.c = c;
     }
     
    void copy_org(poly p)
    {set_org(p.org_xpoints[0],p.org_ypoints[0],p.org_xpoints[1],p.org_ypoints[1],
         p.org_xpoints[2],p.org_ypoints[2],p.org_xpoints[3],p.org_ypoints[3],p.c);
    }
    
    void draw(Graphics g)
    {
        //g.setColor(Color.yellow);
        g.setColor(c);
        g.fillPolygon(new_Xpoints, new_Ypoints, 4);
        g.setColor(Color.black);
        g.drawPolygon(new_Xpoints, new_Ypoints, 4);
        g.drawPolygon(new_Xpoints, new_Ypoints, 3);
    }  
    
    public boolean contains(Point test) 
    {
      int i;
      int j;
      boolean result = false;
      
      //System.out.println("inside contains");
      
      for (i = 0, j = 3; i < 4; j = i++) {
        if ((new_Ypoints[i] > test.y) != (new_Ypoints[j] > test.y) &&
            (test.x < (new_Xpoints[j] - new_Xpoints[i]) * (test.y - new_Ypoints[i]) / 
                (new_Ypoints[j]-new_Ypoints[i]) + new_Xpoints[i])) 
        {
          result = true;
        }
      }
      //System.out.println("result"+result);
      return result;
    }
      

}
