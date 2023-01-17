/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.source.persistence.exemplo2;

import br.univates.source.persistence.KeyViolationException;
import br.univates.source.persistence.InvalidKeyException;
import br.univates.source.persistence.DaoAdapter;
import br.univates.source.persistence.Filter;
import java.util.ArrayList;

/**
 *
 * @author mouriac
 */
public class FuncionarioDao extends DaoAdapter<Funcionario,Integer>
{

    @Override
    public void create(Funcionario objeto) throws KeyViolationException,InvalidKeyException
    {
        if (objeto.getCodigo() == 1)
        {
            throw new KeyViolationException();
        }
        if (objeto.getCodigo() <= 0)
        {
            throw new InvalidKeyException();
        }
    }

    @Override
    public Funcionario read(Integer primaryKey)
    {
        return null;
    }

    @Override
    public ArrayList<Funcionario> readAll()
    {
        ArrayList<Funcionario> lista = new ArrayList();
        lista.add( new Funcionario(1,"João","Lajeado"));
        lista.add( new Funcionario(2,"Paulo","Lajeado"));
        lista.add( new Funcionario(3,"Juca","Estrela"));
        lista.add( new Funcionario(4,"Maria","Lajeado"));
        lista.add( new Funcionario(5,"Carla","Estrela"));
        lista.add( new Funcionario(6,"Lucas","Lajeado"));
        lista.add( new Funcionario(7,"Eva","Lajeado"));
        return lista;
    }

    @Override
    public void update(Funcionario objeto)
    {
        
    }

    @Override
    public void delete(Integer primaryKey)
    {
        
    }

    
}
