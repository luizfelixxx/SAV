package utilidades;

import java.util.Arrays;

public class Validacao {
    public static Integer[] validarValoresNumerico(String valores) {
        try {
            Integer[] numeros = Arrays.stream(valores.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            Impressora.imprimirValores("Númerico", numeros);
            return numeros;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Erro: Valores inválidos para tipo numérico.");
        }
    }

    public static Character[] validarValoresCaracteres(String valores) {
        Character[] caracteres = Arrays.stream(valores.split(",")).map(valor -> valor.charAt(0)).toArray(Character[]::new);
        Impressora.imprimirValores("Númerico", caracteres);
        return caracteres;
    }

    public static int validarTempoExecucao(String tempo){
        try{
            return Integer.parseInt(tempo);
        } catch (NumberFormatException exception){
            System.out.println(exception.getMessage());
            return 100;
        }
    }
    public static void validarTipoOrdenamento(String tipoOrdenamento){
        if (!tipoOrdenamento.equals("az") && !tipoOrdenamento.equals("za")) {
            throw new IllegalArgumentException("Tipo de ordenamento inválido. Deve ser 'az' ou 'za'.");
        }
    }
}
