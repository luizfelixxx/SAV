package algoritmos;

import utilidades.TempoUtil;

public abstract class AlgoritmoClassificacao <T extends Comparable<T>>{
    protected int tempoPausaExecucao;
    protected static final String ORDENACAO_CRESCENTE = "az";
    protected static final String ORDENACAO_DECRESCENTE = "za";
    public abstract void aplicarOrdenacao(T[] arg, String tipoOrdenamento);
    public void setTempoPausaExecucao(int tempoPausaExecucao) {
        this.tempoPausaExecucao = tempoPausaExecucao;
    }
    protected static double calcularTempoExecucao(long tempoFinal, long tempoInicial, long tempoPausa){
        long tempoPercorrido = tempoFinal - tempoInicial - tempoPausa;
        return (double) tempoPercorrido / 1000;
    }
    protected void esperarTempo() {
        TempoUtil.esperarTempo(this.tempoPausaExecucao);
    }
    protected long calcularTempoPausaTotal(int trocasRealizadas){
        return TempoUtil.calcularTempoPausaTotal(this.tempoPausaExecucao, trocasRealizadas);
    }
}