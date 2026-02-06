package org.hojatrabajo;

import java.io.IOException;
import java.util.Arrays;

/**
 * Clase principal que ejecuta pruebas de rendimiento
 * sobre distintos algoritmos de ordenamiento.
 * Carlos Altán 25772
 * Sergio Tepaz
 */
public class Main {

    /**
     * Método principal del programa.
     *
     * @param args argumentos de línea de comandos
     * @throws IOException si ocurre un error al leer o escribir archivos
     */
    public static void main(String[] args) throws IOException {
        GenerateFile file = new GenerateFile();
        SortingClass sortingClass = new SortingClass();

        int n = 2000;

        file.generateRandomNumbers(n);
        Integer[] datosBase = file.readFromFile();

        System.out.println("--- RESULTADOS DE RENDIMIENTO (n=" + n + ") ---");

        correrPruebas(sortingClass, datosBase, "Desordenado");

        Arrays.sort(datosBase);

        correrPruebas(sortingClass, datosBase, "Ordenado");
    }

    /**
     * Ejecuta los algoritmos de ordenamiento y mide su tiempo de ejecución.
     *
     * @param f    instancia de la clase de ordenamiento
     * @param data arreglo de datos a ordenar
     * @param n    cantidad de elementos
     * @param modo descripción del escenario de prueba
     */
    private static void correrPruebas(SortingClass f, Integer[] data, String modo) {
        System.out.println("\n>>> Modo: " + modo);

        medirGnomeSort(f, data);
        medirMergeSort(f, data);
    }

    /**
     * Mide el tiempo de ejecución del algoritmo Gnome Sort.
     *
     * @param f    instancia de la clase de ordenamiento
     * @param data arreglo de datos a ordenar
     */
    private static void medirGnomeSort(SortingClass f, Integer[] data) {
        Integer[] copia = data.clone();

        long startTime = System.nanoTime();
        f.gnomeSort(copia);
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1_000_000.0;
        System.out.printf("%-15s: %.4f ms\n", "Gnome Sort", duration);
    }

    /**
     * Mide el tiempo de ejecución del algoritmo Merge Sort.
     *
     * @param f    instancia de la clase de ordenamiento
     * @param data arreglo de datos a ordenar
     */
    private static void medirMergeSort(SortingClass f, Integer[] data) {
        Integer[] copia = data.clone();

        long startTime = System.nanoTime();
        f.mergeSort(copia);
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1_000_000.0;
        System.out.printf("%-15s: %.4f ms\n", "Merge Sort", duration);
    }
}
