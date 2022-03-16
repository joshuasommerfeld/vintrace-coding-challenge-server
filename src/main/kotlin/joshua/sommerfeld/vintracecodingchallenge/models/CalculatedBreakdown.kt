package joshua.sommerfeld.vintracecodingchallenge.models

data class BreakdownComponent(
    val key: String,
    val percentage: Double,
)

data class CalculatedBreakdown(
    val breakdownType: String,
    val breakdown: List<BreakdownComponent>
)