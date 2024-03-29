import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.border.LineBorder;
public class trip extends JFrame implements ActionListener {

    JPanel p1, p2;
    JLabel lheading, lborrowhead, lborrowtext,lname, lstartdate, lenddate, ldestination, lactivities,lroute,lto,lto2,liconhome;
    JTextArea tactivities;
    JTextField tname, tstartdate, tenddate, tdestination,troute,troute2,troute3;
    JButton btnRecord,btnreset,btnshow;

    Connection con;
    Statement stmt;

    public trip() {

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setPreferredSize(new Dimension(1920, 1360));


	JScrollPane scrollPaneForP1 = new JScrollPane(p1);
	scrollPaneForP1.setBounds(0, 0, 1920, 1080); 
        scrollPaneForP1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	lheading = new JLabel("LifeAnalyzer 360");
        lborrowhead = new JLabel(" TRIP PLANNER "); 
    	lborrowtext=new JLabel("<html> we present TRIP PLANNER, a dynamic project designed to simplify and enhance the art of documenting your travel experiences.TRIP PLANNER is a user-friendly travel planning and memory-retention system that empowers users to create, store, and revisit their travel itineraries and adventures. With its intuitive interface.<br><br> TRIP PLANNER transforms the way we record and reminisce about our journeys. The application enables users to effortlessly input vital information such as trip name, start and end dates, destinations, and a comprehensive list of planned activities. By offering a structured framework for capturing these details, TRIP PLANNER ensures that no precious moment is forgotten, no matter how busy life may become.</html>"); 
    	
    	Icon img = new ImageIcon("home.png");
	liconhome = new JLabel(img);
liconhome.setBounds(-320,-234,800,1050);
    	


        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 650, 1000, 700);
        p2.setBackground(Color.BLACK);
        LineBorder lineBorder = new LineBorder(Color.CYAN, 4);
        p2.setBorder(lineBorder);

        p1.add(p2);


	lheading.setBounds(740, 100, 800, 70);
	lborrowhead.setBounds(100, 280,550, 30);
	lborrowtext.setBounds(100, 360, 1560, 185);
	
	lheading.setForeground(Color.BLACK);
	lborrowhead.setForeground(Color.WHITE);
	lborrowtext.setForeground(Color.BLACK);
	
	   lheading.setFont(lheading.getFont().deriveFont(60f));
        lborrowhead.setFont(lborrowhead.getFont().deriveFont(35f));
        lborrowtext.setFont(lborrowtext.getFont().deriveFont(19f));


         lname = new JLabel("Name:");
   	 lstartdate = new JLabel("Start Date:");
   	 lenddate = new JLabel("End Date:");
   	 lroute = new JLabel("Route : ");
   	 lto = new JLabel("to");
   	 lto2 = new JLabel("to");
   	 
   	 ldestination = new JLabel("Destination:");
  	 lactivities = new JLabel("Activities:");

    //ADDING BACKGROUND
        ImageIcon backgroundImage = new ImageIcon("background.png"); 
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1920, 1500);
        backgroundLabel.setOpaque(true); 
	backgroundLabel.setBackground(new Color(255, 255, 255, 150));
        getContentPane().add(backgroundLabel);
    

    // Set bounds for the labels
  	  lname.setBounds(300, 80, 150, 30);
  	  lstartdate.setBounds(300, 130, 200, 30);
  	  lenddate.setBounds(300, 180, 200, 30);
  	  lroute.setBounds(300, 230, 200, 30);
  	  lto.setBounds(650, 270, 200, 30);
	  lto2.setBounds(650, 340, 200, 30);
  	  
  	  ldestination.setBounds(300, 430, 200, 30);
  	  lactivities.setBounds(300, 480, 200, 30);

    
    	 lname.setForeground(Color.WHITE);
         lstartdate.setForeground(Color.WHITE);
         lenddate.setForeground(Color.WHITE);
         ldestination.setForeground(Color.WHITE);
         lactivities.setForeground(Color.WHITE);
         lroute.setForeground(Color.WHITE);
        lto.setForeground(Color.WHITE);
        lto2.setForeground(Color.WHITE);
        
    
    	lname.setFont(lname.getFont().deriveFont(16f));
        lstartdate.setFont(lstartdate.getFont().deriveFont(16f));
        lenddate.setFont(lenddate.getFont().deriveFont(16f));
        ldestination.setFont(ldestination.getFont().deriveFont(16f));
        lactivities.setFont(lactivities.getFont().deriveFont(16f));
        lroute.setFont(lroute.getFont().deriveFont(16f));
        lto.setFont(lto.getFont().deriveFont(16f));
        lto2.setFont(lto2.getFont().deriveFont(16f));
        
    
    
    
    
    
    
    
    
    
        // Create text fields
       	 tname = new JTextField();
       	 tstartdate = new JTextField();
       	 tenddate = new JTextField();
       	 troute = new JTextField();
       	 troute2 = new JTextField();
      	  troute3 = new JTextField();
      	  tdestination = new JTextField();
       	 tactivities = new JTextArea();
	

        tname.setBounds(565, 80, 230, 30);
    	tstartdate.setBounds(565, 130, 230, 30);
    	tenddate.setBounds(565, 180, 230, 30);
    	troute.setBounds(565, 230, 230, 30);
    	troute2.setBounds(565, 305, 230, 30);
	troute3.setBounds(565, 373, 230, 30);
		
    	tdestination.setBounds(565, 430, 230, 30);
    	tactivities.setBounds(565, 480, 230, 80);
    

        // Create the "Record" button
        btnRecord = new JButton("R E C O R D");
        btnRecord.setBounds(690, 600, 145, 30);
        btnRecord.addActionListener(this); // Attach action listener

       
        // Create the "Record" button
        btnreset = new JButton("R E S E T");
        btnreset.setBounds(140, 600, 145, 30);
        
        // Create the "Record" button
        btnshow = new JButton("SHOW RECORDS");
        btnshow.setBounds(410, 600, 245, 30);
        
        
        
        
        liconhome.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Handle the click event here
   	mainpage.main(null);
        dispose(); // Close the current JFrame
   
    }
});





	//HOVER FOR btnRecord SUBMIT
	btnRecord.addMouseListener( new MouseAdapter()
	{
	public void mouseEntered(MouseEvent e){

	btnRecord.setBackground(Color.GRAY);
	btnRecord.setForeground(Color.BLACK);
	}

	public void mouseExited(MouseEvent e){

	btnRecord.setBackground(Color.WHITE);
	btnRecord.setForeground(Color.BLACK);

	}


 	}

	);//hover for btnRecord end
	
	
	
	
	
	//HOVER FOR btnreset RESET

	btnreset.addMouseListener(new MouseAdapter (){

	public void  mouseEntered(MouseEvent e){

	btnreset.setBackground(Color.GRAY);
	btnreset.setForeground(Color.BLACK);

	}

	public void  mouseExited(MouseEvent e){

	btnreset.setBackground(Color.WHITE);
	btnreset.setForeground(Color.BLACK);

	}
	}

	); //hover for btnreset end


       
       //HOVER FOR btnshow SUBMIT
	btnshow.addMouseListener( new MouseAdapter()
	{
	public void mouseEntered(MouseEvent e){

	btnshow.setBackground(Color.GRAY);
	btnshow.setForeground(Color.BLACK);
	}

	public void mouseExited(MouseEvent e){

	btnshow.setBackground(Color.WHITE);
	btnshow.setForeground(Color.BLACK);

	}


 	}

	);//hover for btnshow end
	
       
       
        
 	 //BACKEND FOR BTN2 TO RESET VALUES

	btnreset.addActionListener(new ActionListener(){

	//ACTIONS WHICH HAD TO DONE ON CLICK OF BTN2 RESET
	public void actionPerformed(ActionEvent arr){

        if(arr.getSource() == btnreset){

	try{

	   tname.setText(null);
	   tstartdate.setText(null);
       	   tenddate.setText(null);
       	   troute.setText(null);
       	   troute.setText(null);
	   troute2.setText(null);
       	   troute3.setText(null);
       	   tdestination.setText(null);
       	   tactivities.setText(null);
       	   

	 }//try end

	catch(Exception e2){
	System.out.println("Problem is :"+e2);
	}//catch end

	}//if end

	else{System.out.println("source is invalid");}

	}//actionperformed2 end
	}
	);

        

       
       
 	 //BACKEND FOR BTN2 TO RESET VALUES

	btnshow.addActionListener(new ActionListener(){

	//ACTIONS WHICH HAD TO DONE ON CLICK OF BTN2 RESET
	public void actionPerformed(ActionEvent arr){

        if(arr.getSource() == btnshow){

	try{

	 checktrip.main(null);
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

       
       
       
       
        // Add components to the panel
       
       
       
        getContentPane().add(scrollPaneForP1);
        
        
        p2.add(lname);
    	p2.add(lstartdate);
    	p2.add(lenddate);
    	p2.add(lroute);
    	p2.add(lto);
    	p2.add(lto2);
    	p2.add(ldestination);
    	p2.add(lactivities);
    	p1.add(liconhome);
        
        p2.add(tname);
        p2.add(tstartdate);
        p2.add(tenddate);
        p2.add(troute);
        p2.add(troute2);
        p2.add(troute3);
        
        p2.add(tdestination);
        p2.add(tactivities);
        
        p2.add(btnRecord);
        p2.add(btnreset);
	p2.add(btnshow);

        p1.add(lheading);
        p1.add(lborrowhead);
        p1.add(lborrowtext);
        
        p1.add(backgroundLabel);
        
        
       

    }

    public void actionPerformed(ActionEvent e) {
        String name = tname.getText();
        String startDate = tstartdate.getText();
        String endDate = tenddate.getText();
        String Route = troute.getText();
        String Route2 = troute2.getText();
        String Route3 = troute3.getText();   
        String destination = tdestination.getText();
        String activities = tactivities.getText();

        if (e.getSource() == btnRecord) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "attack");
                System.out.println("DATABASE CONNECTED SUCCESSFULLY...");

                Statement stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO trips (name, start_date, end_date, route, route2, route3, destination, activities) VALUES ('"
                        + name + "','" + startDate + "','" + endDate + "','"  + Route + "','" + Route2 + "','"  + Route3 + "','" + destination + "','" + activities + "')");

                JOptionPane.showMessageDialog(this, "Record inserted successfully..");

            } catch (Exception e1) {
                System.out.println("Database connection error: " + e1);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            trip trippPage = new trip();
            trippPage.setSize(1920, 1080);
            trippPage.setVisible(true);
        });
    }
}

