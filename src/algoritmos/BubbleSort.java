package algoritmos;

import utilidades.Impressora;


public class BubbleSort<T extends Comparable<T>> extends AlgoritmoClassificacao<T>{
    @Override
    public void organizar(T[] elementos, String tipoOrdenamento) {
        int comprimento = elementos.length;
        boolean trocou;
        long tempoInicial = System.currentTimeMillis();
        long tempoPausa = 0;
        do {
            trocou = false;
            for (int i = 0; i < comprimento - 1; i++) {
                
                if (tipoOrdenamento.equals("az") && elementos[i].compareTo(elementos[i + 1]) > 0 ||
                    tipoOrdenamento.equals("za") && elementos[i].compareTo(elementos[i + 1]) < 0) {
                    T temporario = elementos[i];
                    elementos[i] = elementos[i + 1];
                    elementos[i + 1] = temporario;
                    trocou = true;

                    Impressora.imprimirArray(elementos);

                    try{
                        Thread.sleep(this.tempoPausaExecucao);
                        tempoPausa += tempoPausaExecucao;
                    } catch (InterruptedException exception){
                        System.out.println(exception.getMessage());
                    }
                }
            }

        } while (trocou);
        long tempoFinal = System.currentTimeMillis();
        Impressora.imprimirTempoExecucao(calcularTempoExecucao(tempoFinal, tempoInicial, tempoPausa));
    }
}