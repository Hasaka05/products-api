package uk.ac.westminster.products_api;

// A PhysicalProduct IS-A Product because it inherits the common
// product details from Product. A ShoppingCart is not a Product
// because it contains products rather than being a product.

public class PhysicalProduct extends Product implements Discountable {

    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct() {
        super();
    }

    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String getSummary(){
        return getName() + " - Physical Product (Weight: " + weightKg + " kg)";
    }

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}