package net.zonetech.elbasket.Helpers

import android.content.Context
import android.content.Intent
import java.text.SimpleDateFormat
import java.util.Date
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import net.zonetech.elbasket.Utils.Common
import java.io.File
import java.io.IOException

class ImagesHelper(var mContext:Context) {

    private lateinit var currentPhotoPath: String


    internal val REQUEST_IMAGE_CAPTURE = 1
    internal val REQUEST_IMAGE_GALLERY = 2

    internal var intent: Intent? = null


//    fun selectImage(action: String): Intent? {
//        if (action.equals("camera")) {
//            intent = openCamera()
//        } else if (action.equals("gallery")) {
//            intent = openGallery()
//        }
//        return intent
//    }

//
//    private fun openCamera(): Intent? {
//        Common.ACTION_REQUEST = REQUEST_IMAGE_CAPTURE
//        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        return if (takePictureIntent.resolveActivity(mContext.getPackageManager()) != null) {
//            takePictureIntent
//        } else {
//            null
//
//        }
    }


//    private fun openGallery(): Intent? {
//
//        Common.ACTION_REQUEST = REQUEST_IMAGE_GALLERY
//        Log.d("openGallery", Common.ACTION_REQUEST.toString()+"**********************")
//        val takePictureIntent = Intent(Intent.ACTION_PICK)
//        takePictureIntent.setType("image/*")
//        val mimeTypes = arrayOf("image/jpeg", "image/png")
//        takePictureIntent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
//
//        if (takePictureIntent.resolveActivity(mContext.getPackageManager()) != null) {
//            // Create the File where the photo should go
//            var photoFile: File? = null
//            try {
//                photoFile = createImageFile()
//
//            } catch (ex: IOException) {
//                // Error occurred while creating the File
//                Toast.makeText(mContext, "Error creating File", Toast.LENGTH_SHORT).show()
//            }
//
//            // Continue only if the File was successfully created
//            if (photoFile != null) {
////                Common.profileImagePath = photoFile!!.getAbsolutePath()
//                return takePictureIntent
//            } else
//                return null
//
//        } else
//            return null
//    }
//
//
//    @Throws(IOException::class)
//    fun createImageFile(): File {
//        // Create an image file name
//        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
//        val imageFileName = "JPEG_" + timeStamp + "_"
//        val storageDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
//        val image = File.createTempFile(
//            imageFileName, /*  prefix     */
//            ".jpg", /*  suffix     */
//            storageDir     /*  directory  */
//        )
//
//        // Save a file: path for use with ACTION_VIEW intents
//        currentPhotoPath = image.getAbsolutePath()
//        return image
//    }

