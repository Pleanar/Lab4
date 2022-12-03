package enums;

public enum Action {
    CANBUY("можно купить"),
    BUY("купить"),
    SELL("продать"),
    GET_PRICE("узнать цену");


    private final String action;
    Action(String action) {
        this.action = action;
    }

    public String getAction() {
        return this.action;
    }
}