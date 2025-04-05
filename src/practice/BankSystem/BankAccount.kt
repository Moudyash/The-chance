package BankSystem

import java.util.*
import java.util.UUID.randomUUID

class BankAccount(val fullname: String) {

    val accountId: UUID = randomUUID()
    private var balance = 0
    private val PinCode = mutableListOf<Char>()
    private val transactions = mutableListOf<Int>()

    init {
        setupBankAccount()

    }

    fun getPinFromUser(): String {
        val scanner = Scanner(System.`in`)
        var pin: String

        while (true) {
            println("Please enter your 4-digit PIN:")
            pin = scanner.nextLine()

            if (pin.length == 4 && pin.all { it.isDigit() }) {
                return pin
            } else {
                println("Invalid PIN. Please enter exactly 4 digits.")
            }
        }
    }

    fun setupBankAccount() {
        println("You have created a BankAccount with full name $fullname successfully.")
        println("Please let’s setup your account for security.")

        val pin = getPinFromUser()
        PinCode.addAll(pin.toList())

        println("We have securely saved your PIN code for account protection.")
        println("Please ensure that you do not share your PIN code with anyone, as it is confidential and will be used to secure your account.")
    }

    fun checkPinForTransaction(): Boolean {
        val scanner = Scanner(System.`in`)
        println("Please enter your PIN to proceed with the transaction:")
        val inputPin = scanner.nextLine().trim()

        return PinCode == inputPin.toList()
    }

    fun getBalance() {
        println("Your current Balance: $balance$")
    }

    fun deposit(amount: Int) {
        if (checkPinForTransaction()) {
            balance += amount
            transactions.add(amount)
            println("Deposit process done. You added $amount$ to your account $fullname")
        } else {
            println("Sorry ${fullname} Invalid PIN. Transaction failed.")
        }
    }

    fun withdraw(amount: Int): Boolean {
        if (checkPinForTransaction()) {
            return if (amount <= balance) {
                balance -= amount
                transactions.add(-amount)
                println("Withdraw process done. You withdrew $amount$")
                true
            } else {
                println("Process failed: No enough balance in your account")
                false
            }
        } else {
            println("Sorry ${fullname} Invalid PIN. Transaction failed.")
            return false
        }
    }

    fun printTransactions() {
        println("Transaction history for $fullname:")
        transactions.forEach { amount ->
            if (amount > 0) {
                println("Deposited: $amount$")
            } else {
                println("Withdrew: ${-amount}$")
            }
        }
    }

    fun printLastTransaction() {
        if (transactions.isNotEmpty()) {
            val lastTransaction = transactions.last()
            println("Last Transaction Process Info for $fullname:")
            if (lastTransaction > 0) {
                println("Deposited: $lastTransaction$")
            } else {
                println("Withdrew: ${-lastTransaction}$")
            }
        } else {
            println("No transactions found for $fullname.")
        }
    }

    fun transferBalance(amount: Int, bankAccount: BankAccount) {
        if (checkPinForTransaction()) {
            if (withdraw(amount)) {
                bankAccount.deposit(amount)
                println("Transferred $amount From Your Account: $fullname to ${bankAccount.fullname} Account")
            }
        } else {
            println("Sorry ${fullname} Invalid PIN. Transaction failed.")
        }
    }
    fun createAccount(): BankAccount {
        val scanner = Scanner(System.`in`)
        println("Please enter your full name:")
        val fullname = scanner.nextLine()

        val newAccount = BankAccount(fullname)
        newAccount.setupBankAccount()
        return newAccount
    }
    fun showMenu() {
        val scanner = Scanner(System.`in`)
        while (true) {
            println("\nSelect the process you want to perform:")
            println("1. View Balance")
            println("2. Deposit Money")
            println("3. Withdraw Money")
            println("4. Transfer Money")
            println("5. View Transaction History")
            println("6. View Last Transaction")
            println("7. Exit")

            when (scanner.nextInt()) {
                1 -> getBalance()
                2 -> {
                    println("Enter the amount to deposit:")
                    val amount = scanner.nextInt()
                    deposit(amount)
                }
                3 -> {
                    println("Enter the amount to withdraw:")
                    val amount = scanner.nextInt()
                    withdraw(amount)
                }
                4 -> {
                    println("Enter the amount to transfer:")
                    val amount = scanner.nextInt()

                    val recipientAccount = BankAccount("Recipient Account")
                    transferBalance(amount, recipientAccount)
                }
                5 -> printTransactions()
                6 -> printLastTransaction()
                7 -> {
                    println("Exiting... Goodbye!")
                    break
                }
                else -> println("Invalid choice, please select again.")
            }
        }
    }
}




