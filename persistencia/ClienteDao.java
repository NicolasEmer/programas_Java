/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.persistencia;


import br.univates.negocio.Cliente;
import br.univates.source.db.DataBaseException;
import br.univates.source.persistence.DaoAdapter;
import br.univates.source.persistence.Filter;
import br.univates.source.persistence.InvalidKeyException;
import br.univates.source.persistence.KeyViolationException;
import br.univates.source.persistence.NotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class ClienteDao extends DaoAdapter<Cliente,String> {

    @Override
    public void create(Cliente as) throws InvalidKeyException, KeyViolationException {
        if (as.getCpf()!=null){
            try{
                String sql = "insert into cliente values (?, ?, ?, ?, ?, ?, ?, ?);";
                SystemManager.getInstance().getDataBase().runPreparedSQL(sql,
                        as.getCpf(),as.getNome(),as.getEmail(),as.getAss_atv(),as.getTelefone(),
                        as.getForma_pag().getPk(),as.getEndereco().getPk(),as.getAssinatura().getPk());
            }catch(DataBaseException ex){
                throw new KeyViolationException();
            }
        }else{
            throw new InvalidKeyException();
        }
    }
    

    @Override
    public Cliente read(String primaryKey) throws NotFoundException {
        Cliente as=null;
        ArrayList<Cliente> array=this.readAll();
        for (Cliente cliente : array) {
            if (cliente.getCpf().equals(primaryKey)){
                as=cliente;
                break;
            }
        }
        
        if (as==null){
            throw new NotFoundException();
        }
        return as;
    }

    @Override
    public ArrayList<Cliente> readAll() {
        ArrayList<Cliente> lista = new ArrayList();
        
        try
        {
            ResultSet rs = br.univates.persistencia.SystemManager.getInstance().getDataBase().runQuerySQL("select * from cliente;");
            
            if (rs.isBeforeFirst())
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    String cpf = rs.getString("cpf");
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    String ass_ativa = rs.getString("ass_ativa");
                    String telefone = rs.getString("telefone");
                    int forma_pagamento = rs.getInt("idforma_pagamento");
                    int endereco = rs.getInt("idendereco");
                    int assinatura = rs.getInt("idassinatura");
                    
                    Cliente e = new Cliente(cpf,nome,email,ass_ativa,telefone,
                            DaoFactory.createForma_pagamentoDao().read(forma_pagamento),DaoFactory.createEnderecoDao().read(endereco),
                            DaoFactory.createAssinaturaDao().read(assinatura));
                    lista.add(e);
                    
                    rs.next();
                }
            }
        }
        catch (DataBaseException ex)
        {
            JOptionPane.showMessageDialog(null, 
                    "Falha na conexão com o banco de dados",
                    "Conexão com erro", JOptionPane.ERROR_MESSAGE);
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, 
                    "Falha na conexão com o banco de dados",
                    "Conexão com erro", JOptionPane.ERROR_MESSAGE);
        } catch (NotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    @Override
    public ArrayList<Cliente> readAll(Filter<Cliente> filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Cliente as) {
        
        try {
            String sql = "UPDATE liente SET nome = ?, SET email = ?, SET ass_ativa =  ?,"
                    + " SET telefone = ?, SET idforma_pagamento =  ?, SET idendereco =  ?"
                    + ", SET idassinatura =  ? WHERE idcliente = ? ;";
            SystemManager.getInstance().getDataBase().runPreparedSQL(sql,as.getNome(),as.getEmail(),as.getAss_atv(),as.getTelefone(),
                        as.getForma_pag().getPk(),as.getEndereco().getPk(),as.getAssinatura().getPk(),as.getCpf());
        } catch (DataBaseException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(String primaryKey) throws NotFoundException {
        try {
            String sql = "DELETE FROM cliente WHERE cpf = ? ;";
            SystemManager.getInstance().getDataBase().runPreparedSQL(sql, primaryKey);
        } catch (DataBaseException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
