package cn.infosoft.swing.jcomponent;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class JSpinnerDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public JSpinnerDemo(){
        prepareGUI();
    }

    public static void main(String[] args){
        JSpinnerDemo  swingControlDemo = new JSpinnerDemo();
        swingControlDemo.showSpinnerDemo();
    }

    private void prepareGUI(){
        mainFrame = new JFrame("Java Swing Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("",JLabel.CENTER);

        statusLabel.setSize(350,100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showSpinnerDemo(){
        headerLabel.setText("Control in action: JSpinner");
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(10, //initial value
                        0, //min
                        100, //max
                        1);//step
        JSpinner spinner = new JSpinner(spinnerModel);
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                statusLabel.setText("Value : " + ((JSpinner)e.getSource()).getValue());
            }
        });
        controlPanel.add(spinner);
        mainFrame.setVisible(true);
    }
}
