import java.util.Scanner;

class JogoVelha{
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		char[][] jogo = new char[3][3];
		boolean fimGame = false;
		int jogada = 1,lin,col,j,contSignal,win = -1;
		char signal;

		//Inicializando a matriz com *
		for(int i=0;i<jogo.length;i++){
			for(j=0;j<jogo[i].length;j++){
				jogo[i][j] = '*';
			}
		}

		System.out.println();
		System.out.println("Jogador 1 com X");
		System.out.println("Jogador 2 com O");
		System.out.println();

		//Imprimindo o tabuleiro do jogo
			System.out.println("\n\r    1 2 3\n\r");
			for(int i=0;i<jogo.length;i++){
				System.out.print(" "+ (i+1) +"  ");
				for(j=0;j<jogo[i].length;j++){
					System.out.print(""+ jogo[i][j] +" ");
				}
				System.out.println();
			}
			System.out.println();

		//Logica do jogo
		while(!fimGame){
			if(jogada%2 != 0){
				System.out.println("Jogador 1 escolhe linha e coluna [1 - 3]: ");
				signal = 'X';
			}
			else{
				System.out.println("Jogador 2 escolhe linha e coluna [1 - 3]: ");
				signal = 'O';
			}

			//Lendo linha
			do{
				do{
					System.out.print("\n\rLinha: ");
					lin = scan.nextInt();
					if(lin < 1 || lin > 3) System.out.println("\n\rRepita por favor.");
				}while(lin < 1 || lin > 3);

				//Lendo coluna
				do{
					System.out.print("\n\rColuna: ");
					col = scan.nextInt();
					if(col < 1 || col > 3) System.out.println("\n\rRepita por favor.");
				}while(col < 1 || col > 3);

				lin--;
				col--;

				if(jogo[lin][col]=='X' || jogo[lin][col]=='O'){
					System.out.println("Este espaco ja esta ocupado. Escolha outro.");
				}
			}while(jogo[lin][col]=='X' || jogo[lin][col]=='O');

			//Inserindo o valor do sinal na matriz
			jogo[lin][col] = signal;

			//Imprimindo o tabuleiro do jogo
			System.out.println("\n\r    1 2 3\n\r");
			for(int i=0;i<jogo.length;i++){
				System.out.print(" "+ (i+1) +"  ");
				for(j=0;j<jogo[i].length;j++){
					System.out.print(""+ jogo[i][j] +" ");
				}
				System.out.println();
			}
			System.out.println();

			//VERIFICANDO VENCEDOR
			
			if(jogada>2){
				// 1- Verificando Linhas
				for(int i=0;i<jogo.length;i++){
					if(jogo[i][0] == 'X' || jogo[i][0] == 'O'){
						contSignal = 1;
						signal = jogo[i][0];
						for(j=1;j<jogo[i].length;j++){
							if(signal == jogo[i][j]) contSignal++;
						}
						if(contSignal == 3){
							fimGame = true;
							break;
						}
					}//fecha_if
				}//fecha_for

				if(!fimGame){
					// 2- Verificando Colunas
					for(j=0;j<jogo.length;j++){
						if(jogo[0][j] == 'X' || jogo[0][j] == 'O'){
							contSignal = 1;
							signal = jogo[0][j];
							for(int i=1;i<jogo[j].length;i++){
								if(signal == jogo[i][j]) contSignal++;
							}
							if(contSignal == 3){
								fimGame = true;
								break;
							}
						}//fecha_if
					}//fecha_for
				}//fecha_if

				if(!fimGame){
					// 3- Verificando Diagonal 1
					if(jogo[0][0] == 'X' || jogo[0][0] == 'O'){
						signal = jogo[0][0];

						contSignal=1;
						for(int i=1;i<jogo.length;i++){
							if(signal == jogo[i][i]) contSignal++;
						}
						if(contSignal == 3){
							fimGame = true;
						}
					}//fecha_if
				}//fecha_if

				if(!fimGame){
					// 4- Verificando Diagonal 2
					if(jogo[0][2] == 'X' || jogo[0][2] == 'O'){
						signal = jogo[0][2];

						contSignal=1;
						j=1;
						for(int i=1;i<jogo.length;i++){
							if(signal == jogo[i][j]) contSignal++;
							j--;
						}
						if(contSignal == 3){
							fimGame = true;
						}
					}//fecha_if
				}//fecha_if

				//Decidindo um vencedor
				if(fimGame){
					if(signal == 'X') win = 1;
					else win = 2;
					break;
				}
				if(jogada == 9) break;
			}//fecha_if_jogada

			jogada++;
		}//fim_de_while

		//Anunciando o vencedor
		if(win == -1) System.out.println("Que pena, ninguem venceu.\n\r");
		else System.out.println("O Jogador "+ win + " venceu!\n\r");

	}//fim_da_main
}//fim_da_classe