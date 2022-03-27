package sudoku;

import java.util.Scanner;

public class Juego {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Tablero tb = new Tablero();
		Juego m = new Juego();
		
		tb.imprimir();
		
		int opcion;
		do {
			System.out.println("\n\t\t1. Rellenar celda");
			System.out.println("\t\t2. Borrar celda");
			System.out.println("\t\t3. Comprobar resultado");
			System.out.print("\n\t\tIntroduce una opcion: ");
			opcion = teclado.nextInt();
			
			
		}	while(opcion <=0 && opcion > 3);
		
		switch (opcion){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			default:
		}
	}
}
