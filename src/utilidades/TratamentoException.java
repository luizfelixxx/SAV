package utilidades;

public class TratamentoException {
    public static void lidarComInterrupcaoThread(InterruptedException exception) {
        System.out.println("A operação foi interrompida: " + exception.getMessage());
        Thread.currentThread().interrupt();
    }
}
