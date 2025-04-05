package Tasks.Week01

fun CheckIp(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success: $name.")
    } else {
        println("Failed: $name.")
    }
}

fun main() {
    fun checkIPv4Validity(address: String): Boolean {
        val segments = address.split(".")

        if (segments.size != 4) return false

        for (segment in segments) {
            if (segment.isEmpty() || !segment.all { it.isDigit() }) return false

            val value = segment.toInt()
            if (value < 0 || value > 255) return false

            if (segment != "0" && segment.startsWith("0")) return false
        }

        return true
    }

    CheckIp("Valid IPV4 Address", checkIPv4Validity("192.168.1.1"), true)
    CheckIp("Larger than expected segments", checkIPv4Validity("192.168.1.9.5"), false)
    CheckIp("Fewer slides than expected", checkIPv4Validity("192.168.1"), false)
    CheckIp("Invalid Character in Segment", checkIPv4Validity("192.168.1.b"), false)
    CheckIp("Out of Range Segment", checkIPv4Validity("192.168.256.256"), false)
    CheckIp("Leading Zero in Segment", checkIPv4Validity("192.168.1.01"), false)
    CheckIp("Empty Ip", checkIPv4Validity(""), false)
    CheckIp("Special Characters", checkIPv4Validity("192.168.#.1"), false)
    CheckIp("Empty Segment", checkIPv4Validity("192.168..1"), false)
}
