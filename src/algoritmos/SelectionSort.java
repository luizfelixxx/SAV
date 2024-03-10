package algoritmos;

import utilidades.Impressora;

public class SelectionSort<T extends Comparable<T>> extends AlgoritmoClassificacao<T>{
    @Override
    public void aplicarOrdenacao(T[] elementos, String tipoOrdenamento) {
        int comprimento = elementos.length;
        long tempoInicial = System.currentTimeMillis();
        int trocasRealizadas = 0;

        for (int i = 0; i < comprimento - 1; i++){
            int index_menor = i;
            for (int j = i+1; j < comprimento; j++){
                if ((tipoOrdenamento.equals(ORDENACAO_CRESCENTE) && elementos[j].compareTo(elementos[index_menor]) < 0) ||
                    (tipoOrdenamento.equals(ORDENACAO_DECRESCENTE) && elementos[j].compareTo(elementos[index_menor]) > 0)) {
                    index_menor = j;
                }
            }
            T temporario = elementos[index_menor];
            elementos[index_menor] = elementos[i];
            elementos[i] = temporario;

            trocasRealizadas += 1;
            Impressora.imprimirArray(elementos);
            esperarTempo();
        }
        long tempoFinal = System.currentTimeMillis();
        long tempoPausaTotal = calcularTempoPausaTotal(trocasRealizadas);
        Impressora.imprimirTempoExecucao(calcularTempoExecucao(tempoFinal, tempoInicial, tempoPausaTotal));
    }
}
