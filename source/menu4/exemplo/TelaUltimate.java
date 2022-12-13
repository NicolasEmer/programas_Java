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
public class TelaUltimate
{
    //
    //
    //
    //
    //
    //

    public void exibir()
    {
        Menu m = new Menu();
        
        m.adicionarMenuItem(new MenuItem('a', "Teste 01", new MenuProcesso() {
            @Override
            public void executar()
            {
                System.out.println("O processo 01 foi executado");
            }
        }));
        
        m.adicionarMenuItem(new MenuItem('b', "Teste 02", new MenuProcesso() {
            @Override
            public void executar()
            {
                System.out.println("O processo 02 foi executado");
            }
        } ));
        
        m.adicionarMenuItem(new MenuItem('c', "Teste 03", new MenuProcesso() {
            @Override
            public void executar()
            {
                System.out.println("O processo 03 foi executado");
            }
        } ));
        
        m.adicionarMenuItem(new MenuItem('d', "Teste 04", new MenuProcesso()
        {
            
            @Override
            public void executar()
            {
                System.out.println("O processo 04 foi executado");
            }
            
        }));
        
        m.gerar();
    }
    
    
}
