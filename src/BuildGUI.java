import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuildGUI {
   private JFrame startFrame;
    private JPanel basePanel;
    private JButton startButton;
    private JButton exitButton;

    public BuildGUI(){
        startFrame = new JFrame("SeaBattle");
        startFrame.setSize(new Dimension(800,400));
        startFrame.setVisible(true);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void buildingFormGUI() {

        startButton = new JButton("START");
        exitButton = new JButton("EXIT");
        startFrame.add(startButton, BorderLayout.AFTER_LAST_LINE);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setVisible(false);
                basePanel = new JPanel();
                basePanel.setBackground(Color.BLACK);
                basePanel.setLayout(new FlowLayout());
                GameField playerField = new GameField();
                GameField playerField1 = new GameField();
                startFrame.add(basePanel);
                basePanel.add(playerField);
                basePanel.add(StatusPanel.createStatusPanel());
                basePanel.add(playerField1);
                basePanel.add(exitButton);
                exitButton.addActionListener((n) -> System.exit(0));

            }
        });



    }
}
