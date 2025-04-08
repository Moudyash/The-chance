package practice.PersonalFinancialTracker

import CategoryManager

class CategoryManagerTest {
fun CheckCategory(name: String, result: Any, expected: Any) {
    if (result == expected) {
        println("Success: $name.")
    } else {
        println("Failed: $name. Expected $expected, got $result.")
    }
}

    fun runCategoryManagerTests() {
        val manager = CategoryManager()
        val longName = "b".repeat(50)
        CheckCategory("Add new category with more than max length (50 characters)", manager.addCategory(longName), true)
        CheckCategory("Add new category with less than min length (3 characters)", manager.addCategory("te"), true)
        CheckCategory("Add new category: Gaming", manager.addCategory("Gaming"), true)
        CheckCategory("Add duplicate category: gaming", manager.addCategory("GAMING"), true)
        CheckCategory("Add empty category name", manager.addCategory(""), true)
        CheckCategory("Update category: Gaming to eSports", manager.updateCategory("gaming", "eSports"), true)
        CheckCategory("Update non existing  category: Tea to eSports", manager.updateCategory("tea", "eSports"), true)
        CheckCategory("Prevent update to empty name", manager.updateCategory("eSports", ""), true)
        CheckCategory("Delete category: eSports", manager.deleteCategory("Esports"), true)
        CheckCategory("Delete non existing category: Coffee", manager.deleteCategory("Coffee"), true)
        CheckCategory("Check non existing category: Coffee", manager.categoryExists(""), true)
        CheckCategory("Check category exists: Food", manager.categoryExists("food"), true)

    }

}


//println(" Categories List:")
//manager.listCategories().forEach { println("- $it") }

























