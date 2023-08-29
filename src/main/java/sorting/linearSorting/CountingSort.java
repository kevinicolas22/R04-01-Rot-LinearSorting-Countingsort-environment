package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
        if (array == null || array.length <= 1 || leftIndex >= rightIndex) {
            return;
        }

        // Encontra o maior elemento no array
        int max = array[leftIndex];
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // Cria um array de contagem para armazenar a contagem de cada elemento
        int[] countArray = new int[max + 1];

        // Conta a ocorrência de cada elemento no array original
        for (int i = leftIndex; i <= rightIndex; i++) {
            countArray[array[i]]++;
        }

        // Atualiza o array original com os elementos ordenados
        int outputIndex = leftIndex;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                array[outputIndex] = i;
                outputIndex++;
                countArray[i]--;
            }
        }
    }
}
