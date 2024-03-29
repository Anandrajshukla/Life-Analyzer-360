import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.border.LineBorder;
import java.sql.*;
import java.lang.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;


class borrowmanage extends JFrame implements ActionListener{

JPanel p1,p2;
JLabel lheading,lborrowhead,lborrowtext, lID, lname,lcontact,lamount,ldate,lduedate,lreason,liconhome;
JTextField tID,tname,tcontact,tamount;
JTextArea treason;
JScrollPane scrollPane;
JButton btn1,btn2;
JFormattedTextField tdate,tduedate;
	 Connection con;
        Statement stmt;



	public borrowmanage(){

	p1 = new JPanel();
	p1.setLayout(null);
	p1.setPreferredSize(new Dimension(1920, 1360)); 

  
        JScrollPane scrollPaneForP1 = new JScrollPane(p1);
	scrollPaneForP1.setBounds(0, 0, 1920, 1080); 
        scrollPaneForP1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


	//Declaration of Labels :    

        lheading = new JLabel("OUR PROJECT");
        lborrowhead = new JLabel(" BORROW MANAGEMENT "); 
    	lborrowtext=new JLabel("<html>In a world characterized by constant interactions and exchanges, it's not uncommon for individuals to lend or borrow items from friends, family, or even customers. Often, these transactions can become complex to keep track of, leading to misunderstandings and forgotten obligations. To address this issue, we present the Borrow Analysis project, a Java-based solution designed to streamline the process of recording and managing borrowings from friends and customers.<br><br>The Borrow Analysis project aims to provide a user-friendly and efficient platform that allows users to easily input, organize, and monitor borrowed items. Whether you're lending a book to a friend, borrowing a tool from a neighbor, or managing loans from customers in a small business, this project offers a systematic way to maintain a clear record of borrowings, thus promoting transparency and accountability.</html>"); 
    	

//adding another panel
	p2 = new JPanel();
	p2.setLayout(null);
	p2.setBounds(400,650,1000,700);
	p2.setBackground(Color.BLACK);
	LineBorder lineBorder = new LineBorder(Color.CYAN,4);
        p2.setBorder(lineBorder);

	
	p1.add(p2);

// label name

lID = new JLabel("ID :");
lname = new JLabel("Name :");
lcontact = new JLabel("Contact :");
lamount = new JLabel("Amount :");
ldate = new JLabel("Date :");
lduedate = new JLabel("Due Date :");
lreason = new JLabel("Reason :");
Icon img = new ImageIcon("home.png");
	liconhome = new JLabel(img);
// set bounds

lheading.setBounds(740, 100, 800, 70);
lborrowhead.setBounds(100, 280,550, 30);
lborrowtext.setBounds(100, 360, 1560, 185);
lID.setBounds(270,109,300,50);
lname.setBounds(270,146,300,50);
lcontact.setBounds(270,186,300,50);
lamount.setBounds(270,227,300,50);
ldate.setBounds(270, 265, 300,50);
lduedate.setBounds(270,306,300,50);
lreason.setBounds(270,347,300,50);
liconhome.setBounds(-320,-234,800,1050);

//set color of a label

lheading.setForeground(Color.BLACK);
lborrowhead.setForeground(Color.WHITE);
lborrowtext.setForeground(Color.BLACK);
lID.setForeground(Color.WHITE);
lname.setForeground(Color.WHITE);
lcontact.setForeground(Color.WHITE);
lamount.setForeground(Color.WHITE);
ldate.setForeground(Color.WHITE);
lduedate.setForeground(Color.WHITE);
lreason.setForeground(Color.WHITE);
// set a font size of a label
    
        lheading.setFont(lheading.getFont().deriveFont(60f));
        lborrowhead.setFont(lborrowhead.getFont().deriveFont(35f));
        lborrowtext.setFont(lborrowtext.getFont().deriveFont(19f));
//lheading.setFont(lheading.getFont().deriveFont(36f));
lID.setFont(lID.getFont().deriveFont(20f));
lname.setFont(lname.getFont().deriveFont(20f));
lcontact.setFont(lcontact.getFont().deriveFont(20f));
lamount.setFont(lamount.getFont().deriveFont(20f));
ldate.setFont(ldate.getFont().deriveFont(20f));
lduedate.setFont(lduedate.getFont().deriveFont(20f));
lreason.setFont(lreason.getFont().deriveFont(20f));
// Background gradient
 	ImageIcon backgroundImage = new ImageIcon("background.png"); 
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1920, 1500);
        backgroundLabel.setOpaque(true); 
        backgroundLabel.setBackground(new Color(255, 255, 255, 150));
        getContentPane().add(backgroundLabel);

// test field
tID = new JTextField();
tname = new JTextField();
tcontact = new JTextField();
tamount = new JTextField();
treason = new JTextArea();
tdate = new JFormattedTextField();
tduedate = new JFormattedTextField();

// text field bounds

tID.setBounds(465,118,230,30);
tname.setBounds(465,158,230,30);
tcontact.setBounds(465,198,230,30);
tamount.setBounds(465,238,230,30);
treason.setBounds(465,358,230,50);
tdate.setBounds(465, 278, 230, 30);
 tduedate.setBounds(465, 318, 230, 30);
// date field

try {
            MaskFormatter dateinput = new MaskFormatter("####-##-##");
            tdate = new JFormattedTextField(dateinput);
            tdate.setBounds(465, 278, 230, 30);
        } catch (ParseException e) {
            e.printStackTrace();

        }
// due date field
try {
	 MaskFormatter dateinput = new MaskFormatter("####-##-##");
            tduedate = new JFormattedTextField(dateinput);
            tduedate.setBounds(465, 318, 230, 30);
        } catch (ParseException e) {
            e.printStackTrace();
     }

// butoon

	btn1=new JButton("R E C O R D");
        btn1.setBounds(660,490,145,30);

	btn2=new JButton("C H E C K   R E C O R D S");
        btn2.setBounds(180,490,198,30);

//HOVER FOR BTN1 SUBMIT
        btn1.addMouseListener( new MouseAdapter()
        {
        public void mouseEntered(MouseEvent e){

        btn1.setBackground(Color.GRAY);
        btn1.setForeground(Color.BLACK);
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

        btn2.setBackground(Color.GRAY);
        btn2.setForeground(Color.BLACK);

        }

        public void  mouseExited(MouseEvent e){

        btn2.setBackground(Color.WHITE);
        btn2.setForeground(Color.BLACK);

        }
        }

        ); //hover for btn2 end
        
  
  liconhome.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Handle the click event here
   	mainpage.main(null);
        dispose(); // Close the current JFrame
   
    }
});
  
        	 //BACKEND FOR BTN2 TO RESET VALUES

	btn2.addActionListener(new ActionListener(){

	//ACTIONS WHICH HAD TO DONE ON CLICK OF BTN2 RESET
	public void actionPerformed(ActionEvent arr){

        if(arr.getSource() == btn2){

	try{

      	checkborrow.main(null);
        
        dispose(); 
    

	 }//try end

	catch(Exception e2){
	System.out.println("Problem is :"+e2);
	}//catch end

	}//if end

	else{System.out.println("source is invalid");}

	}//actionperformed2 end
	}
	);

 



getContentPane().add(scrollPaneForP1);

p1.add(lheading);
p1.add(lborrowhead);
p1.add(lborrowtext);
p2.add(lID);
p2.add(lname);
p2.add(lcontact);
p2.add(lamount);
p2.add(ldate);
p2.add(lduedate);
p2.add(lreason);
p1.add(liconhome);
p2.add(tID);
p2.add(tname);
p2.add(tamount);
p2.add(tcontact);
p2.add(tdate);
p2.add(tduedate);
p2.add(treason);

p2.add(btn1);
p2.add(btn2);
p1.add(backgroundLabel);

    //BACKEND FOR BTN1 TO Records VALUES

        btn1.addActionListener(this);
	


} // borrow constructor end

 //Action performed on btn 1

        public void actionPerformed(ActionEvent arr){

        String id =tID.getText();
        String name =tname.getText();
        String contact =tcontact.getText();
        String amount =tamount.getText();
        String date =tdate.getText();
        String due_date =tduedate.getText();
	String reason = treason.getText();

        if(arr.getSource() == btn1){
        try{

        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdata","root","attack");
        System.out.println("DATABASE CONNECTED SUCCESSFULLY...");
 //insert the user given input to the database(bdata in table reecords)


        if(id.isEmpty() || name.isEmpty() || contact.isEmpty() || amount.isEmpty() || date.isEmpty() || due_date.isEmpty()){

        if(id.isEmpty())
        {JOptionPane.showMessageDialog(this,"ID is Required");     }
        else if(name.isEmpty())
        {JOptionPane.showMessageDialog(this,"Name is Required");     }
        else if(contact.isEmpty())
        {JOptionPane.showMessageDialog(this,"Contact is Required");     }
        else if(amount.isEmpty())
        {JOptionPane.showMessageDialog(this,"Amount is Required");     }
        else if(date.isEmpty())
        {JOptionPane.showMessageDialog(this,"Date is Required");     }
        else if(due_date.isEmpty())
        {JOptionPane.showMessageDialog(this,"Due Date is Required");     }

}//validation if end

	else{
 if(date.equals(due_date)){
        JOptionPane.showMessageDialog(this,"Different Due_Date is required");

}

        else{


        Statement stmt=con.createStatement();
        stmt.executeUpdate("insert into borrow values('"+id+"','"+name+"','"+amount+"','"+contact+"','"+date+"','"+due_date+"','"+reason+"')");

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


} // borrow class end
class borrow{

	public static void main(String []ar)
	{
	borrowmanage frame = new borrowmanage();
	frame.setSize(1920, 1080);
	frame.setVisible(true);
	}
}
