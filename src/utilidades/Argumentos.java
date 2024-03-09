package utilidades;

import java.util.HashMap;
import java.util.Map;

public class Argumentos {
    private static final String TIPO = "t";
    private static final String VALORES = "v";
    private static final String ALGORITMO = "a";
    private static final String ORDENAMENTO = "o";
    private static final String TEMPO = "s";
    private static final String valorALEATORIO = "r";
    private static final String quantidadeValoresAleatorios = "m";

    private final Map<String, String> mapa = new HashMap<>();

    public void processarParametros(String[] args){
        extrairParametros(args);
        String tipo = mapa.get(TIPO);
        String valores = mapa.get(VALORES);
        String tipoAlgoritmo = mapa.get(ALGORITMO);
        String tipoOrdenamento = mapa.get(ORDENAMENTO);
        String tempo = mapa.get(TEMPO);

        int tempo_execucao = Validacao.validarTempoExecucao(tempo);

        Validacao.validarTipoOrdenamento(tipoOrdenamento);

        processarTipo(tipo, valores, tipoAlgoritmo, tipoOrdenamento, tempo_execucao);
    }
    private void extrairParametros(String[] args){
        if (args.length < 3) {
            throw new IllegalArgumentException("Número insuficiente de argumentos.");
        }
        for (String arg: args){
            String[] parts = arg.split("=");
            if (parts.length == 2){
                mapa.put(parts[0], parts[1]);
            }
        }
    }
    private void processarTipo(String tipo, String valores, String tipoAlgoritmo, String tipoOrdenamento,
                               int tempo_execucao) {
        switch (tipo) {
            case "n" -> {
                Integer[] numeros = Validacao.validarValoresNumerico(valores);
                Ordenador.escolherAlgoritmo(numeros, tipoAlgoritmo, tipoOrdenamento, tempo_execucao);
            }
            case "c" -> {
                Character[] caracteres = Validacao.validarValoresCaracteres(valores);
                Ordenador.escolherAlgoritmo(caracteres, tipoAlgoritmo, tipoOrdenamento, tempo_execucao);
            }
            default -> throw new IllegalArgumentException("Tipo de parâmetro inválido.");
        }
    }
}