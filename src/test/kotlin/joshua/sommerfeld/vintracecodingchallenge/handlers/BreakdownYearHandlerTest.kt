package joshua.sommerfeld.vintracecodingchallenge.handlers

import joshua.sommerfeld.vintracecodingchallenge.models.BreakdownComponent
import joshua.sommerfeld.vintracecodingchallenge.models.CalculatedBreakdown
import joshua.sommerfeld.vintracecodingchallenge.models.Component
import joshua.sommerfeld.vintracecodingchallenge.models.Lot
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BreakdownYearHandlerTest {

    @Test
    fun ensureCalculationBreakdownIsSummedCorrectly() {
        val inLot = Lot(
                "1234567",
                100.0,
                "test wine",
                "T25-00",
                "Almost There",
                "Test Wines Pty Ltd",
                arrayOf(
                        Component(10.0, 2000, "Example", "Melbourne"),
                        Component(15.0, 2000, "Example", "Melbourne"),
                        Component(20.0, 2001, "Example", "Melbourne"),
                        Component(25.0, 2001, "Example", "Melbourne"),
                        Component(30.0, 2002, "Example", "Melbourne"),
                )
        )

        val expectedBreakdown = CalculatedBreakdown("year", listOf(
                BreakdownComponent("2001", 45.0),
                BreakdownComponent("2002", 30.0),
                BreakdownComponent("2000", 25.0),
                ))
        assertEquals(getBreakdownByYear(inLot), expectedBreakdown)
    }

    @Test
    fun ensureEmptyHandledWithoutError() {
        val inLot = Lot(
                "1234567",
                100.0,
                "test wine",
                "T25-00",
                "Almost There",
                "Test Wines Pty Ltd",
                arrayOf()
        )

        val expectedBreakdown = CalculatedBreakdown("year", listOf())
        assertEquals(getBreakdownByYear(inLot), expectedBreakdown)
    }
}