package Models;

public class Customers {

    /**
     * Customer class declarations
     */
    private int customerId;

    private String customerName;

    private String address;

    private String postalCode;

    private String country;

    private int divisionId;

    private String phone;

    /**
     * Customer class constructors
     * @param customerId
     * @param customerName
     * @param address
     * @param postalCode
     * @param country
     * @param divisionId
     * @param phone
     */
    public Customers(
            int customerId,
            String customerName,
            String address,
            String postalCode,
            String country,
            int divisionId,
            String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.country = country;
        this.divisionId = divisionId;
        this.phone = phone;
    }

    public Customers() {

    }

    public Customers(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    /**
     * Customer class getter's and setter's
     * @return
     */

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * returns customer name as a string
     * @return
     */
    @Override
    public String toString() {
        return (customerName);
    }
}
