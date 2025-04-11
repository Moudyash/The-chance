package practice.Personal_Financial_Tracker

import CategorySystem

fun main() {
    val system = CategorySystem()
    system.printAllCategories()
    println(system.addCategory("22"))
// TODO: Enable support for multilanguage input, ensuring compatibility with various character sets and languages.
// TODO: Prevent updates to default categories to maintain integrity of predefined categories.
// TODO: Implement a Validator class to handle input validation and ensure consistent validation logic across the system.

}
