package com.android.labellens


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import com.android.labellens.databinding.FragmentCameraDisplayBinding
import com.android.labellens.databinding.FragmentLabelImagesBinding
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.text.method.Touch
import android.view.MotionEvent

class LabelImages : Fragment() {
    val LOG_TAG = "LabelImages"
    private lateinit var imagePreviewView: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentLabelImagesBinding>(inflater,
            R.layout.fragment_label_images, container, false)

        this.imagePreviewView = binding.imagePreview

        val imagePath = context!!.filesDir.path+"/picture.jpg"
        val files = context!!.filesDir.listFiles()
        for (f in files ){
            Log.d(LOG_TAG, f.name)
        }
        //val bitmap = BitmapFactory.decodeFile(imagePath)

        this.imagePreviewView.setImageURI(imagePath.toUri())
        Log.d(LOG_TAG, "Presenting image: ${imagePath.toUri()}")

        return binding.root
    }
}
