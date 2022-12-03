package enums;

public enum Place {
    UNKNOWN("Неизвестно где"),
    HOMETOWN("Родной город"),
    FIELD("Поле"),
    DAVILON("Давилон"),
    RAILWAY_STATION("Вокзал");


    private final String location;
    Place(String location)
    {
        this.location = location;
    }

    public String getPlace() {
        return this.location;
    }
}