/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.negocio.Cliente;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class ModeloCliente extends ModeloAdapter{
    private ArrayList<Cliente> lista;

    public ModeloCliente(ArrayList<Cliente> lista)
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
        return 8;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        String[] col = { "CPF","Nome","Email","Assinatura ativa","Telefone",
            "Endereco","Forma de pagamento","Assinatura (ultima registrada)" };
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
        Cliente aux = lista.get(rowIndex);
        Object[] vet = { aux.getCpf(), aux.getNome(),aux.getEmail(), aux.getAss_atv(),aux.getTelefone(),
            aux.getEndereco().getTodasInformacoes(), aux.getForma_pag().getTipo(), aux.getAssinatura().getNome() };
        return vet[columnIndex];
    }
}
