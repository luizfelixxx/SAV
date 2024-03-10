package utilidades;

import java.util.HashMap;
import java.util.Map;


public class Argumentos {
    private static final String TIPO = "t";
    private static final String VALORES = "v";
    private static final String ALGORITMO = "a";
    private static final String ORDENAMENTO = "o";
    private static final String TEMPO = "s";
    private static final String VALOR_LISTA = "in";
    private static final String QUANTIDADE_VALORES_ALEATORIOS = "r";
    private final Map<String, String> mapa = new HashMap<>();

    public void processarParametros(String[] args) {
        extrairParametros(args);
        // Falta resolver a questão para transformar tudo em lowerCase
        String tipo = Validacao.validarArgumentoTipo(mapa, TIPO);
        String valores = mapa.get(VALORES); // Sem validaçãoArgumento
        String tipoAlgoritmo = Validacao.validarTipoAlgoritmo(mapa, ALGORITMO);
        String tipoOrdenamento = Validacao.validarTipoOrdenamento(mapa, ORDENAMENTO);
        String tipoValorLista = Validacao.validarTipoValorLista(mapa, VALOR_LISTA);
        int tempoExecucao = Validacao.validarTempoExecucao(mapa, TEMPO);

        if (tipoValorLista.equals("r")) {
            int quantidadeValoresAleatorios = Validacao.validarQuantidadeValoresAleatorios(mapa, QUANTIDADE_VALORES_ALEATORIOS);
            String valoresAleatorios = switch (tipo) {
                case "n" -> GeradorValores.gerarValoresNumericosAleatorios(quantidadeValoresAleatorios);
                case "c" -> GeradorValores.gerarValoresCaracateresAleatorios(quantidadeValoresAleatorios);
                default -> throw new IllegalArgumentException("Tipo de dados inválido. Use 'n' para números ou 'c' para caracteres.");
            };
            Impressora.imprimirDados(tipo, valoresAleatorios, mapa.get(ALGORITMO), tipoOrdenamento, tempoExecucao,
                    "Aleatório", quantidadeValoresAleatorios);
            processarTipo(tipo, valoresAleatorios, tipoAlgoritmo, tipoOrdenamento, tempoExecucao);
        }
        else if (tipoValorLista.equals("m")) {
            Impressora.imprimirDados(tipo, valores, mapa.get(ALGORITMO), tipoOrdenamento, tempoExecucao,
                    "Usuário", 0);
            processarTipo(tipo, valores, tipoAlgoritmo, tipoOrdenamento, tempoExecucao);
        }
    }
    private void extrairParametros(String[] args){
        for (String arg: args){
            String[] partes = arg.split("=");
            if (partes.length == 2){
                mapa.put(partes[0], partes[1]);
            }
        }
    }
    private void processarTipo(String tipo, String valores, String tipoAlgoritmo, String tipoOrdenamento,
                               int tempoExecucao) {
        switch (tipo) {
            case "n" -> processarValoresNumericos(valores, tipoAlgoritmo, tipoOrdenamento, tempoExecucao);
            case "c" -> processarValoresCaracteres(valores, tipoAlgoritmo, tipoOrdenamento, tempoExecucao);
            default -> throw new IllegalArgumentException("Tipo de parâmetro inválido.");
        }
    }
    private void processarValoresNumericos(String valores, String tipoAlgoritmo, String tipoOrdenamento,
                                           int tempoExecucao) {
        Integer[] numeros = Validacao.validarValoresNumerico(valores);
        Ordenador.escolherAlgoritmo(numeros, tipoAlgoritmo, tipoOrdenamento, tempoExecucao);
    }
    private void processarValoresCaracteres(String valores, String tipoAlgoritmo, String tipoOrdenamento,
                                            int tempoExecucao) {
        Character[] caracteres = Validacao.validarValoresCaracteres(valores);
        Ordenador.escolherAlgoritmo(caracteres, tipoAlgoritmo, tipoOrdenamento, tempoExecucao);
    }
}