package io.uric.cesta;
import io.uric.cesta.gui.MainWindow;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean fakeData;
        while (true) {
            System.out.println("Deseja popular com dados temporarios? S/N");
            String popular = sc.nextLine();
            if(popular.equalsIgnoreCase("S")){
                fakeData = true;
                break;
            } else if (popular.equalsIgnoreCase("N")){
                fakeData = false;
                break;
            }
        }
        JFrame frame = new JFrame("Cesta!");
        frame.setContentPane(new MainWindow(fakeData).generalPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
