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
	
	path = new JTextField("");
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
			if ((extension.getText()!=null && !extension.getText().isEmpty())  &&  (changeFrom.getText()!=null && !changeFrom.getText().isEmpty())  &&	(changeTo.getText()!=null && !changeTo.getText().isEmpty())  && 	(path.getText()!=null && !path.getText().isEmpty()) && !path.getText().endsWith(":\\") )
				{
				FileFinder finder = new FileFinder(path.getText(),extension.getText());
				if (finder.exists==1){
					FileChanger changer = new FileChanger();
					changer.ChangeFile(finder.filesfound, changeFrom.getText(), changeTo.getText());
					JOptionPane message = new JOptionPane();
					message.showMessageDialog(null,"Liczba zmienionych plików: "+changer.howmanyfiles);
				}
				else{
					JOptionPane message = new JOptionPane();
					message.showMessageDialog(null,"Podana œcie¿ka nie istnieje.");
				}
			}
			else{
				
				if (path.getText().endsWith(":\\")){
					JOptionPane message = new JOptionPane();
					message.showMessageDialog(null,"Nie mo¿na przeskanowaæ ca³ego dysku "+path.getText().charAt(0));
				}
				else{
					JOptionPane message = new JOptionPane();
					message.showMessageDialog(null,"Uzupe³nij wszystkie pola");
				}
			}
		}

	}
	
}



