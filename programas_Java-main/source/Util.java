package br.univates.source;

import java.util.Arrays;

public class Util
{
    public static int contarDivisores( int num )
    {
        int conta = 0 ;
        for (int i = 1; i <= num; i++)
        {
            if (num % i == 0)
            {
                conta++;
            }
        }
        return conta;
    }
    
    public static boolean ehPrimo( int num )
    {
        return (contarDivisores(num)==2);
    }
    
    public static boolean saoPrimosRelativos(int num1, int num2)
    {
        int conta = 0;
        int menor = Math.min(num1,num2);
        for (int i = 2; i <= menor; i++)
        {
            if (num1%i == 0 && num2%i==0)
            {
                conta++;
            }
        }
        return (conta==0);
    }
    
    public static double media( int[] vetor )
    {
        double media = 0;
        for (int i = 0; i < vetor.length; i++)
        {
            media += vetor[i];
        }
        media /= vetor.length; // media = media / vetor.length
        return media;
    }
    
    public static double variancia( int[] vetor )
    {
        double variancia = 0;
        double media = media( vetor );
        for (int i = 0; i < vetor.length; i++)
        {
            variancia += Math.pow( vetor[i] -  media, 2);
        }
        variancia /= vetor.length;
        return variancia;
    }
    
    public static double desvioPadrao( int[] vetor )
    {
        //double variancia = variancia( vetor );
        return Math.sqrt( variancia( vetor ) );
    }
    
    public static void ordenar( int[] vetor )
    {
        int passadas = 0;
        boolean ordenado = false;
        while (!ordenado)
        {
            ordenado = true;
            passadas ++;
            for (int i = 0; i < vetor.length - passadas; i++)
            {
                if (vetor[i] > vetor[i+1]) // trocar
                {
                    int aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    ordenado = false;
                }
            }
        }
    }
    
    public static double mediana( int[] vetor )
    {
        double mediana = 0;
        
        int[] aux = Arrays.copyOf(vetor, vetor.length);
        ordenar(aux);
        double meio = vetor.length / 2D;
        if (meio == (int)meio)
        {
            mediana = (aux[ (int)meio-1 ] + aux[ (int)meio ])/2D;
        }
        else
        {
            mediana = aux[ (int)meio ];
        }
        return mediana;
    }
    
    public static double moda( int[] vetor )
    {
        int contAnterior = 0;
        int moda = 0;
        
        for (int i = 0; i < vetor.length; i++) 
        {
            int elemento = vetor[i];
            int cont = 0;
            for (int j = 0; j < vetor.length; j++) 
            {
                if (vetor[j] == elemento)
                {
                    cont ++;
                }
            }
            if (cont > contAnterior)
            {
                moda = elemento;
                contAnterior = cont;
            }
        }
        return moda;
    }
    
}
