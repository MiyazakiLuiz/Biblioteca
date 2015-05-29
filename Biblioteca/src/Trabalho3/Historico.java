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
        
        this.calendarA.set(DATE, this.diaA);
        this.calendarA.set(MONTH, this.mesA);
        this.calendarA.set(YEAR, this.anoA);
        
        this.calendarN.set(DATE, this.diaN);
        this.calendarN.set(MONTH, this.mesN);
        this.calendarN.set(YEAR, this.anoN);
    }
    
    public void setDia(int a)
    {
        this.diaN = a;
        this.calendarN.set(DATE, this.diaN);
    }
    
    public void setMes(int a)
    {
        this.mesN = a;
        this.calendarN.set(MONTH, this.mesN);
    }
    
    public void setAno(int a)
    {
        this.anoN = a;
        this.calendarN.set(YEAR, this.anoN);
    }
    
    
    
    public Calendar getCalendarA()
    {
        return this.calendarA;
    }
    
    public Calendar getCalendarN()
    {
        return this.calendarN;
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
