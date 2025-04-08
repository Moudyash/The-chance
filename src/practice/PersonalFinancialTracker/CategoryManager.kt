enum class DefaultCategory(val id: Int, val displayName: String) {
    FOOD(1, "Food"),
    RENT(2, "Rent"),
    SALARY(3, "Salary"),
    ENTERTAINMENT(4, "Entertainment"),
    TRANSPORT(5, "Transport"),
    Other(6, "Other");

    override fun toString(): String = "$id. $displayName"
}

class CategoryManager {
    private val categories = mutableSetOf<String>()



    fun categoryExists(name: String): Any {
        return false
    }

    fun addCategory(name: String): Any {
        return false
    }

    fun updateCategory(oldName: String, newName: String): Any {
        return false
    }

    fun deleteCategory(name: String): Any {
        return false
    }

    fun listCategories(): Any {
        return categories.sorted()
    }
}
