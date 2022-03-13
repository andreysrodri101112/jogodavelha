import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
        int linha = 0;
        int coluna = 0;
        int dimensaoTabuleiro = 3;
        int fimDeJogo = 0; // 1 - vitoria, 2 - empate
        boolean jogadaValida = false;
        String inputNome = "";

        System.out.println("Digite o nome do primeiro jogador:");
        inputNome = s.nextLine();
        Jogador j1 = new Jogador(inputNome);

        System.out.println("Digite o nome do segundo jogador:");
        inputNome = s.nextLine();
        Jogador j2 = new Jogador(inputNome);

        System.out.println("Digite a dimensão do tabuleiro:");
        dimensaoTabuleiro = Integer.parseInt(s.nextLine());
        JogoDaVelha jogo = new JogoDaVelha(dimensaoTabuleiro);

        while (fimDeJogo == 0){
            // ---------- JOGADOR 1 ----------
            jogo.exibeTabuleiro();

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


            fimDeJogo = jogo.verificaGanhador('X');
            if (fimDeJogo > 0) {
                jogo.exibeTabuleiro();
                switch (fimDeJogo) {
                    case 1:
                        System.out.println("Fim de jogo!\nVencedor: " + j1.getNome());
                        j1.setPontuacao();
                        break;
                    case 2:
                        System.out.println("Fim de jogo!\nEmpate");
                        break;
                }

                System.out.println("Nova partida?\n0 - Sim\n1 - Não");
                fimDeJogo = Integer.parseInt(s.nextLine());
                if (fimDeJogo == 1) {
                    System.out.println("Pontuação: \n");
                    System.out.println(j1.getNome() + " - " + j1.getPontuacao());
                    System.out.println(j2.getNome() + " - " + j2.getPontuacao());
                    break;
                }
            }

            // ---------- JOGADOR 2 ----------
            jogo.exibeTabuleiro();

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

            fimDeJogo = jogo.verificaGanhador('O');
            if (fimDeJogo > 0) {
                jogo.exibeTabuleiro();
                switch (fimDeJogo) {
                    case 1:
                        System.out.println("Fim de jogo!\nVencedor: " + j2.getNome());
                        j2.setPontuacao();
                        break;
                    case 2:
                        System.out.println("Fim de jogo!\nEmpate");
                        break;
                }

                System.out.println("Nova partida?\n0 - Sim\n1 - Não");
                fimDeJogo = Integer.parseInt(s.nextLine());
                if (fimDeJogo == 1) {
                    System.out.println("Pontuação: \n");
                    System.out.println(j1.getNome() + " - " + j1.getPontuacao());
                    System.out.println(j2.getNome() + " - " + j2.getPontuacao());
                    break;
                };
            }
        }
    }

}
