package materos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Oias {

	public int cantidadPersonas;
	public int[] a;

	public Oias(String path) throws FileNotFoundException {
		leerArchivo(path);
	}

	public void leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));

		sc.useLocale(Locale.ENGLISH);
		this.cantidadPersonas = sc.nextInt();
		a = new int[cantidadPersonas-1];

		for (int i = 0; i < cantidadPersonas-1; i++) {
			this.a[i] = sc.nextInt();
//			System.out.println("testlecturar"+a[i]);  //testlectura
		}
		sc.close();
	}

	public void calcularCebador() throws IOException {
		ArrayList<Integer> pasajes = new ArrayList<Integer>();
		int[] safaroni = new int[this.cantidadPersonas - 1];
		int posEliminar = 0;
		int cantidadActualPersonas = this.cantidadPersonas;
		int j = 0;
		
		// creo la lista de personas
		for (int i = 1; i <= this.cantidadPersonas; i++) {
			pasajes.add(i);
		}
		while (cantidadActualPersonas != 1) {
			
			posEliminar = (int) ((posEliminar + this.a[j]) % cantidadActualPersonas);
			safaroni[j] = pasajes.get(posEliminar);
			System.out.println("pasaje.getpos.posEliminar= " + pasajes.get(posEliminar) + " y b[" + j + "]= " + safaroni[j]);
			pasajes.remove(posEliminar);
			j++;
			cantidadActualPersonas--;
		}
		grabar((int)pasajes.get(0), safaroni, (int) this.cantidadPersonas);
	}

	public void grabar(int cebador, int[] safaroni, int cantidadPersonas) throws IOException {
		String path = "C:\\Users\\user - lenovo\\Documents\\PA\\EclipseProjects\\Pruebas\\AventurerosMateros\\loteDePruebas\\ldp\\";
		PrintWriter salida = new PrintWriter(new FileWriter(path + "aventureros.out"));
		for (int i = 0; i < this.cantidadPersonas - 1; i++) {
			salida.print(safaroni[i] + " ");
		}
		salida.println(" ");
		salida.println(cebador);

		salida.close();
	}

}
