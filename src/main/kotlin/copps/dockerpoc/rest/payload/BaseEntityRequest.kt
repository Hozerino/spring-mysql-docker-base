package copps.dockerpoc.rest.payload

import copps.dockerpoc.domain.model.BaseEntity
import javax.validation.constraints.NotBlank

data class BaseEntityRequest(
        @NotBlank
        val code: String,
        @NotBlank
        val message: String
) {
    fun toModel() = BaseEntity(null, code, message)
}

data class BaseEntityResponse(
        val code: String,
        val message: String
) : GenericResponse