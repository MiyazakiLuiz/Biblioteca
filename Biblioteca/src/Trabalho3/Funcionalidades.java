/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author 8937013
 */
public class Funcionalidades 
{
    //Locale france = new Locale.Builder().setLanguage("fr").setRegion("CA").build();
    //Locale japan = new Locale.Builder().setLanguage("ja").setScript("Kana").build();
    
    //Locale japan = new Locale("ja");
        
    private static ArrayList<Pessoa> listNome = new ArrayList<Pessoa>();
    private static ArrayList<Livro> listLivros = new ArrayList<Livro>();
    
    
    String lang;
    String country;
    
    Locale currentLocale;
    
    ResourceBundle messages;
    
    Calendar calendarioN = Calendar.getInstance();
    
    Calendar calendarioV = Calendar.getInstance();
    
    private int diaAtual;
    private int mesAtual;
    private int anoAtual;
    
    private int diaAntigo;
    private int mesAntigo;
    private int anoAntigo;
    
    private int diferencaDias = 0;
    
    public ResourceBundle getMessages()
    {
        return this.messages;
    }
    
    
    public boolean removePessoa(String a)
    {
        String str;
        Pessoa rem = null;
        Livro rem2 = null;
        
        for(Pessoa aux : listNome)
        {
            if (a.equals(aux.getNome()))
            {
                rem = aux;
            }
        }
        
        if(rem == null)
        {
            return false;
        }
        
        str = null;
        
        System.out.println(rem.getNome());
        
        if(rem.getNumeroDeLivros() > 0)
        {   
            
                for(Livro aux : listLivros)
                {
                    if(aux.getAtualDono() == null || aux.getAtualDono().equals(rem.getNome()))
                    {
                        rem.setNumeroDeLivros(rem.getNumeroDeLivros() - 1);
                        aux.setEmprestado(false);
                        aux.setDias(0);
                        aux.setAtualDono(str);
                        
                    }
                }
                
        }
        
        return (this.listNome.remove(rem));
    }
    
    
    
    public boolean removeLivro(String a)
    {
        String str;
        Livro rem = null;
        Pessoa rem2 = null;
        
        for(Livro aux : listLivros)
        {
            if (a.equals(aux.getNome()))
            {
                rem = aux;
            }
        }
        
        if(rem == null)
        {
            return false;
        }
        
        if(rem.getEmpr())
        {
            str = rem.getAtualDono();
            
            
            for(Pessoa aux : listNome)
            {
                if(str.equals(aux.getNome()))
                {
                    aux.setNumeroDeLivros(aux.getNumeroDeLivros() - 1);
                }
            }
        }
        
        return (this.listLivros.remove(rem));
    }
    
    public void adicionaLivro(String nome, boolean empr, int diasParaDevolver, boolean text, String dono)
    {
        boolean encontrou = false;
        for(Livro aux: listLivros)
        {
            if(aux.getNome() == nome)
            {
                encontrou = true;
                break;
            }
        }
        
        if(encontrou)
        {
            System.out.println("Operacao invalida - Livro ja existe no acervo");
        }
        else{
            Livro novo = new Livro(nome, empr, diasParaDevolver, text, dono);
            listLivros.add(novo);
            System.out.println("Livro adicionado com sucesso");    
        }
    } 
    public void adicionaProfessor(String nome, int livros, boolean sus, int susD)
    {
        boolean encontrou = false;
        for(Pessoa aux: listNome)
        {
            if(aux.getNome() == nome)
            {
                encontrou = true;
                break;
            }
        }
        if(encontrou)
        {
            System.out.println("Operacao invalida - Pessoa ja esta cadastrada");
        }
        else{
            Professor novo = new Professor(nome, livros, sus, susD);
            listNome.add(novo);
        }
    }
    
    public void adicionaAluno(String nome, int livros, boolean sus, int susD)
    {
        boolean encontrou = false;
        for(Pessoa aux: listNome)
        {
            if(aux.getNome() == nome)
            {
                encontrou = true;
                break;
            }
        }
        if(encontrou)
        {
            System.out.println("Operacao invalida - Pessoa ja esta cadastrada");
        }
        else{
            Aluno novo = new Aluno(nome, livros, sus, susD);
            listNome.add(novo);
        }
    }
    
    public void adicionaComunidade(String nome, int livros, boolean sus, int susD)
    {   
        boolean encontrou = false;
        for(Pessoa aux: listNome)
        {
            if(aux.getNome() == nome)
            {
                encontrou = true;
                break;
            }
        }
        if(encontrou)
        {
            System.out.println("Operacao invalida - Pessoa ja esta cadastrada");
        }
        else{
            Comunidade novo = new Comunidade(nome, livros, sus, susD);
            listNome.add(novo);
        }
    }
    
    public boolean emprestarLivro(String nomePessoa, String nomeLivro)
    {
        Pessoa Pessoa = null;
        Livro Livro = null;
        
        for (Pessoa aux : listNome)
        {
            if(aux.getNome().equals(nomePessoa))
            {
                Pessoa = aux;
                break;
            }
        }
        if(Pessoa == null){
            System.out.println("Nome da pessoa nao encontrada");
            return false;
        }
        
        for (Livro aux : listLivros)
        {
            if(aux.getNome().equals(nomeLivro))
            {
                Livro = aux;
                break;
            }
        }
        if(Livro == null){
            System.out.println("Titulo do livro nao encontrado");
            return false;
        }
        
       
        if(Pessoa.getNumeroDeLivros() < Pessoa.getNumeroDeLivrosMax() && !Pessoa.getSuspenso())
        {
            if(Pessoa.getNumeroDeLivrosMax() == 2 && Livro.getText())
            {
                System.out.println("Operacao falhou - Comunidade nao pode ter livros texto");
                return false;
            }
            else
            {
                if(Livro.getEmpr())
                {
                    System.out.println("Operacao falhou - Livro ja foi emprestado");
                    return false;
                }
                else
                {
                    Livro.setEmprestado(true);
                    Livro.setDias(Pessoa.getlimiteDias());
                    Pessoa.setNumeroDeLivros(Pessoa.getNumeroDeLivros() + 1);
                    Livro.setAtualDono(Pessoa.getNome());
                    System.out.println("Livro emprestado com sucesso");
                    return true;
                }

            }

        }
        else
        {
            if(Pessoa.getSuspenso())
                System.out.println("Operacao falhou - Pessoa suspensa");
            else
                System.out.println("Operacao falhou - Tentativa de exceder o numero maximo de livros emprestados");
            
            return false;
        }            
        
    }
    
    public void numeroAtualDeLivros(String Nome)
    {
        Pessoa pessoa = null;
        
        for(Pessoa aux : this.listNome)
        {
            if(aux.getNome().equals(Nome))
            {
                pessoa = aux;
                break;
            }
        }
        
        if(pessoa == null)
        {
            return;
        }
        
        System.out.println("O usuario pode ter no maximo " + pessoa.getNumeroDeLivrosMax() + " livros");
        System.out.println("Atualmente ele tem " + pessoa.getNumeroDeLivros() + " livros");
    }
    
    
    public boolean devolverLivro(String nomePessoa, String nomeLivro)
    {
        Pessoa Pessoa = null;
        Livro Livro = null;
        
        for (Pessoa aux : listNome)
        {
            if(aux.getNome().equals(nomePessoa))
            {
                Pessoa = aux;
                break;
            }
        }
        
        for (Livro aux : listLivros)
        {
            if(aux.getNome().equals(nomeLivro) && Pessoa.getNome().equals(aux.getAtualDono()))
            {
                Livro = aux;
                break;
            }
        }
        
        if (Pessoa != null && Livro != null)
        {
            String nulo = null;
            Pessoa.setNumeroDeLivros(Pessoa.getNumeroDeLivros() - 1);
            if(Livro.getDias() < 0)
            {
                Pessoa.setDiasDeSuspensao(Pessoa.getDiasDeSuspensao() + (Livro.getDias() * -1));
            }
            Livro.setAtualDono(nulo);
            Livro.setDias(0);
            Livro.setEmprestado(false);
            System.out.println("Livro devolvido com sucesso");
            return true;
            
                
        }
        else
        {
            System.out.println("Operacao falhou - nome invalido");
            return false;
        }
        
        
    }
    
    public void PegarLivrosDoDono(String Dono)
    {
        System.out.println("Os possiveis livros a serem retirados sao: ");
        
        for(Livro aux : this.listLivros)
        {
            if(aux.getAtualDono() != null && aux.getAtualDono().equals(Dono))
            {
                System.out.println(aux.getNome() + " - " + aux.getDias() + " dias restantes");
            }
        }
    }
    
    
    public static void ordenaListaNome()
    {
        
        Collections.sort(listNome, new Comparator<Pessoa>(){

        public int compare(Pessoa o1, Pessoa o2) {
            String s1 = o1.getNome();
            String s2 = o2.getNome();
            if(s1.compareTo(s2) == 0)
            {
                return 0;
            }
            else if(s1.compareTo(s2) > 0)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
            
        });
    }
    
    
    public static void ordenaListaLivro()
    {
        
        Collections.sort(listLivros, new Comparator<Livro>(){

        public int compare(Livro o1, Livro o2) {
            String s1 = o1.getNome();
            String s2 = o2.getNome();
            if(s1.compareTo(s2) == 0)
            {
                return 0;
            }
            else if(s1.compareTo(s2) > 0)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
            
        });
    }
    
    
    
    public void imprimeDatas()
    {
        System.out.println("Data antiga: ");
        System.out.println(this.diaAntigo + "/" + this.mesAntigo + "/" + this.anoAntigo);
        
        System.out.println("Data atual: ");
        System.out.println(this.diaAtual + "/" + this.mesAtual + "/" + this.anoAtual);
        System.out.println();
        
        //System.out.println(this.calendarioN.compareTo(calendarioV));

    }
    
    
    
    public void preparaListaNome(String listaPessoa)
    {
        try 
        {
		BufferedReader in = new BufferedReader(new FileReader(listaPessoa));
		String pessoa;
                
		while((pessoa = in.readLine()) != null) 
                    
                {
                    String[] values = pessoa.split(",");
                    if(Integer.parseInt(values[0]) == 0)
                    {
                        listNome.add(new Professor(values[1], Integer.parseInt(values[2]), Boolean.parseBoolean(values[3]), Integer.parseInt(values[4])));
                    }
                    
                    if(Integer.parseInt(values[0]) == 1)
                    {
                        listNome.add(new Aluno(values[1], Integer.parseInt(values[2]), Boolean.parseBoolean(values[3]), Integer.parseInt(values[4])));
                    }
                    
                    if(Integer.parseInt(values[0]) == 2)
                    {
                        listNome.add(new Comunidade(values[1], Integer.parseInt(values[2]), Boolean.parseBoolean(values[3]), Integer.parseInt(values[4])));
                    }
		}
	}
        
	catch(FileNotFoundException e) 
        {
		System.out.println("File " + listaPessoa + " was not found!");
	}
        
	catch(IOException e) 
        {
		System.out.println("Error reading the file!");
	}
    }
    
    public void preparaListaLivro(String listaLivro)
    {
        try 
        {
		BufferedReader in = new BufferedReader(new FileReader(listaLivro));
		String livro;
                
		while((livro = in.readLine()) != null) 
                    
                {
                    String[] values = livro.split(",");
                    listLivros.add(new Livro(values[0], Boolean.parseBoolean(values[1]), Integer.parseInt(values[2]), Boolean.parseBoolean(values[3]), values[4]));
		}
	}
        
	catch(FileNotFoundException e) 
        {
		System.out.println("File " + listaLivro + " was not found!");
	}
        
	catch(IOException e) 
        {
		System.out.println("Error reading the file!");
	}
    }
    
    public void preparaDataAntiga(String data)
    {
        try 
        {
		BufferedReader in = new BufferedReader(new FileReader(data));
		String date;
                
		while((date = in.readLine()) != null)    
                {
                    String[] values = date.split(",");
                    this.diaAntigo = Integer.parseInt(values[0]);
                    this.mesAntigo = Integer.parseInt(values[1]);
                    this.anoAntigo = Integer.parseInt(values[2]);
                    this.calendarioV.set(this.anoAntigo, this.mesAntigo, this.diaAntigo);
		}
	}
        
	catch(FileNotFoundException e) 
        {
		System.out.println("File " + data + " was not found!");
	}
        
	catch(IOException e) 
        {
		System.out.println("Error reading the file!");
	}
    }
    
    public void preparaDataAtual()
    {
        //calendarioN.set(MONTH, MONTH+1);
        this.diaAtual = calendarioN.get(DATE);
        this.mesAtual = calendarioN.get(MONTH) + 1;
        this.anoAtual = calendarioN.get(YEAR);
        calendarioN.set(MONTH, this.mesAtual);
        
    }
    
    public int calculaDiferenca()
    {
        if(this.calendarioN.compareTo(this.calendarioV) == 0)
        {
            return 0;
        }
        else
        {
            this.diferencaDias = ((this.anoAtual - this.anoAntigo) * 365);
            if(this.mesAtual < this.mesAntigo)
            {
                this.diferencaDias += (this.mesAntigo - this.mesAtual) * 30;
            }
            else
            {
                if(this.diferencaDias == 0)
                {
                    this.diferencaDias += (this.mesAtual - this.mesAntigo) * 30;
                }
                else
                {
                    this.diferencaDias -= (this.mesAtual - this.mesAntigo) * 30;
                }
                
            }
            
            if(this.diaAtual < this.diaAntigo)
            {
                this.diferencaDias += (this.diaAntigo - this.diaAtual);
            }
            else
            {
                if((this.mesAtual - this.mesAntigo) == 0)
                {
                    this.diferencaDias += (this.diaAtual - this.diaAntigo);
                }
                else
                {
                    this.diferencaDias -= (this.diaAtual - this.diaAntigo);
                }
                
            }
            
            System.out.println(this.diferencaDias);
            return this.diferencaDias;
        }
    }
    
    
    public void atualizaDias(int a)
    {
        int teste;
        
        
        
        
        for(Pessoa aux : listNome)
        {
            if(aux.getSuspenso())
            {
                teste = aux.getDiasDeSuspensao() - a;
                if(teste <= 0)
                {
                    aux.setSuspenso(false);
                    aux.setDiasDeSuspensao(0);
                }
                else
                {
                    aux.setDiasDeSuspensao(teste);
                }
            }
        }
        
        
        
        
        
        
        
        for(Livro aux : listLivros)
        {
            if(aux.getEmpr())
            {
                teste = aux.getDias() - a;
                if(teste < 0)
                {
                    for(Pessoa aux2 : listNome)
                    {
                        if(aux.getAtualDono() != null && aux.getAtualDono().equals(aux2.getNome()))
                        {
                            aux2.setSuspenso(true);
                        }
                    }
                    aux.setDias(teste);
                }
                else
                {
                    aux.setDias(teste);
                }
            }
        }
        
    }
    
    
    public Funcionalidades (String listaPessoa, String listaLivro, String data) 
    {
        int dif;
        Scanner novo = new Scanner(System.in);
        System.out.println("Digite o código da língua e do país: ");
        this.lang = novo.nextLine();
        this.country = novo.nextLine();
        if(this.lang.length() != 2 || this.country.length() != 2)
        {
            currentLocale = new Locale("en", "US");
        }
        else
        {
            currentLocale = new Locale(lang, country);
        }
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        System.out.println(messages.getString("oi"));
        
        this.preparaListaNome(listaPessoa);
        this.preparaListaLivro(listaLivro);
        this.preparaDataAntiga(data);
        this.preparaDataAtual();
        dif = this.calculaDiferenca();
        this.atualizaDias(dif);
        
        
        
    }
    
    
    
    public void imprimeLivros()
    {
        for(Livro aux : listLivros)  
        {
            System.out.println("|-----------------------------|");
            System.out.println("Titulo: " + aux.getNome());
            System.out.println("Emprestado: " + aux.getEmpr());
            System.out.println("Dias para o livro chegar: " + aux.getDias()); 
            System.out.println("Tipo texto: " + aux.getText()); 
            System.out.println("Livro com: " + aux.getAtualDono());
            System.out.println("|-----------------------------|");
            System.out.println();
        }
        
    }
    
    public void imprimePessoas()
    {
        for(Pessoa aux : listNome)  
        {
            System.out.println("|-----------------------------------|");
            System.out.println("Nome: " + aux.getNome());  
            System.out.println("Numero maximo de livros: " + aux.getNumeroDeLivrosMax()); 
            System.out.println("Numero de livros com a pessoa: " + aux.getNumeroDeLivros());
            System.out.println("Suspenso: " + aux.getSuspenso());
            System.out.println("Dias de suspenso: " +aux.getDiasDeSuspensao());
            System.out.println("|-----------------------------------|");
            System.out.println();
        }
        
    }
    
    public void fechaArquivo(String a, String b, String c) throws IOException
    {
        
        FileWriter arq = new FileWriter(a);
        PrintWriter pw = new PrintWriter(arq);
        int x;
        
        for(Pessoa aux : this.listNome)
        {
            
            x =  aux.getNumeroDeLivrosMax();
            if(x == 6)
                x = 0;
            else if(x == 4)
                x = 1;
            
            pw.print(x + "," + aux.getNome() + "," + aux.getNumeroDeLivros() + "," + aux.getSuspenso() + "," + aux.getDiasDeSuspensao() + "\n");
        }
           
       arq.close();
       
       FileWriter arq2 = new FileWriter(b);
       PrintWriter pw2 = new PrintWriter(arq2);
       
       for(Livro aux : this.listLivros)
       {
           pw2.print(aux.getNome() + "," + aux.getEmpr() + "," + aux.getDias() + "," + aux.getText() + "," + aux.getAtualDono() + "\n");
           
       
       }
       
       arq2.close();
       
       
       FileWriter arq3 = new FileWriter(c);
       PrintWriter pw3 = new PrintWriter(arq3);
       
       
           pw3.print(this.diaAtual + "," + this.mesAtual + "," + this.anoAtual + "\n");
           
       
       
       
       arq3.close();
       
    }
    
    public final void limpaTela()
    {
        int i;
        for(i = 0; i < 50; ++i)
        {
            System.out.println();
        }
    }
    
}
