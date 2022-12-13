/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

import br.univates.source.NomePessoa;
import java.io.IOException;

/**
 *
 * @author nicol
 */
public class Cliente {
    String cpf;
    String nome;
    String email;
    String ass_atv;
    String telefone;
    Forma_pagamento forma_pag;
    Endereco endereco;
    Assinatura assinatura;

    public Cliente(String cpf, String nome, String email, String ass_atv, String telefone, Forma_pagamento forma_pag, Endereco endereco, Assinatura assinatura) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.ass_atv = ass_atv;
        this.telefone = telefone;
        this.forma_pag = forma_pag;
        this.endereco = endereco;
        this.assinatura = assinatura;
    }
    
    public Cliente() {
        this.cpf = null;
        this.nome = null;
        this.email = null;
        this.ass_atv = null;
        this.telefone = null;
        this.forma_pag = null;
        this.endereco = null;
        this.assinatura = null;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws IOException {
        if (this.verify_CPF(cpf)){
            this.cpf = cpf;
        }
    }
    
    public boolean verify_CPF(String cpf) throws IOException{
        boolean res=false;
        char[] cpfc = new char[11];
        if (cpf.length()==11){
            cpfc=cpf.toCharArray();
            int x1=Character.getNumericValue(cpfc[0])*1; //calculo para certificar cpf encontrado em:
            x1+=Character.getNumericValue(cpfc[1])*2; //https://www.cadcobol.com.br/calcula_cpf_cnpj_caepf.htm
            x1+=Character.getNumericValue(cpfc[2])*3;
            x1+=Character.getNumericValue(cpfc[3])*4;
            x1+=Character.getNumericValue(cpfc[4])*5;
            x1+=Character.getNumericValue(cpfc[5])*6;
            x1+=Character.getNumericValue(cpfc[6])*7;
            x1+=Character.getNumericValue(cpfc[7])*8;
            x1+=Character.getNumericValue(cpfc[8])*9;
            int resto1 = x1%11;
            
            
            int x2=Character.getNumericValue(cpfc[0])*0;
            x2+=Character.getNumericValue(cpfc[1])*1;
            x2+=Character.getNumericValue(cpfc[2])*2;
            x2+=Character.getNumericValue(cpfc[3])*3;
            x2+=Character.getNumericValue(cpfc[4])*4;
            x2+=Character.getNumericValue(cpfc[5])*5;
            x2+=Character.getNumericValue(cpfc[6])*6;
            x2+=Character.getNumericValue(cpfc[7])*7;
            x2+=Character.getNumericValue(cpfc[8])*8;
            x2+=resto1*9;
            
            int resto2 = x2%11;

            
            if (resto1==Character.getNumericValue(cpfc[9]) && resto2==Character.getNumericValue(cpfc[10])){
                res=true;
            }
        } else {
            throw new IOException("CPF não tem 11 números.");
        }
        return res;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        
        NomePessoa x =new NomePessoa(nome);
        this.nome = x.getNomeFormatado(0);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAss_atv() {
        return ass_atv;
    }

    public void setAss_atv(String ass_atv) throws IOException {
        if ("sim".equals(ass_atv) || "não".equals(ass_atv)){
            this.ass_atv = ass_atv;
        }else{
            throw new IOException("Assinatura ativa só aceita os valores 'sim' ou 'não'.");
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
      
        int x = Integer.parseInt(telefone);
        this.telefone=Integer.toString(x);
       
    }

    public Forma_pagamento getForma_pag() {
        return forma_pag;
    }

    public void setForma_pag(Forma_pagamento forma_pag) {
        this.forma_pag = forma_pag;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
    }
    
}
