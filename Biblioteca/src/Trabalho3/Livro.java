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
    private String atualDono;

    Livro(String a, boolean b, int c, boolean d, String e, String f, String g, int h) 
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
    
    public void setAtualDono(String a)
    {
        this.atualDono = a;
    }
    
    public void setEmprestado(boolean a)
    {
        this.emprestado = a;
    }
    
    public void setDias(int a)
    {
        this.diasRestantes = a;
    }
    
    public String getNome()
    {
        return this.titulo;
    }
    
    public String getAutor()
    {
        return this.autor;
    }
    
    public String getEdtora()
    {
        return this.editora;
    }
    
    public int getAno()
    {
        return this.ano;
    }
    
    public boolean getText()
    {
        return this.text;
    }
    
    public boolean getEmpr()
    {
        return this.emprestado;
    }
    
    public int getDias()
    {
        return this.diasRestantes;
    }
    
    public String getAtualDono()
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
