package melo.java_mots_mls.GénérationGrille.ihm;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import melo.java_mots_mls.GénérationGrille.Controleur;

public class BarreNiv extends JMenuBar
{

	private JMenu menu1;
	private JMenuItem menu,niveau,libre;
	private Controleur ctrl;
	private JFrame frameAnc,framePrinc;
	private boolean b2Frame;

	public BarreNiv(JFrame framePrinc,Controleur ctrl)
	{
		super();
		this.ctrl = ctrl;
		b2Frame = false;
		this.framePrinc = framePrinc;
		this.initBoutons();
		
		this.framePrinc.add(this);
	}

	public BarreNiv(JFrame framePrinc,JFrame frameAnc,Controleur ctrl)
	{
		super();
		this.ctrl = ctrl;
		b2Frame = true;
		this.framePrinc = framePrinc;
		this.frameAnc = frameAnc;
		this.initBoutons();

		framePrinc.add(this);
		frameAnc.add(this);
	}

	private void initBoutons() 
	{
		this.setLayout( new FlowLayout(FlowLayout.LEFT, 0, 0) );
		//ImageIcon icon = new ImageIcon("lib/ASTRE.png");	
		this.menu1  = new JMenu("Navigation");
		this.menu   = new JMenuItem("Menu");
		this.niveau = new JMenuItem("Niveau");
		this.libre  = new JMenuItem("Libre");
		
		this.menu1.add(menu);
		this.menu1.add(niveau);
		this.menu1.add(libre);

		this.menu.addActionListener(    new ActionListener() {public void actionPerformed(ActionEvent e){NavActionPerformed(e);}});
		this.niveau.addActionListener(  new ActionListener() {public void actionPerformed(ActionEvent e){NavActionPerformed(e);}});
		this.libre.addActionListener(   new ActionListener() {public void actionPerformed(ActionEvent e){NavActionPerformed(e);}});
		
		this.add(menu1);
	}

	private void NavActionPerformed(ActionEvent e) 
	{
		if (e.getSource() == this.menu) { this.retourAccueil(); }
		if (e.getSource() == this.niveau && !this.framePrinc.getTitle().equals("e")) { this.retourMeNiv(); }
		if (e.getSource() == this.libre && !this.framePrinc.getTitle().equals("e")) { this.retourMeLibre(); }
	
	}

	private void retourMeNiv() 
	{
		this.framePrinc.dispose();
		if (b2Frame) { this.frameAnc.dispose();}
		new MenuNiv(this.ctrl);
	}

	private void retourMeLibre() 
	{
		this.framePrinc.dispose();
		if (b2Frame) { this.frameAnc.dispose();}
		new MenuLibre(this.ctrl, new ArrayList<String>());
	}

	public void retourAccueil() 
	{
		this.framePrinc.dispose();
		if (b2Frame) { this.frameAnc.dispose();}
		new Menu(this.ctrl);
	}

	public JMenu getMenu() {
		return menu1;
	}

	public JMenuItem getAccueil() {
		return menu;
	}
}
