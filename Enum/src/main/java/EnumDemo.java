/**
 * Created by sbt-opolskiy-va on 26.04.2017.
 */

enum Mobile {
    Samsung(300), Nokia(400), Motorolla(500);

    int price;
    Mobile(int p) {
        price = p;
    }

    int showPrice() {
        return price;
    }
}

public class EnumDemo {
    public static void main(String[] args) {
        for (Mobile m : Mobile.values() ) {
            System.out.println(m + " costs " + m.showPrice() + " dollars. The ordinall is " + m.ordinal());
        }

        Mobile ret = Mobile.Motorolla;
        System.out.println("The ordinall is " + ret.ordinal());
    }

}
