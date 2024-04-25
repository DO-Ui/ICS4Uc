public class Customer {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zip;


    /**
     * @brief This is the constructor for the Customer class.
     * @param firstName The first name of the customer.
     * @param lastName The last name of the customer.
     * @param street The street address of the customer.
     * @param city The city of the customer.
     * @param state The state of the customer.
     * @param zip The zip code of the customer.
     */
    public Customer(String firstName, String lastName, String street, String city, String state, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /**
     * @brief This is the getter for all the private variables in the Customer class.
     * @return The first name of the customer.
     */
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n" + "Address: " + street + ", " + city + ", " + state + ", " + zip;
    }

    /**
     * @brief This is the getter for the first name of the customer.
     * @return The first name of the customer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @brief This is the getter for the last name of the customer.
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @brief This is the getter for the street address of the customer.
     * @return The street address of the customer.
     */
    public String getStreet() {
        return street;
    }

    /**
     * @brief This is the getter for the city of the customer.
     * @return The city of the customer.
     */
    public String getCity() {
        return city;
    }

    /**
     * @brief This is the getter for the state of the customer.
     * @return The state of the customer.
     */
    public String getState() {
        return state;
    }

    /**
     * @brief This is the getter for the zip code of the customer.
     * @return The zip code of the customer.
     */
    public String getZip() {
        return zip;
    }

    /**
     * @brief This is the setter for the first name of the customer.
     * @param firstName The first name of the customer.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @brief This is the setter for the last name of the customer.
     * @param lastName The last name of the customer.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @brief This is the setter for the street address of the customer.
     * @param street The street address of the customer.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @brief This is the setter for the city of the customer.
     * @param city The city of the customer.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @brief This is the setter for the state of the customer.
     * @param state The state of the customer.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @brief This is the setter for the zip code of the customer.
     * @param zip The zip code of the customer.
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

}
