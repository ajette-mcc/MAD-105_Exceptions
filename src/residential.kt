import java.text.DecimalFormat

/**************************************************************
 *  Residential Class for MAD-105 Inheritance Assignment due 28-Feb-2022
 *  This class creates the Residential Class, which inherits the Customer Class
 *  and has a function: calculate, which calculates the weekly lawn
 *  maintenance cost for Residential customers
 *
 *  @author:  Al Jette
 *  Date:  17-Feb-2022
 *  @param:  residentialRate: Residential rate to maintain lawn
 *           senior: if Senior, apply Senior discount
 *  Inherited from customer Class:  customerName, customerPhone, customerAddress & squareFootage
 *
 *  Function calculate Returns:  Weekly maintenance cost
 *
 *  Mods:
 **************************************************************/

class residential (
    residentialRate: Double,
    senior: Boolean,
    customerName: String,                // customer name through square footage inherited from Customer Class
    customerPhone: String,
    customerAddress: String,
    squareFootage: Double):
    customer(customerName,customerPhone, customerAddress, squareFootage) {

    // Getters and Setters
    var residentialRate: Double = 6.00
        get() = field
        set(value) {
            field = value
        }

    var senior: Boolean = false
        get() = field
        set(value) {
            field = value
        }

    init {
        this.customerName = customerName
        this.customerPhone = customerPhone
        this.customerAddress = customerAddress
        this.squareFootage = squareFootage
        this.residentialRate = residentialRate
        this.senior = senior
    }

    /**************************************************************
     *  Residential Class Function: calculate, which calculates the weekly lawn
     *  maintenance cost for Residential customers
     *
     *  @author:  Al Jette
     *  Date:  21-Feb-2022
     *  @param:  residentialRate: Residential rate to maintain lawn
     *           senior: if Senior, apply Senior discount
     *  Inherited from customer Class:  customerName, customerPhone, customerAddress & squareFootage
     *
     *  Function calculate Returns:  Weekly maintenance cost
     *
     *  Mods:
     **************************************************************/

    fun calculate(): Double {
        val Dollar = DecimalFormat("$###,###.00")
        var seniorDiscount: Double = 1.00
        if (this.senior == true) seniorDiscount = 0.85

        var weeklyCost: Double = (this.squareFootage / 1000) * this.residentialRate * seniorDiscount

        println("*** Text below printed from Residential Class Function ***")
        println("Customer ${this.customerName}")
        println("  Address: ${this.customerAddress}    Phone: ${this.customerPhone}")
        println("  Square Footage: ${this.squareFootage},  Senior Discount: ${this.senior}")
        println("  Weekly Maintenance cost: " + Dollar.format(weeklyCost))
        println()

        return weeklyCost
    }
}
