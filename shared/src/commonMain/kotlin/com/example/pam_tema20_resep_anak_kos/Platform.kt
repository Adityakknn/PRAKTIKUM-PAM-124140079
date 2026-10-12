package com.example.pam_tema20_resep_anak_kos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform