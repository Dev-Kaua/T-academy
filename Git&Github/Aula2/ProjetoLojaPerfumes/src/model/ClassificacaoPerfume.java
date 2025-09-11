package model;

public enum ClassificacaoPerfume {
    EAU_DE_PARFUM("Eau de Parfum", "Alta concentração de essência, fixação longa (6-10h)"),
    EAU_DE_TOILETTE("Eau de Toilette", "Concentração média, fixação moderada (3-6h)"),
    EAU_DE_COLOGNE("Eau de Cologne", "Concentração leve, fixação curta (2-3h)"),
    PARFUM("Parfum", "Maior concentração, fixação muito longa (8-12h)"),
    BODY_SPRAY("Body Spray", "Bem leve, mais usado para refrescância");

    private final String nome;
    private final String descricao;

    ClassificacaoPerfume(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return nome + " - " + descricao;
    }
}
