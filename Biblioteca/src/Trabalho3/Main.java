package Trabalho3;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main 
{
    public static void main(String args[]) throws IOException, URISyntaxException
    {
        boolean readMode = false; //variavel usada para evitar que o usuário faca alteracoes no passado
        ResourceBundle messages;
        int escolha = 0;
        int escolha2 = 0;
        String str, str2, str3, str4;
        int ano;
        int id;
        boolean correto;
        
        Scanner s = new Scanner(System.in);
        Scanner t = new Scanner(System.in);
        Scanner u = new Scanner(System.in);

        String a = "listaPessoa.csv";
        String b = "listaLivro.csv";
        String c = "data.csv";
        String d = "historico.csv";
        
        Funcionalidades biblioteca = new Funcionalidades(a, b, c, d); 
        boolean ciclo = true;
        messages = biblioteca.getMessages();
        readMode = biblioteca.getReadOnly();
        if(readMode == true)
        {
            System.out.println(messages.getString("readonly1"));
            System.out.println(messages.getString("readonly2"));
        }

        while (ciclo)
        {
            
           
                System.out.println(messages.getString("choose1"));//escolha um item:
                System.out.println(messages.getString("1pessoa"));
                System.out.println(messages.getString("2livro"));
                System.out.println(messages.getString("3data"));
                System.out.println(messages.getString("4historico"));
                System.out.println(messages.getString("5fechar"));

                //caso o usuario nao escolha um inteiro como opcao, estamos tratando isso aqui
                if(s.hasNextInt())
                {                    
                    escolha = s.nextInt();
                    if(escolha == 42)
                    {
                        System.out.println("The Answer to the Ultimate Question of Life, The Universe, and Everything.");
                        if(Desktop.isDesktopSupported())
                        {
                             Desktop.getDesktop().browse(new URI("http://en.wikipedia.org/wiki/Phrases_from_The_Hitchhiker%27s_Guide_to_the_Galaxy#Answer_to_the_Ultimate_Question_of_Life.2C_the_Universe.2C_and_Everything_.2842.29"));
                        }
                    }
                }
                else
                {
                    str = s.nextLine();
                    escolha = 10;
                    if(str.equals("tutturu"))
                    {
                        System.out.println("tutturu!");
                        if(Desktop.isDesktopSupported())
                        {
                             Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=CgouXrkye20"));
                        }
                    }
                    
                }

            
                switch (escolha)
                {
                    case 1://pessoa
                        System.out.println(messages.getString("11p"));//inserir
                        System.out.println(messages.getString("12o"));//ordenar
                        System.out.println(messages.getString("13p"));//imprimir
                        System.out.println(messages.getString("14r"));//remover
                        System.out.println(messages.getString("15l"));//livros com a pessoa
                        System.out.println(messages.getString("16v"));//voltar
                        
                        //caso o usuario nao escolha um inteiro, estamos tratando isso aqui
                        if(s.hasNextInt())
                        {
                            escolha = s.nextInt();
                        }
                        else
                        {
                            str = s.nextLine();
                            escolha = 10;
                        }
                        switch (escolha)
                        {
                             case 1://inserir
                                System.out.println(messages.getString("111p"));
                                System.out.println(messages.getString("112a"));
                                System.out.println(messages.getString("113c"));
                                while(!s.hasNextInt())
                                {
                                    str = s.nextLine();
                                }
                                escolha2 = s.nextInt(); //professor, aluno ou comunidade?
                                System.out.println(messages.getString("1111d"));
                                str = u.nextLine(); //nome
                                
                                System.out.println(messages.getString("1111id"));
                                while(!t.hasNextInt())
                                {
                                    str = t.nextLine();
                                }
                                id = t.nextInt(); //id
                                System.out.println(messages.getString("1111i"));
                                while(!t.hasNextInt())
                                {
                                    str = t.nextLine();
                                }
                                ano = t.nextInt(); //idade
                                
                                System.out.println(messages.getString("1111s"));
                                str2 = s.nextLine(); //sonhos
                                str2 = s.nextLine();
                                
                                if(escolha2 == 1)//professor
                                {
                                    biblioteca.adicionaProfessor(str, 0, false, 0, ano, str2, id);
                                }
                                else if(escolha2 == 2)//aluno
                                {
                                    biblioteca.adicionaAluno(str, 0, false, 0, ano, str2, id);
                                }
                                else if(escolha2 == 3)//comunidade
                                {
                                    biblioteca.adicionaComunidade(str, 0, false, 0, ano, str2, id);
                                }

                                System.out.println(messages.getString("pics1"));
                                System.out.println();

                                break;

                             case 2://ordenar

                                 biblioteca.ordenaListaNome();
                                 System.out.println(messages.getString("lno1"));
                                 System.out.println();
                                 break;

                             case 3://imprimir

                                 biblioteca.imprimePessoas();

                                 break;

                             case 4://remover
                                 System.out.println(messages.getString("dnpr1"));
                                 ano = t.nextInt();

                                 correto = biblioteca.removePessoa(ano);
                                 if(correto)
                                 {
                                     System.out.println(messages.getString("prcs1"));
                                 }
                                 else
                                 {
                                     System.out.println(messages.getString("err1"));
                                 }

                                 System.out.println();
                                 break;

                             case 5://livros com a pessoa
                                 System.out.println(messages.getString("dnp1"));
                                 id = t.nextInt();
                                 biblioteca.consultaLivros(id);
                                 
                                 break;

                             case 6://voltar 
                                 break;
                                 
                             default://mensagem em caso do usuario nao escolher uma opcao valida
                                 System.out.println(messages.getString("eegg"));
                                 break;
                        }
                        break;

                    case 2://livro
                        System.out.println(messages.getString("21i"));//adiciona
                        System.out.println(messages.getString("22o"));//ordena
                        System.out.println(messages.getString("23i"));//imprime
                        System.out.println(messages.getString("24e"));//empresta
                        System.out.println(messages.getString("25r"));//recebe
                        System.out.println(messages.getString("26r"));//remove
                        System.out.println(messages.getString("27l"));//informacoes sobre o livro
                        System.out.println(messages.getString("28v"));//voltar
                        
                        //caso o usuario nao escolha um inteiro, estamos tratando isso aqui
                        if(s.hasNextInt())
                        {
                            escolha = s.nextInt();
                        }
                        else
                        {
                            str = s.nextLine();
                            escolha = 10;
                        }
                        switch (escolha)
                        {
                             case 1://adiciona
                                 System.out.println(messages.getString("dtl1"));

                                 str = u.nextLine();//titulo
                                 
                                 System.out.println(messages.getString("autorP"));
                                 str2 = u.nextLine();//autor
                                 
                                 System.out.println(messages.getString("editoraP"));
                                 str3 = u.nextLine();//editora
                                 
                                 System.out.println(messages.getString("anoP"));
                                 while(!s.hasNextInt())
                                 {
                                     str4 = s.nextLine();
                                 }                                     
                                 ano = s.nextInt();//ano

                                 System.out.println(messages.getString("tl"));
                                 System.out.println(messages.getString("tl1"));
                                 System.out.println(messages.getString("tl2"));
                                 while(!s.hasNextInt())
                                 {
                                     str4 = s.nextLine();
                                 }
                                 escolha = s.nextInt(); //texto ou geral?
                                 
                                 
                                 str4 = null;
                                 
                                 if(escolha == 1)//texto
                                    biblioteca.adicionaLivro(str, false, 0, true, str4, str2, str3, ano);
                                 else//geral 
                                    biblioteca.adicionaLivro(str, false, 0, false, str4, str2, str3, ano);

                                 System.out.println();
                                 break;

                             case 2://ordena

                                 biblioteca.ordenaListaLivro();
                                 System.out.println(messages.getString("lvos1"));
                                 System.out.println();
                                 break;

                             case 3://imprime

                                 biblioteca.imprimeLivros();

                                 break;


                             case 4://empresta

                                 System.out.println(messages.getString("dnp1"));
                                 while(!t.hasNextInt())
                                 {
                                     str4 = t.nextLine();
                                 }
                                 id = t.nextInt(); //id

                                 biblioteca.numeroAtualDeLivros(id);

                                 System.out.println(messages.getString("dtl2"));
                                 str2 = t.nextLine(); //titulo do livro
                                 str2 = t.nextLine();

                                 biblioteca.emprestarLivro(id, str2);
                                 System.out.println();
                                 break;


                             case 5: //receber

                                 System.out.println(messages.getString("dnp2"));
                                 while(!t.hasNextInt())
                                 {
                                     str4 = t.nextLine();
                                 }
                                 id = t.nextInt(); //id da pessoa

                                 biblioteca.PegarLivrosDoDono(id);

                                 System.out.println(messages.getString("dtl3"));
                                 str2 = u.nextLine(); //titulo do livro

                                 biblioteca.devolverLivro(id, str2);
                                 System.out.println();

                                 break;

                             case 6: //remover
                                 System.out.println(messages.getString("dtlr1"));
                                 str = t.nextLine(); //titulo do livro

                                 correto = biblioteca.removeLivro(str);
                                 if(correto) //mensagem de livro removido
                                 {
                                     System.out.println(messages.getString("lrcs1"));
                                 }
                                 else //mensagem de livro nao removido
                                 {
                                     System.out.println(messages.getString("err2"));
                                 }

                                 System.out.println();
                                 break;
                                 
                             case 7: //informacoes do livro
                                 biblioteca.verInfoLivrosEmprestados();

                             case 8: //voltar
                                 break;

                             default:
                                 System.out.println(messages.getString("eegg"));
                                 break;
                        }
                        break;

                    case 3: //datas
                        biblioteca.imprimeDatas();
                        System.out.println();
                        break; 

                    case 4: //historico
                        System.out.println(messages.getString("ih1"));
                        biblioteca.imprimeHistorico();
                        break;
                        
                    case 5: //sair
                        ciclo = false;
                        break;
                        
                    default: //mensagem de erro, por nao selecionar um opcao valida
                        
                        System.out.println(messages.getString("eegg"));
                        
                        break;
                } 
            
            }
    
        //fecha os arquivos
        biblioteca.fechaArquivo(a, b, c, d);
    
    }
}
