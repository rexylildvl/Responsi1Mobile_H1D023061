# ⚽️ Responsi 1 Mobile — RCD Espanyol App

**Nama:** Raia Digna Amanda  
**NIM:** H1D023061  
**Shift Asal:** Shift C  
**Shift Baru:** Shift C  

---

## 📱 Deskripsi Aplikasi
Aplikasi **Responsi 1 Mobile (H1D023061)** merupakan aplikasi Android yang menampilkan informasi klub sepak bola **RCD Espanyol de Barcelona**.  
Aplikasi ini menampilkan:
- Profil dan sejarah klub  
- Data pelatih utama (Head Coach)  
- Daftar pemain (Team Squad)

---

## 🎬 Video Demo Aplikasi

Berikut adalah tampilan demo aplikasi:

<p align="center">
  <img src="assets/demo_app.gif" width="320" height="640" alt="Demo Responsi 1 Mobile">
</p>

---

## 🧠 Alur Data — Dari API ke Tampilan UI

Berikut penjelasan alur data mulai dari pemanggilan API hingga penyajian di layar:

1. Pemanggilan API
   Aplikasi menggunakan endpoint resmi dari [Football Data API](https://www.football-data.org/). Token API dikirim melalui header.
3. Repository
   TeamRepository.kt berfungsi sebagai jembatan antara API dan ViewModel. Tugasnya memanggil data dari server melalui Retrofit, kemudian mengirimkannya ke ViewModel.
4. ViewModel
  TeamViewModel.kt mengatur alur data dari Repository ke tampilan (UI). Menggunakan LiveData agar UI otomatis ter-update saat data baru diterima.
5. Penyajian di Tampilan (UI)
   View melakukan observe terhadap data dari ViewModel, lalu menampilkan hasilnya pada komponen UI seperti TextView, ImageView.

Alur Lengkap Data :
1. Pengguna membuka aplikasi → MainActivity dijalankan.
2. ViewModel memanggil data dari API melalui TeamRepository.
3. Data JSON dari server dikonversi menjadi model Kotlin (ApiResponse.kt).
4. LiveData di ViewModel memperbarui UI secara otomatis setelah data diterima.
5. Tampilan menampilkan nama klub, pelatih, stadion, serta daftar pemain sesuai data dari API.




