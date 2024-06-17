import org.junit.jupiter.api.Test;
import white.walker.Carte;
import white.walker.Lieu;
import white.walker.Marcheur;

import static org.junit.jupiter.api.Assertions.*;

public class MarcheurTest {
  @Test
  public void départ_à_HEI_vers_ESTI(){
    var marais = new Lieu("Marais");
    var sekolintsika = new Lieu("sekolintsika");
    var hei = new Lieu("HEI");
    var balançoire = new Lieu("balançoire");
    var esti = new Lieu("ESTI");
    var boulevard_de_l_europe = new Lieu("Boulevard de l'Europe");
    var nexta = new Lieu("NEXTA");
    var pullman = new Lieu("Pullman");

    var carte = new Carte();
    carte.ajouterUneRue(marais, sekolintsika);
    carte.ajouterUneRue(sekolintsika, hei);
    carte.ajouterUneRue(hei, balançoire);
    carte.ajouterUneRue("Andriatsinorana", hei, pullman);
    carte.ajouterUneRue("Ranaivo", pullman, balançoire);
    carte.ajouterUneRue(pullman, nexta);
    carte.ajouterUneRue(balançoire, esti);
    carte.ajouterUneRue(balançoire, boulevard_de_l_europe);
    carte.ajouterUneRue(boulevard_de_l_europe, esti);

    var trajet = Marcheur.marche(carte, hei, esti);
    assertFalse(trajet.isEmpty());
    assertTrue(trajet.size() > 2);
    assertEquals(esti, trajet.getLast());
  }
}
