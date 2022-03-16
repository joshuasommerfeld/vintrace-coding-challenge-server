package joshua.sommerfeld.vintracecodingchallenge.models

data class Lot(
    val lotCode: String,
    val volume: Double,
    val description: String,
    val tankCode: String,
    val productState: String?,
    val ownerName: String,
    val components: Array<Component>
)