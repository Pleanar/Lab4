package  interfaces;

import  requisite.Stock;

public interface IEmployee{
    String buyInstruction(IBoss boss, Stock stock);
    String  sellInstruction(IBoss boss, Stock stock);
}