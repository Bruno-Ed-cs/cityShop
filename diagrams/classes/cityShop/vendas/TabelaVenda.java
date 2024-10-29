package cityShop.vendas;

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

	}

	public ArrayList<Venda> getVendas() {
		
	}

}
