package enums;

public enum Action {
    CAN_BUY("может купить"),
    CAN_SELL("может продать"),
    BUY("покупает"),
    SELL("продает"),
    GET_PRICE("узнать цену");


    private final String action;
    Action(String action) {
        this.action = action;
    }

    public String getAction() {
        return this.action;
    }
}