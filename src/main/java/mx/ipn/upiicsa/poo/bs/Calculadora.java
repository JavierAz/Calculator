package mx.ipn.upiicsa.poo.bs;

import mx.ipn.upiicsa.poo.exception.DivZeroException;

import java.util.List;

public class Calculadora {
    public static final int OPERATOR_SUMA = 1;
    public static final int OPERATOR_RESTA = 2;
    public static final int OPERATOR_MULTIPLICACION = 3;
    public static final int OPERATOR_DIVISION = 4;
    public static final int OPERATOR_PORCENTAJE = 5;
    public static final int OPERATOR_SENO = 6;
    public static final int OPERATOR_COSENO = 7;
    public static final int OPERATOR_FACTORIAL = 8;
    public static final int OPERATOR_CUADRADO = 9;
    public static final int OPERATOR_CUBO = 10;
    public static final int OPERATOR_XALAY = 11;
    public static final int OPERATOR_EALAX = 12;
    public static final int OPERATOR_10ALAX = 13;
    public static final int OPERATOR_1SOBREX = 14;
    public static final int OPERATOR_RAIZCUADRADA = 15;
    public static final int OPERATOR_RAIZCUBICA = 16;
    public static final int OPERATOR_RAIZDEY = 17;
    public static final int OPERATOR_LOGN = 18;
    public static final int OPERATOR_LOG10 = 19;
    public static final int OPERATOR_TAN = 20;
    public static final int OPERATOR_E = 21;
    public static final int OPERATOR_PI = 22;

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
            case OPERATOR_SENO:
                System.out.println("---> valor de operand" + operands.get(0));
                resultado = seno(operands);
                break;
            case OPERATOR_COSENO:
                resultado = coseno(operands);
                break;
            case OPERATOR_FACTORIAL:
                resultado = factorial(operands);
                break;
            case OPERATOR_CUADRADO:
                resultado = cuadrado(operands);
                break;
            case OPERATOR_CUBO:
                resultado = cubo(operands);
                break;
            case OPERATOR_XALAY:
                resultado = xAlaY(operands);
                break;
            case OPERATOR_EALAX:
                resultado = ealaX(operands);
                break;
            case OPERATOR_10ALAX:
                resultado = alaX(operands);
                break;
            case OPERATOR_1SOBREX:
                resultado = sobreX(operands);
                break;
            case OPERATOR_RAIZCUADRADA:
                resultado = raizCuadrada(operands);
                break;
            case OPERATOR_RAIZCUBICA:
                resultado = raizCubica(operands);
                break;
            case OPERATOR_RAIZDEY:
                resultado = raizdeY(operands);
                break;
            case OPERATOR_LOGN:
                resultado = logNat(operands);
                break;
            case OPERATOR_LOG10:
                resultado = log(operands);
                break;
            case OPERATOR_TAN:
                resultado = tan(operands);
                break;
            case OPERATOR_E:
                resultado = factorial(operands);
                break;
            case OPERATOR_PI:
                resultado = factorial(operands);
                break;
            default:
                resultado = -1.0;
                break;
        }
        return resultado;
    }

    public double suma(List<Double> operands) {
        double resultado = 0.0;
        for (Double operand : operands) {
            resultado = suma(resultado, operand);
        }
        return resultado;
    }

    public double resta(List<Double> values) {
        double resultado = 0.0;
        resultado = resta(values.get(0), values.get(1));
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

    public double porcentaje(List<Double> values) {
        double resultado = 0.0;
        for (Double value : values) {
            resultado = porcentaje(resultado, value);
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

    public double seno(List<Double> numbers) {
        double resultado = 0;
        resultado = seno(numbers.get(0));
        System.out.println("resultado: " + resultado);
        return resultado;
    }

    public Double seno(Double number) {
        return Math.sin(number);
    }

    public double coseno(List<Double> numero){
        return Math.cos(numero.get(0));
    }

    public double factorial(List<Double> numero){
        double resultado=1.0;
        for (double i = numero.get(0); i > 0; i--) {
            System.out.println("---> valor del numero: "+i);
            resultado=resultado*i;
        }
        return resultado;
    }

    public double cuadrado(List<Double> numbers){
        double resultado;
        resultado=Math.pow(numbers.get(0), 2);
        return resultado;
    }

    public double cubo(List<Double> numbers){
        double resultado;
        resultado=Math.pow(numbers.get(0), 3);
        return resultado;
    }

    public double xAlaY(List<Double> numbers){
        double resultado;
        resultado=Math.pow(numbers.get(0), numbers.get(1));
        return resultado;
    }

    public double ealaX(List<Double> numbers){
        double resultado;
        resultado=Math.pow(Math.E, numbers.get(0));
        return resultado;
    }

    public double alaX(List<Double> numbers){
        double resultado;
        resultado=Math.pow(10, numbers.get(0));
        return resultado;
    }

    public double sobreX(List<Double> numbers){
        double resultado;
        resultado=1/numbers.get(0);
        return resultado;
    }

    public double raizCuadrada(List<Double> numbers){
        double resultado;
        resultado = Math.sqrt(numbers.get(0));
        return resultado;
    }

    public double raizCubica(List<Double> numbers){
        double resultado;
        resultado = Math.cbrt(numbers.get(0));
        return resultado;
    }

    public double raizdeY(List<Double> numbers){
        double resultado;
        resultado = Math.pow(numbers.get(0), 1/numbers.get(1));
        return resultado;
    }

    public double logNat(List<Double> numbers){
        double resultado;
        resultado =Math.log(numbers.get(0));
        return  resultado;
    }

    public double log(List<Double> numbers){
        double resultado;
        resultado =Math.log(numbers.get(0));
        return  resultado;
    }

    public double tan(List<Double> numbers){
        double resultado;
        resultado =Math.tan(numbers.get(0));
        return resultado;
    }
}
