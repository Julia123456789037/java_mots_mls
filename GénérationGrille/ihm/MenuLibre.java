package projet_java.melo.java_mots_mls.GénérationGrille.ihm;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import projet_java.melo.java_mots_mls.GénérationGrille.Controleur;

public class MenuLibre extends JFrame implements ActionListener 
{
	private Controleur ctrl;
	private ArrayList<Button> lstBout;
	private Button quitter;
	private JLabel attent1;
	private JLabel attent2;
    private JTextField nouvMot;
    private ArrayList<String> lstMots;
    private JLabel affMots;

    private JPanel haut;
    private JPanel centre;

	public MenuLibre( Controleur ctr ) 
	{
		this.ctrl = ctr;
		this.setTitle("2 Boutons");
		this.setSize    (1200,500);
		this.setLocation(50,50);
		this.getContentPane().setBackground(new Color(222,222,222));
		this.setLayout (new BorderLayout(8,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Création des Controles
        this.haut = new JPanel();
        this.centre = new JPanel();
		this.setJMenuBar(new BarreNiv(this,this.ctrl));
		this.attent1 = new JLabel("Attention une même liste de mot peut générer des résultats différent.", SwingConstants.CENTER);
		this.attent2 = new JLabel("Attention le mot rentré en mode libre ne sont pas forcément tous présent", SwingConstants.CENTER);
		this.quitter = new Button( " quitter "   );
        this.nouvMot = new JTextField("rentré un mots");
        this.affMots = new JLabel();

        this.nouvMot.addActionListener(new ActionListener() {
            //capturer un événement sur le JTextField
            public void actionPerformed(ActionEvent e) {
              //récupérer et afficher le contenu de JTextField dans la console
              System.out.println("Text=" + this.nouvMot.getText());
            }



		// Activation des Controles
		this.quitter.addActionListener( this );


		// Positionnement des Controles
        this.haut.add(this.attent1);
        this.haut.add(this.attent2);
        this.centre.add(this.nouvMot);
        this.centre.add(this.affMots);
		this.add(this.haut, BorderLayout.NORTH);
        this.add(this.centre, BorderLayout.CENTER);
        this.add(this.quitter, BorderLayout.SOUTH);


		//this.pack();                          
		this.setVisible(true);
	}

    public void keyTyped(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ENTER ){
            System.out.println("ty");
        }
} 
	public void actionPerformed(ActionEvent e)
	{            
		if (e.getSource() == this.quitter)  {this.dispose();} 
	}

}