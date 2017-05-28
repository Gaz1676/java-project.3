package models;

/**
 * This is an abstract Person class which contains:
 *          - Person email
 *          - Person name
 *          - Person address
 *          - Person gender
 *
 * @author Gary Fleming 21/05/2017
 * @version 4.0
 */


public abstract class Person {
    private String email;
    private String name;
    private String address;
    private String gender;

    /**
     *
     * @param email Persons email
     * @param name Persons name
     * @param address Persons address
     * @param gender Persons gender
     */
    Person( String email, String name, String address, String gender) {

        this.email = email;


        if (name.length() <= 30) {
            this.name = name;
        } else {
            this.name = name.substring(0, 30);
        }


        this.address = address;


        if ((gender.toUpperCase().equals("M")) || (gender.toUpperCase().equals("F"))) {
            this.gender = gender.toUpperCase();
        } else {
            this.gender = "Unspecified";
        }
    }

    /**
     *
     * @return returns the persons email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return rturns the persons name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return returns the persons address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return returns the persons gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Updates the persons gender field.
     *
     * @param gender
     *            The persons gender i.e. can be either "M" or "F".
     *            All other values are ignored.
     */
    public void setGender(String gender) {
        if ((gender.toUpperCase().equals("M")) || (gender.toUpperCase().equals("F"))) {
            this.gender = gender.toUpperCase();
        }
    }

    /**
     * Updates the persons address field
     *
     * @param address
     *         There is no validation on the persons address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Updates the persons name field
     *
     * @param name
     *          There is no validation on the persons name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Updates the persons email field
     *
     * @param email
     *          There is no validation on the persons email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return User-friendly String representing the Person
     */
    @Override
    public String toString() {
        return "Email: " + email + "/ Name: " + name + "/ Address: " + address + "/ Gender: " +  gender;
    }

}
