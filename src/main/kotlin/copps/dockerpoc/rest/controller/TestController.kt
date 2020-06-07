package copps.dockerpoc.rest.controller

import copps.dockerpoc.domain.service.TestService
import copps.dockerpoc.domain.validator.TestRequestValidator
import copps.dockerpoc.rest.payload.TestRequest
import copps.dockerpoc.rest.payload.TestResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class TestController(val testService: TestService,
                     val testTestRequestValidator: TestRequestValidator) {

    @GetMapping("/test")
    fun find(@RequestParam(required = false) code: String?,
               @RequestParam(required = false) message: String?): ResponseEntity<List<TestResponse>> {
        val response = testService
                .searchByParams(code, message)
                .map { it.toResponse() }

        return ResponseEntity.ok(response)
    }

    @PostMapping("/test")
    fun create(@Valid @RequestBody test: TestRequest): ResponseEntity<TestResponse> {
        return ResponseEntity.ok(
                testService
                        .create(test.toModel())
                        .toResponse()
        )
    }
}