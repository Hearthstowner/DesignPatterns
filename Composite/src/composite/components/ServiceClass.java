package composite.components;

import java.util.ArrayList;
import java.util.List;

public class ServiceClass implements CanGetWight {

    public List<CanGetWight> passengers = new ArrayList<>();
    private final int WEIGHT_WITHOUT_PRICE;


    protected ServiceClass(int weightWithoutPrice) {
        WEIGHT_WITHOUT_PRICE = weightWithoutPrice;
    }



    public void add(CanGetWight canGetWight, int weight) {
        if(this.SetWeight(weight))
            canGetWight.SetWeight(weight);
        passengers.add(canGetWight);
    }

    public void remove(CanGetWight canGetWight) {
        canGetWight.SetWeight(-1);
    }

    @Override
    public int GetWeight() {
        int sum = 0;
        for(CanGetWight canGetWight : passengers)
            sum += canGetWight.GetWeight();
        return sum;
    }

    public boolean SetWeight(int weight) {
        if(weight >= WEIGHT_REQ && weight <= WEIGHT_LIMIT){
            if(weight > WEIGHT_WITHOUT_PRICE){
                System.out.println("ПЛАТИ");
//                item.setWeight(weight);
                return true;
            }
            System.out.println("Загружен");
//            item.setWeight(weight);
            return true;
        }
        else
            return false;
    }
}
