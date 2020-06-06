package copps.dockerpoc.domain.validator

interface Validator<T> {
    fun validate(obj: T): Unit
}