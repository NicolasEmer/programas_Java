package br.univates.source.persistence;

public interface Filter<T>
{
    public boolean isAccept(T record);
}
