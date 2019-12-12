package com.android.labellens

import android.app.Application
import android.content.Context
import android.util.Log
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility
import com.amazonaws.services.s3.AmazonS3Client
import java.io.File

class MobileHubHelper(val context: Context) {
    val LOG_TAG = "MobileHub"

    fun uploadWithTransferUtility(file: File) {
        val transferUtility = TransferUtility.builder()
            .context(this.context)
            .awsConfiguration(AWSMobileClient.getInstance().configuration)
            .s3Client(AmazonS3Client(AWSMobileClient.getInstance().credentialsProvider))
            .build()


        val uploadObserver = transferUtility.upload("labellens-userfiles-mobilehub-866544857/public", "0001.jpg", file)

        // Attach a listener to the observer
        uploadObserver.setTransferListener(object : TransferListener {
            override fun onStateChanged(id: Int, state: TransferState) {
                if (state == TransferState.COMPLETED) {
                    // Handle a completed upload
                }
            }

            override fun onProgressChanged(id: Int, current: Long, total: Long) {
                val done = (((current.toDouble() / total) * 100.0).toInt())
                Log.d(LOG_TAG, "UPLOAD - - ID: $id, percent done = $done")
            }

            override fun onError(id: Int, ex: Exception) {
                Log.d(LOG_TAG, "UPLOAD ERROR - - ID: $id - - EX: ${ex.message.toString()}")
            }
        })

        // If you prefer to long-poll for updates
        if (uploadObserver.state == TransferState.COMPLETED) {
            Log.d(LOG_TAG, "File Upload Complete!")
        }
        val bytesTransferred = uploadObserver.bytesTransferred
    }

}