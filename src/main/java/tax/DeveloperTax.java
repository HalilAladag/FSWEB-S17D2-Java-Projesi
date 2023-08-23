package tax;

public class DeveloperTax implements  Taxable{
    @Override
    public double getSimpleTaxRate() {
        return 10;
    }

    @Override
    public double getMiddleTaxRate() {
        return 15;
    }

    @Override
    public double getUpperTaxRate() {
        return 20;
    }
}
