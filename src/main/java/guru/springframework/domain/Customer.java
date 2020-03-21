package guru.springframework.domain;

import javax.persistence.*;

/**
 * Created by jt on 11/14/15.
 */
@Entity
public class Customer extends AbstractDomainClass {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "billingal1")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "billingal2")),
            @AttributeOverride(name = "city", column = @Column(name = "billingCity")),
            @AttributeOverride(name = "state", column = @Column(name = "billingState")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "billingZipCode"))
    })
    private Address billingAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "shipping1")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "shipping2")),
            @AttributeOverride(name = "city", column = @Column(name = "shippingcity")),
            @AttributeOverride(name = "state", column = @Column(name = "shippingState")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "shippingZip"))
    })
    private Address shippingAddress;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private User user;

    @Override
    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
