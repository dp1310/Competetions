package InnerClasses;

public class Parcel2 {
    class Contents {
        private int i = 11;

        public int value() {
            return 1;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Rajpurohit");
        Parcel2 q = new Parcel2();

        // Defining references to inner classes:
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("Churu");
        q.ship(c.i + "");
        q.ship(d.label);
    }
}
