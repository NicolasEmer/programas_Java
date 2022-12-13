/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.negocio;

/**
 *
 * @author nicolas.emer
 */
public class Assinatura {
    private Integer pk;
    private String nome;
    private String qualidade;
    private int qtdMaxDispositivos;
    private double preco;

    public Assinatura(Integer pk, String nome, String qualidade, int qtdMaxDispositivos, double preco) {
        this.pk = pk;
        this.nome = nome;
        this.qualidade = qualidade;
        this.qtdMaxDispositivos = qtdMaxDispositivos;
        this.preco = preco;
    }
    
    public Assinatura() {
        this.pk = 0;
        this.nome = "";
        this.qualidade = "";
        this.qtdMaxDispositivos = 0;
        this.preco = 0;
    }
    

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        if (pk>0){
            this.pk = pk;
        } else {
            System.out.println("ID menor ou igual a 0.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    public int getQtdMaxDispositivos() {
        return qtdMaxDispositivos;
    }

    public void setQtdMaxDispositivos(int qtdMaxDispositivos) {
        if (qtdMaxDispositivos<100){
            this.qtdMaxDispositivos = qtdMaxDispositivos;
        } else {
            System.out.println("A quantidade máxima de dispositivos simultâneos é 99.");
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    @Override
    public boolean equals(Object as){
        Assinatura x=(Assinatura) as;
        return (this.pk==x.getPk());
    }
    
    @Override
    public String toString()
    {
        return (this.nome);
    }
    
}
