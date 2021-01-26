package copps.dockerpoc.domain.service

import copps.dockerpoc.domain.repository.BaseRepository
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.times

class BaseServiceTest {
    val repository = Mockito.mock(BaseRepository::class.java)

    val service = BaseService(repository)

    @Test
    fun searchByCodeAndMessage() {
        val code = "code"
        val message = "message"
        service.searchByParams(code, message)

        Mockito.verify(repository, times(1)).findByCodeAndMessage(code, message)
    }

    @Test
    fun emptyCode() {
        val code = ""
        val message = "message"
        service.searchByParams(code, message)

        Mockito.verify(repository, times(1)).findByMessage(message)
    }

    @Test
    fun emptyMessage() {
        val code = "code"
        val message = ""
        service.searchByParams(code, message)

        Mockito.verify(repository, times(1)).findByCode(code)
    }
}