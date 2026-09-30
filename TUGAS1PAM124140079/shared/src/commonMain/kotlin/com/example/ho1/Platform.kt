package com.example.ho1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform