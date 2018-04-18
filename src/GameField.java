import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;



public class GameField extends JPanel implements ActionListener, MouseMotionListener, MouseInputListener{

    private static final int WIDTH = 301;
    private static final int HEIGHT = 301;

    private int countPressedGameField = 0;
    private ArrayList<Integer> listTypeShip = new ArrayList<>();;
    private Ship ship = new Ship();
    private int [] ships = ship.addTypeShips();
    private ArrayList<Point> listPoints;
    private Point positionPoint;
    private ArrayList<Boolean> isVerticalList;
    private boolean isVertical;
    private  DrawField drawField;
    private Timer timerRepaint = new Timer(50,this);
    Logic lo = new Logic();

    public GameField(){
        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        timerRepaint.start();
        listTypeShip.add(ships[countPressedGameField]);
        drawField = new DrawField();
        listPoints = new ArrayList<>();
        positionPoint = new Point();
        isVerticalList = new ArrayList<>();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (drawField != null){
            drawField.drawGridFiled(g);
            drawField.setShipToField(g,listPoints,isVerticalList,listTypeShip);
            drawField.movedShipToCoursor(g,countPressedGameField,isVertical,listTypeShip,ships, positionPoint);
        }
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        positionPoint.x = e.getX();
        positionPoint.y = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (countPressedGameField < 10) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                positionPoint.x = e.getX();
                positionPoint.y = e.getY();
                listPoints.add(new Point(positionPoint));
                listTypeShip.add(ships[++countPressedGameField]);
                isVerticalList.add(isVertical);
                lo.addAllShips(listTypeShip,listPoints,isVerticalList);

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) isVertical = !isVertical;
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
}
