package utilidades;

import java.util.Arrays;
import java.util.Map;

public class Validacao {
    public static Integer[] validarValoresNumerico(String valores) {
        try {
            Integer[] numeros = Arrays.stream(valores.split(",")).map(String::trim).map(Integer::parseInt).toArray(Integer[]::new);
            Impressora.imprimirValores(numeros);
            return numeros;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Erro: Valores inválidos para tipo numérico.");
        }
    }

    public static Character[] validarValoresCaracteres(String valores) {
        Character[] caracteres = Arrays.stream(valores.split(",")).map(valor -> valor.charAt(0)).toArray(Character[]::new);
        Impressora.imprimirValores(caracteres);
        return caracteres;
    }

    public static int validarTempoExecucao(Map<String, String> mapa, String tempo){
        String obterTempoExecucao = mapa.get(tempo);
        if(obterTempoExecucao != null && obterTempoExecucao.matches("^(?:[1-9][0-9]{2}|1000)$")){
            return Integer.parseInt(obterTempoExecucao);
        }else{
            throw new IllegalArgumentException("Valor inválido! Utilize um número entre 100-1000");
        }
    }
    public static String validarTipoOrdenamento(Map<String, String> mapa, String tipoOrdenamento){
        String obterTipoOrdenamento = mapa.get(tipoOrdenamento);
        if (obterTipoOrdenamento != null && obterTipoOrdenamento.matches("^(az|za)$")) {
            return obterTipoOrdenamento;
        }
        else{
            throw new IllegalArgumentException("tipoOrdenamento deve ser 'az' ou 'za'");
        }
    }
    public static String validarTipoValorLista(Map<String, String> mapa, String tipoValorLista) {
        String obterTipoValorLista = mapa.get(tipoValorLista);
        if (obterTipoValorLista != null && obterTipoValorLista.matches("[rm]")){
            return obterTipoValorLista;
        }
        else{
            throw new IllegalArgumentException("Tipo de valor inválido. Use 'r' para " +
                    "valores aleatórios ou 'm' para valores manuais.");
        }
    }
    public static int validarQuantidadeValoresAleatorios(Map<String, String> mapa, String quantidadeValoresAleatorios){
        String obterQuantiadeValoresAleatorios = mapa.get(quantidadeValoresAleatorios);
        if (obterQuantiadeValoresAleatorios != null && obterQuantiadeValoresAleatorios.matches("[1-9]|[1-3][0-9]|40")){
            return Integer.parseInt(obterQuantiadeValoresAleatorios);
        }
        else{
            throw new IllegalArgumentException("A quantidade de valores aleatórios deve ser um número inteiro entre 1-40");
        }
    }
    public static String validarArgumentoTipo(Map<String, String> mapa, String tipo) {
        String obterTipo = mapa.get(tipo);
        if (obterTipo != null && obterTipo.matches("[nc]")) {
            return obterTipo;
        } else {
            throw new IllegalArgumentException("Valor de tipo inválido. Use 'n' ou 'c'.");
        }
    }
    public static String validarTipoAlgoritmo(Map<String, String> mapa, String tipoAlgoritmo) {
        String obterTipoAlgortimo = mapa.get(tipoAlgoritmo);
        System.out.println(obterTipoAlgortimo);
        if (obterTipoAlgortimo != null && obterTipoAlgortimo.matches("^[sib]$")) {
            return obterTipoAlgortimo;
        }else{
            throw new IllegalArgumentException("Valor inválido. Utilize 's'', 'i' ou 'b'");
        }
    }
}