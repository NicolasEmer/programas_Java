/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author nicol
 */
public class Endereco {
    Integer pk;
    String Rua;
    String Bairro;
    int numero;
    String cidade;
    Estado estado;

    public Endereco(Integer pk, String Rua, String Bairro, int numero, String cidade, Estado estado) {
        this.pk = pk;
        this.Rua = Rua;
        this.Bairro = Bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco() {
        this.pk = null;
        this.Rua = null;
        this.Bairro = null;
        this.numero = 0;
        this.cidade = null;
        this.estado = null;
    }
    
    public String getTodasInformacoes(){
        String x=estado.getSigla()+", "+cidade+" "+Bairro+" "+Rua+" "+numero;
        return x;
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString()
    {
        return Integer.toString(this.pk);
    }
    
}
