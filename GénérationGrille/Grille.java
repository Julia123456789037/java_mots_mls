package melo.java_mots_mls.GénérationGrille;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



/** Grille 
 * Cette classe représente une grille de mots croisés.
 * @author Justine BONDU
* @version 1 du 01/04/2023
*/

public class Grille
{
	/* -------------------------------------- */
	/*               Attributs                */
	/* -------------------------------------- */

	private String					nomFichier;
	private char[][]				grilleMots;
	private ArrayList<String>		motsATrouverAvant;
	private ArrayList<String>		motsATrouverComplet;
	private int						nbMots;
	private int						longueur;
	private int						largeur;
	private int						niveau;
	private HashMap<String, String> posMot;

	/* -------------------------------------- */
	/*            Constructeur                */
	/* -------------------------------------- */

	/**
	 * Constructeur de la grille
	 * 
	 * @param nomFich Le nom du fichier contenant les mots à placer dans la grille.
	 */
	public Grille(String nomFich)
	{
		this.nomFichier = "Joueur/" + nomFich + ".txt";
		//this.niveau = null;
		this.largeur = this.longueur = 10;
		scaneur();
		this.grilleMots = new char[this.largeur][this.longueur];
		this.posMot = new HashMap<String, String>();
		placerMot();

		renplirGrillr();

		System.out.println ( "------------------------------------------------------------------------------" );
		System.out.println ();
		System.out.println (toString());
		System.out.println ();
		System.out.println ( "------------------------------------------------------------------------------" );
		System.out.println (getMotsATrouver());
		System.out.println ( "------------------------------------------------------------------------------" );
		System.out.println ();
	}

	public Grille(ArrayList<String>	lstMots )
	{
		for (int i = 0; i < lstMots.size(); i++) { this.motsATrouverAvant.add(lstMots.get(i).toUpperCase()) ; }
		this.nbMots = lstMots.size();
		deterTaille();
		this.grilleMots = new char[this.largeur][this.longueur];
		placerMot();


		renplirGrillr();

		System.out.println ( "------------------------------------------------------------------------------" );
		System.out.println ();
		System.out.println (toString());
		System.out.println ();
		System.out.println ( "------------------------------------------------------------------------------" );
		System.out.println (getMotsATrouver());
		System.out.println ( "------------------------------------------------------------------------------" );
		System.out.println ();

	}

	public Grille(int niv)
	{
		this.niveau = niv;
		this.nomFichier = "niveau/niv" + niv + ".txt";
		this.largeur = this.longueur = 10;
		scaneur();
		this.grilleMots = new char[this.longueur][this.largeur];
		this.posMot = new HashMap<String, String>();
		placerMot();


		//renplirGrillr();

		System.out.println ( "------------------------------------------------------------------------------" );
		System.out.println ();
		System.out.println (toString());
		System.out.println ();
		System.out.println ( "------------------------------------------------------------------------------" );
		System.out.println (getMotsATrouver());
		System.out.println ( "------------------------------------------------------------------------------" );
		System.out.println ();

	}

	/* -------------------------------------- */
	/*               Accesseur                */
	/* -------------------------------------- */

	/**
	 * Accesseur pour obtenir la liste des mots à trouver.
	 * 
	 * @return Une chaîne de caractères contenant les mots à trouver.
	 */
	public String getMotsATrouver()
	{
		String s;
		s = "";
		s = s + "";
		if ( ! this.motsATrouverComplet.isEmpty() )
		{
			s = s + this.motsATrouverComplet.get(0);
			for (int i = 1; i < this.motsATrouverComplet.size(); i++) 
			{
				s = s + ", " + this.motsATrouverComplet.get(i);
			}
		}
		else 
		{
			System.out.println("liste vide");
		}
		s = s + "";
		return s;
	}



	/* -------------------------------------- */
	/*                Méthode                 */
	/* -------------------------------------- */

	/**
	 * Cette méthode lit un fichier pour extraire les mots à trouver.
	 * Elle configure également les dimensions de la grille en fonction du nombre de mots.
	 */
	private void scaneur()
	{
		this.motsATrouverAvant = new ArrayList<String>();

		FileReader fr;
		this.nbMots = 0;

		try
		{
			fr = new FileReader ( this.nomFichier );
			Scanner sc = new Scanner ( fr );

			while ( sc.hasNextLine() && this.nbMots < 80  )
			{
				this.motsATrouverAvant.add(sc.nextLine().toUpperCase());
				this.nbMots++; 
			}	
			fr.close();
		}
		catch (Exception e){ e.printStackTrace(); }
		deterTaille();	
	}

	private void deterTaille()
	{
		if ( this.nbMots <= 10  )
		{
			this.longueur = 11;
			this.largeur = 11;
		}
		else if ( this.nbMots <= 20  )
		{
			this.longueur = 16;
			this.largeur = 16;
		}
		else if ( this.nbMots <= 50  )
		{
			this.longueur = 31;
			this.largeur = 31;
		}
		else if ( this.nbMots > 50  )
		{
			this.longueur = 51;
			this.largeur = 31;
		}
	}

	public char[][] getTab() { return grilleMots; }
	

	/*-------------------------------------------------------------------- */
	public void rangeArrayTail()
	{
		ArrayList<String>		tempo;
		ArrayList<Integer>		tempInt;

		tempInt = new ArrayList<Integer>();
		tempo = new ArrayList<String>();

		if ( ! this.motsATrouverComplet.isEmpty() )
		{
			System.out.println("----------------------------------------");
			System.out.println(this.motsATrouverComplet);
			this.motsATrouverComplet.toArray();
			System.out.println(this.motsATrouverComplet);

			System.out.println("----------------------------------------");

			
			for (int i = 0; i < this.motsATrouverComplet.size(); i++) 
			{
				tempInt.add( (Integer) this.motsATrouverComplet.get(1).length());
			}
		}
		else 
		{
			System.out.println("liste vide");
		}

	}

	public void rangeArrayAlpha()
	{
		ArrayList<String>		tempo;

		if ( ! this.motsATrouverComplet.isEmpty() )
		{
			for (int i = 0; i < this.motsATrouverComplet.size(); i++) 
			{
				for (int j = 0; j < this.motsATrouverComplet.size(); j++) 
				{
					this.motsATrouverComplet.get(0);
				}
			}
		}
		else 
		{
			System.out.println("liste vide");
		}
	}
/* 
	public void rangeArrayInt(ArrayList<Integer> tempo)
	{
		if ( ! tempo.isEmpty() )
		{
			System.out.println(tempo);
			tempo.toArray();
			System.out.println(tempo);
		}
		else 
		{
			System.out.println("liste vide");
		}
	}*/
	/*-------------------------------------------------------------------- */




	/**
	 * Cette méthode vérifie les différentes directions où un mot peut être placé dans la grille.
	 * Elle retourne une liste d'entiers correspondant aux directions possibles.
	 *
	 * @param mot Le mot à placer.
	 * @param lig La ligne de départ.
	 * @param col La colonne de départ.
	 * @return Une liste d'entiers représentant les directions possibles.
	 */
	public ArrayList<Integer> ferifMot(String mot, int lig, int col)
	{
		ArrayList<Integer>	tempo;
		tempo = new ArrayList<Integer> ();
		if ( peutPlacerLigneGD(mot, lig, col) ) { tempo.add(1); }
		if ( peutPlacerLigneDG(mot, lig, col) ) { tempo.add(2); }
		if ( peutPlacerColoneBH(mot, lig, col) ) { tempo.add(3); }
		if ( peutPlacerColoneHB(mot, lig, col) ) { tempo.add(4); }
		if ( peutPlacerDiagHG_BD(mot, lig, col) ) { tempo.add(5); }
		if ( peutPlacerDiagBD_HG(mot, lig, col) ) { tempo.add(6); }
		if ( peutPlacerDiagHD_BG(mot, lig, col) ) { tempo.add(7); }
		if ( peutPlacerDiagBG_HD(mot, lig, col) ) { tempo.add(8); }
		
		return tempo;
	}

	/**
	 * Place les mots aléatoirement dans la grille.
	 * Pour chaque mot, cette méthode sélectionne une position et une direction
	 * aléatoire dans la grille, puis essaie de placer le mot dans cette direction.
	 * Si une direction valide est trouvée, le mot est inséré dans la grille
	 * et ajouté à la liste des mots à trouver.
	 */
	private void placerMot()
	{
		int tempo;
		int col;
		int lig;
		int cpt;
		cpt = 0;

		this.motsATrouverComplet = new ArrayList<String>();
		
		//Random random = new Random();
		while ( ! motsATrouverAvant.isEmpty() && cpt < 5) {
			cpt++;
			for (String mot : motsATrouverAvant) 
			{
				ArrayList<Integer>		casPossibleMot;
				casPossibleMot = new ArrayList<Integer>();

				col =(int) ( ( Math.random() * this.largeur-1 )  );
				lig =(int) ( ( Math.random() * this.longueur-1 )  );

				casPossibleMot = ferifMot( mot, lig, col );
				
				tempo = (int) ( ( Math.random() * casPossibleMot.size()  )  );


				if ( ! casPossibleMot.isEmpty() )
				{		
					switch ( casPossibleMot.get(tempo))
					{
						case 1:
							placerLigneGD(mot, lig, col);
							motsATrouverAvant.remove(mot);
							break;
						case 2:
							placerLigneDG(mot, lig, col);
							motsATrouverAvant.remove(mot);
							break;
						case 3:
							placerColoneBH(mot, lig, col);
							motsATrouverAvant.remove(mot);
							break;
						case 4:
							placerColoneHB(mot, lig, col);
							motsATrouverAvant.remove(mot);
							break;
						case 5:
							placerDiagHG_BD(mot, lig, col);
							motsATrouverAvant.remove(mot);
							break;
						case 6:
							placerDiagBD_HG(mot, lig, col);
							motsATrouverAvant.remove(mot);
							break;
						case 7:
							placerDiagHD_BG(mot, lig, col);
							motsATrouverAvant.remove(mot);
							break;
						case 8:
							placerDiagBG_HD(mot, lig, col);
							motsATrouverAvant.remove(mot);
							break;
						default:
							placerDiagHD_BG(mot, lig, col); // Direction par défaut : horizontal HautDroite jusqu'à BasGauche
							motsATrouverAvant.remove(mot);
							break;
					}
				}
			}
		}

		
	}

	/**
	 * Vérifie si le mot peut être inséré horizontalement de gauche à droite à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 * @return true si le mot peut être inséré horizontalement, sinon false.
	 */
	public boolean peutPlacerLigneGD(String mot, int ligne, int colonne) 
	{
		if ( colonne + mot.length() > this.largeur ) 
		{
			return false; // Le mot dépasse les limites du tableau.
		}
		for (int i = 0; i < mot.length(); i++) 
		{
			if ( this.grilleMots[ligne][colonne + i]  != mot.charAt(i) && this.grilleMots[ligne][colonne + i] != '\0' ) 
			{
				return false; // L'emplacement est déjà occupé.
			}
		}
		return true;
	}

	/**
	 * Insère le mot horizontalement de gauche à droite à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 */
	public void placerLigneGD(String mot, int ligne, int colonne) 
	{
		String tempo;
		if (peutPlacerLigneGD(mot, ligne, colonne)) 
		{
			for (int i = 0; i < mot.length(); i++) 
			{
				this.grilleMots[ligne][colonne + i] = mot.charAt(i);
			}
			this.motsATrouverComplet.add(mot);
			tempo = "(" + ligne + ":" + colonne + ")";
			this.posMot.put(mot, tempo);
		}
	}

	/**
	 * Vérifie si le mot peut être inséré horizontalement de droite à gauche à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 * @return true si le mot peut être inséré horizontalement, sinon false.
	 */
	public boolean peutPlacerLigneDG(String mot, int ligne, int colonne) 
	{
		if (colonne - this.largeur < 0) 
		{
			return false; // Le mot dépasse les limites du tableau.
		}

		for (int i = 0; i < mot.length(); i++) 
		{
			if (grilleMots[ligne][colonne - i]  != mot.charAt(i) && grilleMots[ligne][colonne - i] != '\0' ) 
			{
				return false; // L'emplacement est déjà occupé.
			}
		}
		return true;
	}

	/**
	 * Insère le mot horizontalement de gauche à droite à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 */
	public void placerLigneDG(String mot, int ligne, int colonne) 
	{
		String tempo;
		if (peutPlacerLigneDG(mot, ligne, colonne)) 
		{
			for (int i = 0; i < mot.length(); i++) 
			{
				this.grilleMots[ligne][colonne - i] = mot.charAt(i);
			}
			this.motsATrouverComplet.add(mot);
			tempo = "(" + ligne + ":" + colonne + ")";
			this.posMot.put(mot, tempo);
		}
	}




	/**
	 * Vérifie si le mot peut être inséré verticalement de haut en bas à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 * @return true si le mot peut être inséré verticalement, sinon false.
	 */
	public boolean peutPlacerColoneHB(String mot, int ligne, int colonne) 
	{
		
		if ( ( ligne + mot.length() ) > this.longueur) 
		{
			return false; // Le mot dépasse les limites du tableau.
		}

		for (int i = 0; i < mot.length(); i++) 
		{
			/*
			System.out.println(grilleMots[ligne + i][colonne]);
			System.out.println(mot.charAt(i));
*/
			if ( this.grilleMots[ligne + i][colonne]  != mot.charAt(i) && this.grilleMots[ligne + i][colonne]  != '\0' ) 
			{
				return false; // L'emplacement est déjà occupé.
			}
		}
		return true;
	}

	/**
	 * Insère le mot verticalement de haut en bas à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 */
	public void placerColoneHB(String mot, int ligne, int colonne) 
	{
		String tempo;
		if (peutPlacerColoneHB(mot, ligne, colonne)) 
		{
			for (int i = 0; i < mot.length(); i++) 
			{
				this.grilleMots[ligne + i][colonne] = mot.charAt(i);
			}
			this.motsATrouverComplet.add(mot);
			tempo = "(" + ligne + ":" + colonne + ")";
			this.posMot.put(mot, tempo);
		}
	}

	/**
	 * Vérifie si le mot peut être inséré verticalement de bas en haut à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 * @return true si le mot peut être inséré verticalement, sinon false.
	 */
	public boolean peutPlacerColoneBH(String mot, int ligne, int colonne) 
	{
		if (ligne - mot.length() < 0) 
		{
			return false; // Le mot dépasse les limites du tableau.
		}

		for (int i = 0; i < mot.length(); i++) 
		{
			if ( this.grilleMots[ligne - i][colonne] != mot.charAt(i) && this.grilleMots[ligne - i][colonne] != '\0' ) 
			{
				return false; // L'emplacement est déjà occupé.
			}
		}
		return true;
	}

	/**
	 * Insère le mot horizontalement de bas en haut à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 */
	public void placerColoneBH(String mot, int ligne, int colonne) 
	{
		String tempo;
		if (peutPlacerColoneBH(mot, ligne, colonne)) 
		{
			for (int i = 0; i < mot.length(); i++) 
			{
				this.grilleMots[ligne - i][colonne] = mot.charAt(i);
			}
			this.motsATrouverComplet.add(mot);
			tempo = "(" + ligne + ":" + colonne + ")";
			this.posMot.put(mot, tempo);
		}
	}




	/**
	 * Vérifie si le mot peut être inséré en diagonale de haut-gauche à bas-droite à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 * @return true si le mot peut être inséré en diagonale, sinon false.
	 */
	public boolean peutPlacerDiagHG_BD(String mot, int ligne, int colonne) 
	{
		if (ligne + mot.length() > this.grilleMots.length || colonne + mot.length() > this.grilleMots[0].length) 
		{
			return false; // Le mot dépasse les limites du tableau.
		}

		for (int i = 0; i < mot.length(); i++) 
		{
			if ( this.grilleMots[ligne + i][colonne + i]  != mot.charAt(i) && this.grilleMots[ligne + i][colonne + i] != '\0' ) 
			{
				return false; // L'emplacement est déjà occupé.
			}
		}
		return true;
	}

	/**
	 * Insère le mot en diagonale de haut-gauche à bas-droite à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 */
	public void placerDiagHG_BD(String mot, int ligne, int colonne) 
	{
		String tempo;
		if (peutPlacerDiagHG_BD(mot, ligne, colonne)) 
		{
			for (int i = 0; i < mot.length(); i++) 
			{
				this.grilleMots[ligne + i][colonne + i] = mot.charAt(i);
			}
			this.motsATrouverComplet.add(mot);
			tempo = "(" + ligne + ":" + colonne + ")";
			this.posMot.put(mot, tempo);
		}
	}


	/**
	 * Vérifie si le mot peut être inséré en diagonale de haut-gauche à bas-droite à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 * @return true si le mot peut être inséré en diagonale, sinon false.
	 */
	public boolean peutPlacerDiagBD_HG(String mot, int ligne, int colonne) 
	{
		if ( ligne - mot.length() < 0 || colonne - mot.length() < 0 ) 
		{
			return false; // Le mot dépasse les limites du tableau.
		}

		for (int i = 0; i < mot.length(); i++) 
		{
			if ( this.grilleMots[ligne - i][colonne - i]  != mot.charAt(i) && this.grilleMots[ligne - i][colonne - i] != '\0' ) 
			{
				return false; // L'emplacement est déjà occupé.
			}
		}
		return true;
	}

	/**
	 * Insère le mot en diagonale de haut-gauche à bas-droite à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 */
	public void placerDiagBD_HG(String mot, int ligne, int colonne) 
	{
		String tempo;
		if (peutPlacerDiagBD_HG(mot, ligne, colonne)) 
		{
			for (int i = 0; i < mot.length(); i++) 
			{
				this.grilleMots[ligne - i][colonne - i] = mot.charAt(i);
			}
			this.motsATrouverComplet.add(mot);
			tempo = "(" + ligne + ":" + colonne + ")";
			this.posMot.put(mot, tempo);
		}
	}

	/**
	 * Vérifie si le mot peut être inséré en diagonale de haut-droite à bas-gauche à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 * @return true si le mot peut être inséré en diagonale, sinon false.
	 */
	public boolean peutPlacerDiagHD_BG(String mot, int ligne, int colonne) 
	{
		if (ligne + mot.length() > this.grilleMots.length ||  colonne - mot.length() < 0) 
		{
			return false; // Le mot dépasse les limites du tableau.
		}

		for (int i = 0; i < mot.length(); i++) 
		{
			if ( this.grilleMots[ligne + i][colonne - i]  != mot.charAt(i) && grilleMots[ligne + i][colonne - i] != '\0' ) 
			{
				return false; // L'emplacement est déjà occupé.
			}
		}
		return true;
	}

	/**
	 * Insère le mot en diagonale de haut-droite à bas-gauche à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 */
	public void placerDiagHD_BG(String mot, int ligne, int colonne) 
	{
		String tempo;
		if (peutPlacerDiagHD_BG(mot, ligne, colonne)) 
		{
			for (int i = 0; i < mot.length(); i++) 
			{
				this.grilleMots[ligne + i][colonne - i] = mot.charAt(i);
			}
			this.motsATrouverComplet.add(mot);
			tempo = "(" + ligne + ":" + colonne + ")";
			this.posMot.put(mot, tempo);
		}
	}


	/**
	 * Vérifie si le mot peut être inséré en diagonale de bas-gauche à haut-droite à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 * @return true si le mot peut être inséré en diagonale, sinon false.
	 */
	public boolean peutPlacerDiagBG_HD(String mot, int ligne, int colonne)
	{
		if (ligne - mot.length() < 0 || colonne + mot.length() > this.grilleMots[0].length)
		{
			return false; // Le mot dépasse les limites du tableau.
		}

		for (int i = 0; i < mot.length(); i++)
		{
			if ( mot.charAt(i) != this.grilleMots[ligne - i][colonne + i] && this.grilleMots[ligne - i][colonne + i] != '\0' )
			{
				return false; // L'emplacement est déjà occupé.
			}
		}
		return true;
	}


	/**
	 * Insère le mot en diagonale de bas-gauche à haut-droite à partir des coordonnées (ligne, colonne).
	 *
	 * @param mot Le mot à insérer.
	 * @param ligne La ligne de départ.
	 * @param colonne La colonne de départ.
	 */
	public void placerDiagBG_HD(String mot, int ligne, int colonne) 
	{
		String tempo;
		if (peutPlacerDiagBG_HD(mot, ligne, colonne)) 
		{
			for (int i = 0; i < mot.length(); i++) 
			{
				this.grilleMots[ligne - i][colonne + i] = mot.charAt(i);
			}
			this.motsATrouverComplet.add(mot);
			tempo = "(" + ligne + ":" + colonne + ")";
			this.posMot.put(mot, tempo);
		}
	}

	/**
	 * Cette méthode remplit la grille avec des lettres aléatoires.
	 */
	private void renplirGrillr()
	{
		for (int i = 0; i < this.longueur; i++) 
		{
			for (int j = 0; j < this.largeur; j++) 
			{
				if ( !estlettre(grilleMots [i][j]) )
				{
					this.grilleMots [i][j] = (char) ('A' + ( Math.random() * 26 ));
				}	
			}
		}
	}

	/**
	 * Cette méthode vérifie si un caractère est une lettre.
	 *
	 * @param c Le caractère à vérifier.
	 * @return true si c'est une lettre, sinon false.
	 */
	private boolean estlettre(char c)
	{
		if ( c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' )
		{
			return true;
		}
		return false;
	}

	private char[][] copyTableau()
	{
		char[][]	newT;
		newT = new char[this.longueur][this.largeur];

		for (int i = 0; i < this.longueur; i++) 
		{
			for (int j = 0; j < this.largeur; j++) 
			{
				newT[i][j] = this.grilleMots[i][j];
			}
		}



		return newT;
	}


	public  String toString()
	{
		String		s="     ";
		char[][]	tab;
		int			cptlig;
		int			cptcol;
		int			cpt;
		int			cptl2;

		tab = this.grilleMots;

		cptl2 = tab.length-1;
		for (cptcol = 0; cptcol < tab[cptl2].length;cptcol++)
		{
			s = s + String.format ( "%" + (3) + "s",    cptcol ) + " ";
		}
		s = s + "\n";
		s = s  + "    -";
		for (cptcol = 0; cptcol < tab[cptl2].length;cptcol++)
		{
			s = s + "----";
		}
		s = s  + "\n";

		for (cptlig = 0; cptlig < tab.length;cptlig++)
		{
			s = s + String.format ( "%" + (4) + "d",    cptlig ) + "|";
			for (cptcol = 0; cptcol < tab[cptl2].length;cptcol++)
			{
				s = s +  String.format ( "%" + (3) + "s",    tab[cptlig][cptcol] ) + "|";
			}
			s = s + "\n";
			s = s  + "    -";
			cptl2 = tab.length-1;
			for (cpt = 0; cpt < tab[cptl2].length;cpt++)
			{
				s = s + "----";
			}
			s = s + "" + "\n";
		}		
		return s;
	}

	public static void main(String[] argv)
	{
		Grille        gril1, gril2, gril3;
		//gril1 = new Grille("texte.txt");
/*
		gril2 = new Grille(1);
		gril3 = new Grille(5);
*/
		System.out.println ();

		gril2 = new Grille(5);
		

	}

} 
