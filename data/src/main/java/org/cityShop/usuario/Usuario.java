package org.cityShop.usuario;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Usuario {

    // Atributos de um usuario

    public String nome;
    public String cpf;
    public Long id;
    public Boolean lojista;
    public ArrayList<Favoritavel> favoritos;

    // Construtor de um usuario

    public Usuario(String nome, String cpf, Long id, Boolean lojista) {

        this.nome = nome;
        this.cpf = cpf;
        this.id = id;
        this.lojista = lojista;
        this.favoritos = new ArrayList<>();
    }

    // Construtor de um usuario a partir de um JSON

    public Usuario(JSONObject json) {

        // Atribuindo os valores do JSON diretamente

        this.nome = json.getString("nome");
        this.cpf = json.getString("cpf");
        this.id = json.getLong("id");
        this.lojista = json.getBoolean("lojista");
        this.favoritos = new ArrayList<>();

        // Preenchendo a lista de favoritos a partir do JSON

        JSONArray favoritosJson = json.getJSONArray("favoritos");

        for (int i = 0; i < favoritosJson.length(); i++) {

            JSONObject favoritoJson = favoritosJson.getJSONObject(i);
            Favoritavel favorito = criarFavorito(favoritoJson);

            this.favoritos.add(favorito);
        }
    }

    public JSONObject toJSON(){

        JSONObject json = new JSONObject();

        json.put("cpf", this.cpf);
        json.put("nome", this.nome);
        json.put("id", this.id);
        json.put("lojista", this.lojista);

        JSONArray favs = new JSONArray();

        for (Favoritavel favorito : this.favoritos){

            favs.put(favorito.toJSON());
        }

        json.put("favoritos", favs);

        return json;
    }

    // metodo auxiliar para criar o favorito com base no tipo

    private Favoritavel criarFavorito(JSONObject favoritoJson) {
        // favor nao usar json dentro da aplicação em si, nos argumento ou use variaveis normais ou objetos, o json é para ser usado dentro da database

        FavTypes type = favoritoJson.getEnum(FavTypes.class, "type");
        Long idTarget = favoritoJson.getLong("id");

        switch (type) {

            case PRODUTO: // Produto

                return new FavoritoProduto(this.id, idTarget);

            case LOJA: // Loja

                return new FavoritoLoja(this.id, idTarget);

            default:

                throw new IllegalArgumentException("Tipo de favorito não definido");
        }
    }

    /**
     * Adiciona um favorito ao usuario.
     * para idTarget O ID do produto/loja favoritado.
     * para type O tipo do favorito (produto/loja).
     */

    public void adicionarFavorito(Long idTarget, FavTypes type) {

        Favoritavel favorito = criarFavorito(type, idTarget);

        favoritos.add(favorito);
    }

    // metodo auxiliar para criar o favorito com base no tipo (utilizado no adicionarFavorito)

    private Favoritavel criarFavorito(FavTypes type, Long idTarget) {

        switch (type) {

            case PRODUTO:

                return new FavoritoProduto(idTarget, this.id);

            case LOJA:

                return new FavoritoLoja(idTarget, this.id);

            default:

                throw new IllegalArgumentException("Tipo de favorito não definido");
        }
    }

    /**
     * Retorna um array com os favoritos de um tipo específico.
     * para type O tipo de favorito desejado (produto/loja).
     * retorna Um array de objetos Favoritavel.
     */

    public Favoritavel[] queryFavoritos(FavTypes type) {

        return favoritos.stream()

            .filter(f -> (type == FavTypes.PRODUTO && f instanceof FavoritoProduto) ||
                         (type == FavTypes.LOJA && f instanceof FavoritoLoja))
            .toArray(Favoritavel[]::new);
    }
}
