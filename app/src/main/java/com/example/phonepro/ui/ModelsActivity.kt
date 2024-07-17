package com.example.phonepro.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phonepro.util.ModelsAdapter
import com.example.phonepro.util.Constants
import com.example.phonepro.R
import com.example.phonepro.R.drawable.background
import com.example.phonepro.R.drawable.iphoneforteen
import com.example.phonepro.R.drawable.iphonefourteenred
import com.example.phonepro.R.drawable.iphonefourteenyellow
import com.example.phonepro.databinding.ActivityModelsBinding
import com.example.phonepro.domain.ObjectModel
import com.example.phonepro.domain.SpinnerObject
import com.example.phonepro.util.ModelClickListener

class ModelsActivity : AppCompatActivity() ,ModelClickListener{
    private lateinit var iPhoneList :List<ObjectModel>
    private lateinit var samsungList  :List<ObjectModel>
    private lateinit var googleList  :List<ObjectModel>
    private lateinit var oppoList  :List<ObjectModel>
    private lateinit var binding:ActivityModelsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareLists()
        getPhoneBrand()
    }


    private fun getPhoneBrand() {
        val brand = intent.getStringExtra(getString(R.string.brand))
        when (brand) {
            Constants.iPhone -> binding.rvModels.adapter = setAdapter(iPhoneList)
            //Constants.iPhone -> binding.rvModels.adapter = ModelsAdapter(iPhoneList,this@ModelsActivity)
            Constants.samsung -> binding.rvModels.adapter = setAdapter(samsungList)
            Constants.googlePixel -> binding.rvModels.adapter = setAdapter(googleList)
            Constants.oppo -> binding.rvModels.adapter = setAdapter(oppoList)
        }
    }
    fun setAdapter(list:List<ObjectModel>):ModelsAdapter{
       return ModelsAdapter(list,this@ModelsActivity)
        //return ModelsAdapter(iPhoneList,this@ModelsActivity)
    }
    private fun prepareLists() {
        iPhoneList = listOf(
            ObjectModel(iphonefourteenred
                , "iPhone 14"
                ,"$600"
                ,"  The iPhone 14 features a sleek design, powerful A15 Bionic chip," +
                        " enhanced dual-camera system for stunning photos and videos, and improved battery life." +
                        " It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options" +
                        ", it combines innovation and style for an exceptional user experience."
            ,  arrayListOf(SpinnerObject(image = 0, colorText = "_"),SpinnerObject(iphoneforteen,"purple")
                    ,SpinnerObject(iphonefourteenyellow,"Yellow")
                    ,SpinnerObject(iphonefourteenred,"Red"))
            ),
            ObjectModel(iphoneforteen
                ,"iPhone 14 Max "
                ,"$750"
                ,"  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience."
            ,arrayListOf(SpinnerObject(iphoneforteen,"purple")
                    ,SpinnerObject(iphonefourteenyellow,"Yellow")
                    ,SpinnerObject(iphonefourteenred,"Red"))),
            ObjectModel(iphonefourteenyellow,
                "iPhone 14 Pro",
                "$900",
                "  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience."
            ,arrayListOf(SpinnerObject(iphoneforteen,"purple")
                    ,SpinnerObject(iphonefourteenyellow,"Yellow")
                    ,SpinnerObject(iphonefourteenred,"Red"))) )
        samsungList = listOf(
            ObjectModel(background
                ,"Galaxy S22"
                ,"$200"
                ,"  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience."
            ,arrayListOf(SpinnerObject(iphoneforteen,"purple")
                    ,SpinnerObject(iphonefourteenyellow,"Yellow")
                    ,SpinnerObject(iphonefourteenred,"Red"))),
            ObjectModel(background
                ,"Galaxy S22 Ultra  "
                ,"$200"
                ,"  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience."
            ,arrayListOf(SpinnerObject(iphoneforteen,"purple")
                    ,SpinnerObject(iphonefourteenyellow,"Yellow")
                    ,SpinnerObject(iphonefourteenred,"Red"))),
            ObjectModel(background,
                "Galaxy Z",
                "$250",
                "  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience."
            ,arrayListOf(SpinnerObject(iphoneforteen,"purple")
                    ,SpinnerObject(iphonefourteenyellow,"Yellow")
                    ,SpinnerObject(iphonefourteenred,"Red"))) )
        googleList = listOf(
            ObjectModel(background
                ,"Google Pixel 6"
                ,"$150"
                ,"  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience."
            ,arrayListOf(SpinnerObject(iphoneforteen,"purple")
                    ,SpinnerObject(iphonefourteenyellow,"Yellow")
                    ,SpinnerObject(iphonefourteenred,"Red"))),
            ObjectModel(background,
                "Google Pixel 6 Pro "
                ,"$200 ",
                "  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience."
            ,arrayListOf(SpinnerObject(iphoneforteen,"purple")
                    ,SpinnerObject(iphonefourteenyellow,"Yellow")
                    ,SpinnerObject(iphonefourteenred,"Red"))),
            ObjectModel(background,
                "Google Pixel 6a",
                "$4250",
                "  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience."
            ,arrayListOf(SpinnerObject(iphoneforteen,"purple")
                    ,SpinnerObject(iphonefourteenyellow,"Yellow")
                    ,SpinnerObject(iphonefourteenred,"Red"))) )
       oppoList = listOf(
           ObjectModel(background,
               "Oppo Find X5",
               "$200",
               "  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience."
           ,arrayListOf(SpinnerObject(iphoneforteen,"purple")
                   ,SpinnerObject(iphonefourteenyellow,"Yellow")
                   ,SpinnerObject(iphonefourteenred,"Red"))),
           ObjectModel(background
               ,"Oppo Find X5 Pro  "
               ,"$230"
               ,"  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience."
           ,arrayListOf(SpinnerObject(iphoneforteen,"purple")
                   ,SpinnerObject(iphonefourteenyellow,"Yellow")
                   ,SpinnerObject(iphonefourteenred,"Red"))),
            ObjectModel(background,
                "Oppo Find X3",
                "$270",
                "  The iPhone 14 features a sleek design, powerful A15 Bionic chip, enhanced dual-camera system for stunning photos and videos, and improved battery life. It boasts a vibrant 6.1-inch Super Retina XDR display and runs on iOS 15, offering seamless performance and advanced features. Available in various colors and storage options, it combines innovation and style for an exceptional user experience."
            ,arrayListOf(SpinnerObject(iphoneforteen,"purple")
                    ,SpinnerObject(iphonefourteenyellow,"Yellow")
                    ,SpinnerObject(iphonefourteenred,"Red"))) )
    }

    override fun click(objectModel: ObjectModel) {
        val intent = Intent(this,ModelDetailsActivity::class.java)
        intent.putExtra(Constants.model,objectModel)
        startActivity(intent)
    }
}