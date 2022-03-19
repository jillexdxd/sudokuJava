package sudoku;

public class Juego {
	public static void main(String[] args) {
		Tablero tb = new Tablero();

		System.out.println("░██████╗██╗░░░██╗██████╗░░█████╗░██╗░░██╗██╗░░░██");
		System.out.println("██╔════╝██║░░░██║██╔══██╗██╔══██╗██║░██╔╝██║░░░██║");
		System.out.println("╚█████╗░██║░░░██║██║░░██║██║░░██║█████═╝░██║░░░██║");
		System.out.println("░╚═══██╗██║░░░██║██║░░██║██║░░██║██╔═██╗░██║░░░██║");
		System.out.println("██████╔╝╚██████╔╝██████╔╝╚█████╔╝██║░╚██╗╚██████╔╝");
		System.out.println("╚═════╝░░╚═════╝░╚═════╝░░╚════╝░╚═╝░░╚═╝░╚═════╝░");
		System.out.println();
		tb.imprimir();
	}
}
