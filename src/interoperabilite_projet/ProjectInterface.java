package interoperabilite_projet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

import javax.swing.*;

public class ProjectInterface extends JFrame {
	
	private JPanel pan =new JPanel();
	private JButton bouton=new JButton ("Clique");
	private JLabel lab = new JLabel("hello");
	private JFileChooser file=new JFileChooser();
	private JTextField text= new JTextField();
	public ProjectInterface(){
		setTitle("projet interopérabilité");
		setSize(900, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		text.setText("test test");
		double x=text.getBounds().getMaxX();
		System.out.println(x);
		double y=text.getBounds().getMaxY();
		System.out.println(y);
		setLayout(new BorderLayout());
		getContentPane().add(file, BorderLayout.WEST);
		getContentPane().add(text);
		
	
		 ActionListener actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        JFileChooser theFileChooser = (JFileChooser) actionEvent.getSource();
		        String command = actionEvent.getActionCommand();
		        if (command.equals(JFileChooser.APPROVE_SELECTION)) {
		          File selectedFile = theFileChooser.getSelectedFile();
		          text.setText("blam blam \n");
		          String fileName=selectedFile.getName();
		          
		          file.hide();
		          try 
		 			{
		  			BufferedReader inStream  
		      				= new BufferedReader (new FileReader(fileName));
		 			String line = inStream.readLine();  
		 		 	while (line != null)
		 		 	 {   
		 		 		System.out.println(line);
		     	      text.setText(line);               
				      line = inStream.readLine();                  
		  			}
		   			inStream.close();                              
		  			} catch (Exception e) 
		  				{
		              text.setText("Exception cause: "+e);
		   		      e.printStackTrace();
		  				}	
		          
		          System.out.println(selectedFile.getParent());
		          System.out.println(selectedFile.getName());
		        } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
		          System.out.println(JFileChooser.CANCEL_SELECTION);
		        }
		      }
		    };
		
		file.addActionListener(actionListener);
		
		
		setVisible(true);
		
		
	}

	
	
	public static void main(String []args){
		ProjectInterface f1= new ProjectInterface();
			
	
	
	}

	
	
	
	
}
