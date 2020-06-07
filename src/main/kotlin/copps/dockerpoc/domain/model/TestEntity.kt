package copps.dockerpoc.domain.model

import copps.dockerpoc.rest.payload.TestResponse
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "dockerpoc_db", name = "TEST_TABLE")
data class TestEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "IDT_TEST")
        val id: Long? = null,

        @Column(name = "COD_CODE")
        var code: String = "",

        @Column(name = "DES_MESSAGE")
        var message: String = ""
) {
    fun toResponse() = TestResponse(this.id!!, this.code, this.message)
}