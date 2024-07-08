package com.example.phonepro.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.example.phonepro.util.Constants
import com.example.phonepro.R
import com.example.phonepro.databinding.ActivityMainBinding
import com.example.phonepro.domain.BrandObject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.tbMain)
        setDialog()

    }

    private fun setDialog() {
        val brandsList = listOf(
            BrandObject(
                binding.ibApple,
                "iPhone",
                " The iPhone, synonymous with sleek design and unparalleled user experience, embodies a harmonious blend of cutting-edge technology and elegant aesthetics. Known for its seamless integration of hardware and software, it continues to redefine the standards of user-centric innovation, setting benchmarks for the entire industry.")
            ,BrandObject(
                binding.ibSamsung,
                "Samsung",
                "Samsung smartphones epitomize the epitome of technological advancement, offering a diverse range of devices that cater to various user preferences. With a reputation for pioneering displays, robust performance, and an extensive ecosystem, Samsung's commitment to innovation consistently propels the boundaries of what is possible in the world of mobile technology. ")
            , BrandObject(
                brand = binding.ibGoogle,
                brandName = "Google",
                description =   " Google's smartphones are a testament to the company's commitment to seamless integration of software and hardware, delivering an intuitive and optimized user experience. Renowned for their powerful AI-driven capabilities, Google's devices empower users with a blend of sophisticated design, cutting-edge camera technology, and access to a comprehensive suite of Google services, making them a reliable choice for those immersed in the Google ecosystem.")
        , BrandObject(brand = binding.ibOppo,
                brandName = "Oppo",
            description =  " Oppo's smartphones combine innovative design with state-of-the-art technology, delivering a compelling user experience that emphasizes both style and functionality. With a focus on camera prowess, Oppo devices are tailored for photography enthusiasts, offering an array of features that capture the finer nuances of every moment. Additionally, Oppo's commitment to seamless performance and striking visual appeal positions their smartphones as an appealing choice for users seeking a harmonious balance between style and substance. ")
                )
        brandsList.forEach { brandObject ->
            brandObject.brand.setOnClickListener { addCallBack(brandObject.brandName,brandObject.description) }
        }
    }
    private fun addCallBack(name:String, description:String) {
        AlertDialog.Builder(this).setTitle(name)
            .setMessage(description)
            .create().show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.brands_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.iphone -> startModelsActivity(Constants.iPhone)
            R.id.samsung -> startModelsActivity(Constants.samsung)
            R.id.google_pixel -> startModelsActivity(Constants.googlePixel)
            R.id.oppo -> startModelsActivity(Constants.oppo)
        }
        return super.onOptionsItemSelected(item)
    }
    private fun startModelsActivity(brand:String) {
        val intent = Intent(this@MainActivity, ModelsActivity::class.java)
        intent.putExtra(getString(R.string.brand), brand)
        startActivity(intent)
    }
}
