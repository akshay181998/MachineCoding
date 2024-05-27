package dto;

public class Customer {
    private static Integer customerCounter = 0;
    private Integer customerId;
    private String customerName;
    private Integer vehicleId;
    private Integer ticketId;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public Customer(String customerName, Integer vehicleId) {
        this.customerId = ++customerCounter;
        this.customerName = customerName;
        this.vehicleId = vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

}
