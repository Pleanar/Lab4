package interfaces;

import enums.Instruction;
import estate.Barge;
import requisite.Stock;

public interface IBoss{
    String getImmovables();
    String getStocks();
    String giveInstruction(Barge barge, Instruction instruction, Stock stock);
    boolean haveStock(Stock stock);
    String buyStock(Stock stock);
    String sellStock(Stock stock);
    boolean evaluateStock(Stock stock);
}