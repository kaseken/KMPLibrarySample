package dev.kaseken.kmpsamplelibrary

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform