import java.text.DecimalFormat

/**************************************************************
 *  Commercial Class for MAD-105 Inheritance Assignment due 28-Feb-2022
 *  This class creates the Commercial Class, which inherits the Customer Class
 *  and has a function: calculate, which calculates the weekly lawn
 *  maintenance cost for Commercial customers
 *
 *  @author:  Al Jette
 *  Date:  17-Feb-2022
 *  @param:  propertyName:  Name of property for commercial customer
 *           commercialRate: Commercial rate to maintain lawn
 *           multipleProperty: # properties we maintain for this customer (allows for multi-property discount)
 *  Inherited from customer Class:  customerName, customerPhone, customerAddress & squareFootage
 *
 *  Function calculate Returns:  Weekly maintenance cost
 *
 *  Mods:
 **************************************************************/

class commercial (
    propertyName: String,
    commercialRate: Double,
    multipleProperty: String,
    customerName: String,                // customer name through square footage inherited from Customer Class
    customerPhone: String,
    customerAddress: String,
    squareFootage: Double):
    customer(customerName, customerPhone, customerAddress, squareFootage) {

    // Getters and Setters
    var propertyName: String = ""
        get() = field
        set(value) {field=value}

    var commercialRate: Double = 5.00
        get() = field
        set(value) {field=value}

    var multipleProperty: String = ""
        get() = field
        set(value) {field=value}

    init {
        this.customerName = customerName
        this.customerPhone = customerPhone
        this.customerAddress = customerAddress
        this.squareFootage = squareFootage
        this.propertyName = propertyName
        this.commercialRate = commercialRate
        this.multipleProperty = multipleProperty
    }

    /**************************************************************
     *  Commercial Class Function: calculate, which calculates the weekly lawn
     *  maintenance cost for Commercial customers
     *
     *  @author:  Al Jette
     *  Date:  21-Feb-2022
     *  @param:  propertyName:  Name of property for commercial customer
     *           commercialRate: Commercial rate to maintain lawn
     *           multipleProperty: # properties we maintain for this customer (allows for multi-property discount)
     *  Inherited from customer Class:  customerName, customerPhone, customerAddress & squareFootage
     *
     *  Function calculate Returns:  Weekly maintenance cost
     *
     *  Mods:
     **************************************************************/
    
    fun calculate(): Double {
        val Dollar = DecimalFormat("$###,###.00")
        var multiPropertyDiscount: Double = 1.00
        if (this.multipleProperty == "y") multiPropertyDiscount = 0.90
        var weeklyCost: Double = (this.squareFootage / 1000) * this.commercialRate * multiPropertyDiscount

        println("*** Text below printed from Commerical Class Function ***")
        println("Business Customer Contact: ${this.customerName}")
        println("  Business Name: ${this.propertyName}")
        println("  Address: ${this.customerAddress}    Phone: ${this.customerPhone}")
        println("  Square Footage: ${this.squareFootage},  Multi-property discount: ${this.multipleProperty}")
        println("  Weekly Maintenance cost: " +Dollar.format(weeklyCost))
        println()
        return weeklyCost
    }
}