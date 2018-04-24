package ss.konovalov.seabattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class PCField extends GameField implements ActionListener {
    private static final int WIDTH = 301;
    private static final int HEIGHT = 301;

    private DrawField drawField;
    private Timer repaintTimer;
    private int[] pcShips;
    private Point pcPositionPoint;
    private boolean isPCPosition;
    private Logic pcLogic;
    private ArrayList<Boolean>isPositionList;
    private ArrayList<Point>pcListPoint;
    private ArrayList<Integer>listTypeShips;


    public PCField(){
        drawField = new DrawField();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        pcLogic = new Logic();
        pcShips  = new Ship().addTypeShips();
        pcPositionPoint = new Point();
        repaintTimer = new Timer(50,this);
        repaintTimer.start();
        isPositionList = new ArrayList<>();
        pcListPoint = new ArrayList<>();
        listTypeShips = new ArrayList<>();
        addPCAllShips();
    }

    private void addPCAllShips(){
        Random randomPosition = new Random();
        Random randomPointX = new Random();
        Random randomPointY = new Random();
        for (int i = 0; i < pcShips.length-1; i++) {
            isPCPosition = randomPosition.nextBoolean();
            pcPositionPoint.x = randomPointX.nextInt(300);
            pcPositionPoint.y = randomPointY.nextInt(300);
            if (pcLogic.isAccessSetShip(pcShips[i],pcPositionPoint, isPCPosition)){
                pcLogic.addAllShips(pcShips[i], pcPositionPoint, isPCPosition);
                isPositionList.add(isPCPosition);
                pcListPoint.add(new Point (pcPositionPoint));
                listTypeShips.add(pcShips[i]);

            }
            else{
                if (i != 0) --i;
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (drawField != null) {
            drawField.drawGridFiled(g);
            //временная хрень, для тестирования автоматической расстоновки кораблей PC
            drawField.setShipToField(g,pcListPoint,isPositionList,listTypeShips);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
