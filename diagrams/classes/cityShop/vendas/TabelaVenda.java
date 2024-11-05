package cityShop.vendas;

import java.util.ArrayList;

public class TabelaVenda {
	
	public Integer qtdVenda;
	public ArrayList<Venda> vendas;
	private TabelaVenda instancia;

	private TabelaVenda() {


	}

	public TabelaVenda getInstance() {

		if (this.instancia == null) {


			this.instancia = new TabelaVenda();

		}

		return this.instancia;

	}

	public Integer getQtdVenda() {

		return null;

	}

	public ArrayList<Venda> getVendas() {

		return null;
		
	}

}
