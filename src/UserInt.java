import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class UserInt extends JFrame implements ActionListener {
	
	
			
	private JButton button;
	private JTextField path;
	private JTextField extension;
	private JTextField changeFrom;
	private JTextField changeTo;
	
	public String ext;
	public String cFrom;
	public String cTo;
	
	UserInt(){
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("File Changer");
	setSize(300,200);
	setLocationRelativeTo(null);
	
	
	setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	c.fill = GridBagConstraints.HORIZONTAL;
	JLabel label = new JLabel("proszê podaæ pe³n¹ œcie¿kê katalogu:");
	{
		c.weightx = 0.5;
		c.weighty = 0.05;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth =5;
	}
	add(label,c);
	
	path = new JTextField("C:\\");
	path.addActionListener(this);
	{
		c.weightx = 0.5;
		c.weighty = 0.2;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth =5;		
	}
	add(path,c);
	
	label = new JLabel("podaj rozszerzenie:");
	{
		c.weightx = 0.1;
		c.weighty = 0.2;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth =1;
	}
	add(label,c);
	
	extension = new JTextField("");
	extension.addActionListener(this);
	{
		c.weightx = 0.5;
		c.weighty = 0.2;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth =1;
	}
	add(extension,c);
	
	label = new JLabel("zamieñ s³owo:");
	{
		c.weightx = 0.1;
		c.weighty = 0.2;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth =1;
	}
	add(label,c);
	
	changeFrom = new JTextField("");
	changeFrom.addActionListener(this);
	{
		c.weightx = 0.5;
		c.weighty = 0.2;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth =1;
	}
	add(changeFrom,c);
	
	label = new JLabel("na s³owo:");
	{
		c.weightx = 0.1;
		c.weighty = 0.2;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth =1;
	}
	add(label,c);
	
	changeTo = new JTextField("");
	changeTo.addActionListener(this);
	{
		c.weightx = 0.5;
		c.weighty = 0.2;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth =5;
	}
	add(changeTo,c);	
	
	button = new JButton("zamieñ");
	button.addActionListener(this);
	{
		c.weightx = 0.5;
		c.weighty = 0.4;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth =2;
	}
	add(button, c);

	setVisible(true);
	}
	

	
	
	
	
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		
		if (source == button){
			FileFinder finder = new FileFinder(path.getText(),extension.getText());
			FileChanger changer = new FileChanger();
			changer.ChangeFile(finder.filesfound, changeFrom.getText(), changeTo.getText());
		}

	}
	
}



