package cn.infosoft.swing.adapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowAdapterDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public WindowAdapterDemo(){
        prepareGUI();
    }

    public static void main(String[] args){
        WindowAdapterDemo  swingAdapterDemo = new WindowAdapterDemo();
        swingAdapterDemo.showWindowAdapterDemo();
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


    private void showWindowAdapterDemo(){
        headerLabel.setText("Listener in action: WindowAdapter");

        JButton okButton = new JButton("OK");

        final JFrame aboutFrame = new JFrame();
        aboutFrame.setSize(300,200);;
        aboutFrame.setTitle("WindowAdapter Demo");
        aboutFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                aboutFrame.dispose();
            }
        });
        JLabel msgLabel  = new JLabel("Welcome to INFOSOFT SWING Tutorial." ,JLabel.CENTER);
        aboutFrame.add(msgLabel);
        aboutFrame.setVisible(true);
    }
}
