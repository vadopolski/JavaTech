interface Gorilla {
    public String move();
};

public class GorillaFamily {

    static String approach;

    public static void everyOnePlay(Boolean baby){

        String walk = "walk";

//        walk = "run";

        approach = "test";

        play(() -> walk);
        play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);
    }

    public static void play(Gorilla g){
        System.out.println( g.move());
    }

    public static void main(String[] args) {
        GorillaFamily.everyOnePlay(true);
    }

}