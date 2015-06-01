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
    
    /*
    muda os dias de suspensao
    input: dias de suspensao atual
    */
    public void setDiasDeSuspensao(int a)
    {
        this.diasDeSuspensao = a;
    }
    
    /*
    retorna os dias de suspensao
    output: dias de suspensao
    */
    public int getDiasDeSuspensao()
    {
        return this.diasDeSuspensao;
    }
            
    /*
    muda o nome da pessoa
    input: nome
    */
    public void setNome(String a)
    {
        this.nome = a;
    }
    
    /*
    muda o sonho da pessoa
    input: sonho
    */
    public void setSonho(String a)
    {
        this.sonhos_e_esperancas = a;
    }
    
    /*
    muda a idade da pessoa
    input: idade
    */
    public void setIdade(int a)
    {
        this.idade = a;
    }
    
    /*
    muda o ID da pessoa
    input: ID
    */
    public void setId(int a)
    {
        this.id = a;
    }
    
    /*
    retorna o nome da pessoa
    output: nome
    */
    public String getNome()
    {
        return this.nome;
    }
    
    /*
    retorna o sonho da pessoa
    output: sonho
    */
    public String getSonho()
    {
        return this.sonhos_e_esperancas;
    }
    
    /*
    retorna a idade da pessoa
    output: idade
    */
    public int getIdade()
    {
        return this.idade;
    }
    
    /*
    retorna o id da pessoa
    output: id
    */
    public int getId()
    {
        return this.id;
    }
    
    /*void Pessoa(String a)
    {
        this.setNome(a);
    }*/
    
    /*
    muda o numero de livros que a pessoa tem atualmente
    input: numero de livros que a pessoa tem atualmente
    */
    public void setNumeroDeLivros(int a)
    {
        this.numeroDeLivros = a;
    }
    
    /*
    retorna o numero de livros que a pessoa tem atualmente
    output: o numero de livros que a pessoa tem atualmente
    */
    public int getNumeroDeLivros()
    {
        return this.numeroDeLivros;
    }
    
    /*
    muda o numero de livros maximo que a pessoa pode ter
    input: o numero de livros maximo que a pessoa pode ter
    */
    public void setNumeroDeLivrosMax(int a)
    {
        this.numeroDeLivrosMax = a;
    }
    
    /*
    retorna o numero de livros maximo que a pessoa pode ter
    output: o numero de livros maximo que a pessoa pode ter
    */
    public int getNumeroDeLivrosMax()
    {
        return this.numeroDeLivrosMax;
    }
    
    /*
    muda o numero maximo de dias que a pessoa pode ficar com o livro
    input: o numero maximo de dias que a pessoa pode ficar com o livro
    */
    public void setlimiteDias(int a)
    {
        this.limiteDias = a;
    }
    
    /*
    retorna o numero maximo de dias que a pessoa pode ficar com o livro
    output: o numero maximo de dias que a pessoa pode ficar com o livro
    */
    public int getlimiteDias()
    {
        return this.limiteDias;
    }
    
    /*
    muda a variavel booleana para true se a pessoa estiver suspensa
    ou para false se a pessoa nao estiver suspensa
    input: true/false
    */
    public void setSuspenso(boolean a)
    {
        this.suspenso = a;
    }
    
    /*
    retorna a variavel booleana para true se a pessoa estiver suspensa
    ou para false se a pessoa nao estiver suspensa
    output: true/false
    */
    public boolean getSuspenso()
    {
        return this.suspenso;
    }
    
    
    
    

}
