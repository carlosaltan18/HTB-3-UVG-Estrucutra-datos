package org.hojatrabajo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Clase encargada de generar un archivo con números aleatorios
 * y leer dichos números desde el archivo.
 */
public class GenerateFile {

    /**
     * Nombre y ruta del archivo donde se almacenan los datos.
     */
    private static final String FILE_NAME = "./docs/datos.txt";

    /**
     * Genera un archivo con una cantidad específica de números aleatorios.
     *
     * @param amount cantidad de números a generar
     * @throws IOException si ocurre un error al escribir el archivo
     */
    public static void generateRandomNumbers(int amount) throws IOException {
        Random rand = new Random();
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < amount; i++) {
                writer.println(rand.nextInt(10000));
            }
        }
    }

    /**
     * Lee los números almacenados en el archivo y los devuelve en un arreglo.
     *
     * @return arreglo de números enteros leídos desde el archivo
     * @throws IOException si ocurre un error al leer el archivo
     */
    public static Integer[] readFromFile() throws IOException {
        List<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
        }
        return list.toArray(new Integer[0]);
    }
}
