package practice.PersonalFinancialTracker

import CategoryManager

class CategoryManagerTest {
fun CategoryCheck(name: String, result: Boolean, expected: Boolean) {
    if (result == expected) {
        println("Success: $name.")
    } else {
        println("Failed: $name. Expected $expected, got $result.")
    }
}

    fun runCategoryManagerTests() {
        val manager = CategoryManager()

        CategoryCheck("Check default category exists: Food", manager.categoryExists("food"), true)
        CategoryCheck("Add new category: Gaming", manager.addCategory("Gaming"), true)
        CategoryCheck("Add duplicate category: gaming", manager.addCategory("GAMING"), true)
        CategoryCheck("Update category: Gaming -> eSports", manager.updateCategory("gaming", "eSports"), true)
        CategoryCheck("Delete category: eSports", manager.deleteCategory("Esports"), true)
        CategoryCheck("Delete non-existing category: Coffee", manager.deleteCategory("Coffee"), true)
        CategoryCheck("Check non-existing category: Coffee", manager.categoryExists(""), true)
        println(" Categories List:")
        manager.listCategories().forEach { println("- $it") }
    }

}




























