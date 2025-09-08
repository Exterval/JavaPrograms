import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class TemperatureGUI extends Frame implements ActionListener{
    Label l1, l2, l3, l4, l5, l6;
    Panel p1, p2, p3, p4, p5, p6;
    Button b1 = new Button("Convert"), b2 = new Button("Convert");
    TextField t1 = new TextField(10), t2 = new TextField(10);

    public TemperatureGUI(){
        //for C to F
        l1 = new Label("Celsius to Fahrenheit");
        l2 = new Label("Start Temp: ");
        l3 = new Label("", Label.CENTER);
        p1 = new Panel(new BorderLayout());
        p1.setBounds(10, 30, 300, 85);
        p2 = new Panel(new FlowLayout());
        p3 = new Panel(new BorderLayout());
        p3.setSize(60, 60);
        p1.add(l1, BorderLayout.NORTH);
        p2.add(l2);
        p2.add(t1);
        p2.add(b1);
        p1.add(p2, BorderLayout.WEST);
        p3.add(l3, BorderLayout.CENTER);
        p1.add(p3, BorderLayout.SOUTH);
        
        b1.addActionListener(this);

        //for F to C
        l4 = new Label("Fahrenheit to Celsius");
        l5 = new Label("Start Temp: ");
        l6 = new Label("", Label.CENTER);
        p4 = new Panel(new BorderLayout());
        p5 = new Panel(new FlowLayout());
        p6 = new Panel(new BorderLayout());
        p4.setBounds(10,130, 300, 85);
        p4.add(l4, BorderLayout.NORTH);
        p5.add(l5);
        p5.add(t2);
        p5.add(b2);
        p4.add(p5, BorderLayout.WEST);
        p6.add(l6, BorderLayout.CENTER);
        p4.add(p6, BorderLayout.SOUTH);
        b2.addActionListener(this);

        //for frame
        setSize(300, 250);
        setLayout(null);
        add(p1);
        add(p4);
        setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        setTitle("Temperature Converter");
        addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent e){
        		dispose();
        	}
        });
    }

    public static void main(String[] args) {
        //main method
        new TemperatureGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == b1){
            try {
                double f = ((Double.parseDouble(t1.getText())*1.8)+32);
                l3.setText("Fahrenheit: "+new DecimalFormat("#.##").format(f));
            }
             catch (NumberFormatException ex) {
                l3.setText("Invalid Input");
                    System.err.println("Invalid input, please enter a number.");
             }
        }else if(e.getSource() == b2){
            try {
                double c = ((Double.parseDouble(t2.getText())-32)*5/9);
                l6.setText("Celsius: "+new DecimalFormat("#.##").format(c));
            } catch (NumberFormatException ex) {
                l6.setText("Invalid Input");
                System.err.println("Invalid input, please enter a number.");
            }
            }
        }       
    }
