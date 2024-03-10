package utilidades;

import java.util.Arrays;

public class Impressora {
    public static <T> void imprimirValores(T[] valores){
        System.out.println("Valores: " + Arrays.toString(valores));
    }
    public static <T> void imprimirArray(T[] valores){
        System.out.println(Arrays.toString(valores));
    }
    public static void imprimirTempoExecucao(double valor){
        System.out.println("Tempo execução: " + valor);
    }
    public static void imprimirDados(String tipo, String valores, String tipoAlgortimo, String tipoOrdenamento,
                                     int tempoExecucao, String valorLista, int quantidadeValoresAleatorios) {
        String tipoOrdenamentoExibir = tipoOrdenamento.equals("az") ? "Ordem Crescente" :
                tipoOrdenamento.equals("za") ? "Ordem Decrescente" : null;

        String tipoAlgortimoExibir = switch (tipoAlgortimo) {
            case "s" -> "Selection";
            case "i" -> "Insertion";
            case "b" -> "Bubble";
            default -> null;
        };

        String tipoExibir = tipo.equals("n") ? "Númerico" :
                tipo.equals("c") ? "Caracteres" : null;

        System.out.println("Tipo: " + tipoExibir
                + "\nValores: " + valores
                + "\nTipo de Algoritmo: " + tipoAlgortimoExibir
                + "\nTipo de Ordenamento: " + tipoOrdenamentoExibir
                + "\nTempo de Execução: " + tempoExecucao
                + "\nValor da Lista: " + valorLista
                + "\nQuantidade de Valores Aleatórios: " + quantidadeValoresAleatorios + "\n");
    }
}