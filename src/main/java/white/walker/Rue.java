package white.walker;

import java.util.Objects;

public class Rue {
  private final String rue;
  private final Lieu a, b;

  public Rue(Lieu a, Lieu b) {
    this(null, a, b);
  }

  public Rue(String name, Lieu a, Lieu b){
    this.rue = name;
    this.a = a;
    this.b = b;
    a.connecterA(this);
    b.connecterA(this);
  }

  public boolean aCeLieu(Lieu lieu){
    return a.equals(lieu) || b.equals(lieu);
  }

  public Lieu getLieuA() {
    return a;
  }

  public Lieu getLieuB() {
    return b;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Rue rue)) return false;
    return Objects.equals(a, rue.a) && Objects.equals(b, rue.b);
  }

  @Override
  public int hashCode() {
    return Objects.hash(a, b);
  }

  @Override
  public String toString() {
    return "Rue{" +
      "rue='" + (rue == null ? "Rue inconnu" : rue) + '\'' +
      ", lieu_a=" + a +
      ", lieu_b=" + b +
      '}';
  }
}
