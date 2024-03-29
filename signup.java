import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.sql.*;
import java.lang.*;
import javax.swing.border.EmptyBorder;

class guisignup extends JFrame implements ActionListener{

        JPanel p1,p2;
        JLabel lhead,lheading,lusername,lname,lemail,lgender,lpassword,licon,licon2,lcpassword,laacc;
        JTextField tusername,tname,temail;
        JPasswordField tpassword;
	JPasswordField tcpassword;
	JComboBox Cgender;
	JButton btn1,btn2,btn3;
	JCheckBox showpass;

	Connection con;
	Statement stmt;
                                                                                                                                                            
        public guisignup(){

        p1 =new JPanel();
        p1.setLayout(null);
	//p1.setBackground(Color.GRAY);
	
	
	

//adding another panel
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,200,1100,700);
        p2.setBackground(Color.BLACK);
        add(p2);
        p1.add(p2);




        lheading =new JLabel("SIGNUP PAGE");
	lusername =new JLabel("USERNAME :");
	lname =new JLabel("NAME :");
	lemail =new JLabel("EMAIL :");
	lgender =new JLabel("GENDER :");
        lpassword =new JLabel("PASSWORD :");
	lcpassword =new JLabel("REPEAT PASSWORD :");
	laacc = new JLabel("Already have an account?");
	lhead = new JLabel("LifeAnalyzer 360");
	

	Icon img = new ImageIcon("iconn.png");
	licon = new JLabel(img);
	

	Icon img2 = new ImageIcon("iconn.png");
	licon2 = new JLabel(img2);
	

         // Entry control of gender
	 Cgender = new JComboBox();
        
        Cgender.addItem("SELECT GENDER");
        Cgender.addItem("MALE");
        Cgender.addItem("FEMALE");
	Cgender.addItem("RATHER NOT SAY");
	Cgender.addItem("OTHERS");
	
	//TO SET POSITION OF A LABEL
	lheading.setBounds(465,50,300,50);
        lusername.setBounds(320,120,250,35);
        lname.setBounds(320,170,250,35);
        lemail.setBounds(320,220,250,35);
        lgender.setBounds(320,270,250,35);
        lpassword.setBounds(320,320,250,35);
	lcpassword.setBounds(320,370,250,35);
	licon.setBounds(155,-139,800,1050);
	licon2.setBounds(155,-189,800,1050);
	laacc.setBounds(570,412,250,35);
	lhead.setBounds(630,50,800,75);
	
	//TO SET COLOR OF A LABEL
        lheading.setForeground(Color.CYAN);
        lusername.setForeground(Color.WHITE);
        lname.setForeground(Color.WHITE);
	lemail.setForeground(Color.WHITE);
        lgender.setForeground(Color.WHITE);
        lpassword.setForeground(Color.WHITE);
	lcpassword.setForeground(Color.WHITE);
	laacc.setForeground(Color.WHITE);
	lhead.setForeground(Color.BLACK);
	

	//TO SET FONT-SIZE OF A LABEL
        lheading.setFont(lheading.getFont().deriveFont(35f));
        lusername.setFont(lusername.getFont().deriveFont(18f));
        lname.setFont(lname.getFont().deriveFont(18f));
        lemail.setFont(lemail.getFont().deriveFont(18f));
        lgender.setFont(lgender.getFont().deriveFont(18f));
        lpassword.setFont(lpassword.getFont().deriveFont(18f));
	lcpassword.setFont(lcpassword.getFont().deriveFont(18f));
	laacc.setFont(lcpassword.getFont().deriveFont(16f));
	lhead.setFont(lhead.getFont().deriveFont(65f));
	
	
	
       
        ImageIcon backgroundImage = new ImageIcon("background.png"); 
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1920, 1080);
        backgroundLabel.setOpaque(true); 
	backgroundLabel.setBackground(new Color(255, 255, 255, 150));
        getContentPane().add(backgroundLabel);
       


      

	tname=new JTextField();
        temail=new JTextField();
	tusername=new JTextField();



	tusername.setBounds(570,120,250,30);
	tname.setBounds(570,170,250,30);
        temail.setBounds(570,220,250,30);
        Cgender.setBounds(570,270,250,30);

        tpassword=new JPasswordField();
        tpassword.setBounds(570,320,250,30);
        
	tcpassword=new JPasswordField();
        tcpassword.setBounds(570,370,250,30);
        
	showpass = new JCheckBox();
	showpass.setBounds(1020,400,140,30);
	showpass.setBackground(Color.GRAY);
	// show password icon link	
	ImageIcon i2 = new ImageIcon("eye.png");
	showpass.setBackground(new Color(0, 0, 0, 0)); 
        showpass.setIcon(i2);
	showpass.setBounds(816,322,50,28);
	

	btn1=new JButton("S U B M I T");
	btn1.setBounds(670,490,150,35);
	//btn1.setForeground(Color.WHITE);
	//btn1.setBackground(Color.BLACK);


	btn2=new JButton("R E S E T");
	btn2.setBounds(340,490,150,35);
	//btn2.setForeground(Color.WHITE);
	//btn2.setBackground(Color.BLACK);
	
	
	btn3=new JButton("Login");
        btn3.setBounds(784,413,85,30);
        btn3.setForeground(Color.BLUE);
        btn3.setBackground(new Color(0, 0, 0, 0));
	btn3.setBorder(new EmptyBorder(0, 0, 0, 0));
	btn3.setFont(btn3.getFont().deriveFont(16f));
	

	
	
	
	p2.add(lheading);
	p1.add(lhead);
	p2.add(lusername);
	p2.add(lname);
	p2.add(lemail);
	p2.add(lgender);
	p2.add(lpassword);
	p2.add(lcpassword);
	p2.add(licon);
	p2.add(licon2);
	p2.add(tname);
	p2.add(temail);
	p2.add(Cgender);
	p2.add(tusername);
	p2.add(tpassword);
	p2.add(tcpassword);
	p2.add(showpass);
	p2.add(btn1);
	p2.add(btn2);
	p2.add(btn3);
	p2.add(laacc);
	p1.add(backgroundLabel);
	add(p1);




                                                                                                                                                            
	//HOVER FOR BTN1 SUBMIT
	btn1.addMouseListener( new MouseAdapter()
	{
	public void mouseEntered(MouseEvent e){

	btn1.setBackground(Color.BLACK);
	btn1.setForeground(Color.WHITE);
	}

	public void mouseExited(MouseEvent e){

	btn1.setBackground(Color.WHITE);
	btn1.setForeground(Color.BLACK);

	}


 	}

	);//hover for btn1 end
                                                                                                                                                            

	//HOVER FOR BTN2 RESET

	btn2.addMouseListener(new MouseAdapter (){

	public void  mouseEntered(MouseEvent e){

	btn2.setBackground(Color.BLACK);
	btn2.setForeground(Color.WHITE);

	}

	public void  mouseExited(MouseEvent e){

	btn2.setBackground(Color.WHITE);
	btn2.setForeground(Color.BLACK);

	}
	}

	); //hover for btn2 end

                                                                                                                                                            
// Action performed to show the password

    showpass.addActionListener(new ActionListener()
   {
    @Override
	public void actionPerformed(ActionEvent e)
	{
	JCheckBox CBox = (JCheckBox) e.getSource();
	tpassword.setEchoChar(CBox.isSelected() ? '\0' : '*');
	}
   });

	//BACKEND FOR BTN2 TO RESET VALUES

	btn2.addActionListener(new ActionListener(){

	//ACTIONS WHICH HAD TO DONE ON CLICK OF BTN2 RESET
	public void actionPerformed(ActionEvent arr){

        if(arr.getSource() == btn2){

	try{

	   tusername.setText(null);
	   tname.setText(null);
       	   temail.setText(null);
	   Cgender.setSelectedItem(null);
	   tpassword.setText(null);
	   tcpassword.setText(null);

	   JOptionPane.showMessageDialog(guisignup.this,"RESETED successfully");

	 }//try end

	catch(Exception e2){
	System.out.println("Problem is :"+e2);
	}//catch end

	}//if end

	else{System.out.println("source is invalid");}

	}//actionperformed2 end
	}
	);

                                                                                                                                                            
	btn3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Open the SignUp window when the button is clicked
        login.main(null);
        // Close the Login window
        dispose(); // Close the login window using this.dispose()
    }
});

	//BACKEND FOR BTN1 TO SUBMIT VALUES

	btn1.addActionListener(this);

	

       }//guisignup constructor end



                                                                                                                                                            


	//ACTIONS WHICH HAD TO DONE ON CLICK OF BTN1

	public void actionPerformed(ActionEvent arr){

	String username =tusername.getText();
	String name =tname.getText();
	String email =temail.getText();
	String gender =Cgender.getSelectedItem().toString();
	String pass =tpassword.getText();
        String cpass =tcpassword.getText();

	if(arr.getSource() == btn1){
	try{

        Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","attack");
	System.out.println("DATABASE CONNECTED SUCCESSFULLY...");

	//insert the user given input to the database(mydb in table reecords)
         

        if(name.isEmpty() || username.isEmpty() || email.isEmpty() || gender.isEmpty() || pass.isEmpty() || cpass.isEmpty()){

        if(username.isEmpty())
        {JOptionPane.showMessageDialog(this,"Username is Required");     }
        else if(name.isEmpty())
        {JOptionPane.showMessageDialog(this,"Name is Required");     }
        else if(email.isEmpty())
        {JOptionPane.showMessageDialog(this,"Email is Required");     }
        else if(gender.isEmpty())
        {JOptionPane.showMessageDialog(this,"gender is Required");     }
        else if(pass.isEmpty())
        {JOptionPane.showMessageDialog(this,"Password is Required");     }
        else if(cpass.isEmpty())
        {JOptionPane.showMessageDialog(this,"Confirm Password is Required");     }
        
      
	 }//validation if end
	
	
	else{
	if(!pass.equals(cpass)){
        JOptionPane.showMessageDialog(this,"Please Repeat the same password");
        
        }
	

        else{
        
         
	Statement stmt=con.createStatement();
        stmt.executeUpdate("insert into records values('"+name+"','"+username+"','"+email+"','"+gender+"','"+pass+"')");

        JOptionPane.showMessageDialog(this,"Record inserted successfully..");

        
      
        }
	
	
	}
       
	}
	catch(Exception e1){
	System.out.println("database is not connected"+e1);
	}
       }

	else{System.out.println("doesnt get source");}


	
	}//actionperformed end
                                                                                                                                                            

   }//guisignup class end

                                                                                                                                                            

class signup{
        public static void main(String[]arr){


        guisignup obj =new guisignup();

        obj.setVisible(true);
        obj.setSize(1920,1080);
}
}
                                                                                                                                                            
