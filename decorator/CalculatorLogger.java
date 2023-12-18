package Calculator.decorator;

import Calculator.data.Calculable;
import Calculator.log.Loggable;

public class CalculatorLogger implements Calculable{
    private Calculable calculator;
    private Loggable logger;

    public CalculatorLogger(Calculable calculator, Loggable logger) {
        this.calculator = calculator;
        this.logger = logger;
    }

    @Override
    public Calculable sum(double arg) {
        logger.log(String.format("Вычисляем сумму чисел: %f и %f", calculator.getResult(), arg));
        return calculator.sum(arg);
    }

    @Override
    public Calculable multi(double arg) {
        logger.log(String.format("Вычисляем произведение чисел: %f и %f", calculator.getResult(), arg));
        return calculator.multi(arg);
    }

    @Override
    public double getResult() {
        logger.log(String.format("Результат: %f", calculator.getResult()));
        return calculator.getResult();
    }

    @Override
    public Calculable div(double arg) {
        logger.log(String.format("Вычисляем деление чисел: %f и %f", calculator.getResult(), arg));
        return calculator.div(arg);
    }
    
}
