package shop.vav.com.shoppingcart.model;

/**
 * Created by vaibhav on 8/28/17.
 */

public class Catagory {
    private long id;
    private String catagoryName;

    public Catagory(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }
}
