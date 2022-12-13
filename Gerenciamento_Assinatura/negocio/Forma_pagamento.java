/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author nicol
 */
public class Forma_pagamento {
    Integer pk;
    String tipo;
    String num_cartao;

    public Forma_pagamento(Integer pk, String tipo, String num_cartao) {
        this.pk = pk;
        this.tipo = tipo;
        this.num_cartao = num_cartao;
    }

    public Forma_pagamento() {
        this.pk = null;
        this.tipo = null;
        this.num_cartao = null;
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if(tipo!="Boleto" && tipo!="Cartão"){
            System.out.println("Só são aceitos os tipos de pagamento: Cartão ou Boleto.");
        }else{
            this.tipo = tipo;
        }
    }

    public String getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(String num_cartao) {
        if (num_cartao==null || num_cartao.equals("")){
            this.num_cartao = null;
        }else{
            int x = Integer.parseInt(num_cartao);
            this.num_cartao = Integer.toString(x);
        }
    }
    
    @Override
    public String toString()
    {
        return Integer.toString(this.pk);
    }
}
