package projet_java.melo.java_mots_mls.GénérationGrille.ihm;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import projet_java.melo.java_mots_mls.GénérationGrille.Controleur;

public class confirDeb extends JFrame implements ActionListener 
{
	private Controleur			ctrl;
	private ArrayList<Button>	lstBout;
	private JButton				quitter;
	private JButton				retour;
	private JLabel				attent1;
	private JLabel				attent2;
	private JLabel				attent3;
	private JTextField			nouvMot;
	private JButton				validerM;
	private JButton				validerL;
	private ArrayList<String>	lstMots;
	private JTextArea 			affMots;

	private JPanel				haut;
	private JPanel				centre;
	private JPanel				bas;

	public confirDeb( Controleur ctr, ArrayList<String> ltMot ) 
	{
		this.ctrl = ctr;
		this.setTitle("2 Boutons");
		this.setSize    (500,500);
		this.setLocation(250,250);
		this.getContentPane().setBackground(new Color(222,222,222));
		this.setLayout (new BorderLayout(4,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.lstMots = ltMot;

		// Création des Controles
		this.haut		= new JPanel();
		this.centre		= new JPanel();
		this.bas		= new JPanel();
		this.attent1	= new JLabel("Attention une même liste de mot peut générer des résultats différent.", SwingConstants.CENTER);
		this.attent2	= new JLabel("Attention le mot rentré en mode libre ne sont pas forcément tous présent", SwingConstants.CENTER);
		this.attent3	= new JLabel("", SwingConstants.CENTER);
		this.nouvMot	= new JTextField("mots");
		this.validerM	= new JButton( " Valider le mot "   );
		this.affMots	= new JTextArea(15,15);
		this.retour		= new JButton( " retour "   );
		this.quitter	= new JButton( " quitter "   );
		this.validerL	= new JButton( " Valider la liste"   );

		// Activation des Controles
		this.haut.setLayout (new GridLayout(2,1));
		this.centre.setLayout (new GridLayout(5,1));
		this.bas.setLayout (new GridLayout(1,3));
		this.setJMenuBar(new BarreNiv(this,this.ctrl));
		this.validerM.addActionListener( this );
		this.retour.addActionListener( this );
		this.quitter.addActionListener( this );
		this.validerL.addActionListener( this );
		this.affMots.setEditable(false);


		// Positionnement des Controles
		this.haut.add(this.attent1);
		this.haut.add(this.attent2);
		this.centre.add(this.attent3);
		this.centre.add(this.nouvMot);
		this.centre.add(this.validerM);
		this.centre.add(this.affMots);
		this.bas.add(this.retour);
		this.bas.add(this.quitter);
		this.bas.add(this.validerL);
		this.add(this.haut, BorderLayout.NORTH);
		this.add(this.centre, BorderLayout.CENTER);
		this.add(this.bas, BorderLayout.SOUTH);


		//this.pack();                          
		this.setVisible(true);
	}


	public void actionPerformed(ActionEvent e)
	{            
		if (e.getSource() == this.validerM)  {this.verifMot();} 
		if (e.getSource() == this.retour)  {new Menu(ctrl);this.dispose();} 
		if (e.getSource() == this.quitter)  {this.dispose();} 
		if (e.getSource() == this.validerL)  {System.out.println("page suivante");} 
	}

	private boolean verifMot()
	{
		String tempo;
		tempo = this.nouvMot.getText();
		for (int i = 0; i < tempo.length(); i++) 
		{ 
			if ( ! (tempo.charAt(i) >= 'a' && tempo.charAt(i) <= 'z') &&  ! (tempo.charAt(i) >= 'A' && tempo.charAt(i) <= 'Z') ) 
			{ 
				this.attent3.setText("Les seul caractère admit sont les 26 lettres qu'elle soit miniscule ou masjuscule.");
				return false;
			} 
		}
		for (String st : lstMots) 
		{ 
			if (tempo.equalsIgnoreCase(st))
			{ 
				this.attent3.setText("Ce mot est déjà présent dans la liste.");
				return false; 
			}
		}
		if (tempo.equalsIgnoreCase(""))
		{
			this.attent3.setText("Veillez écrire un mot.");
				return false; 
		}
		
		lstMots.add(tempo);
		this.affMots.append(tempo + "; ");
		return true;
	}


}