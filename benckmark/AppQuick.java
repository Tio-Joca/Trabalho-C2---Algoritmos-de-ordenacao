package benckmark;

import java.lang.Math;
import java.util.Scanner;

public class AppQuick {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        int opcao;
        do {
            System.out.println("Digite 1 para 100, 2 para 1000, 3 para 10000, 4 para 100000, 5 para 1000000 ou digite 0 para sair: ");
            opcao = Math.abs(entrada.nextInt());

            if (opcao > 5)  {
                System.out.println("Opcao invalida.");
            }   else if (opcao >= 1)  {
                processar(opcao);
            }
        }   while (opcao != 0);
    }
    public static void processar (int opcao)  {
        int vet [];

        if (opcao == 1) {
            vet = new int[100];
        }   else if (opcao == 2) {
            vet = new int[1000];
        }   else if (opcao == 3) {
            vet = new int[10000];
        }   else if (opcao == 4) {
            vet = new int[100000];
        }   else    {
            vet = new int[1000000];
        }

        long start;
        long finish;

        preencherCrescente(vet);
        start = System.currentTimeMillis();
        quickSort(vet, 0, vet.length - 1);
        finish = System.currentTimeMillis() - start;
        System.out.println("Crescente finalizado em " + finish);
        preencherAleatorio(vet);
        start = System.currentTimeMillis();
        quickSort(vet, 0, vet.length - 1);
        finish = System.currentTimeMillis() - start;
        System.out.println("\nAleatorio finalizado em " + finish);
        preencherDecrescente(vet);
        start = System.currentTimeMillis();
        quickSort(vet, 0, vet.length - 1);
        finish = System.currentTimeMillis() - start;
        System.out.println("\nDecrescente finalizado em " + finish);
    }
    public static void quickSort(int vet [], int pontaEsquerda, int pontaDireita) {
        int pilha [] = new int[pontaDireita - pontaEsquerda + 1];
        int top = -1;
        pilha[++top] = pontaEsquerda;
        pilha[++top] = pontaDireita;

        while (top >= 0) {
            pontaDireita = pilha[top--];
            pontaEsquerda = pilha[top--];
            int referencial = partition(vet, pontaEsquerda, pontaDireita);

            if (referencial - 1 > pontaEsquerda) {
                pilha[++top] = pontaEsquerda;
                pilha[++top] = referencial - 1;
            }
            if (referencial + 1 < pontaDireita) {
                pilha[++top] = referencial + 1;
                pilha[++top] = pontaDireita;
            }
        }
    }
    private static int partition(int vet [], int pontaEsquerda, int pontaDireita) {
        int ultimo = vet [pontaDireita];
        int x = (pontaEsquerda - 1);

        for (int y = pontaEsquerda; y <= pontaDireita - 1; y++) {
            if (vet [y] < ultimo) {
                x++;
                swap(vet, x, y);
            }
        }
        swap(vet, x + 1, pontaDireita);
        return (x + 1);
    }
    private static void swap(int vet [], int x, int y)
    {
        int temp = vet[x];
        vet[x] = vet[y];
        vet[y] = temp;
    }
    public static void preencherCrescente (int vet [])  {
        for (int x = 0; x < vet.length; x++)    {
            vet[x] = x + 1;
        }
    }
    public static void preencherAleatorio (int vet [])  {
        for (int x = 0; x < vet.length; x++)    {
            vet[x] = (int) (Math.random() * vet.length) + 1;
        }
    }
    public static void preencherDecrescente (int vet [])    {
        int tamanho = vet.length;
        for (int x = 0; x < vet.length; x++)    {
            vet[x] = tamanho--;
        }
    }
}
