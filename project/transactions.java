package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transactions extends JFrame implements ActionListener {
    JButton deposit,withdrawal,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;

    transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,680, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,850,680);
        add(label);

        JLabel text = new JLabel("Please select your Transaction");
        text.setFont(new Font("osward", Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(200,215,400,20);
        label.add(text);//to show on image

      deposit = new JButton("Deposit");
        deposit.setBounds(160,310,140,25);
        deposit.addActionListener(this);
        label.add(deposit);

         withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(340,310,140,25);
        withdrawal.addActionListener(this);
        label.add(withdrawal);

         fastcash = new JButton("Fastcash");
        fastcash.setBounds(160,340,140,25);
        fastcash.addActionListener(this);
        label.add(fastcash);

         ministatement = new JButton(" Ministatement");
        ministatement.setBounds(340,340,140,25);
        ministatement.addActionListener(this);
        label.add( ministatement);

       pinchange = new JButton("Pinchange ");
        pinchange.setBounds(160,370,140,25);
        pinchange.addActionListener(this);
        label.add( pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(340,370,140,25);
        balanceenquiry.addActionListener(this);
        label.add( balanceenquiry);

         exit = new JButton("Exit");
        exit.setBounds(280,396,100,20);
        exit.addActionListener(this);
        label.add( exit);

        setSize(850, 680);
        setUndecorated(true);//removes title bar
        setVisible(true);
        setLocation(350,10);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== exit){
            System.exit(0);
        } else if (ae.getSource()==deposit) {
            setVisible(false);
           new deposit(pinnumber).setVisible(true);
        }else if (ae.getSource()==withdrawal) {
            setVisible(false);
            new withdrawl(pinnumber).setVisible(true);
        }else if (ae.getSource()==fastcash) {
            setVisible(false);
            new fastcash(pinnumber).setVisible(true);
        } else if (ae.getSource()==pinchange) {
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);
        }else if (ae.getSource()==balanceenquiry) {
            setVisible(false);
            new balanceenquiry(pinnumber).setVisible(true);
        }else if (ae.getSource()==ministatement) {
            setVisible(false);
            new ministatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
       new  transactions("");
    }
}
