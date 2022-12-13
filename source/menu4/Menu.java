package br.univates.source.menu4;

import br.univates.source.Entrada;
import java.util.ArrayList;

public class Menu
{
    private ArrayList<MenuItem> itens;

    public Menu()
    {
        this.itens = new ArrayList();
    }
    
    public void adicionarMenuItem( MenuItem item )
    {
        itens.add(item);
    }
    
    public void gerar()
    {        
        String menu = "M E N U\n\n";
        for (int i = 0; i < itens.size(); i++)
        {
            char atalho = itens.get(i).getAtalho();
            String descricao = itens.get(i).getDescricao();
            
            menu += "["+atalho+"] "+descricao+"\n";
        }
        menu += "[x] Sair\n\n";
        menu += "Opção:";
        char op = ' ';
        while (op != 'x')
        {
            op = Entrada.leiaChar(menu);
            op = Character.toLowerCase(op);
            
            for (MenuItem item: itens)
            {
                if (item.getAtalho() == op)
                {
                    item.executarOperacao();
                    break;
                }
            }
        }
    }
    
    
}
