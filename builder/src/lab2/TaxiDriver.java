package lab2;

class TaxiDriver extends Driver{
    private final String _licence;

    TaxiDriver(String licence) {
        _licence = licence;
    }

    String GetLicence(){
        return _licence;
    }
}
