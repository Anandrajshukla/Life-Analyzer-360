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

class guifuel extends JFrame implements ActionListener{
    JPanel p1,p2;
    JLabel lheading,lfuelhead,lfueltext,lbudget,lresult,lresult2;
    //JTextField tbudget,trate;
    JTextArea textArea;
    JScrollPane scrollPane;
    JButton btn2;
    JComboBox versionComboBox,deviceComboBox, rateComboBox;
    
    double fuelrequired; 
    double cost; 

    
    public void actionPerformed(ActionEvent arr) {
       
       
   }


  
    public guifuel() {
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setPreferredSize(new Dimension(1920, 1360)); 
        
         
        
        
        
        JScrollPane scrollPaneForP1 = new JScrollPane(p1);
	scrollPaneForP1.setBounds(0, 0, 1920, 1080); 
        scrollPaneForP1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


	
    
	//Declaration of Labels :    

        lheading = new JLabel("OUR PROJECT");
        lfuelhead = new JLabel(" FUEL ANALYSIS "); 
    	lfueltext=new JLabel("<html>In a world that's constantly on the move, optimizing our resources has become more crucial than ever. Imagine having a tool that not only helps you plan your journey but also ensures you make the most efficient use of your vehicle's fuel. Welcome to OUR PROJECT – your personal travel companion designed to provide you with accurate fuel consumption estimates for your bike or car journeys.<br><br>OUR PROJECT is a user-friendly and innovative project that aims to simplify your travel planning while promoting eco-friendly practices. By inputting the distance you intend to travel, you'll receive an estimate of the amount of petrol your vehicle would require. Whether you're embarking on a short city commute or planning a long road trip, OUR PROJECT ensures you have a clear understanding of the fuel resources you'll need, allowing you to make informed decisions and contribute to a greener environment.</html>"); 
    	
    	
    	
    	
    	//adding another panel
	p2 = new JPanel();
	p2.setLayout(null);
	p2.setBounds(200,650,1000,700);
	p2.setBackground(Color.BLACK);
	LineBorder lineBorder = new LineBorder(Color.CYAN,4);
        p2.setBorder(lineBorder);

	
	p1.add(p2);
	
	
    	
    	
    	
        lbudget = new JLabel(" Enter your budget"); 
        lresult = new JLabel();
        lresult2 = new JLabel();
         
    	
    	//Position of labels :
	
	
  
        lheading.setBounds(775, 100, 500, 70);
        lfuelhead.setBounds(100, 280, 550, 30);
	lfueltext.setBounds(100, 360, 1560, 185);

        lheading.setForeground(Color.BLACK);
        lfuelhead.setForeground(Color.WHITE);
        lfueltext.setForeground(Color.BLACK);
        
            
        lheading.setFont(lheading.getFont().deriveFont(60f));
        lfuelhead.setFont(lfuelhead.getFont().deriveFont(35f));
        lfueltext.setFont(lfueltext.getFont().deriveFont(19f));
             
	  
	
        lbudget.setBounds(66, 170, 500, 25);
	lresult.setBounds(63, 240, 500, 25);
	lresult2.setBounds(70,550,550,30);

        lbudget.setForeground(Color.WHITE);
       
        lresult.setForeground(Color.WHITE);
        lresult2.setForeground(Color.WHITE);
           
        lbudget.setFont(lbudget.getFont().deriveFont(14f));
        
        lresult.setFont(lfueltext.getFont().deriveFont(14f));
        lresult2.setFont(lfueltext.getFont().deriveFont(14f));
        
        //ADDING BACKGROUND
        ImageIcon backgroundImage = new ImageIcon("background.png"); 
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1920, 1500);
        backgroundLabel.setOpaque(true); 
	backgroundLabel.setBackground(new Color(255, 255, 255, 150));
        getContentPane().add(backgroundLabel);
    
             
	
	
	

	
	
	
	
	btn2=new JButton("R E S E T");
	btn2.setBounds(480,310,150,30);
	
        
        
	
	
	
	
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

	); //hover for btn2 e cALCULATE BUTTON
	
	
    
  
 	


	 JComboBox<String> rateComboBox = new JComboBox<>(new String[]{"Select Budget","10,000","20,000","30,000","40,000","N/A"});
       rateComboBox.setBounds(66, 170, 500, 25);
	
	
        // Bike Version Combo Box
        JComboBox<String> versionComboBox = new JComboBox<>();
        versionComboBox.setBounds(700,510,200,30);

        JComboBox<String> deviceComboBox = new JComboBox<>(new String[]{"Select Device","Xiaomi","Realme","Samsung","One plus","I phone","Vivo","Oppo"});

        // Add ActionListener to the Device ComboBox
        rateComboBox.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String selectedRate = (String) rateComboBox.getSelectedItem();
                if (selectedRate.equals("Select Budget")) {
                    versionComboBox.setModel(new DefaultComboBoxModel<>());
                }
                else if(selectedRate.equals("10,000")){
                	 
       deviceComboBox.setBounds(130,510,200,30);
                 String[] Tenthousand = getTenthousand(selectedRate);

                    versionComboBox.setModel(new DefaultComboBoxModel<>(Tenthousand));
            }
            else if(selectedRate.equals("20,000")){
      
       deviceComboBox.setBounds(130,510,200,30);
                 String[] Tenthousand = getTenthousand(selectedRate);
                    versionComboBox.setModel(new DefaultComboBoxModel<>(Tenthousand));
            }
            else if(selectedRate.equals("30,000")){
            	
       deviceComboBox.setBounds(130,510,200,30);
                 String[] Tenthousand = getTenthousand(selectedRate);
                    versionComboBox.setModel(new DefaultComboBoxModel<>(Tenthousand));
            }
            else if(selectedRate.equals("40,000")){
       deviceComboBox.setBounds(130,510,200,30);
                 String[] Tenthousand = getTenthousand(selectedRate);
                    versionComboBox.setModel(new DefaultComboBoxModel<>(Tenthousand));
            }
            }
        });

        

         
 	 //BACKEND FOR BTN2 TO RESET VALUES

	btn2.addActionListener(new ActionListener(){

	//ACTIONS WHICH HAD TO DONE ON CLICK OF BTN2 RESET
	public void actionPerformed(ActionEvent arr){

        if(arr.getSource() == btn2){

	try{

	   lresult.setText(null);
       	   lresult2.setText(null);
       	
       	   deviceComboBox.setSelectedIndex(0);
           versionComboBox.setSelectedIndex(0);
       	
      

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
        p1.add(lfuelhead);
        p1.add(lfueltext);
        p2.add(lbudget);
        
       p2.add(btn2);
    	p2.add(lresult);
    	p2.add(lresult2);
    	p2.add(deviceComboBox);
    	p2.add(versionComboBox);
    	p2.add(rateComboBox);
        p1.add(backgroundLabel);
        
        
        
        
        
        
    
}
    /*
 deviceComboBox.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String selectedDevice = (String) deviceComboBox.getSelectedItem();
                if (selectedRate.equals("Select Device")) {
                    versionComboBox.setModel(new DefaultComboBoxModel<>());
                }
                else if(selectedDevice.equals("Xiaomi")){
                	 
       deviceComboBox.setBounds(130,510,200,30);
                 String[] Tenthousand = getTenthousand(selectedRate);

                    versionComboBox.setModel(new DefaultComboBoxModel<>(Tenthousand));
            }
            else if(selectedDevice.equals("Realme")){
      
       deviceComboBox.setBounds(130,510,200,30);
                 String[] Twentythousand = getTwentythousand(selectedRate);
                    versionComboBox.setModel(new DefaultComboBoxModel<>(Twentythousand));
            }
            else if(selectedRate.equals("Samsung");
            deviceComboBox.setBounds(130,510,200,30);
                 String[] Thirtythousand = getThirtythousand(selectedRate);
                    versionComboBox.setModel(new DefaultComboBoxModel<>(Thirtythousand));
            }
            else if(selectedRate.equals("40,000")){
       deviceComboBox.setBounds(130,510,200,30);
                 String[] Fortythousand = getFortythousand(selectedRate);
                    versionComboBox.setModel(new DefaultComboBoxModel<>(Fortythousand));
            }
            });
        

	*/

	public static String[] getTenthousand(String selectedRate) {
        // Return mobile phone version based on selected device
        if (selectedRate.equals("10,000")) {
            return new String[]{"Select Device","Xiaomi","Realme","Samsung","One plus","I phone","Vivo","Oppo"};
        } else if (selectedRate.equals("20,000")) {
            return new String[]{"Select Device","Xiaomi","Realme","Samsung","One plus","I phone","Vivo","Oppo"};

        } else if (selectedRate.equals("30,000")) {
            return new String[]{"Select Device","Xiaomi","Realme","Samsung","One plus","I phone","Vivo","Oppo"};
        } else if(selectedRate.equals("40,000")) {
          return new String[]{"Select Device","Xiaomi","Realme","Samsung","One plus","I phone","Vivo","Oppo"};
          }else {
            return new String[0];
        }
    }
    




}//main class end



class fuel3 {
    public static void main(String[] arr) {
        guifuel obj = new guifuel();
        obj.setVisible(true);
        obj.setSize(1920, 10880);        
        
        
    }
}

