package Trabalho3;


public class Professor extends Pessoa
{
    Professor(String a, int b, boolean c, int d)
    {
        this.setNome(a);
        this.setNumeroDeLivros(b);
        this.setSuspenso(c);
        this.setNumeroDeLivrosMax(6);
        this.setlimiteDias(60);
        this.setDiasDeSuspensao(d);
    }
}
