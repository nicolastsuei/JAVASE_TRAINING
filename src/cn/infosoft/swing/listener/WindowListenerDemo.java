package cn.infosoft.swing.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowListenerDemo {
    private JFrame mainFrame;
    private JFrame aboutFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public WindowListenerDemo(){
        prepareGUI();
    }

    public static void main(String[] args){
        WindowListenerDemo  swingListenerDemo = new WindowListenerDemo();
        swingListenerDemo.showWindowListenerDemo();
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

    private void showWindowListenerDemo(){
        headerLabel.setText("Listener in action: WindowListener");

        JButton okButton = new JButton("OK");

        aboutFrame = new JFrame();
        aboutFrame.setSize(300,200);;
        aboutFrame.setTitle("WindowListener Demo");
        aboutFrame.addWindowListener(new CustomWindowListener());

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        JLabel msglabel
                = new JLabel("Welcome to INFOSOFT SWING Tutorial."
                ,JLabel.CENTER);
        panel.add(msglabel);
        aboutFrame.add(panel);
        aboutFrame.setVisible(true);
    }
    class CustomWindowListener implements WindowListener {
        public void windowOpened(WindowEvent e) {
        }

        public void windowClosing(WindowEvent e) {
            aboutFrame.dispose();
        }

        public void windowClosed(WindowEvent e) {
        }

        public void windowIconified(WindowEvent e) {
        }

        public void windowDeiconified(WindowEvent e) {
        }

        public void windowActivated(WindowEvent e) {
        }

        public void windowDeactivated(WindowEvent e) {
        }
    }
}
