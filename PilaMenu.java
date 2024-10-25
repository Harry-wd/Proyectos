import java.util.Scanner;

public class PilaMenu {

    private int[] pila;
    private int tope;
    private int tamaño;

    public PilaMenu(int tamaño) {
        this.tamaño = tamaño;
        pila = new int[tamaño];
        tope = -1; 
    }



    // creamos metodo para apilar o insertar un elemento
    public void apilar(int elemento) {
        if (estaLlena()) {
            System.out.println("La pila está llena.");
        } else {
            tope++;
            pila[tope] = elemento;
            System.out.println("el elemento " + elemento + " fue apilado correctamente.");
        }
    }




    // creamos metodo para desapilar un elemento
    public int desapilar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
            return -1;
        } else {
            int elemento = pila[tope];
            tope--;
            System.out.println("El elemento " + elemento + " fue desapilado correctamente.");
            return elemento;
        }
    }



    // creamos metodo para obtener el Tope de la pila
    public int obtenerTope() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
            return -1; 
        } else {
            return pila[tope];
        }
    }




    // ahora creamos metodo para mostrar los elementos de la pila
    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Elementos de la pila:");
            for (int i = tope; i >= 0; i--) {
                System.out.println(pila[i]);
            }
        }
    }




    // creamos el metodo de verificar si la pila esta vacia
    public boolean estaVacia() {
        return tope == -1;
    }

    // metodo para verificar si la pila esta llena
    public boolean estaLlena() {
        return tope == tamaño - 1;
    }

    // metodo para obtener el tamaño de la pila
    public int obtenerTamaño() {
        return tamaño;
    }

    // metodo para vaciar la pila
    public void vaciarPila() {
        tope = -1;
        System.out.println("La pila se vacio correctamente.");
    }


    

    // creamos el menu para que el usuario seleccione cualquier opcion

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el tamaño de la pila: ");
        int tamañoPila = entrada.nextInt();
        PilaMenu pila = new PilaMenu(tamañoPila);

        int opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Apilar");
            System.out.println("2. Desapilar");
            System.out.println("3. Obtener Tope");
            System.out.println("4. Mostrar Pila");
            System.out.println("5. Verificar si esta vacia");
            System.out.println("6. Verificar si esta llena");
            System.out.println("7. Obtener el Tamaño");
            System.out.println("8. Vaciar la pila");
            System.out.println("0. Salir");
            System.out.print("Por favor ingrese una opcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a apilar: ");
                    int elemento = entrada.nextInt();
                    pila.apilar(elemento);
                    break;
                case 2:
                    pila.desapilar();
                    break;
                case 3:
                    System.out.println("El tope de la pila es: " + pila.obtenerTope());
                    break;
                case 4:
                    pila.mostrarPila();
                    break;
                case 5:
                    if (pila.estaVacia()) {
                        System.out.println("La pila esta vacia.");
                    } else {
                        System.out.println("La pila no esta vacia.");
                    }
                    break;
                case 6:
                    if (pila.estaLlena()) {
                        System.out.println("La pila esta llena.");
                    } else {
                        System.out.println("La pila no esta llena.");
                    }
                    break;
                case 7:
                    System.out.println("El tamaño de la pila es: " + pila.obtenerTamaño());
                    break;
                case 8:
                    pila.vaciarPila();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
        entrada.close();

    
    }
    
}
