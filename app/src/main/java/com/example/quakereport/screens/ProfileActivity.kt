package com.example.quakereport.screens

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.quakereport.R

@Suppress("DEPRECATION")
class ProfileActivity : AppCompatActivity() {

    private val GALLERY_REQ_CODE = 101
    private lateinit var profileImage: de.hdodenhof.circleimageview.CircleImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        profileImage = findViewById(R.id.profile_image)
        val btnGallery: ImageButton = findViewById(R.id.btn_pic_img)
        btnGallery.setOnClickListener(View.OnClickListener {
            fun onClick(v: View) {
                val iGallery = Intent(Intent.ACTION_PICK)
                iGallery.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                startActivityForResult(iGallery, GALLERY_REQ_CODE)
            }
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GALLERY_REQ_CODE) {
                val selectedImageUri = data?.data
                if (selectedImageUri != null) {
                    // Set the selected image URI to the profileImage
                    profileImage.setImageURI(selectedImageUri)
                }
            }
        }
    }

}