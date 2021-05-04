package com.dat.android.gamebit.presentation.main.dialogs

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.dat.android.gamebit.PreferenceProvider
import com.dat.android.gamebit.R
import com.dat.android.gamebit.presentation.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_defeat.*

class FragmentDialogDefeat : DialogFragment() {

    interface Callbacks{
        fun replay()
    }

    companion object{

        private const val DATA_KEY = "DATA_KEY"

        fun newInstance(data : String) : FragmentDialogDefeat{
            var bundle = Bundle()
            bundle.putString(DATA_KEY, data)

            var fragment = FragmentDialogDefeat()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        var defeatView: View = inflater.inflate(R.layout.dialog_defeat, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(0))
        isCancelable = false
        return defeatView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        updateUI()
        // btn replay and exit

        btnRetry.setOnClickListener {
            //(activity as MainActivity).replay()
            (activity as Callbacks).replay()
            dismiss()
        }

        var data = arguments!!.getString(DATA_KEY)
        Log.e("LOL", "data -- $data")

    }

    private fun updateUI() {
        var backState = PreferenceProvider.getBackgroundStateSetting()
        when (backState) {
            PreferenceProvider.BACKGROUND_BLUE -> {
                llBackground.setBackgroundColor(resources.getColor(R.color.background_blue))
            }
            PreferenceProvider.BACKGROUND_GREEN -> {
                llBackground.setBackgroundColor(resources.getColor(R.color.background_green))
            }
            PreferenceProvider.BACKGROUND_RED -> {
                llBackground.setBackgroundColor(resources.getColor(R.color.background_red))
            }
        }
    }

}
