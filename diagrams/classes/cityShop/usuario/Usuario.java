package cityShop.usuario;

import cityShop.loja.*;
import cityShop.estoque.*;

public class Usuario 
{

	public String nome;
	public String cpf;
	public Long id;

	public ArrayList<FavoritoLoja> lojasFavoritas;
	public ArrayList<FavoritoProduto> produtosFavoritos;
}
