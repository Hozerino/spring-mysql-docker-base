package copps.dockerpoc.rest.controller

import copps.dockerpoc.domain.service.BaseService
import copps.dockerpoc.rest.exception.NotFoundException
import copps.dockerpoc.rest.payload.BaseEntityRequest
import copps.dockerpoc.rest.payload.BaseEntityResponse
import copps.dockerpoc.rest.validator.BaseRequestValidator
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
class BaseController(val baseService: BaseService,
                     val validator: BaseRequestValidator) {

    @GetMapping("/test")
    fun find(@RequestParam(required = false) code: String?,
               @RequestParam(required = false) message: String?): ResponseEntity<List<BaseEntityResponse>> {
        val response = baseService
                .searchByParams(code, message)
                .ifEmpty { throw NotFoundException("No entity found with code=$code and message=$message") }
                .map { it.toResponse() }

        return ResponseEntity.ok(response)
    }

    @PostMapping("/test")
    fun create(@Valid @RequestBody baseEntity: BaseEntityRequest): ResponseEntity<BaseEntityResponse> {
        validator.validate(baseEntity)

        return ResponseEntity.ok(
                baseService
                        .create(baseEntity.toModel())
                        .toResponse()
        )
    }
}