package exercicios.aula20;

import java.util.Scanner;

/*Faça um programa para jogar o jogo da velha. O programa deve
permitir que dois jogadores façam uma partida do jogo da velha,
usando o computador para ver o tabuleiro. Cada jogador vai
alternadamente informando a posição onde deseja colocar a sua
peça (‘O’ ou ‘X’). O programa deve impedir jogadas inválidas e
determinar automaticamente quando o jogo terminou e quem foi o
vencedor (jogador1 ou jogador2). A cada nova jogada, o programa
deve atualizar a situação do tabuleiro na tela.*/

public class Ex06 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		char[][] tabuleiro = new char[3][3];

		System.out.println("Jogador 1 = x");
		System.out.println("jogador 2 = o");

		boolean ganhou = false;
		int jogada = 1;
		char sinal;
		int linha = 0, coluna = 0;

		while (!ganhou) {

			if (jogada % 2 == 1) {
				System.out.println("Vez do jogador 1. Escolha linha e coluna (1-3");
				sinal = 'x';
			} else {
				System.out.println("Vez do jogador 2. Escolha linha e coluna (1-3");
				sinal = 'o';
			}
			boolean linhaValida = false;
			while (!linhaValida) {
				System.out.println("Entre com a linha (1, 2, 3)");
				linha = scan.nextInt();
				if (linha >= 1 && linha <= 3) {
					linhaValida = true;
				} else {
					System.out.println("Entrada inválida");
				}
			}

			boolean colunaValida = false;

			while (!colunaValida) {

				System.out.println("Entre com a coluna. (1, 2, 3 ");
				coluna = scan.nextInt();
				if (coluna >= 1 && coluna <= 3) {
					colunaValida = true;
				} else {
					System.out.println("Entrada inválida");
				}
			}
			coluna--;
			linha--;
			if (tabuleiro[linha][coluna] == 'x' || tabuleiro[linha][coluna] == 'o') {
				System.out.println("Posição já usada");
			} else {
				tabuleiro[linha][coluna] = sinal;
				jogada++;
			}
			for (int i = 0; i < tabuleiro.length; i++) {
				for (int j = 0; j < tabuleiro[i].length; j++) {
					System.out.print(tabuleiro[i][j] + " | ");
				}
				System.out.println();
			}

			if ((tabuleiro[0][0] == 'x' && tabuleiro[0][1] == 'x' && tabuleiro[0][2] == 'x')
					|| (tabuleiro[1][0] == 'x' && tabuleiro[1][1] == 'x' && tabuleiro[1][2] == 'x')
					|| (tabuleiro[2][0] == 'x' && tabuleiro[2][1] == 'x' && tabuleiro[2][2] == 'x')
					|| (tabuleiro[0][0] == 'x' && tabuleiro[1][1] == 'x' && tabuleiro[2][2] == 'x')
					|| (tabuleiro[0][2] == 'x' && tabuleiro[1][1] == 'x' && tabuleiro[0][2] == 'x')
					|| (tabuleiro[0][0] == 'x' && tabuleiro[1][0] == 'x' && tabuleiro[2][0] == 'x')
					|| (tabuleiro[0][1] == 'x' && tabuleiro[1][1] == 'x' && tabuleiro[2][1] == 'x')
					|| (tabuleiro[0][2] == 'x' && tabuleiro[1][2] == 'x' && tabuleiro[2][2] == 'x')) {
				System.out.println("Jogador 1 ganhou");
				ganhou = true;

			} else if ((tabuleiro[0][0] == 'o' && tabuleiro[0][1] == 'o' && tabuleiro[0][2] == 'o')
					|| (tabuleiro[1][0] == 'o' && tabuleiro[1][1] == 'o' && tabuleiro[1][2] == 'o')
					|| (tabuleiro[2][0] == 'o' && tabuleiro[2][1] == 'o' && tabuleiro[2][2] == 'o')
					|| (tabuleiro[0][0] == 'o' && tabuleiro[1][1] == 'o' && tabuleiro[2][2] == 'o')
					|| (tabuleiro[0][2] == 'o' && tabuleiro[1][1] == 'o' && tabuleiro[0][2] == 'o')
					|| (tabuleiro[0][0] == 'o' && tabuleiro[1][0] == 'o' && tabuleiro[2][0] == 'o')
					|| (tabuleiro[0][1] == 'o' && tabuleiro[1][1] == 'o' && tabuleiro[2][1] == 'o')
					|| (tabuleiro[0][2] == 'o' && tabuleiro[1][2] == 'o' && tabuleiro[2][2] == 'o')) {
				System.out.println("Jogador 2 ganhou");
				ganhou = true;
			}else if (jogada > 9) {
				ganhou = true;
				System.out.println("Ninguém ganhou essa partida.");
			}

		}

	}

}
