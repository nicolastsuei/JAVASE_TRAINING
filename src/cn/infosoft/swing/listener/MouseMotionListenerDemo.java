package cn.infosoft.swing.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseMotionListenerDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public MouseMotionListenerDemo(){
        prepareGUI();
    }

    public static void main(String[] args){
        MouseMotionListenerDemo  swingListenerDemo = new MouseMotionListenerDemo();
        swingListenerDemo.showMouseMotionListenerDemo();
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

    private void showMouseMotionListenerDemo(){
        headerLabel.setText("Listener in action: MouseMotionListener");

        JPanel panel = new JPanel();
        panel.setBackground(Color.magenta);
        panel.setLayout(new FlowLayout());
        panel.addMouseMotionListener(new CustomMouseMotionListener());

        JLabel msglabel = new JLabel("Welcome to INFOSOFT SWING Tutorial." ,JLabel.CENTER);
        panel.add(msglabel);

        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }

    class CustomMouseMotionListener implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {
            statusLabel.setText("Mouse Dragged: ("+e.getX()+", "+e.getY() +")");
        }

        public void mouseMoved(MouseEvent e) {
            statusLabel.setText("Mouse Moved: ("+e.getX()+", "+e.getY() +")");
        }
    }
}
