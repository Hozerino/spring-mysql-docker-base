package copps.dockerpoc.rest.controller

import copps.dockerpoc.DockerpocApplication
import copps.dockerpoc.rest.payload.BaseEntityRequest
import copps.dockerpoc.rest.payload.ErrorPayload
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension


// ExtendWith = RunWith but in JUnit 5
@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [DockerpocApplication::class], webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
class BaseControllerIntegrationTest {

//    //TODO allow use of @LocalServerPort in Kotlin
    private var PORT = 55664
    private val BASE_PATH = "http://localhost:$PORT/api/test"

    val client = TestRestTemplate()

    @Test
    fun validateEmptyCode() {
        val nullCode = BaseEntityRequest("", "message")

        val response = client.postForEntity(BASE_PATH, nullCode, ErrorPayload::class.java)

        assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
        println(response)
    }


}
