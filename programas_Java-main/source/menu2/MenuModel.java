package br.univates.source.menu2;

public abstract class MenuModel
{
    public abstract char[] getAtalhos();
    public abstract String[] getDescricoes();
    public abstract void executarProcesso( char op );
}
