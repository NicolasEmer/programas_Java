package br.univates.source.menu3;

import br.univates.source.Entrada;

public class Menu
{
    private MenuModel model;

    public Menu(MenuModel model)
    {
        this.model = model;
    }
    
    public void gerar()
    {
        char[] atalhos = model.getAtalhos();
        String[] descricoes = model.getDescricoes();
        
        String menu = "M E N U\n\n";
        for (int i = 0; i < atalhos.length; i++)
        {
            char atalho = atalhos[i];
            String descricao = descricoes[i];
            
            menu += "["+atalho+"] "+descricao+"\n";
        }
        menu += "[x] Sair\n\n";
        menu += "Opção:";
        char op = ' ';
        while (op != 'x')
        {
            op = Entrada.leiaChar(menu);
            op = Character.toLowerCase(op);
            
            model.executarProcesso( op );
        }
    }
    
    
}
