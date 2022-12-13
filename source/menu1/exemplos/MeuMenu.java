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
public class MeuMenu extends Menu
{
    // definir os atributos específicos
    // definir os atributos específicos
    // definir os atributos específicos

    public MeuMenu(char[] atalhos, String[] descricoes) // incluir atributos específicos
    {
        super(atalhos, descricoes);
        // definir os atributos específicos
        // definir os atributos específicos
        // definir os atributos específicos
    }

    @Override
    public void executarProcesso(char op)
    {
        System.out.println("Opção do meu menu");
    }
    
    
    
}
