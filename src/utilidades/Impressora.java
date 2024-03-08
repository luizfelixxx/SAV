package utilidades;

import java.util.Arrays;

public class Impressora {
    public static <T> void imprimirValores(String tipo, T[] valores){
        System.out.println("Tipo: [" + tipo + "]");
        System.out.println("Valores: " + Arrays.toString(valores));
    }
    public static <T> void imprimirArray(T[] valores){
        System.out.println(Arrays.toString(valores));
    }

    public static void imprimirTempoExecucao(double valor){
        System.out.println(valor);
    }
}