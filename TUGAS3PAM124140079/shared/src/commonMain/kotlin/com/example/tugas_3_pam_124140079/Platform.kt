package com.example.tugas_3_pam_124140079

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform