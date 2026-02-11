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

    private static void ejecutarGnomeSort(SortingClass sortingClass, Integer[] data) {
        sortingClass.gnomeSort(data);
    }

    private static void ejecutarMergeSort(SortingClass sortingClass, Integer[] data) {
        sortingClass.mergeSort(data);
    }

    private static void ejecutarQuickSort(SortingClass sortingClass, Integer[] data) {
        sortingClass.quickSort(data);
    }

    private static void ejecutarRadixSort(SortingClass sortingClass, Integer[] data) {
        sortingClass.radixSort(data);
    }

    private static void ejecutarInsertionSort(SortingClass sortingClass, Integer[] data) {
        sortingClass.insertionSort(data);
    }
}
