package estate;

import enums.Instruction;
import enums.Place;
import interfaces.IBoss;
import interfaces.IEmployee;
import interfaces.IName;
import requisite.Stock;
import java.util.ArrayList;

public class Barge extends Immovables {

    private ArrayList<IEmployee> employees = new ArrayList<>(0);

    public Barge(String name, String owner, Place position) {
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
        for (int i = 0; i < employees.size(); i++){
            IName employee = (IName) employees.get(i);
            list = list + "сотрудник -" + employee.getName();
        }
        return list;
    }

    public String applyInstructions(IBoss boss, Instruction command, Stock stock) {
        String result = "";
        if (command.getInstruction() == Instruction.BUY.getInstruction()){
            for (IEmployee worker : employees){
                result += worker.buyInstruction(boss, stock);
            }
        } else {
            for (IEmployee worker : employees){
                result += worker.sellInstruction(boss, stock);
            }
        }
        return result;
    }
}