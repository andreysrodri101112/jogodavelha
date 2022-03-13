public class JogoDaVelha {

    public Integer dimensaoTabuleiro;
    public Character[][] tabuleiro;

    public JogoDaVelha(Integer d){
        this.dimensaoTabuleiro = d;
        this.tabuleiro = new Character[d][d];

        this.inicializaTabuleiro();
    }

    public boolean realizaJogada(Integer linha, Integer coluna, Character xo){
        if (linha >= this.dimensaoTabuleiro || coluna >= this.dimensaoTabuleiro) {
            return false;
        }

        if (this.tabuleiro[linha][coluna] != '*') {
            return false;
        }

        this.tabuleiro[linha][coluna] = xo;

        return true;
    }

    public int verificaGanhador(Character xo){
        boolean linhaCompleta;
        boolean colunaCompleta;
        boolean diagonalCompleta;
        boolean empate;

        empate = this.verificaEmpate();
        if (empate) {
            return 2;
        }

        // Valida linhas
        for (int linha = 0; linha < this.dimensaoTabuleiro; linha++) {
            linhaCompleta = true;
            for (int coluna = 0; coluna < this.dimensaoTabuleiro; coluna++) {
                if (this.tabuleiro[linha][coluna] != xo) {
                    linhaCompleta = false;
                }
            }

            if (linhaCompleta) {
                return 1;
            }
        }

        // Valida colunas
        for (int coluna = 0; coluna < this.dimensaoTabuleiro; coluna++) {
            colunaCompleta = true;
            for (int linha = 0; linha < this.dimensaoTabuleiro; linha++) {
                if (this.tabuleiro[linha][coluna] != xo) {
                    colunaCompleta = false;
                }
            }

            if (colunaCompleta) {
                return 1;
            }
        }

        // Valida diagonal principal
        diagonalCompleta = true;
        for (int linha = 0; linha < this.dimensaoTabuleiro; linha++) {
            for (int coluna = 0; coluna < this.dimensaoTabuleiro; coluna++) {
                if (linha == coluna) {
                    if (this.tabuleiro[linha][coluna] != xo) {
                        diagonalCompleta = false;
                    }
                }
            }
        }

        if (diagonalCompleta) {
            return 1;
        }

        // Valida diagonal secundaria
        diagonalCompleta = true;
        for (int linha = 0; linha < this.dimensaoTabuleiro; linha++) {
            for (int coluna = 0; coluna < this.dimensaoTabuleiro; coluna++) {
                if (linha + coluna == this.dimensaoTabuleiro - 1) {
                    if (this.tabuleiro[linha][coluna] != xo) {
                        diagonalCompleta = false;
                    }
                }
            }
        }

        if (diagonalCompleta) {
            return 1;
        }

        return 0;
    }

    public boolean verificaEmpate(){
        for (int linha = 0; linha < this.dimensaoTabuleiro; linha++) {
            for (int coluna = 0; coluna < this.dimensaoTabuleiro; coluna++) {
                if (this.tabuleiro[linha][coluna] == '*') {
                    return false;
                }
            }
        }

        return true;
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
