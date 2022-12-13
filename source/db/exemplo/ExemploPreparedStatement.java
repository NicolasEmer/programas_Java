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
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author mouriac
 */
public class ExemploPreparedStatement
{
    public static void main(String[] args)
    {
        try
        {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager( DataBaseConnectionManager.POSTGRESQL, 
                    "tec_prog", "postgres", "postgres" );
            
            
            /**
             * Chamar o método runPreparedSQL 
             * O primeiro parâmetro será a string SQL substituindo por ? todos os campos variáveis
             * Depois completar mais tantos argumentos quantas forem as interrogações colocadas no SQL
             * Os argumentos poderão ser inteiro, double, String ou Date
             */
            //dbcm.runPreparedSQL( "insert into cidade values (?,?,?);", 5, "Santiago", "RS" );
            dbcm.runPreparedSQL( "insert into pedido values (?,?,?);", 2, "Paulo Silva", new Date() );
            
            //ResultSet rs = dbcm.runQuerySQL("select * from cidade;");
            ResultSet rs = dbcm.runPreparedQuerySQL("select * from pedido where data <= ?;", new Date());
 
            if (rs.isBeforeFirst()) // significa que retornou alguma coisa no select
            {

                rs.next(); // avançar para o primeiro item do ResultSet
                while (!rs.isAfterLast())
                {
                    //int id = rs.getInt("id");
                    //String nome = rs.getString("nome");
                    //String uf = rs.getString("sigla_estado");

                    int id = rs.getInt("numero");
                    String nome = rs.getString("cliente");
                    Date dt = rs.getDate("data");
                    
                    System.out.println(id+" - "+nome+" - "+DateFormat.getDateInstance().format(dt) );
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
