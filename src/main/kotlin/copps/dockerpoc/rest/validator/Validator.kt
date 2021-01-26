package copps.dockerpoc.rest.validator

interface Validator<T> {
    fun validate(obj: T): Unit
}