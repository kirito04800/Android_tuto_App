package kirito04800.cours_android;

import java.util.ArrayList;

/**
 * Created by julienavalle on 02/10/2017.
 */

public class Cellar {

    private ArrayList<Bottle> listeBottle=new ArrayList<Bottle>();
    private Bottle tempsBottle;

    Cellar(){
    }


    public void addBottle(String name, double price){
        tempsBottle = new Bottle(name,price);
        if (!listeBottle.contains(tempsBottle)){ // on add pas si existe deja
            listeBottle.add(tempsBottle);
        }
    } //(Les prix sont ajoutés en Euro et on a l’équivalence 1€ = 0.8$)

    public Bottle getBottle(String name){
        for (Bottle b:listeBottle){
            if (name.equals(b.getName())){
                return b;
            }
        }
        return null;
    }

    public double getEuroPrice(String name){
        return getBottle(name).getPrice();
    }

    public double getDollarPrice(String name){
        return getBottle(name).getPrice()*0.8;
    }

    public ArrayList<Bottle> getListeBottle(){
        return listeBottle;
    }

}
