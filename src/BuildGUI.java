import javax.swing.*;
import java.awt.*;

public class BuildGUI {
    JFrame startFrame;
    Panel basePanel;

    public BuildGUI(){
        startFrame = new JFrame("SeaBattle");
        startFrame.setSize(new Dimension(700,400));
        startFrame.setVisible(true);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void buildingFormGUI() {
        basePanel = new Panel();
        basePanel.setBackground(Color.BLACK);
        startFrame.add(basePanel);
        basePanel.setLayout(new FlowLayout());
        GameField playerField = new GameField();
        GameField playerField1 = new GameField();
        playerField.setBackground(Color.BLACK);
        playerField1.setBackground(Color.RED);
        basePanel.add(playerField);
        basePanel.add(playerField1);

    }
}
