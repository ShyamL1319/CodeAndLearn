/**
 * Date: 10/02/2024:18:04
 * User: shyamlal
 */
public class PolyMorphism {
    public static void main(String[] args) {
        P obj = new C();
        System.out.println(obj.d1);
        System.out.println(obj.d);

        obj.fun1();
        obj.fun();
        P.sfun();
    }
}

class P {
    protected int d1 = 10;
    protected int d = 100;

    P() {
        System.out.println("PPPP");
    }

    static protected void sfun() {
        System.out.println("P's sfun");
    }

    protected void fun1() {
        System.out.println("P's fun1");
    }

    protected void fun() {
        System.out.println("P's fun");
    }
}


class C extends P {
    protected int d2 = 20;
    protected int d = 200;


    C() {
        System.out.println("CCC");
    }

    static protected void sfun() {
        System.out.println("C's sfun");
    }

    protected void fun2() {
        System.out.println("C's fun2");
    }

    protected void fun() {
        System.out.println("C's fun");
    }
}
