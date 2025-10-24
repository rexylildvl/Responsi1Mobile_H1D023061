package com.unsoed.responsi1mobile_h1d023061.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.responsi1mobile_h1d023061.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvHistoryTitle.text = "RCD Espanyol de Barcelona"

        binding.tvParagraph1.text = "RCD Espanyol de Barcelona, officially known as Reial Club Deportiu Espanyol de Barcelona, was founded in 1900 by Ángel Rodríguez Ruiz, a student of engineering at the University of Barcelona. It became one of the oldest football clubs in Spain and a founding member of La Liga in 1929. The club originally featured only local Catalan players, in contrast to other teams that relied on foreign talent. Espanyol’s blue and white colors were inspired by the coat of arms of the Count of Barcelona, a historic symbol of the city."

        binding.tvParagraph2.text = "Throughout the 20th century, Espanyol grew into one of the major clubs in Catalonia and became the main rival of FC Barcelona in the famous Derbi Barceloní. The club won its first Copa del Rey in 1929, followed by more trophies in 1940, 2000, and 2006. Although Espanyol never matched its city rival in global fame, it built a strong identity based on humility, hard work, and loyalty to its local supporters."

        binding.tvParagraph3.text = "Espanyol also achieved success on the European stage, reaching the UEFA Cup finals in 1988 and 2007, both times finishing as runners-up after dramatic penalty shootouts. The club has been home to many talented Spanish players such as Raúl Tamudo, Dani Jarque, Sergio García, and David López. Dani Jarque, a beloved captain, became an eternal symbol of the club after his tragic passing in 2009, and his legacy continues to inspire the team and its fans."

        binding.tvParagraph4.text = "Since 2009, Espanyol has played its home matches at the modern RCDE Stadium in Cornellà de Llobregat, replacing the historic Estadi de Sarrià. The club continues to compete in La Liga, aiming to strengthen its position among Spain’s elite. With the passionate support of their fans known as 'Pericos', RCD Espanyol remains a proud representation of Catalan spirit, tradition, and resilience in Spanish football."
    }
}
