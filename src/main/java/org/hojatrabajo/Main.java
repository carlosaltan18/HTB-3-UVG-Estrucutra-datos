package org.hojatrabajo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Clase principal encargada de ejecutar pruebas de rendimiento
 * para distintos algoritmos de ordenamiento.
 *
 * Esta clase genera arreglos de números aleatorios, ejecuta
 * varios algoritmos de ordenamiento con datos ordenados y
 * desordenados, y deja la medición de tiempos a un profiler
 * externo de Java.
 *
 * @author Carlos Altán 25772
 * @author Sergio Tepaz
 */
public class Main {

    /**
     * Método principal del programa.
     *
     * Genera conjuntos de datos de tamaño definido, ejecuta
     * los algoritmos de ordenamiento implementados en
     * {@link SortingClass} y registra la ejecución.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     * @throws IOException si ocurre un error al escribir el archivo CSV
     */
    public static void main(String[] args) throws IOException {
        GenerateFile file = new GenerateFile();
        SortingClass sortingClass = new SortingClass();
        int[] sizes = {100000};

        String csvFile = "resultados_sorting.csv";

        System.out.println("========================================");
        System.out.println("Iniciando generación de datos...");
        System.out.println("========================================");

        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            writer.println("n,ejecucion");

            for (int n : sizes) {
                System.out.println("Procesando N = " + n);

                file.generateRandomNumbers(n);
                Integer[] datosBase = file.readFromFile();

                Integer[] datosOrdenados = datosBase.clone();
                Arrays.sort(datosOrdenados);

                // Datos ordenados
                ejecutarGnomeSort(sortingClass, datosOrdenados.clone());
                ejecutarMergeSort(sortingClass, datosOrdenados.clone());
                ejecutarQuickSort(sortingClass, datosOrdenados.clone());
                ejecutarRadixSort(sortingClass, datosOrdenados.clone());
                ejecutarInsertionSort(sortingClass, datosOrdenados.clone());

                // Datos desordenados
                ejecutarGnomeSort(sortingClass, datosBase.clone());
                ejecutarMergeSort(sortingClass, datosBase.clone());
                ejecutarQuickSort(sortingClass, datosBase.clone());
                ejecutarRadixSort(sortingClass, datosBase.clone());
                ejecutarInsertionSort(sortingClass, datosBase.clone());

                writer.println(n + ",ok");
                System.out.println("Completado\n");
            }
        }

        System.out.println("========================================");
        System.out.println("Proceso finalizado");
        System.out.println("========================================");
    }

    /**
     * Ejecuta el algoritmo Gnome Sort.
     *
     * @param sortingClass instancia que contiene los algoritmos de ordenamiento
     * @param data arreglo de datos a ordenar
     */
    private static void ejecutarGnomeSort(SortingClass sortingClass, Integer[] data) {
        sortingClass.gnomeSort(data);
    }

    /**
     * Ejecuta el algoritmo Merge Sort.
     *
     * @param sortingClass instancia que contiene los algoritmos de ordenamiento
     * @param data arreglo de datos a ordenar
     */
    private static void ejecutarMergeSort(SortingClass sortingClass, Integer[] data) {
        sortingClass.mergeSort(data);
    }

    /**
     * Ejecuta el algoritmo Quick Sort.
     *
     * @param sortingClass instancia que contiene los algoritmos de ordenamiento
     * @param data arreglo de datos a ordenar
     */
    private static void ejecutarQuickSort(SortingClass sortingClass, Integer[] data) {
        sortingClass.quickSort(data);
    }

    /**
     * Ejecuta el algoritmo Radix Sort.
     *
     * Este método solo aplica para arreglos de tipo
     *
     * @param sortingClass instancia que contiene los algoritmos de ordenamiento
     * @param data arreglo de enteros a ordenar
     */
    private static void ejecutarRadixSort(SortingClass sortingClass, Integer[] data) {
        sortingClass.radixSort(data);
    }

    /**
     * Ejecuta el algoritmo Insertion Sort.
     *
     * @param sortingClass instancia que contiene los algoritmos de ordenamiento
     * @param data arreglo de datos a ordenar
     */
    private static void ejecutarInsertionSort(SortingClass sortingClass, Integer[] data) {
        sortingClass.insertionSort(data);
    }
}
