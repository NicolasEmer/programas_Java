package br.univates.source.menu4;

public class MenuItem
{
    private char atalho;
    private String descricao;
    private MenuProcesso acao;

    public MenuItem(char atalho, String descricao, MenuProcesso acao)
    {
        this.atalho = atalho;
        this.descricao = descricao;
        this.acao = acao;
    }
    
    public void executarOperacao()
    {
        this.acao.executar();
    }
    

    public MenuProcesso getAcao()
    {
        return acao;
    }

    public void setAcao(MenuProcesso acao)
    {
        this.acao = acao;
    }

    public char getAtalho()
    {
        return atalho;
    }

    public void setAtalho(char atalho)
    {
        this.atalho = atalho;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
    
    
}
