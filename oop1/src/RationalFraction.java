public class RationalFraction {
    private int m;
    private int n;

    public RationalFraction(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public void add(RationalFraction fraction) {
        if (this.n == fraction.n) {
            this.m += fraction.m;
        } else {
            this.m = this.m * fraction.n + fraction.m * this.n;
            this.n *= fraction.n;
        }
    }

    public double getIrrational() {
        return (double) m / (double) n;
    }

    @Override
    public String toString() {
        return Integer.toString(m) + "/" + Integer.toString(n);
    }

    @Override
    public boolean equals(Object fraction) {
        if (fraction instanceof RationalFraction) {
            RationalFraction fraction1 = (RationalFraction) fraction;
            return this.m == fraction1.m && this.n == fraction1.n;
        }
        return false;
    }
}
