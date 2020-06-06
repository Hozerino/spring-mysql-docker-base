package copps.dockerpoc.domain.validator

import copps.dockerpoc.domain.model.ErrorEntry
import copps.dockerpoc.domain.model.TestEntity
import copps.dockerpoc.domain.model.ValidationException
import org.springframework.stereotype.Component

@Component
class TestEntityValidator : Validator<TestEntity> {

    val CODE_MAX_SIZE = 32
    val MESSAGE_MAX_SIZE = 255

    override fun validate(obj: TestEntity) {
        val errors = mutableListOf<ErrorEntry>()

        // code validation
        if (obj.code.isBlank()) {
            errors.add(ErrorEntry("Code must not be blank"))
        }
        if (obj.code.length >= CODE_MAX_SIZE) {
            errors.add(ErrorEntry("Code must be equal to or smaller than $CODE_MAX_SIZE characters"))
        }

        // message validation
        if (obj.message.length >= MESSAGE_MAX_SIZE) {
            errors.add(ErrorEntry("Code must be equal to or smaller than $MESSAGE_MAX_SIZE characters"))
        }
        if(obj.message.isBlank()) {
            errors.add(ErrorEntry("Message must not be blank"))
        }

        if(errors.isNotEmpty()) {
            throw ValidationException("Invalid payload for object Test", errors)
        }
    }
}