package Calculator.factory;

import Calculator.data.Calculable;
import Calculator.data.Calculator;

public class CalculableFactory implements iCalculableFactory {
    public Calculable create(int primaryArg) {
        return new Calculator(primaryArg);
    }
}
