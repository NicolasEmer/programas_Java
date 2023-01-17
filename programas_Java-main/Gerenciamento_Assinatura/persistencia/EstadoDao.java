
package br.univates.persistencia;

import br.univates.negocio.Estado;
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
public class EstadoDao extends DaoAdapter<Estado,Integer> {

    @Override
    public void create(Estado as) throws InvalidKeyException, KeyViolationException {
        if (as.getPk()!=null){
            try{
                String sql = "insert into estado values (?, ?, ?);";
                SystemManager.getInstance().getDataBase().runPreparedSQL(sql,as.getPk(),as.getNome(),as.getSigla());
            }catch(DataBaseException ex){
                throw new KeyViolationException();
            }
        }else{
            throw new InvalidKeyException();
        }
    }
    

    @Override
    public Estado read(Integer primaryKey) throws NotFoundException {
        Estado as=null;
        ArrayList<Estado> array=this.readAll();
        for (Estado estado : array) {
            if (estado.getPk().equals(primaryKey)){
                as=estado;
                break;
            }
        }
        
        if (as==null){
            throw new NotFoundException();
        }
        return as;
    }

    @Override
    public ArrayList<Estado> readAll() {
        ArrayList<Estado> lista = new ArrayList();
        
        try
        {
            ResultSet rs = br.univates.persistencia.SystemManager.getInstance().getDataBase().runQuerySQL("select * from estado;");
            
            if (rs.isBeforeFirst())
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    Integer pk = rs.getInt("idestado");
                    String nome = rs.getString("nome");
                    String sigla = rs.getString("sigla");
                    
                    Estado e = new Estado(pk,nome,sigla);
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
    public ArrayList<Estado> readAll(Filter<Estado> filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Estado as) {
        
        try {
            String sql = "UPDATE estado SET nome = ?, sigla= ? WHERE idestado = ? ;";
            SystemManager.getInstance().getDataBase().runPreparedSQL(sql,as.getNome(),as.getSigla(),as.getPk());
        } catch (DataBaseException ex) {
            Logger.getLogger(EstadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(Integer primaryKey) throws NotFoundException {
        try {
            String sql = "DELETE FROM estado WHERE idestado = ? ;";
            SystemManager.getInstance().getDataBase().runPreparedSQL(sql, primaryKey);
        } catch (DataBaseException ex) {
            Logger.getLogger(EstadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}

