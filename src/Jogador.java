public class Jogador {

    public String nome;
    public Integer pontos;

    public Jogador(String n){
        this.nome = n;
        this.pontos = 0;
    }

    public String getNome(){
        return this.nome;
    }

    public int getPontuacao(){
        return this.pontos;
    }

    public void setPontuacao(){
        this.pontos += 1;
    }
}
