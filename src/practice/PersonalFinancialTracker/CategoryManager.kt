import practice.PersonalFinancialTracker.Category
enum class DefaultCategory(val displayName: String) {
    FOOD("Food"),
    RENT("Rent"),
    SALARY("Salary"),
    BILLS("Bills"),
    ENTERTAINMENT("Entertainment"),
    TRANSPORTATION("Transportation"),
    HEALTH("Health"),
    TRAVEL("Travel"),
    EDUCATION("Education"),
    SAVINGS("Other");

    override fun toString(): String = displayName
}

class CategoryManager {
    private val categories = mutableSetOf<String>()

    init {
        // Initialize with default categories
        DefaultCategory.values().forEach { categories.add(it.displayName) }
    }

    fun categoryExists(name: String): Boolean {
        if (name.isBlank()) return false
        return categories.any { it.equals(name, ignoreCase = true) }
    }


    fun addCategory(name: String): Boolean {
        if (categoryExists(name)) return false
        categories.add(name)
        return true
    }

    fun updateCategory(oldName: String, newName: String): Boolean {
        if (oldName.isBlank() || newName.isBlank()) return false

        val old = categories.find { it.equals(oldName, ignoreCase = true) }
        if (old == null || categoryExists(newName)) return false

        categories.remove(old)
        categories.add(newName)
        return true
    }

    fun deleteCategory(name: String): Boolean {
        val toDelete = categories.find { it.equals(name, ignoreCase = true) }
        return if (toDelete != null) {
            categories.remove(toDelete)
            true
        } else {
            false
        }
    }

    fun listCategories(): List<String> {
        return categories.sorted()
    }
}

// ✅ Sample test runner without a test library
fun checkResult(name: String, result: Boolean, expected: Boolean) {
    if (result == expected) {
        println("✅ Success: $name")
    } else {
        println("❌ Failed: $name (Expected $expected but got $result)")
    }
}

fun runCategoryManagerTests() {
    val manager = CategoryManager()

    checkResult("Check default category exists: Food", manager.categoryExists("food"), true)
    checkResult("Add new category: Gaming", manager.addCategory("Gaming"), true)
    checkResult("Add duplicate category: gaming", manager.addCategory("GAMING"), false)
    checkResult("Update category: Gaming -> eSports", manager.updateCategory("gaming", "eSports"), true)
    checkResult("Delete category: eSports", manager.deleteCategory("Esports"), true)
    checkResult("Delete non-existing category: Coffee", manager.deleteCategory("Coffee"), false)

    println("Categories List:")
    manager.listCategories().forEach { println("- $it") }
}