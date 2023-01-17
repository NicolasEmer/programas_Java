package br.univates.source;

public class Dado
{
    int[] contador;

    public Dado()
    {
        this.contador = new int[6];
        reinicializar();
    }
    
    public int lancarDado()
    {
        int num = (int)(Math.random()*6)+1;
        contador[num-1] ++;
        return num;
    }
    
    public double getPercentualLancamentos(int lado)
    {
        double r = 0;
        if (lado >= 1 && lado <= 6)
        {
            r = this.getNumeroLancamentos(lado);
            r /= this.getNumeroLancamentos();
            r *= 100;
        }
        return r;
    }
    
    
    public int getNumeroLancamentos(int lado)
    {
        int r = 0;
        if (lado >=1 && lado <= 6)
        {
            r = contador[lado-1];
        }
        return r;
    }
    
    public int getNumeroLancamentos()
    {
        int soma = 0;
        for (int i = 0; i < 6; i++)
        {
            soma += getNumeroLancamentos(i+1);
        }
        return soma;
    }
    
    public void reinicializar()
    {
        for (int i = 0; i < 6; i++)
        {
            contador[i] = 0;
        }
    }
    
}
