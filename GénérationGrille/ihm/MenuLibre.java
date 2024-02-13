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

public class MenuLibre extends JFrame implements ActionListener 
{
	private Controleur			ctrl;
	private ArrayList<Button>	lstBout;
	private JButton				quitter;
	private JLabel				attent1;
	private JLabel				attent2;
	private JTextField			nouvMot;
	private JButton				valider;
	private ArrayList<String>	lstMots;
	private JTextArea 				affMots;
	private JTextArea 				attent;

	private JPanel				haut;
	private JPanel				centre;

	public MenuLibre( Controleur ctr ) 
	{
		this.ctrl = ctr;
		this.setTitle("2 Boutons");
		this.setSize    (800,500);
		this.setLocation(50,50);
		this.getContentPane().setBackground(new Color(222,222,222));
		this.setLayout (new BorderLayout(8,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Création des Controles
		this.haut = new JPanel();
		this.centre = new JPanel();
		this.haut.setLayout (new GridLayout(8,1));
		this.setJMenuBar(new BarreNiv(this,this.ctrl));
		this.attent =  new JTextArea(2,1);
		this.attent.append("Attention une même liste de mot peut générer des résultats différent.");
		this.attent.append("Attention le mot rentré en mode libre ne sont pas forcément tous présent.");
		this.attent1 = new JLabel("Attention une même liste de mot peut générer des résultats différent.", SwingConstants.CENTER);
		this.attent2 = new JLabel("Attention le mot rentré en mode libre ne sont pas forcément tous présent", SwingConstants.CENTER);
		this.quitter = new JButton( " quitter "   );
		this.nouvMot = new JTextField("mots");
		this.valider = new JButton( " Valider "   );
		this.affMots = new JTextArea(15,15);



		

		// Activation des Controles
		this.quitter.addActionListener( this );
		this.attent.setEditable(false);
		this.affMots.setEditable(false);


		// Positionnement des Controles
		//this.haut.add(this.attent1);
		//this.haut.add(this.attent2);
		this.centre.add(this.attent);
		this.centre.add(this.nouvMot);
		this.centre.add(this.valider);
		this.centre.add(this.affMots);
		this.add(this.haut, BorderLayout.NORTH);
		this.add(this.centre, BorderLayout.CENTER);
		this.add(this.quitter, BorderLayout.SOUTH);


		//this.pack();                          
		this.setVisible(true);
	}


	public void actionPerformed(ActionEvent e)
	{            
		if (e.getSource() == this.quitter)  {this.dispose();} 
		if (e.getSource() == this.valider)  {this.verifMot();} 
	}

	private boolean verifMot()
	{
		String tempo;
		tempo = this.nouvMot.getText();
		for (int i = 0; i < tempo.length(); i++) {
			if ( ! (tempo.charAt(i) >= 'a' && tempo.charAt(i) <= 'z') ||  ! (tempo.charAt(i) >= 'A' && tempo.charAt(i) <= 'Z') ) 
			{ 
				return false; 
				System.out.println("je passe par iccccccccccccccccciiiiiiiiiiiiiiiiiiii");
			}
		}
		lstMots.add(tempo);
		this.affMots.append(tempo);
		System.out.println(lstMots);
		return true;
	}


}