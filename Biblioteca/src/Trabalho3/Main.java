package Trabalho3;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class Main 
{
    public static void main(String args[]) throws IOException, URISyntaxException
    {
        boolean readMode = false;
        ResourceBundle messages;
        int escolha = 1;
        String str, str2, str3, str4;
        int ano;
        int id;
        boolean correto;
        //String tutturu = "tutturu";
        
        Scanner s = new Scanner(System.in);
        Scanner t = new Scanner(System.in);

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
       // System.out.println(readMode);
        //System.out.println(messages.getString("oi"));
        

        while (ciclo)
        {
            
           
                System.out.println(messages.getString("choose1"));
                System.out.println(messages.getString("1pessoa"));
                System.out.println(messages.getString("2livro"));
                System.out.println(messages.getString("3data"));
                System.out.println(messages.getString("4historico"));
                System.out.println(messages.getString("5fechar"));

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
                    case 1:
                        System.out.println(messages.getString("11p"));
                        System.out.println(messages.getString("12o"));
                        System.out.println(messages.getString("13p"));
                        System.out.println(messages.getString("14r"));
                        System.out.println(messages.getString("15l"));
                        System.out.println(messages.getString("16v"));

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
                             case 1:
                                System.out.println(messages.getString("111p"));
                                System.out.println(messages.getString("112a"));
                                System.out.println(messages.getString("113c"));
                                escolha = s.nextInt();
                                System.out.println(messages.getString("1111d"));
                                str = t.nextLine();
                                System.out.println(messages.getString("1111id"));
                                id = t.nextInt();
                                System.out.println(messages.getString("1111i"));
                                ano = t.nextInt();
                                System.out.println(messages.getString("1111s"));
                                str2 = s.nextLine();
                                str2 = s.nextLine();
                                
                                if(escolha == 1)
                                {

                                    biblioteca.adicionaProfessor(str, 0, false, 0, ano, str2, id);
                                }
                                else if (escolha == 2)
                                {
                                    biblioteca.adicionaAluno(str, 0, false, 0, ano, str2, id);
                                }
                                else if (escolha == 3)
                                {
                                    biblioteca.adicionaComunidade(str, 0, false, 0, ano, str2, id);
                                }

                                System.out.println(messages.getString("pics1"));
                                System.out.println();

                                break;

                             case 2:

                                 biblioteca.ordenaListaNome();
                                 System.out.println(messages.getString("lno1"));
                                 System.out.println();
                                 break;

                             case 3:

                                 biblioteca.imprimePessoas();

                                 break;

                             case 4:
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

                             case 5:
                                 System.out.println(messages.getString("dnp1"));
                                 id = t.nextInt();
                                 biblioteca.consultaLivros(id);
                                 
                                 break;

                             case 6: 
                                 break;
                             default:
                                 System.out.println(messages.getString("eegg"));
                                 break;
                        }
                        break;

                    case 2:
                        System.out.println(messages.getString("21i"));
                        System.out.println(messages.getString("22o"));
                        System.out.println(messages.getString("23i"));
                        System.out.println(messages.getString("24e"));
                        System.out.println(messages.getString("25r"));
                        System.out.println(messages.getString("26r"));
                        System.out.println(messages.getString("27l"));
                        System.out.println(messages.getString("28v"));

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
                             case 1:
                                 System.out.println(messages.getString("dtl1"));

                                 str = t.nextLine();
                                 
                                 System.out.println(messages.getString("autorP"));
                                 str2 = t.nextLine();
                                 
                                 System.out.println(messages.getString("editoraP"));
                                 str3 = t.nextLine();
                                 
                                 System.out.println(messages.getString("anoP"));
                                 ano = t.nextInt();

                                 System.out.println(messages.getString("tl"));
                                 System.out.println(messages.getString("tl1"));
                                 System.out.println(messages.getString("tl2"));

                                 escolha = s.nextInt();
                                 
                                 
                                 
                                 str4 = null;
                                 
                                 if(escolha == 1)
                                    biblioteca.adicionaLivro(str, false, 0, true, str4, str2, str3, ano);
                                 else
                                    biblioteca.adicionaLivro(str, false, 0, false, str4, str2, str3, ano);

                                 System.out.println();
                                 break;

                             case 2:

                                 biblioteca.ordenaListaLivro();
                                 System.out.println(messages.getString("lvos1"));
                                 System.out.println();
                                 break;

                             case 3:

                                 biblioteca.imprimeLivros();

                                 break;


                             case 4:

                                 System.out.println(messages.getString("dnp1"));
                                 id = t.nextInt();

                                 biblioteca.numeroAtualDeLivros(id);

                                 System.out.println(messages.getString("dtl2"));
                                 str2 = t.nextLine();

                                 biblioteca.emprestarLivro(id, str2);
                                 System.out.println();
                                 break;


                             case 5:

                                 System.out.println(messages.getString("dnp2"));
                                 str = t.nextLine();

                                 biblioteca.PegarLivrosDoDono(str);

                                 System.out.println(messages.getString("dtl3"));
                                 str2 = t.nextLine();

                                 biblioteca.devolverLivro(str, str2);
                                 System.out.println();

                                 break;

                             case 6:
                                 System.out.println(messages.getString("dtlr1"));
                                 str = t.nextLine();

                                 correto = biblioteca.removeLivro(str);
                                 if(correto)
                                 {
                                     System.out.println(messages.getString("lrcs1"));
                                 }
                                 else
                                 {
                                     System.out.println(messages.getString("err2"));
                                 }

                                 System.out.println();
                                 break;
                                 
                             case 7:
                                 biblioteca.verInfoLivrosEmprestados();

                             case 8:
                                 break;

                             default:
                                 System.out.println(messages.getString("eegg"));
                                 break;
                        }
                        break;

                    case 3:
                        biblioteca.imprimeDatas();
                        System.out.println();
                        break; 

                    case 5:
                        ciclo = false;
                        break;
                        
                    case 4:
                        System.out.println(messages.getString("ih1"));
                        biblioteca.imprimeHistorico();
                        break;
                        
                    default:
                        
                        System.out.println(messages.getString("eegg"));
                        
                        break;
                } 
            
            }
    
        
        biblioteca.fechaArquivo(a, b, c, d);
    
    }
}
