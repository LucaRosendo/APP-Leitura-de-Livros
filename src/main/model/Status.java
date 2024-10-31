package main.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Status {

    private int dataPublicacao;
    private List<String> obrasMaisLidas;
    private final Map<String, Integer> tempoLeituraPorLivro;
    private int paginasLidas;

    public Status() {
        this.tempoLeituraPorLivro = new HashMap<>();
        this.obrasMaisLidas = new ArrayList<>(); 
        this.paginasLidas = 0;
    }

    public void definirDataPublicacao(int dataPublicacao) {
        if (dataPublicacao <= 0) {
            throw new IllegalArgumentException("A data de publicação deve ser um valor positivo.");
        }
        this.dataPublicacao = dataPublicacao;
    }

    public void adcMaisLida(String obra) {
        if (obra == null || obra.trim().isEmpty()) {
            throw new IllegalArgumentException("A obra não pode ser nula ou vazia.");
        }
        if (!obrasMaisLidas.contains(obra)) {
            this.obrasMaisLidas.add(obra);
        }
    }

    public void registrarPaginasLidas(int paginas) {
        if (paginas < 0) {
            throw new IllegalArgumentException("O número de páginas lidas não pode ser negativo.");
        }
        this.paginasLidas += paginas;
    }

    public int obterPaginasLidas() {
        return this.paginasLidas;
    }

    public void registrarTempo(String livroNome, int tempo) {
        if (livroNome == null || livroNome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do livro não pode ser nulo ou vazio.");
        }
        if (tempo < 0) {
            throw new IllegalArgumentException("O tempo de leitura não pode ser negativo.");
        }
        this.tempoLeituraPorLivro.put(livroNome,
                this.tempoLeituraPorLivro.getOrDefault(livroNome, 0) + tempo);
    }

    public Map<String, Object> obterEstatisticas() {
        Map<String, Object> estatisticas = new HashMap<>();
        estatisticas.put("DataPublicacao", this.dataPublicacao);
        estatisticas.put("ObrasMaisLidas", new ArrayList<>(this.obrasMaisLidas)); 
        estatisticas.put("TempoLeituraPorLivro", new HashMap<>(this.tempoLeituraPorLivro)); 
        estatisticas.put("PaginasLidas", this.paginasLidas);
        return estatisticas;
    }
}
