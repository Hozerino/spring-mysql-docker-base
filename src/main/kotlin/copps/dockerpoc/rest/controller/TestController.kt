package copps.dockerpoc.rest.controller

import copps.dockerpoc.domain.model.TestEntity
import copps.dockerpoc.domain.service.TestService
import copps.dockerpoc.rest.payload.TestPayload
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class TestController(val testService: TestService) {

    @GetMapping("/test")
    fun find(@RequestParam(required = false) code: String?,
               @RequestParam(required = false) message: String?): ResponseEntity<List<TestPayload>> {
        val response = testService
                .searchByParams(code, message)
                .map { it.toResponse() }

        return ResponseEntity.ok(response)
    }

    @PostMapping("/test")
    fun create(@RequestBody test: TestEntity): ResponseEntity<TestPayload> {
        return ResponseEntity.ok(testService.create(test).toResponse())
    }
}