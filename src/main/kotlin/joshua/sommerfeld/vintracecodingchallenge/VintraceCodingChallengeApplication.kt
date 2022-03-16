package joshua.sommerfeld.vintracecodingchallenge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

import joshua.sommerfeld.vintracecodingchallenge.controllers.BreakdownYearController
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


@SpringBootApplication
class VintraceCodingChallengeApplication

fun main(args: Array<String>) {
	runApplication<VintraceCodingChallengeApplication>(*args)
}

@RestController
class BreakdownYearController {
	val mapper = jacksonObjectMapper()

	@GetMapping("/api/breakdown/year/{lotCode}")
	fun getBreakdownByYearEndpoint(@PathVariable("lotCode")lotCode: String): String {
		val calculatedBreakdown = BreakdownYearController.getBreakdownByYearFromLotCode(lotCode)
		return mapper.writeValueAsString(calculatedBreakdown)
	}
}