/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.source;

import java.util.Calendar;

/**
 *
 * @author mouriac
 */
public class Data
{
    final public static int DDMMAAAA = 1;
    final public static int DIA_MES_AAAA = 2;
    final public static int DIASEMANA_DIA_MES_AAAA = 3;
    
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano)
    {
        this.dia = 1;
        this.mes = 1;
        this.ano = 2001;
        
        this.setData(dia, mes, ano);
    }

    public int getDia()
    {
        return dia;
    }

    public int getMes()
    {
        return mes;
    }

    public int getAno()
    {
        return ano;
    }

    public void setDia(int dia)
    {
        if (Data.isCorreta(dia, mes, ano))
        {
            this.dia = dia;
        }
    }

    public void setMes(int mes)
    {
        if (Data.isCorreta(dia, mes, ano))
        {
            this.mes = mes;
        }
    }

    public void setAno(int ano)
    {
        if (Data.isCorreta(dia, mes, ano))
        {
            this.ano = ano;
        }
    }
    
    public void setData(int dia, int mes, int ano)
    {
        if (Data.isCorreta(dia, mes, ano))
        {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
    }
    
    public boolean isBissexto() 
    { 
        return (ano % 400 == 0 || ( ano%4==0 && ano%100!=0 ));
    }
    
    public int getUltimoDiaMes() 
    { 
        int[] dias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (this.isBissexto())
        {
            dias[1] = 29;
        }
        return dias[ mes-1 ]; 
    }
    
    private static int obterUltimoDiaMes(int mes, int ano) 
    { 
        int[] dias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if ((ano % 400 == 0 || ( ano%4==0 && ano%100!=0 )))
        {
            dias[1] = 29;
        }
        return dias[ mes-1 ]; 
    }
    
    public static boolean isCorreta(int dia, int mes, int ano) 
    { 
        boolean ok = false;
        if (ano >= 1901)
        {
            if (mes >=1 && mes <= 12)
            {
                if (dia >=1 && dia <= obterUltimoDiaMes(mes,ano))
                {
                    ok = true;
                }
            }
        }
        return ok; 
    }
    public int getDiferenca( Data data ) 
    { 
        return Math.abs(this.getDiaDoSeculo() - data.getDiaDoSeculo());
    }
    
    public long getDiaAno() 
    {
        return this.getDiferenca( new Data(1,1,ano) )+1;
    }
    
    public long getSegundosAno() 
    { 
        return this.getDiaAno() * 60 * 60 * 24;
    }
    
    public String getExtensoMes() 
    { 
        String[] meses = { "Janeiro", "Fevereiro", "Março", "Abril",
            "Maio", "Junho", "Julho", "Agosto", "Setembro",
            "Outubro", "Novembro", "Dezembro" };
        return meses[mes-1];
    }
    
    public String getDataFormatada( int formato ) 
    { 
        String dataFormatada = dia+"/"+mes+"/"+ano;
        if (formato == 1)
        {
            dataFormatada =  dia < 10 ? "0"+dia : ""+dia;
            dataFormatada += "/";
            dataFormatada +=  mes < 10 ? "0"+mes : ""+mes;
            dataFormatada += "/"+ano;
        }
        else if (formato == 2)
        {
            dataFormatada = dia+" de "+this.getExtensoMes().toLowerCase()+" de "+ano;
        }
        else if (formato == 3)
        {
            dataFormatada = this.getDiaSemana()+", "+dia+" de "+this.getExtensoMes().toLowerCase()+" de "+ano;
        }
        return dataFormatada;
    }
    
    public String getDiaSemana() 
    { 
        String[] semana = { "Segunda-feira", "Terça-feira", "Quarta-feira",
            "Quinta-feira", "Sexta-feira", "Sábado", "Domingo" };
        
        return semana[this.getDiaDoSeculo() % 7];
    }
    
    public void avancarUmDia() 
    {
        dia ++;
        if (!Data.isCorreta(dia,mes,ano))
        {
            dia = 1;
            mes ++;
            if (!Data.isCorreta(dia,mes,ano))
            {
                mes = 1;
                ano ++;
            }
        }
    }
    
    public void retrocederUmDia() 
    {
        dia --;
        if ( dia < 1 )
        {
            mes --;
            if ( mes < 1 )
            {
                mes = 12;
                ano --;
            }
            dia = this.getUltimoDiaMes();
        }
    }
    
    public void avancarDias( int dias ) 
    { 
        for (int i = 0; i < dias; i++)
        {
            this.avancarUmDia();
        }
    }
    
    public void retrocederDias( int dias ) 
    {
        for (int i = 0; i < dias; i++)
        {
            this.retrocederUmDia();
        }
    }
    
    public Data getDataFutura( int dias ) 
    { 
        Data d = new Data(dia,mes,ano);
        d.avancarDias(dias);
        return d; 
    }
    
    public String getEstacaoDoAno() { return null; }
    public String getSigno() { return null; }
    public String getFaseLua() { return null; }
    public boolean isFeriado() { return true; }


    
    public int getDiaDoSeculo()
    {
        //www.inf.ufrgs.br/~cabral/Dia_do_Seculo.html
        int diaDoSeculo = (ano - 1901) * 365 + (ano - 1901) / 4 + dia + (mes - 1)
                * 31 - ((mes * 4 + 23) / 10)
                * ((mes + 12) / 15) + ((4 - ano % 4) / 4)
                * ((mes + 12) / 15);
        return diaDoSeculo;
    }
    
    
    
}
