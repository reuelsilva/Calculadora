/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author reuel
 */

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
        
public class Calculadora extends JFrame{
    private Container container;
    private JTextArea txtDisplay;
    private JPanel painelDeDisplay, painelDeBotoes;
    private JButton botoes[] = new JButton[16];
    private String nomes[] = {"7", "8", "9", "+", 
        "4", "5", "6", "-", 
        "1", "2", "3", "x",
        "0", "backspace", "=", "/"};
    private Color cor01 = new Color(110, 110, 110);
    private Color cor02 = new Color(230, 230, 230);
    private Color cor03 = new Color(185, 185, 185);
    private Color cor04 = new Color(205, 205, 205);
    private Color cor05 = new Color(180, 190, 201);
    private Icon backspaceIcon, equalIcon;
    private int valor1, valor2;
    private String operador;
    
    public Calculadora(){
        super("Calculadora");
        container = getContentPane();
        container.setLayout(new BorderLayout());
        painelDeDisplay = new JPanel(new BorderLayout());
        painelDeDisplay.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        painelDeDisplay.setBackground(cor01);
        container.add(painelDeDisplay, BorderLayout.NORTH);
        txtDisplay = new JTextArea(1, 12);
        txtDisplay.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        txtDisplay.setBackground(cor02);
        txtDisplay.setFont(new Font("SansSerif", Font.PLAIN, 35));
        txtDisplay.setLineWrap(true);
        txtDisplay.setEditable(false);
        painelDeDisplay.add(txtDisplay, BorderLayout.CENTER);
        painelDeBotoes = new JPanel(new GridLayout(4, 4, 5, 5));
        painelDeBotoes.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 15));
        painelDeBotoes.setBackground(cor03);
        backspaceIcon = new ImageIcon("figuras/backspace-figura.png");
        equalIcon = new ImageIcon("figuras/equal-sign.png");
        container.add(painelDeBotoes, BorderLayout.CENTER);
        
        for(int pos=0; pos<botoes.length;pos++){
            switch (pos) {
                case 3:
                    botoes[pos] = new JButton(nomes[pos]);
                    botoes[pos].setBackground(cor05);
                    break;
                case 7:
                    botoes[pos] = new JButton(nomes[pos]);
                    botoes[pos].setBackground(cor05);
                    break; 
                case 11:
                    botoes[pos] = new JButton(nomes[pos]);
                    botoes[pos].setBackground(cor05);
                    break;
                case 13:
                    botoes[pos] = new JButton(backspaceIcon);
                    botoes[pos].setBackground(cor04);
                    break;
                case 14:
                    botoes[pos] = new JButton(equalIcon);
                    botoes[pos].setBackground(cor04);
                    break;
                case 15:
                    botoes[pos] = new JButton(nomes[pos]);
                    botoes[pos].setBackground(cor05);
                    break;
                default:
                    botoes[pos] = new JButton(nomes[pos]);
                    botoes[pos].setBackground(cor04);
            }
        }
        
        for(int count=0; count<botoes.length; count++){
            botoes[count].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for(int count=0; count<botoes.length; count++){
                        if(botoes[count] == e.getSource()){
                            try {
                                txtDisplay.setText(txtDisplay.getText() + Integer.parseInt(nomes[count]));
                            } 
                            catch (NumberFormatException ev) {
                                
                                switch(nomes[count]){
                                    case "+":
                                        valor1 = Integer.parseInt(txtDisplay.getText());
                                        operador = "+";
                                        txtDisplay.setText("");
                                        break;
                                    case "-":
                                        valor1 = Integer.parseInt(txtDisplay.getText());
                                        operador = "-";
                                        txtDisplay.setText("");
                                        break;
                                    case "x":
                                        valor1 = Integer.parseInt(txtDisplay.getText());
                                        operador = "x";
                                        txtDisplay.setText("");
                                        break;
                                    case "backspace":
                                        txtDisplay.setText(txtDisplay.getText().substring(0, txtDisplay.getText().length() - 1));
                                        break;  
                                    case "/":
                                        valor1 = Integer.parseInt(txtDisplay.getText());
                                        operador = "/";
                                        txtDisplay.setText("");
                                        break;
                                    case "=":
                                        valor2 = Integer.parseInt(txtDisplay.getText());
                                        if(operador == "+"){
                                            txtDisplay.setText(String.valueOf(valor1 + valor2));
                                            break;
                                        }
                                        if(operador == "-"){
                                            txtDisplay.setText(String.valueOf(valor1 - valor2));
                                            break;
                                        }   
                                        if(operador == "x"){
                                            txtDisplay.setText(String.valueOf(valor1 * valor2));
                                            break;
                                        }
                                        if(operador == "/"){
                                            txtDisplay.setText(String.valueOf(valor1 / valor2));
                                            break;
                                        }
                                }
                                
                            }
                        }
                    }
                }
            });
        }
        
        for(int count=0; count < botoes.length; count++){
            painelDeBotoes.add(botoes[count]);
        }
        
        setSize(325, 400);
        setResizable(false);
        setVisible(true);
    } 
    
    public static void main(String[] args) {
        Calculadora aplicacao = new Calculadora();
        aplicacao.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
