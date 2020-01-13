package com.example.ice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_check.*

class Check : AppCompatActivity() {
    private lateinit var itemsAdapter: ItemsRecyclerAdapter

    val list = ArrayList<Items>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)

        btnRecommendation3.setOnClickListener(){
            val intent = Intent(this, Recommendation::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0);
        }

        btnHC3.setOnClickListener(){
            val intent = Intent(this, Comparison::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0);
        }


        btnAdd.setOnClickListener({
            val rnds = (0..10).random()
            initRecyclerView()

            var part=  Items("CPU", R.drawable.ryzen5cpu, "AMD Ryzen 5 3600", 899.00)

            if(rnds==2){
               part = Items("CPU", R.drawable.i5, "Intel Core i5-9600K", 499.00)
            }else if(rnds ==3){
                part = Items("CPU", R.drawable.i7, "Intel Core i7-9700K", 999.00)
            }else if(rnds == 4){
                part = Items("CPU Cooler", R.drawable.corsair, "Corsair H100i RGB PLATINUM", 450.00)
            }else if(rnds == 5){
                part = Items("CPU Cooler", R.drawable.max, "AMD Wraith Max", 199.00)
            }else if(rnds == 6){
                part = Items("Motherboard", R.drawable.msi, "MSI B450M GAMING PLUS",280.00)
            }else if(rnds == 7){
                part = Items("Graphic Card", R.drawable.giga, "Gigabyte GAMING OC", 1599.00)
            }else if(rnds == 8){
                part = Items("Graphic Card", R.drawable.rog, "Asus ROG Strix Gaming OC", 4999.00)
            }else if(rnds == 9){
                part = Items("Memory", R.drawable.ram, "Corsair Vengeance RGB Pro 32 GB", 478.00)
            }else if(rnds==10){
                part = Items("Storage", R.drawable.ssd, "Samsung 970 EVO Plus", 1799.00)
            }




            list.add(part)




            itemsAdapter.submitList(list)



        })

        btnTest2.setOnClickListener {

            if (list.size != 0){
                list.removeAt(0)
                initRecyclerView()
                itemsAdapter.submitList(list)
            }else{
                Toast.makeText(this, "No Component Found!", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun initRecyclerView(){
        rv.layoutManager = LinearLayoutManager(this@Check)
        itemsAdapter = ItemsRecyclerAdapter()
        rv.adapter = itemsAdapter
    }
}
