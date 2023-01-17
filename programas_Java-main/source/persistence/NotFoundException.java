package br.univates.source.persistence;

public class NotFoundException extends Exception
{

    public NotFoundException()
    {
        super("Registro não encontrado");
    }

    
    
}
