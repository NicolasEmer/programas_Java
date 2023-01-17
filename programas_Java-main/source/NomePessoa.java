package br.univates.source;

public class NomePessoa
{
    final public static int NOME_COMPLETO = 0;
    final public static int SOBRENOME_NOME = 1;
    final public static int SOBRENOME_INICIAIS = 2;
    final public static int INICIAIS_SOBRENOME = 3;
    
    private String nome;

    public NomePessoa(String nome)
    {
        this.nome = "<vazio>";
        setNomePessoa(nome);
    }

    public String toString()
    {
        return nome;
    }

    public String getNomeFormatado( int formato )
    {   
        String iniciais = this.getIniciais(true).substring(0, this.getIniciais(true).trim().lastIndexOf(" "));
        
        String retorno = this.nome;
        if (formato == 1)
        {
            retorno = this.getSobrenome().toUpperCase()+", "+this.getPrenome();
        }
        else if (formato == 2)
        {
            retorno = this.getSobrenome().toUpperCase()+", "+iniciais;
        }
        else if (formato == 3)
        {
            retorno = iniciais+" "+this.getSobrenome();
        }
        // CHAVES, J. M.
        // J. M. Chaves
        return retorno;
    }
    
    public String getSobrenome()
    {
        String sobrenome = this.nome;
        String aux = this.getNomeSemLigacoes();
        String[] partes = aux.split(" ");
        if (partes.length > 0)
        {
            sobrenome = partes[ partes.length-1 ];
        }
        return sobrenome;
    }
    
    public String getPrenome()
    {
        String prenome = this.nome;
        String aux = this.getNomeSemLigacoes();
        String[] partes = aux.split(" ");
        if (partes.length > 0)
        {
            prenome = partes[ 0 ];
        }
        return prenome;
    }
    
    public String getIniciais()
    {
        return this.getIniciais(false);
    }
    
    public String getIniciais( boolean comPonto )
    {
        String salva = nome;
        nome = this.getNomeSemLigacoes();
        String aux = this.getNomeSemCaracteresEspeciais();
        nome = salva;
        
        String[] partes = aux.split(" ");
        String iniciais = "";
        for (String parte: partes)
        {
            iniciais += parte.charAt(0)+(comPonto ? ". " : "");
        }
        return iniciais.toUpperCase();
    }
    
    public String getNomeSemCaracteresEspeciais()
    {
        String charsEspeciais = "áàãäâéèêëíìîïóòôõöúùüûçñ";
        String charsLimpos    = "aaaaaeeeeiiiiooooouuuucn";
        String aux = this.nome;
        
        for (int i = 0; i < charsEspeciais.length(); i++)
        {
            //if (aux.contains(charsEspeciais.charAt(i)+""))
            //{
                aux = aux.replace(charsEspeciais.charAt(i), charsLimpos.charAt(i));
            //}
        }
        
        for (int i = 0; i < charsEspeciais.length(); i++)
        {
            //if (aux.contains(charsEspeciais.toUpperCase().charAt(i)+""))
            //{
                aux = aux.replace(charsEspeciais.toUpperCase().charAt(i), charsLimpos.toUpperCase().charAt(i));
            //}
        }
        
        return aux;
    }
    
    public String getNomeSemLigacoes()
    {
        String[] ligacoes = { " de ", " da ", " dos ", " das " };
        String nomeAux = nome;
        for (String conexao: ligacoes)
        {
            if (nomeAux.contains( conexao ))
            {
                nomeAux = nomeAux.replace(conexao," ");
            }
        }
        return nomeAux;
    }
    
    

    public void setNomePessoa(String nome)
    {
        if (!nome.isEmpty())
        {
            this.nome = nome;
        }
    }
    
    
    
}
