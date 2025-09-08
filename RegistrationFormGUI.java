import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegistrationFormGUI extends JFrame implements ActionListener{

	 JPanel p1, p2, p3, p4, p5;
	    JLabel l1, l2, l3, l4, l5, l6, status; 
	    JTextField t1, t2;
	    JTextArea t3, show;
	    JRadioButton r1, r2;
	    ButtonGroup gender;
	    JComboBox<Integer> cb1, cb3;
	    JComboBox<String> cb2;
	    JCheckBox c = new JCheckBox("Accept Terms and Conditions");
	    JButton b1, b2;

	    Integer years[] = {1965, 1966, 1967, 1968, 1969, 1970, 1971, 1972, 1973, 1974, 1975, 1976, 
	        1977, 1978, 1979, 1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990, 
	        1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 
	        1999, 2000, 2001, 2002, 2003, 2004,2005,2006,2007,2008,2009,2010,2011,2012,
	        2013,2014,2015,2016,2017,2018,2019,2020,2021,2022,
	        2023,2024,2025};

	    String months[]= {"Jan","Feb", "Mar", "Apr", "May", "Jun",
	                "Jul","Aug","Sept","Oct","Nov","Dec"};

	    Integer days[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
	        11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 
	        21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};

	    public RegistrationFormGUI(){  
	    	//LABELS
	    	l1 = new JLabel("Registration Form", SwingConstants.CENTER);
	        l1.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
	        l1.setBounds(30, 20, 600, 40);
	        l2 = new JLabel("Name");
	        l3 = new JLabel("Mobile");
	        l4 = new JLabel("Gender");
	        l5 = new JLabel("DOB");
	        l6 = new JLabel("Address", 0);
	        l6.setBounds(0, -10, 0, 0);
	        status = new JLabel("", SwingConstants.CENTER);
	        status.setBounds(70, 480, 170, 30);

	        //RADIOS
	        r1 = new JRadioButton("Male");
	        r2 = new JRadioButton("Female");
	        gender = new ButtonGroup();
	        gender.add(r1);
	        gender.add(r2);

	        //TEXTFIELDS & TEXTAREAS
	        t1 = new JTextField(15);
	        t2 = new JTextField(10);
	        t3 = new JTextArea();
	        t3.setPreferredSize(new Dimension(150, 60));
	        show = new JTextArea();
	        show.setBounds(330, 90, 300, 400);

	        //PANELS
	        p1 = new JPanel(new FlowLayout(0,25, 20));
	        p1.setBounds(30, 70, 250, 400);
	        p2 = new JPanel();
	        p3 = new JPanel(new BorderLayout());
	        p3.setPreferredSize(new Dimension(140, 50));
	        p4 = new JPanel();
	        p5 = new JPanel(new GridLayout(1, 1 , 10, 0));
	        p5.setPreferredSize(new Dimension(200, 20));

	        //COMBOBOX
	        cb1 = new JComboBox<>(years);
	        cb2 = new JComboBox<>(months);
	        cb3 = new JComboBox<>(days);

	        //BUTTONS
	        b1 = new JButton("Submit");
	        b2 = new JButton("Reset");

	        //ADDING TO PANEL
	        p5.add(b1);
	        p5.add(b2);
	        p4.add(c);
	        p2.add(cb3);
	        p2.add(cb2);
	        p2.add(cb1);
	        p1.add(l2);
	        p1.add(t1);
	        p1.add(l3);
	        p1.add(t2);
	        p1.add(l4);
	        p1.add(r1);
	        p1.add(r2);
	        p1.add(l5);
	        p1.add(p2);
	        p1.add(l6);
	        p1.add(t3);
	        p1.add(p4);
	        p1.add(p5);
	        
	        //FUNCTIONS
	        b1.addActionListener(this);
	        b2.addActionListener(this);

	        //FRAME
	        this.setLayout(null);
	        this.setTitle("Registration Form");
	        this.add(l1);
	        this.add(p1);
	        this.add(show);
	        this.add(status);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
	        this.setSize(700, 600);
	    }
	    public static void main(String[] args) {
	      new RegistrationFormGUI();
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	   if(e.getSource() == b1){
	               try {
	                     if(t1.getText().isEmpty()|| t2.getText().isEmpty()|| t3.getText().isEmpty()){
	                       JOptionPane.showMessageDialog(this, "You must complete every textfield.", "Exception catched", JOptionPane.ERROR_MESSAGE);
	                       throw new Exception("Everything must be filled.");
	                   } else if (!r1.isSelected() && !r2.isSelected()) {
	                       JOptionPane.showMessageDialog(this, "Please choose a gender.", "Exception catched", JOptionPane.ERROR_MESSAGE);
	                       throw new Exception("No gender is selected.");

	                   }else{
	                   try {
	                    boolean checked = c.isSelected();
	                   int mb = Integer.parseInt(t2.getText());
	                       if(r1.isSelected() && checked == true){
	                           show.setText("Name: "+t1.getText()+"\nMobile: "+mb+"\nGender: "+r1.getText()+"\nDOB: "+cb3.getSelectedItem()+"/"+cb2.getSelectedItem()+"/"+cb1.getSelectedItem()+"\nAddress: "+t3.getText());
	                           status.setText("Registered Successfully..");
	                       } else if(r2.isSelected() && checked == true){
	                           show.setText("Name: "+t1.getText()+"\nMobile: "+mb+"\nGender: "+r2.getText()+"\nDOB: "+cb3.getSelectedItem()+"/"+cb2.getSelectedItem()+"/"+cb1.getSelectedItem()+"\nAddress: "+t3.getText());
	                           status.setText("Registered Successfully..");
	                       } else{
	                           JOptionPane.showMessageDialog(this, "You must accept terms and conditions before continuing.", "Exception catched", JOptionPane.ERROR_MESSAGE);
	                           throw new Exception("Terms & Conditions is not Checked.");
	                       }   
	               }  catch (NumberFormatException ex) {
	                   JOptionPane.showMessageDialog(this, "Enter a valid number.", "Exception catched", JOptionPane.ERROR_MESSAGE);
	                   System.err.println("Must be no letters in textfield 2.");
	               } catch(Exception exc){
	                   System.err.println(exc.getMessage());
	               } 
	           }
	               } catch (Exception exx) {
	                   System.err.println(exx.getMessage());
	               }
	               
	           } else if(e.getSource() == b2){
	               t1.setText("");
	               t2.setText("");
	               t3.setText("");
	               show.setText("");
	               c.setSelected(false);
	               gender.clearSelection();
	               status.setText("");
	           }
	       }
}