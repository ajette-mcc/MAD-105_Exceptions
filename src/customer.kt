/**************************************************************
 *  Customer Class for MAD-105 Inheritance Assignment due 28-Feb-2022
 *  This class is inherited by both Residential & Commercial customers
 *
 *  @author:  Al Jette
 *  Date:  17-Feb-2022
 *  @param:  customerName:  Name of customer
 *           customerPhone: Phone # of customer
 *           customerAddress:  Address of customer
 *           squareFootage:  Sq Footage of property being maintained
 *
 *  Mods:
 **************************************************************/

open class customer (
        customerName: String,
        customerPhone: String,
        customerAddress: String,
        squareFootage: Double) {

        var customerName: String = ""
            get() = field
            set(value) {field=value}

        var customerPhone: String = ""
            get() = field
            set(value) {field=value}

        var customerAddress: String = ""
            get() = field
            set(value) {field=value}

        var squareFootage: Double = 0.00
            get() = field
            set(value) {field=value}
    }