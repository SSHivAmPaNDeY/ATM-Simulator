package project;
import javax.swing.*;//to import frame or use jframe
import java.awt.*;//to import color
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;//action listner to buttons

public class signupone extends JFrame implements ActionListener  {
    long random;
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton male,female,other,married,unmarried;
    signupone(){
        setLayout(null);
        //to get randome numbers
        Random ran = new Random();
         random =  Math.abs((ran.nextLong() % 9000L)+ 1000L);
        //math.abs makes any no +ve we did claculation to get  a 4 digit no

        JLabel formno= new JLabel("APPLICATION FORM NO"+random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140,15,600,30);
        add( formno);

        JLabel personaldetails= new JLabel("PAGE 1 :PERSONAL DETAILS");
        personaldetails.setFont(new Font("Raleway", Font.BOLD,20));
        personaldetails.setBounds(290,60,400,30);
        add( personaldetails);

        JLabel name= new JLabel("NAME :");
        name .setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,120,100,30);
        add( name);

        nameTextField = new JTextField();
        nameTextField.setBounds(300,120,400,30);
        nameTextField.setFont(new Font("Raleway", Font.BOLD,20));
        add( nameTextField);

        JLabel fname= new JLabel("FATHERS NAME :");
        fname .setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,170,200,30);
        add( fname);

       fnameTextField = new JTextField();
        fnameTextField.setBounds(300,170,400,30);
        fnameTextField.setFont(new Font("Raleway", Font.BOLD,20));
        add( fnameTextField);


        JLabel dob= new JLabel("DATE OF BIRTH:");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
      dob.setBounds(100,220,200,30);
        add( dob);

         dateChooser =new JDateChooser();
        dateChooser.setBounds(300,220,400,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
//      dobTextField = new JTextField();
//        dobTextField.setBounds(300,240,400,30);
//        dobTextField.setFont(new Font("Raleway", Font.BOLD,20));
//        add(dobTextField);

        JLabel gender= new JLabel("GENDER :");
        gender .setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,270,200,30);
        add(gender);

        male = new JRadioButton("MALE");
       male.setBounds(300,270,60,30);
        male.setBackground(Color.WHITE);
        add(male);

         female = new JRadioButton("FEMALE");
        female.setBounds(450,270,100,30);
        female.setBackground(Color.WHITE);
        add(female);

        //to let able choose only one
        ButtonGroup gendergroup =new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email= new JLabel("EMAIL ADDRESS :");
        email .setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,320,200,30);
        add(email);

         emailTextField = new JTextField();
        emailTextField.setBounds(300,320,400,30);
        emailTextField.setFont(new Font("Raleway", Font.BOLD,20));
        add(emailTextField);

        JLabel marital= new JLabel("MARITAL STATUS:");
        marital .setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100,370,200,30);
        add( marital);

        married = new JRadioButton("MARRIED");
        married.setBounds(300,370,120,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(450,370,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

         other = new JRadioButton("OTHER");
        other.setBounds(600,370,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        //to let able choose only one
        ButtonGroup maritalgroup =new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(other);
        maritalgroup.add(unmarried);

        JLabel address= new JLabel("ADDRESS:");
        address .setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,420,200,30);
        add( address);

         addressTextField = new JTextField();
        addressTextField.setBounds(300,420,400,30);
        addressTextField.setFont(new Font("Raleway", Font.BOLD,20));
        add(addressTextField);

        JLabel city= new JLabel("CITY:");
        city .setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100,470,200,30);
        add( city);

        cityTextField = new JTextField();
        cityTextField.setBounds(300,470,400,30);
        cityTextField.setFont(new Font("Raleway", Font.BOLD,20));
        add(cityTextField);

        JLabel state= new JLabel("STATE:");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,520,200,30);
        add( state);

        stateTextField = new JTextField();
        stateTextField.setBounds(300,520,400,30);
        stateTextField.setFont(new Font("Raleway", Font.BOLD,20));
        add(stateTextField);

        JLabel pincode= new JLabel("PINCODE:");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100,570,200,30);
        add( pincode);

         pincodeTextField = new JTextField();
        pincodeTextField.setBounds(300,570,400,30);
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD,20));
        add(pincodeTextField);

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
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;//way to convert long to string
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();//to get value from text field

        String dob= (( JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender="Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()){
            marital="married";
        } else if (unmarried.isSelected()) {
            marital = "unmarried";
        }else if (other.isSelected()) {
            marital = "other";
            
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();

        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
                //used for exeption dilogue box
            }else{
                connect c = new connect();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signuptwo(formno).setVisible(true);

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new signupone();
    }
}
