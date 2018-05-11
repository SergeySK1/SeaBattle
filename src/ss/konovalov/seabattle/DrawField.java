package ss.konovalov.seabattle;

import java.awt.*;
import java.util.ArrayList;



public class DrawField  {

    private static final int WIDTH = 301;
    private static final int HEIGHT = 301;
    private static final int ONESTEP = 30;
    private static final Color KILL_COLOR = Color.red;
    private static final Color WOUNDED_COLOR = Color.GRAY;
    private static final Color PAST_COLOR = Color.WHITE;




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

    public void movedShipToCoursor (Graphics g, int countPress, boolean isPosition, ArrayList<Integer> listTypeShip, int[] ships, Point coordPoint, Color color){
        g.setColor(color);
        if (countPress <= ships.length) {
            if (!isPosition) {
            	if ((coordPoint.x/ONESTEP) * ONESTEP + (ONESTEP * listTypeShip.get(countPress)) <= WIDTH){
                    g.fillRect((coordPoint.x / ONESTEP) * ONESTEP, (coordPoint.y / ONESTEP) * ONESTEP,
                            ONESTEP * listTypeShip.get(countPress), ONESTEP);
            	}
            }
            else{
            	if ((coordPoint.y/ONESTEP) * ONESTEP + (ONESTEP * listTypeShip.get(countPress)) <= HEIGHT){
                    g.fillRect((coordPoint.x / ONESTEP) * ONESTEP, (coordPoint.y / ONESTEP) * ONESTEP,
                            ONESTEP, ONESTEP * listTypeShip.get(countPress));
            	}
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

    public void statusBattleField(Graphics g, ArrayList<Integer> codeShot, ArrayList<Point> shotPoint){
        for (int i = 0; i < shotPoint.size(); i++) {

            if (codeShot.get(i) == 0) {
                g.setColor(PAST_COLOR);
                g.fillRect(((shotPoint.get(i).x /ONESTEP ) * ONESTEP)+10, ((shotPoint.get(i).y /ONESTEP ) * ONESTEP)+10, ONESTEP-20, ONESTEP-20);
            } else if (codeShot.get(i) == -1) {
                g.setColor(WOUNDED_COLOR);
                g.fillRect((shotPoint.get(i).x / ONESTEP) * ONESTEP, (shotPoint.get(i).y / ONESTEP) * ONESTEP, ONESTEP, ONESTEP);
            } else {
                g.setColor(KILL_COLOR);
                g.fillRect((shotPoint.get(i).x / ONESTEP) * ONESTEP, (shotPoint.get(i).y / ONESTEP) * ONESTEP, ONESTEP, ONESTEP);
                System.out.println("kill");
            }
        }
    }
}
