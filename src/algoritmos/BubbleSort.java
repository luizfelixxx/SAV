package algoritmos;

import utilidades.Impressora;

public class BubbleSort<T extends Comparable<T>> extends AlgoritmoClassificacao<T>{
    @Override
    public void aplicarOrdenacao(T[] elementos, String tipoOrdenamento) {
        int comprimento = elementos.length; int trocasRealizadas = 0;
        boolean trocou;
        long tempoInicial = System.currentTimeMillis();

        do {
            trocou = false;
            for (int i = 0; i < comprimento - 1; i++) {
                
                if (tipoOrdenamento.equals(ORDENACAO_CRESCENTE) && elementos[i].compareTo(elementos[i + 1]) > 0 ||
                    tipoOrdenamento.equals(ORDENACAO_DECRESCENTE) && elementos[i].compareTo(elementos[i + 1]) < 0) {
                    T temporario = elementos[i];
                    elementos[i] = elementos[i + 1];
                    elementos[i + 1] = temporario;

                    trocou = true;
                    trocasRealizadas += 1;

                    Impressora.imprimirArray(elementos);
                    esperarTempo();
                }
            }
        } while (trocou);
        long tempoFinal = System.currentTimeMillis();
        long tempoPausaTotal = calcularTempoPausaTotal(trocasRealizadas);
        Impressora.imprimirTempoExecucao(calcularTempoExecucao(tempoFinal, tempoInicial, tempoPausaTotal));
    }
}