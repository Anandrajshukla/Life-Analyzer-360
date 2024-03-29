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

class guilogin extends JFrame implements ActionListener{

	JPanel p1,p2;
        JLabel lheading,lusername,lpassword,lforgetpass,licon,lhead;
        JTextField tusername;
        JPasswordField tpassword;
        JButton btn1,btn2,btn3,btn4;
	JCheckBox showpass;
	Connection con;
        Statement stmt;
                                                                 
        public guilogin(){

        p1 =new JPanel();
        p1.setLayout(null);
        
        //adding another panel
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,200,1100,700);
        p2.setBackground(Color.BLACK);
        add(p2);
        p1.add(p2);


        lheading =new JLabel("LOGIN PAGE");
        lusername =new JLabel("USERNAME");
        lpassword =new JLabel("PASSWORD");
        lhead = new JLabel("LifeAnalyzer 360");
	

	Icon img = new ImageIcon("iconn.png");
        licon = new JLabel(img);
        licon.setBackground(Color.GRAY);

	//TO SET POSITION OF A LABEL
	lheading.setBounds(465,50,600,50);
        lusername.setBounds(280,190,250,35);
	lpassword.setBounds(280,280,250,35);
	licon.setBounds(107,-228,800,1050);
	lhead.setBounds(630,50,800,75);
	


	//TO SET COLOR OF A LABEL
        lheading.setForeground(Color.CYAN);
        lusername.setForeground(Color.WHITE);
        lpassword.setForeground(Color.WHITE);
        lhead.setForeground(Color.BLACK);
	


	//TO SET FONT-SIZE OF A LABEL
        lheading.setFont(lheading.getFont().deriveFont(45f));
        lusername.setFont(lusername.getFont().deriveFont(24f));
        lpassword.setFont(lpassword.getFont().deriveFont(24f));
        lhead.setFont(lhead.getFont().deriveFont(65f));
	
       

	//adding textfield
	tusername=new JTextField();
	tpassword=new JPasswordField();

	tusername.setBounds(520,190,300,35);
	tpassword.setBounds(520,280,300,35);

	

	 showpass = new JCheckBox();
         showpass.setBounds(1020,400,140,30);
         showpass.setBackground(Color.GRAY);

	ImageIcon i2 = new ImageIcon("eye.png");
	showpass.setBackground(new Color(0, 0, 0, 0)); 
        showpass.setIcon(i2);
        showpass.setBounds(810,255,50,80);
	

	btn1=new JButton("L O G I N");
        btn1.setBounds(670,450,150,35);

	btn2=new JButton("R E S E T");
        btn2.setBounds(300,450,150,35);

	btn3=new JButton("Forget Password?");
	btn3.setBounds(1170,430,170,30);
	btn3.setForeground(Color.BLUE);
	
	
	btn3.setOpaque(false);
        btn3.setContentAreaFilled(false);
        btn3.setBorderPainted(false);
       
        btn4=new JButton("Create a new account!");
        btn4.setBounds(637,380,270,30);
	btn4.setForeground(Color.BLUE);
        btn4.setFont(btn4.getFont().deriveFont(14f));
        
        btn4.setOpaque(false);
        btn4.setContentAreaFilled(false);
        btn4.setBorderPainted(false);
     
          
        
        ImageIcon backgroundImage = new ImageIcon("background.png"); 
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1920, 1080);
        backgroundLabel.setOpaque(true); 
	backgroundLabel.setBackground(new Color(255, 255, 255, 150));
        getContentPane().add(backgroundLabel);
       


	p2.add(lheading);
        p2.add(lusername);
 	p2.add(lpassword);
	p2.add(licon);
	p2.add(tusername);
 	p2.add(tpassword);
        p2.add(showpass);
	p2.add(btn1);
        p2.add(btn2);
	p2.add(btn3);
	p2.add(btn4);
	p1.add(lhead);
	p1.add(backgroundLabel);
	
	add(p1);


       

                                                                 

//HOVER FOR BTN1 SUBMIT
        btn1.addMouseListener( new MouseAdapter()
        {
        public void mouseEntered(MouseEvent e){

        btn1.setBackground(Color.WHITE);
        btn1.setForeground(Color.BLACK);
        }

        public void mouseExited(MouseEvent e){

        btn1.setBackground(Color.GRAY);
        btn1.setForeground(Color.BLACK);

        }


        }

        );//hover for btn1 end
                                                                 

    //HOVER FOR BTN2 RESET

        btn2.addMouseListener(new MouseAdapter (){

        public void  mouseEntered(MouseEvent e){

        btn2.setBackground(Color.WHITE);
        btn2.setForeground(Color.BLACK);

        }

        public void  mouseExited(MouseEvent e){

        btn2.setBackground(Color.GRAY);
        btn2.setForeground(Color.BLACK);

        }
        }

        ); //hover for btn2 end

                                                                 
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
           tpassword.setText(null);
           JOptionPane.showMessageDialog(guilogin.this,"RESETED successfully");

         }//try end

        catch(Exception e2){
        System.out.println("Problem is :"+e2);
        }//catch end

        }//if end


        else{System.out.println("source is invalid");}

        
        
        }
        
        
        } //actionperformed2 end
         );
                                                                

        //BACKEND FOR BTN1 TO SUBMIT VALUES

        btn1.addActionListener(this);



	//Action on click on btn4(create a new account) redirecting to signup.java
	
	 btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the SignUp window when the button is clicked
                signup.main(null);
                dispose(); // Close the Login window
            }
        });

















       }//guilogin constructor end

                                                              

	  //ACTIONS WHICH HAD TO DONE ON CLICK OF BTN1

        public void actionPerformed(ActionEvent e) {

	String userinput=tusername.getText();
	String userpass=tpassword.getText();

	if (e.getSource() == btn1) {
	

	try{

	Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","attack");
        System.out.println("DATABASE CONNECTED SUCCESSFULLY...");

	ResultSet rs;
	String check="select * from records where username=? AND password=?";
	PreparedStatement pstmt=con.prepareStatement(check);
	pstmt.setString(1,userinput);
	pstmt.setString(2,userpass);
	rs=pstmt.executeQuery();



	 if (rs.next()) {
                 String usernamedb = rs.getString("username");
		 String userpassdb = rs.getString("password");
		if (!userpass.equals(userpassdb)) {
                    JOptionPane.showMessageDialog(guilogin.this, "Incorrect password. Please try again.");
 		}
 		

	 else {
                mainpage.main(null);
        	dispose(); 
	
                }
            } else {
                JOptionPane.showMessageDialog(guilogin.this, "Incorrect username. Please enter a valid username.");
            }
}
	catch(Exception e3){
	 JOptionPane.showMessageDialog(guilogin.this, "Database is not Connected");
	}//catch end




    
       }//e.getsource end
   
    }//action performed for login button








                                                                                  
}//guilogin class end


                                                            

	class login{
        public static void main(String[]arr){

        guilogin obj =new guilogin();

        obj.setVisible(true);
        obj.setSize(1920,1080);
}
}

                                                                 

