package br.univates.source.persistence.exemplo2;

import br.univates.source.persistence.exemplo1.*;

public class Funcionario 
{
    private int codigo;
    private String nome;
    private String cidade;

    public Funcionario(int codigo, String nome, String cidade)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getCidade()
    {
        return cidade;
    }

    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    
}
