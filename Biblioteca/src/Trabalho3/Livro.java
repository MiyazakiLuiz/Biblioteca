package Trabalho3;


public class Livro 
{
    private String titulo;
    private boolean emprestado;
    private int diasRestantes;
    private boolean text;
    private String atualDono;

    Livro(String a, boolean b, int c, boolean d, String e) 
    {
        this.titulo = a;
        this.emprestado = b;
        this.diasRestantes = c;  
        this.text = d;
        this.atualDono = e;
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
