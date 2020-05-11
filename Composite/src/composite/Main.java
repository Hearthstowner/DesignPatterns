package composite;

import composite.components.Stewardess;
import composite.components.Passenger;
import composite.components.Pilot;
import composite.containers.Airplane;
import composite.containers.BusinessClass;
import composite.containers.EconomyClass;
import composite.containers.FirstClass;

public class Main {

    public static void main(String[] args) {
        BusinessClass businessClass = new BusinessClass(35);
        FirstClass firstClass = new FirstClass(0);
        EconomyClass economyClass = new EconomyClass(20);

        Airplane airplane = new Airplane(firstClass, businessClass, economyClass);

        airplane.boardInEconomy(new Passenger(), 10700);
        airplane.boardInBusiness(new Passenger(), 200);
        airplane.boardInFirst(new Passenger(), 100);
        airplane.boardInFirst(new Pilot(), 0);
        airplane.boardInFirst(new Stewardess(), 0);

        airplane.show();
    }
}
