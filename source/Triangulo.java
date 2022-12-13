package br.univates.source;

public class Triangulo
{
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC)
    {
        this.ladoA = 1;
        this.ladoB = 1;
        this.ladoC = 1;
        
        setLadosTriangulo(ladoA,ladoB,ladoC);
    }
    
    public static boolean isCorreto(double a, double b, double c)
    {
        double maior = Math.max(a, Math.max(b, c));
        double soma = a+b+c-maior;
        
        return (maior < soma);
    }

    public double getLadoA()
    {
        return ladoA;
    }

    public double getLadoB()
    {
        return ladoB;
    }

    public double getLadoC()
    {
        return ladoC;
    }

    public void setLadoA(double a)
    {
        if (this.isCorreto(a,this.ladoB,this.ladoC))
        {
            this.ladoA = a;
        }        
    }

    public void setLadoB(double b)
    {
        if (this.isCorreto(this.ladoA,b,this.ladoC))
        {
            this.ladoB = b;
        }
    }

    public void setLadosTriangulo(double a, double b, double c)
    {
        if (this.isCorreto(a,b,c))
        {
            this.ladoA = a;
            this.ladoB = b;
            this.ladoC = c;
        }
    }
    
    
    public void setLadoC(double c)
    {
        if (this.isCorreto(this.ladoA,this.ladoB,c))
        {
            this.ladoC = c;
        }
    }
    
    public double getArea()
    {
        double sp = (ladoA+ladoB+ladoC)/2;
        double area = Math.sqrt(sp * (sp-ladoA) * (sp-ladoB) * (sp-ladoC) );
        return area;
    }
    
    public double getPerimetro()
    {
        return ladoA+ladoB+ladoC;
    }
    
    
    
}
