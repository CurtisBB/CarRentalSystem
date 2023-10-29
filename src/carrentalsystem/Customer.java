package carrentalsystem;

/**
 * creates customer class
 * @author Curtis
 */
public class Customer {
    
    // name of Customer
    private String customerName;
    
    // email of Customer
    private String customerEmail;
    
    // address of Customer
    private String customerAddress;
    
    // customer constructor
    public Customer(String customerName, String customerEmail
            , String customerAddress) {
        super();
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }
    
    // returns name of customer
    public String getCustomerName() {
        return customerName;
    }
    
    // update customer name
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    // returns email of customer
    public String getCustomerEmail() {
        return customerEmail;
    }
    
    // update customer email
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    
    // returns customer address
    public String getCustomerAddress() {
        return customerAddress;
    }
    
    // update customer address
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
            
}
