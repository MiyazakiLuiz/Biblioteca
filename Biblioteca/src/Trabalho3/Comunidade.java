package Trabalho3;


public class Comunidade extends Pessoa 
{
    Comunidade(String a, int b, boolean c, int d)
    {
        this.setNome(a);
        this.setNumeroDeLivros(b);
        this.setSuspenso(c);
        this.setNumeroDeLivrosMax(2);
        this.setlimiteDias(15);
        this.setDiasDeSuspensao(d);
    }
}
