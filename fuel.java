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
    JLabel lheading,lfuelhead,lfueltext,ldistance,lmileage,lrate,lresult,lresult2,lresult3,liconhome;
    JTextField tdistance,tmileage,trate;
    JTextArea textArea;
    JScrollPane scrollPane;
    JButton btn1,btn2;
    JComboBox versionComboBox,bikeComboBox;
    
    double fuelrequired,cost,mileage; 

    
    public void actionPerformed(ActionEvent arr) {
       
       
   }


  
    public guifuel() {
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setPreferredSize(new Dimension(1920, 1860)); 
        
         
        
        
        
        JScrollPane scrollPaneForP1 = new JScrollPane(p1);
	scrollPaneForP1.setBounds(0, 0, 1920, 1080); 
        scrollPaneForP1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


	
    
	//Declaration of Labels :    

        lheading = new JLabel("LifeAnalyzer 360");
        lfuelhead = new JLabel(" FUEL ANALYSIS "); 
    	lfueltext=new JLabel("<html>In a world that's constantly on the move, optimizing our resources has become more crucial than ever. Imagine having a tool that not only helps you plan your journey but also ensures you make the most efficient use of your vehicle's fuel. Welcome to LifeAnalyzer 360 – your personal travel companion designed to provide you with accurate fuel consumption estimates for your bike or car journeys.<br><br>LifeAnalyzer 360 is a user-friendly and innovative project that aims to simplify your travel planning while promoting eco-friendly practices. By inputting the distance you intend to travel, you'll receive an estimate of the amount of petrol your vehicle would require. Whether you're embarking on a short city commute or planning a long road trip, LifeAnalyzer 360 ensures you have a clear understanding of the fuel resources you'll need, allowing you to make informed decisions and contribute to a greener environment.</html>"); 
    	
    	
    	
    	
    	//adding another panel
	p2 = new JPanel();
	p2.setLayout(null);
	p2.setBounds(400,650,1000,700);
	p2.setBackground(Color.BLACK);
	LineBorder lineBorder = new LineBorder(Color.CYAN,4);
        p2.setBorder(lineBorder);

	
	p1.add(p2);
	
	
    	
    	
    	ldistance  = new JLabel("Enter the distance(km) you want to travel : ");
        lmileage = new JLabel(" Enter the mileage of your bike : "); 
        lrate = new JLabel("  Enter the Rate of petrol in your city : "); 
        lresult = new JLabel();
        lresult2 = new JLabel();
        lresult3 = new JLabel();
         Icon img = new ImageIcon("home.png");
	liconhome = new JLabel(img);      
    	
    	//Position of labels :
	
	
  
        lheading.setBounds(740, 100, 800, 70);
        lfuelhead.setBounds(100, 280, 550, 30);
	lfueltext.setBounds(100, 360, 1560, 185);

        lheading.setForeground(Color.BLACK);
        lfuelhead.setForeground(Color.WHITE);
        lfueltext.setForeground(Color.BLACK);
        
            
        lheading.setFont(lheading.getFont().deriveFont(60f));
        lfuelhead.setFont(lfuelhead.getFont().deriveFont(35f));
        lfueltext.setFont(lfueltext.getFont().deriveFont(19f));
             
	  
	ldistance.setBounds(70, 250, 500, 25);
        lmileage.setBounds(66, 320, 500, 25);
	lrate.setBounds(63, 390, 500, 25);
	lresult.setBounds(70,600,550,30);
	lresult2.setBounds(70,650,550,30);
	lresult3.setBounds(630,85,400,35);
	liconhome.setBounds(-320,-234,800,1050);
		
        ldistance.setForeground(Color.WHITE);
        lmileage.setForeground(Color.WHITE);
        lrate.setForeground(Color.WHITE);
        lresult.setForeground(Color.CYAN);
        lresult2.setForeground(Color.CYAN);
        lresult3.setForeground(Color.CYAN);
	        
           
        ldistance.setFont(ldistance.getFont().deriveFont(14f));
        lmileage.setFont(lmileage.getFont().deriveFont(14f));
        lrate.setFont(lfueltext.getFont().deriveFont(14f));
        lresult.setFont(lfueltext.getFont().deriveFont(14f));
        lresult2.setFont(lfueltext.getFont().deriveFont(14f));
        lresult3.setFont(lfueltext.getFont().deriveFont(16f));
        
        //ADDING BACKGROUND
        ImageIcon backgroundImage = new ImageIcon("background.png"); 
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1920, 1500);
        backgroundLabel.setOpaque(true); 
	backgroundLabel.setBackground(new Color(255, 255, 255, 150));
        getContentPane().add(backgroundLabel);
    
             
	
	
	//Declaration of textfields :
	          
        tdistance=new JTextField();
        tmileage=new JTextField();
	trate=new JTextField();


	
	//Position of Textfields :
	
	
	tdistance.setBounds(530, 250, 250, 25);
        tmileage.setBounds(530, 320, 250, 25);
        trate.setBounds(530,390, 250, 25);
        
        
        btn1=new JButton("CALCULATE");
	btn1.setBounds(530,500,150,30);
	
	
	
	btn2=new JButton("R E S E T");
	btn2.setBounds(300,500,150,30);
	
        
        
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

                                                                                                                                                            

        //ACTION CLICK OF CALCULATE BUTTON
    	btn1.addActionListener(new ActionListener() {
    
  	
 	public void actionPerformed(ActionEvent arr) {

        
            String distancestr = tdistance.getText();
            String mileagestr = tmileage.getText();
            String ratestr = trate.getText();
  	if(arr.getSource() == btn1){
            try {
                double distance = Double.parseDouble(distancestr);
                double mileage = Double.parseDouble(mileagestr);
                double rate = Double.parseDouble(ratestr);

                fuelrequired = distance / mileage;
                cost = fuelrequired * rate;
                
                 SwingUtilities.invokeLater(() -> {
                lresult.setText("• REQUIRED FUEL IS " + fuelrequired+ " Litre");
                lresult2.setText("• TOTAL COST REQUIRED IS : " + cost+ " Rupees");
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
  
  
liconhome.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Handle the click event here
   	mainpage.main(null);
        dispose(); // Close the current JFrame
   
    }
});  
 	
	//COMBOBOX ACTIVITY FOR BIKES

	
	
	 JComboBox<String> bikeComboBox = new JComboBox<>(new String[]{"Select Bike", "Hero Motocorp","Bajaj","Tvs","Royal Enfield","KTM","Yamaha","Kawasaki","Honda","Suzuki"});
        bikeComboBox.setBounds(100,50,200,35);
        bikeComboBox.setBackground(Color.WHITE);

        // Bike Version Combo Box
        JComboBox<String> versionComboBox = new JComboBox<>();
        versionComboBox.setBounds(380,50,200,35);
	versionComboBox.setBackground(Color.WHITE);
        

        // Add ActionListener to the Bike ComboBox
        bikeComboBox.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String selectedBike = (String) bikeComboBox.getSelectedItem();
                if (!selectedBike.equals("Select Bike")) {
                    
                    String[] bikeVersions = getBikeVersions(selectedBike);
                    versionComboBox.setModel(new DefaultComboBoxModel<>(bikeVersions));
                } else {
                    
                    versionComboBox.setModel(new DefaultComboBoxModel<>());
                }
            }
        });
        
        
        
        
        versionComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedVersion = (String) versionComboBox.getSelectedItem();
                getMileageForVersion(selectedVersion);
                if (selectedVersion != null && !selectedVersion.equals("Select Version")) {
                    //System.out.
                }
            }
        });

	//COMBOBOX ACTIVITY BIKE END         



	//COMBOBOX ACTIVITY FOR CARS

	JComboBox<String> carComboBox = new JComboBox<>(new String[]{"Select Car", "Tata", "Maruti Suzuki", "Hyundai", "Honda", "Kia", "Nissan", "Renault", "Toyota", "Skoda", "Ford"});
	carComboBox.setBounds(100, 120, 200, 35);
	carComboBox.setBackground(Color.WHITE);

	// Car Version Combo Box
	JComboBox<String> carversionComboBox = new JComboBox<>();
	carversionComboBox.setBounds(380, 120, 200, 35);
	carversionComboBox.setBackground(Color.WHITE);
	
	// Add ActionListener to the Car ComboBox
	carComboBox.addActionListener(new ActionListener() {
	
	    public void actionPerformed(ActionEvent e) {
	        String selectedCar = (String) carComboBox.getSelectedItem();
	        if (!selectedCar.equals("Select Car")) {
	
	            String[] carVersions = getCarVersions(selectedCar);
	            carversionComboBox.setModel(new DefaultComboBoxModel<>(carVersions));
	        } else {

	            carversionComboBox.setModel(new DefaultComboBoxModel<>());
	        }
	    }
	});
	
	carversionComboBox.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String selectedVersion = (String) carversionComboBox.getSelectedItem();
	        getMileageForVersioncar(selectedVersion);
	        if (selectedVersion != null && !selectedVersion.equals("Select Version")) {
	            
	            
	            
	        }
	    }
	});



	//COMBOBOX ACTIVITY CAR END







         
 	 //BACKEND FOR BTN2 TO RESET VALUES

	btn2.addActionListener(new ActionListener(){

	//ACTIONS WHICH HAD TO DONE ON CLICK OF BTN2 RESET
	public void actionPerformed(ActionEvent arr){

        if(arr.getSource() == btn2){

	try{

	   tdistance.setText(null);
	   tmileage.setText(null);
       	   trate.setText(null);
       	   lresult.setText(null);
       	   lresult2.setText(null);
	   lresult3.setText(null);
       	   bikeComboBox.setSelectedIndex(0);
           versionComboBox.setSelectedIndex(0);
       	   carComboBox.setSelectedIndex(0);
           carversionComboBox.setSelectedIndex(0);
       	
      

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
        p2.add(ldistance);
	p1.add(liconhome);
        p2.add(lmileage);
        p2.add(lrate);
        p2.add(tdistance);
        p2.add(tmileage);
    	p2.add(trate);
    	p2.add(btn1);
        p2.add(btn2);
    	p2.add(lresult);
    	p2.add(lresult2);
    	p2.add(lresult3);
    	p2.add(bikeComboBox);
    	p2.add(versionComboBox);
        p2.add(carComboBox);
    	p2.add(carversionComboBox);
        p1.add(backgroundLabel);
        
        
        
        
        
        
    

    
}//constructor end

	//BACKEND OF BIKE ACTIVITY 

	public String[] getBikeVersions(String selectedBike) {
   
    if (selectedBike.equals("Hero Motocorp")) {
        return new String[]{"Select Version", "Splendor Plus", "HF Deluxe", "Xplus 200cc", "Xtreme 160R", "Glamour", "Passion Plus"};
   
    } else if (selectedBike.equals("Bajaj")) {
        return new String[]{"Select Version", "CT 100", "Platina 100", "Pulsar 150", "Pulsar NS 200", "Dominar 400", "Avenger Cruise 220", "Avenger Street 160"};
   
    } else if (selectedBike.equals("Tvs")) {
        return new String[]{"Select Version", "Sport", "Star City", "Radeon", "Apache RTR 160", "Radier 160", "XL100", "Ronin", "Apache 310"};
   
    } else if (selectedBike.equals("Royal Enfield")) {
        return new String[]{"Select Version", "Meteor 350", "Himalayan", "Scram 411", "Classic 350", "Continental GT 650", "Interceptor 650", "Super Meteor 650"};
   
    } else if (selectedBike.equals("KTM")) {
        return new String[]{"Select Version", "200 Duke", "250 Duke", "RC 200", "125 Duke", "RC 390", "RC 125", "390 Adventure"};
   
    } else if (selectedBike.equals("Kawasaki")) {
        return new String[]{"Select Version", "W175 170cc", "Ninja H2R", "Z900 948cc", "Ninja ZX- 10R", "650 649cc", "Ninja 300 296cc", "Ninja 1000 1043cc", "Z650 649cc"};
   
    } else if (selectedBike.equals("Honda")) {
        return new String[]{"Select Version", "SP 125cc", "CD 110 cc Dream", "Livo", "Shine", "X-Blade", "CB20X", "Hornet 2.0", "Dream Yuga", "Dream Neo"};
   
    } else if (selectedBike.equals("Yamaha")) {
    return new String[]{"Select Version", "FZ", "Ray ZR", "Fascino 125", "FZ X", "FZ FI", "FZS", "MT 15", "FZ S FI"};
}

	else if (selectedBike.equals("Suzuki")) {
    return new String[]{"Select Version", "Gixxer", "Gixxer SF", "V-Strom SX", "Gixxer SF 250", "V-Strom 650 XT", "Hayabusa"};
}
	
   
   
   else {
        return new String[]{"Select Bike"};
    }
}

    
    
   public void getMileageForVersion(String version) {
    
    if (version.endsWith("Splendor Plus")) {
    lresult3.setText("• Mileage of " + version + " is 70 Kpl");
} else if (version.endsWith("HF Deluxe")) {
    lresult3.setText("• Mileage of " + version + " is 70 Kpl");
} else if (version.endsWith("Xplus 200cc")) {
    lresult3.setText("• Mileage of " + version + " is 51.59 Kpl");
} else if (version.endsWith("Xtreme 160R")) {
    lresult3.setText("• Mileage of " + version + " is 55.47 Kpl");
} else if (version.endsWith("Glamour")) {
    lresult3.setText("• Mileage of " + version + " is 55 Kpl");
} else if (version.endsWith("Passion Plus")) {
    lresult3.setText("• Mileage of " + version + " is 45 Kpl");
}

    else if (version.equals("CT 100")) {
    lresult3.setText("• Mileage of " + version + " is 89.5 Kpl");
} else if (version.equals("Platina 100")) {
    lresult3.setText("• Mileage of " + version + " is 80 Kpl");
} else if (version.equals("Pulsar 150")) {
    lresult3.setText("• Mileage of " + version + " is 50 Kpl");
} else if (version.equals("Pulsar NS 200")) {
    lresult3.setText("• Mileage of " + version + " is 36 Kpl");
} else if (version.equals("Dominar 400")) {
    lresult3.setText("• Mileage of " + version + " is 29 Kpl");
} else if (version.equals("Avenger Cruise 220")) {
    lresult3.setText("• Mileage of " + version + " is 40 Kpl");
} else if (version.equals("Avenger Street 160")) {
    lresult3.setText("• Mileage of " + version + " is 45 Kpl");
}
    
    else if (version.equals("Sport")) {
    lresult3.setText("• Mileage of " + version + " is 68 Kpl");
} else if (version.equals("Star City")) {
    lresult3.setText("• Mileage of " + version + " is 68 Kpl");
} else if (version.equals("Radeon")) {
    lresult3.setText("• Mileage of " + version + " is 65 Kpl");
} else if (version.equals("Apache RTR 160")) {
    lresult3.setText("• Mileage of " + version + " is 45 Kpl");
} else if (version.equals("Radier 160")) {
    lresult3.setText("• Mileage of " + version + " is 56 Kpl");
} else if (version.equals("XL100")) {
    lresult3.setText("• Mileage of " + version + " is 52 Kpl");
} else if (version.equals("Ronin")) {
    lresult3.setText("• Mileage of " + version + " is 42.95 Kpl");
} else if (version.equals("Apache 310")) {
    lresult3.setText("• Mileage of " + version + " is 30 Kpl");
}
   
   
   
   else if (version.equals("Meteor 350")) {
    lresult3.setText("• Mileage of " + version + " is 32 Kpl");
} else if (version.equals("Himalayan")) {
    lresult3.setText("• Mileage of " + version + " is 32 Kpl");
} else if (version.equals("Scram 411")) {
    lresult3.setText("• Mileage of " + version + " is 29 Kpl");
} else if (version.equals("Classic 350")) {
    lresult3.setText("• Mileage of " + version + " is 32 Kpl");
} else if (version.equals("Continental GT 650")) {
    lresult3.setText("• Mileage of " + version + " is 25 Kpl");
} else if (version.equals("Interceptor 650")) {
    lresult3.setText("• Mileage of " + version + " is 23 Kpl");
} else if (version.equals("Super Meteor 650")) {
    lresult3.setText("• Mileage of " + version + " is 23 Kpl");
}

    
   else if (version.equals("200 Duke")) {
    lresult3.setText("• Mileage of " + version + " is 33 Kpl");
} else if (version.equals("250 Duke")) {
    lresult3.setText("• Mileage of " + version + " is 41 Kpl");
} else if (version.equals("RC 200")) {
    lresult3.setText("• Mileage of " + version + " is 35 Kpl");
} else if (version.equals("125 Duke")) {
    lresult3.setText("• Mileage of " + version + " is 46.92 Kpl");
} else if (version.equals("RC 390")) {
    lresult3.setText("• Mileage of " + version + " is 25.89 Kpl");
} else if (version.equals("RC 125")) {
    lresult3.setText("• Mileage of " + version + " is 41 Kpl");
} else if (version.equals("390 Adventure")) {
    lresult3.setText("• Mileage of " + version + " is 30 Kpl");
}

    
    
 else if (version.equals("W175 170cc")) {
    lresult3.setText("• Mileage of " + version + " is 45 Kpl");
} else if (version.equals("Ninja H2R")) {
    lresult3.setText("• Mileage of " + version + " is 15 Kpl");
} else if (version.equals("Z900 948cc")) {
    lresult3.setText("• Mileage of " + version + " is 15 Kpl");
} else if (version.equals("Ninja ZX- 10R")) {
    lresult3.setText("• Mileage of " + version + " is 15 Kpl");
} else if (version.equals("650 649cc")) {
    lresult3.setText("• Mileage of " + version + " is 21 Kpl");
} else if (version.equals("Ninja 300 296cc")) {
    lresult3.setText("• Mileage of " + version + " is 26 Kpl");
} else if (version.equals("Ninja 1000 1043cc")) {
    lresult3.setText("• Mileage of " + version + " is 17 Kpl");
} else if (version.equals("Z650 649cc")) {
    lresult3.setText("• Mileage of " + version + " is 18 Kpl");
}


else if (version.equals("SP 125cc")) {
    lresult3.setText("• Mileage of " + version + " is 65 Kpl");
} else if (version.equals("CD 110 cc Dream")) {
    lresult3.setText("• Mileage of " + version + " is 62 Kpl");
} else if (version.equals("Livo")) {
    lresult3.setText("• Mileage of " + version + " is 59 Kpl");
} else if (version.equals("Shine")) {
    lresult3.setText("• Mileage of " + version + " is 55 Kpl");
} else if (version.equals("X-Blade")) {
    lresult3.setText("• Mileage of " + version + " is 50 Kpl");
} else if (version.equals("CB20X")) {
    lresult3.setText("• Mileage of " + version + " is 43 Kpl");
} else if (version.equals("Hornet 2.0")) {
    lresult3.setText("• Mileage of " + version + " is 57.35 Kpl");
} else if (version.equals("Dream Yuga")) {
    lresult3.setText("• Mileage of " + version + " is 72 Kpl");
} else if (version.equals("Dream Neo")) {
    lresult3.setText("• Mileage of " + version + " is 74 Kpl");
}


else if (version.equals("Gixxer")) {
    lresult3.setText("• Mileage of " + version + " is 45 Kpl");
} else if (version.equals("Gixxer SF")) {
    lresult3.setText("• Mileage of " + version + " is 45 Kpl");
} else if (version.equals("V-Strom SX")) {
    lresult3.setText("• Mileage of " + version + " is 36 Kpl");
} else if (version.equals("Gixxer SF 250")) {
    lresult3.setText("• Mileage of " + version + " is 35 Kpl");
} else if (version.equals("V-Strom 650 XT")) {
    lresult3.setText("• Mileage of " + version + " is 25 Kpl");
} else if (version.equals("Hayabusa")) {
    lresult3.setText("• Mileage of " + version + " is 18 Kpl");
}




else if (version.equals("R15")) {
    lresult3.setText("• Mileage of " + version + " is 51 Kpl");
} else if (version.equals("Ray ZR")) {
    lresult3.setText("• Mileage of " + version + " is 49 Kpl");
} else if (version.equals("Fascino 125")) {
    lresult3.setText("• Mileage of " + version + " is 49 Kpl");
} else if (version.equals("FZ X")) {
    lresult3.setText("• Mileage of " + version + " is 48 Kpl");
} else if (version.equals("FZ FI")) {
    lresult3.setText("• Mileage of " + version + " is 48 Kpl");
} else if (version.equals("FZS")) {
    lresult3.setText("• Mileage of " + version + " is 48 Kpl");
} else if (version.equals("MT 15")) {
    lresult3.setText("• Mileage of " + version + " is 47 Kpl");
} else if (version.equals("FZ S FI")) {
    lresult3.setText("• Mileage of " + version + " is 45 Kpl");
}


    
     else if (version.equals("Select Version")) {
        lresult3.setText(""); 
    } else {
        lresult3.setText("• Mileage: 50 km/l");
    }
    
    
    
    
}

	//BACKEND OF BIKE ACTIVITY ENDS



	
	
	
	
	//BACKEND OF BIKE ACTIVITY 


	public static String[] getCarVersions(String selectedCar) {
	    // Return car versions based on the selected car
	    if (selectedCar.equals("Tata")) {
	        return new String[]{"Select Version", "Tiago", "Tigor", "Altroz","Nexon","Harrier"};
	    } else if (selectedCar.equals("Maruti Suzuki")) {
        return new String[]{"Select Version", "Swift", "Baleno", "Alto","swift Dzire","Vitara Brezza","Ertiga"};
	    } else if (selectedCar.equals("Hyundai")) {
	        return new String[]{"Select Version", "Venue", "Verna", "i20", "Alcazar"};
	    }
	      else if (selectedCar.equals("Honda")) {
	        return new String[]{"Select Version", "Amaze", "City"};
	    } 
	    
	      else if (selectedCar.equals("Kia")) {
	        return new String[]{"Select Version", "Seltos", "Carnival"};
	    } 
	    
	     else if (selectedCar.equals("Nissan")) {
	        return new String[]{"Select Version", "Magnite"};
	    } 
	    
	     else if (selectedCar.equals("Renault")) {
	        return new String[]{"Select Version", "Triber","Kiger","Kwid"};
	    } 
	    
	    
	     else if (selectedCar.equals("Toyota")) {
	        return new String[]{"Select Version", "Fortuner","Innova Hycross","Glaza","Fortuner Legender"};
	    } 
	    
	     else if (selectedCar.equals("Skoda")) {
	        return new String[]{"Select Version", "Slavia","Kushaq","Superb","Kodiaq"};
	    } 
	    
	    
	     else if (selectedCar.equals("Ford")) {
	        return new String[]{"Select Version", "Endeavour","Figo","Aspire","Ecosport","Mustang"};
	    }
	      else {
	        return new String[0];
	    }
	}
	
	
	
	
	
	public void getMileageForVersioncar(String version) {
	    if (version.equals("Tiago")) {
        lresult3.setText("• Mileage of " + version + " is 23-27 Kpl");
	    } else if (version.equals("Tigor")) {
	        lresult3.setText("• Mileage of " + version + " is 20-24 Kpl");
	    } else if (version.equals("Altroz")) {
	        lresult3.setText("• Mileage of " + version + " is 19-23 Kpl");
	    }
	    
	    else if (version.equals("Nexon")) {
	        lresult3.setText("• Mileage of " + version + " is 17-21 Kpl");
	    }else if (version.equals("Harrier")) {
	        lresult3.setText("• Mileage of " + version + " is 14-17 Kpl");
	    }else if (version.equals("Swift")) {
	        lresult3.setText("• Mileage of " + version + " is 21-24 Kpl");
	    }else if (version.equals("Baleno")) {
	        lresult3.setText("• Mileage of " + version + " is 19-23 Kpl");
	    }else if (version.equals("Alto")) {
	        lresult3.setText("• Mileage of " + version + " is 22-24 Kpl");
	    }else if (version.equals("swift Dzire")) {
	        lresult3.setText("• Mileage of " + version + " is 23-25 Kpl");
	    }else if (version.equals("Vitara Brezza")) {
	        lresult3.setText("• Mileage of " + version + " is 18-21 Kpl");
	    }else if (version.equals("Ertiga")) {
	        lresult3.setText("• Mileage of " + version + " is 18-20 Kpl");
	    }else if (version.equals("Venue")) {
	        lresult3.setText("• Mileage of " + version + " is 23 Kpl");
	    }else if (version.equals("Verna")) {
	        lresult3.setText("• Mileage of " + version + " is 21 Kpl");
	    }else if (version.equals("i20")) {
	        lresult3.setText("• Mileage of " + version + " is 20 Kpl");
	    }else if (version.equals("Alcazar")) {
	        lresult3.setText("• Mileage of " + version + " is 20 Kpl");
	    }else if (version.equals("Amaze")) {
	        lresult3.setText("• Mileage of " + version + " is 19 Kpl");
	    }else if (version.equals("City")) {
	        lresult3.setText("• Mileage of " + version + " is 18 Kpl");
	    }else if (version.equals("Seltos")) {
	        lresult3.setText("• Mileage of " + version + " is 21 Kpl");
	    }else if (version.equals("Carnival")) {
	        lresult3.setText("• Mileage of " + version + " is 14 Kpl");
	    }else if (version.equals("Magnite")) {
	        lresult3.setText("• Mileage of " + version + " is 20 Kpl");
	    }else if (version.equals("Triber")) {
	        lresult3.setText("• Mileage of " + version + " is 19 Kpl");
	    }else if (version.equals("Kiger")) {
	        lresult3.setText("• Mileage of " + version + " is 21 Kpl");
	    }else if (version.equals("Kwid")) {
	        lresult3.setText("• Mileage of " + version + " is 22 Kpl");
	    }else if (version.equals("Fortuner")) {
	        lresult3.setText("• Mileage of " + version + " is 15 Kpl");
	    }else if (version.equals("Innova Hycross")) {
	        lresult3.setText("• Mileage of " + version + " is 16 Kpl");
	    }else if (version.equals("Glaza")) {
	        lresult3.setText("• Mileage of " + version + " is 23 Kpl");
	    }else if (version.equals("Fortuner Legender")) {
	        lresult3.setText("• Mileage of " + version + " is 14 Kpl");
	    }else if (version.equals("Slavia")) {
	        lresult3.setText("• Mileage of " + version + " is 20 Kpl");
	    }else if (version.equals("Kushaq")) {
	        lresult3.setText("• Mileage of " + version + " is 20 Kpl");
	    }else if (version.equals("Superb")) {
	        lresult3.setText("• Mileage of " + version + " is 15 Kpl");
	    }else if (version.equals("Kodiaq")) {
	        lresult3.setText("• Mileage of " + version + " is 13 Kpl");
	    }else if (version.equals("Endeavour")) {
	        lresult3.setText("• Mileage of " + version + " is 13.9 Kpl");
	    }else if (version.equals("Figo")) {
	        lresult3.setText("• Mileage of " + version + " is 24.4 Kpl");
	    }else if (version.equals("Aspire")) {
	        lresult3.setText("• Mileage of " + version + " is 24.4 Kpl");
	    }else if (version.equals("Ecosport")) {
	        lresult3.setText("• Mileage of " + version + " is 21.7 Kpl");
	    }else if (version.equals("Mustang")) {
	        lresult3.setText("• Mileage of " + version + " is 7.7 Kpl");
	    
	     }else if (version.equals("Select Version")) {
	        lresult3.setText(""); 
	    } else {
	        lresult3.setText("Data Unavailable");
	    }
	}


	//BACKEND OF CAR ACTIVITY ENDS


























}//main class end








class fuel {
    public static void main(String[] arr) {
        guifuel obj = new guifuel();
        obj.setVisible(true);
        obj.setSize(1920, 1080);
        
        
        
    }
}

