package joshua.sommerfeld.vintracecodingchallenge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

import joshua.sommerfeld.vintracecodingchallenge.controllers.GetLotController
import joshua.sommerfeld.vintracecodingchallenge.controllers.BreakdownYearController
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class VintraceCodingChallengeApplication

fun main(args: Array<String>) {
	runApplication<VintraceCodingChallengeApplication>(*args)
}

@RestController
class BreakdownYearController {
	val mapper = jacksonObjectMapper()

	@GetMapping("/api/wine/{lotCode}")
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = ["http://localhost:3000"])
	fun getLot(@PathVariable("lotCode")lotCode: String): String {
		val lot = GetLotController.getLot(lotCode)
		return mapper.writeValueAsString(lot)
	}

	@GetMapping("/api/breakdown/year/{lotCode}")
    @ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = ["http://localhost:3000"])
	fun getBreakdownByYearEndpoint(@PathVariable("lotCode")lotCode: String): String {
		val calculatedBreakdown = BreakdownYearController.getBreakdownByYearFromLotCode(lotCode)
		return mapper.writeValueAsString(calculatedBreakdown)
	}
}