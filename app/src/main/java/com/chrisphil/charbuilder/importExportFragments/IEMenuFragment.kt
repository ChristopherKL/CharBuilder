package com.chrisphil.charbuilder.importExportFragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.controller.ImportExportController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.import_export_fragment.view.*

/**
 * Created by Phil on 25.01.2018.
 */
class IEMenuFragment : Fragment() {

    companion object {
        fun newInstance(): IEMenuFragment {
            return IEMenuFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.import_export_fragment, container, false)

        view.logout_button.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.content_frame, ImportExportController.newInstance(),"importExport")
                    .commit()
        }

        view.change_pw_button.setOnClickListener {
            var mauth = FirebaseAuth.getInstance()
            var email = mauth.currentUser!!.email.toString()
            mauth.sendPasswordResetEmail(email)
            Toast.makeText(context,"Passwortreset EMail versandt",Toast.LENGTH_LONG).show()
        }

        view.import_button.setOnClickListener {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.content_frame, ImportFragment.newInstance(),"import")
                    .commit()
        }

        view.export_button.setOnClickListener {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.content_frame, ExportFragment.newInstance(),"export")
                    .commit()
        }

        return view
    }
}