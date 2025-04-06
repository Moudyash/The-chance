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
            println("\u001B[34mPlease enter your 4-digit PIN:\u001B[0m") // Blue color for instruction
            pin = scanner.nextLine()

            if (pin.length == 4 && pin.all { it.isDigit() }) {
                return pin
            } else {
                println("\u001B[31m❌ Invalid PIN. Please enter exactly 4 digits.\u001B[0m") // Red for error
            }
        }
    }

    fun setupBankAccount() {
        println("\u001B[32mYou have created a BankAccount with full name $fullname successfully.\u001B[0m")
        println("\u001B[34mPlease let’s setup your account for security.\u001B[0m")

        val pin = getPinFromUser()
        PinCode.addAll(pin.toList())

        println("\u001B[32m✅ We have securely saved your PIN code for account protection.\u001B[0m")
        println("\u001B[33mPlease ensure that you do not share your PIN code with anyone, as it is confidential and will be used to secure your account.\u001B[0m")
    }

    fun checkPinForTransaction(): Boolean {
        val scanner = Scanner(System.`in`)
        println("\u001B[34mPlease enter your PIN to proceed with the transaction:\u001B[0m")
        val inputPin = scanner.nextLine().trim()

        return PinCode == inputPin.toList()
    }

    fun getBalance() {
        println("\u001B[34mYour current Balance: \u001B[32m$balance$\u001B[0m")
    }

    fun deposit(amount: Int) {
        if (checkPinForTransaction()) {
            balance += amount
            transactions.add(amount)
            println("\u001B[32m✅ Deposit process done. You added \u001B[34m$amount$\u001B[32m to your account $fullname\u001B[0m 💰")
            println("\uD83D\uDCB0 \u001B[34m Your Current Balance is: ${balance}")
        } else {
            println("\u001B[31m❌ Sorry ${fullname} Invalid PIN. Transaction failed.\u001B[0m")
        }
    }

    fun withdraw(amount: Int): Boolean {
        if (checkPinForTransaction()) {
            return if (amount <= balance) {
                balance -= amount
                transactions.add(-amount)
                println("\u001B[32m✅ Withdraw process done. You withdrew \u001B[34m$amount$\u001B[32m 💰\u001B[0m")
                println("\uD83D\uDCB0 \u001B[34m Your Current Balance is: ${balance}")

                true
            } else {
                println("\u001B[31m❌ Process failed: No enough balance in your account.\u001B[0m")
                false
            }
        } else {
            println("\u001B[31m❌ Sorry ${fullname} Invalid PIN. Transaction failed.\u001B[0m")
            return false
        }
    }

    fun printTransactions() {
        println("\u001B[34mTransaction history for $fullname:\u001B[0m")
        transactions.forEach { amount ->
            if (amount > 0) {
                println("\u001B[32mDeposited: \u001B[34m$amount$\u001B[32m 💰\u001B[0m")
            } else {
                println("\u001B[31mWithdrew: \u001B[34m${-amount}$\u001B[31m 💰\u001B[0m")
            }
        }
    }

    fun printLastTransaction() {
        if (transactions.isNotEmpty()) {
            val lastTransaction = transactions.last()
            println("\u001B[34mLast Transaction Process Info for $fullname:\u001B[0m")
            if (lastTransaction > 0) {
                println("\u001B[32mDeposited: \u001B[34m$lastTransaction$\u001B[32m 💰\u001B[0m")
            } else {
                println("\u001B[31mWithdrew: \u001B[34m${-lastTransaction}$\u001B[31m 💰\u001B[0m")
            }
        } else {
            println("\u001B[33mℹ️ No transactions found for $fullname.\u001B[0m")
        }
    }

    fun transferBalance(amount: Int, bankAccount: BankAccount) {
        if (checkPinForTransaction()) {
            if (withdraw(amount)) {
                bankAccount.deposit(amount)
                println("\u001B[32m✅ Transferred \u001B[34m$amount$\u001B[32m From Your Account: \u001B[34m$fullname\u001B[32m to \u001B[34m${bankAccount.fullname} Account\u001B[0m 💰")
                println("\uD83D\uDCB0 \u001B[34m Your Current Balance is: ${balance}")

            }
        } else {
            println("\u001B[31m❌ Sorry ${fullname} Invalid PIN. Transaction failed.\u001B[0m")
        }
    }

    fun createAccount(): BankAccount {
        val scanner = Scanner(System.`in`)
        println("\u001B[34mPlease enter your full name:\u001B[0m")
        val fullname = scanner.nextLine()

        val newAccount = BankAccount(fullname)
        newAccount.setupBankAccount()
        return newAccount
    }

    fun showMenu() {
        val scanner = Scanner(System.`in`)
        while (true) {
            println("\n\u001B[34mSelect the process you want to perform:\u001B[0m")
            println("\u001B[34m1. View Balance")
            println("2. Deposit Money")
            println("3. Withdraw Money")
            println("4. Transfer Money")
            println("5. View Transaction History")
            println("6. View Last Transaction")
            println("7. Exit\u001B[0m")

            when (scanner.nextInt()) {
                1 -> getBalance()
                2 -> {
                    println("\u001B[34mEnter the amount to deposit:\u001B[0m")
                    val amount = scanner.nextInt()
                    deposit(amount)
                }
                3 -> {
                    println("\u001B[34mEnter the amount to withdraw:\u001B[0m")
                    val amount = scanner.nextInt()
                    withdraw(amount)
                }
                4 -> {
                    println("\u001B[34mEnter the amount to transfer:\u001B[0m")
                    val amount = scanner.nextInt()

                    val recipientAccount = BankAccount("Recipient Account")
                    transferBalance(amount, recipientAccount)
                }
                5 -> printTransactions()
                6 -> printLastTransaction()
                7 -> {
                    println("\u001B[32mExiting... Goodbye!\u001B[0m")
                    break
                }
                else -> println("\u001B[31m❌ Invalid choice, please select again.\u001B[0m")
            }
        }
    }
}

