import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class source extends JFrame implements ActionListener, KeyListener {


    int pX,pY;


    source(){

        super("MBPS to MB");
        labelMbps.setBounds(15,5,80,30);
        textMb.setBounds(100,5,80,30);
        btnConvert.setBounds(80,50,100,50);
        labelConverted.setBounds(105,25,90,30);
        add(textMb);
        add(labelMbps);
        add(btnConvert);
        add(labelConverted);
        setLayout(null);
        btnConvert.addActionListener(this);
        add(new JLabel(new ImageIcon("/Users/furkan/Downloads/internet-speed-icon-psd.png")));
        setFocusable(true);
        addKeyListener(this);

        /*KeyAdapter adapter = new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                super.keyTyped(e);
                System.out.println(e+" key pressed");
            }
        };
        */

        textMb.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(textMb.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter value!");

                }

                try{
                    labelConverted.setText(new DecimalFormat("##.##").format(Double.valueOf(textMb.getText())*mbps)+"MB/s");
                    textMb.setText("");

                }catch (NumberFormatException e1){

                   // JOptionPane.showMessageDialog(null,"Please enter Correct");




                }


            }
        });




        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me){
                pX = me.getX();
                pY = me.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent me){
                setLocation(getLocation().x+me.getX()-pX,getLocation().y+me.getY()-pY);
            }
        });




    }

    JButton btnConvert = new JButton("Convert");
    double mbps = 0.125;
    JTextField textMb = new JTextField();
    JLabel labelConverted = new JLabel("sonuc");
    JLabel labelMbps = new JLabel("MBPS/MB");
   //ImageIcon icon = new ImageIcon("/Users/furkan/Downloads/internet-speed-icon-psd.png");



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnConvert){


           // System.out.println("test");
            try{
                labelConverted.setText(new DecimalFormat("##.##").format(Double.valueOf(textMb.getText())*mbps)+"MB/s");
                textMb.setText("");

            }catch (NumberFormatException e1){
                System.out.println("dogru gir");

               int i=100;
               int time;
               JOptionPane pane = new JOptionPane();

                pane.showMessageDialog(null,"Please enter Correct");




            }

        }



    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
        if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        if(e.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE){
            System.out.println("test");
        }

    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {

    }
}
