package com.dealer.display;

/**
 * Enumeration of possible options for the user
 * @author Prabhjot Aulakh, Safin Haque
 */
public enum Options {
    VIEW_CARS(1, "View Cars"),
    FILTER_CARS(2, "Filter cars"),
    VIEW_CUSTOMERS(3, "View Customers"),
    FILTER_CUSTOMERS(4, "Filter customers"),
    VIEW_EMPLOYEES(5, "View Employees"),
    FILTER_EMPLOYEES(6, "Filter Employees"),
    CREATE_CAR(7, "Create Car"),
    UPDATE_CAR(8, "Update Car"),
    DELETE_CAR(9, "Delete Car"),
    QUIT(10, "Quit");

    private final int code;
    private final String description;

    /**
     * Constructor
     * @param code Code of the option
     * @param description Description of the option
     */
    private Options(int code, String description) {
        this.code = code;
        this.description = description;
    }   

    /**
     * Returns the code of the option
     * @return Code of the option
     */
    public int getCode() {
        return code;
    }

    /**
     * Returns the description of the option
     * @return Description of the option
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.code + ": " + this.description;
    }
}
