package com.dynamicdriller.velox.ui.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.dynamicdriller.velox.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CancelTrackingDialog : DialogFragment() {


    private var yesListener: (() -> Unit)? = null

    fun setYesListener(listener: ()->Unit){
        yesListener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
            .setTitle("Cancel Tracking")
            .setMessage("Do you want to cancel tracking?")
            .setIcon(R.drawable.ic_delete)
            .setPositiveButton("Yes"){_,_->
                yesListener?.let {yes->
                    yes()
                }
            }
            .setNegativeButton("No"){dialogInterface,_->
                dialogInterface.cancel()
            }
            .create()
    }

}