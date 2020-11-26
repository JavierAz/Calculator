package mx.ipn.upiicsa.poo.gui;

import mx.ipn.upiicsa.poo.bs.Calculadora;
import mx.ipn.upiicsa.poo.exception.DivZeroException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCalculadora extends JFrame {
    protected static final Integer CERO = 0;
    protected static final Integer UNO = 1;
    protected static final Integer DOS = 2;
    protected static final Integer TRES = 3;
    protected static final Integer CUATRO = 4;
    protected static final Integer CINCO = 5;
    protected static final Integer SEIS = 6;
    protected static final Integer SIETE = 7;
    protected static final Integer OCHO = 8;
    protected static final Integer NUEVE = 9;
    protected static final String PUNTO = ".";
    protected static final String EMPTY_STRING = "";

    protected static final int STATE_INIT = 0;
    protected static final int STATE_CAPTURE = 1;
    protected static final int STATE_OPERATOR = 2;
    protected static final int STATE_CALCULATE = 3;
    protected int state;

    protected static final int ACTION_NUMBER = 0;
    protected static final int ACTION_OPERATOR = 1;
    protected static final int ACTION_EQUAL = 2;
    protected static final int ACTION_CLEAN = 3;

    protected int operador;
    protected Double valor1;
    protected Double valor2;
    protected Double resultado;
    protected Calculadora calculadora;

    protected JMenuItem menu;

    protected JTextField display;
    protected JButton button0;
    protected JButton button1;
    protected JButton button2;
    protected JButton button3;
    protected JButton button4;
    protected JButton button5;
    protected JButton button6;
    protected JButton button7;
    protected JButton button8;
    protected JButton button9;
    protected JButton buttonPunto;
    protected JButton buttonClear;
    protected JButton buttonPorcentaje;
    protected JButton buttonDivision;
    protected JButton buttonProducto;
    protected JButton buttonSuma;
    protected JButton buttonResta;
    protected JButton buttonIgual;

    public VentanaCalculadora() {
        state = STATE_INIT;
        calculadora = new Calculadora();
        initComponents();
    }

    protected void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 430);
        setResizable(false);

        instantiateComponents();
        buildGrid();
        initializeListener();

        setVisible(true);
    }

    protected void initializeListener() {
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //System.out.println(0);
                capturarNumero(CERO.toString());

            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarNumero(UNO.toString());
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarNumero(DOS.toString());
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarNumero(TRES.toString());
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarNumero(CUATRO.toString());
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarNumero(CINCO.toString());
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarNumero(SEIS.toString());
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarNumero(SIETE.toString());
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarNumero(OCHO.toString());
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarNumero(NUEVE.toString());
            }
        });
        buttonPunto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarNumero(PUNTO);
            }
        });
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                limpiarDisplay();
            }
        });
        buttonSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarOperador(calculadora.OPERATOR_SUMA);
            }
        });
        buttonResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarOperador(calculadora.OPERATOR_RESTA);
            }
        });
        buttonProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarOperador(calculadora.OPERATOR_MULTIPLICACION);
            }
        });
        buttonDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarOperador(calculadora.OPERATOR_DIVISION);
            }
        });
        buttonPorcentaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarOperador(calculadora.OPERATOR_PORCENTAJE);
            }
        });
        buttonIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                actualizarEstado(ACTION_EQUAL);
                actualizarDisplay("");
            }
        });
    }

    protected void instantiateComponents() {
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
//        menu = new JMenuItem();
//        menu.setText("Calculadora Cientifica");
        //display.add(menu);
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonPunto = new JButton(".");
        buttonClear = new JButton("AC");
        buttonPorcentaje = new JButton("%");
        buttonDivision = new JButton("/");
        buttonProducto = new JButton("*");
        buttonSuma = new JButton("+");
        buttonResta = new JButton("-");
        buttonIgual = new JButton("=");

    }

    protected void buildGrid() {
        Container pane = getContentPane();
        GridBagLayout calculadoraGrid = new GridBagLayout();
        GridBagConstraints calculadoraGridConstraints = new GridBagConstraints();
        pane.setLayout(calculadoraGrid);

        calculadoraGridConstraints.fill = GridBagConstraints.HORIZONTAL;
        calculadoraGridConstraints.weightx = 0.5;
        calculadoraGridConstraints.ipady = 40;
        //pane.add(menu, calculadoraGridConstraints);

        calculadoraGridConstraints.gridx = 0;
        calculadoraGridConstraints.gridy = 0;
        calculadoraGridConstraints.gridwidth = 40;
        pane.add(display, calculadoraGridConstraints);

        calculadoraGridConstraints.gridx = 0;
        calculadoraGridConstraints.gridy = 1;
        calculadoraGridConstraints.gridwidth = 2;
        pane.add(buttonClear, calculadoraGridConstraints);
        buttonClear.setBackground(Color.darkGray);

        calculadoraGridConstraints.gridwidth = 1;
        calculadoraGridConstraints.gridx = 2;
        calculadoraGridConstraints.gridy = 1;
        pane.add(buttonPorcentaje, calculadoraGridConstraints);
        buttonPorcentaje.setBackground(Color.darkGray);

        calculadoraGridConstraints.gridx = 3;
        calculadoraGridConstraints.gridy = 1;
        pane.add(buttonDivision, calculadoraGridConstraints);
        buttonDivision.setBackground(Color.orange);

        //bloque 2
        calculadoraGridConstraints.gridx = 0;
        calculadoraGridConstraints.gridy = 2;
        pane.add(button7, calculadoraGridConstraints);
        button7.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 1;
        calculadoraGridConstraints.gridy = 2;
        pane.add(button8, calculadoraGridConstraints);
        button8.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 2;
        calculadoraGridConstraints.gridy = 2;
        pane.add(button9, calculadoraGridConstraints);
        button9.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 3;
        calculadoraGridConstraints.gridy = 2;
        pane.add(buttonProducto, calculadoraGridConstraints);

        //bloque 3
        calculadoraGridConstraints.gridx = 0;
        calculadoraGridConstraints.gridy = 3;
        pane.add(button4, calculadoraGridConstraints);
        button4.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 1;
        calculadoraGridConstraints.gridy = 3;
        pane.add(button5, calculadoraGridConstraints);
        button5.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 2;
        calculadoraGridConstraints.gridy = 3;
        pane.add(button6, calculadoraGridConstraints);
        button6.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 3;
        calculadoraGridConstraints.gridy = 3;
        pane.add(buttonResta, calculadoraGridConstraints);

        //bloque 4
        calculadoraGridConstraints.gridx = 0;
        calculadoraGridConstraints.gridy = 4;
        pane.add(button1, calculadoraGridConstraints);
        button1.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 1;
        calculadoraGridConstraints.gridy = 4;
        pane.add(button2, calculadoraGridConstraints);
        button2.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 2;
        calculadoraGridConstraints.gridy = 4;
        pane.add(button3, calculadoraGridConstraints);
        button3.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 3;
        calculadoraGridConstraints.gridy = 4;
        pane.add(buttonSuma, calculadoraGridConstraints);

        //bloque 5
        calculadoraGridConstraints.gridx = 0;
        calculadoraGridConstraints.gridy = 5;
        calculadoraGridConstraints.gridwidth = 2;
        pane.add(button0, calculadoraGridConstraints);
        button0.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 2;
        calculadoraGridConstraints.gridy = 5;
        calculadoraGridConstraints.gridwidth = 1;
        pane.add(buttonPunto, calculadoraGridConstraints);
        buttonPunto.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 3;
        calculadoraGridConstraints.gridy = 5;
        pane.add(buttonIgual, calculadoraGridConstraints);

    }

    public void actualizarDisplay(String valor) {
        if (state==STATE_INIT){
            display.setText(valor);
        }else if (state == STATE_CAPTURE) {
            String valorActual = display.getText();
            display.setText(valorActual + valor);
        } else if (state == STATE_OPERATOR) {
            String valorString = display.getText();
            display.setText(valor);
            valor1 = Double.parseDouble(valorString);
        } else if (state == STATE_CALCULATE) {
            String resultadoString = null;
            String valorString = display.getText();
            valor2 = Double.parseDouble(valorString);
            try {
                resultado = calculadora.calculate(operador, valor1, valor2);
                resultadoString = resultado.toString();
            } catch (DivZeroException e) {
                resultadoString = "Syntax Error";
                actualizarEstado(ACTION_CLEAN);
                JOptionPane.showMessageDialog(this, "Syntax Error", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                display.setText(resultadoString);
            }
            display.setText(resultado.toString());
        }
    }

    public void limpiarDisplay() {
        display.setText(EMPTY_STRING);
        actualizarEstado(ACTION_CLEAN);
    }

    protected void actualizarEstado(int action) {
        if (action == ACTION_CLEAN) {
            state = STATE_INIT;
        } else if (state == STATE_INIT && action == ACTION_NUMBER || state == STATE_OPERATOR && action == ACTION_NUMBER || state == STATE_CALCULATE && action == ACTION_NUMBER) {
            state = STATE_CAPTURE;
        } else if (state == STATE_CAPTURE && action == ACTION_OPERATOR || state == STATE_CALCULATE && action == ACTION_OPERATOR) {
            state = STATE_OPERATOR;
        } else if (state == STATE_CAPTURE && action == ACTION_EQUAL) {
            state = STATE_CALCULATE;
        }
    }

    protected void capturarNumero(String numero) {
        actualizarDisplay(numero);
        actualizarEstado(ACTION_NUMBER);
    }

    protected void capturarOperador(int operator) {
        setOperador(operator);
        actualizarEstado(ACTION_OPERATOR);
    }

    protected void asignarOperador(int operador) {

    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public void setState(int state) {
        this.state = state;
    }

    public int getOperador() {
        return operador;
    }

    public void setOperador(int operador) {
        this.operador = operador;
    }

    public Double getValor1() {
        return valor1;
    }

    public void setValor1(Double valor1) {
        this.valor1 = valor1;
    }

    public Double getValor2() {
        return valor2;
    }

    public void setValor2(Double valor2) {
        this.valor2 = valor2;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
}
