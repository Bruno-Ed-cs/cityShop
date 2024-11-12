package org.cityShop.usuario;

import java.util.ArrayList;
import org.cityShop.estoque.*;
import org.cityShop.loja.*;

public class Usuario 

{

	public String nome;
	public String cpf;
	public Long id;

	public ArrayList<FavoritoLoja> lojasFavoritas;
	public ArrayList<FavoritoProduto> produtosFavoritos;


}
