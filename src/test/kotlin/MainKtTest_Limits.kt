import org.junit.Test

import org.junit.Assert.*

class MainKtTest_Limits {

    @Test
        fun `limit exceeded in Day check Maestro` () {
            // arange
            val vCard: String = "Maestro"
            val vtotalSumInMonth: Int = 255_000
            val vpay: Int = 151_000

            // act
            val result = limitsExceeded(
                Card = vCard,
                totalSumInMonth = vtotalSumInMonth,
                pay = vpay
            )

            // assert
            assertEquals("InDay", result)
        }

    @Test
        fun `limit exceeded in Month check Maestro` () {
            // arange
            val vCard: String = "Maestro"
            val vtotalSumInMonth: Int = 555_000
            val vpay: Int = 123_000

            // act
            val result = limitsExceeded(
                Card = vCard,
                totalSumInMonth = vtotalSumInMonth,
                pay = vpay
            )

            // assert
            assertEquals("InMonth", result)
        }

    @Test
    fun `limit exceeded in Day check Visa` () {
        // arange
        val vCard: String = "Visa"
        val vtotalSumInMonth: Int = 25_000
        val vpay: Int = 150_100

        // act
        val result = limitsExceeded(
            Card = vCard,
            totalSumInMonth = vtotalSumInMonth,
            pay = vpay
        )

        // assert
        assertEquals("InDay", result)
    }

    @Test
    fun `limit exceeded in Month check Visa` () {
        // arange
        val vCard: String = "Visa"
        val vtotalSumInMonth: Int = 599_000
        val vpay: Int = 1_500

        // act
        val result = limitsExceeded(
            Card = vCard,
            totalSumInMonth = vtotalSumInMonth,
            pay = vpay
        )

        // assert
        assertEquals("InMonth", result)
    }

    @Test
    fun `limit exceeded in Day check Mir` () {
        // arange
        val vCard: String = "Mir"
        val vtotalSumInMonth: Int = 255_000
        val vpay: Int = 152_000

        // act
        val result = limitsExceeded(
            Card = vCard,
            totalSumInMonth = vtotalSumInMonth,
            pay = vpay
        )

        // assert
        assertEquals("InDay", result)
    }

    @Test
    fun `limit exceeded in Month check Mir` () {
        // arange
        val vCard: String = "Mir"
        val vtotalSumInMonth: Int = 555_000
        val vpay: Int = 46_000

        // act
        val result = limitsExceeded(
            Card = vCard,
            totalSumInMonth = vtotalSumInMonth,
            pay = vpay
        )

        // assert
        assertEquals("InMonth", result)
    }

    @Test
        fun `limit exceeded in Month check VkPay` () {
            // arange
            val vCard: String = "VkPay"
            val vtotalSumInMonth: Int = 35_000
            val vpay: Int = 12_000

            // act
            val result = limitsExceeded(
                Card = vCard,
                totalSumInMonth = vtotalSumInMonth,
                pay = vpay
            )

            // assert
            assertEquals("InMonth", result)
        }

    @Test
    fun `limit exceeded in Day check VkPay` () {
        // arange
        val vCard: String = "VkPay"
        val vtotalSumInMonth: Int = 20_000
        val vpay: Int = 16_000

        // act
        val result = limitsExceeded(
            Card = vCard,
            totalSumInMonth = vtotalSumInMonth,
            pay = vpay
        )

        // assert
        assertEquals("InDay", result)
    }

}