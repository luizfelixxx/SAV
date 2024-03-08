import java.util.Arrays;
import algoritmos.*;
import utilidades.Impressora;

public class Parametros {
    public void validacaoParametros(String[] args){
        if (args.length < 3) {
            throw new IllegalArgumentException("Número insuficiente de argumentos.");
        }

        String tipo = args[0].substring(2);
        String valores = args[1].substring(2);
        String tipo_algoritmo = args[2].substring(2);
        String tipo_ordenamento = args[3].substring(2);
        String tempo = (args[4].substring(2));

        int tempo_execucao = validarTempoExecucao(tempo);

        // Verificar se o tipo de ordenamento é válido
        if (!tipo_ordenamento.equals("az") && !tipo_ordenamento.equals("za")) {
            throw new IllegalArgumentException("Tipo de ordenamento inválido. Deve ser 'az' ou 'za'.");
        }

        switch (tipo) {
            case "n" -> {
                Integer[] numeros = validarNumerico(valores);
                escolherAlgoritmo(numeros, tipo_algoritmo, tipo_ordenamento, tempo_execucao);
            }
            case "c" -> {
                Character[] caracteres = validarCaracteres(valores);
                escolherAlgoritmo(caracteres, tipo_algoritmo, tipo_ordenamento, tempo_execucao);
            }
            default -> throw new IllegalArgumentException("Tipo de parâmetro inválido.");
        }

    }

    private Integer[] validarNumerico(String valores) {
        try {
            Integer[] numeros = Arrays.stream(valores.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            Impressora.imprimirValores("Númerico", numeros);
            return numeros;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Erro: Valores inválidos para tipo numérico.");
        }
    }

    private Character[] validarCaracteres(String valores) {
        Character[] caracteres = Arrays.stream(valores.split(",")).map(valor -> valor.charAt(0)).toArray(Character[]::new);
        Impressora.imprimirValores("Númerico", caracteres);
        return caracteres;
    }
    private <T extends Comparable<T>> void escolherAlgoritmo(T[] valores, String algoritmo,  String tipoOrdenamento,
                                                             int tempo_execucao) {
        AlgoritmoClassificacao<T> sorter;
        switch (algoritmo) {
                case "b" -> sorter = new BubbleSort<>();
                case "m" -> sorter = new MergeSort<>();
                case "q" -> sorter = new QuickSort<>();
                default -> throw new IllegalArgumentException("Algoritmo de ordenação inválido.");
        }
        sorter.setTempoPausaExecucao(tempo_execucao);
        sorter.organizar(valores, tipoOrdenamento);

    }
    private int validarTempoExecucao(String tempo){
        try{
            return Integer.parseInt(tempo);
        } catch (NumberFormatException exception){
            System.out.println(exception.getMessage());
            return 100;
        }
    }
}
