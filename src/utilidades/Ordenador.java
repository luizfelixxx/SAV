package utilidades;

import algoritmos.*;
public class Ordenador {
    public static <T extends Comparable<T>> void escolherAlgoritmo(T[] valores, String algoritmo,  String tipoOrdenamento,
                                                                   int tempo_execucao) {
        AlgoritmoClassificacao<T> sorter;
        switch (algoritmo) {
            case "b" -> sorter = new BubbleSort<>();
            case "i" -> sorter = new InsertionSort<>();
            case "s" -> sorter = new SelectionSort<>();
            default -> throw new IllegalArgumentException("Algoritmo de ordenação inválido.");
        }
        sorter.setTempoPausaExecucao(tempo_execucao);
        sorter.aplicarOrdenacao(valores, tipoOrdenamento);
    }
}
