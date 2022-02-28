import java.text.DecimalFormat

/**************************************************************
 *  Main program for MAD-105 Inheritance Assignment due 28-Feb-2022
 *  Calculates the cost of Lawn Maintenance for either Commercial or
 *  Residential customers.
 *
 *  @author:  Al Jette
 *  Date:  17-Feb-2022
 *
 *  @param
 *  Mods:
 **************************************************************/

fun main() {
    // Define current rates (fixed values) and customer(s)
    val currentCommercialRate: Double = 5.00
    val currentResidentialRate:Double = 6.00
    val Dollar = DecimalFormat("$###,###.00")
    var cust_commercial = commercial("xx", currentCommercialRate, "", "cc", "555", "zz", 100.00)
    var cust_residential = residential(currentResidentialRate, senior = false, "rc", "666", "zz", 0.00)

    // Other variables in main
    var quote: Double = 0.00
    var choice: Int = 0

    while (choice != 3) {
        print("Quote for a Commerical customer (1), Residential customer (2), or quit (3) ... (enter 1, 2 or 3): ")
        try { choice = readLine()!!.toInt() }
        catch (e: NumberFormatException) {
            println("  *** Exception, Please try again *** ")
            choice = 0
        }

// Choice = 1 for Commercial Customers, get keyboard entry, get cost to maintain lawn, print quote
        if (choice == 1) {
            print("  Customer Name: ")
            cust_commercial.customerName = readLine()!!.toString()
            print("  Customer Phone: ")
            cust_commercial.customerPhone = readLine()!!.toString()
            print("  Customer Address: ")
            cust_commercial.customerAddress = readLine()!!.toString()
            print("  Square footage of the property: ")
            try { cust_commercial.squareFootage = readLine()!!.toDouble() }
            catch (e: NumberFormatException) {
                println("  *** Exception, Defaults to Square Footage of 10,000 *** ")
                cust_commercial.squareFootage = 10000.00
            }
            print("  Property name: ")
            cust_commercial.propertyName = readLine()!!.toString()
            print("  Do we maintain multiple properties for this customer (enter y or n): ")
            cust_commercial.multipleProperty = readLine()!!.toString()

            quote = cust_commercial.calculate()

            println("*** Text below printed from Main - QUOTE ***")
            println("Business Customer Contact: ${cust_commercial.customerName}")
            println("  Business Name: ${cust_commercial.propertyName}")
            println("  Address: ${cust_commercial.customerAddress}    Phone: ${cust_commercial.customerPhone}")
            println("  Square Footage: ${cust_commercial.squareFootage},  Multi-property discount: ${cust_commercial.multipleProperty}")
            println("  Weekly Maintenance cost: " + Dollar.format(quote))
            println()

// Choice = 2 for Residential Customers, get keyboard entry, get cost to maintain lawn, print quote
        } else if (choice == 2) {
            print("  Customer Name: ")
            cust_residential.customerName = readLine()!!.toString()
            print("  Customer Phone: ")
            cust_residential.customerPhone = readLine()!!.toString()
            print("  Customer Address: ")
            cust_residential.customerAddress = readLine()!!.toString()
            print("  Square footage of the property: ")
            try {cust_residential.squareFootage = readLine()!!.toDouble() }
            catch (e: NumberFormatException) {
                println("  *** Exception, Defaults to Square Footage of 5,000 ***")
                cust_residential.squareFootage = 5000.00
            }
            print("  Senior Discount (enter true or false): ")
            cust_residential.senior = readLine()!!.toBoolean()

            quote = cust_residential.calculate()

            println("*** Text below printed from Main - QUOTE***")
            println("Residential Customer: ${cust_residential.customerName}")
            println("  Address: ${cust_residential.customerAddress}    Phone: ${cust_residential.customerPhone}")
            println("  Square Footage: ${cust_residential.squareFootage},  Senior discount: ${cust_residential.senior}")
            println("  Weekly Maintenance cost: " + Dollar.format(quote))
            println()

        } else if(choice !=3) println("Invalid Choice")
    }
}