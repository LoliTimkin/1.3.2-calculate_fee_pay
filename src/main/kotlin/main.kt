fun main() {
    calculateFeePay("Mir", 5_000, 2_000)
    calculateFeePay("VkPay", 25_000, 6_000)
    calculateFeePay("Maestro", 155_000, 76_000)
    calculateFeePay("Visa", 155_000, 170_000)
}


fun calculateFeePay(Card: String = "VkPay", totalSumInMonth: Int = 0, pay: Int = 0 ) {
    var feePay: Double = 0.00
    val LimitInDayToCard: Int = 150_000
    val LimitInMonthToCard: Int = 600_000
    val LimitInDayToOnlinePay: Int = 15_000
    val LimitInMonthToOnlinePay: Int = 40_000

        feePay = when (Card) {
            "Master","Maestro" -> {
                if (pay < 75_000) 0.00
                else (pay * 0.006 + 20) * 100.00
            }
            "Visa", "Mir" -> {
                if (pay * 0.0075 > 35)  (pay * 0.0075) * 100.00 else 35 * 100.00
            }
            else -> 0.00
        }


    if (Card == "VkPay") {
            if (pay > LimitInDayToOnlinePay) println("Можно оплачивать не более $LimitInDayToOnlinePay в день")
            else if (totalSumInMonth + pay > LimitInMonthToOnlinePay) println("Вы превысили месячный размер переводов: $LimitInMonthToOnlinePay")
            else println("Ваша коммисия составила: $feePay копеек")
        } else {
            if (pay > LimitInDayToCard) println("Можно оплачивать не более $LimitInDayToCard в день")
            else if (totalSumInMonth + pay > LimitInMonthToCard) println("Вы превысили месячный размер переводов: $LimitInMonthToCard")
            else println("Ваша коммисия составила: $feePay копеек")
        }
}






