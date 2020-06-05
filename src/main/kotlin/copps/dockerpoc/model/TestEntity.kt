package copps.dockerpoc.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "TEST_TABLE")
data class TestEntity(
        @Id
        val id: Long? = null,

        @Column(name = "COD_CODE")
        var code: String?,

        @Column(name = "DES_MESSAGE")
        var message: String?
)