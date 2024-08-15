package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balanceenquiry extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;
    balanceenquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,680, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,850,680);
        add(label);

        back = new JButton("Back");
        back.setBounds(330,380,140,25);
        back.addActionListener(this);
        label.add(back);

        connect c = new connect();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            }catch(Exception e){
                System.out.println(e);
            }

        JLabel text = new JLabel("your current account balance is: "+balance);
        text.setFont(new Font("system", Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(150,255,400,20);
        label.add(text);

        setSize(850, 680);
        setUndecorated(true);
        setVisible(true);
        setLocation(350,10);
    }
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);

        new transactions(pinnumber).setVisible(true);

    }
    public static void main(String[] args) {
        new balanceenquiry("");
    }
}
