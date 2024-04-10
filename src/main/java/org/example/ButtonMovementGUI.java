package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.awt.FlowLayout;
public class ButtonMovementGUI extends JFrame {
    int schetcic = 0;
    public ButtonMovementGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        /**
         * Creating buttons to play, previous and next
         */
        JButton buttonplay = new JButton("Play");
        JButton buttonprevious = new JButton("Previous");
        JButton buttonnext = new JButton("Next");
        panel.add(buttonprevious);
        panel.add(buttonplay);
        panel.add(buttonnext);
        /**
         * Creating and checking for music playback (changing the name of the play or stop button)
         */
        buttonplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ++schetcic;
                    if (schetcic % 2 == 1){
                        buttonplay.setLabel("Stop");
                    }else{
                        buttonplay.setLabel("Play");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



        JLabel label = new JLabel("Value: " + 50);
        JSlider slidervolume = new JSlider(JSlider.CENTER, 0, 100, 50);
        slidervolume.setMajorTickSpacing(10);
        slidervolume.setMinorTickSpacing(1);
        slidervolume.setPaintTicks(true);
        slidervolume.setPaintLabels(true);

        slidervolume.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText("Value: " + slidervolume.getValue());
            }
        });
        /**
         * Creating a slider
         */
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(slidervolume);
        panel.add(label);

        add(panel, BorderLayout.SOUTH);
        /*
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point point = e.getPoint();
                int x = (int) point.getX();
                int y = (int) point.getY();

                setTitle("Mouse coordinates - X: " + x + ", Y: " + y);
            }
        });
*/
        setSize(1100, 700);
        setVisible(true);
        setTitle("S-Vinks");
        /**
         * try to make a search
         */
        /*
        final JFileChooser fileChooser = new JFileChooser();
        final JEditorPane document = new JEditorPane();
        panel.add(new JScrollPane(document), BorderLayout.CENTER);

        JButton open = new JButton("Open");
        open.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int result = fileChooser.showOpenDialog(panel);
                if (result==JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        document.setPage(file.toURI().toURL());
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        panel.add(open, BorderLayout.NORTH);

        f.setContentPane(gui);
        f.pack();
        f.setSize(900,700);
        f.setLocationByPlatform(true);

        f.setVisible(true);
        f.setResizable(false);*/
        /**
         * what about list of compositions?
         */
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ButtonMovementGUI();
            }
        });
    }
}
