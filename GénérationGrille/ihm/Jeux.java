package melo.java_mots_mls.GénérationGrille.ihm;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import melo.java_mots_mls.GénérationGrille.Controleur;
import melo.java_mots_mls.GénérationGrille.Grille;


public class Jeux extends JFrame
{
	private Controleur			ctrl;
	private GrilleBout			grill;
	private char[][]			tabL;
	private ArrayList<String>	lstMots;		 ² 
	private Grille 				jeu;


	public Jeux( Controleur ctr, ArrayList<String> lstMot ) 
	{
		this.ctrl = ctr;
		this.jeu = new Grille(lstMot);
		this.tabL = this.jeu.getTab();
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