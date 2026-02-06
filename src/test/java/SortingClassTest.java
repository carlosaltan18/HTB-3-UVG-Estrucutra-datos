import org.hojatrabajo.SortingClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Clase de pruebas unitarias para verificar el correcto
 * funcionamiento de los algoritmos de ordenamiento
 * implementados en la clase SortingClass.
 */
public class SortingClassTest {

    /**
     * Instancia de la clase SortingClass utilizada
     * para ejecutar los métodos de ordenamiento.
     */
    private final SortingClass sorting = new SortingClass();

    /**
     * Prueba Gnome Sort con un arreglo desordenado.
     */
    @Test
    public void testGnomeSortDesordenado() {
        Integer[] input = {5, 3, 8, 1, 2};
        Integer[] expected = {1, 2, 3, 5, 8};

        sorting.gnomeSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Gnome Sort con un arreglo previamente ordenado.
     */
    @Test
    public void testGnomeSortOrdenado() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        sorting.gnomeSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Gnome Sort con un arreglo ordenado en forma inversa.
     */
    @Test
    public void testGnomeSortInverso() {
        Integer[] input = {9, 7, 5, 3, 1};
        Integer[] expected = {1, 3, 5, 7, 9};

        sorting.gnomeSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Gnome Sort con elementos repetidos.
     */
    @Test
    public void testGnomeSortConRepetidos() {
        Integer[] input = {4, 2, 4, 1, 2};
        Integer[] expected = {1, 2, 2, 4, 4};

        sorting.gnomeSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Merge Sort con un arreglo desordenado.
     */
    @Test
    public void testMergeSortDesordenado() {
        Integer[] input = {10, 7, 3, 8, 2};
        Integer[] expected = {2, 3, 7, 8, 10};

        sorting.mergeSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Merge Sort con un arreglo previamente ordenado.
     */
    @Test
    public void testMergeSortOrdenado() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        sorting.mergeSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Merge Sort con un arreglo ordenado en forma inversa.
     */
    @Test
    public void testMergeSortInverso() {
        Integer[] input = {6, 5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5, 6};

        sorting.mergeSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Merge Sort con elementos repetidos.
     */
    @Test
    public void testMergeSortConRepetidos() {
        Integer[] input = {3, 1, 2, 3, 1};
        Integer[] expected = {1, 1, 2, 3, 3};

        sorting.mergeSort(input);

        assertArrayEquals(expected, input);
    }
}
