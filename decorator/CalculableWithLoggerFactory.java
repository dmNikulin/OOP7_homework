package Calculator.decorator;

import Calculator.data.Calculable;
import Calculator.data.Calculator;
import Calculator.factory.iCalculableFactory;
import Calculator.log.impl.ConsoleLogger;

public class CalculableWithLoggerFactory implements iCalculableFactory {

    @Override
    public Calculable create(int primaryArg) {
        return new CalculatorLogger(new Calculator(primaryArg), new ConsoleLogger());
    }
    
}
