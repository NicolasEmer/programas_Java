/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.source.db.exemplo;

import br.univates.source.db.DataBaseConnectionManager;
import br.univates.source.db.DataBaseException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mouriac
 */
public class Main
{
    public static void main(String[] args)
    {
//        
//        try
//        {
//            DataBaseConnectionManager dbcm = new DataBaseConnectionManager( DataBaseConnectionManager.POSTGRESQL, 
//                    "tec_prog", "postgres", "postgres" );
//            dbcm.connectionTest();
//            
//            System.out.println("Conectou");
//        } 
//        catch (DataBaseException ex)
//        {
//            System.out.println("Não conectou");
//        }

        try
        {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager( DataBaseConnectionManager.POSTGRESQL, 
                    "tec_prog", "postgres", "postgres" );
            
            //dbcm.runSQL( "insert into estado values ('SP','São Paulo');" );
            dbcm.runSQL( "insert into cidade values (4,'Porto Belo','SC');" );
            
            ResultSet rs = dbcm.runQuerySQL("select * from cidade;");
 
            if (rs.isBeforeFirst()) // significa que retornou alguma coisa no select
            {

                rs.next(); // avançar para o primeiro item do ResultSet
                while (!rs.isAfterLast())
                {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String uf = rs.getString("sigla_estado");

                    System.out.println(id+" - "+nome+" - "+uf);
                    rs.next();
                }
                dbcm.closeConnection();
            }
            else
            {
                System.out.println("vazio");
            }
            
        } 
        catch (DataBaseException ex)
        {
            System.out.println( ex.getMessage() );
        } 
        catch (SQLException ex)
        {
            System.out.println("Problema no Result Set");
        }

    }
}
