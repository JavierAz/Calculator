package mx.ipn.upiicsa.poo.gui;

import mx.ipn.upiicsa.poo.bs.CalculadoraCientifica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCalculadoraCientifica extends VentanaCalculadora {

    private JButton buttonEquisCuadrada;
    private JButton buttonEquisCubica;
    private JButton buttonEquisY;
    private JButton buttonEalaX;
    private JButton button10alaX;
    private JButton button1sobreX;
    private JButton buttonRaizCuadrada;
    private JButton buttonRaizCubica;
    private JButton buttonRaizdeY;
    private JButton buttonLogNatural;
    private JButton buttonLogBase10;
    private JButton buttonFactorial;
    private JButton buttonSeno;
    private JButton buttonCoseno;
    private JButton buttonTangente;
    private JButton buttonE;
    private JButton buttonPi;
    private CalculadoraCientifica calculadoraCientifica;

    public VentanaCalculadoraCientifica() {
        super();
    }

    @Override
    protected void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(650, 430);
        setResizable(false);

        instantiateComponents();
        buildBasicaGrid();
        initializeListener();

        setVisible(true);
    }

    @Override
    protected void initializeListener() {
        super.initializeListener();

        buttonSeno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                capturarOperador(calculadoraCientifica.OPERATOR_SENO);
                actualizarDisplay("");
            }
        });
    }

    @Override
    protected void instantiateComponents() {
        super.instantiateComponents();
        buttonEquisCuadrada = new JButton("X²");
        buttonEquisCubica = new JButton("X³");
        buttonEquisY = new JButton("X^y");
        buttonEalaX = new JButton("e^x");
        button10alaX = new JButton("10^x");
        button1sobreX = new JButton("1/x");
        buttonRaizCuadrada = new JButton("sqrt");
        buttonRaizCubica = new JButton("sqrt3");
        buttonRaizdeY = new JButton("sqrtY");
        buttonLogNatural = new JButton("ln");
        buttonLogBase10 = new JButton("log10");
        buttonFactorial = new JButton("x!");
        buttonSeno = new JButton("sin");
        buttonCoseno = new JButton("cos");
        buttonTangente = new JButton("tan");
        buttonE = new JButton("e");
        buttonPi = new JButton("pi");
    }

    @Override
    protected void buildBasicaGrid() {
        Container pane = getContentPane();
        GridBagLayout calculadoraGrid = new GridBagLayout();
        GridBagConstraints calculadoraGridConstraints = new GridBagConstraints();
        pane.setLayout(calculadoraGrid);

        calculadoraGridConstraints.fill = GridBagConstraints.HORIZONTAL;
        calculadoraGridConstraints.weightx = 0.5;
        calculadoraGridConstraints.ipady = 40;
        //pane.add(menu, calculadoraGridConstraints);

        //display
        calculadoraGridConstraints.gridx = 0;
        calculadoraGridConstraints.gridy = 0;
        calculadoraGridConstraints.gridwidth = 10;
        pane.add(display, calculadoraGridConstraints);

        // primer bloque de botones
        calculadoraGridConstraints.gridwidth = 1;
        calculadoraGridConstraints.gridx = 0;
        calculadoraGridConstraints.gridy = 1;
        pane.add(button1sobreX, calculadoraGridConstraints);
        button1sobreX.setBackground(Color.darkGray);

        calculadoraGridConstraints.gridx = 6;
        calculadoraGridConstraints.gridy = 1;
        calculadoraGridConstraints.gridwidth = 2;
        pane.add(buttonClear, calculadoraGridConstraints);
        buttonClear.setBackground(Color.darkGray);

        calculadoraGridConstraints.gridwidth = 1;
        calculadoraGridConstraints.gridx = 8;
        calculadoraGridConstraints.gridy = 1;
        pane.add(buttonPorcentaje, calculadoraGridConstraints);
        buttonPorcentaje.setBackground(Color.darkGray);

        calculadoraGridConstraints.gridx = 9;
        calculadoraGridConstraints.gridy = 1;
        pane.add(buttonDivision, calculadoraGridConstraints);
        buttonDivision.setBackground(Color.orange);
        buttonClear.setBackground(new Color(91, 86, 85));

        //bloque 2
        calculadoraGridConstraints.gridx = 1;
        calculadoraGridConstraints.gridy = 2;
        pane.add(buttonEquisCuadrada, calculadoraGridConstraints);
        buttonEquisCuadrada.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 2;
        calculadoraGridConstraints.gridy = 2;
        pane.add(buttonEquisCubica, calculadoraGridConstraints);
        buttonEquisCubica.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 3;
        calculadoraGridConstraints.gridy = 2;
        pane.add(buttonEquisY, calculadoraGridConstraints);
        buttonEquisY.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 4;
        calculadoraGridConstraints.gridy = 2;
        pane.add(buttonEalaX, calculadoraGridConstraints);
        buttonEalaX.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 5;
        calculadoraGridConstraints.gridy = 2;
        pane.add(button10alaX, calculadoraGridConstraints);
        button10alaX.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 6;
        calculadoraGridConstraints.gridy = 2;
        pane.add(button7, calculadoraGridConstraints);
        button7.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 7;
        calculadoraGridConstraints.gridy = 2;
        pane.add(button8, calculadoraGridConstraints);
        button8.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 8;
        calculadoraGridConstraints.gridy = 2;
        pane.add(button9, calculadoraGridConstraints);
        button9.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 9;
        calculadoraGridConstraints.gridy = 2;
        pane.add(buttonProducto, calculadoraGridConstraints);

        //bloque 3
        calculadoraGridConstraints.gridx = 0;
        calculadoraGridConstraints.gridy = 3;
        pane.add(button1sobreX, calculadoraGridConstraints);
        button1sobreX.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 1;
        calculadoraGridConstraints.gridy = 3;
        pane.add(buttonRaizCuadrada, calculadoraGridConstraints);
        buttonRaizCuadrada.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 2;
        calculadoraGridConstraints.gridy = 3;
        pane.add(buttonRaizCubica, calculadoraGridConstraints);
        buttonRaizCubica.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 3;
        calculadoraGridConstraints.gridy = 3;
        pane.add(buttonRaizdeY, calculadoraGridConstraints);
        buttonRaizdeY.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 4;
        calculadoraGridConstraints.gridy = 3;
        pane.add(buttonLogNatural, calculadoraGridConstraints);
        buttonLogNatural.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 5;
        calculadoraGridConstraints.gridy = 3;
        pane.add(buttonLogBase10, calculadoraGridConstraints);
        buttonLogBase10.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 6;
        calculadoraGridConstraints.gridy = 3;
        pane.add(button4, calculadoraGridConstraints);
        button4.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 7;
        calculadoraGridConstraints.gridy = 3;
        pane.add(button5, calculadoraGridConstraints);
        button5.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 8;
        calculadoraGridConstraints.gridy = 3;
        pane.add(button6, calculadoraGridConstraints);
        button6.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 9;
        calculadoraGridConstraints.gridy = 3;
        pane.add(buttonResta, calculadoraGridConstraints);

        //bloque 4
        calculadoraGridConstraints.gridx = 0;
        calculadoraGridConstraints.gridy = 4;
        pane.add(buttonFactorial, calculadoraGridConstraints);
        buttonFactorial.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 1;
        calculadoraGridConstraints.gridy = 4;
        pane.add(buttonSeno, calculadoraGridConstraints);
        buttonSeno.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 2;
        calculadoraGridConstraints.gridy = 4;
        pane.add(buttonCoseno, calculadoraGridConstraints);
        buttonCoseno.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 3;
        calculadoraGridConstraints.gridy = 4;
        pane.add(buttonTangente, calculadoraGridConstraints);
        buttonTangente.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 4;
        calculadoraGridConstraints.gridy = 4;
        pane.add(buttonE, calculadoraGridConstraints);
        buttonE.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 6;
        calculadoraGridConstraints.gridy = 4;
        pane.add(button1, calculadoraGridConstraints);
        button1.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 7;
        calculadoraGridConstraints.gridy = 4;
        pane.add(button2, calculadoraGridConstraints);
        button2.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 8;
        calculadoraGridConstraints.gridy = 4;
        pane.add(button3, calculadoraGridConstraints);
        button3.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 9;
        calculadoraGridConstraints.gridy = 4;
        pane.add(buttonSuma, calculadoraGridConstraints);

        //bloque 5
        calculadoraGridConstraints.gridx = 4;
        calculadoraGridConstraints.gridy = 5;
        pane.add(buttonPi, calculadoraGridConstraints);
        buttonPi.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 6;
        calculadoraGridConstraints.gridy = 5;
        calculadoraGridConstraints.gridwidth = 2;
        pane.add(button0, calculadoraGridConstraints);
        button0.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 8;
        calculadoraGridConstraints.gridy = 5;
        calculadoraGridConstraints.gridwidth = 1;
        pane.add(buttonPunto, calculadoraGridConstraints);
        buttonPunto.setBackground(new Color(91, 86, 85));

        calculadoraGridConstraints.gridx = 9;
        calculadoraGridConstraints.gridy = 5;
        pane.add(buttonIgual, calculadoraGridConstraints);
    }

    @Override
    protected void capturarOperador(int operator) {
        setOperador(operator);
    }
}
