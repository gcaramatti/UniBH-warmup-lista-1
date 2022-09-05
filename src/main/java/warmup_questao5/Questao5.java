/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warmup_questao5;

import java.util.Scanner;

/**
 *
 * @author Filipe Morais
 */
public class Questao5 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        
        int[] numerosEscritaUnica = new int[5];
        boolean[] numeros = new boolean[5];
        
        int numeroAtual = 0;
        
        while(true) {
            System.out.println("Insira um valor para o " + (numeroAtual + 1) + "º número: ");
            int numeroInserido = input.nextInt();
            
            if (numeros[numeroAtual] != true) {
                numerosEscritaUnica[numeroAtual] = numeroInserido;
                numeros[numeroAtual] = true;
            }
            
            System.out.println("O valor atual do " + (numeroAtual + 1) + "º número é " + numerosEscritaUnica[numeroAtual] + ".");

            if (numeroAtual < 4)
                numeroAtual++;
            else
                numeroAtual = 0;
        }
    }
}
