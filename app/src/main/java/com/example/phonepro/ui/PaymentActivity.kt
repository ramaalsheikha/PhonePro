package com.example.phonepro.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.phonepro.R
import com.example.phonepro.domain.SelectedModelList

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        getData()
    }

    private fun getData() {
        val selectedModelObject = intent.getParcelableExtra<SelectedModelList>(getString(R.string.selectedmodellist))
        selectedModelObject?.let {
            if (it.modelList.isNotEmpty()) {
                Toast.makeText(this, "${it.modelList[0]} ${it.modelList[1]} ${it.modelList[2]} ${it.modelList[3]}", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Model list is empty", Toast.LENGTH_LONG).show()
            }
        } }
}