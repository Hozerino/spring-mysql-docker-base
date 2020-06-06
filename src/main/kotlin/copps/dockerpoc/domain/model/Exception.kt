package copps.dockerpoc.domain.model

data class ErrorEntry(
        val description: String
)

class ValidationException(override val message: String, val errors: List<ErrorEntry>) : RuntimeException()