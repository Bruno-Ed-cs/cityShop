package org.cityShop.usuario;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.cityShop.testes.Json;
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

        // Nome do usuario
        this.nome = json.getString("nome");

        // CPF do usuario
        this.cpf = json.getString("cpf");

        // ID do usuario
        this.id = json.getLong("id");

        // Booleano que representa se o usuario é lojista ou não
        this.lojista = json.getBoolean("lojista");

        // Inicialização da lista de favoritos
        JSONArray favoritosJson = json.getJSONArray("favoritos");
        this.favoritos = new ArrayList<>();

        for (int i = 0; i < favoritosJson.length(); i++) {

            Favoritavel favorito = null;
            JSONObject favoritoJson = favoritosJson.getJSONObject(i);

            switch (favoritoJson.getInt("type")) {
                case 1: // Produto
                    favorito = new FavoritoProduto(favoritoJson.getLong("id"));
                    break;
                case 0: // Loja
                    favorito = new FavoritoLoja(favoritoJson.getLong("id"));
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de favorito não definido");
            }

            this.favoritos.add(favorito);
        }
    }

    /**
     * Adiciona um favorito ao usuario.
     * @param idTarget O ID do produto/loja favoritado.
     * @param type O tipo do favorito (produto/loja).
     */
    public void adicionarFavorito(Long idTarget, FavTypes type) {

        Favoritavel favorito;

        switch (type) {
            case PRODUTO:
                favorito = new FavoritoProduto(idTarget, this.id);
                break;

            case LOJA:
                favorito = new FavoritoLoja(idTarget, this.id);
                break;

            default:
                throw new IllegalArgumentException("Tipo de favorito não definido");
        }

        favoritos.add(favorito);
    }

    /**
     * Retorna um array com os favoritos de um tipo específico.
     * --> type: O tipo de favorito desejado (produto/loja).
     * retorna Um array de objetos Favoritavel.
     */

    public Favoritavel[] queryFavoritos(FavTypes type) {
        return favoritos.stream()
            .filter(f -> (f instanceof FavoritoProduto && type == FavTypes.PRODUTO) ||
                         (f instanceof FavoritoLoja && type == FavTypes.LOJA))
            .toArray(Favoritavel[]::new);
    }
}
