package Calculator;

import Calculator.decorator.CalculableWithLoggerFactory;
import Calculator.factory.CalculableFactory;
import Calculator.factory.iCalculableFactory;
import Calculator.view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        // iCalculableFactory calculableFactory = new CalculableFactory();
        iCalculableFactory calculableFactory = new CalculableWithLoggerFactory();
        CalculatorView view = new CalculatorView(calculableFactory);
        view.run();
    }
}
