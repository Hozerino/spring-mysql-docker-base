package copps.dockerpoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DockerpocApplication

fun main(args: Array<String>) {
	runApplication<DockerpocApplication>(*args)
}
