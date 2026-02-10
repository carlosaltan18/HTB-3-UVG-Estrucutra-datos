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

    /**
     * Prueba Quick Sort con un arreglo desordenado.
     * Verifica que el algoritmo ordene correctamente elementos aleatorios.
     */
    @Test
    public void testQuickSortDesordenado() {
        Integer[] input = {10, 7, 8, 9, 1, 5};
        Integer[] expected = {1, 5, 7, 8, 9, 10};

        sorting.quickSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Quick Sort con un arreglo previamente ordenado.
     * Verifica que el algoritmo maneje el peor caso eficientemente.
     */
    @Test
    public void testQuickSortOrdenado() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        sorting.quickSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Quick Sort con un arreglo ordenado en forma inversa.
     * Verifica que el algoritmo maneje correctamente el orden inverso.
     */
    @Test
    public void testQuickSortInverso() {
        Integer[] input = {9, 7, 5, 3, 1};
        Integer[] expected = {1, 3, 5, 7, 9};

        sorting.quickSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Quick Sort con elementos repetidos.
     * Verifica que el algoritmo maneje correctamente duplicados.
     */
    @Test
    public void testQuickSortConRepetidos() {
        Integer[] input = {4, 2, 4, 1, 2};
        Integer[] expected = {1, 2, 2, 4, 4};

        sorting.quickSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Radix Sort con un arreglo desordenado.
     * Verifica que el algoritmo ordene correctamente números de varios dígitos.
     */
    @Test
    public void testRadixSortDesordenado() {
        Integer[] input = {170, 45, 75, 90, 802, 24, 2, 66};
        Integer[] expected = {2, 24, 45, 66, 75, 90, 170, 802};

        sorting.radixSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Radix Sort con un arreglo previamente ordenado.
     * Verifica el mejor caso del algoritmo.
     */
    @Test
    public void testRadixSortOrdenado() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        sorting.radixSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Radix Sort con elementos repetidos.
     * Verifica que el algoritmo maneje correctamente duplicados.
     */
    @Test
    public void testRadixSortConRepetidos() {
        Integer[] input = {100, 50, 100, 25, 50};
        Integer[] expected = {25, 50, 50, 100, 100};

        sorting.radixSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Insertion Sort con un arreglo desordenado.
     * Verifica que el algoritmo ordene correctamente elementos aleatorios.
     */
    @Test
    public void testInsertionSortDesordenado() {
        Integer[] input = {12, 11, 13, 5, 6};
        Integer[] expected = {5, 6, 11, 12, 13};

        sorting.insertionSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Insertion Sort con un arreglo previamente ordenado.
     * Verifica el mejor caso del algoritmo (O(n)).
     */
    @Test
    public void testInsertionSortOrdenado() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        sorting.insertionSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Insertion Sort con un arreglo ordenado en forma inversa.
     * Verifica el peor caso del algoritmo (O(n²)).
     */
    @Test
    public void testInsertionSortInverso() {
        Integer[] input = {9, 7, 5, 3, 1};
        Integer[] expected = {1, 3, 5, 7, 9};

        sorting.insertionSort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Prueba Insertion Sort con elementos repetidos.
     * Verifica que el algoritmo maneje correctamente duplicados.
     */
    @Test
    public void testInsertionSortConRepetidos() {
        Integer[] input = {4, 2, 4, 1, 2};
        Integer[] expected = {1, 2, 2, 4, 4};

        sorting.insertionSort(input);

        assertArrayEquals(expected, input);
    }
}