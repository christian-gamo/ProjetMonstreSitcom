package junitests;

import static org.junit.Assert.*;

import actors.Actor;
import actors.Chasseur;
import actors.Monstre;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sitcom.Sitcom;
import sitcom.StreamingPlatform;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe-test junitests.SitcomTest.
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 *
 * Les classes-test sont documentées ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont basées sur le document Š 2002 Robert A. Ballance intitulé
 * "JUnit: Unit Testing Framework".
 *
 * Les objets Test (et TestSuite) sont associés aux classes à tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe Name.java
 * se nommera NameTest.java); les deux se retrouvent dans le męme paquetage.
 * Les "engagements" (anglais : "fixture") forment un ensemble de conditions
 * qui sont vraies pour chaque méthode Test à exécuter.  Il peut y avoir
 * plus d'une méthode Test dans une classe Test; leur ensemble forme un
 * objet TestSuite.
 * BlueJ découvrira automatiquement (par introspection) les méthodes
 * Test de votre classe Test et générera la TestSuite conséquente.
 * Chaque appel d'une méthode Test sera précédé d'un appel de setUp(),
 * qui réalise les engagements, et suivi d'un appel à tearDown(), qui les
 * détruit.
 */
public class SitcomTest
{
    private StreamingPlatform netflix;
    private Sitcom friends;

    private Sitcom mhSitcom1;

    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).



    /**
     * Constructeur de la classe-test junitests.SitcomTest
     */
    public SitcomTest()
    {
    }

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @Before
    public void setUp() // throws java.lang.Exception
    {
        netflix = StreamingPlatform.getInstance();
        friends = new Sitcom();
        friends.setNbSaisons(7);
        friends.setPaysOrigine("Etats-Unis");
        friends.setPlatformAvailable(netflix);
        friends.setNom("Friends");
        netflix.setAvailableSitcom(friends);
        netflix.setNom("Netflix");

        mhSitcom1 = new Sitcom();
        mhSitcom1.setNom("Monster Hunter Friends");
        mhSitcom1.setNbSaisons(2);
        mhSitcom1.setPaysOrigine("Japon");
        mhSitcom1.setPlatformAvailable(netflix);

        List<Actor> acteursMH = new ArrayList<Actor>();

        Monstre mizutsune = new Monstre("Mizutsune", "Bulles", 1);

        acteursMH.add(mizutsune);
        acteursMH.add(new Chasseur("Darlène", 0, mizutsune));
        acteursMH.add(new Chasseur("Christian", 0, mizutsune));
        acteursMH.add(new Chasseur("Marine", 0, mizutsune));
        acteursMH.add(new Chasseur("Lucy", 0, mizutsune));

        mhSitcom1.setActeurs(acteursMH);
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }

    @Test
    public void testsitcomRenewed()
    {
        Sitcom Friends = new Sitcom();
        Friends.sitcomRenewed();
    }

    @Test
    public void testCountriesAvailableOn()
    {
        assertEquals("Netflix propose des sitcoms venant du pays suivant: Etats-Unis", netflix.countriesAvailableOn(friends));
    }

    @Test
    public void testAssociationBidirectionnelle(){

        assertEquals(friends, netflix.getAvailableSitcom());
        assertEquals(netflix, friends.getPlatformAvailable());
    }

    @Test
    public void testGetNombreSaisons(){
        assertEquals(7, friends.getNbSaisons());
    }

    @Test
    public void testGetNom(){
        assertEquals("Friends", friends.getNom());
    }

    @Test
    public void testGetActeurs(){
        List<Actor> acteurs = mhSitcom1.getActeurs();
        assertEquals("Darlène", acteurs.get(0).getNom());
        assertEquals("Christian", friends.getNom());
        assertEquals("Darlène", friends.getNom());
        assertEquals("Darlène", friends.getNom());
    }

}



