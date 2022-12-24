package enums;

public enum Instruction {
    BUY("купить"),
    SELL("продать");


    private final String content;
    Instruction(String content) {
        this.content = content;
    }

    public String getInstruction() {
        return this.content;
    }
}