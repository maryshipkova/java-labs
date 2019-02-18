import java.util.Iterator;

public class Polynom {
    public RationalFractions fractions;

    public Polynom(RationalFractions fractions) {
        this.fractions = fractions;
    }

    public void add(Polynom polynom) {
        fractions.add(polynom.fractions);
    }


    @Override
    public boolean equals(Object polynom) {
        if (polynom instanceof Polynom) {
            Polynom polynom1 = (Polynom) polynom;
            return this.fractions.equals(polynom1.fractions);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
//         Integer i = 0;
        fractions.forEach((fraction) -> {
            str.append(fraction.toString() + "x + ");

        });
        str.delete(str.length() - 3, str.length() - 1);
        return str.toString();
    }

}
