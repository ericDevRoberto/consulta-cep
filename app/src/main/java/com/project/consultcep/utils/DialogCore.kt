package com.project.consultcep.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.project.consultcep.R
import com.project.consultcep.databinding.InflateAlertDialogBinding

class DialogCore(
    private val baseContext: Context,
    @StringRes private val title: Int,
    @StringRes private val message: Int,
    @StringRes private val positiveBntTitle: Int? = null,
    private val onClickBntPositive: (() -> Unit)? = null,
    @StringRes private val negativeBntTitle: Int? = null,
    private val onClickBntNegative: (() -> Unit)? = null,
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val binding: InflateAlertDialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.inflate_alert_dialog,
            null,
            false
        )

        val view = View.inflate(baseContext, R.layout.inflate_alert_dialog, null)

        with(binding) {
            dialogTitle.setText(title)
            dialogMessage.setText(message)
            buttonNegative(dialogButtonNegative)
            if (positiveBntTitle != null)
                buttonPositive(dialogButtonPositive)
        }


        val builder = AlertDialog.Builder(view.context)
        builder.setView(binding.root)

        val dialogBuilder = builder.create()
        dialogBuilder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogBuilder.setCanceledOnTouchOutside(false)
        
        return dialogBuilder
    }

    private fun buttonPositive(button: Button) {
        with(button) {
            visibility = View.VISIBLE
            positiveBntTitle?.let { setText(it) }
            setOnClickListener {
                onClickBntPositive?.invoke()
            }
        }
    }

    private fun buttonNegative(button: Button) {
        with(button) {
            visibility = View.VISIBLE
            negativeBntTitle?.let { setText(it) }
            setOnClickListener {
                onClickBntNegative?.invoke()
                //dismissAllowingStateLoss()
            }
        }
    }


}

fun Fragment.alertDialog(
    @StringRes title: Int = R.string.dialog_text_generic_title,
    @StringRes message: Int = R.string.dialog_text_generic_message,
    @StringRes positiveBntTitle: Int? = null,
    onClickBntPositive: (() -> Unit)? = null,
    @StringRes negativeBntTitle: Int? = R.string.dialog_text_generic_negative_bnt,
    onClickBntNegative: (() -> Unit)? = null,
) = context?.let { context ->
    DialogCore(
        baseContext = context,
        title = title,
        message = message,
        positiveBntTitle = positiveBntTitle,
        onClickBntPositive = onClickBntPositive,
        negativeBntTitle = negativeBntTitle,
        onClickBntNegative = onClickBntNegative
    ).show(childFragmentManager, "Dialog")
}