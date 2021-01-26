package copps.dockerpoc.domain.service

import copps.dockerpoc.domain.model.BaseEntity
import copps.dockerpoc.domain.repository.BaseRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BaseService(val baseRepository: BaseRepository) {
    fun searchByParams(code: String?, message: String?): List<BaseEntity> {
        return when {
            // both are present
            !code.isNullOrBlank() && !message.isNullOrBlank() -> baseRepository.findByCodeAndMessage(code, message)

            // code is present
            !code.isNullOrBlank() -> baseRepository.findByCode(code)

            // message is present
            !message.isNullOrBlank() -> baseRepository.findByMessage(message)

            // no entity, controller will deal with the response
            else -> Collections.emptyList()
        }
    }



    fun getAll(): List<BaseEntity> = baseRepository.findAll().toList()

    fun create(base: BaseEntity): BaseEntity {
        return baseRepository.save(base)
    }
}