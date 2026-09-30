package com.example.tugas_3_pam_124140079

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import tugas3pam124140079.shared.generated.resources.Res
import tugas3pam124140079.shared.generated.resources.Pasfoto


// ==========================================
// TEMA WARNA STARBUCKS
// ==========================================
val StarbucksGreen = Color(0xFF00704A)
val StarbucksDarkGreen = Color(0xFF1E3932)
val StarbucksCream = Color(0xFFF2F0EB)
val StarbucksWarmWhite = Color(0xFFFFFFFF)

// ==========================================
// TAMPILAN UTAMA (App)
// ==========================================
@Composable
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = StarbucksCream
        ) {
            var showContactInfo by remember { mutableStateOf(false) }
            var showSchoolInfo by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(StarbucksCream)
                    .verticalScroll(rememberScrollState())
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                // 1. Header Profil
                ProfileHeader(
                    name = "Aditya Kristian Novalino",
                    nim = "124140079",
                    bio = "Teknik Informatika Institut Teknologi Sumatera."
                )

                Spacer(modifier = Modifier.height(32.dp))

                // 2. Tombol Detail Contact
                Button(
                    onClick = { showContactInfo = !showContactInfo },
                    colors = ButtonDefaults.buttonColors(containerColor = StarbucksGreen),
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(44.dp)
                ) {
                    Text(
                        text = if (showContactInfo) "Hide Contact" else "Detail Contact",
                        color = StarbucksWarmWhite,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 3. Card Informasi Kontak (tepat di bawah tombol Detail Contact)
                AnimatedVisibility(visible = showContactInfo) {
                    ContactInfoCard()
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 4. Tombol Detail School
                Button(
                    onClick = { showSchoolInfo = !showSchoolInfo },
                    colors = ButtonDefaults.buttonColors(containerColor = StarbucksGreen),
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(44.dp)
                ) {
                    Text(
                        text = if (showSchoolInfo) "Hide School" else "Detail School",
                        color = StarbucksWarmWhite,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 5. Card Informasi Sekolah (tepat di bawah tombol Detail School)
                AnimatedVisibility(visible = showSchoolInfo) {
                    SchoolInfoCard()
                }
            }
        }
    }
}

// ==========================================
// REUSABLE COMPOSABLE 1: ProfileHeader
// ==========================================
@Composable
fun ProfileHeader(name: String, nim: String, bio: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Foto profil
        Image(
            painter = painterResource(Res.drawable.Pasfoto),
            contentDescription = "Foto Profil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
                .border(4.dp, Color.White, CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = StarbucksDarkGreen
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "NIM: $nim",
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = StarbucksGreen
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = bio,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.DarkGray,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }
}

// ==========================================
// REUSABLE COMPOSABLE 2: ContactInfoCard
// ==========================================
@Composable
fun ContactInfoCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = StarbucksWarmWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = "Informasi Anggota",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = StarbucksDarkGreen
            )

            InfoItem(
                icon = "✉️",
                label = "Student Email",
                value = "aditya.124140079@student.itera.ac.id"
            )

            InfoItem(
                icon = "📞",
                label = "Phone",
                value = "+62 0897-9102-225"
            )

            InfoItem(
                icon = "📍",
                label = "Location",
                value = "Wayhui, Bandar Lampung, Indonesia"
            )
        }
    }
}

// ==========================================
// REUSABLE COMPOSABLE 3: SchoolInfoCard
// ==========================================
@Composable
fun SchoolInfoCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = StarbucksWarmWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = "Informasi Kampus",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = StarbucksDarkGreen
            )

            InfoItem(
                icon = "🏫",
                label = "Curriculum Vitae",
                value = "www.adityakn.com"
            )

            InfoItem(
                icon = "🎓",
                label = "Peminatan",
                value = "Artificial Inteligence Data Engineer"
            )

            InfoItem(
                icon = "🪪",
                label = "Angkatan",
                value = "2024"
            )
        }
    }
}

// ==========================================
// REUSABLE COMPOSABLE 4: InfoItem
// ==========================================
@Composable
fun InfoItem(icon: String, label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(StarbucksCream),
            contentAlignment = Alignment.Center
        ) {
            Text(text = icon, fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.width(14.dp))

        Column {
            Text(
                text = label,
                fontSize = 11.sp,
                color = Color.Gray
            )
            Text(
                text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = StarbucksDarkGreen
            )
        }
    }
}