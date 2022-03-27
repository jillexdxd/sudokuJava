package sudoku;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Juego {
	
	public void clear() {
		for (int n = 0; n < 15; n++) {
			System.out.println();
		}
	}
	
	// GRACIAS RAUL ¯\_(ツ)
	public void sleep (int s) {
		try {
			TimeUnit.SECONDS.sleep(s);
			}catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
	}
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Tablero tb = new Tablero();
		Juego j = new Juego();
		
		boolean menu = true;
		int opcion, fil, cel, num;
		
		do {
			tb.imprimir();
			System.out.println("\n\t\t1. Rellenar celda");
			System.out.println("\t\t2. Borrar celda");
			System.out.println("\t\t3. Comprobar resultado");
			System.out.println("\t\t0. Salir");
			System.out.print("\n\t\tIntroduce una opcion: ");
			opcion = teclado.nextInt();
			
			switch (opcion){
				case 1:
					j.clear();
					tb.imprimir();
					System.out.println();
					System.out.print("\t\tIntroduce fila (1-4): ");
					fil = teclado.nextInt();
					
					System.out.print("\t\tIntroduce celda fila (1-4): ");
					cel = teclado.nextInt();
					
					System.out.print("\t\tIntroduce numero (1-4): ");
					num = teclado.nextInt();
					
					 tb.setNum(fil, cel, num);
					 j.clear();
					break;
				case 2:
					j.clear();
					tb.imprimir();
					System.out.print("\t\tIntroduce fila (1-4): ");
					fil = teclado.nextInt();
					
					System.out.print("\t\tIntroduce celda fila (1-4): ");
					cel = teclado.nextInt();
					tb.setNum(fil, cel, 0);
					j.clear();
					break;
				case 3:
					if (tb.comprobar()) {
						j.clear();
						tb.imprimir();
						System.out.println("\n\t█▀▀ █▀▀█ █▀▀█ █▀▀█ █▀▀ █▀▀ ▀▀█▀▀ █▀▀█ ");
						System.out.println("\t█░░ █░░█ █▄▄▀ █▄▄▀ █▀▀ █░░ ░░█░░ █░░█ ");
						System.out.println("\t▀▀▀ ▀▀▀▀ ▀░▀▀ ▀░▀▀ ▀▀▀ ▀▀▀ ░░▀░░ ▀▀▀▀");
						menu = false;
					} else {
						j.clear();
						tb.imprimir();
						System.out.println("\n\t     █▀▀ █▀▀█ █▀▀█ █▀▀█ █▀▀█ ");
						System.out.println("\t     █▀▀ █▄▄▀ █▄▄▀ █░░█ █▄▄▀ ");
						System.out.println("\t     ▀▀▀ ▀░▀▀ ▀░▀▀ ▀▀▀▀ ▀░▀▀");
						j.sleep(3);
					}
					break;
				case 0:
					menu = false;
					break;
				default:
					j.clear();
					break;
			}		
		}	while(menu);
	}
}