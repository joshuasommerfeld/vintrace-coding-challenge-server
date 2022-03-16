package joshua.sommerfeld.vintracecodingchallenge.controllers

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

import joshua.sommerfeld.vintracecodingchallenge.fs.FileReader
import joshua.sommerfeld.vintracecodingchallenge.handlers.getBreakdownByYear
import joshua.sommerfeld.vintracecodingchallenge.models.CalculatedBreakdown
import joshua.sommerfeld.vintracecodingchallenge.models.Lot
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

object BreakdownYearController {
    private val mapper = jacksonObjectMapper()

    @Throws(ResponseStatusException::class)
    fun getBreakdownByYearFromLotCode(lotCode: String): CalculatedBreakdown {
        val maybeLotFile: String? = FileReader.readJsonFileFromResources(lotCode)
        val lotFile: String = maybeLotFile ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "lot not found")
        val lot: Lot = mapper.readValue(lotFile)
        return getBreakdownByYear(lot)
    }
}