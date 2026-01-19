package com.teacherry

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform