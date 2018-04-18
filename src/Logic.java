import java.awt.*;
import java.util.ArrayList;


public class Logic {

    private static final int ONESTEP = 30;

    private char[][] saveShip;
    char f ='d';

    public Logic(){
        saveShip = new char[300][300];
    }

    public void addAllShips (ArrayList<Integer> listShips, ArrayList<Point> listPoint){

        for (int i = 0; i < listPoint.size(); i++) {

           saveShip[(listPoint.get(i).x / ONESTEP) * ONESTEP][(listPoint.get(i).y / ONESTEP) * ONESTEP] = 'd';

        }


        }
    }

