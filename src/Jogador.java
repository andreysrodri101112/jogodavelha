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

}
