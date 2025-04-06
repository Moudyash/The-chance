package BankSystem

import java.util.*

fun main() {
   // TDD()
    val scanner = Scanner(System.`in`)
    println("Welcome to the Bank System!")
    println("Please enter your full name To create your account:")

    val mohammed = BankAccount("mohammed")
    val sami = BankAccount("mohammed")

    mohammed.deposit(100)
    mohammed.withdraw(100)
    mohammed.deposit(100)
    mohammed.deposit(200)
    mohammed.withdraw(100)
    mohammed.transferBalance(100,sami)
}

fun test(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("✅ Success: $name.")
    } else {
        println("❌ Failed: $name.")
    }
}

fun TDD() {
    // createAccount()
    test("createAccount() should return valid BankAccount instance", result = false, correctResult = true)
    test("createAccount() should not return null", result = false, correctResult = true)

    // deposit()
    test("deposit() should increase balance when PIN is correct", result = false, correctResult = true)
    test("deposit() should fail when PIN is incorrect", result = true, correctResult = false)
    test("deposit() should reject negative amounts", result = true, correctResult = false)

    // withdraw()
    test("withdraw() should deduct balance correctly with valid PIN and amount", result = false, correctResult = true)
    test("withdraw() should fail with incorrect PIN", result = true, correctResult = false)
    test("withdraw() should fail if amount exceeds balance", result = true, correctResult = false)

    // transferBalance()
    test("transferBalance() should transfer money between two valid accounts with correct PIN", result = false, correctResult = true)
    test("transferBalance() should fail with incorrect PIN", result = true, correctResult = false)
    test("transferBalance() should fail if balance is insufficient", result = true, correctResult = false)
    test("transferBalance() should fail if the transferred balance is negative", result = true, correctResult = false)
    test("transferBalance() should fail if the amount is not a number", result = true, correctResult = false)

    // printTransactions()
    test("printTransactions() should show all previous transactions", result = false, correctResult = true)
    test("printTransactions() should show empty if no transactions", result = false, correctResult = true)

    // printLastTransaction()
    test("printLastTransaction() should return the most recent transaction", result = false, correctResult = true)
    test("printLastTransaction() should fail if no transaction exists", result = true, correctResult = false)

    // getPinFromUser()
    test("getPinFromUser() should return 4-digit numeric PIN", result = false, correctResult = true)
    test("getPinFromUser() should reject PIN with letters", result = true, correctResult = false)
    test("getPinFromUser() should reject PIN less than 4 digits", result = true, correctResult = false)
    test("getPinFromUser() should reject PIN more than 4 digits", result = true, correctResult = false)

    // checkPinForTransaction()
    test("checkPinForTransaction() should return true for correct PIN", result = false, correctResult = true)
    test("checkPinForTransaction() should return false for wrong PIN", result = true, correctResult = false)
    test("checkPinForTransaction() should return false for empty input", result = true, correctResult = false)

    // setupBankAccount()
    test("setupBankAccount() should store a valid PIN code", result = false, correctResult = true)
    test("setupBankAccount() should not store invalid PIN", result = true, correctResult = false)

    // getBalance()
    test("getBalance() should display 0 for new account", result = false, correctResult = true)
    test("getBalance() should reflect deposited amount", result = false, correctResult = true)
    test("getBalance() should reflect deducted amount after withdraw", result = false, correctResult = true)
}






















/*
*     val scanner = Scanner(System.`in`)
    println("Welcome to the Bank System!")
    println("Please enter your full name To create your account:")
    val fullname = scanner.nextLine()

    val mohammed = BankAccount(fullname)
    mohammed.deposit(1000)
    val sami = BankAccount("sami")

    mohammed.deposit(1000)
*/