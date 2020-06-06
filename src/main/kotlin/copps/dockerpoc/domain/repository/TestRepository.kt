package copps.dockerpoc.domain.repository

import copps.dockerpoc.domain.model.TestEntity
import org.springframework.data.repository.CrudRepository

interface TestRepository : CrudRepository<TestEntity, Long> {
    fun findByCodeAndMessage(code: String, message: String): List<TestEntity>
    fun findByCode(code: String): List<TestEntity>
    fun findByMessage(message: String): List<TestEntity>
}