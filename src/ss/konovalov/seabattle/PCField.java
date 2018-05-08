package ss.konovalov.seabattle;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;


public class PCField extends GameField implements ActionListener, MouseInputListener {
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
    private static PCField pcField;
    private Color statusShip;
    private char[][] saveToFieldShips;


    private PCField(){
        drawField = new DrawField();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        pcLogic = new Logic();
        pcShips  = new Ship().addTypeShips();
        pcPositionPoint = new Point();
        addMouseListener(this);
        repaintTimer = new Timer(50,this);
        repaintTimer.start();
        isPositionList = new ArrayList<>();
        pcListPoint = new ArrayList<>();
        listTypeShips = new ArrayList<>();
        addPCAllShips();
    }

    public static PCField createPCField(){
        if (pcField == null) pcField = new PCField();
        return pcField;
    }

    public char[][] getPCShip(){
        return pcLogic.getSaveShip();
    }

    private void addPCAllShips(){
        Random randomPosition = new Random();
        Random randomPoint = new Random();
        for (int i = 0; i < pcShips.length-1; i++) {
            isPCPosition = randomPosition.nextBoolean();
            pcPositionPoint.x = randomPoint.nextInt(300);
            pcPositionPoint.y = randomPoint.nextInt(300);
            if (pcLogic.isAccessSetShip(pcShips[i],pcPositionPoint, isPCPosition)){
                pcLogic.addAllShips(pcShips[i], pcPositionPoint, isPCPosition);
                /*isPositionList.add(isPCPosition);
                pcListPoint.add(new Point (pcPositionPoint));
                listTypeShips.add(pcShips[i]);*/
            }
            else{
                if (i >= -1) --i;
            }
        }
        isPCReady = true;
        saveToFieldShips = getPCShip();
    }


/*    public void testSeeShip(){
        for (int i = 0; i < saveToFieldShips.length; i++) {
            for (int j = 0; j < saveToFieldShips.length; j++) {
                System.out.print(saveToFieldShips[j][i]);
            }
            System.out.println();
        }
    }*/

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (drawField != null) {
            drawField.drawGridFiled(g);
            //Временная хрень, для тестирования визульного вывода корабля на поле PC.
            drawField.setShipToField(g,pcListPoint,isPositionList,listTypeShips);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isPlayerReady) {
            if (e.getButton() == MouseEvent.BUTTON1) {

                switch (pcLogic.shot(e.getPoint())){
                    case 0:
                        System.out.println("Мимо");
                        break;
                    case 1:
                        System.out.println("убил");
                        break;
                    case -1:
                        System.out.println("ранил");
                }
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
