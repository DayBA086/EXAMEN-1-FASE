import java.util.Scanner;

public class ContadorRepeticiones {
    private int[] numeros; // Almacena los 10 numeros
    private int[] conteos; //Cuenta las repeticiones de 1-10
    private Scanner scanner;
    public ContadorRepeticiones() {
        numeros = new int[10];
        conteos = new int[11]; 
        scanner = new Scanner(System.in);
    }

    // Método para leer los datos con validación WHILE
    public void leerNumeros() {
        int i = 0;
        System.out.println("Ingrese 10 numeros del 1-10:");
        while (i < 10) {
            System.out.print("Numero " + (i + 1) + ": ");
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num >= 1 && num <= 10) {
                    numeros[i] = num;
                    conteos[num]++; //Incrementa el contador 
                    i++;
                } else {
                    System.out.println("Ingresa un numero entre 1- 10.");
                }
            } else {
                System.out.println(" Entrada inválida");
                scanner.next(); 
            }
        }
    }

    public void mostrarReporte() {
        System.out.println("\nLos numeros ingresados son:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + "\t");
        }
        System.out.println("\n");

        for (int i = 1; i <= 10; i++) {
            if (conteos[i] > 0) {
                System.out.println("El numero " + i + " se repite " + conteos[i] + " veces");
            }
        }
    }

    // Método main
    public static void main(String[] args) {
        ContadorRepeticiones programa = new ContadorRepeticiones();
        programa.leerNumeros();
        programa.mostrarReporte();
    }
}
