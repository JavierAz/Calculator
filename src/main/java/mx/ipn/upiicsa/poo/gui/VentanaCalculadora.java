package mx.ipn.upiicsa.poo.gui;

import mx.ipn.upiicsa.poo.bs.Calculadora;
import mx.ipn.upiicsa.poo.exception.DivZeroException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

    protected Integer operador;
    protected List<Double> valores;
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

    protected JPanel basica;
    protected JPanel cientifica;

    public VentanaCalculadora() {
        state = STATE_INIT;
        calculadora = new Calculadora();
        valores = new ArrayList<>();
        operador = null;
        initComponents();
        display.setText("0");
    }

    protected void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 430);
        setResizable(false);

        instantiateComponents();
        buildBasicaGrid();
        buildGridCientifica();
        buildMenu();
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
                valores.clear();
                display.setText("0");
                operador=null;
                state=STATE_INIT;
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
                clickEquals();
            }
        });
    }

    protected void instantiateComponents() {
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        menu = new JMenuItem();
        menu.setText("Calculadora Cientifica");
        display.add(menu);
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

        basica = new JPanel();
        cientifica = new JPanel();
        JPanel gridsContainer = new JPanel();
        gridsContainer.setLayout(new BoxLayout(gridsContainer, BoxLayout.X_AXIS));
        gridsContainer.add(cientifica);
        gridsContainer.add(basica);

        Container pane = getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.add(display);
        pane.add(gridsContainer);
        cientifica.setVisible(false);
    }

    protected void buildBasicaGrid() {
        JPanel pane = basica;
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

    protected void buildGridCientifica() {
        JPanel pane = cientifica;


        pane.add(new JButton("label"));

    }

    protected void buildMenu(){
        //Create the menu bar.
        JMenuBar menuBar = new JMenuBar();

//Build the first menu.
        JMenu menu = new JMenu("Modo");
        menuBar.add(menu);

//a group of JMenuItems
        JMenuItem menuItem = new JMenuItem("basica");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cientifica.setVisible(false);
            }
        });
        JMenuItem menuItem2 = new JMenuItem("cientifica");
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cientifica.setVisible(true);
            }
        });

        menu.add(menuItem);
        menu.add(menuItem2);
        setJMenuBar(menuBar);
    }

    public void actualizarDisplay(String valor) {
        String valorActual = display.getText();
        display.setText(valorActual + valor);
    }

    public void limpiarDisplay() {
        display.setText(EMPTY_STRING);
    }

    protected void capturarNumero(String numero) {
        if (state == STATE_INIT) {
            display.setText("");
            actualizarDisplay(numero);
            state = STATE_CAPTURE;
        } else if (state == STATE_CAPTURE) {
            actualizarDisplay(numero);
        } else if (state == STATE_OPERATOR) {
            display.setText("");
            actualizarDisplay(numero);
            state = STATE_CAPTURE;
        } else if (state == STATE_CALCULATE) {
            actualizarDisplay(numero);
            valores.clear();
            operador = null;
            state = STATE_CAPTURE;
        }
    }

    protected void capturarOperador(int operator) {
        if (state == STATE_INIT) {
            valores.add(Double.valueOf(display.getText()));
            setOperador(operator);
            state = STATE_OPERATOR;
        } else if (state == STATE_CAPTURE) {
            valores.add(Double.valueOf(display.getText()));
            setOperador(operator);
            state = STATE_OPERATOR;
        } else if (state == STATE_CALCULATE) {
            valores.clear();
            valores.add(Double.valueOf(display.getText()));
            setOperador(operator);
            state = STATE_OPERATOR;
        } else if (state == STATE_OPERATOR) {
            setOperador(operator);
        }
    }

    protected void clickEquals() {
        if (state == STATE_CAPTURE) {
            if (getOperador() != null) {
                valores.add(Double.valueOf(display.getText()));
                Double resultado = compute();
                display.setText("");
                actualizarDisplay(resultado.toString());
                valores.clear();
                operador = null;
                state = STATE_CALCULATE;
            }
        }
    }

    protected Double compute() {
        try {
            return calculadora.calculate(operador, valores);
        } catch (DivZeroException e) {
            JOptionPane.showMessageDialog(this, "Syntax Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0.0;
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public void setState(int state) {
        this.state = state;
    }

    public Integer getOperador() {
        return operador;
    }

    public void setOperador(Integer operador) {
        this.operador = operador;
    }

    public List<Double> getValores() {
        return valores;
    }

    public void setValores(List<Double> valores) {
        this.valores = valores;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
}
