package enums;

public enum Position {
    UNKNOWN("Неизвестно где"),
    HOMETOWN("Родной город"),
    FIELD("Поле"),
    DAVILON("Давилон"),
    RAILWAY_STATION("Вокзал");


    private final String location;
    Position(String location)
    {
        this.location = location;
    }

    public String getPlace() {
        return this.location;
    }
}