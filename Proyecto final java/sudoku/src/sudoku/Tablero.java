package sudoku;

public class Tablero {
	private int[][] tab;
	
	public Tablero() {
		tab = new int[4][4];
		for (int f = 0; f < tab.length; f++) {
			for (int c = 0; c < tab[f].length; c++){
				tab[f][c] = 0;
			}
		}
	}
	
	public void imprimir() {
		System.out.println("\t\t+---+---+---+---+");
		for (int f = 0; f < tab.length; f++) {
			System.out.print("\t\t| ");
			for (int c = 0; c < tab[f].length; c++){
				System.out.print(tab[f][c] + " | ");
			}
			System.out.println("\n\t\t+---+---+---+---+");
		}
	}
}
