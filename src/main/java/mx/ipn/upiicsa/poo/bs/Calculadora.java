package mx.ipn.upiicsa.poo.bs;

import mx.ipn.upiicsa.poo.exception.DivZeroException;

import java.util.List;

public class Calculadora {
    public static final int OPERATOR_SUMA = 1;
    public static final int OPERATOR_RESTA = 2;
    public static final int OPERATOR_MULTIPLICACION = 3;
    public static final int OPERATOR_DIVISION = 4;
    public static final int OPERATOR_PORCENTAJE = 5;

    public Double calculate(int operator, List<Double> operands) throws DivZeroException {
        Double resultado;
        switch (operator) {
            case OPERATOR_SUMA:
                resultado = suma(operands);
                break;
            case OPERATOR_RESTA:
                resultado = resta(operands);
                break;
            case OPERATOR_MULTIPLICACION:
                resultado = producto(operands);
                break;
            case OPERATOR_DIVISION:
                resultado = division(operands);
                break;
            case OPERATOR_PORCENTAJE:
                resultado = porcentaje(operands);
                break;
            default:
                resultado = -1.0;
                break;
        }
        return resultado;
    }

    public double suma(List<Double> operands){
        double resultado=0.0;
        for(Double operand: operands){
            resultado=suma(resultado, operand);
        }
        return resultado;
    }

    public double resta(List<Double> values) {
        double resultado = 0.0;
        for (Double value : values) {
            resultado = resta(resultado, value);
        }
        return resultado;
    }

    public double producto(List<Double> values) {
        double resultado = 1;
        for (Double value : values) {
            resultado = producto(resultado, value);
        }
        return resultado;
    }

    public double division(List<Double> values) throws DivZeroException {
        double resultado = values.remove(0);
        for (Double value : values) {
            resultado = division(resultado, value);
        }
        return resultado;
    }

    public double porcentaje(List<Double> values){
        double resultado =0.0;
        for(Double value: values){
            resultado=porcentaje(resultado,value);
        }
        return resultado;
    }

    public Double suma(Double sumando1, Double sumando2) {
        return sumando1 + sumando2;
    }

    public Double resta(Double minuendo, Double sustraendo) {
        return minuendo - sustraendo;
    }

    public Double producto(Double factor1, Double factor2) {
        return factor1 * factor2;
    }

    public Double division(Double dividendo, Double divisor) throws DivZeroException {
        if (divisor == 0) {
            throw new DivZeroException();
        }
        return dividendo / divisor;
    }

    public Double porcentaje(Double cantidad, Double porcentaje) {
        return (cantidad * porcentaje) / 100;
    }

}
