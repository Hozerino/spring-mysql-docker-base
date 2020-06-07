package copps.dockerpoc.rest.payload

import copps.dockerpoc.domain.model.TestEntity
import javax.validation.constraints.NotBlank

data class TestRequest(
        @NotBlank
        val code: String,
        @NotBlank
        val message: String
) {
    fun toModel() = TestEntity(null, code, message)
}

data class TestResponse(
        val id: Long,
        val code: String,
        val message: String
)