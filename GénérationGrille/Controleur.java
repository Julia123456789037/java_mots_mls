package projet_java.melo.java_mots_mls.GénérationGrille;

import projet_java.melo.java_mots_mls.GénérationGrille.ihm.GrilleBout;
import projet_java.melo.java_mots_mls.GénérationGrille.ihm.Menu;

public class Controleur {

    private Menu eccureil;
    private GrilleBout partie;

    public Controleur()
    {
        this.eccureil =  new Menu(this);
    }
    public static void main(String s[]) { new Controleur();}
}
