package Trabalho3;


public class Aluno extends Pessoa
{


    Aluno(String a, int b, boolean c, int d)
    {
        this.setNome(a);
        this.setNumeroDeLivros(b);
        this.setSuspenso(c);
        this.setNumeroDeLivrosMax(4);
        this.setlimiteDias(15);
        this.setDiasDeSuspensao(d);
    }
}
