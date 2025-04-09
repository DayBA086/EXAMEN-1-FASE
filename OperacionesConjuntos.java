import java.util.*;

class Arreglo<T extends Number> {
    T[] arreglo1;
    T[] arreglo2;

    public Arreglo(T[] arreglo1, T[] arreglo2) {
        this.arreglo1 = arreglo1;
        this.arreglo2 = arreglo2;
    }
}

public class OperacionesConjuntos {

    // Búsqueda binaria recursiva
    public static <T extends Comparable<T>> boolean busquedaBinaria(T[] arreglo, T valor, int inicio, int fin) {
        if (inicio > fin) return false;
        int medio = (inicio + fin) / 2;
        int comp = arreglo[medio].compareTo(valor);

        if (comp == 0) return true;
        else if (comp > 0) return busquedaBinaria(arreglo, valor, inicio, medio - 1);
        else return busquedaBinaria(arreglo, valor, medio + 1, fin);
    }

    // Eliminar duplicados y ordenar
    private static <T extends Comparable<T>> List<T> ordenarSinDuplicados(T[] arreglo) {
        Set<T> conjunto = new TreeSet<>(Arrays.asList(arreglo)); // elimina duplicados y ordena
        return new ArrayList<>(conjunto);
    }

    // Unión
    public static <T extends Number & Comparable<T>> List<T> union(T[] a, T[] b) {
        Set<T> resultado = new TreeSet<>();
        Collections.addAll(resultado, a);
        Collections.addAll(resultado, b);
        return new ArrayList<>(resultado);
    }

    // Intersección
    public static <T extends Number & Comparable<T>> List<T> interseccion(T[] a, T[] b) {
        Set<T> conjuntoA = new HashSet<>(Arrays.asList(a));
        Set<T> conjuntoB = new HashSet<>(Arrays.asList(b));
        conjuntoA.retainAll(conjuntoB);
        return new ArrayList<>(conjuntoA);
    }

    // Diferencia A - B
    public static <T extends Number & Comparable<T>> List<T> diferencia(T[] a, T[] b) {
        Set<T> conjuntoA = new HashSet<>(Arrays.asList(a));
        Set<T> conjuntoB = new HashSet<>(Arrays.asList(b));
        conjuntoA.removeAll(conjuntoB);
        return new ArrayList<>(conjuntoA);
    }

    // Diferencia Simétrica A Δ B
    public static <T extends Number & Comparable<T>> List<T> diferenciaSimetrica(T[] a, T[] b) {
        List<T> union = union(a, b);
        List<T> interseccion = interseccion(a, b);
        union.removeAll(interseccion);
        return union;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] arregloA, arregloB;
        int longitud;

        System.out.print("Ingrese la longitud de los arreglos: ");
        longitud = sc.nextInt();

        arregloA = new Integer[longitud];
        arregloB = new Integer[longitud];

        System.out.println("Ingrese los elementos del arreglo A:");
        for (int i = 0; i < longitud; i++) {
            System.out.print("A[" + i + "]: ");
            arregloA[i] = sc.nextInt();
        }

        System.out.println("Ingrese los elementos del arreglo B:");
        for (int i = 0; i < longitud; i++) {
            System.out.print("B[" + i + "]: ");
            arregloB[i] = sc.nextInt();
        }

        Arreglo<Integer> conjunto = new Arreglo<>(arregloA, arregloB);

        int opcion;
        do {
            System.out.println("\n--- MENÚ DE OPERACIONES ---");
            System.out.println("1. UNIÓN (A U B)");
            System.out.println("2. INTERSECCIÓN (A ∩ B)");
            System.out.println("3. DIFERENCIA (A - B)");
            System.out.println("4. DIFERENCIA SIMÉTRICA (A Δ B)");
            System.out.println("5. SALIR");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            // Mostrar arreglos A y B
            System.out.println("\nArreglo A: " + Arrays.toString(conjunto.arreglo1));
            System.out.println("Arreglo B: " + Arrays.toString(conjunto.arreglo2));

            switch (opcion) {
                case 1:
                    System.out.println("Unión A U B: " + union(conjunto.arreglo1, conjunto.arreglo2));
                    break;
                case 2:
                    System.out.println("Intersección A ∩ B: " + interseccion(conjunto.arreglo1, conjunto.arreglo2));
                    break;
                case 3:
                    System.out.println("Diferencia A - B: " + diferencia(conjunto.arreglo1, conjunto.arreglo2));
                    break;
                case 4:
                    System.out.println("Diferencia Simétrica A Δ B: " + diferenciaSimetrica(conjunto.arreglo1, conjunto.arreglo2));
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }
}
