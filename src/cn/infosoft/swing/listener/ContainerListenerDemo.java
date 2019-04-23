package cn.infosoft.swing.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContainerListenerDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public ContainerListenerDemo(){
        prepareGUI();
    }

    public static void main(String[] args){
        ContainerListenerDemo  swingListenerDemo = new ContainerListenerDemo();
        swingListenerDemo.showContainerListenerDemo();
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

    private void showContainerListenerDemo(){
        headerLabel.setText("Listener in action: ContainerListener");

        JPanel panel = new JPanel();
        panel.setBackground(Color.magenta);
        panel.addContainerListener(new CustomContainerListener());

        JLabel msglabel  = new JLabel("Welcome to INFOSOFT SWING Tutorial." ,JLabel.CENTER);
        panel.add(msglabel);

        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }

    class CustomContainerListener implements ContainerListener {
        public void componentAdded(ContainerEvent e) {
            statusLabel.setText(statusLabel.getText()  + e.getComponent().getClass().getSimpleName() + " added. ");
        }

        public void componentRemoved(ContainerEvent e) {
            statusLabel.setText(statusLabel.getText()  + e.getComponent().getClass().getSimpleName() + " removed. ");
        }
    }
}
