package BankSystem

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Welcome to the Bank System!")
    println("Please enter your full name To create your account:")
    val fullname = scanner.nextLine()

    val mohammed = BankAccount(fullname)
    mohammed.deposit(100)
    mohammed.withdraw(80)
    mohammed.deposit(1000)
    mohammed.deposit(10020)
    mohammed.getBalance()
    mohammed.printTransactions()
    mohammed.printLastTransaction()

}
