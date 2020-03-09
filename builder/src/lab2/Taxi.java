package lab2;

class Taxi extends AbstractCar {
    private boolean _childSeat = false;

    Taxi() {
        super("B", 4);
    }

    void AddChildSit() {
        _childSeat = true;
    }

    void BoardPassenger(TaxiPassenger passenger) {
        if (passenger.IsChild() && !HasChildSeat()) {
            throw new Error("Can't board child without child seat");
        }
        super.BoardPassenger(passenger);
    }

    void BoardDriver(TaxiDriver driver) {
        super.BoardDriver(driver);
    }

    private boolean HasChildSeat() {
        return _childSeat;
    }

}
