/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author nicol
 */
public class Estado {
    Integer pk;
    String sigla;
    String nome;

    public Estado( Integer pk, String nome, String sigla) {
        this.sigla = sigla;
        this.nome = nome;
        this.pk=pk;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        if (sigla!=null && sigla.length()==2){
            this.sigla = sigla;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome!=null){
            this.nome = nome;
        }
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }
    
    @Override
    public String toString()
    {
        return (this.sigla);
    }
}
