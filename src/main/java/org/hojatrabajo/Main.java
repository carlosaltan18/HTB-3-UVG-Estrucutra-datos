package org.hojatrabajo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Clase principal que ejecuta pruebas de rendimiento
 * @author Carlos Altán 25772
 * @author Sergio Tepaz
 */
public class Main {

    /**
     * Método principal del programa.
     * @param args argumentos de línea de comandos (no utilizados)
     * @throws IOException si ocurre un error al leer o escribir archivos
     */
    public static void main(String[] args) throws IOException {
        GenerateFile file = new GenerateFile();
        SortingClass sortingClass = new SortingClass();
        int[] sizes = {10, 100, 500, 1000, 2000, 3000};

        String csvFile = "resultados_sorting.csv";

        System.out.println("========================================");
        System.out.println("Iniciando generación de datos...");
        System.out.println("========================================");
        System.out.println("Archivo de salida: " + csvFile);
        System.out.println();

        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            writer.println("n,gnomesort ordenado,mergesort ordenado,quicksort ordenado,radixsort ordenado,insertionsort ordenado,gnome desordenado,merge desordenado,quick desordenado,radix desordenado,insertion desordenado");

            for (int n : sizes) {
                System.out.println("Procesando N = " + n);
                System.out.println("----------------------------------------");
                file.generateRandomNumbers(n);
                Integer[] datosBase = file.readFromFile();

                Integer[] datosOrdenados = datosBase.clone();
                Arrays.sort(datosOrdenados);

                System.out.println("  Midiendo con datos ordenados...");
                double gnomeOrd = medirGnomeSort(sortingClass, datosOrdenados.clone());
                double mergeOrd = medirMergeSort(sortingClass, datosOrdenados.clone());
                double quickOrd = medirQuickSort(sortingClass, datosOrdenados.clone());
                double radixOrd = medirRadixSort(sortingClass, datosOrdenados.clone());
                double insertOrd = medirInsertionSort(sortingClass, datosOrdenados.clone());

                System.out.println("  Midiendo con datos desordenados...");
                double gnomeDesord = medirGnomeSort(sortingClass, datosBase.clone());
                double mergeDesord = medirMergeSort(sortingClass, datosBase.clone());
                double quickDesord = medirQuickSort(sortingClass, datosBase.clone());
                double radixDesord = medirRadixSort(sortingClass, datosBase.clone());
                double insertDesord = medirInsertionSort(sortingClass, datosBase.clone());

                writer.printf("%d,%.4f,%.4f,%.4f,%.4f,%.4f,%.4f,%.4f,%.4f,%.4f,%.4f\n",
                        n,
                        gnomeOrd, mergeOrd, quickOrd, radixOrd, insertOrd,
                        gnomeDesord, mergeDesord, quickDesord, radixDesord, insertDesord);

                System.out.println("Completado");
                System.out.println();
            }
        }

        System.out.println("========================================");
        System.out.println("Proceso finalizado");
        System.out.println("========================================");
        System.out.println("Archivo generado: " + csvFile);
        System.out.println();
        System.out.println("Estructura del CSV:");
        System.out.println("  - Columnas 1-6: Datos ORDENADOS");
        System.out.println("    (gnome, merge, quick, radix, insertion)");
        System.out.println("  - Columnas 7-11: Datos DESORDENADOS");
        System.out.println("    (gnome, merge, quick, radix, insertion)");
        System.out.println();
    }

    /**
     * Mide el tiempo de ejecución del algoritmo Gnome Sort.
     *
     * @param sortingClass instancia de la clase con los algoritmos
     * @param data         arreglo de datos a ordenar
     * @return tiempo de ejecución en milisegundos
     */
    private static double medirGnomeSort(SortingClass sortingClass, Integer[] data) {
        long startTime = System.nanoTime();
        sortingClass.gnomeSort(data);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000.0;
    }

    /**
     * Mide el tiempo de ejecución del algoritmo Merge Sort.
     *
     * @param sortingClass instancia de la clase con los algoritmos
     * @param data         arreglo de datos a ordenar
     * @return tiempo de ejecución en milisegundos
     */
    private static double medirMergeSort(SortingClass sortingClass, Integer[] data) {
        long startTime = System.nanoTime();
        sortingClass.mergeSort(data);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000.0;
    }

    /**
     * Mide el tiempo de ejecución del algoritmo Quick Sort.
     *
     * @param sortingClass instancia de la clase con los algoritmos
     * @param data         arreglo de datos a ordenar
     * @return tiempo de ejecución en milisegundos
     */
    private static double medirQuickSort(SortingClass sortingClass, Integer[] data) {
        long startTime = System.nanoTime();
        sortingClass.quickSort(data);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000.0;
    }

    /**
     * Mide el tiempo de ejecución del algoritmo Radix Sort.
     *
     * @param sortingClass instancia de la clase con los algoritmos
     * @param data         arreglo de datos a ordenar
     * @return tiempo de ejecución en milisegundos
     */
    private static double medirRadixSort(SortingClass sortingClass, Integer[] data) {
        long startTime = System.nanoTime();
        sortingClass.radixSort(data);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000.0;
    }

    /**
     * Mide el tiempo de ejecución del algoritmo Insertion Sort.
     *
     * @param sortingClass instancia de la clase con los algoritmos
     * @param data         arreglo de datos a ordenar
     * @return tiempo de ejecución en milisegundos
     */
    private static double medirInsertionSort(SortingClass sortingClass, Integer[] data) {
        long startTime = System.nanoTime();
        sortingClass.insertionSort(data);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000.0;
    }
}