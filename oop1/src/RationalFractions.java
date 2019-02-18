import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class RationalFractions implements Iterable<RationalFraction> {
    public int length = 0;
    private ArrayList<RationalFraction> fractions;
    private RationalFraction maxFraction = new RationalFraction(1, Integer.MAX_VALUE);
    private RationalFraction minFraction = new RationalFraction(Integer.MAX_VALUE, 1);

    public RationalFractions(ArrayList<RationalFraction> fractions) {
        this.fractions = fractions;
        length = fractions.size();
    }

    public RationalFractions() {
        this.fractions = new ArrayList<RationalFraction>();
    }

    public void add(RationalFractions fractions) {
        int minLength = Math.min(this.length, fractions.length);
        for (int i = 0; i < minLength; i++) {
            this.fractions.get(i).add(fractions.get(i));
        }
        int i = fractions.length - minLength;
        while (fractions.length > minLength) {
            this.push(fractions.get(fractions.length - i));
            --i;
        }
    }

    public RationalFraction get(int index) {
        return this.fractions.get(index);
    }

    public void push(RationalFraction fraction) {
        this.fractions.add(fraction);
        ++length;
        this.countMax();
        this.countMin();
    }

    public int numGreaterThan(RationalFraction fraction) {
        int num = 0;
        for (RationalFraction fr : fractions) {
            if (fr.getIrrational() > fraction.getIrrational())
                ++num;
        }
        return num;
    }

    public int numLesserThan(RationalFraction fraction) {
        int num = 0;
        for (RationalFraction fr : fractions) {
            if (fr.getIrrational() < fraction.getIrrational())
                ++num;
        }
        return num;
    }

    public RationalFraction min() {
        return this.minFraction;
    }

    public RationalFraction max() {
        return this.maxFraction;
    }


    private void countMax() {
        fractions.forEach(fraction -> {
            if (maxFraction.getIrrational() < fraction.getIrrational())
                maxFraction = fraction;
        });
    }

    private void countMin() {
        fractions.forEach(fraction -> {
            if (minFraction.getIrrational() > fraction.getIrrational())
                minFraction = fraction;
        });
    }

    public Iterator<RationalFraction> getIterator() {
        return this.fractions.iterator();
    }

    @Override
    public Iterator<RationalFraction> iterator() {
        return fractions.iterator();
    }

    @Override
    public void forEach(Consumer<? super RationalFraction> action) {
        for (RationalFraction fraction : fractions) {
            action.accept(fraction);
        }
    }

    @Override
    public boolean equals(Object fractions) {
        if (!(fractions instanceof RationalFractions)) return false;
        RationalFractions fractions1 = (RationalFractions) fractions;

        if (this.length != fractions1.length) return false;
        boolean isEqual = true;

        for (int i = 0; i < this.length; i++) {
            if (!this.fractions.get(i).equals(fractions1.get(i))) isEqual = false;
        }
        return isEqual;
    }
}
