import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Laptop item1 = new Laptop(
                "Lenovo v1",
                8,
                256,
                "Windows",
                "Red",
                38
        );

        Laptop item2 = new Laptop(
                "Lenovo v2",
                3,
                512,
                "Windows",
                "Синий",
                48
        );


        Set <Laptop> laptopsInStock = new HashSet<>();
        laptopsInStock.add( item1 );
        laptopsInStock.add( item2 );

        Laptop.filter( laptopsInStock );

    }
}
