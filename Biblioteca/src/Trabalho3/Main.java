package Trabalho3;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class Main 
{
    public static void main(String args[]) throws IOException
    {
        ResourceBundle messages;
        int escolha = 1;
        String str, str2;
        boolean correto;
        
        Scanner s = new Scanner(System.in);
        Scanner t = new Scanner(System.in);

        String a = "listaPessoa.csv";
        String b = "listaLivro.csv";
        String c = "data.csv";
        
        Funcionalidades biblioteca = new Funcionalidades(a, b, c); 
        boolean ciclo = true;
        messages = biblioteca.getMessages();
        System.out.println(messages.getString("oi"));
        

        while (ciclo)
        {
            
           
                System.out.println("Escolha o item desejado: ");
                System.out.println("1 - Pessoa");
                System.out.println("2 - Livro");
                System.out.println("3 - Datas");
                System.out.println("4 - Fechar programa");

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
                        System.out.println("1 - Inserir uma pessoa");
                        System.out.println("2 - Ordenar a lista de pessoas");
                        System.out.println("3 - Imprimir a lista de pessoas");
                        System.out.println("4 - Remover uma pessoa da lista");
                        System.out.println("5 - Livros com a pessoa");
                        System.out.println("6 - Voltar");

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
                                System.out.println("1 - Professor");
                                System.out.println("2 - Aluno");
                                System.out.println("3 - Comunidade");
                                escolha = s.nextInt();
                                System.out.println("Digite o nome da pessoa:");
                                str = t.nextLine();

                                if(escolha == 1)
                                {

                                    biblioteca.adicionaProfessor(str, 0, false, 0);
                                }
                                else if (escolha == 2)
                                {
                                    biblioteca.adicionaAluno(str, 0, false, 0);
                                }
                                else if (escolha == 3)
                                {
                                    biblioteca.adicionaComunidade(str, 0, false, 0);
                                }

                                System.out.println("Pessoa inserida com sucesso!");
                                System.out.println();

                                break;

                             case 2:

                                 biblioteca.ordenaListaNome();
                                 System.out.println("Lista de nomes ordenada com sucesso");
                                 System.out.println();
                                 break;

                             case 3:

                                 biblioteca.imprimePessoas();

                                 break;

                             case 4:
                                 System.out.println("Digite o nome da pessoa que sera removida:");
                                 str = t.nextLine();

                                 correto = biblioteca.removePessoa(str);
                                 if(correto)
                                 {
                                     System.out.println("A pessoa foi removida com sucesso");
                                 }
                                 else
                                 {
                                     System.out.println("ERRO! Nome inexistente");
                                 }

                                 System.out.println();
                                 break;

                             case 5:
                                 break;

                             case 6: 
                                 break;
                             default:
                                 System.out.println("\nO que esta fazendo, parca? Isso foi um comando invalido!\n");
                                 break;
                        }
                        break;

                    case 2:
                        System.out.println("1 - Inserir um livro");
                        System.out.println("2 - Ordenar a lista de livro");
                        System.out.println("3 - Imprimir a lista de livro");
                        System.out.println("4 - Emprestar livro");
                        System.out.println("5 - Receber livro");
                        System.out.println("6 - Remover um livro da lista");
                        System.out.println("7 - Voltar");

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
                                 System.out.println("Digite o titulo do livro:");

                                 str = t.nextLine();

                                 System.out.println("Tipo do livro:");
                                 System.out.println("1. Texto");
                                 System.out.println("2. Nao texto");


                                 escolha = s.nextInt();
                                 str2 = null;
                                 if(escolha == 1)
                                    biblioteca.adicionaLivro(str, false, 0, true, str2);
                                 else
                                    biblioteca.adicionaLivro(str, false, 0, false, str2);

                                 System.out.println();
                                 break;

                             case 2:

                                 biblioteca.ordenaListaLivro();
                                 System.out.println("Lista de livros ordenadas com sucesso");
                                 System.out.println();
                                 break;

                             case 3:

                                 biblioteca.imprimeLivros();

                                 break;


                             case 4:

                                 System.out.println("Digite o nome da pessoa:");
                                 str = t.nextLine();

                                 biblioteca.numeroAtualDeLivros(str);

                                 System.out.println("Digite o nome do livro:");
                                 str2 = t.nextLine();

                                 biblioteca.emprestarLivro(str, str2);
                                 System.out.println();
                                 break;


                             case 5:

                                 System.out.println("Digite o nome da pessoa:");
                                 str = t.nextLine();

                                 biblioteca.PegarLivrosDoDono(str);

                                 System.out.println("Digite o titulo do livro:");
                                 str2 = t.nextLine();

                                 biblioteca.devolverLivro(str, str2);
                                 System.out.println();

                                 break;

                             case 6:
                                 System.out.println("Digite o titulo do livro que sera removido:");
                                 str = t.nextLine();

                                 correto = biblioteca.removeLivro(str);
                                 if(correto)
                                 {
                                     System.out.println("O livro foi removido com sucesso");
                                 }
                                 else
                                 {
                                     System.out.println("ERRO! Titulo inexistente");
                                 }

                                 System.out.println();
                                 break;

                             case 7:
                                 break;

                             default:
                                 System.out.println("\nO que esta fazendo, parca? Isso foi um comando invalido!\n");
                                 break;
                        }
                        break;

                    case 3:
                        biblioteca.imprimeDatas();
                        System.out.println();
                        break; 

                    case 4:
                        ciclo = false;
                        break;
                        
                    default:
                        
                        System.out.println("\nO que esta fazendo, parca? Isso foi um comando invalido!\n");
                        
                        break;
                } 
            
            }
    
        
        biblioteca.fechaArquivo(a, b, c);
    
    }
}
