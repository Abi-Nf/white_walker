package white.walker;

import java.util.HashSet;
import java.util.Set;

public class Lieu {
  private final Set<Rue> ruesConnecte = new HashSet<>();

  private final String nom;

  public Lieu(String nom) {
    this.nom = nom;
  }

  void connecterA(Rue rue){
    ruesConnecte.add(rue);
  }

  public boolean estConnecterA(Rue rue){
    return ruesConnecte.contains(rue);
  }

  @Override
  public String toString() {
    return nom;
  }
}
