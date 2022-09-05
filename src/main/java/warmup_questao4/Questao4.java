/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warmup_questao4;

import java.util.Scanner;

/**
 *
 * @author Gabriel Caramatti
 */
public class Questao4 {
    public static void main(String[] args) {
        System.out.println("Roubo Banco HSVC");
        
        var valoresSuspeitos = obtemValoresSuspeitos();
        var valorAssaltanteConfesso = obtemValorAssaltanteConfessado();
                
        var assaltantes = avaliarSuspeitos(valoresSuspeitos, valorAssaltanteConfesso);
        int valorTotalRoubado = 0;
        
        for(int i=0; i<assaltantes.length; i++) {
            int indiceAssaltante = assaltantes[i];
            
            System.out.println("O suspeito de nº " + (indiceAssaltante + 1) + " é um dos assaltantes.");
            
            valorTotalRoubado += valoresSuspeitos[indiceAssaltante];
        }
        
        System.out.println();
        System.out.print("Os assaltantes roubaram R$" + valorTotalRoubado + ",00.");
    }
    
    private static int[] obtemValoresSuspeitos() {
        final Scanner input = new Scanner(System.in);
        
        var valores = new int[10];
        int suspeitosContabilizados = 0;
        
        while(suspeitosContabilizados < 10) {
            int suspeitoNumero = suspeitosContabilizados + 1;
            
            System.out.print("Insira o valor contido pelo suspeito nº " + suspeitoNumero + ": ");
            int valorContido = input.nextInt();
            
            if (valorContido < 0) {
                System.out.println();
                System.out.print("Favor inserir um valor válido. Tente novamente.");
                continue;
            }
            
            valores[suspeitosContabilizados] = valorContido;
            suspeitosContabilizados++;
            
            System.out.println("O suspeito de nº " + suspeitosContabilizados + " continha R$" + valorContido + ",00.");
        }
        
        return valores;
    }
    
    private static int obtemValorAssaltanteConfessado() {
        System.out.println();
        
        final Scanner input = new Scanner(System.in);
        int valorConfessado = 0;
        
        while(valorConfessado == 0) {
            System.out.print("Insira o valor que o assaltante confessou: ");
            int valorContido = input.nextInt();
            
            System.out.println();
            valorConfessado = valorContido;
        }
        
        return valorConfessado;
    }    
    
    private static int[] avaliarSuspeitos(int[] valoresSuspeitos, int valorAssaltanteConfesso) {
        var suspeitosAssaltantes = new int[0];
        
        for(int i=0; i<valoresSuspeitos.length; i++) {
            int valorContido = valoresSuspeitos[i];
            
            if (valorContido % 10 != 0 || valorContido < valorAssaltanteConfesso)
                continue;

            suspeitosAssaltantes = adicionarAssaltante(suspeitosAssaltantes, i);
        }
        
        return suspeitosAssaltantes;
    }
    
    private static int[] adicionarAssaltante(int[] indicesAssaltantes, int indiceNovoAssaltante) {
        int novoTamanhoArray = indicesAssaltantes.length + 1;
        var novoIndexAssaltante = new int[novoTamanhoArray];
        
        for(int i=0; i<indicesAssaltantes.length; i++)
            novoIndexAssaltante[i] = indicesAssaltantes[i];

        novoIndexAssaltante[novoTamanhoArray - 1] = indiceNovoAssaltante;
        
        return novoIndexAssaltante;
    }
}
