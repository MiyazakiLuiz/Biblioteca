/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho3;

import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

/**
 *
 * @author 8937013
 */
public class Historico 
{
    //private Calendar calendarioN = Calendar.getInstance();
    
    //private Calendar calendarioV = Calendar.getInstance();
    
    private Calendar calendarN = Calendar.getInstance();
    private Calendar calendarA = Calendar.getInstance();
    
    private int diaA;
    private int mesA;
    private int anoA;
    
    private int diaN;
    private int mesN;
    private int anoN;
    
    private int Dono;
    
    private String Livro;
    
    public Historico(int diaA, int mesA, int anoA, int diaN, int mesN, int anoN, int Dono, String Livro)
    {
        this.diaA = diaA;
        this.mesA = mesA;
        this.anoA = anoA;
        
        this.diaN = diaN;
        this.mesN = mesN;
        this.anoN = anoN;
        
        this.Dono = Dono;
        this.Livro = Livro;
        
        this.calendarA.set(DATE, this.diaA);
        this.calendarA.set(MONTH, this.mesA);
        this.calendarA.set(YEAR, this.anoA);
        
        this.calendarN.set(DATE, this.diaN);
        this.calendarN.set(MONTH, this.mesN);
        this.calendarN.set(YEAR, this.anoN);
    }
    
    /*
    muda o dia do historico
    input: novo dia
    */
    public void setDia(int a)
    {
        this.diaN = a;
        this.calendarN.set(DATE, this.diaN);
    }
    
    /*
    muda o mes do historico
    input: novo mes
    */
    public void setMes(int a)
    {
        this.mesN = a;
        this.calendarN.set(MONTH, this.mesN);
    }
    
    /*
    muda o ano do historico
    input: novo ano
    */
    public void setAno(int a)
    {
        this.anoN = a;
        this.calendarN.set(YEAR, this.anoN);
    }
    
    /*
    retorna o calendario antigo
    output: calendario antigo
    */
    public Calendar getCalendarA()
    {
        return this.calendarA;
    }
    
    /*
    retorna o calendario novo
    output: calendario novo
    */
    public Calendar getCalendarN()
    {
        return this.calendarN;
    }
    
    /*
    retorna o dia antigo
    output: dia antigo
    */
    public int getDiaA()
    {
        return this.diaA;
    }
    
    /*
    retorna o mes antigo
    output: mes antigo
    */
    public int getMesA()
    {
        return this.mesA;
    }
    
    /*
    retorna o ano antigo
    output: ano antigo
    */
    public int getAnoA()
    {
        return this.anoA;
    }
    
    /*
    retorna o dia novo
    output: dia novo
    */
    public int getDiaN()
    {
        return this.diaN;
    }
    
    /*
    retorna o mes novo
    output: mes novo
    */
    public int getMesN()
    {
        return this.mesN;
    }
    
    /*
    retorna o ano novo
    output: ano novo
    */
    public int getAnoN()
    {
        return this.anoN;
    }
    
     /*
    retorna a pessoa que esta no historico
    output: a pessoa que esta no historico
    */
    public int getDono()
    {
        return this.Dono;
    }
    
    /*
    retorna o titulo do livro
    output: o titulo do livro
    */
    public String getLivro()
    {
        return this.Livro;
    }
    
}
