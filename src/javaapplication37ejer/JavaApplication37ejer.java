package javaapplication37ejer;

import java.util.Scanner;

public class JavaApplication37ejer {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Solicitar tamaño de la pila al usuario
        System.out.println("Cual sera el tamaño de la pila?");
        int tamaño = teclado.nextInt();
        String[] arregloLlenado = new String[tamaño];  // Solo una declaración

        int tope = 0; // Variable para controlar el número de elementos en la pila

        try {
            // Menú interactivo
            do {
                System.out.println("\nQue deseas hacer?  \n1.-Llenar automáticamente \n2.- Mostrar \n3.- Eliminar ultimo dato \n4.-Salir");
                int opcion = teclado.nextInt();

                switch (opcion) {
                    case 1: {
                        // Llenar automáticamente y aleatoriamente
                        tope = llenar(arregloLlenado, tope, tamaño);
                        break;
                    }
                    case 2: {
                        // MOSTRAR
                        mostrar(arregloLlenado, tope);
                        break;
                    }
                    case 3: {
                        // ELIMINAR último elemento de la pila
                        if (tope > 0) {
                            // Desplazar todos los elementos hacia adelante
                            for (int i = 0; i < tope - 1; i++) {
                                arregloLlenado[i] = arregloLlenado[i + 1];
                            }

                            // El último elemento ahora queda vacío 
                            arregloLlenado[tope - 1] = null;

                            // Reducir el tamaño de la pila
                            tope--;

                            System.out.println("El primer elemento fue eliminado.");
                        } else {
                            System.out.println("La pila está vacía.");
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("Adios");
                        System.exit(0);  // Salir del programa
                    }
                    default: {
                        System.out.println("OPCION NO VALIDA. INTENTA DE NUEVO.");
                    }
                }

            } while (true);  // Mantener el ciclo activo
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

    // Método para llenar la pila automáticamente de manera aleatoria
    public static int llenar(String[] arregloLlenado, int tope, int tamaño) {
        char[] bancoDeLetras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z'};

        // Llenar la pila de manera aleatoria hasta que esté llena
        while (tope < tamaño) {
            String letra = "" + bancoDeLetras[(int) (Math.random() * 26)];
            // Verificar si la letra ya está en la pila
            boolean repetida = false;
            for (int i = 0; i < tope; i++) {
                if (arregloLlenado[i].equals(letra)) {
                    repetida = true;
                    break;
                }
            }
            //si la letra no esta repetida la agrega a la pila
            if (!repetida) {
                arregloLlenado[tope] = letra;
                tope++;
            }
        }
        System.out.println("La pila se ha llenado automaticamente.");
        return tope;
    }

    public static void mostrar(String[] arregloLlenado, int tope) {
        if (tope == 0) {
            System.out.println("La pila está vacia.");
        } else {
            System.out.println("Elementos en la pila:");
            for (int i = 0; i < tope; i++) {
                System.out.println(arregloLlenado[i]);
            }
        }
    }
}
