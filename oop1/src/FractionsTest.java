import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionsTest {
    private RationalFraction fraction1;
    private RationalFraction fraction2;
    private RationalFraction fraction3;
    private RationalFraction fraction4;
    RationalFractions fractions;
    Polynom polynom;

    //Rational Fractions
    @BeforeEach
    public void init() {
        fraction1 = new RationalFraction(1, 3);
        fraction2 = new RationalFraction(2, 3);
        fraction3 = new RationalFraction(2, 2);
        fraction4 = new RationalFraction(8, 6);
        fractions = new RationalFractions();
        fractions.push(fraction1);
        fractions.push(fraction2);
        fractions.push(fraction3);
        fractions.push(fraction4);

        polynom = new Polynom(fractions);
    }

    //Rational Fraction

    @Test
    void testAddWithEqualN() throws Exception {
        fraction1.add(fraction2);
        RationalFraction result = new RationalFraction(3, 3);
        assertEquals(fraction1, result);
    }

    @Test
    void testAddWithDifferentN() throws Exception {
        fraction1.add(fraction3);
        RationalFraction result = new RationalFraction(8, 6);
        assertEquals(fraction1, result);
    }

    @Test
    void testMax() throws Exception {
        assertEquals(fractions.max(), fraction4);
    }

    @Test
    void testMin() throws Exception {
        assertEquals(fractions.min(), fraction1);
    }

    //Polynom

    @Test
    void testAddPolynom() throws Exception {
        RationalFraction fraction21 = new RationalFraction(1, 3);
        RationalFraction fraction22 = new RationalFraction(4, 3);
        RationalFraction fraction23 = new RationalFraction(2, 2);
        RationalFractions fractions2 = new RationalFractions();
        fractions2.push(fraction21);
        fractions2.push(fraction22);
        fractions2.push(fraction23);
        Polynom polynom2 = new Polynom(fractions2);

        RationalFraction fraction31 = new RationalFraction(2, 3);
        RationalFraction fraction32 = new RationalFraction(6, 3);
        RationalFraction fraction33 = new RationalFraction(4, 2);
        RationalFraction fraction34 = new RationalFraction(8, 6);
        RationalFractions fractions3 = new RationalFractions();
        fractions3.push(fraction31);
        fractions3.push(fraction32);
        fractions3.push(fraction33);
        fractions3.push(fraction34);

        Polynom result = new Polynom(fractions3);
        polynom.add(polynom2);
        assertEquals(polynom, result);
    }
}
