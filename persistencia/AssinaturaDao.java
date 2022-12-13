/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.persistencia;

import br.univates.negocio.Assinatura;
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
 * @author nicolas.emer
 */
public class AssinaturaDao extends DaoAdapter<Assinatura,Integer> {

    @Override
    public void create(Assinatura as) throws InvalidKeyException, KeyViolationException {
        if (as.getPk()!=null){
            try{
                String sql = "insert into assinatura values (?, ?, ?, ?, ?);";
                SystemManager.getInstance().getDataBase().runPreparedSQL(sql,
                        as.getPk(),as.getNome(),as.getQualidade(),as.getQtdMaxDispositivos(),as.getPreco());
            }catch(DataBaseException ex){
                throw new KeyViolationException();
            }
        }else{
            throw new InvalidKeyException();
        }
    }
    

    @Override
    public Assinatura read(Integer primaryKey) throws NotFoundException {
        Assinatura as=null;
        ArrayList<Assinatura> array=this.readAll();
        for (Assinatura assinatura : array) {
            if (assinatura.getPk().equals(primaryKey)){
                as=assinatura;
                break;
            }
        }
        
        if (as==null){
            throw new NotFoundException();
        }
        return as;
    }

    @Override
    public ArrayList<Assinatura> readAll() {
        ArrayList<Assinatura> lista = new ArrayList();
        
        try
        {
            ResultSet rs = br.univates.persistencia.SystemManager.getInstance().getDataBase().runQuerySQL("select * from assinatura;");
            
            if (rs.isBeforeFirst())
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    Integer pk = rs.getInt("idassinatura");
                    String nome = rs.getString("nome");
                    String qual = rs.getString("qualidade");
                    int qtd = rs.getInt("qtd_maxima");
                    double preco = rs.getDouble("preco");
                    
                    Assinatura e = new Assinatura(pk,nome,qual,qtd,preco);
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
    public ArrayList<Assinatura> readAll(Filter<Assinatura> filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Assinatura as) throws NotFoundException {
        
        try {
            String sql = "UPDATE assinatura SET nome = ?, qualidade = ?, qtd_maxima =  ?,"
                    + " preco = ? WHERE idassinatura = ? ;";
            SystemManager.getInstance().getDataBase().runPreparedSQL(sql,as.getNome(),as.getQualidade(),
                    as.getQtdMaxDispositivos(),as.getPreco(),as.getPk());
        } catch (DataBaseException ex) {
            Logger.getLogger(AssinaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(Integer primaryKey) throws NotFoundException {
        try {
            String sql = "DELETE FROM assinatura WHERE idassinatura = ? ;";
            SystemManager.getInstance().getDataBase().runPreparedSQL(sql, primaryKey);
        } catch (DataBaseException ex) {
            Logger.getLogger(AssinaturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
