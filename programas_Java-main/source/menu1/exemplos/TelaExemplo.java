/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.source.menu1.exemplos;

import br.univates.source.menu1.Menu;

/**
 *
 * @author mouriac
 */
public class TelaExemplo
{
    //
    // atributos necessários para a tela
    //
    
    public void exibir()
    {
        String[] descricoes = { "Descrição da opção 01", "Descrição da opção 02", "Descrição da opção 03" };
        char[] atalhos = { 'a','b','c' };
        
        MeuMenu m = new MeuMenu(atalhos,descricoes);
        m.gerar();
    }
}
