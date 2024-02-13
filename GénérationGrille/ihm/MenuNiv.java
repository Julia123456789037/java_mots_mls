package projet_java.melo.java_mots_mls.GénérationGrille.ihm;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import projet_java.melo.java_mots_mls.GénérationGrille.Controleur;

public class MenuNiv extends JFrame implements ActionListener 
{
	private Controleur ctrl;
	private ArrayList<Button> lstBout;
	private Button quitter;
	private JLabel attent1;
	private JLabel attent2;

	public MenuNiv( Controleur ctr ) 
	{
		this.ctrl = ctr;
		this.setTitle("2 Boutons");
		this.setSize    (1200,500);
		this.setLocation(50,50);
		this.getContentPane().setBackground(new Color(222,222,222));

		this.setLayout (new GridLayout(8,1));

		// Création des Controles
		this.setJMenuBar(new BarreNiv(this,this.ctrl));
		this.attent1 = new JLabel("Attention les niveau proposer ne sont qu'une liste prédéfini de mot dont chaque nouvelle génération du même niveau peut créer un nouveau résultat.", SwingConstants.CENTER);
		this.attent2 = new JLabel("Attention le mot rentré en mode libre ne sont pas forcément tous présent", SwingConstants.CENTER);
		this.quitter = new Button( " quitter "   );



		// Activation des Controles
		this.quitter.addActionListener( this );


		// Positionnement des Controles
		this.add(this.attent1);
		this.add(this.attent2);
		this.add(this.quitter);


		//this.pack();                          
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{            
		if (e.getSource() == this.quitter)  {this.dispose();} 
	}

}