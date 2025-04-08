import practice.PersonalFinancialTracker.Category

class CategoryManager {
    private val categories = mutableListOf<Category>()
    private var nextId = 1

    fun addCategory(name: String): Boolean {
        val trimmedName = name.trim()
        if (trimmedName.isEmpty()) return false
        if (categories.any { it.name.equals(trimmedName, ignoreCase = true) }) return false

        val newCategory = Category(id = nextId++, name = trimmedName)
        categories.add(newCategory)
        return true
    }

    fun updateCategory(oldName: String, newName: String): Boolean {
        val trimmedNewName = newName.trim()
        if (trimmedNewName.isEmpty()) return false

        val category = categories.find { it.name.equals(oldName, ignoreCase = true) }
        if (category == null || categories.any { it.name.equals(trimmedNewName, ignoreCase = true) }) return false

        category.name = trimmedNewName
        return true
    }

    fun deleteCategory(name: String): Boolean {
        return categories.removeIf { it.name.equals(name, ignoreCase = true) }
    }

    fun listCategories(): List<Category> {
        return categories.toList()
    }

    fun categoryExists(name: String): Boolean {
        return categories.any { it.name.equals(name, ignoreCase = true) }
    }
}
