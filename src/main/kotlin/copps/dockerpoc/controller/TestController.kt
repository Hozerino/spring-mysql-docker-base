package copps.dockerpoc.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @GetMapping("/echo")
    fun redirector(@RequestParam("echo", required = false, defaultValue = "manda alguma coisa caraio") echo: String): String {
        return echo
    }
}