/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.persistencia;

import br.univates.negocio.Endereco;
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
public class EnderecoDao extends DaoAdapter<Endereco,Integer> {

   @Override
    public void create(Endereco as) throws InvalidKeyException, KeyViolationException {
        if (as.getPk()!=null){
            try{
                String sql = "insert into endereco values ("+as.getPk()+", '"+as.getRua()+"', '"+as.getBairro()+"', '"+
                        as.getNumero()+"', '"+as.getCidade()+"', '"+as.getEstado().getPk()+"');";
                SystemManager.getInstance().getDataBase().runSQL(sql);
            }catch(DataBaseException ex){
                throw new KeyViolationException();
            }
        }else{
            throw new InvalidKeyException();
        }
    }
    

    @Override
    public Endereco read(Integer primaryKey) throws NotFoundException {
        Endereco as=null;
        ArrayList<Endereco> array=this.readAll();
        for (Endereco endereco : array) {
            if (endereco.getPk().equals(primaryKey)){
                as=endereco;
                break;
            }
        }
        
        if (as==null){
            throw new NotFoundException();
        }
        return as;
    }

    @Override
    public ArrayList<Endereco> readAll() {
        ArrayList<Endereco> lista = new ArrayList();
        
        try
        {
            ResultSet rs = br.univates.persistencia.SystemManager.getInstance().getDataBase().runQuerySQL("select * from endereco;");
            
            if (rs.isBeforeFirst())
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    Integer pk = rs.getInt("idendereco");
                    String rua = rs.getString("rua");
                    String bairro = rs.getString("bairro");
                    int numero = rs.getInt("numero");
                    String cidade = rs.getString("cidade");
                    int estado = rs.getInt("idestado");
                    
                    Endereco e = new Endereco(pk,rua,bairro,numero,cidade,DaoFactory.createEstadoDao().read(estado));
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
           Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        return lista;
    }
    
    @Override
    public ArrayList<Endereco> readAll(Filter<Endereco> filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Endereco as) {
        
        try {
            String sql = "UPDATE endereco SET rua = ?, bairro = ?, numero =  ?,"
                    + " cidade = ?, idestado = ? WHERE idendereco = ? ;";
            SystemManager.getInstance().getDataBase().runPreparedSQL(sql,as.getRua(),as.getBairro(),
                    as.getNumero(),as.getCidade(),as.getEstado().getPk(),as.getPk());
        } catch (DataBaseException ex) {
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(Integer primaryKey) throws NotFoundException {
        try {
            String sql = "DELETE FROM endereco WHERE idendereco = ? ;";
            SystemManager.getInstance().getDataBase().runPreparedSQL(sql, primaryKey);
        } catch (DataBaseException ex) {
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
