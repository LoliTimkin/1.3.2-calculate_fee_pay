import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun `calculateFeePay VkPay` () {
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
    fun `calculateFeePay for Maestro` () {
        // arange
        val vCard: String = "Maestro"
        val vtotalSumInMonth: Int = 25_000
        val vpay: Int = 19_000

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
    fun `calculateFeePay for Master` () {
        // arange
        val vCard: String = "Master"
        val vtotalSumInMonth: Int = 25_000
        val vpay: Int = 76_000

        // act
        val result = calculateFeePay(
            Card = vCard,
            totalSumInMonth = vtotalSumInMonth,
            pay = vpay
        )

        // assert
        assertEquals(47600, result)
    }

    @Test
    fun `calculateFeePay for Visa` () {
        // arange
        val vCard: String = "Visa"
        val vtotalSumInMonth: Int = 25_000
        val vpay: Int = 56_000

        // act
        val result = calculateFeePay(
            Card = vCard,
            totalSumInMonth = vtotalSumInMonth,
            pay = vpay
        )

        // assert
        assertEquals(42000, result)
    }

    @Test
    fun `calculateFeePay for Mir` () {
        // arange
        val vCard: String = "Mir"
        val vtotalSumInMonth: Int = 25_000
        val vpay: Int = 3_200

        // act
        val result = calculateFeePay(
            Card = vCard,
            totalSumInMonth = vtotalSumInMonth,
            pay = vpay
        )

        // assert
        assertEquals(3500, result)
    }

}