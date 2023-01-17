/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.source.persistence.exemplo2;

import br.univates.source.persistence.exemplo1.*;
import br.univates.source.persistence.Filter;

/**
 *
 * @author mouriac
 */
public class FiltroPorCidade implements Filter<Funcionario>
{
    private String cidade;

    public FiltroPorCidade(String cidade)
    {
        this.cidade = cidade;
    }
    
    @Override
    public boolean isAccept(Funcionario record)
    {
        boolean ok = false;
        if (record.getCidade().equalsIgnoreCase(cidade))
        {
            ok = true;
        }
        return ok;
    }
    
}
