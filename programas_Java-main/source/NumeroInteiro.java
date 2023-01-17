package br.univates.source;

public class NumeroInteiro 
{
    private int valor;

    public NumeroInteiro(int valor)
    {
        this.valor = valor;
    }
        
    public int contarDivisores()
    {
        int conta = 0 ;
        for (int i = 1; i <= valor; i++)
        {
            if (valor % i == 0)
            {
                conta++;
            }
        }
        return conta;
    }
    
    public boolean ehPrimo()
    {
        return Util.ehPrimo(valor);
    }
    
    public boolean ehPrimoRelativoDe(NumeroInteiro outroNumeroInteiro)
    {
        int conta = 0;
        int menor = Math.min(this.valor,outroNumeroInteiro.valor);
        for (int i = 2; i <= menor; i++)
        {
            if (this.valor%i == 0 && outroNumeroInteiro.valor%i==0)
            {
                conta++;
            }
        }
        return (conta==0);
    }
    
}
