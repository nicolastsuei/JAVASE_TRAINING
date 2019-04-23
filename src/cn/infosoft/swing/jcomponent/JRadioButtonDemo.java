package cn.infosoft.swing.jcomponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JRadioButtonDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public JRadioButtonDemo(){
        prepareGUI();
    }

    public static void main(String[] args){
        JRadioButtonDemo  swingControlDemo = new JRadioButtonDemo();
        swingControlDemo.showRadioButtonDemo();
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

    private void showRadioButtonDemo(){
        headerLabel.setText("Control in action: RadioButton");

        final JRadioButton radApple = new JRadioButton("Apple", true);
        final JRadioButton radMango = new JRadioButton("Mango");
        final JRadioButton radPeer = new JRadioButton("Peer");

        radApple.setMnemonic(KeyEvent.VK_C);
        radMango.setMnemonic(KeyEvent.VK_M);
        radPeer.setMnemonic(KeyEvent.VK_P);

        radApple.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Apple RadioButton: " +  (e.getStateChange()==1?"checked":"unchecked"));
            }
        });

        radMango.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Mango RadioButton: " + (e.getStateChange()==1?"checked":"unchecked"));
            }
        });

        radPeer.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Peer RadioButton: " + (e.getStateChange()==1?"checked":"unchecked"));
            }
        });

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(radApple);
        group.add(radMango);
        group.add(radPeer);

        controlPanel.add(radApple);
        controlPanel.add(radMango);
        controlPanel.add(radPeer);

        mainFrame.setVisible(true);
    }
}
