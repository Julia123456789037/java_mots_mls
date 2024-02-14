package projet_java.melo.java_mots_mls.GénérationGrille.ihm;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import projet_java.melo.java_mots_mls.GénérationGrille.Controleur;

public class GrilleBout extends JPanel implements ActionListener 
{
	private Controleur			ctrl;
	private JButton[][] tabButton;
	private char[][] gril;
	private ArrayList<String>	lstMots;
	private boolean bout1Enc;
	private JButton bout1;
	private JButton bout2;

	public GrilleBout( Controleur ctr, char[][] tab, ArrayList<String> lstMot ) 
	{
		this.ctrl = ctr;
		this.gril = tab;
		this.lstMots = lstMot;
		this.setLayout (new GridLayout(this.gril.length,this.gril[0].length));
		this.setSize    (800,500);

		// Création des Controles

		for (int i = 0; i < this.gril.length; i++) {
			for (int j = 0; j < this.gril[i].length; j++) {
				tabButton[i][j] = new JButton( "" + this.gril[i][j] ) ;
			}
		}

		// Activation des Controles
		for (int i = 0; i < this.gril.length; i++) {
			for (int j = 0; j < this.gril[i].length; j++) {
				this.tabButton[i][j].addActionListener( this );
			}
		}

		// Positionnement des Controles


		//this.pack();                          
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{    
		if ( ! bout1Enc) {

			for (int i = 0; i < this.gril.length; i++) {
				for (int j = 0; j < this.gril[i].length; j++) {
					if (e.getSource() == this.tabButton[i][j])  
					{
						this.bout1 = this.tabButton[i][j];
						bout1Enc = true;
					}  
				}
			}
		}        

		if (bout1Enc) {
			for (int i = 0; i < this.gril.length; i++) {
				for (int j = 0; j < this.gril[i].length; j++) {


					if (e.getSource() == this.tabButton[i][j])  
					{
						this.bout2 = this.tabButton[i][j];
						trait();
					}  
				}
			}
		}
		
	}

	private boolean trait()
	{

		return false;
	}

	private void lettre()
	{
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		System.out.println ("8");

		Graphics2D g2 = (Graphics2D) g;

		/* 
		g.drawLine();
		g.drawLine();

		if (trait) {
			g.drawLine();
		}

		if (lettre) {
			g.drawChars();
		}
		
		*/

		

		System.out.println ("9");
	}

}