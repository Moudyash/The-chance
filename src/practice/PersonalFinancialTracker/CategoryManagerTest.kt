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

        CheckCategory("Add new category: Gaming", manager.addCategory("Gaming"), true)
        CheckCategory("Add duplicate category: gaming", manager.addCategory("GAMING"), true)
        CheckCategory("Update category: Gaming to eSports", manager.updateCategory("gaming", "eSports"), true)
        CheckCategory("Update non existing  category: Tea to eSports", manager.updateCategory("tea", "eSports"), true)
        CheckCategory("Delete category: eSports", manager.deleteCategory("Esports"), true)
        CheckCategory("Delete non existing category: Coffee", manager.deleteCategory("Coffee"), true)
        CheckCategory("Check non existing category: Coffee", manager.categoryExists(""), true)
        CheckCategory("Check category exists: Food", manager.categoryExists("food"), true)

    }

}


//println(" Categories List:")
//manager.listCategories().forEach { println("- $it") }

























