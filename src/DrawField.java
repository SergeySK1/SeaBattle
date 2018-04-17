
import java.awt.*;
import java.util.LinkedList;


public class DrawField  {

    private static final int WIDTH = 301;
    private static final int HEIGHT = 301;
    private static final int ONESTEP = 30;

   private Point coordinatesPoint;
   private LinkedList<Point> listCoordinatesPoint;

   public DrawField (){
       coordinatesPoint = new Point();
   }


    public void drawGridFiled (Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0,0,WIDTH+1,HEIGHT+1);
        g.setColor(Color.YELLOW);
        for (int i = 0; i <= WIDTH; i += ONESTEP){
            g.drawLine(0, i, WIDTH, i);
        }

        for (int i = 0; i <= HEIGHT; i += ONESTEP){
            g.drawLine(i,0,i,HEIGHT);
        }
    }

}
