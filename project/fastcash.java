package project;

import project.withdrawl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener {
        JButton deposit,withdrawal,ministatement,pinchange,fastcash,balanceenquiry,exit;
        String pinnumber;

        fastcash(String pinnumber){
            this.pinnumber=pinnumber;
            setLayout(null);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(850,680, Image.SCALE_DEFAULT );
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(0,0,850,680);
            add(label);

            JLabel text = new JLabel("Please select withdrawal amount");
            text.setFont(new Font("osward", Font.BOLD,16));
            text.setForeground(Color.WHITE);
            text.setBounds(200,215,400,20);
            label.add(text);//to show on image

            deposit = new JButton("RS 100");
            deposit.setBounds(160,310,140,25);
            deposit.addActionListener(this);
            label.add(deposit);

            withdrawal = new JButton("RS 500");
            withdrawal.setBounds(340,310,140,25);
            withdrawal.addActionListener(this);
            label.add(withdrawal);

            fastcash = new JButton("RS 1000");
            fastcash.setBounds(160,340,140,25);
            fastcash.addActionListener(this);
            label.add(fastcash);

            ministatement = new JButton("RS 2000");
            ministatement.setBounds(340,340,140,25);
            ministatement.addActionListener(this);
            label.add( ministatement);

            pinchange = new JButton("RS 5000 ");
            pinchange.setBounds(160,370,140,25);
            pinchange.addActionListener(this);
            label.add( pinchange);

            balanceenquiry = new JButton("RS 10000");
            balanceenquiry.setBounds(340,370,140,25);
            balanceenquiry.addActionListener(this);
            label.add( balanceenquiry);

            exit = new JButton("BACK");
            exit.setBounds(280,396,100,20);
            exit.addActionListener(this);
            label.add( exit);

            setSize(850, 680);
            setUndecorated(true);//removes title bar
            setVisible(true);
            setLocation(350,10);
        }

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == exit) {
                setVisible(false);
                new transactions(pinnumber).setVisible(true);
            } else {
                String amount = ((JButton) ae.getSource()).getText().substring(3);//500 rs removed
                connect c = new connect();
                try {
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE");
                        return;

                    }
                    Date date = new Date();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','withdrawal','" + amount + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "RS" + amount + "DEBITED SUCESSFULLY");
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);




                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        public static void main(String[] args) {

            new project.fastcash("");
        }
    }