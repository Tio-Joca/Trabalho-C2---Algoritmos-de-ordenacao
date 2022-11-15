package benckmark;

import java.lang.Math;
import java.util.Scanner;

public class AppMerge {
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
        MergeSort(vet, 0, vet.length - 1);
        finish = System.currentTimeMillis() - start;
        System.out.println("Crescente finalizado em " + finish);
        preencherAleatorio(vet);
        start = System.currentTimeMillis();
        MergeSort(vet, 0, vet.length - 1);
        finish = System.currentTimeMillis() - start;
        System.out.println("\nAleatorio finalizado em " + finish);
        preencherDecrescente(vet);
        start = System.currentTimeMillis();
        MergeSort(vet, 0, vet.length - 1);
        finish = System.currentTimeMillis() - start;
        System.out.println("\nDecrescente finalizado em " + finish);
    }
    private static void MergeSort (int vet [], int pontaEsquerda, int pontaDireita)    {
        if (pontaEsquerda < pontaDireita)   {
            int meio = (pontaEsquerda + pontaDireita) / 2;

            MergeSort(vet, pontaEsquerda, meio);
            MergeSort(vet, meio + 1, pontaDireita);

            merge(vet, pontaEsquerda, meio, pontaDireita);
        }
    }
    private static void merge (int vet [], int pontaEsquerda, int meio, int pontaDireita)    {
        int tamanhoVet1 = meio - pontaEsquerda + 1;
        int tamanhoVet2 = pontaDireita - meio;

        int vetTemp1 [] = new int[tamanhoVet1];
        int vetTemp2 [] = new int[tamanhoVet2];

        for (int x = 0; x < tamanhoVet1; x++)   {
            vetTemp1[x] = vet[pontaEsquerda + x];
        }
        for (int y = 0; y < tamanhoVet2; y++)   {
            vetTemp2[y] = vet[meio + 1 + y];
        }

        int i, j, k;
        i = 0;
        j = 0;
        k = pontaEsquerda;

        while (i < tamanhoVet1 && j < tamanhoVet2)  {
            if (vetTemp1[i] <= vetTemp2[j]) {
                vet[k] = vetTemp1[i];
                i++;
            } else {
                vet[k] = vetTemp2[j];
                j++;
            }
            k++;
        }
        while (i < tamanhoVet1) {
            vet[k] = vetTemp1[i];
            i++;
            k++;
        }
        while (j < tamanhoVet2) {
            vet[k] = vetTemp2[j];
            j++;
            k++;
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
