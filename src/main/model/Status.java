package main.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Status {

    private int dataPublicacao;
    private List<String> obrasMaisLidas;
    private int tempoLeitura;

    public void definirDataPublicacao(int dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public void adcMaisLida(String obra) {
        this.obrasMaisLidas.add(obra);
    }

    public int registrarTempo(int tempo) {
        this.tempoLeitura += tempo;
        return this.tempoLeitura;
    }

    public Map<String, Object> obterEstatisticas() {
        Map<String, Object> estatisticas = new HashMap<>();
        estatisticas.put("DataPublicacao", this.dataPublicacao);
        estatisticas.put("ObrasMaisLidas", this.obrasMaisLidas);
        estatisticas.put("TempoLeitura", this.tempoLeitura);
        return estatisticas;
    }
}
