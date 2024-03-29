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

class guifms extends JFrame implements ActionListener
{
    JPanel p1,p2;
    JLabel lheading,lfmshead,lfmstext,liconhome,lprinciple,lrate,ltime,lresult,lprinciple2,lrate2,ltime2,lresult2;
    JTextField tprinciple,trate,ttime,tprinciple2,trate2,ttime2;
    JTextArea textArea;
    JScrollPane scrollPane;
    JButton btn1,btn2,btn3,btn4;
    
    //double principle,rate,time,emi;
        
    public void actionPerformed(ActionEvent arr) {
       
       
   }




    public guifms() {
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setPreferredSize(new Dimension(1920, 1470)); 
        
         
        
        
        
        JScrollPane scrollPaneForP1 = new JScrollPane(p1);
	scrollPaneForP1.setBounds(0, 0, 1920, 1080); 
        scrollPaneForP1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


	
    
	//Declaration of Labels :    

        lheading = new JLabel("LifeAnalyzer 360");
        lfmshead = new JLabel(" FUND MANAGEMENT SYSTEM "); 
    	lfmstext=new JLabel("<html>Welcome to the Fund Management System – your comprehensive solution for efficient financial planning and analysis. In today's fast-paced world, managing your funds wisely is crucial for achieving your financial goals. Our Java-based application empowers you to make informed decisions by providing two essential services. <br><br> In the first service, we bring you the power of EMI (Equated Monthly Installments) calculation. With just three simple inputs – principal amount, interest rate, and time period – our system calculates the monthly installment you need to pay. Whether you're planning a home purchase, a vehicle acquisition, or any other major investment, our EMI service ensures transparency and predictability in your financial commitments. <br><br> Moving on to the second service, we delve into the realm of interest calculation. Understanding the dynamics of interest is paramount to successful financial management. With this service, you'll gain insights into the accrued interest for your chosen principal, interest rate, and time period. This information can be instrumental in assessing the profitability of various investment options, guiding your financial decisions with confidence.      </html>"); 
    	
    	
    	
    	
    	//adding another panel
	p2 = new JPanel();
	p2.setLayout(null);
	p2.setBounds(400,780,1000,670);
	p2.setBackground(Color.BLACK);
	LineBorder lineBorder = new LineBorder(Color.CYAN,4);
        p2.setBorder(lineBorder);

	
	p1.add(p2);
	
	
    	
    	
    	lprinciple  = new JLabel("Enter the principle amount you invested : ");
        lrate = new JLabel(" Enter the rate of emi (P.A) : "); 
        ltime = new JLabel("  Enter the time for you invested : "); 
        lresult = new JLabel();
        
        lprinciple2  = new JLabel("Enter the principle amount you invested : ");
        lrate2 = new JLabel(" Enter the rate of interest (P.A) : "); 
        ltime2 = new JLabel("  Enter the time for you invested : ");         
        lresult2 = new JLabel();
        
       
        Icon img = new ImageIcon("home.png");
	liconhome = new JLabel(img);      
    	
         
    	//Position of labels :
	
	
  
        lheading.setBounds(740, 100, 800, 70);
        lfmshead.setBounds(100, 280, 750, 30);
	lfmstext.setBounds(100, 360, 1560, 350);

        lheading.setForeground(Color.BLACK);
        lfmshead.setForeground(Color.WHITE);
        lfmstext.setForeground(Color.BLACK);
        
            
        lheading.setFont(lheading.getFont().deriveFont(60f));
        lfmshead.setFont(lfmshead.getFont().deriveFont(35f));
        lfmstext.setFont(lfmstext.getFont().deriveFont(19f));
             
	
	
	
	liconhome.setBounds(-320,-234,800,1050);
	
	  
	
	lprinciple.setBounds(70, 60, 500, 25);
        lrate.setBounds(66, 120, 500, 25);
	ltime.setBounds(63, 180, 500, 25);
	lresult.setBounds(70,300,950,30);
	
	lprinciple2.setBounds(70, 360, 500, 25);
        lrate2.setBounds(66, 420, 500, 25);
	ltime2.setBounds(63, 480, 500, 25);
	lresult2.setBounds(70,600,950,30);


		
        lprinciple.setForeground(Color.WHITE);
        lrate.setForeground(Color.WHITE);
        ltime.setForeground(Color.WHITE);
        lresult.setForeground(Color.CYAN);
	
	lprinciple2.setForeground(Color.WHITE);
        lrate2.setForeground(Color.WHITE);
        ltime2.setForeground(Color.WHITE);
        lresult2.setForeground(Color.CYAN);
        
           
        lprinciple.setFont(lprinciple.getFont().deriveFont(14f));
        lrate.setFont(lrate.getFont().deriveFont(14f));
        ltime.setFont(ltime.getFont().deriveFont(14f));
        lresult.setFont(lresult.getFont().deriveFont(14f));
        
        lprinciple2.setFont(lprinciple2.getFont().deriveFont(14f));
        lrate2.setFont(lrate2.getFont().deriveFont(14f));
        ltime2.setFont(ltime2.getFont().deriveFont(14f));
        lresult2.setFont(lresult2.getFont().deriveFont(14f));
        
        
        
        
        //ADDING BACKGROUND
        ImageIcon backgroundImage = new ImageIcon("background.png"); 
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1920, 1470);
        backgroundLabel.setOpaque(true); 
	backgroundLabel.setBackground(new Color(255, 255, 255, 150));
        getContentPane().add(backgroundLabel);
    
             
	
	
	//Declaration of textfields :
	          
        tprinciple=new JTextField();
        trate=new JTextField();
	ttime=new JTextField();
	
	tprinciple2=new JTextField();
        trate2=new JTextField();
	ttime2=new JTextField();


	
	//Position of Textfields :
	
	
	tprinciple.setBounds(530, 60, 250, 25);
        trate.setBounds(530, 110, 250, 25);
        ttime.setBounds(530,160, 250, 25);
        
        tprinciple2.setBounds(530, 360, 250, 25);
        trate2.setBounds(530, 420, 250, 25);
        ttime2.setBounds(530,480, 250, 25);
        
        
        btn1=new JButton("CALCULATE EMI");
	btn1.setBounds(530,235,150,30);
	
	
	
	btn2=new JButton("R E S E T");
	btn2.setBounds(300,235,150,30);
	
        
        
        btn3=new JButton("CALCULATE INTEREST");
	btn3.setBounds(530,540,200,30);
	
	
	
	btn4=new JButton("R E S E T");
	btn4.setBounds(300,540,150,30);
	
        
        
	//HOVER FOR BTN1 CALCULATE
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

        
        
        
        //HOVER FOR BTN3 CALCULATE
	btn3.addMouseListener( new MouseAdapter()
	{
	public void mouseEntered(MouseEvent e){

	btn3.setBackground(Color.GRAY);
	btn3.setForeground(Color.BLACK);
	}

	public void mouseExited(MouseEvent e){

	btn3.setBackground(Color.WHITE);
	btn3.setForeground(Color.BLACK);

	}


 	}

	);//hover for btn3 end
	                  
	                  
	                  
	                                                                                                                                                    
	//HOVER FOR BTN4 RESET
	btn4.addMouseListener( new MouseAdapter()
	{
	public void mouseEntered(MouseEvent e){

	btn4.setBackground(Color.GRAY);
	btn4.setForeground(Color.BLACK);
	}

	public void mouseExited(MouseEvent e){

	btn4.setBackground(Color.WHITE);
	btn4.setForeground(Color.BLACK);

	}


 	}

	);//hover for btn4 end
	
	
	
	
	
	
        //ACTION CLICK OF CALCULATE EMI BUTTON
    	btn1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arr) {
        String principlestr = tprinciple.getText();
        String ratestr = trate.getText();
        String timestr = ttime.getText();
        
        try {
            double principle = Double.parseDouble(principlestr);
            double rate = Double.parseDouble(ratestr);
            double time = Double.parseDouble(timestr);

            double ratef = rate / (12 * 100);
            double timef = time * 12;

            double emi = (principle * ratef * Math.pow(1 + ratef, timef)) / (Math.pow(1 + ratef, timef) - 1);

            SwingUtilities.invokeLater(() -> {
                lresult.setText("• TOTAL EMI FOR AMOUNT " + principle + " AT THE RATE OF " + rate + " FOR THE TIME OF " + time + " YEARS IS: " + emi+ " RUPEES");
                repaint();
            });
            System.out.println("Calculation is successful");
        } catch (NumberFormatException ex) {
            lresult.setText("Invalid input. Please enter valid numbers.");
        }
    }
});
  //btn1 actionlistner end 
  
  	

         
 	 //BACKEND FOR BTN2 TO RESET VALUES

	btn2.addActionListener(new ActionListener(){

	//ACTIONS WHICH HAD TO DONE ON CLICK OF BTN2 RESET
	public void actionPerformed(ActionEvent arr){

        if(arr.getSource() == btn2){

	try{

	   tprinciple.setText(null);
	   trate.setText(null);
       	   ttime.setText(null);
       	   lresult.setText(null);
       	   

	 }//try end

	catch(Exception e2){
	System.out.println("Problem is :"+e2);
	}//catch end

	}//if end

	else{System.out.println("source is invalid");}

	}//actionperformed2 end
	}
	);

        

		
        //ACTION CLICK OF CALCULATE INTEREST BUTTON
    	btn3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arr) {
        String principlestr = tprinciple2.getText();
        String ratestr = trate2.getText();
        String timestr = ttime2.getText();
        
        try {
            double principle = Double.parseDouble(principlestr);
            double rate = Double.parseDouble(ratestr);
            double time = Double.parseDouble(timestr);
            

            double interest = (principle * rate * time) / 100;

            SwingUtilities.invokeLater(() -> {
                lresult2.setText("• TOTAL SIMPLE INTEREST FOR AMOUNT " + principle + " AT THE RATE OF " + rate + " FOR THE TIME OF " + time + " YEARS IS: " + interest+ " RUPEES");
                repaint();
            });
            System.out.println("Calculation is successful");
        } catch (NumberFormatException ex) {
            lresult2.setText("Invalid input. Please enter valid numbers.");
        }
    }
});
  //btn3 actionlistner end 
  



         
 	 //BACKEND FOR BTN4 TO RESET VALUES

	btn4.addActionListener(new ActionListener(){

	//ACTIONS WHICH HAD TO DONE ON CLICK OF BTN2 RESET
	public void actionPerformed(ActionEvent arr){

        if(arr.getSource() == btn4){

	try{

	   tprinciple2.setText(null);
	   trate2.setText(null);
       	   ttime2.setText(null);
       	   lresult2.setText(null);
       	   

	 }//try end

	catch(Exception e2){
	System.out.println("Problem is :"+e2);
	}//catch end

	}//if end

	else{System.out.println("source is invalid");}

	}//actionperformed4 end
	}
	);



      

liconhome.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Handle the click event here
   	mainpage.main(null);
        dispose(); // Close the current JFrame
   
    }
});  
 
        
        
       getContentPane().add(scrollPaneForP1);
        
        p1.add(lheading);
        p1.add(lfmshead);
        p1.add(lfmstext);
        p1.add(liconhome);
        
        p2.add(lprinciple);
	p2.add(lrate);
        p2.add(ltime);
        p2.add(lprinciple2);
	p2.add(lrate2);
        p2.add(ltime2);
        
        p2.add(tprinciple);
        p2.add(trate);
    	p2.add(ttime);
    	p2.add(tprinciple2);
        p2.add(trate2);
    	p2.add(ttime2);
    	
    	p2.add(btn1);
    	p2.add(btn2);
    	p2.add(btn3);
    	p2.add(btn4);
    	
    	p2.add(lresult);
	p2.add(lresult2);
    	
        p1.add(backgroundLabel);
        

    
}//constructor end








}//main class end








class fms {
    public static void main(String[] arr) {
        guifms obj = new guifms();
        obj.setVisible(true);
        obj.setSize(1920, 1080);
        
        
        
    }
}


