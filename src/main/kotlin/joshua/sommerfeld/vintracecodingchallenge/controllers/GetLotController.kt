package joshua.sommerfeld.vintracecodingchallenge.controllers

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

import joshua.sommerfeld.vintracecodingchallenge.fs.FileReader
import joshua.sommerfeld.vintracecodingchallenge.handlers.getBreakdownByYear
import joshua.sommerfeld.vintracecodingchallenge.models.CalculatedBreakdown
import joshua.sommerfeld.vintracecodingchallenge.models.Lot
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

object GetLotController {
    private val mapper = jacksonObjectMapper()

    @Throws(ResponseStatusException::class)
    fun getLot(lotCode: String): Lot {
        val maybeLotFile: String? = FileReader.readJsonFileFromResources(lotCode)
        val lotFile: String = maybeLotFile ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "lot not found")
        return mapper.readValue(lotFile)
    }
}