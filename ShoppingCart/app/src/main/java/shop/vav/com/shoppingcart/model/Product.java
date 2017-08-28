package shop.vav.com.shoppingcart.model;

/**
 * Created by vaibhav on 8/26/17.
 */

public class Product {
    private long id;
    private String name;
    private String description;
    private String promoMessage;
    private double salePrice;
    private double purchasePrice;
    private String imagePath;
    private long catagoryId;
    private String catagoryName;
    private long dateAdded;
    private long dateOfLastTransaction;

    public Product(){

    }
    public Product(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.promoMessage = product.getPromoMessage();
        this.salePrice = product.getSalePrice();
        this.purchasePrice = product.getPurchasePrice();
        this.imagePath = product.getImagePath();
        this.catagoryId = product.getCatagoryId();
        this.catagoryName = product.getCatagoryName();
        this.dateAdded = product.getDateAdded();
        this.dateOfLastTransaction = product.getDateOfLastTransaction();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPromoMessage() {
        return promoMessage;
    }

    public void setPromoMessage(String promoMessage) {
        this.promoMessage = promoMessage;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public long getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(long catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public long getDateOfLastTransaction() {
        return dateOfLastTransaction;
    }

    public void setDateOfLastTransaction(long dateOfLastTransaction) {
        this.dateOfLastTransaction = dateOfLastTransaction;
    }
}
