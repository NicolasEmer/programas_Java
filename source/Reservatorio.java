package br.univates.source;

public class Reservatorio
{
    private double nivel;
    private double capacidade;

    public Reservatorio(double capacidade)
    {
        this.nivel = 0;
        this.capacidade = capacidade;
    }
    
    public double getNivel()
    {
        return nivel;
    }

    public double getCapacidade()
    {
        return capacidade;
    }

    public void adicionarConteudo(double conteudoAdicionar)
    {
        if (conteudoAdicionar > 0 && this.nivel + conteudoAdicionar <= this.capacidade)
        {
            this.nivel += conteudoAdicionar;
        }
        else
        {
            throw new RuntimeException("Resevatório transbordou");
        }
    }

    public void subtrairConteudo(double conteudoRetirar)
    {
        if (conteudoRetirar > 0 && this.nivel - conteudoRetirar >= 0)
        {
            this.nivel -= conteudoRetirar;
        }
        else
        {
            throw new RuntimeException("Não há conteúdo suficiente");
        }
    }

    
}
