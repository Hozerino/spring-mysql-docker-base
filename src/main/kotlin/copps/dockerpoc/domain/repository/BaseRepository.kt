package copps.dockerpoc.domain.repository

import copps.dockerpoc.domain.model.BaseEntity
import org.springframework.data.repository.CrudRepository

interface BaseRepository : CrudRepository<BaseEntity, Long> {
    fun findByCodeAndMessage(code: String, message: String): List<BaseEntity>
    fun findByCode(code: String): List<BaseEntity>
    fun findByMessage(message: String): List<BaseEntity>
}