package practice.PersonalFinancialTracker

import CategoryManager

class CategoryManagerTest {
fun CategoryTest(name: String, result: Boolean, expected: Boolean) {
    if (result == expected) {
        println("✅ Success: $name.")
    } else {
        println("❌ Failed: $name. Expected $expected, got $result.")
    }
}

    fun runCategoryManagerTests() {
        val manager = CategoryManager()

        CategoryTest("Add 'Food'", manager.addCategory("Food"), true)
        CategoryTest("Prevent empty category", manager.addCategory(""), false)
        CategoryTest("Prevent duplicate 'Food'", manager.addCategory("Food"), false)

        CategoryTest("Update 'Food' to 'Groceries'", manager.updateCategory("Food", "Groceries"), true)
        CategoryTest("Fail to update 'NonExist'", manager.updateCategory("NonExist", "Test"), false)

        manager.addCategory("Bills")
        CategoryTest("Prevent rename to existing category", manager.updateCategory("Groceries", "Bills"), false)

        CategoryTest("Delete 'Groceries'", manager.deleteCategory("Groceries"), true)
        CategoryTest("Fail delete 'Random'", manager.deleteCategory("Random"), false)

        manager.addCategory("Travel")
        manager.addCategory("Health")
        val list = manager.listCategories()
        val listCheck = list.any { it.name.equals("Travel", ignoreCase = true) } &&
                list.any { it.name.equals("Health", ignoreCase = true) }
        CategoryTest("List all categories", listCheck, true)

        manager.updateCategory("Bills", "a")

        println(" Final Category List:")
        manager.listCategories().forEach {
            println("ID: ${it.id}, Name: ${it.name}")
        }

        println(" Check category exists:")
        println("Does 'A' category exist? ${manager.categoryExists("A")}")
        println("Does 'hEALTH' category exist? ${manager.categoryExists("hEALTH")}")
    }

}




























