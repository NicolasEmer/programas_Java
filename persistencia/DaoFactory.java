/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.persistencia;

import br.univates.negocio.Assinatura;
import br.univates.negocio.Cliente;
import br.univates.negocio.Endereco;
import br.univates.negocio.Estado;
import br.univates.negocio.Forma_pagamento;
import br.univates.source.persistence.IDao;


/**
 *
 * @author nicolas.emer
 */
public class DaoFactory {
    
    public static IDao<Assinatura,Integer> createAssinaturaDao(){
        return new AssinaturaDao();
    }
    
    public static IDao<Estado,Integer> createEstadoDao(){
        return new EstadoDao();
    }
    
    public static IDao<Endereco,Integer> createEnderecoDao(){
        return new EnderecoDao();
    }
    
    public static IDao<Forma_pagamento,Integer> createForma_pagamentoDao(){
        return new Forma_pagamentoDao();
    }
    
    public static IDao<Cliente,String> createClienteDao(){
        return new ClienteDao();
    }
}
