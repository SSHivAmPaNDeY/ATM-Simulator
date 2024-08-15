package project;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ministatement extends JFrame {
   // String pinnumber;
   ministatement(String pinnumber){
      setLayout(null);
//
        setTitle("mini statement");
        JLabel mini = new JLabel();
        add(mini);
//
        JLabel bank = new JLabel("MY BANK");
//        bank.setFont(new Font("system", Font.BOLD,16));
        bank.setBounds(150,20,100,20);
       add(bank);
//
//
//
        JLabel card =new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
//
//        JLabel balance =new JLabel();
//        balance.setBounds(150,400,400,20);
//        add(balance);
//
//
//
       try {
            connect c = new connect();

            ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            while (rs.next()) {
                card.setText("card Number:" +rs.getString("cardnumber").substring(0,4)+"xxxxxxxx"+ rs.getString("cardnumber").substring(12));
            }
        }
        catch (Exception e) {
           System.out.println(e);
        }
        try {
            connect c = new connect();
//            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
//                if (rs.getString("type").equals("deposit")) {
//                    bal += Integer.parseInt(rs.getString("amount"));
//                } else {
//                    bal -= Integer.parseInt(rs.getString("amount"));
//                }
           }
//                    balance.setText("YOUR CURRENT account balance is rs "+bal);
//
        } catch (Exception e) {
            System.out.println(e);
       }
        mini.setBounds(20,140,400,200);
//
       setSize(400, 600);
//        //setUndecorated(true);
        setVisible(true);
        setLocation(20,20);
    }

    public static void main(String[] args) {
        new ministatement("");
    }
}
