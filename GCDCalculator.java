/**
 * Date: 17/12/2023:12:18
 * User: shyamlal
 */
public class GCDCalculator {
    public static void main(String[] args) {
//        Fraction f = new Fraction(10,5);
//        Fraction res = f.add(f);

        Fraction x = new Fraction(2, 3);  // 2/3
        Fraction y = new Fraction(4, 5); // 4/5
        Fraction r1 = x.add(y); // 22/15
        Fraction r2 = x.subtract(y); // -2/15
        Fraction r3 = x.multiply(y); // 8/15
        System.out.println(r1.numerator + "/" + r1.denominator);
        System.out.println(r2.numerator + "/" + r2.denominator);
        System.out.println(r3.numerator + "/" + r3.denominator);
    }
}

class Fraction {
    int numerator, denominator;

    // Define constructor here
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    Fraction add(Fraction a) {
        // Complete the function
        int nom = (this.numerator * a.denominator + this.denominator * a.numerator);
        int den = this.denominator * a.denominator;
        int gcd = gcdCalculator(Math.abs(nom), Math.abs(den));
        Fraction f = new Fraction(nom / gcd, den / gcd);
        return f;


    }

    Fraction subtract(Fraction a) {
        // Complete the function
        int nom = (this.numerator * a.denominator - this.denominator * a.numerator);
        int den = this.denominator * a.denominator;

        int gcd = gcdCalculator(Math.abs(nom), Math.abs(den));

        return new Fraction(nom / gcd, den / gcd);

    }

    Fraction multiply(Fraction a) {
        // Complete the function
        int nom = this.numerator * a.numerator;
        int den = this.denominator * a.denominator;

        int gcd = gcdCalculator(Math.abs(nom), Math.abs(den));

        return new Fraction(nom / gcd, den / gcd);


    }

    int gcdCalculator(int a, int b) {
        if (b % a == 0) return a;
        return gcdCalculator(b % a, a);
    }
}

/*
    Fraction x = new Fraction(2, 3)  // 2/3
	Fraction y = new Fraction(4, 5) // 4/5
    Fraction z = x.add(y) // 22/15
    Fraction z = x.subtract(y) // -2/15
    Fraction z = x.multiply(y) // 8/15
*/