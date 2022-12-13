package br.univates.persistencia;

import br.univates.source.db.DataBaseConnectionManager;
import br.univates.source.db.DataBaseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SystemManager
{
    private static SystemManager instance = new SystemManager();

    public static SystemManager getInstance()
    {
        return instance;
    }


    private DataBaseConnectionManager dbmc;
    
    private SystemManager()
    {
        try 
        {
            this.dbmc = new DataBaseConnectionManager( DataBaseConnectionManager.POSTGRESQL,
                    "Assinatura", "postgres", "nicolas" );
        } 
        catch (DataBaseException ex)
        {
            JOptionPane.showMessageDialog(null, 
                    "Erro fatal na configuração de acesso ao banco de dados",
                    "Conexão com o banco de dados", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    public DataBaseConnectionManager getDataBase()
    {
        return dbmc;
    }

    
    
}
