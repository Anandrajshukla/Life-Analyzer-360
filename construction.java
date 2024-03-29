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

class guiconstruct extends JFrame implements ActionListener{
    JPanel p1,p2;
    JLabel lheading,lconsthead,lconsttext,larea,lareacross,lresult,lresult2,lresult3,lresult4,lresult5,lcolumn,lresult6,liconhome;
    JTextField tlength,twidth,tcolumn;
    JTextArea textArea;
    JScrollPane scrollPane;
    JButton btn1,btn2,btn3;
    JComboBox column;
    
double area,bars,sand;

    
    public void actionPerformed(ActionEvent arr) {
       
       
   }


  
    public guiconstruct() {
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setPreferredSize(new Dimension(1920, 1360)); 
        
         
        JScrollPane scrollPaneForP1 = new JScrollPane(p1);
	scrollPaneForP1.setBounds(0, 0, 1920, 1080); 
        scrollPaneForP1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


	
    
	//Declaration of Labels :    

        lheading = new JLabel("LifeAnalyzer 360");
        lconsthead = new JLabel("CONSTRUCTION ANALYSIS"); 
    	lconsttext=new JLabel("<html> In a world where architecture shapes the landscape of our aspirations, the CONSTRUCTION ANALYSIS project emerges as a guiding light, illuminating the intricate path of construction planning and material management. Rooted in Java's versatility, this project seeks to empower both homeowners and builders with a comprehensive toolkit for precision and efficiency in the realm of construction.<br><br>The  CONSTRUCTION ANALYSIS project is more than just numbers and formulas; it's a testament to efficiency and sustainability. By delivering accurate estimates of required materials – TMT bars, sand, ballast (gitti), and cement – the project empowers individuals with the knowledge needed to optimize their resources and reduce waste. It transforms construction into a dance of precision, where each component plays a vital role in the symphony of creation </html>"); 
    	
    	
    	
    	
    	//adding another panel
	p2 = new JPanel();
	p2.setLayout(null);
	p2.setBounds(400,650,1000,700);
	p2.setBackground(Color.BLACK);
	LineBorder lineBorder = new LineBorder(Color.CYAN,4);
        p2.setBorder(lineBorder);
        p1.add(p2);
	
	
    	
    	
    	larea  = new JLabel("Enter the Length & Width of your house (in ft) : ");
    	lareacross = new JLabel(" × ");
        lresult = new JLabel();
        lresult2 = new JLabel();
        lresult3 = new JLabel();
        lresult4 = new JLabel();
        lresult5 = new JLabel();
        lresult6 = new JLabel();
        Icon img = new ImageIcon("home.png");
	liconhome = new JLabel(img);
               
    	
    	//Position of labels :
	
	
  
        lheading.setBounds(740, 100, 800, 70);
        lconsthead.setBounds(100, 280, 550, 30);
	lconsttext.setBounds(100, 360, 1560, 185);

        lheading.setForeground(Color.BLACK);
        lconsthead.setForeground(Color.WHITE);
        lconsttext.setForeground(Color.BLACK);
        
            
        lheading.setFont(lheading.getFont().deriveFont(60f));
        lconsthead.setFont(lconsthead.getFont().deriveFont(35f));
        lconsttext.setFont(lconsttext.getFont().deriveFont(19f));
             
	  
	larea.setBounds(70, 60, 500, 25);
        lareacross.setBounds(710, 60, 100, 30);
	lresult.setBounds(70,210,550,30);
	lresult2.setBounds(70,260,550,30);
	lresult3.setBounds(70,310,850,30);
	lresult4.setBounds(70,360,550,30);
	lresult5.setBounds(70,410,550,30);
	lresult6.setBounds(70,590, 780, 30);
	liconhome.setBounds(-320,-234,800,1050);
	
        
        larea.setForeground(Color.WHITE);
        lareacross.setForeground(Color.WHITE);
        lresult.setForeground(Color.CYAN);
        lresult2.setForeground(Color.CYAN);
        lresult3.setForeground(Color.CYAN);
        lresult4.setForeground(Color.CYAN);
        lresult5.setForeground(Color.CYAN);
        lresult6.setForeground(Color.CYAN);
        
           
        larea.setFont(larea.getFont().deriveFont(16f));
        lareacross.setFont(lareacross.getFont().deriveFont(18f));
        lresult.setFont(lresult.getFont().deriveFont(14f));
        lresult2.setFont(lresult2.getFont().deriveFont(14f));
        lresult3.setFont(lresult3.getFont().deriveFont(14f));
        lresult4.setFont(lresult4.getFont().deriveFont(14f));
        lresult5.setFont(lresult5.getFont().deriveFont(14f));
        lresult6.setFont(lresult6.getFont().deriveFont(14f));
        
        
        //ADDING BACKGROUND
        ImageIcon backgroundImage = new ImageIcon("background.png"); 
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1920, 1500);
        backgroundLabel.setOpaque(true); 
	backgroundLabel.setBackground(new Color(255, 255, 255, 150));
        getContentPane().add(backgroundLabel);
    
             
	
	//Declaration of textfields :
	          
        tlength=new JTextField();
        twidth=new JTextField();
	tcolumn=new JTextField();


	
	//Position of Textfields :
	
	
	tlength.setBounds(550, 60, 150, 25);
        twidth.setBounds(750, 60, 150, 25);
        tcolumn.setBounds(450,510, 200, 30);
        
        
        btn1=new JButton("CALCULATE");
	btn1.setBounds(650,130,150,30);
	
	
	
	btn2=new JButton("R E S E T");
	btn2.setBounds(300,130,150,30);
	
        
	btn3=new JButton("CALCULATE");
	btn3.setBounds(740,510, 180, 30);
	
	lcolumn  = new JLabel("IF YOU WANT TO KNOW HOW MUCH TMT BARS WOULD BE REQUIRED IN COLUMNS : ");
        lcolumn.setBounds(70,450,750,20);
        lcolumn.setForeground(Color.WHITE);
        lcolumn.setFont(lcolumn.getFont().deriveFont(14f));
        
	
	
	String[] columnItems = {"SELECT HEIGHT","10 FEET", "13 FEET", "20 FEET"};
        JComboBox<String> column = new JComboBox<>(columnItems);
	column.setBounds(70,510,300,30);
        
	
	
	
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

         
         
         //HOVER FOR BTN3 SUBMIT
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
	
	     liconhome.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Handle the click event here
   	mainpage.main(null);
        dispose(); // Close the current JFrame
   
    }
});
                                                                                                                                              

        //ACTION CLICK OF CALCULATE BUTTON
    	btn1.addActionListener(new ActionListener() {
    
  	
 	public void actionPerformed(ActionEvent arr) {

        
            String lengthstr = tlength.getText();
            String widthstr = twidth.getText();
            
  	if(arr.getSource() == btn1){
            try {
                double length = Double.parseDouble(lengthstr);
                double width = Double.parseDouble(widthstr);
               
                area = length * width;
                bars = area * .65;
                sand = area * .25;
                int cement = (int) (area * .06);
                
                 SwingUtilities.invokeLater(() -> {
                lresult.setText("• YOUR HOUSE'S TOTAL AREA IN SQUARE FEET IS : " +area+ " Square feet");
                lresult2.setText("• TOTAL TMT BAR IN LENTAR REQUIRED IN HOUSE IS : " +bars+ " Kgs");
                lresult3.setText("• TOTAL SAND (MAURAM) IN LENTAR REQUIRED IN HOUSE IS : " +sand+ " FEET (1 TROLLEY = 100 FEET)");
                lresult4.setText("• TOTAL BALLAST (GITTI) IN LENTAR REQUIRED IN HOUSE IS : " +sand+ " FEET");
                lresult5.setText("• TOTAL CEMENT IN LENTAR REQUIRED IN HOUSE IS : " +cement+ " BAGS");
                
                
                
                repaint(); 
            });
                System.out.println("calculation is successful");

                
            } catch (NumberFormatException ex) {
                lresult.setText("Invalid input. Please enter valid numbers.");
                lresult2.setText("");
            }
       } //if end
       
       else{System.out.println("invalid");};
    }

  } );    //btn1 actionlistner end 
  
  
  
 	


         
 	 //BACKEND FOR BTN2 TO RESET VALUES

	btn2.addActionListener(new ActionListener(){

	//ACTIONS WHICH HAD TO DONE ON CLICK OF BTN2 RESET
	public void actionPerformed(ActionEvent arr){

        if(arr.getSource() == btn2){

	try{

	   tlength.setText(null);
	   twidth.setText(null);
       	   lresult.setText(null);
       	   lresult2.setText(null);
       	   lresult3.setText(null);
       	   lresult4.setText(null);
	   lresult5.setText(null);
	   lresult6.setText(null);
	   column.setSelectedIndex(0);
	   tcolumn.setText(null);



	 }//try end

	catch(Exception e2){
	System.out.println("Problem is :"+e2);
	}//catch end

	}//if end

	else{System.out.println("source is invalid");}

	}//actionperformed2 end
	}
	);

        





	 //// ACTION CLICK ON SECOND CALCULATE BUTTON (BTN3) 

	btn3.addActionListener(new ActionListener(){

	//ACTIONS WHICH HAD TO DONE ON CLICK OF BTN2 RESET
	public void actionPerformed(ActionEvent arr){

        if(arr.getSource() == btn3){

	try{

	   
	String selectedColumn = (String) column.getSelectedItem();
        String quantitystr =tcolumn.getText();
        double quantity = Double.parseDouble(quantitystr);
        
        if(selectedColumn.equals("10 FEET")){
        	
        	double result = 10 * quantity;
        	lresult6.setText("• In "+quantity+" columns of size "+selectedColumn+" Total Tmt bar required would be "+result+" Kgs");
                
        }
	
	else if(selectedColumn.equals("13 FEET")){
        
          	double result = 14 * quantity;
      		lresult6.setText("• In "+quantity+" columns of size "+selectedColumn+" Total Tmt bar required would be "+result+" Kgs");
                
        }
		
	else if(selectedColumn.equals("20 FEET")){
        
		double result = 20 * quantity;
                lresult6.setText("• In "+quantity+" columns of size "+selectedColumn+" Total Tmt bar required would be "+result+" Kgs");
                
        }
	
	
	
	else if(selectedColumn.equals("SELECT HEIGHT")){
        	
	        lresult6.setText("• PLEASE ENTER THE VALID VALUE");        
        }
	
		
	else{
	
	System.out.println("invalid");
	
	}


	 }//try end

	catch(Exception e2){
	System.out.println("Problem is :"+e2);
	}//catch end

	}//if end

	else{System.out.println("source is invalid");}

	}//actionperformed3 end
	}
	);
	
      	// ACTION CLICK ON SECOND CALCULATE BUTTON (BTN3) END 

        
        
        
        
        
       getContentPane().add(scrollPaneForP1);
        
        p1.add(lheading);
        p1.add(lconsthead);
        p1.add(lconsttext);
        p2.add(larea);
        p2.add(lareacross);
        p2.add(tlength);
        p2.add(twidth);
        p2.add(lresult);
    	p2.add(lresult2);
    	p2.add(lresult3);
    	p2.add(lresult4);
    	p2.add(lresult5);
    	p1.add(liconhome);
    	p2.add(lcolumn);
    	p2.add(column);
        p2.add(tcolumn);
    	p2.add(btn1);
        p2.add(btn2);
        p2.add(btn3);
        p2.add(lresult6);
        p1.add(backgroundLabel);
        
        
        
        
        
        
    

    
}//constructor end

	







}//main class end








class construction {
    public static void main(String[] arr) {
        guiconstruct obj = new guiconstruct();
        obj.setVisible(true);
        obj.setSize(1920, 10880);
        
        
        
    }
}

