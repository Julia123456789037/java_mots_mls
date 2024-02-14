package projet_java.melo.java_mots_mls.GénérationGrille.ihm;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import projet_java.melo.java_mots_mls.GénérationGrille.Controleur;

public class Jeux extends JFrame
{
	private Controleur			ctrl;
	private GrilleBout			grill;
	private char[][]			tabL;
	private ArrayList<String>	lstMots;


	public Jeux( Controleur ctr, char[][] tab, ArrayList<String> lstMot ) 
	{
		this.ctrl = ctr;
		this.tabL = tab;
		this.lstMots = lstMot;
		this.setTitle("Jeux");
		this.setSize    (1200,500);
		this.setLocation(50,50);

        this.setLayout (new BorderLayout(4,1));

		// Création des Controles
		this.grill = new GrilleBout(this.ctrl, this.tabL, this.lstMots);
		

		// Activation des Controles

		// Positionnement des Controles


		//this.pack();                          
		this.setVisible(true);
	}

}