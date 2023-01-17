/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.source.menu4.exemplo;

import br.univates.source.menu4.Menu;
import br.univates.source.menu4.MenuItem;
import br.univates.source.menu4.MenuProcesso;

/**
 *
 * @author mouriac
 */
public class Tela
{
    //
    //
    //
    //
    //
    //

    public void exibir()
    {
        Processo01 p1 = new Processo01();
        Processo02 p2 = new Processo02();

        Menu m = new Menu();

        m.adicionarMenuItem(new MenuItem('a', "Teste 01", p1));
        m.adicionarMenuItem(new MenuItem('b', "Teste 02", p2));
        m.adicionarMenuItem(new MenuItem('c', "Teste 03", new Processo03() ));
        m.adicionarMenuItem(new MenuItem('d', "Teste 04", p2));
        m.adicionarMenuItem(new MenuItem('e', "Teste 05", p1));

        m.gerar();
    }

    private class Processo01 implements MenuProcesso
    {

        @Override
        public void executar()
        {
            System.out.println("O processo 01 foi executado");
        }

    }

    private class Processo02 implements MenuProcesso
    {

        @Override
        public void executar()
        {
            System.out.println("lkjsdalkfdjsakl");
        }

    }
    
    private class Processo03 implements MenuProcesso
    {

        @Override
        public void executar()
        {
            System.out.println("sdflkjhasdflksdafjlkçasfdjk");
        }

    }
}
