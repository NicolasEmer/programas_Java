/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.source.persistence.exemplo1;

import java.util.ArrayList;

/**
 *
 * @author mouriac
 */
public class Teste
{
    public static void main(String[] args)
    {
        FiltroPorCidade filtro = new FiltroPorCidade("Estrela");
        
        FuncionarioDao dao = new FuncionarioDao();
        
        ArrayList<Funcionario> funcTotal = dao.readAll();
        ArrayList<Funcionario> funcDeLajeado = dao.readAll(filtro);
        Funcionario func3 = dao.read(3);
        
        for (Funcionario f: funcDeLajeado)
        {
            System.out.println(f.getNome());
        }
    }
}
