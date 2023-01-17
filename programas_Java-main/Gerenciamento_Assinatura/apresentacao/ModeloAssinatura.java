/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.negocio.Assinatura;
import java.util.ArrayList;


/**
 *
 * @author nicol
 */
public class ModeloAssinatura extends ModeloAdapter{
    private ArrayList<Assinatura> lista;

    public ModeloAssinatura(ArrayList<Assinatura> lista)
    {
        this.lista = lista;
    }

    
    @Override
    public int getRowCount()
    {
        return lista.size();
    }

    @Override
    public int getColumnCount()
    {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        String[] col = { "ID","Nome","Qualidade","Quantidade máxima de dispositivos","Preço" };
        return col[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        if (columnIndex == 0)
        {
            return Integer.class;
        }
        return String.class;
    }

    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Assinatura aux = lista.get(rowIndex);
        Object[] vet = {aux.getPk(), aux.getNome(),aux.getQualidade(),
            aux.getQtdMaxDispositivos(),aux.getPreco()};
        return vet[columnIndex];
    }
}