package lab2;

class BusBuilder {
    private Bus _bus;

    BusBuilder() {
        _bus = new Bus();
    }


    BusBuilder BoardPassenger(BusPassenger... passengers){
        for (var pas:passengers
             ) {
            BoardPassenger(pas);
        }
        return this;
    }
    BusBuilder BoardPassenger(BusPassenger passenger){
        _bus.BoardPassenger(passenger);
        switch (passenger.GetBusPassengerType()){
            case ADULT:
                _bus._overallCost += 100;
                break;
            case CHILD:
                _bus._overallCost += 50;
                break;
            case DISCOUNT:
                _bus._overallCost += 25;
                break;
        }
        return this;
    }

    BusBuilder BoardDriver(){
        _bus.BoardDriver(new BusDriver());
        return this;
    }

    Bus GetBus(){
        var old_bus = _bus;
        _bus = new Bus();
        return old_bus;
    }


}
