package com.cyrillrx.library

object Config {
    val host: Host = Host.LOCAL

    enum class Host(val value: String) {
        LOCAL("10.0.2.2:3000"),
    }
}
