package practice.Personal_Financial_Tracker

import CategorySystem

fun check(message: String, actual: Any?, expected: Any?) {
    if (expected != actual) {
        println("x Failed : $message")
    } else {
        println("✓ Success: $message")
    }
}
fun testCases(system:CategorySystem){
    // Add categories
    check(
        message = "should return true when adding a new category",
        actual = system.addCategory("Food"),
        expected = true
    )
    check(
        message = "should return false when adding duplicate category",
        actual = system.addCategory("Food"),
        expected = false
    )

    // Exists
    check(
        message = "should return true when checking existing category",
        actual = system.exists("Food"),
        expected = true
    )
    check(
        message = "should return false when checking non-existing category",
        actual = system.exists("Travel"),
        expected = false
    )

    // Update category
    check(
        message = "should return true when updating category",
        actual = system.updateCategoryName("Food", "Housing"),
        expected = true
    )
    check(
        message = "should return false when updating to an existing category name",
        actual = system.updateCategoryName("Housing", "Food"),
        expected = false
    )
    check(
        message = "should return false when updating non-existent category",
        actual = system.updateCategoryName("Transport", "Cars"),
        expected = false
    )

    // Delete category
    check(
        message = "should return true when deleting existing category",
        actual = system.deleteCategory("Housing"),
        expected = true
    )
    check(
        message = "should return false when deleting already deleted category",
        actual = system.deleteCategory("Housing"),
        expected = false
    )
    check(
        message = "should return false when deleting non-existent category",
        actual = system.deleteCategory("Games"),
        expected = false
    )

    // Get all categories
    val remaining = system.getAllCategories().map { it.name }
    check(
        message = "should return correct categories after operations",
        actual = remaining,
        expected = listOf<String>()
    )
}
fun testCasesimp(system: CategorySystem) {
    // Add categories
    check(
        message = "should return Category 'newcategory' added successfully with ID",
        actual = system.addCategory("newcategory"),
        expected = "Category 'newcategory' added successfully with ID ${system.getAllCategories().last().id}."
    )
    check(
        message = "should return error when adding duplicate category",
        actual = system.addCategory("Food"),
        expected = "Category 'Food' already exists."
    )
    check(
        message = "should return error when adding category with special characters",
        actual = system.addCategory("Food@123"),
        expected = "Category name cannot contain special characters or symbols."
    )
    check(
        message = "should return error when adding category less than 3 characters",
        actual = system.addCategory("a"),
        expected = "Category name cannot be less than 3 characters."
    )
    check(
        message = "should return error when adding category more than 50 characters",
        actual = system.addCategory("A".repeat(51)),
        expected = "Category name cannot be more than 50 characters."
    )
    check(
        message = "should return true when adding Arabic category",
        actual = system.addCategory("مطعم"),
        expected = "Category 'مطعم' added successfully with ID ${system.getAllCategories().last().id}."
    )

    // Continue with the other tests...
}
class CategorySystemTest {

    private val categories = mutableListOf<Category>()
    private var nextId = 1

    init {
        addDefaultCategories()
    }

    private fun addDefaultCategories() {
        val defaults = listOf(
            "Food", "Rent", "Salary", "Entertainment", "Transport", "Other"
        )
        defaults.forEach { addCategory(it) }
    }

    fun addCategory(name: String): Boolean {
        if (name.isBlank()) {
            println("Category name cannot be empty.")
            return false
        }
        if (categories.any { it.name.equals(name, ignoreCase = true) }) {
            println("Category '$name' already exists.")
            return false
        }
        val category = Category(id = nextId.toString(), name = name)
        categories.add(category)
        nextId++
        return true
    }

    fun updateCategoryName(oldName: String, newName: String): Boolean {
        if (newName.isBlank()) {
            println("New category name cannot be empty.")
            return false
        }

        // Find the category with the old name, ignoring case
        val existing = categories.find { it.name.equals(oldName, ignoreCase = true) } ?: run {
            println("Category '$oldName' not found.")
            return false
        }

        // Check if a category with the new name already exists, ignoring case
        if (categories.any { it.name.equals(newName, ignoreCase = true) }) {
            println("Category '$newName' already exists.")
            return false
        }

        // Update the category name
        existing.name = newName
        return true
    }

    fun deleteCategory(name: String): Boolean {
        if (name.isBlank()) {
            println("Category name cannot be empty.")
            return false
        }
        val category = categories.find { it.name.equals(name, ignoreCase = true) } ?: run {
            println("Category '$name' not found.")
            return false
        }
        categories.remove(category)
        return true
    }

    fun getAllCategories(): List<Category> {
        return categories.toList()
    }

    fun printAllCategories() {
        if (categories.isEmpty()) {
            println("No categories available.")
        } else {
            categories.forEach { category ->
                println("ID: ${category.id}, Name: ${category.name}")
            }
        }
    }

    fun exists(name: String): Boolean {
        if (name.isBlank()) {
            println("Category name cannot be empty.")
            return false
        }
        return categories.any { it.name.equals(name, ignoreCase = true) }
    }
}
