public class JogoDaVelha {

    public Integer dimensaoTabuleiro;
    public Character[][] tabuleiro;

    public JogoDaVelha(Integer d){
        this.dimensaoTabuleiro = d;
        this.tabuleiro = new Character[d][d];

        this.inicializaTabuleiro();
    }

    public boolean realizaJogada(Integer linha, Integer coluna, Character xo){
        if (linha >= this.dimensaoTabuleiro && coluna >= this.dimensaoTabuleiro) {
            return false;
        }

        if (this.tabuleiro[linha][coluna] != '*') {
            return false;
        }

        this.tabuleiro[linha][coluna] = xo;

        return true;
    }

    public boolean verificaGanhador(){

        char primeiraPosicao = '*';
        boolean winByLineCompleted;

        for (int i = 0; i < this.dimensaoTabuleiro; i++) {

            winByLineCompleted = true;
            for (int k = 0; k < this.dimensaoTabuleiro; k++) {

                if (k == 0) {
                    primeiraPosicao = this.tabuleiro[i][k];
                }

                if (primeiraPosicao != this.tabuleiro[i][k]) {
                    winByLineCompleted = false;
                }
            }
        }

        return false;
    }

    public void inicializaTabuleiro(){
        for (int i = 0; i < this.dimensaoTabuleiro; i++) {
            for (int k = 0; k < this.dimensaoTabuleiro; k++) {
                this.tabuleiro[i][k] = '*';
            }
        }
    }

    public void exibeTabuleiro(){
        for (int i = 0; i < this.dimensaoTabuleiro; i++) {
            for (int k = 0; k < this.dimensaoTabuleiro; k++) {
                System.out.printf("\t" + this.tabuleiro[i][k]);
            }
            System.out.printf("\n");
        }
    }

}
