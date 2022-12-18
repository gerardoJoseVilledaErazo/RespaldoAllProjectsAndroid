package com.example.removebackgroundbyaristidevs

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.drawable.toBitmap
import com.example.removebackgroundbyaristidevs.databinding.ActivityMainBinding
import com.slowmac.autobackgroundremover.BackgroundRemover
import com.slowmac.autobackgroundremover.OnBackgroundChangeListener
import java.lang.Exception

/**
 * 1-Arquitectura
 * 2-Buscar diseño
 * 3-Poder seleccionar desde la galaria o desde la camara
 * 4-Guardar el resultado
 * 5-Opción de TRIM
 * 6-Compartir imagen
 * 7-Meter métodos de monetización (gratis con publi/pago único)
 * 8-Ficha
 * https://www.twitch.tv/videos/1647931043
 *45.40min
 * */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var iv: ImageView

    private val imageResult =
        registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            uri?.let { uri ->
//                binding.img.setImageURI(uri)
                iv.setImageURI(uri)
                processImage()
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        iv = findViewById(R.id.ivTests)
        imageResult.launch("image/*")
    }

//    val REQUEST_IMAGE_CAPTURE = 1
//
//    private fun dispatchTakePictureIntent() {
//        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        try {
//            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
//        } catch (e: ActivityNotFoundException) {
//            // display error state to the user
//        }
//    }

    fun processImage(/*image: Bitmap*/) {
        BackgroundRemover.bitmapForProcessing(
//            image,
            iv.drawable.toBitmap(),
            false,
            object : OnBackgroundChangeListener {
                override fun onSuccess(bitmap: Bitmap) {
                    // do what ever you want to do with this bitmap
                    iv.setImageBitmap(bitmap)
                }

                override fun onFailed(exception: Exception) {
                    //exception
                }
            }
        )
    }
}