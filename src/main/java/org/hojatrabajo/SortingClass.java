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
     *
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
     *
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
     *
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
     * Implementación requerida por la interfaz Comparable.
     *
     * @param o objeto a comparar
     * @return valor de comparación
     */
    @Override
    public int compareTo(SortingClass o) {
        return 0;
    }
}
