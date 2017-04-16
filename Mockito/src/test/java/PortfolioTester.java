import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PortfolioTester {

    Portfolio porfolio;
    StockService stockService;

    public static void main(String[] args) {
        PortfolioTester tester = new PortfolioTester();
        tester.setUp();
        System.out.println(tester.testMarketValue()?"pass":"fail");
    }

    private void setUp() {
        // Create a portfolio object which is to be tested
        porfolio = new Portfolio();

        // Create a mock object of StockService
        stockService = mock(StockService.class);

        // Set the stockService to the Portfolio
        porfolio.setStockService(stockService);
    }

    public boolean testMarketValue() {
        // Create list of stock
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock microsoftStock = new Stock("2", "Microsoft", 100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        // add stocks to the portfolio
        porfolio.setStocks(stocks);

        // mock the behavior of stock service to return the value
        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        double marketValue = porfolio.getMarketValue();
        return marketValue == 100500.00;
    }
}