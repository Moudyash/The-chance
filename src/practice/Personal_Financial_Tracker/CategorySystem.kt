import practice.Personal_Financial_Tracker.Category

class CategorySystem {

    private val categories = mutableListOf<Category>()
    private var nextId = 1

    private val defaultCategories = setOf("Food", "Rent", "Salary","Entertainment","Transport","Other")

    init {
        addDefaultCategories()
    }

    private fun addDefaultCategories() {
        defaultCategories.forEach { addCategory(it) }
    }

    fun addCategory(name: String): String {
        return when {
            name.isBlank() -> "Category name cannot be empty."
            name.length < 3 -> "Category name cannot be less than 3 characters."
            name.length > 50 -> "Category name cannot be more than 50 characters."
            !name.matches("^[a-zA-Z0-9\\s\u0600-\u06FF]+$".toRegex()) -> "Category name cannot contain special characters or symbols."
            categories.any { it.name.equals(name, ignoreCase = true) } -> "Category '$name' already exists."
            else -> {
                val category = Category(id = nextId.toString(), name = name)
                categories.add(category)
                nextId++
                "Category '$name' added successfully with ID ${category.id}."

            }
        }
    }


    fun updateCategoryName(oldName: String, newName: String): Any {
        return when {
            newName.isBlank() -> {
                println("New category name cannot be empty.")
                false
            }
            newName.length < 3 -> {
                println("Category name cannot be less than 3 characters.")
                false
            }
            newName.length > 50 -> {
                println("Category name cannot be more than 50 characters.")
                false
            }
            !newName.matches("^[a-zA-Z0-9\\s\u0600-\u06FF]+$".toRegex()) -> {
                println("Category name cannot contain special characters or symbols.")
                false
            }
            defaultCategories.contains(oldName) -> {
                println("Cannot update default category '$oldName'.")
                false
            }
            categories.none { it.name.equals(oldName, ignoreCase = true) } -> {
                println("Category '$oldName' not found.")
                false
            }
            categories.any { it.name.equals(newName, ignoreCase = true) } -> {
                // find the original name (case sensitive)
                val existingCategory = categories.find { it.name.equals(newName, ignoreCase = true) }!!
                println("Category '${existingCategory.name}' already exists.")
                false
            }
            else -> {
                val existing = categories.find { it.name.equals(oldName, ignoreCase = true) }!!
                existing.name = newName
                println("Category '$oldName' has been updated to '$newName'.")
                true
            }
        }
    }
    fun deleteCategory(name: String): Boolean {
        return when {
            name.isBlank() -> {
                println("Category name cannot be empty.")
                false
            }
            !name.matches("^[a-zA-Z0-9\\s\u0600-\u06FF]+$".toRegex()) -> {
                println("Category name cannot contain special characters or symbols.")
                false
            }
            defaultCategories.contains(name) -> {
                println("Cannot delete default category '$name'.")
                false
            }
            categories.none { it.name.equals(name, ignoreCase = true) } -> {
                println("Category '$name' not found.")
                false
            }
            else -> {
                // Find and remove the category
                val category = categories.find { it.name.equals(name, ignoreCase = true) }!!
                categories.remove(category)
                println("Category '$name' has been deleted.")

                // reassign IDs to keep them in a sequence
                reorderCategoryIds()
                true
            }
        }
    }

    private fun reorderCategoryIds() {
        var newId = 1
        categories.forEach { category ->
            category.id = newId.toString()
            newId++
        }
    }    fun getAllCategories(): List<Category> {
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
        return when {
            name.isBlank() -> {
                println("Category name cannot be empty.")
                false
            }
            !name.matches("^[a-zA-Z0-9\\s\u0600-\u06FF]+$".toRegex()) -> {
                println("Category name cannot contain special characters or symbols.")
                false
            }
            else -> categories.any { it.name.equals(name, ignoreCase = true) }
        }
    }
}
