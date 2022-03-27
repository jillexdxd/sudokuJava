package sudoku;


public class Tablero {
	private int[][] tab, masc, jugador;

	public Tablero() {			
		
		// relleno la matriz por cada fila elementos del 1 al 4 que toma el valor c+1 para no tener que controlar que se repitan en la misma fila
		tab = new int[4][4];
		for (int f = 0; f < tab.length; f++) {
			for (int c = 0; c < tab[f].length; c++){
				tab[f][c] = c+1;
			}
		}
		
		boolean control = true;
		
		do {
			// Algoritmo de sattolo funciona en indice negativo para no repetir posiciones e ir descartando elementos de la lista al permutarlos
			for (int f = 0; f < tab.length; f++) {
				for (int i = 4; i > 1; i--) {
					int r = (int) (Math.random() * (i-1));
					int aux = tab[f][r];
					tab[f][r] = tab[f][i-1];
					tab[f][i-1] = aux;
				}
			}
			
			// Inicia un for para llevar el control de numeros repetidos en la misma fila despues de la permutacion del vector
			// Al ser permutado con unos valores del 1-4 en el vector, es imposible que se repitan en f, pero si es posible que se repitan en c
			int con1 = 0, con2 = 0, con3 = 0, con4 = 0, contf = 0;
					
			for (int c = 0; c < 4; c++){
				for (int f = 0; f < 4; f++) {
					if (tab[f][c] == 1) {
						con1++;
					}
					else if (tab[f][c] == 2) {
						con2++;
					}
					else if (tab[f][c] == 3) {
						con3++;
					}
					else if (tab[f][c] == 4) {
						con4++;
					}
				}
				//Se comprueba que hay uno por cada fila y se suma a contf 1, para un estado correcto
				// contf, despues de este bucle tiene que ser = 4
				if (con1 == 1 && con2 == 1 && con3 == 1 && con4 == 1) {
					contf++;
				}
				
				con1 = 0;
				con2 = 0;
				con3 = 0;
				con4 = 0;
			}
			
			// Se comprueba que haya al menos un numero de cada en la primer 2x2 empezando desde arriba a la izquierda
			// Casualmente coincide en los resultados que los demas bloques 2x2 son un numero en cada celda

			for (int f = 0; f < tab.length/2; f++) {
				for (int c = 0; c < tab[f].length/2; c++) {
					if (tab[f][c] == 1) {
						con1++;
					}
					else if (tab[f][c] == 2) {
						con2++;
					}
					else if (tab[f][c] == 3) {
						con3++;
					}
					else if (tab[f][c] == 4) {
						con4++;
					}
				}
			}
			
			// si se comprueba un numero en cada celda del primer 2x2 contf suma 1
			// siendo la salida 5, el dato que le tenemos que pasar abajo linea(88)
			
			if (con1 == 1 && con2 == 1 && con3 == 1 && con4 == 1) {
				contf++;
			}
			
			//si es 5, se convierte en false y sale del bucle do while dando por terminada la mezcla de los numeros
			if (contf == 5) {
				control = false;
			} else {
				control = true;
			}
			
		} while (control);
		
		
		//matriz masc y jugador son iniciados a 0 en todos sus valores
		masc = new int[4][4];
		jugador = new int[4][4];
		
		for (int f = 0; f < 4; f++) {
			for (int c = 0; c < 4; c++){
				masc[f][c] = 0;
				jugador[f][c] = 0;
			}
		}
		
		int randF, randC;
		
		for (int i = 0; i <= 8; i++) {
			randF = (int) Math.floor(Math.random()*4);
			randC = (int) Math.floor(Math.random()*4);
			masc[randF][randC] = 1;
		}
	}
	
	public void imprimir() {
		
		System.out.println("░██████╗██╗░░░██╗██████╗░░█████╗░██╗░░██╗██╗░░░██╗");
		System.out.println("██╔════╝██║░░░██║██╔══██╗██╔══██╗██║░██╔╝██║░░░██║");
		System.out.println("╚█████╗░██║░░░██║██║░░██║██║░░██║█████═╝░██║░░░██║");
		System.out.println("░╚═══██╗██║░░░██║██║░░██║██║░░██║██╔═██╗░██║░░░██║");
		System.out.println("██████╔╝╚██████╔╝██████╔╝╚█████╔╝██║░╚██╗╚██████╔╝");
		System.out.println("╚═════╝░░╚═════╝░╚═════╝░░╚════╝░╚═╝░░╚═╝░╚═════╝░");
		System.out.println();
	
		
		System.out.println("\t\t+---+---+---+---+");
		for (int f = 0; f < tab.length; f++) {
			System.out.print("\t\t| ");
			for (int c = 0; c < tab[f].length; c++){
				if (masc[f][c] == 1) {
					System.out.print(tab[f][c] + " | ");
				}	else {
						if (jugador[f][c]>0) {
							System.out.print(jugador[f][c] + " | ");
						} else {
							System.out.print(" " + " | ");
						}
				}
			}
			System.out.println("\n\t\t+---+---+---+---+");
		}
	}
	
	public boolean comprobar() {
		int cont0 = 0, contV = 0;
		
		for (int f = 0; f < tab.length; f++) {
			for (int c = 0; c < tab[f].length; c++) {
				//suma a contador de cont0 uno por cada cero en la matriz masc
				if (masc[f][c] == 0) {
					cont0++;
					//comprueba que por cada 0 de la matriz masc existe un numero igual en las dos matrices (tab y jugador)
					if (tab[f][c] == jugador[f][c]) {
						contV++;
					}
				}
			}
		}
		
		//si la cantidad de numeros iguales es la misma que de 0 que hay en la matriz, se retorna true
		if (contV == cont0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	//sirve tanto para borrar como para introducir un numero
	
	public void setNum(int fil, int cel, int numero) {	
		jugador[fil-1][cel-1] = numero;
			
	}
}