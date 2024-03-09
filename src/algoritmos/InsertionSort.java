package algoritmos;

import utilidades.Impressora;
// Falta consertar a lógica da ordenação - 08/03 00h23
public class InsertionSort<T extends Comparable<T>> extends AlgoritmoClassificacao<T>{
    @Override
    public void aplicarOrdenacao(T[] elementos, String tipoOrdenamento) {
        int comprimento = elementos.length;
        long tempoInicial = System.currentTimeMillis();
        int trocasRealizadas = 0;

        for (int i = 1; i < comprimento ; i++) {
            T chave = elementos[i];
            int j = i - 1;

            while (j >= 0 && (tipoOrdenamento.equals(ORDENACAO_CRESCENTE) && elementos[j].compareTo(chave) > 0 ||
                    tipoOrdenamento.equals(ORDENACAO_DECRESCENTE) && elementos[j].compareTo(chave) < 0)) {
                elementos[j + 1] = elementos[j];
                j = j - 1;
                trocasRealizadas += 1;

                esperarTempo();
            }
            elementos[j + 1] = chave;
            Impressora.imprimirArray(elementos);
        }
        long tempoFinal = System.currentTimeMillis();
        long tempoPausaTotal = calcularTempoPausaTotal(trocasRealizadas);
        Impressora.imprimirTempoExecucao(calcularTempoExecucao(tempoFinal, tempoInicial, tempoPausaTotal));
    }
}
