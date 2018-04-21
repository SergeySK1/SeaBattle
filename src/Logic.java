import java.awt.*;
import java.util.function.ToDoubleBiFunction;

public class Logic {

    private static final int ONESTEP = 30;

    private char[][] saveShip;


    public Logic() {
        saveShip = new char[10][10];
    }

    public void addAllShips(int ships, Point positionPoint, boolean isPosition) {
        for (int i = 0; i < ships; i++) {
            if (isPosition) {
                switch (ships) {
                    case 4:
                        saveShip[positionPoint.x / ONESTEP][(positionPoint.y / ONESTEP) + i] = 52;
                        break;
                    case 3:
                        saveShip[positionPoint.x / ONESTEP][(positionPoint.y / ONESTEP) + i] = 51;
                        break;
                    case 2:
                        saveShip[positionPoint.x / ONESTEP][(positionPoint.y / ONESTEP) + i] = 50;
                        break;
                    case 1:
                        saveShip[positionPoint.x / ONESTEP][(positionPoint.y / ONESTEP) + i] = 49;
                        break;
                }
            } else {
                switch (ships) {
                    case 4:
                        saveShip[(positionPoint.x / ONESTEP) + i][positionPoint.y / ONESTEP] = 52;
                        break;
                    case 3:
                        saveShip[(positionPoint.x / ONESTEP) + i][positionPoint.y / ONESTEP] = 51;
                        break;
                    case 2:
                        saveShip[(positionPoint.x / ONESTEP) + i][positionPoint.y / ONESTEP] = 50;
                        break;
                    case 1:
                        saveShip[(positionPoint.x / ONESTEP) + i][positionPoint.y / ONESTEP] = 49;
                        break;

                }
            }
        }
    }

    // TODO Переодически выходит за предел массива, разобраться, допилить.
    public boolean isAccessSetShip(int ships, Point positionPoint, boolean isPosition) {
        if (positionPoint.x != 0 && positionPoint.y != 0) {
            if (isPosition) {
                for (int i = (positionPoint.x / ONESTEP) - 1; i < ((positionPoint.x / ONESTEP) - 1) + ships + 2; i++) {
                    for (int j = (positionPoint.y / ONESTEP) - 1; j < ((positionPoint.y / ONESTEP) - 1) + ships + 2; j++) {
                        if (saveShip[i][j] != 0) return false;
                    }
                }
            } else {
                for (int i = (positionPoint.y / ONESTEP) - 1; i < ((positionPoint.x / ONESTEP) - 1) + ships + 2; i++) {
                    for (int j = (positionPoint.x / ONESTEP) - 1; j < ((positionPoint.y / ONESTEP) - 1) + ships + 2; j++) {
                        if (saveShip[i][j] != 0) return false;
                    }
                }
            }
        }
        return true;
    }
}