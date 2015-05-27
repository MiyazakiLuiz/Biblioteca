package Trabalho3;


public abstract class Pessoa 
{
    private String nome;
    private int numeroDeLivros;
    private int numeroDeLivrosMax;    
    private int limiteDias;
    private boolean suspenso;
    private int diasDeSuspensao;
    
    public void setDiasDeSuspensao(int a)
    {
        this.diasDeSuspensao = a;
    }
    
    public int getDiasDeSuspensao()
    {
        return this.diasDeSuspensao;
    }
            
    
    public void setNome(String a)
    {
        this.nome = a;
        /*this.numeroDeLivros = 0;
        this.suspenso = false;*/
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    /*void Pessoa(String a)
    {
        this.setNome(a);
    }*/
    
    public void setNumeroDeLivros(int a)
    {
        this.numeroDeLivros = a;
    }
    
    public int getNumeroDeLivros()
    {
        return this.numeroDeLivros;
    }
    
    public void setNumeroDeLivrosMax(int a)
    {
        this.numeroDeLivrosMax = a;
    }
    
    public int getNumeroDeLivrosMax()
    {
        return this.numeroDeLivrosMax;
    }
    
    public void setlimiteDias(int a)
    {
        this.limiteDias = a;
    }
    
    public int getlimiteDias()
    {
        return this.limiteDias;
    }
    
    public void setSuspenso(boolean a)
    {
        this.suspenso = a;
    }
    
    public boolean getSuspenso()
    {
        return this.suspenso;
    }
    
    
    
    

}
