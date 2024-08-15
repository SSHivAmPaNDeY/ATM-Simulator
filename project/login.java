package project;

import javax.management.Query;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    login(){
            setTitle("ATM");

            setLayout(null);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
            Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT );
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(70,10,100,100);
            add(label);

            getContentPane().setBackground(Color.LIGHT_GRAY);

            JLabel text = new JLabel("welcome to the ATM");
            text.setFont(new Font("osward", Font.BOLD,38));
            text.setBounds(200,40,400,40);
            add(text);

            JLabel cardno= new JLabel("CARD NO");
            cardno.setFont(new Font("Raleway", Font.BOLD,28));
            cardno.setBounds(100,150,200,40);
            add(cardno);

            cardTextField   = new JTextField();
            cardTextField.setBounds(300,150,250,30);
            add(cardTextField);

            JLabel pin = new JLabel("PIN");
            pin.setFont(new Font("Raleway", Font.BOLD,28));
            pin.setBounds(100,220,400,30);
            add(pin);

            pinTextField = new JPasswordField();
            pinTextField.setBounds(300,220,250,30);
            add(pinTextField);

             login = new JButton("SIGN IN");
            login.setBounds(300,300,100,30);
            login.setBackground(Color.BLACK);
            login.setForeground(Color.WHITE);
        login.addActionListener(this);
            add(login);

            clear = new JButton("CLEAR");
            clear.setBounds(430,300,100,30);
            clear.setBackground(Color.BLACK);
            clear.setForeground(Color.WHITE);
            clear.addActionListener(this);
            add(clear);

            signup = new JButton("SIGN UP");
            signup.setBounds(300,350,230,30);
            signup.setBackground(Color.BLACK);
            signup.setForeground(Color.WHITE);
            signup.addActionListener(this);
            add(signup);

            setSize(800, 450);
            setVisible(true);
            setLocation(300,150);
        }
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource()== clear){
                cardTextField.setText("");
                pinTextField.setText("");
        }else if (ae.getSource()== login){
                connect conn =new connect();
                String cardnumber = cardTextField.getText();
                String pinnumber= pinTextField.getText();
                String query ="select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";

                try{

                   ResultSet rs = connect.s.executeQuery(query);
                   if (rs.next()){
                       setVisible(false);
                       new transactions(pinnumber).setVisible(true);
                   }else {
                       JOptionPane.showMessageDialog(null, "INCORRECT CARD NUMBER OR PIN");
                   }

                }catch (Exception e){
                    System.out.println(e);
                }
            }else if (ae.getSource()== signup) {
                setVisible(false);
                new signupone ().setVisible(true);
            }
            }
        public static void main(String[] args) {
 new login();
        }

    }


