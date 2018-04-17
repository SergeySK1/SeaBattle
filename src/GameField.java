import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;



public class GameField extends JPanel implements ActionListener, MouseMotionListener, MouseInputListener{

    private static final int ONESTEP = 30;
    private static final int WIDTH = 301;
    private static final int HEIGHT = 301;

    private static int indexToX;
    private static int indexToY;


    static int countPressedGameField = 0;
    static ArrayList<Integer> listTypeShip;
    static Ship ship = new Ship();
    int [] ships = ship.addTypeShips();
    static ArrayList<Point> p = new ArrayList<>();
    Point po = new Point();
    static ArrayList<Boolean> isVerticalList = new ArrayList<>();
    static boolean isVertical = false;
    DrawField drawField;


    Timer t = new Timer(50,this);

    public GameField(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        t.start();
        listTypeShip = new ArrayList<>();
        addMouseListener(this);
        addMouseMotionListener(this);
        drawField = new DrawField();


    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (drawField != null){
            drawField.drawGridFiled(g);
        }
        //если координаты были получены, отрисовываем корабль, по координате из листа
        if (p.size() > 0) {

            for (int i = 0; i < p.size(); i++) {

                if (!isVerticalList.get(i)) {

                    g.fillRect((p.get(i).x / ONESTEP) * ONESTEP, (p.get(i).y / ONESTEP) * ONESTEP,
                            ONESTEP * listTypeShip.get(i), ONESTEP);
                }
                else {
                    g.fillRect((p.get(i).x / ONESTEP) * ONESTEP, (p.get(i).y / ONESTEP) * ONESTEP,
                            ONESTEP, ONESTEP * listTypeShip.get(i));
                }
            }
        }
        //Динамическая прорисовка корабля, следящего за курсором, для поиска координат на поле
                g.setColor(Color.BLACK);
                if (countPressedGameField < ships.length) {
                    if (!isVertical) {
                        for (int i = 0; i < listTypeShip.size(); i++) {

                            g.fillRect((indexToX / ONESTEP) * ONESTEP, (indexToY / ONESTEP) * ONESTEP,
                                    ONESTEP * listTypeShip.get(i), ONESTEP);
                            System.out.print(listTypeShip.get(i));
                        }
                    }
                    else{

                        for (int i = 0; i < listTypeShip.size(); i++) {

                            g.fillRect((indexToX / ONESTEP) * ONESTEP, (indexToY / ONESTEP) * ONESTEP,
                                    ONESTEP, ONESTEP * listTypeShip.get(i));
                        }
                    }

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
        indexToX = e.getX();
        indexToY = e.getY();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //собираем кординаты, + наполняем лист кораблями из Ships
        if (countPressedGameField < 10) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                po.x = e.getX();
                po.y = e.getY();
                p.add(new Point(po));
            //    System.out.println(countPressedGameField);
                listTypeShip.add(ships[countPressedGameField++]);
                isVerticalList.add(isVertical);

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
