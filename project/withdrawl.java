package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class withdrawl extends JFrame implements ActionListener {
    JTextField  amount;
    JButton withdraw,back;
    String pinnumber;
    withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,680, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,850,680);
        add(label);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setFont(new Font("osward", Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(170,215,400,20);
        label.add(text);//to show on image

        amount= new JPasswordField();
        amount.setFont(new Font("Raleway", Font.BOLD,28));
        amount.setBounds(170,300,300,30);
        label.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(330,350,140,25);
        withdraw.addActionListener(this);
        label.add(withdraw);

        back = new JButton("Back");
        back.setBounds(330,380,140,25);
        back.addActionListener(this);
        label.add(back);




        setSize(850, 680);
        setUndecorated(true);
        setVisible(true);
        setLocation(350,10);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== withdraw){
            String number =amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE ENTER THE AMOUNT YOU WANT TO WITHDRAW");
            }else {
                try {
                    connect con = new connect();
                    String query = "INSERT INTO BANK VALUES('" + pinnumber + "','" + date + "','withdrawl','" + number + "')";
                    connect.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "rs " + number + " withdraw successfully ");
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);

                } catch(Exception e){
                    System.out.println(e);
                }
            }
        } else if (ae.getSource()==back) {
            new transactions(pinnumber).setVisible(true);

        }
    }
    public static void main(String[] args) {
        new withdrawl("");

    }
}//video 8 24.02{

