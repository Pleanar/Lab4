package enums;

public enum Instruction {
    BUY("Купить"),
    SELL("Продать");


    private final String content;
    Instruction(String content) {
        this.content = content;
    }

    public String getInstruction() {
        return this.content;
    }
}