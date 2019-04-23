package cn.infosoft.swing.jcomponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageIconDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public ImageIconDemo(){
        prepareGUI();
    }

    public static void main(String[] args){
        ImageIconDemo  swingControlDemo = new ImageIconDemo();
        swingControlDemo.showImageIconDemo();
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

    // Returns an ImageIcon, or null if the path was invalid.
    private static ImageIcon createImageIcon(String path,
                                             String description) {
        java.net.URL imgURL = ImageIconDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    private void showImageIconDemo(){
        headerLabel.setText("Control in action: ImageIcon");
        ImageIcon icon = createImageIcon("C:/tools/Java/jdk1.8.0_121/lib/missioncontro/plugins/com.jrockit.mc.rjmx_5.5.1.172852/icons/hprof-16.png","Java");
        JLabel commentlabel = new JLabel("", icon,JLabel.CENTER);
        controlPanel.add(commentlabel);
        mainFrame.setVisible(true);
    }
}
