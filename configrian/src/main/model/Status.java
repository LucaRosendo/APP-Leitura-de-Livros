package main.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Status {

    private int dataPublicacao;
    private List<String> obrasMaisLidas;
    private final Map<String, Integer> tempoLeituraPorLivro;
    private int paginasLidas;

    public void definirDataPublicacao(int dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public void adcMaisLida(String obra) {
        this.obrasMaisLidas.add(obra);
    }

    public Status() {
        this.tempoLeituraPorLivro = new HashMap<>();
    }

    public void registrarPaginasLidas(int paginas) {
        this.paginasLidas += paginas;
    }

    public int obterPaginasLidas() {
        return this.paginasLidas;
    }

    public void registrarTempo(String livroNome, int tempo) {
        this.tempoLeituraPorLivro.put(livroNome,
                this.tempoLeituraPorLivro.getOrDefault(livroNome, 0) + tempo);
    }

    public Map<String, Object> obterEstatisticas() {
        Map<String, Object> estatisticas = new HashMap<>();
        estatisticas.put("DataPublicacao", this.dataPublicacao);
        estatisticas.put("ObrasMaisLidas", this.obrasMaisLidas);
        estatisticas.put("TempoLeituraPorLivro", this.tempoLeituraPorLivro);
        estatisticas.put("PaginasLidas", this.paginasLidas);
        return estatisticas;
    }
}
