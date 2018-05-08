package ss.konovalov.seabattle;

import javax.swing.*;
import java.awt.*;

public abstract class GameField extends JPanel {

    protected static boolean isPCReady = false;
    protected static boolean isPlayerReady = false;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
