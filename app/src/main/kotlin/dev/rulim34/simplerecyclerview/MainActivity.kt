package dev.rulim34.simplerecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewVertical: RecyclerView
    private lateinit var recyclerViewHorizontal: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productList: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi RecyclerView Vertikal
        recyclerViewVertical = findViewById(R.id.recycler_view_vertical)
        recyclerViewVertical.layoutManager = GridLayoutManager(this, 2) // Untuk scroll vertikal

        // Inisialisasi RecyclerView Horizontal
        recyclerViewHorizontal = findViewById(R.id.recycler_view_horizontal)
        recyclerViewHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) // Untuk scroll horizontal

        // Buat data produk
        productList = listOf(
            Product(R.drawable.delta_force_website_image_1, "Product 1"),
            Product(R.drawable.delta_force_website_image_2, "Product 2"),
            Product(R.drawable.delta_force_vyron_image, "Product 3"),
            Product(R.drawable.delta_force_stinger, "Product 4"),
            Product(R.drawable.delta_force_m4abrams, "Product 5"),
            Product(R.drawable.delta_force_luna, "Product 6"),
            Product(R.drawable.delta_force_website_image_1, "Product 7"),
            Product(R.drawable.delta_force_website_image_2, "Product 8"),
            Product(R.drawable.delta_force_vyron_image, "Product 9"),
            Product(R.drawable.delta_force_stinger, "Product 10"),
            Product(R.drawable.delta_force_m4abrams, "Product 11"),
            Product(R.drawable.delta_force_luna, "Product 12"),
        )

        // Inisialisasi adapter untuk RecyclerView Vertikal
        productAdapter = ProductAdapter(productList)
        recyclerViewVertical.adapter = productAdapter

        // Inisialisasi adapter untuk RecyclerView Horizontal
        recyclerViewHorizontal.adapter = productAdapter // Anda bisa menggunakan adapter yang sama atau membuat adapter baru jika diperlukan
    }
}