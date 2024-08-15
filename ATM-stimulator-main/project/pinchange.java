package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinchange extends JFrame implements ActionListener {
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    pinchange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(850,680, Image.SCALE_DEFAULT );
    ImageIcon i3 = new ImageIcon(i2);
    JLabel label = new JLabel(i3);
        label.setBounds(0,0,850,680);
    add(label);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("osward", Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(170,215,400,20);
        label.add(text);//to show on image

        JLabel pintext = new JLabel("New pin:");
        pintext.setFont(new Font("system", Font.BOLD,16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(150,245,150,20);
        label.add(pintext);//to show on image

       pin= new JPasswordField();
       pin.setBounds(290,245,150,20);
        pin.setFont(new Font("Raleway", Font.BOLD,20));
        label.add(pin);



        JLabel repintext = new JLabel("ReEnter new pin:");
        repintext.setFont(new Font("system", Font.BOLD,16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(150,275,400,20);
        label.add(repintext);//to show on image

         repin= new JPasswordField();
        repin.setBounds(290,275,150,20);
        repin.setFont(new Font("Raleway", Font.BOLD,20));
       label.add(repin);

          change = new JButton("change");
        change.setBounds(310,340,140,25);
        change.addActionListener(this);
        label.add(change);

         back = new JButton("Back");
        back.setBounds(310,370,140,25);
        back.addActionListener(this);
        label.add(back);


        setSize(850, 680);
        setUndecorated(true);
        setVisible(true);
        setLocation(350,10);

}
public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "ENTERED PIN DOSEN'T MATCH");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "PLEASE ENTER PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "PLEASE REENTER PIN");
                    return;
                }
                connect conn = new connect();
                String query1= "update bank set pin ='"+rpin+"' where pin'"+pinnumber+"'";
                String query2= "update login set pin ='"+rpin+"' where pin'"+pinnumber+"'";
                String query3= "update signupthree set pin ='"+rpin+"' where pin'"+pinnumber+"'";

                connect.s.executeUpdate(query1);
                connect.s.executeUpdate(query2);
                connect.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PLEASE REENTER PIN");
                setVisible(false);
                new transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }else {
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        }
        }

    public static void main(String[] args) {
        new pinchange("").setVisible(true);
    }
    }
