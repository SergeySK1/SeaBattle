import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Logic {

    private static final int ONESTEP = 30;

    private char[][] saveShip;


    public Logic(){
        saveShip = new char[300][300];
    }

    public void addAllShips (ArrayList<Integer> listShips, ArrayList<Point> listPoint, ArrayList<Boolean> isPosition){
        int minX =0;
        int minY =0;
        int typeShip = -1;

        for (int i = 0; i < listPoint.size(); i++) {
            minX = (listPoint.get(i).x / ONESTEP) * ONESTEP;
            minY = (listPoint.get(i).y / ONESTEP) * ONESTEP;
            typeShip = listShips.get(i);
            if (!isPosition.get(i)) {
                switch (listShips.get(i)) {
                    case 4:
                        for (int j = minX; j < minX + ONESTEP; j++) {
                            for (int k = minY; k < (minY +ONESTEP) * typeShip; k++) {
                                saveShip[j][k] = 52;
                            }
                        }
                        break;
                }
            }
        }
        for (int i = 0; i < saveShip.length; i++) {
            for (int j = 0; j < saveShip.length; j++) {
                System.out.print(saveShip[i][j]);
            }
            System.out.println();
        }



        }
    }

