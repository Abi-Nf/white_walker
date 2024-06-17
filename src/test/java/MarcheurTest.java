import org.junit.jupiter.api.Test;
import white.walker.Carte;
import white.walker.Lieu;
import white.walker.Marcheur;
import white.walker.Rue;

import static org.junit.jupiter.api.Assertions.*;

public class MarcheurTest {
  @Test
  public void départ_à_HEI_vers_ESTI(){
    var marais = new Lieu("Marais");
    var sekolintsika = new Lieu("sekolintsika");
    var hei = new Lieu("HEI");
    var balancoire = new Lieu("balançoire");
    var esti = new Lieu("ESTI");
    var boulevardDeLEurope = new Lieu("Boulevard de l'Europe");
    var nexta = new Lieu("NEXTA");
    var pullman = new Lieu("Pullman");

    var carte = new Carte();

    var rueMaraisSekolinstsika = new Rue(marais, sekolintsika);
    carte.ajouterUneRue(rueMaraisSekolinstsika);

    var rueSekolintsikaHei = new Rue(sekolintsika, hei);
    carte.ajouterUneRue(rueSekolintsikaHei);

    carte.ajouterUneRue("Andriatsinorana", hei, pullman);
    carte.ajouterUneRue("Ranaivo", pullman, balancoire);

    var ruePullmanNexta = new Rue(pullman, nexta);
    carte.ajouterUneRue(ruePullmanNexta);

    carte.ajouterUneRue(hei, balancoire);

    carte.ajouterUneRue(balancoire, esti);
    carte.ajouterUneRue(balancoire, boulevardDeLEurope);
    carte.ajouterUneRue(boulevardDeLEurope, esti);

    var itineraireDeBjarni  = new Marcheur("Bjarni");
    var lesRuePasse = itineraireDeBjarni.marche(carte, hei, esti);

    System.out.println(lesRuePasse);

    assertFalse(lesRuePasse.isEmpty());
    assertTrue(lesRuePasse.contains(balancoire));
    assertTrue(lesRuePasse.size() > 2);
    assertEquals(esti, lesRuePasse.getLast());

    var rues = carte.lesRues();
    System.out.println("contient marais - sekolinstsika " + rues.contains(rueMaraisSekolinstsika));
    System.out.println("contient sekolinstika - hei " + rues.contains(rueSekolintsikaHei));
    System.out.println("contient pullman - nexta " + rues.contains(ruePullmanNexta));
  }
}
