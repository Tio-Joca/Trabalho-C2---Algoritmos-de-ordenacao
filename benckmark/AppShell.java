package benckmark;

import java.lang.Math;
import java.util.Scanner;

public class AppShell {
    public static void main(String[] args)  {
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
        shellSort(vet, vet.length);
        finish = System.currentTimeMillis() - start;
        System.out.println("Crescente finalizado em " + finish);
        preencherAleatorio(vet);
        start = System.currentTimeMillis();
        shellSort(vet, vet.length);
        finish = System.currentTimeMillis() - start;
        System.out.println("\nAleatorio finalizado em " + finish);
        preencherDecrescente(vet);
        start = System.currentTimeMillis();
        shellSort(vet, vet.length);
        finish = System.currentTimeMillis() - start;
        System.out.println("\nDecrescente finalizado em " + finish);
    }
    public static void shellSort (int vet [], int n) {
        for (int meio = n / 2; meio > 0; meio /= 2) {
            for (int x = meio; x < n; x += 1) {
                int temp = vet[x];
                int y;
                for (y = x; y >= meio && vet[y - meio] > temp; y -= meio) {
                    vet[y] = vet[y - meio];
                }
                vet[y] = temp;
            }
        }
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
