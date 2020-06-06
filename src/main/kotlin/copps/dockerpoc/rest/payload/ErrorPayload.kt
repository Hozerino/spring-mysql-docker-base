package copps.dockerpoc.rest.payload

import copps.dockerpoc.domain.model.ErrorEntry


data class ErrorPayload(val message: String, val errors: List<ErrorEntry>)