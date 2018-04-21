

import java.awt.*;
import java.util.ArrayList;



public class DrawField  {

    private static final int WIDTH = 301;
    private static final int HEIGHT = 301;
    private static final int ONESTEP = 30;




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

    public void movedShipToCoursor (Graphics g, int countPress, boolean isPosition, ArrayList<Integer> listTypeShip, int[] ships, Point coordPoint){
        g.setColor(Color.BLACK);
        if (countPress <= ships.length) {
            if (!isPosition) {
                    g.fillRect((coordPoint.x / ONESTEP) * ONESTEP, (coordPoint.y / ONESTEP) * ONESTEP,
                            ONESTEP * listTypeShip.get(countPress), ONESTEP);
            }
            else{
                    g.fillRect((coordPoint.x / ONESTEP) * ONESTEP, (coordPoint.y / ONESTEP) * ONESTEP,
                            ONESTEP, ONESTEP * listTypeShip.get(countPress));
            }
        }
    }

    public void setShipToField(Graphics g, ArrayList<Point> listPoints, ArrayList<Boolean> isPositionList, ArrayList<Integer> listTypeShip ){
        if (listPoints.size() > 0) {
            g.setColor(Color.YELLOW);
            for (int i = 0; i < listPoints.size(); i++) {
                if (!isPositionList.get(i)) {
                    g.fillRect((listPoints.get(i).x / ONESTEP) * ONESTEP, (listPoints.get(i).y / ONESTEP) * ONESTEP,
                            ONESTEP * listTypeShip.get(i), ONESTEP);

                }
                else {
                    g.fillRect((listPoints.get(i).x / ONESTEP) * ONESTEP, (listPoints.get(i).y / ONESTEP) * ONESTEP,
                            ONESTEP, ONESTEP * listTypeShip.get(i));
                }
            }
        }
    }
}
