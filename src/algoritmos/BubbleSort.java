package algoritmos;

public class BubbleSort<T extends Comparable<T>> extends AlgoritmoClassificacao<T>{
    @Override
    public void organizar(T[] elementos) {
        int comprimento = elementos.length;
        for (int i = 0; i < comprimento - 1; i++) {
            for (int j = 0; j < comprimento - i - 1; j++) {
                if (elementos[j].compareTo(elementos[j + 1]) > 0) {
                    T temporario = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = temporario;
                }
            }
        }
    }
}
