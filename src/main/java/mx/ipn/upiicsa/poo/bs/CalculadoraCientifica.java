package mx.ipn.upiicsa.poo.bs;

import java.util.List;

public class CalculadoraCientifica extends Calculadora{
    public static final int OPERATOR_SENO = 6;
    public static final int OPERATOR_COSENO = 7;

    public Double calculate(int operator, List<Double> operands){
        Double resultado=0.0;
        switch (operator){
            case OPERATOR_SENO:
                resultado=seno(operands);
                break;

            case OPERATOR_COSENO:
                break;
            default:
                resultado = -1.0;
                break;
        }
        return resultado;
    }

    public Double seno(List<Double> number) {
        return Math.sin(number);
    }

    public Double coseno(Double numero){
        return Math.cos(numero);
    }

}
