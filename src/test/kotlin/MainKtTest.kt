import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateFeePay() {
        // arange
        val vCard: String = "VkPay"
        val vtotalSumInMonth: Int = 25_000
        val vpay: Int = 6_000

        // act
        val result = calculateFeePay(
            Card = vCard,
            totalSumInMonth = vtotalSumInMonth,
            pay = vpay
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun `calculateFeePay check limit exceeded` () {
        // arange
        val vCard: String = "VkPay"
        val vtotalSumInMonth: Int = 25_000
        val vpay: Int = 6_000

        // act
        val result = calculateFeePay(
            Card = vCard,
            totalSumInMonth = vtotalSumInMonth,
            pay = vpay
        )

        // assert
        assertEquals(0, result)
    }
}