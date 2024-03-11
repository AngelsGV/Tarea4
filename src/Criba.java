import java.util.Scanner;
/**
 * @author Angels
 * @version 3.0 --> Después de ir a tutoria
 * @since 11/3/2024
 */
public class Criba
{
    // Generar números primos de 1 a max

    /**
     *
     * @param max número que se usa para aumentar la array y que abarque todos los resultados.
     * @return los datos que se devuelvern en cada función.
     */
    public static int[] generarPrimos (int max)
    {
        int i,j; //No veo la necesidad de refactorizar los nombres de las variables.
        if (max >= 2) {
// Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
// Inicializar el array
            iniciaArray(dim, esPrimo);
// Eliminar el 0 y el 1, que no son primos
            noPrimos(esPrimo);
// Criba
            Criba(dim, esPrimo);
// ¿Cuántos primos hay?
            int cuenta = contadorPrimos(dim, esPrimo);
// Rellenar el vector de números primos
            return rellenaPrimos(cuenta, dim, esPrimo);
        } else { // max < 2
            return vacío();
// Vector vacío
        }
    }

    public static void Criba(int dim, boolean[] esPrimo) {
        int i;
        int j;
        for (i=2; i<Math.sqrt(dim)+1; i++) {
            if (esPrimo[i]) {
// Eliminar los múltiplos de i
                for (j=2*i; j< dim; j+=i)
                    esPrimo[j] = false;
            }
        }
    }

    public static int[] vacío() {
        return new int[0];
    }

    public static int[] rellenaPrimos(int cuenta, int dim, boolean[] esPrimo) {
        int j;
        int i;
        int[] primos = new int[cuenta];
        for (i=0, j=0; i< dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    public static int contadorPrimos(int dim, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i=0; i< dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    public static void noPrimos(boolean[] esPrimo) {
        esPrimo[0] = esPrimo[1] = false;
    }

    public static void iniciaArray(int dim, boolean[] esPrimo) {
        int i;
        for (i=0; i< dim; i++)
            esPrimo[i] = true;
    }

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int vector[]=new int[dato];
        vectorInicial(dato, vector);
        vector=generarPrimos(dato);
        vectorPrimos(dato, vector);
    }

    public static void vectorPrimos(int dato, int[] vector) {
        System.out.println("\nVector de primos hasta:"+ dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }

    public static void vectorInicial(int dato, int[] vector) {
        System.out.println("\nVector inicial hasta :"+ dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
    }
}