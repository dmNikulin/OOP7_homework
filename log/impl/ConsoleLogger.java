package Calculator.log.impl;

import java.time.LocalDateTime;

import Calculator.log.Loggable;

public class ConsoleLogger implements Loggable{

    @Override
    public void log(String message) {
        System.out.printf("%n%s : %s%n", LocalDateTime.now(), message);
        
    }
    
}
