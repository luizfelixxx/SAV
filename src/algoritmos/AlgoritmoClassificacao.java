package algoritmos;

public abstract class AlgoritmoClassificacao <T extends Comparable<T>>{
    protected int tempoPausaExecucao;
    public abstract void organizar(T[] arg, String tipoOrdenamento);

    public void setTempoPausaExecucao(int tempoPausaExecucao) {
        this.tempoPausaExecucao = tempoPausaExecucao;
    }
    protected static double calcularTempoExecucao(long tempoFinal, long tempoInicial, long tempoPausa){
        long tempoPercorrido = tempoFinal - tempoInicial - tempoPausa;
        return (double) tempoPercorrido / 1000;
    }
}