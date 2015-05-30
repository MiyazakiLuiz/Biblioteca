package Trabalho3;


public abstract class Pessoa 
{
    private String nome;
    private int idade;
    private String sonhos_e_esperancas;
    private int id;
    
    
    
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
    }
    
    public void setSonho(String a)
    {
        this.sonhos_e_esperancas = a;
    }
    
    public void setIdade(int a)
    {
        this.idade = a;
    }
    
    public void setId(int a)
    {
        this.id = a;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getSonho()
    {
        return this.sonhos_e_esperancas;
    }
    
    public int getIdade()
    {
        return this.idade;
    }
    
    public int getId()
    {
        return this.id;
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
