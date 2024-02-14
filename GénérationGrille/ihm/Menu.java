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

public class Menu extends JFrame implements ActionListener 
{
	private Controleur ctrl;
	private Button niv;
	private Button libre;
	private Button quitter;
	private JLabel bienv;
	private JLabel modeJeux;
	private JLabel attent1;
	private JLabel attent2;

	public Menu( Controleur ctr) 
	{
		this.ctrl = ctr;
		this.setTitle("Menu");
		this.setSize    (1200,500);
		this.setLocation(50,50);
		this.getContentPane().setBackground(new Color(222,222,222));

        this.setLayout (new GridLayout(8,1));

		// Création des Controles
		this.bienv = new JLabel("Bienvenue sur le manu de mon jeux de mot mélé.", SwingConstants.CENTER);
		this.modeJeux = new JLabel("Vous pouvez choisir de jouer celon les niveau prédéfini, ou en rentrant vous même une liste de mot.", SwingConstants.CENTER);
		this.attent1 = new JLabel("Attention les niveau proposer ne sont qu'une liste prédéfini de mot dont chaque nouvelle génération du même niveau peut créer un nouveau résultat.", SwingConstants.CENTER);
		this.attent2 = new JLabel("Attention le mot rentré en mode libre ne sont pas forcément tous présent", SwingConstants.CENTER);
		this.niv = new Button( " jouer par niveau " );
		this.libre = new Button( " mode libre "   );
		this.quitter = new Button( " quitter "   );


		// Activation des Controles
		this.niv.addActionListener( this );
		this.libre.addActionListener( this );
		this.quitter.addActionListener( this );


		// Positionnement des Controles
		this.add(this.bienv);
		this.add(this.modeJeux);
		this.add(this.attent1);
		this.add(this.attent2);
		this.add(this.niv);
		this.add(this.libre);
		this.add(this.quitter);


		//this.pack();                          
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{            
		if (e.getSource() == this.niv)  
        {
			System.out.println("niv");
			new MenuNiv(ctrl);
			this.dispose();
        }      
		if (e.getSource() == this.libre)  
		{
			System.out.println("mode libre");
			new MenuLibre(ctrl, new ArrayList<String>());
			this.dispose();
		} 

		if (e.getSource() == this.quitter)  {this.dispose();} 
	}

	//public static void main(String s[]) { new Menu(null);}
}