package com.android.labellens

import android.os.Bundle
import android.text.method.Touch
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import com.amazonaws.mobile.client.AWSMobileClient
import com.android.labellens.databinding.FragmentLabelImagesBinding
import kotlinx.android.synthetic.main.fragment_label_images.*
import java.io.File

class LabelImages : Fragment() {
    val LOG_TAG = "LabelImages"
    private lateinit var mobileHelper :MobileHubHelper

    private lateinit var uploadButton: Button
    private lateinit var imagePreviewView: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentLabelImagesBinding>(inflater,
            R.layout.fragment_label_images, container, false)

        this.mobileHelper = MobileHubHelper(this.context!!)
        this.uploadButton = binding.uploadButton
        this.imagePreviewView = binding.imagePreview

        val imagePath = context!!.filesDir.path+"/picture.jpg"
        val files = context!!.filesDir.listFiles()
        for (f in files ){
            Log.d(LOG_TAG, f.name)
        }
        //val bitmap = BitmapFactory.decodeFile(imagePath)

        this.imagePreviewView.setImageURI(imagePath.toUri())
        Log.d(LOG_TAG, "Presenting image: ${imagePath.toUri()}")
        uploadButtonClicked()

        AWSMobileClient.getInstance().initialize(this.context).execute()
        return binding.root
    }
    fun labelImage(touch: Touch) : String{
        return ""
    }
    suspend fun mobileUpload(){

    }
    fun uploadButtonClicked(){
        this.uploadButton.setOnClickListener{
            val imageName = "${System.currentTimeMillis()}.jpg"
            val imageFile = File(context!!.filesDir.path+"/picture.jpg")
            imageFile.copyTo(File(context!!.filesDir.path, imageName))

            val uploadedFile = File(context!!.filesDir.path+"/"+imageName)

            var textName = imageName.split(".")[0]
            textName += ".txt"
            val textFile = File(context!!.filesDir.path, textName)
            textFile.appendText("Classification [4,2,3,6]")
            try {
                mobileHelper.uploadWithTransferUtility(textFile)
                mobileHelper.uploadWithTransferUtility(uploadedFile)

            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

}
