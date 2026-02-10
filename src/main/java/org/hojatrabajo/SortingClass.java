package org.hojatrabajo;

import java.util.Arrays;

/**
 * Clase que contiene implementaciones de distintos
 * algoritmos de ordenamiento genéricos.
 * Carlos Altán
 * Sergio Tepaz
 */
public class SortingClass implements Comparable<SortingClass> {

    /**
     * Ordena un arreglo utilizando el algoritmo Gnome Sort.
     * @param <T>   tipo de dato comparable
     * @param array arreglo a ordenar
     */
    public <T extends Comparable<T>> void gnomeSort(T[] array) {
        int index = 0;
        while (index < array.length) {
            if (index == 0 || array[index].compareTo(array[index - 1]) >= 0) {
                index++;
            } else {
                T temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
    }

    /**
     * Ordena un arreglo utilizando el algoritmo Merge Sort.
     * @param <T>   tipo de dato comparable
     * @param array arreglo a ordenar
     */
    public <T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length < 2) {
            return;
        }

        int mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    /**
     * Combina dos arreglos ordenados en uno solo.
     * @param <T>   tipo de dato comparable
     * @param array arreglo resultante
     * @param left  subarreglo izquierdo
     * @param right subarreglo derecho
     */
    private <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    /**
     * Ordena un arreglo utilizando el algoritmo Quick Sort.
     * @param <T>   tipo de dato comparable
     * @param array arreglo a ordenar
     */
    public <T extends Comparable<T>> void quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Metodo recursivo auxiliar de Quick Sort.
     * @param <T>   tipo de dato comparable
     * @param array arreglo a ordenar
     * @param low   índice inferior del rango a ordenar
     * @param high  índice superior del rango a ordenar
     */
    private <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    /**
     * Particiona el arreglo para Quick Sort.
     * @param <T>   tipo de dato comparable
     * @param array arreglo a particionar
     * @param low   índice inferior
     * @param high  índice superior (usado como pivote)
     * @return índice final del pivote
     */
    private <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    /**
     * Ordena un arreglo utilizando el algoritmo Radix Sort.
     * @param array arreglo de enteros a ordenar
     */
    public void radixSort(Integer[] array) {
        if (array.length == 0) {
            return;
        }

        int max = getMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
    }

    /**
     * Encuentra el valor máximo en el arreglo.
     * Metodo auxiliar utilizado por radixSort.
     *
     * @param array arreglo de enteros
     * @return el valor máximo encontrado
     */
    private int getMax(Integer[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Realiza un counting sort basado en el dígito representado por exp.
     * Metodo auxiliar utilizado por radixSort.
     *
     * @param array arreglo a ordenar
     * @param exp   exponente que representa la posición del dígito (1, 10, 100, etc.)
     */
    private void countSort(Integer[] array, int exp) {
        int n = array.length;
        Integer[] output = new Integer[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (Integer integer : array) {
            count[(integer / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, array, 0, n);
    }

    /**
     * Ordena un arreglo utilizando el algoritmo Insertion Sort.
     * @param <T>   tipo de dato comparable
     * @param array arreglo a ordenar
     */
    public <T extends Comparable<T>> void insertionSort(T[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Implementación requerida por la interfaz Comparable.
     * @param o objeto a comparar
     */
    @Override
    public int compareTo(SortingClass o) {
        return 0;
    }
}