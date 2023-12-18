package Calculator.view;

import java.util.Scanner;

import Calculator.data.Calculable;
import Calculator.factory.iCalculableFactory;

public class CalculatorView {
    private final iCalculableFactory calculableFactory;

    public CalculatorView(iCalculableFactory calculableFactory) {
        this.calculableFactory = calculableFactory;
    }

    public void run() {
        while (true) {
            int primaryArg = promptInt("Введите первый аргемент: ");
            Calculable calculator = calculableFactory.create(primaryArg);

            while (true) {
                String cmd = prompt("Введите команду (+, =, *, /): ");

                if (cmd.equals("*")) {
                    double arg = promptInt("Введите второй аргумент: ");
                    calculator.multi(arg);
                    continue;
                }

                if (cmd.equals("+")) {
                    double arg = promptInt("Введите второй аргумент: ");
                    calculator.sum(arg);
                    continue;
                }

                if (cmd.equals("/")) {
                    double arg = promptInt("Введите второй аргумент: ");
                    calculator.div(arg);
                    continue;
                }

                if (cmd.equals("=")) {
                    double result = calculator.getResult();
                    System.out.printf("Результат %f\n", result);
                    break;
                }

                
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }

    private int promptInt(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return Integer.parseInt(in.nextLine());
    }
}
