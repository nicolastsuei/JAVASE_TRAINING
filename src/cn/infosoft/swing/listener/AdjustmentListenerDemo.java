package cn.infosoft.swing.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdjustmentListenerDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public AdjustmentListenerDemo(){
        prepareGUI();
    }

    public static void main(String[] args){
        AdjustmentListenerDemo  swingListenerDemo = new AdjustmentListenerDemo();
        swingListenerDemo.showAdjustmentListenerDemo();
    }

    private void prepareGUI(){
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);

        statusLabel.setSize(350,100);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showAdjustmentListenerDemo(){
        headerLabel.setText("Listener in action: AdjustmentListener");

        JPanel panel = new JPanel();
        JScrollBar scrollbar = new JScrollBar();
        scrollbar.addAdjustmentListener(new CustomAdjustmentListener());

        panel.add(scrollbar);
        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }
    class CustomAdjustmentListener implements AdjustmentListener {
        public void adjustmentValueChanged(AdjustmentEvent e) {
            statusLabel.setText("Adjustment value: "
                    +Integer.toString(e.getValue()));
        }
    }
}
