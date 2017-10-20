package kirito04800.cours_android;

import java.io.Serializable;

/**
 * Created by julienavalle on 02/10/2017.
 */

public class Bottle implements Serializable {
    private String name;
    private double price;


    Bottle(){

    }


    Bottle(String name,double price){
        this.name=name;
        this.price=price;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
