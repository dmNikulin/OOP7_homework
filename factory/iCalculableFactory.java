package Calculator.factory;

import Calculator.data.Calculable;

public interface iCalculableFactory {
    Calculable create(int primaryArg);
}
