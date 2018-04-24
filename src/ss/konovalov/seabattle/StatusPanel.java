package ss.konovalov.seabattle;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

    private JLabel allPlayerShipStatus;
    private JLabel allPCShipStatus;
    private JLabel playerKillShip;
    private JLabel PCKillShip;
    private static StatusPanel st;


    private StatusPanel(){

        setPreferredSize(new Dimension(150,300));
        allPlayerShipStatus = new JLabel("Корабли игрока : ");
        allPCShipStatus = new JLabel("Корабли противника: ");
        playerKillShip = new JLabel("Игрок потопил: ");
        PCKillShip = new JLabel("Противник потопил: ");
        this.add(allPlayerShipStatus);
        this.add(allPCShipStatus);
        this.add(playerKillShip);
        this.add(PCKillShip);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public static StatusPanel createStatusPanel () {
        if (st == null) st = new StatusPanel();

        return st;
    }
}
