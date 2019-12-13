package com.android.labellens


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import com.android.labellens.databinding.FragmentCameraDisplayBinding
import com.android.labellens.databinding.FragmentLabelImagesBinding


class LabelImages : Fragment() {

    private lateinit var imagePreviewView: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentLabelImagesBinding>(inflater,
            R.layout.fragment_label_images, container, false)

        this.imagePreviewView = binding.imagePreview

        val image_path = requireContext().externalMediaDirs.first().name
        this.imagePreviewView.setImageURI( image_path.toUri() )

        return binding.root
    }


}
