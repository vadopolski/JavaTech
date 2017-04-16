import java.util.List;

public class Portfolio {

    private StockService service;
    private List<Stock> stocks;

    public void setStockService(StockService service) {
        this.service = service;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public double getMarketValue (){
        double price = 0.0;

        for (Stock st : stocks) {
            price += st.getQuantity() * service.getPrice(st);
        }

        return price;
    }
}