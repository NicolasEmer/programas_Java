/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.source.persistence;

import br.univates.source.persistence.exemplo2.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author mouriac
 */
public abstract class DaoAdapter<T,E> implements IDao<T,E>
{

    @Override
    public ArrayList<T> readAll(Filter<T> filtro)
    {
        ArrayList<T> selecionados = new ArrayList();
        ArrayList<T> todos = readAll();
        for (T obj: todos)
        {
            if (filtro.isAccept(obj))
            {
                selecionados.add(obj);
            }
        }
        return selecionados;
    }

}
