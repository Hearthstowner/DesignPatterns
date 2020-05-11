package composite.containers;

import composite.components.ServiceClass;
import composite.components.CanGetWight;
import composite.components.Passenger;

public class EconomyClass extends ServiceClass {
    public EconomyClass(int weightWithoutPrice) {
        super(weightWithoutPrice);
    }

    @Override
    public int GetWeight() {
        int sum = 0;
        for(CanGetWight canGetWight : super.passengers){
            if(canGetWight.GetWeight() != -1)
                sum += canGetWight.GetWeight();
        }
        return sum;
    }
}
