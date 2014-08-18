package GUI;

public class Teste {

	public static void main(String[] args) {
		
		String[][] lista = new String[2][2];
		
		lista[0][0]="Ola Mundo";
		lista[0][1]=" em Java!";
		lista[1][0]="Este é um teste ";
		lista[1][1]="de matriz!";
		
		System.out.println(lista[0][0]+lista[0][1]);
	
		System.out.println(lista[1][0]+lista[1][1]);
	}

}
