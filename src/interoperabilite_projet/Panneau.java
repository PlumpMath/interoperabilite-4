package interoperabilite_projet;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panneau extends JPanel{
	
	public void paint(Graphics g){
		
		System.out.println("blam balam");
		g.drawOval(20, 20, 75, 75);
	}


	
}
