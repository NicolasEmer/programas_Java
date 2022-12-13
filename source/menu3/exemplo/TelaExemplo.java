/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.source.menu3.exemplo;

import br.univates.source.menu3.Menu;
import br.univates.source.menu3.MenuModel;


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
        MenuModel model = new ModelDoMeuMenu();
        
        Menu m = new Menu(model);
        m.gerar();
    }
}
