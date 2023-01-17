package br.univates.source.menu1;

import br.univates.source.Entrada;

public class MenuOld
{
    private char[] atalhos;
    private String[] descricoes;
    
    public MenuOld(char[] atalhos, String[] descricoes)
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
    
    public void executarProcesso( char op )
    {
        throw new RuntimeException("A classe Menu deve ser estendida e o método \"executarProcesso\" precisa ser sobrescrito." );
        //System.out.println("A opção escolhida foi ["+op+"]");
    }
    
}
