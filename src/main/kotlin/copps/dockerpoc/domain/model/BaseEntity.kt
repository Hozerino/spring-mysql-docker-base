package copps.dockerpoc.domain.model

import copps.dockerpoc.rest.payload.BaseEntityResponse
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "dockerpoc_db", name = "TEST_TABLE")
data class BaseEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "IDT_TEST")
        val id: Long? = null,

        @Column(name = "COD_CODE")
        var code: String = "",

        @Column(name = "DES_MESSAGE")
        var message: String = ""
) {
    fun toResponse() = BaseEntityResponse(this.code, this.message)
}