package utilidades;

public class TempoUtil {
    public static void esperarTempo(int tempoPausaExecucao) {
        try {
            Thread.sleep(tempoPausaExecucao);
        } catch (InterruptedException exception) {
            TratamentoException.lidarComInterrupcaoThread(exception);
        }
    }
    public static long calcularTempoPausaTotal(int tempoPausaExecucao, int trocasRealizadas) {
        return (long) tempoPausaExecucao * trocasRealizadas;
    }

}
