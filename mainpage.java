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
import javax.swing.border.EmptyBorder;

class guimain extends JFrame {
    JPanel p1,p2;
    JLabel lheading, lintrohead, lintrotext;
    JTextArea textArea;
    JScrollPane scrollPane;
    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;


    Connection con;
    Statement stmt;


  
    public guimain() {
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setPreferredSize(new Dimension(1920, 1600));
        
        
        JScrollPane scrollPaneForP1 = new JScrollPane(p1);
	scrollPaneForP1.setBounds(0, 0, 1920, 1080); 
        scrollPaneForP1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


	
    	//adding another panel
	p2 = new JPanel();
	p2.setLayout(null);
	p2.setBounds(150,820,1600,630);
	p2.setBackground(Color.BLACK);
	LineBorder lineBorder = new LineBorder(Color.CYAN,4);
        p2.setBorder(lineBorder);

	
	p1.add(p2);

        

        lheading = new JLabel("LifeAnalyzer 360");
        lintrohead = new JLabel(" I N T R O D U C T I O N "); 
    	lintrotext=new JLabel("<html>In an increasingly busy world, managing daily life tasks can often become challenging. Introducing LifeAnalyzer 360 , a comprehensive solution designed to streamline your daily life needs. Whether it's calculating fuel consumption for your next journey or keeping track of borrowed items, our platform is here to make your life simpler and more organized.<br><br>In the fast-paced world we live in, managing various aspects of our daily lives can be a challenge. From tracking expenses to planning trips and analyzing construction projects, there's a constant need for efficient tools that simplify and enhance our decision-making process. Enter Life Analyzer 360, a comprehensive Java-based project designed to streamline and organize key areas of our lives. With six intuitive tabs encompassing Borrow Analysis, Fuel Analysis, Construction Analysis, Trip Planner, and more, Life Analyzer 360 empowers users to effortlessly enter and retrieve crucial data, transforming the way we approach everyday tasks.<br><br> Life Analyzer 360 is your ultimate lifestyle companion. This project is built on the principle that making informed decisions should be effortless and accessible to all.</html>"); 
    	
    	
  
        lheading.setBounds(740, 100, 800, 70);
        lintrohead.setBounds(100, 280, 550, 30);
	lintrotext.setBounds(100, 260, 1560, 555);

        lheading.setForeground(Color.BLACK);
        lintrohead.setForeground(Color.WHITE);
        lintrotext.setForeground(Color.BLACK);
        
        //lintrotext.setOpaque(true);
         
	   
        lheading.setFont(lheading.getFont().deriveFont(60f));
        lintrohead.setFont(lintrohead.getFont().deriveFont(35f));
        lintrotext.setFont(lintrotext.getFont().deriveFont(19f));
             
        
        ImageIcon backgroundImage = new ImageIcon("background.png"); 
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1920, 1900);
        backgroundLabel.setOpaque(true); 
	backgroundLabel.setBackground(new Color(255, 255, 255, 150));
            
        
        
	
	btn1=new JButton("<html>BORROW <br>MAINTENANCE</html>");
	btn2=new JButton("FUEL ANALYSIS");
	btn3=new JButton("TRIP PLANNER");
	btn4=new JButton("<html>FUND MANAGEMENT<br> SYSTEM</html>");
	btn5=new JButton("<html>CONSTRUCTION <br>ANALYSIS</html>");
	btn6=new JButton("<html>ELECTRONICS <br>ANALYSIS</html>");
	
	btn7=new JButton("Login");
	btn8=new JButton("Signup");
	
	


	btn1.setBounds(130,100,300,150);
	btn2.setBounds(670,100,300,150);
	btn3.setBounds(1200,100,300,150);
	
	btn4.setBounds(130,380,300,150);
	btn5.setBounds(670,380,300,150);
	btn6.setBounds(1200,380,300,150);
	
	btn7.setBounds(1300,280,100,30);
	btn8.setBounds(1600,280,100,30);
	
 
	
	btn1.setFont(btn1.getFont().deriveFont(Font.BOLD, 24));
	btn2.setFont(btn2.getFont().deriveFont(Font.BOLD, 24));
	btn3.setFont(btn3.getFont().deriveFont(Font.BOLD, 24));
	btn4.setFont(btn4.getFont().deriveFont(Font.BOLD, 24));
	btn5.setFont(btn5.getFont().deriveFont(Font.BOLD, 24));
	btn6.setFont(btn6.getFont().deriveFont(Font.BOLD, 24));
	
	btn7.setFont(btn7.getFont().deriveFont(Font.BOLD, 18));
	btn8.setFont(btn8.getFont().deriveFont(Font.BOLD, 18));
	
	btn7.setBackground(new Color(0, 0, 0, 0));
	btn7.setBorder(new EmptyBorder(0, 0, 0, 0));
	btn8.setBackground(new Color(0, 0, 0, 0));
	btn8.setBorder(new EmptyBorder(0, 0, 0, 0));
	
	btn7.setForeground(Color.BLACK);
        btn8.setForeground(Color.BLACK);
        
        
        
        
	
	
	

	//HOVER FOR BTN1 SUBMIT
	btn1.addMouseListener( new MouseAdapter()
	{
	public void mouseEntered(MouseEvent e){

	btn1.setBackground(Color.GRAY);
	btn1.setForeground(Color.CYAN);
	}

	public void mouseExited(MouseEvent e){

	btn1.setBackground(Color.WHITE);
	btn1.setForeground(Color.BLACK);

	}


 	}

	);//hover for btn1 end
	
	
	
	//HOVER FOR BTN2 SUBMIT
	btn2.addMouseListener( new MouseAdapter()
	{
	public void mouseEntered(MouseEvent e){

	btn2.setBackground(Color.GRAY);
	btn2.setForeground(Color.CYAN);
	}

	public void mouseExited(MouseEvent e){

	btn2.setBackground(Color.WHITE);
	btn2.setForeground(Color.BLACK);

	}


 	}

	);//hover for btn2 end
	
	
	
	//HOVER FOR BTN3 SUBMIT
	btn3.addMouseListener( new MouseAdapter()
	{
	public void mouseEntered(MouseEvent e){

	btn3.setBackground(Color.GRAY);
	btn3.setForeground(Color.CYAN);
	}

	public void mouseExited(MouseEvent e){

	btn3.setBackground(Color.WHITE);
	btn3.setForeground(Color.BLACK);

	}


 	}

	);//hover for btn3 end
	
	
	
	
	//HOVER FOR BTN4 SUBMIT
	btn4.addMouseListener( new MouseAdapter()
	{
	public void mouseEntered(MouseEvent e){

	btn4.setBackground(Color.GRAY);
	btn4.setForeground(Color.CYAN);
	}

	public void mouseExited(MouseEvent e){

	btn4.setBackground(Color.WHITE);
	btn4.setForeground(Color.BLACK);

	}


 	}

	);//hover for btn4 end
	
	
	
	//HOVER FOR BTN5 SUBMIT
	btn5.addMouseListener( new MouseAdapter()
	{
	public void mouseEntered(MouseEvent e){

	btn5.setBackground(Color.GRAY);
	btn5.setForeground(Color.CYAN);
	}

	public void mouseExited(MouseEvent e){

	btn5.setBackground(Color.WHITE);
	btn5.setForeground(Color.BLACK);

	}


 	}

	);//hover for btn5 end
	
	
	
	//HOVER FOR BTN6 SUBMIT
	btn6.addMouseListener( new MouseAdapter()
	{
	public void mouseEntered(MouseEvent e){

	btn6.setBackground(Color.GRAY);
	btn6.setForeground(Color.CYAN);
	}

	public void mouseExited(MouseEvent e){

	btn6.setBackground(Color.WHITE);
	btn6.setForeground(Color.BLACK);

	}


 	}

	);//hover for btn6 end
	









	btn1.addActionListener(new ActionListener() {
    
    public void actionPerformed(ActionEvent e) {
        
        borrow.main(null);
        
        dispose(); 
    	}
	});



	btn2.addActionListener(new ActionListener() {
    
    public void actionPerformed(ActionEvent e) {
        
        fuel.main(null);
        
        dispose(); 
    	}
	});
	
	
	
	btn3.addActionListener(new ActionListener() {
    
    public void actionPerformed(ActionEvent e) {
        
        trip.main(null);
        
        dispose(); 
    	}
	});
	
	
	
	btn4.addActionListener(new ActionListener() {
    
    public void actionPerformed(ActionEvent e) {
        
        fms.main(null);
        
        dispose();
    	}
	});
	
	
	
	btn5.addActionListener(new ActionListener() {
    
    public void actionPerformed(ActionEvent e) {
        
        construction.main(null);
        
        dispose(); 
    	}
	});
	
	
	
	btn6.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        //electronic.main(null);

        dispose();
    	}
	});



	btn7.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        login.main(null);

        dispose();
    	}
	});

	
	btn8.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        signup.main(null);

        dispose();
    	}
	});

	
	
	
	//HOVER FOR BTN7 SUBMIT
	btn7.addMouseListener( new MouseAdapter()
	{
	public void mouseEntered(MouseEvent e){

	
	btn7.setForeground(Color.WHITE);

	}

	public void mouseExited(MouseEvent e){

	
	btn7.setForeground(Color.BLACK);


	}


 	}

	);//hover for btn7 end
	
	
	
	
	//HOVER FOR BTN8 SUBMIT
	btn8.addMouseListener( new MouseAdapter()
	{
	public void mouseEntered(MouseEvent e){

	
	btn8.setForeground(Color.WHITE);
	}

	public void mouseExited(MouseEvent e){

	
	btn8.setForeground(Color.BLACK);

	}


 	}

	);//hover for btn8 end
	
	
	
	
	
	
	
	
	
        getContentPane().add(backgroundLabel);
    
        p1.add(lheading);
        p1.add(lintrohead);
        p1.add(lintrotext);
        p1.add(backgroundLabel);
	p1.add(btn7);
	p1.add(btn8);

	p2.add(btn1);
	p2.add(btn2);
	p2.add(btn3);
	p2.add(btn4);
	p2.add(btn5);
	p2.add(btn6);
	

	


        getContentPane().add(scrollPaneForP1);
    }

    
}

class mainpage {
    public static void main(String[] arr) {
        guimain obj = new guimain();
        obj.setVisible(true);
        obj.setSize(1920, 1080);
        
        
        
    }
}

