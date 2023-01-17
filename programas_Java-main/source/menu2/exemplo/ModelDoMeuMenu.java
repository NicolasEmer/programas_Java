/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.source.menu2.exemplo;

import br.univates.source.menu2.MenuModel;

/**
 *
 * @author mouriac
 */
public class ModelDoMeuMenu extends MenuModel
{
  
    public char[] getAtalhos()
    {
        char[] x = { '1', '2' };
        return x;
    }
    
    public String[] getDescricoes()
    {
        String[] d = { "op1" , "op2" };
        return d;
    }
    
    public void executarProcesso( char op )
    {
        System.out.println("oioioioio");
        
    }
}
