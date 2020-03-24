package lab2;

public interface Builder {
    void BoardPassenger(Passenger passenger);
    void BoardChildPassenger(Passenger passenger);
    void BoardDiscountPassenger(Passenger passenger);
    void BoardDriver();
    void AddChildSeat();
}
