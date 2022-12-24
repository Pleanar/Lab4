package places.estate;

import enums.Instruction;
import enums.Position;
import interfaces.IBoss;
import interfaces.IEmployee;
import interfaces.IName;
import requisite.Stock;
import java.util.ArrayList;
import java.util.Objects;

public class Barge extends Immovables {

    private ArrayList<IEmployee> employees = new ArrayList<>(0);

    public Barge(String name, String owner, Position position) {
        super(name, owner, position);
    }

    public Barge() {
        super();
        this.setName("неизвестная баржа");
    }


    public void addEmployee(IEmployee employee){
        employees.add(employee);
    }

    public void fireEmployee(IEmployee employee){
        employees.remove(employee);
    }

    public String getEmployees(){
        String list = "работают:";
        for (IEmployee iEmployee : employees) {
            IName employee = (IName) iEmployee;
            list = list + "сотрудник - " + employee.getName();
        }
        return list;
    }

    public String applyInstructions(IBoss boss, Instruction command, Stock stock) {

        String result = "";

        if (command.getInstruction().equals(Instruction.BUY.getInstruction())){
            for (IEmployee worker : employees){
                result += worker.buyInstruction(boss, stock);
            }
        }

        if (command.getInstruction().equals(Instruction.SELL.getInstruction())){
            for (IEmployee worker : employees){
                result += worker.sellInstruction(boss, stock);
            }
        }

        return result;
    }
}