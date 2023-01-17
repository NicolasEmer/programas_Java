package br.univates.source.menu1;

import br.univates.source.Entrada;

public abstract class Menu
{
    private char[] atalhos;
    private String[] descricoes;
    
    public Menu(char[] atalhos, String[] descricoes)
    {
        this.atalhos = atalhos;
        this.descricoes = descricoes;
    }
    
    public void gerar()
    {
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
            
            executarProcesso( op );
        }
    }
    
    public abstract void executarProcesso( char op );
    
}
