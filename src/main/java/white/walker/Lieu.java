package white.walker;

import java.util.HashSet;
import java.util.Set;

public class Lieu {
  private final Set<Rue> lesRuesPossible = new HashSet<>();

  private final String nom;

  public Lieu(String nom) {
    this.nom = nom;
  }

  public Set<Rue> lesRuesPossible() {
    return lesRuesPossible;
  }

  void connecterA(Rue rue){
    lesRuesPossible.add(rue);
  }

  public boolean estConnecterA(Rue rue){
    return lesRuesPossible.contains(rue);
  }

  @Override
  public String toString() {
    return nom;
  }
}
