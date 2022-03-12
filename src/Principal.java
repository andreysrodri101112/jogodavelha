import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
        int linha = 0;
        int coluna = 0;
        int dimensaoTabuleiro = 3;
        boolean jogadaValida = false;
        boolean fimDeJogo = false;

        Jogador j1 = new Jogador("Jogador 1");
        Jogador j2 = new Jogador("Jogador 2");

        JogoDaVelha jogo = new JogoDaVelha(dimensaoTabuleiro);

        while (fimDeJogo == false){

            jogo.exibeTabuleiro();

            // ---------- JOGADOR 1 ----------

            do {
                System.out.println(j1.getNome() + ", digite a linha:");
                linha = Integer.parseInt(s.nextLine());

                System.out.println(j1.getNome() + ", digite a coluna:");
                coluna = Integer.parseInt(s.nextLine());

                jogadaValida = jogo.realizaJogada(linha, coluna, 'X');
                if (jogadaValida == false) {
                    System.out.println("Posição inválida ou já inserida, insira novamente");
                }
            } while (jogadaValida == false);

            fimDeJogo = jogo.verificaGanhador();
            if (fimDeJogo) {
                break;
            }

            jogo.exibeTabuleiro();

            // ---------- JOGADOR 2 ----------
            do {
                System.out.println(j2.getNome() + ", digite a linha:");
                linha = Integer.parseInt(s.nextLine());

                System.out.println(j2.getNome() + ", digite a coluna:");
                coluna = Integer.parseInt(s.nextLine());

                jogadaValida = jogo.realizaJogada(linha, coluna, 'O');
                if (jogadaValida == false) {
                    System.out.println("Posição inválida ou já inserida, insira novamente");
                }
            } while (jogadaValida == false);

        }
    }
}
