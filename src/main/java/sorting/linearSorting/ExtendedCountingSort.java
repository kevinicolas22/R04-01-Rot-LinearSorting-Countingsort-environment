package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	
	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
	
        if (array == null || array.length <= 1 || leftIndex >= rightIndex) {
            return;
        }

        int minValue = findMinValue(array, leftIndex, rightIndex);
        int maxValue = findMaxValue(array, leftIndex, rightIndex);

        int range = maxValue - minValue + 1;
        int[] countArray = new int[range];

        for (int i = leftIndex; i <= rightIndex; i++) {
            countArray[array[i] - minValue]++;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        Integer[] outputArray = new Integer[array.length];
        for (int i = rightIndex; i >= leftIndex; i--) {
            outputArray[countArray[array[i] - minValue] - 1] = array[i];
            countArray[array[i] - minValue]--;
        }

        System.arraycopy(outputArray, leftIndex, array, leftIndex, rightIndex - leftIndex + 1);
    }

    private int findMinValue(Integer[] array, int leftIndex, int rightIndex) {
        int minValue = array[leftIndex];
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    private int findMaxValue(Integer[] array, int leftIndex, int rightIndex) {
        int maxValue = array[leftIndex];
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }
}
