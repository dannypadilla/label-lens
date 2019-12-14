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
    val image_x_res = 640
    val image_y_res = 640
    val scaling_factor = 80// box size

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

        var x_center = -1
        var y_center = -1
        var x_up_left = 0
        var y_up_left = 0
        var x_low_right = 0
        var y_low_right = 0


        this.imagePreviewView.setOnTouchListener { view, motionEvent ->

            // Reset values
            x_up_left = 0
            y_up_left = 0
            x_low_right = 0
            y_low_right = 0

            var x_up_offset = false
            var y_up_offset = false
            var x_low_offset = false
            var y_low_offset = false

            x_center = motionEvent.getX().toInt()
            y_center = motionEvent.getY().toInt()

            /* Calculate bounding box for text file */

            // Upper left x, y coordinate
            x_up_left = x_center - this.scaling_factor
            y_up_left = y_center - this.scaling_factor

            // check if calculated coordinates are out of bound
            if (x_up_left < 0) {
                // need to handle low_right so it doesn't shrink
                x_low_offset = true
                x_up_left = 0
            }
            if (y_up_left < 0) {
                y_low_offset = true
                y_up_left = 0
            }


            // Lower Right x, y coordinate
            x_low_right = x_center + this.scaling_factor
            y_low_right = y_center + this.scaling_factor

            if (x_low_right > this.image_x_res) {
                x_up_offset = true
                x_low_right = this.image_x_res
            }
            if (y_low_right > this.image_y_res) {
                y_up_offset = true
                y_low_right = this.image_y_res
            }

            // handle offsetting of other coordinate values if any of the above are changed
            if (x_low_offset) {
                x_low_right = this.scaling_factor
            }
            if (y_low_offset) {
                y_low_right = this.scaling_factor
            }

            if (x_up_offset) {
                x_up_left = this.image_x_res - this.scaling_factor
            }
            if (y_up_offset) {
                x_up_left = this.image_y_res - this.scaling_factor
            }


            // Log coordinates
            Log.d(LOG_TAG, "\nTouched coordinates \nX:${x_center}\tY:${y_center}\n")
            Log.d(LOG_TAG, "\nCalculated coordinates \nX_up:${x_up_left}\tY_up:${y_up_left}\n")
            Log.d(LOG_TAG, "\nCalculated coordinates \nX_low:${x_low_right}\tY_low:${y_low_right}\n")

            return@setOnTouchListener true
        }

        return binding.root
    }
}
