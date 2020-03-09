package lab2;

enum BusPassengerType{
    ADULT,
    CHILD,
    DISCOUNT
}

class BusPassenger extends Passenger {
    private BusPassengerType _busPassengerType;

    BusPassenger(BusPassengerType busPassengerType){
        _busPassengerType = busPassengerType;
    }

    BusPassengerType GetBusPassengerType() {
        return _busPassengerType;
    }
}
