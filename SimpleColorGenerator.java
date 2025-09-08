import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SimpleColorGenerator extends Frame implements ActionListener{
	//declare variables to be used
	Label l1, l2, l3, l4;
	TextField t1, t2, t3, t4;
	Button b1, b2;
	Panel p1, color;
	
	public SimpleColorGenerator() {
		//LABELS & PANEL
		
		p1 = new Panel(new GridLayout(5, 2));
		p1.setSize(300, 170);
		l1 = new Label("Red: ");
		t1 = new TextField("0");
		l2 = new Label("Green: ");
		t2 = new TextField("0");
		l3 = new Label("Blue: ");
		t3 = new TextField("0");
		l4 = new Label("Alpha: ");
		t4 = new TextField("0");
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		
		//BUTTONS
		b1 = new Button("Compute"); //Computing button
		b2 = new Button("Clear");//Clear button
		b1.addActionListener(this);
		b2.addActionListener(this);
		p1.add(b1);
		p1.add(b2);
		//p1.add(p2);
		
		//ColorLabel
		color = new Panel();
		color.setSize(300, 300);
		
		//FRAME
		setLayout(new BorderLayout());
		add(p1, "North");
		add(color, "Center");
		setSize(300, 300);
		setVisible(true);

	}

	public static void main(String[] args) {
		new SimpleColorGenerator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			try {
				int r = Integer.parseInt(t1.getText());
				int g = Integer.parseInt(t2.getText());
				int b = Integer.parseInt(t3.getText());
				int a = Integer.parseInt(t4.getText());
				
				Color c = new Color(r, g, b, a);
				color.setBackground(c);
			} catch(NumberFormatException e1) {
				System.err.println("Please put numeric values.");
			} catch(IllegalArgumentException e1) {
				System.err.println("Values must be in range 0-255.");
			} 
		}
		else if(e.getSource() == b2) {
			t1.setText("0");
			t2.setText("0");
			t3.setText("0");
			t4.setText("0");
			color.setBackground(Color.LIGHT_GRAY);
		}
	}

}
