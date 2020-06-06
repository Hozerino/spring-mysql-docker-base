package copps.dockerpoc.domain.service

import copps.dockerpoc.domain.model.TestEntity
import copps.dockerpoc.domain.repository.TestRepository
import copps.dockerpoc.domain.validator.TestEntityValidator
import org.springframework.stereotype.Service
import java.util.*

@Service
class TestService(val testRepository: TestRepository,
                  val validator: TestEntityValidator) {
    fun searchByParams(code: String?, message: String?): List<TestEntity> =
            when {
                // both are present
                !code.isNullOrBlank() && !message.isNullOrBlank() -> testRepository.findByCodeAndMessage(code, message)

                // code is present
                !code.isNullOrBlank() -> testRepository.findByCode(code)

                // message is present
                !message.isNullOrBlank() -> testRepository.findByMessage(message)

                // none, getting all of them could be a heavy load
                else -> Collections.emptyList()
            }


    fun getAll(): List<TestEntity> = testRepository.findAll().toList()

    fun create(test: TestEntity): TestEntity {
        validator.validate(test)
        return testRepository.save(test)
    }
}