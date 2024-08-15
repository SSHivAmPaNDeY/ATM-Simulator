package project;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;



public class signuptwo extends JFrame implements ActionListener {

    JTextField pan,Aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    String formno;
    JComboBox religion, category,Occupation,Qualification,income;
    JRadioButton male,female,other,married,unmarried;
    signuptwo (String formno)
    {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM PAGER-2");



        JLabel personaldetails= new JLabel("PAGE 2 :PERSONAL DETAILS");
        personaldetails.setFont(new Font("Raleway", Font.BOLD,20));
        personaldetails.setBounds(290,60,400,30);
        add( personaldetails);

        JLabel name= new JLabel("Relegion :");
        name .setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,120,100,30);
        add( name);

        String valReligion[]={"Hindu","Muslim","Sikh","Christian","others"};
         religion = new JComboBox(valReligion);
        religion.setBounds(300,120,300,30);
        add( religion);


        JLabel fname= new JLabel("category :");
        fname .setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,170,200,30);
        add( fname);
        String valcategory[]={"GENERAL","SC","ST","OBC","others"};
        category= new JComboBox(valcategory);
        category.setBounds(300,170,400,30);
        add( category);
        JLabel dob= new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100,220,200,30);
        add( dob);
        String valincome []={"NULL","<1,50,000","<2,50,000","<5,00,000","UPTO 10 LAKH"};
        income= new JComboBox(valincome);
        income.setBounds(300,220,400,30);
        add(income);
        JLabel gender= new JLabel("Educational ");
        gender .setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,280,200,30);
        add(gender);
        JLabel email= new JLabel("Qualification");
        email .setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,300,200,30);
        add(email);
        String valQualification []={"Non Graduate","Graduate","Post Graduate","doctarate","others"};
        Qualification= new JComboBox(valQualification);
        Qualification.setBounds(300,280,400,30);
        add(Qualification);
        JLabel marital= new JLabel("Occupation:");
        marital .setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100,370,200,30);
        add( marital);
        String valOccupation []={"Salaried","Self employed","retired","student","others"};
        Occupation= new JComboBox(valOccupation);
        Occupation.setBounds(300,370,400,30);
        add(Occupation);
        JLabel address= new JLabel("PAN no:");
        address .setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,420,200,30);
        add( address);
        pan = new JTextField();
        pan.setBounds(300,420,400,30);
        pan.setFont(new Font("Raleway", Font.BOLD,20));
        add(pan);
        JLabel city= new JLabel("Aadahar no:");
        city .setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100,470,200,30);
        add( city);
        Aadhar = new JTextField();
        Aadhar.setBounds(300,470,400,30);
        Aadhar.setFont(new Font("Raleway", Font.BOLD,20));
        add(Aadhar);
        JLabel state= new JLabel("Senior citizen:");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,520,200,30);
        add( state);
        syes = new JRadioButton("yes");
        syes.setBounds(300,520,120,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno= new JRadioButton("no");
        sno.setBounds(450,520,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup maritalgroup =new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);


        JLabel pincode= new JLabel("existing account:");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100,570,200,30);
        add( pincode);
        eyes = new JRadioButton("yes");
        eyes.setBounds(300,570,120,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno= new JRadioButton("no");
        eno.setBounds(450,570,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup pincodegroup =new ButtonGroup();
        pincodegroup.add(eyes);
        pincodegroup.add(eno);


        next = new JButton("NEXT");
        next .setBounds(620,610,80,30);
        next .setBackground(Color.BLACK);
        next .setForeground(Color.WHITE);
        next .addActionListener(this);
        add(next );


        getContentPane().setBackground(Color.lightGray);
        setSize(850, 700);
        setVisible(true);
        setLocation(350,10);


    }
    public void actionPerformed(ActionEvent ae)
    {

        String srelegion = (String) religion.getSelectedItem();
        String scategory =  (String) category.getSelectedItem();
        String sincome =  (String) income.getSelectedItem();
        String sQualification =  (String) Qualification.getSelectedItem();
        String sOccupation =  (String) Occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen = "yes";
        }else if (sno.isSelected()){
            seniorcitizen="no";
        }

        String existingaccount = null;
        if (eyes.isSelected()){
            existingaccount="yes";
        } else if (eno.isSelected()) {
            existingaccount = "no";
        }


        String span = pan.getText();
        String sAadhar = Aadhar.getText();


        try{

            connect c = new connect();

            String query = "insert into signuptwo values('"+formno+"','"+srelegion+"','"+scategory+"','"+sincome+"','"+sQualification+"','"+sOccupation+"','"+span+"','"+sAadhar+"','"+existingaccount+"','"+seniorcitizen+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new signupthree(formno).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }
    }



    public static void main(String[] args) {

        new project.signuptwo("");
    }
}