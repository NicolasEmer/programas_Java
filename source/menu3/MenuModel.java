package br.univates.source.menu3;


public interface MenuModel
{
    public char[] getAtalhos();
    public String[] getDescricoes();
    public void executarProcesso( char op );
}
