package br.univates.apresentacao;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public abstract class ModeloAdapter implements TableModel
{
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
    }

    @Override
    public void addTableModelListener(TableModelListener l)
    {
    }

    @Override
    public void removeTableModelListener(TableModelListener l)
    {
    }
    
}
