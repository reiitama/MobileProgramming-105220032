package com.example.materi_52

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    private lateinit var addButton: Button // Tombol "Tambah Kartu"
    private lateinit var cardContainer: LinearLayout // Container untuk kartu-kartu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi tombol "tambah kartu"
        addButton = findViewById(R.id.addButton)

        // Inisialisasi container kartu
        cardContainer = findViewById(R.id.cardContainer)

        // Tambahkan kartu baru ketika tombol "Tambah Kartu" ditekan
        addButton.setOnClickListener {
            tambahKartu()
        }
    }

    private fun tambahKartu() {
        // Membuat tampilan kartu baru dari file layout card_layout.xml
        val cardView = LayoutInflater.from(this).inflate(R.layout.card_layout, null) as CardView

        // TextView untuk judul kartu
        val titleTextView = cardView.findViewById<TextView>(R.id.titleTextView)

        // TextView untuk deskripsi kartu
        val descriptionTextView = cardView.findViewById<TextView>(R.id.descriptionTextView)

        // Mengatur judul kartu
        titleTextView.text = "Coba tebak?"

        // Mengatur deskripsi kartu
        descriptionTextView.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed at sollicitudin lorem. Nunc nec tincidunt est. Vestibulum ullamcorper neque vitae lacus finibus, id varius tellus tincidunt. Integer auctor ullamcorper ex, in fringilla leo volutpat eu. Ut consectetur fermentum maximus. Phasellus id tortor sed urna fringilla tempor. Praesent ac felis ac odio gravida hendrerit nec et ex. Integer ut efficitur nunc. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "

        // Mengatur warna latar belakang kartu secara acak
        cardView.setCardBackgroundColor(getRandomColor())

        // Menambahkan kartu ke dalam container
        cardContainer.addView(cardView)
    }

    private fun getRandomColor(): Int {
        // Array warna yang tersedia
        val colors = arrayOf(
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.CYAN,
            Color.MAGENTA
        )
        // Memilih indeks warna secara acak
        val randomIndex = (0 until colors.size).random()

        // Mengembalikan warna yang dipilih secara acak
        return colors[randomIndex]
    }
}
