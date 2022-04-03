fun main() {
    limitsExceeded("Maestro", 255_000, 151_000)
    limitsExceeded("Mir", 5_000, 2_000)
    limitsExceeded("VkPay", 25_000, 6_000)
    limitsExceeded("Visa", 155_000, 170_000)
}

/*Превышение лимита для карт Maestro.
Превышение лимита для карт Mastercard.
Удовлетворению лимиту для карт Maestro.
Удовлетворению лимиту для карт Mastercard.
Аналогично для карт Visa и Mir.
Превышение дневного лимита для Vk Pay.
Превышение месячных и дневных лимитов для остальных типов.*/

fun limitsExceeded(Card: String = "VkPay", totalSumInMonth: Int = 0, pay: Int = 0): String? {
    val LimitInDayToCard: Int = 150_000
    val LimitInMonthToCard: Int = 600_000
    val LimitInDayToOnlinePay: Int = 15_000
    val LimitInMonthToOnlinePay: Int = 40_000
    var ExceededLimit: String? = null

    if (Card == "VkPay") {
        if (pay > LimitInDayToOnlinePay) {
           ExceededLimit = "InDay"
           println("Можно оплачивать не более $LimitInDayToOnlinePay в день")
        }
        else if (totalSumInMonth + pay > LimitInMonthToOnlinePay) {
            ExceededLimit = "InMonth"
            println("Вы превысили месячный размер переводов: $LimitInMonthToOnlinePay")
        }
        else calculateFeePay("VkPay",pay)
    } else {
        if (pay > LimitInDayToCard) {
            ExceededLimit = "InDay"
            println("Можно оплачивать не более $LimitInDayToCard в день")
        }
        else if (totalSumInMonth + pay > LimitInMonthToCard) {
            ExceededLimit = "InMonth"
            println("Вы превысили месячный размер переводов: $LimitInMonthToCard")
        }
        else calculateFeePay(Card,pay)
    }

        return ExceededLimit
}


fun calculateFeePay (Card: String = "VkPay", totalSumInMonth: Int = 0, pay: Int = 0 ): Int {
    var feePay: Int = 0
    var ExceededLimit: String? = null

        feePay = (when (Card) {
            "Master","Maestro" -> {
                if (pay < 75_000) 0
                else (pay * 0.006 + 20) * 100
            }
            "Visa", "Mir" -> {
                if (pay * 0.0075 > 35)  (pay * 0.0075) * 100 else 35 * 100
            }
            else -> 0
        }).toInt()

    //if (Card == "VkPay") {
     //       if (pay > LimitInDayToOnlinePay) {
     //       println("Можно оплачивать не более $LimitInDayToOnlinePay в день")
     //     }
     //       else if (totalSumInMonth + pay > LimitInMonthToOnlinePay) println("Вы превысили месячный размер переводов: $LimitInMonthToOnlinePay")
     //       else println("Ваша коммисия составила: $feePay копеек")
     //   } else {
     //       if (pay > LimitInDayToCard) println("Можно оплачивать не более $LimitInDayToCard в день")
     //       else if (totalSumInMonth + pay > LimitInMonthToCard) println("Вы превысили месячный размер переводов: $LimitInMonthToCard")
     //       else println("Ваша коммисия составила: $feePay копеек")
     //   }
        println("Ваша коммисия составила: $feePay копеек")
    return feePay
}






