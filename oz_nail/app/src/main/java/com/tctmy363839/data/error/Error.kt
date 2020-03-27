package com.tctmy363839.data.error

/**
 * Created by AhmedEltaher on 5/12/2016
 */

class Error(val code: Int, val description: String) {
    constructor(exception: Exception) : this(code = DEFAULT_ERROR, description = exception.message
            ?: "")

    companion object {
        const val NO_INTERNET_CONNECTION = -1
        const val NETWORK_ERROR = -2
        const val DEFAULT_ERROR = -3
    }
}