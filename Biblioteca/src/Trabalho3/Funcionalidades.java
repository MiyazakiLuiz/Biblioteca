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
    private static ArrayList<Historico> listHistorico = new ArrayList<Historico>();
    
    private boolean readOnly = false;
    private String lang;
    private String country;
    
    private Locale currentLocale;
    
    private ResourceBundle messages;
    
    private Calendar calendarioN = Calendar.getInstance();
    
    private Calendar calendarioV = Calendar.getInstance();
    
    private int diaAtual;
    private int mesAtual;
    private int anoAtual;
    
    private int diaAntigo;
    private int mesAntigo;
    private int anoAntigo;
    
    private int diferencaDias = 0;
    
    // ReadOnly é uma flag que impossibilita algumas funcoes, caso
    //o usuario tente fazer modificacoes no passado.
    public boolean getReadOnly()
    {
        return this.readOnly;
    }
    
    // Isso serve para utilizar o locale
    public ResourceBundle getMessages()
    {
        return this.messages;
    }
    
    /* 
    Tira uma pessoa da listNome e ao fechar o programa
    é salvo a lista sem essa pessoa em um arquivo
    input: id da pessoa
    output: boolean, se remover true, se nao false.
    */
    public boolean removePessoa(int a)
    {
        if(this.readOnly == true)
        {
            System.out.println(messages.getString("readonly"));
            return false;
        }
        String str;
        Pessoa rem = null;
        Livro rem2 = null;
        
        for(Pessoa aux : listNome)
        {
            if (a == aux.getId())
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
    
    /* 
    Tira um livro da listLivros e ao fechar o programa
    é salvo a lista sem esse livro em um arquivo
    input: titulo do livro
    output: boolean, se remover true, se nao false.
    */
    public boolean removeLivro(String a)
    {
        if(this.readOnly == true)
        {
            System.out.println(messages.getString("readonly"));
            return false;
        }
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
    
    /* 
    Adiciona um livro da listLivros e ao fechar o programa
    é salvo a lista com esse livro em um arquivo
    input: titulo do livro, false(indicando que nao esta emprestado), 
    (dias para devolver), texto(true) ou geral(false), nome do dono(null, inicialmente),
    nome do autor, nome da editora e o ano do livro.
    */
    public void adicionaLivro(String nome, boolean empr, int diasParaDevolver, boolean text, String dono, String autor, String editora, int ano)
    {
        if(this.readOnly == true)
        {
            System.out.println(messages.getString("readonly"));
            return;
        }
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
            System.out.println(messages.getString("a2oplje"));
        }
        else{
            Livro novo = new Livro(nome, empr, diasParaDevolver, text, dono, autor, editora, ano);
            listLivros.add(novo);
            System.out.println(messages.getString("a2las1"));    
        }
    } 
    
    /* 
    Adiciona um professor da listNome e ao fechar o programa
    é salvo a lista com esse professor em um arquivo
    input: nome da pessoa, quantidade de livros(6), nao suspenso(false), 
    dias de suspensao, idade, sonhos e id 
    */
    public void adicionaProfessor(String nome, int livros, boolean sus, int susD, int idade, String sonho, int id)
    {
        if(this.readOnly == true)
        {
            System.out.println(messages.getString("readonly"));
            return;
        }
        boolean encontrou = false;
        for(Pessoa aux: listNome)
        {
            if(aux.getId() == id)
            {
                encontrou = true;
                break;
            }
        }
        if(encontrou)
        {
            System.out.println(messages.getString("a2pec"));
        }
        else{
            Professor novo = new Professor(nome, livros, sus, susD, idade, sonho, id);
            listNome.add(novo);
        }
    }
    
    /* 
    Adiciona um aluno da listNome e ao fechar o programa
    é salvo a lista com esse aluno em um arquivo
    input: nome da pessoa, quantidade de livros(4), nao suspenso(false), 
    dias de suspensao, idade, sonhos e id
    */
    public void adicionaAluno(String nome, int livros, boolean sus, int susD, int idade, String sonho, int id)
    {
        if(this.readOnly == true)
        {
            System.out.println(messages.getString("readonly"));
            return;
        }
        boolean encontrou = false;
        for(Pessoa aux: listNome)
        {
            if(aux.getId() == id)
            {
                encontrou = true;
                break;
            }
        }
        if(encontrou)
        {
            System.out.println(messages.getString("a2pec"));
        }
        else{
            Aluno novo = new Aluno(nome, livros, sus, susD, idade, sonho, id);
            listNome.add(novo);
        }
    }
    
    /* 
    Adiciona um comunidade da listNome e ao fechar o programa
    é salvo a lista com esse comunidade em um arquivo
    input: nome da pessoa, quantidade de livros(2), nao suspenso(false), 
    dias de suspensao, idade, sonhos e id
    */
    public void adicionaComunidade(String nome, int livros, boolean sus, int susD, int idade, String sonho, int id)
    {   
        if(this.readOnly == true)
        {
            System.out.println(messages.getString("readonly"));
            return;
        }
        boolean encontrou = false;
        for(Pessoa aux: listNome)
        {
            if(aux.getId() == id)
            {
                encontrou = true;
                break;
            }
        }
        if(encontrou)
        {
            System.out.println(messages.getString("a2pec"));
        }
        else{
            Comunidade novo = new Comunidade(nome, livros, sus, susD, idade, sonho, id);
            listNome.add(novo);
        }
    }
    
    /*
    Marca um livro como emprestado, com quem esta e incrementa a quantidade de livros com a pessoa que o pegou
    input: id da pessoa e o nome do livro
    output: emprestou(true), nao emprestou(false)
    */
    public boolean emprestarLivro(int id, String nomeLivro)
    {
        if(this.readOnly == true)
        {
            System.out.println(messages.getString("readonly"));
            return false;
        }
        Pessoa Pessoa = null;
        Livro Livro = null;
        
        for (Pessoa aux : listNome)
        {
            if(aux.getId() == id)
            {
                Pessoa = aux;
                break;
            }
        }
        if(Pessoa == null){
            System.out.println(messages.getString("a2nne"));
            return false;
        }
        
        for (Livro aux : listLivros)
        {
            if(aux.getNome().equals(nomeLivro))
            {
                Livro = aux;
                if(Livro.getEmpr() != true)
                {
                    break;   
                }
            }
        }
        if(Livro == null){
            System.out.println(messages.getString("a2tne"));
            return false;
        }
        
       
        if(Pessoa.getNumeroDeLivros() < Pessoa.getNumeroDeLivrosMax() && !Pessoa.getSuspenso())
        {
            if(Pessoa.getNumeroDeLivrosMax() == 2 && Livro.getText())
            {
                System.out.println(messages.getString("a2cnlt"));
                return false;
            }
            else
            {
                if(Livro.getEmpr())
                {
                    System.out.println(messages.getString("a2lje"));
                    return false;
                }
                else
                {
                    Livro.setEmprestado(true);
                    Livro.setDias(Pessoa.getlimiteDias());
                    Pessoa.setNumeroDeLivros(Pessoa.getNumeroDeLivros() + 1);
                    Livro.setAtualDono(Pessoa.getNome());
                    System.out.println(messages.getString("a2les"));
                    this.listHistorico.add(new Historico(this.diaAtual, this.mesAtual, this.anoAtual, 0, 0, 0, Pessoa.getNome(), Livro.getNome()));
                    return true;
                }

            }

        }
        else
        {
            if(Pessoa.getSuspenso())
                System.out.println(messages.getString("a2ps"));
            else
                System.out.println(messages.getString("a2ten"));
            
            return false;
        }            
        
    }
    
    /*
    Imprime uma mensagem indicando a quantidade maxima de livros que a pessoa pode ter
    e outra mensagem indicando a quantidade de livros que ela tem emprestado
    input: id da pessoa
    */
    public void numeroAtualDeLivros(int id)
    {
        Pessoa pessoa = null;
        
        for(Pessoa aux : this.listNome)
        {
            if(aux.getId() == id)
            {
                pessoa = aux;
                break;
            }
        }
        
        if(pessoa == null)
        {
            return;
        }
        
        System.out.println(messages.getString("a2upnm1") + pessoa.getNumeroDeLivrosMax() + " " + messages.getString("a2upnm2"));
        System.out.println(messages.getString("a2upnm3") + pessoa.getNumeroDeLivros() + " " + messages.getString("a2upnm2") + "\n");
    }
    
    /*
    Imprime os livros que estao com determinada pessoa
    input: ID da pessoa
    */
    public void consultaLivros(int id)
    {
        boolean c = false;
        String nomePessoa = null;
        System.out.println(messages.getString("livrosqueapessoatem"));
        
        for(Pessoa aux : listNome)
        {
            if(aux.getId() == id)
            {
                nomePessoa = aux.getNome();
            }
        }
        
        if(nomePessoa == null)
        {
            return;
        }
      
        for(Livro aux: this.listLivros)
        {
            if(aux.getAtualDono() != null && aux.getAtualDono().equals(nomePessoa))
            {
                System.out.println("> " + aux.getNome() + messages.getString("diasrestantes") + aux.getDias());
                c = true;
            }
        }
       
        if(!c)
            System.out.println("-");
       
        System.out.println();
    }
    
    /*
    Devolve o livro para a biblioteca, muda as variaveis de emprestimo do livro
    Emprestado para false, AtualDono para null e DiasRestante  para 0
    input: ID da pessoa e o nome do livro
    output: devolvido(true), nao devolvido(false)
    */
    public boolean devolverLivro(int id, String nomeLivro)
    {
        if(this.readOnly == true)
        {
            System.out.println(messages.getString("readonly"));
            return false;
        }
        Pessoa Pessoa = null;
        Livro Livro = null;
        
        for (Pessoa aux : listNome)
        {
            if(aux.getId() == id)
            {
                Pessoa = aux;
                break;
            }
        }
        
        for (Livro aux : listLivros)
        {
            if(aux.getNome().equals(nomeLivro) && aux.getAtualDono() != null && Pessoa.getNome().equals(aux.getAtualDono()))
            {
                Livro = aux;
                if(Livro.getEmpr() == true)
                {
                    break;
                }
                
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
            
            for(Historico aux : listHistorico)
            {
                if(aux.getDono().equals(Pessoa.getNome()) && aux.getLivro().equals(Livro.getNome()))
                {
                    aux.setDia(this.diaAtual);
                    aux.setMes(this.mesAtual);
                    aux.setAno(this.anoAtual);
                }
            }
            
            
            System.out.println("\n" + messages.getString("a2lds"));
            
            
            
            return true;
            
                
        }
        else
        {
            System.out.println(messages.getString("a2ni"));
            return false;
        }
        
        
    }
    
    /*
    Imprime os livros que estao com determinada pessoa
    input: ID da pessoa 
    */
    public void PegarLivrosDoDono(int id)
    {
        String Dono = "nullo";
       
        for(Pessoa aux : listNome)
        {
            if(aux.getId() == id)
            {
                Dono = aux.getNome();
                break;
            }
        }
       
        if(Dono.equals("nullo"))
        {
            return;
        }
        
        System.out.println(messages.getString("a2oplsr"));
        
        for(Livro aux : this.listLivros)
        {
            if(aux.getAtualDono() != null && aux.getAtualDono().equals(Dono))
            {
                System.out.println(aux.getNome() + " - " + aux.getDias() + " " + messages.getString("a2dr"));
            }
        }
    }
    
    /*
    ordena a lista de pessoas por ordem alfabetica(tabela ascii) dos nomes
    */
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
    
    /*
    ordena a lista de livros por ordem alfabetica(tabela ascii) dos titulos 
    */
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
    
    /*
    Imprime a data que esta no arquivo(ultima data de modificacoes) e, a data atual ou de consulta
    */
    public void imprimeDatas()
    {
        System.out.println(messages.getString("a2data1"));
        System.out.println(this.diaAntigo + "/" + this.mesAntigo + "/" + this.anoAntigo);
        
        System.out.println(messages.getString("a2data2"));
        System.out.println(this.diaAtual + "/" + this.mesAtual + "/" + this.anoAtual);
        System.out.println();
        
        //System.out.println(this.calendarioN.compareTo(calendarioV));

    }
    
    /*
    imprime um historico indicando a data de quando uma pessoa pegou um livro 
    e quando ela devolveu
    */
    public void imprimeHistorico()
    {

        for(Historico aux : listHistorico)
        {
           if(this.calendarioN.compareTo(aux.getCalendarA()) > 0 || (this.diaAtual == aux.getDiaA() && this.mesAtual == aux.getMesA() && this.anoAtual == aux.getAnoA()))
           {
                System.out.println(messages.getString("ih2") + aux.getDiaA() + "/" + aux.getMesA() + "/" + aux.getAnoA());
                if(aux.getDiaN() == 0 && aux.getMesN() == 0 && aux.getAnoN() == 0)
                {
                    System.out.println(messages.getString("ih3") + " - ");
                }
                else
                {
                    if(this.calendarioN.compareTo(aux.getCalendarN()) < 0 && (this.diaAtual != aux.getDiaN() || this.mesAtual != aux.getMesN() || this.anoAtual != aux.getAnoN()))
                    {
                        System.out.println(messages.getString("ih3") + " - ");
                    }
                    else
                    {
                        System.out.println(messages.getString("ih3") + aux.getDiaN() + "/" + aux.getMesN() + "/" + aux.getAnoN());
                    }
                    
                }
                System.out.println(messages.getString("ih4") + aux.getDono());
                System.out.println(messages.getString("ih5") + aux.getLivro());
                System.out.println();
           }
        }
    }
    
    /*
    
    */
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
                        listNome.add(new Professor(values[1], Integer.parseInt(values[2]), Boolean.parseBoolean(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), values[6], Integer.parseInt(values[7])));
                    }
                    
                    if(Integer.parseInt(values[0]) == 1)
                    {
                        listNome.add(new Aluno(values[1], Integer.parseInt(values[2]), Boolean.parseBoolean(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), values[6], Integer.parseInt(values[7])));
                    }
                    
                    if(Integer.parseInt(values[0]) == 2)
                    {
                        listNome.add(new Comunidade(values[1], Integer.parseInt(values[2]), Boolean.parseBoolean(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), values[6], Integer.parseInt(values[7])));
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
    
    /*
    
    */
    public void preparaListaLivro(String listaLivro)
    {
        try 
        {
		BufferedReader in = new BufferedReader(new FileReader(listaLivro));
		String livro;
                
		while((livro = in.readLine()) != null) 
                    
                {
                    String[] values = livro.split(",");
                    listLivros.add(new Livro(values[0], Boolean.parseBoolean(values[1]), Integer.parseInt(values[2]), Boolean.parseBoolean(values[3]), values[4], values[5], values[6], Integer.parseInt(values[7])));
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
    
    /*
    
    */
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
    
    /*
    
    */
    public void preparaHistorico(String entregas_retornos)
    {
        Calendar calv = Calendar.getInstance();
        Calendar caln = Calendar.getInstance();
        try 
        {
		BufferedReader in = new BufferedReader(new FileReader(entregas_retornos));
		String historico;
                
		while((historico = in.readLine()) != null)   
                {
                    String[] values = historico.split(",");
                    /*calv.set(DATE, Integer.parseInt(values[0]));
                    calv.set(MONTH, Integer.parseInt(values[1]));
                    calv.set(YEAR, Integer.parseInt(values[2]));
                    caln.set(DATE, Integer.parseInt(values[3]));
                    caln.set(MONTH, Integer.parseInt(values[4]));
                    caln.set(YEAR, Integer.parseInt(values[5]));*/
                    listHistorico.add(new Historico(Integer.parseInt(values[0]), Integer.parseInt(values[1]),Integer.parseInt(values[2]), Integer.parseInt(values[3]),Integer.parseInt(values[4]), Integer.parseInt(values[5]),values[6], values[7]));
		}
	}
        
	catch(FileNotFoundException e) 
        {
		System.out.println("File " + entregas_retornos + " was not found!");
	}
        
	catch(IOException e) 
        {
		System.out.println("Error reading the file!");
	}
    }
    
    /*
    
    */
    public void preparaDataAtual()
    {
        //calendarioN.set(MONTH, MONTH+1);
        this.diaAtual = calendarioN.get(DATE);
        if(this.diaAtual == 31)
        {
            this.diaAtual = 30;
            calendarioN.set(DATE, 30);
        }
        this.mesAtual = calendarioN.get(MONTH) + 1;
        this.anoAtual = calendarioN.get(YEAR);
        calendarioN.set(MONTH, this.mesAtual);
        
    }
    
   /*
    informa por meio de mensagem, todos os livros que estao emprestados e com quem estao
    */
    public void verInfoLivrosEmprestados()
    {
        for(Livro aux : listLivros)
        {
            if(aux.getEmpr() == true)
            {
                System.out.println(aux.getNome());
                System.out.println(aux.getAtualDono());
                //this.calcDifLivros(aux.getDias());
            }
        }
    }
   
    /*
    funcao usada para calcular quantos dias tem entre a data do arquivo e a data atual
    output: inteiro indicando a diferenca de dias
    */
    public int calculaDiferenca()
    {
        this.diferencaDias += (this.anoAtual - this.anoAntigo) * 365;
        this.diferencaDias += (this.mesAtual - this.mesAntigo) * 30;
        this.diferencaDias += this.diaAtual - this.diaAntigo;
        //System.out.println(this.diferencaDias);
        return this.diferencaDias;
    }
    
    /*
    
    */
    public void atualizaDias(int a)
    {
        int teste;
        boolean c = false;
        
        System.out.println(messages.getString("livrosematraso"));
        
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
                    c = true;
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
        if(!c)
        {
            System.out.println(" - ");
        }
        
    }
    
    /*
    
    */
    public boolean digitaDias()
    {
        Scanner s = new Scanner(System.in);
        int valor = 0;
        System.out.println(messages.getString("escolhedia"));
        valor = s.nextInt();
        if(valor != 0 && valor > 0 && valor < 31)
        {
            this.diaAtual = valor;
            this.calendarioN.set(DATE, valor);
            valor = s.nextInt();
            if(valor != 0 && valor > 0 && valor < 13)
            {
                this.mesAtual = valor;
                this.calendarioN.set(MONTH, valor);
                valor = s.nextInt();
                if(valor != 0 && valor > 0)
                {
                    this.anoAtual = valor;
                    this.calendarioN.set(YEAR, valor);
                    return true;
                }
                
            }
            
        }
        return false;
            
    }
        
    
    /*
    
    */
    public Funcionalidades (String listaPessoa, String listaLivro, String data, String entregas_retornos) 
    {
        int dif;
        boolean teste;
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
        //System.out.println(messages.getString("oi"));
        
        this.preparaListaNome(listaPessoa);
        this.preparaListaLivro(listaLivro);
        this.preparaDataAntiga(data);
        this.preparaHistorico(entregas_retornos);
        teste = this.digitaDias();
        if(teste == false)
        {
            this.preparaDataAtual();
        }
        
        dif = this.calculaDiferenca();
        if(dif < 0)
        {
            this.readOnly = true;
        }
        else
        {
            this.atualizaDias(dif);
        }
        
        
        
        
        
    }
    
    
    /*
    Exibe na tela todos os livros que existem na biblioteca
    */
    public void imprimeLivros()
    {
        for(Livro aux : listLivros)  
        {
            System.out.println("|-----------------------------|");
            System.out.println(messages.getString("a2l1") + aux.getNome());
            System.out.println(messages.getString("a2l2") + aux.getAutor());
            System.out.println(messages.getString("a2l3") + aux.getEdtora());
            System.out.println(messages.getString("a2l4") + aux.getAno());
            System.out.println(messages.getString("a2l5") + aux.getEmpr());
            System.out.println(messages.getString("a2l6") + aux.getDias()); 
            System.out.println(messages.getString("a2l7") + aux.getText()); 
            System.out.println(messages.getString("a2l8") + aux.getAtualDono());
            System.out.println("|-----------------------------|");
            System.out.println();
        }
        
    }
    
    /*
    Exibe na tela todos as pessoas que existem no sistema
    */
    public void imprimePessoas()
    {
        for(Pessoa aux : listNome)  
        {
            System.out.println("|-----------------------------------|");
            System.out.println(messages.getString("a2p1") + aux.getNome());  
            System.out.println(messages.getString("a2p2") + aux.getId());
            System.out.println(messages.getString("a2p3") + aux.getIdade());
            System.out.println(messages.getString("a2p4") + aux.getSonho());
            System.out.println(messages.getString("a2p5") + aux.getNumeroDeLivrosMax()); 
            System.out.println(messages.getString("a2p6") + aux.getNumeroDeLivros());
            System.out.println(messages.getString("a2p7") + aux.getSuspenso());
            System.out.println(messages.getString("a2p8") +aux.getDiasDeSuspensao());
            System.out.println("|-----------------------------------|");
            System.out.println();
        }
        
    }
    
    /*
    salva as listas de livros e de pessoas, a nova data caso nao estiver no ReadOnly, o novo historico
    em arquivos e os fecha
    */
    public void fechaArquivo(String a, String b, String c, String d) throws IOException
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
            
            pw.print(x + "," + aux.getNome() + "," + aux.getNumeroDeLivros() + "," + aux.getSuspenso() + "," + aux.getDiasDeSuspensao() + "," + aux.getIdade() + "," + aux.getSonho() + "," + aux.getId() + "\n");
        }
           
       arq.close();
       
       FileWriter arq2 = new FileWriter(b);
       PrintWriter pw2 = new PrintWriter(arq2);
       
       for(Livro aux : this.listLivros)
       {
           pw2.print(aux.getNome() + "," + aux.getEmpr() + "," + aux.getDias() + "," + aux.getText() + "," + aux.getAtualDono() + "," + aux.getAutor() + "," + aux.getEdtora() + "," + aux.getAno() + "\n");
           
       
       }
       
       arq2.close();
       
       
       FileWriter arq3 = new FileWriter(c);
       PrintWriter pw3 = new PrintWriter(arq3);
       
       if(this.readOnly == false)
       {
           pw3.print(this.diaAtual + "," + this.mesAtual + "," + this.anoAtual + "\n");
       }
       else
       {
           pw3.print(this.diaAntigo + "," + this.mesAntigo + "," + this.anoAntigo + "\n");
       }
       

       
       arq3.close();
       
       
       FileWriter arq4 = new FileWriter(d);
       PrintWriter pw4 = new PrintWriter(arq4);
       
       for(Historico aux : this.listHistorico)
       {
           pw4.print(aux.getDiaA()+ "," + aux.getMesA() + "," + aux.getAnoA() + "," + aux.getDiaN() + "," + aux.getMesN() + "," + aux.getAnoN() + "," + aux.getDono() + "," + aux.getLivro()+ "\n");
       }
       
       arq4.close();
       
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
