package utilidades;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class GeradorValores {
    public static String gerarValoresNumericosAleatorios(int quantidadeValoresAleatorios){
        Random random = new Random();
        int[] valoresAleatoriosInt = new int[quantidadeValoresAleatorios];

        for (int i = 0; i < quantidadeValoresAleatorios; i++){
            int valorAleatorio = random.nextInt(2000);
            valoresAleatoriosInt[i] = valorAleatorio - 1000;
        }
        return Arrays.stream(valoresAleatoriosInt).mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }
    public static String gerarValoresCaracateresAleatorios(int quantidadeValoresAleatorios){
        Random random = new Random();
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < quantidadeValoresAleatorios; i++){
            int valorAleatorio = random.nextInt(52);
            char letra = (char) ((valorAleatorio < 26) ? 'a' + valorAleatorio: 'A' + valorAleatorio - 26);
            resultado.append(letra).append(",");
        }
        return resultado.toString();
    }
}
