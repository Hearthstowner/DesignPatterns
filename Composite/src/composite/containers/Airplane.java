package composite.containers;
import composite.components.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Airplane {
    private FirstClass firstClass;
    private BusinessClass businessClass;
    private EconomyClass economyClass;

    private Pilot pilot1;
    private Pilot pilot2;
    private List<Stewardess> _stewardess = new ArrayList<>(6);
    private final int LUGGAGE_WEIGHT_LIMIT = 20000;

    public Airplane(FirstClass firstClass, BusinessClass businessClass, EconomyClass economyClass) {
        this.firstClass = firstClass;
        this.businessClass = businessClass;
        this.economyClass = economyClass;
    }

    public void checkAndDelete(int weight){
        int currentWeight = firstClass.GetWeight() + businessClass.GetWeight() + economyClass.GetWeight();
        if (LUGGAGE_WEIGHT_LIMIT - currentWeight < weight) {
            ListIterator listIterator = economyClass.passengers.listIterator(economyClass.passengers.size());
            while (LUGGAGE_WEIGHT_LIMIT - (firstClass.GetWeight() + businessClass.GetWeight() + economyClass.GetWeight()) < weight) {
                if (listIterator.hasPrevious())
                    economyClass.remove((CanGetWight) listIterator.previous());
            }
        }
    }

    public void boardInBusiness(CanGetWight canGetWight, int weight) {
        checkAndDelete(weight);
        businessClass.add(canGetWight, weight);
    }

    public void boardInFirst(CanGetWight canGetWight, int weight) {
        checkAndDelete(weight);
        firstClass.add(canGetWight, weight);
    }

    public void boardInEconomy(CanGetWight canGetWight, int weight) {
        economyClass.add(canGetWight, weight);
    }

    public void show(){
        System.out.println("Business Class: ");
        for(CanGetWight businessClass : businessClass.passengers){
            System.out.println(businessClass.toString());
            System.out.println(businessClass.GetWeight());
        }
        System.out.println("Economy Class: ");
        for(CanGetWight economy : economyClass.passengers){
            if(economy.GetWeight() != -1) {
                System.out.println(economy.toString());
                System.out.println(economy.GetWeight());
            }
            else {
                System.out.println(economyClass.toString());
                System.out.println("Luggage removed");
            }
        }
        System.out.println("First Class: ");
        for(CanGetWight first : firstClass.passengers){
            System.out.println(first.toString());
            System.out.println(first.GetWeight());
        }
    }

    public void addPilots(Pilot pilot1, Pilot pilot2){
        this.pilot1 = pilot1;
        this.pilot2 = pilot2;
    }

    public void addStewardess(Stewardess stewardess){
        _stewardess.add(stewardess);
    }

}
