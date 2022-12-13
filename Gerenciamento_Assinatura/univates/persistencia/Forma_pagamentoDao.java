/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.persistencia;

import br.univates.negocio.Forma_pagamento;
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
public class Forma_pagamentoDao extends DaoAdapter<Forma_pagamento,Integer>{
    
    @Override
    public void create(Forma_pagamento as) throws InvalidKeyException, KeyViolationException {
        if (as.getPk()!=null){
            try{
                String sql = "insert into forma_pagamento values (?, ?, ?);";
                SystemManager.getInstance().getDataBase().runPreparedSQL(sql,as.getPk(),as.getTipo(),as.getNum_cartao());
            }catch(DataBaseException ex){
                throw new KeyViolationException();
            }
        }else{
            throw new InvalidKeyException();
        }
    }
    

    @Override
    public Forma_pagamento read(Integer primaryKey) throws NotFoundException {
        Forma_pagamento as=null;
        ArrayList<Forma_pagamento> array=this.readAll();
        for (Forma_pagamento forma_pagamento : array) {
            if (forma_pagamento.getPk().equals(primaryKey)){
                as=forma_pagamento;
                break;
            }
        }
        
        if (as==null){
            throw new NotFoundException();
        }
        return as;
    }

    @Override
    public ArrayList<Forma_pagamento> readAll() {
        ArrayList<Forma_pagamento> lista = new ArrayList();
        
        try
        {
            ResultSet rs = br.univates.persistencia.SystemManager.getInstance().getDataBase().runQuerySQL("select * from forma_pagamento;");
            
            if (rs.isBeforeFirst())
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    Integer pk = rs.getInt("idforma_pagamento");
                    String tipo = rs.getString("tipo");
                    String numero_cartao = rs.getString("numero_cartao");
                    
                    Forma_pagamento e = new Forma_pagamento(pk,tipo,numero_cartao);
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
        }
        
        return lista;
    }
    
    @Override
    public ArrayList<Forma_pagamento> readAll(Filter<Forma_pagamento> filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Forma_pagamento as) {
        
        try {
            String sql = "UPDATE forma_pagamento SET tipo = ?, numero_cartao= ? WHERE idforma_pagamento = ? ;";
            SystemManager.getInstance().getDataBase().runPreparedSQL(sql,as.getTipo(),as.getNum_cartao(),as.getPk());
        } catch (DataBaseException ex) {
            Logger.getLogger(Forma_pagamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(Integer primaryKey) throws NotFoundException {
        try {
            String sql = "DELETE FROM forma_pagamento WHERE idforma_pagamento = ? ;";
            SystemManager.getInstance().getDataBase().runPreparedSQL(sql, primaryKey);
        } catch (DataBaseException ex) {
            Logger.getLogger(Forma_pagamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
