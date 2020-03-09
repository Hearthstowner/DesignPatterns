package lab2;

class Bus extends AbstractCar {
    int _overallCost = 0;
    Bus() {
        super("D", 30);
    }

    void BoardDriver(BusDriver driver) {
        super.BoardDriver(driver);
    }

    void BoardPassenger(BusPassenger passenger){
//        if (_passengers.size() == _capacity) {
//            throw new Error("No more seats");
//        }
//        _passengers.add(passenger);
        super.BoardPassenger(passenger);
    }

    int GetOverallCost(){
        return _overallCost;
    }
}
