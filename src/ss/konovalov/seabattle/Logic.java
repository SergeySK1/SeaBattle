package ss.konovalov.seabattle;

import java.awt.*;

public class Logic {

    private static final int ONESTEP = 30;

    private char[][] saveShip;
    private int stepStartPositionX = 0;
    private int stepStartPositionY = 0;
    private int stepLastPosition = 0;
    private int stepScanningShip = 0;

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


    public boolean isAccessSetShip(int ships, Point positionPoint, boolean isPosition) {
        scanningPosition(ships,positionPoint,isPosition);
            if (isPosition && positionPoint.y/ONESTEP + ships <= saveShip.length) {
                for (int i = (positionPoint.x / ONESTEP) - stepStartPositionX; i < ((positionPoint.x / ONESTEP) - stepStartPositionX) + stepLastPosition; i++) {
                    for (int j = (positionPoint.y / ONESTEP) - stepStartPositionY; j < ((positionPoint.y / ONESTEP) - stepStartPositionY) + ships + stepScanningShip; j++) {
                    	if (saveShip[i][j] != 0) return false;
                    }
                }
                return true;
            } else if (!isPosition && positionPoint.x/ONESTEP + ships <= saveShip.length){
                for (int i = (positionPoint.x/ ONESTEP) - stepStartPositionX; i < ((positionPoint.x / ONESTEP) - stepStartPositionX) + ships + stepScanningShip; i++) {
                    for (int j = (positionPoint.y/ ONESTEP) - stepStartPositionY; j < ((positionPoint.y / ONESTEP) - stepStartPositionY) + stepLastPosition; j++) {
                    	if (saveShip[i][j] != 0) return false;
                    }
                }
                return true;
            }
        return false;
    }

    private void scanningPosition (int ships, Point positionPoint, boolean isPosition){
        if (positionPoint.x/ONESTEP == 0 && positionPoint.y/ONESTEP == 0) {
            stepStartPositionX = 0;
            stepStartPositionY =0;
            stepLastPosition = 2;
            stepScanningShip = 1;
        }
        else if (positionPoint.x/ONESTEP == 0 && positionPoint.y/ONESTEP != 9 && isPosition){
            stepStartPositionX = 0;
            stepStartPositionY =1;
            stepLastPosition = 2;
            stepScanningShip = 2;
        }
        else if (positionPoint.y/ONESTEP == 0 && positionPoint.x/ONESTEP != 9 && isPosition){
            stepStartPositionX = 1;
            stepStartPositionY =0;
            stepLastPosition = 3;
            stepScanningShip = 1;
        }
        else if (positionPoint.x/ONESTEP == 0 && positionPoint.y/ONESTEP != 9 && !isPosition){
            stepStartPositionX = 0;
            stepStartPositionY =1;
            stepLastPosition = 3;
            stepScanningShip = 1;
        }
        else if (positionPoint.y/ONESTEP == 0 && positionPoint.y/ONESTEP != 9 && !isPosition){
            stepStartPositionX = 1;
            stepStartPositionY =0;
            stepLastPosition = 2;
            stepScanningShip = 2;
        }
        else if (positionPoint.x/ONESTEP == 9 && positionPoint.y/ONESTEP == 9){
            stepStartPositionX = 1;
            stepStartPositionY =1;
            stepLastPosition = 2;
            stepScanningShip = 1;
        }
        else if (positionPoint.y/ONESTEP == 9 && positionPoint.x/ONESTEP != 0 && isPosition){
            stepStartPositionX = 1;
            stepStartPositionY =1;
            stepLastPosition = 3;
            stepScanningShip = 1;
        }
        else if (positionPoint.x/ONESTEP == 9 && positionPoint.y/ONESTEP != 0 && isPosition){
            stepStartPositionX = 1;
            stepStartPositionY =1;
            stepLastPosition = 2;
            stepScanningShip = 2;
        }
        else if (positionPoint.y/ONESTEP == 9 && positionPoint.x/ONESTEP != 0 && !isPosition){
            stepStartPositionX = 1;
            stepStartPositionY =1;
            stepLastPosition = 2;
            stepScanningShip = 2;
        }
        else if (positionPoint.x/ONESTEP == 9 && positionPoint.y/ONESTEP != 0 && !isPosition){
            stepStartPositionX = 1;
            stepStartPositionY =1;
            stepLastPosition = 3;
            stepScanningShip = 1;
        }
        else if (positionPoint.x/ONESTEP == 9){
            stepStartPositionX = 1;
            stepStartPositionY =0;
            stepLastPosition = 2;
        }
        else if (positionPoint.y/ONESTEP == 9){
            stepStartPositionX = 0;
            stepStartPositionY =1;
            stepLastPosition = 2;
        }
        else{
            stepStartPositionX = 1;
            stepStartPositionY =1;
            stepLastPosition = 3;
            stepScanningShip = 2;
        }
        if (positionPoint.x/ONESTEP + ships == saveShip.length && !isPosition){
            stepScanningShip = 1;
        }
        else if(positionPoint.y/ONESTEP + ships == saveShip.length && isPosition){
            stepScanningShip = 1;
        }
    }

    public char [][] getSaveShip(){
        return saveShip;
    }

    public int shot (Point shotPoint){
        if (saveShip[shotPoint.x/ONESTEP][shotPoint.y/ONESTEP] != 0){
            return killOrWounded(shotPoint.x/ONESTEP, shotPoint.y/ONESTEP) ? 1 : -1;
        }

            return 0;
    }

    public boolean killOrWounded(int x, int y){
        if (x == 0 && y == 0) {
            if (saveShip[x+1][y]==0
                    && saveShip[x][y+1]==0){
                return true;
            }
            else{
                return false;
            }
        }
        else if (x == 0 && y != 9){
            if (saveShip[x][y+1]==0
                    && saveShip[x][y-1]==0
                    && saveShip[x+1][y]==0){
                return true;
            }
            else{
                return false;
            }
        }
        else if (x != 9 && y ==0){
            if (saveShip[x-1][y]==0
                    && saveShip[x+1][y]==0
                    && saveShip[x][y+1]==0){
                return true;
            }
            else{
                return false;
            }
        }
     else if (x == 9 && y == 9){
            if (saveShip[x-1][y] == 0
                    && saveShip[x][y-1]==0){
                return true;
            }
            else{
                return false;
            }
        }
        else if (x != 9 && y == 9){
         if (saveShip[x+1][y]==0
                 && saveShip[x-1][y]==0
                 && saveShip[x][y-1]==0){
             return true;
         }
         else{
             return false;
         }
        }
        else if (x == 9 && y != 9){
            if (saveShip[x][y-1]==0
                    && saveShip[x][y+1]==0
                    && saveShip[x-1][y]==0){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if (saveShip[x][y+1]==0
                    && saveShip[x][y-1]==0
                    && saveShip[x-1][y]==0
                    && saveShip[x+1][y]==0) return true;
        }
        return false;
    }
}