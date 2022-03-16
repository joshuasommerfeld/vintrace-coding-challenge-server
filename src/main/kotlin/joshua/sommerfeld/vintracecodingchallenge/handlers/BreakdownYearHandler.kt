package joshua.sommerfeld.vintracecodingchallenge.handlers

import joshua.sommerfeld.vintracecodingchallenge.models.BreakdownComponent
import joshua.sommerfeld.vintracecodingchallenge.models.CalculatedBreakdown
import joshua.sommerfeld.vintracecodingchallenge.models.Component
import joshua.sommerfeld.vintracecodingchallenge.models.Lot

fun getBreakdownByYear(lot: Lot): CalculatedBreakdown {
    val breakdownComponents: List<BreakdownComponent> = lot.components
            .groupBy { it.year }
            .mapValues { (key, components) ->
                val percentageSum = components.sumOf { component: Component -> component.percentage }
                BreakdownComponent(key.toString(), percentageSum)
            }.values
            .sortedByDescending { breakdownComponent -> breakdownComponent.percentage }
    println(breakdownComponents)
    return CalculatedBreakdown("year", breakdownComponents)
}