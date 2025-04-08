enum class DefaultCategory(val displayName: String) {
    FOOD("Food"),
    RENT("Rent"),
    SALARY("Salary"),
    ENTERTAINMENT("ENTERTAINMENT"),
    TRANSPORT("TRANSPORT"),

    SAVINGS("Other");
    override fun toString(): String = displayName
}

class CategoryManager {
    private val categories = mutableSetOf<String>()

    init {
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
