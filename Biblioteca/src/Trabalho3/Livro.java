package Trabalho3;


public class Livro 
{
    private String titulo;
    private String editora;
    private String autor;
    private int ano;
    
    private boolean emprestado;
    private int diasRestantes;
    private boolean text;
    private int atualDono;

    Livro(String a, boolean b, int c, boolean d, int e, String f, String g, int h) 
    {
        this.titulo = a;
        this.emprestado = b;
        this.diasRestantes = c;  
        this.text = d;
        this.atualDono = e;
        this.autor = f;
        this.editora = g;
        this.ano = h;
    }
    
     /*
    muda o atual dono
    input: atual dono
    */
    public void setAtualDono(int a)
    {
        this.atualDono = a;
    }
    
    /*
    retorna o atual dono
    output: atual dono
    */
    public void setEmprestado(boolean a)
    {
        this.emprestado = a;
    }
    
    /*
    muda o numero de dias restantes para o livro ser devolvido
    sem a pessoa que esta com ele ser suspensa
    input: o numero de dias restantes para o livro ser devolvido
    sem a pessoa que esta com ele ser suspensa
    */
    public void setDias(int a)
    {
        this.diasRestantes = a;
    }
    
    /*
    retorna o titulo do livro
    output: titulo
    */
    public String getNome()
    {
        return this.titulo;
    }
    
    /*
    retorna o autor do livro
    output: autor
    */
    public String getAutor()
    {
        return this.autor;
    }
    
    /*
    retorna a editora do livro
    output: editora
    */
    public String getEdtora()
    {
        return this.editora;
    }
    
    /*
    retorna o ano do livro
    output: ano
    */
    public int getAno()
    {
        return this.ano;
    }
    
    /*
    retorna true se o livro é texto e false se for geral
    output: true/false
    */
    public boolean getText()
    {
        return this.text;
    }
    
    /*
    retorna true se o livro esta e false se nao esta
    output: true/false
    */
    public boolean getEmpr()
    {
        return this.emprestado;
    }
    
    /*
    retorna o numero de dias restantes para o livro ser devolvido
    sem a pessoa que esta com ele ser suspensa
    output: dias restantes
    */
    public int getDias()
    {
        return this.diasRestantes;
    }
    
    /*
    retorna o atual dono do livro
    output: atual dono
    */
    public int getAtualDono()
    {
        return this.atualDono;
    }
    
    /*void Livro(String a, boolean b)
    {
        this.titulo = a;
        this.emprestado = false;
        this.diasRestantes = 0;  
        this.text = b;
        //this.atualDono = c;
    }*/
    
    
}
