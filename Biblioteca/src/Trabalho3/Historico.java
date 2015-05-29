/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho3;

import java.util.Calendar;

/**
 *
 * @author 8937013
 */
public class Historico 
{
    //private Calendar calendarioN = Calendar.getInstance();
    
    //private Calendar calendarioV = Calendar.getInstance();
    
    private int diaA;
    private int mesA;
    private int anoA;
    
    private int diaN;
    private int mesN;
    private int anoN;
    
    private String Dono;
    
    private String Livro;
    
    public Historico(int diaA, int mesA, int anoA, int diaN, int mesN, int anoN, String Dono, String Livro)
    {
        this.diaA = diaA;
        this.mesA = mesA;
        this.anoA = anoA;
        
        this.diaN = diaN;
        this.mesN = mesN;
        this.anoN = anoN;
        
        this.Dono = Dono;
        this.Livro = Livro;
    }
    
    public void setDia(int a)
    {
        this.diaN = a;
    }
    
    public void setMes(int a)
    {
        this.mesN = a;
    }
    
    public void setAno(int a)
    {
        this.anoN = a;
    }
    
    public int getDiaA()
    {
        return this.diaA;
    }
    
    public int getMesA()
    {
        return this.mesA;
    }
    
    public int getAnoA()
    {
        return this.anoA;
    }
    
    public int getDiaN()
    {
        return this.diaN;
    }
    
    public int getMesN()
    {
        return this.mesN;
    }
    
    public int getAnoN()
    {
        return this.anoN;
    }
            
    
    
    
    public String getDono()
    {
        return this.Dono;
    }
    
    public String getLivro()
    {
        return this.Livro;
    }
    
}
