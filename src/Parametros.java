import java.util.Arrays;
import algoritmos.*;

public class Parametros {
    public void validacaoParametros(String[] args){
        if (args.length < 3) {
            throw new IllegalArgumentException("Número insuficiente de argumentos.");
        }

        String tipo = args[0].substring(2);
        String valores = args[1].substring(2);
        String tipo_algoritmo = args[2].substring(2);

        switch (tipo) {
            case "n" -> {
                Integer[] numeros = validarNumerico(valores);
                escolherAlgoritmo(numeros, tipo_algoritmo);
            }
            case "c" -> {
                Character[] caracteres = validarCaracteres(valores);
                escolherAlgoritmo(caracteres, tipo_algoritmo);
            }
            default -> throw new IllegalArgumentException("Tipo de parâmetro inválido.");
        }
    }

    private Integer[] validarNumerico(String valores) {
        try {
            Integer[] numeros = Arrays.stream(valores.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            System.out.println("Tipo: [Numérico]");
            System.out.println("Valores: " + Arrays.toString(numeros));
            return numeros;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Erro: Valores inválidos para tipo numérico.");
        }
    }

    private Character[] validarCaracteres(String valores) {
        Character[] caracteres = Arrays.stream(valores.split(",")).map(valor -> valor.charAt(0)).toArray(Character[]::new);
        System.out.println("Tipo: [Caracteres]");
        System.out.println("Valores: " + Arrays.toString(caracteres));
        return caracteres;
    }
    private <T extends Comparable<T>> void escolherAlgoritmo(T[] valores, String algoritmo) {
        switch (algoritmo) {
            case "b" -> {
                BubbleSort<T> bubbleSort = new BubbleSort<>();
                bubbleSort.organizar(valores);
            }
            case "m" -> {
                MergeSort<T> mergeSort = new MergeSort<>();
                mergeSort.organizar(valores);
            }
            case "q" -> {
                QuickSort<T> quickSort = new QuickSort<>();
                quickSort.organizar(valores);
            }
            default -> throw new IllegalArgumentException("Algoritmo de ordenação inválido.");
        }
        System.out.println("Ordenação: " + Arrays.toString(valores));
    }
}
