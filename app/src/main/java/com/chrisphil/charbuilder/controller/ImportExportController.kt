package com.chrisphil.charbuilder.controller

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.chrisphil.charbuilder.R
import com.chrisphil.charbuilder.importExportFragments.IEMenuFragment
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.import_export_signin_fragment.view.*
import kotlinx.android.synthetic.main.import_export_signup_dialog.view.*

/**
 * Created by Phil on 24.11.2017.
 */
class ImportExportController : Fragment(){

    companion object {
        fun newInstance(): ImportExportController {
            return ImportExportController()
        }
    }

    lateinit var mAuth : FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.import_export_signin_fragment,container,false)

        mAuth = FirebaseAuth.getInstance()

        view.btn_login.setOnClickListener {
            view.clearFocus()
            signIn()
        }

        view.link_signup.setOnClickListener {
            signUpDialog()
        }

        return view
    }

    fun updateUI(){
        fragmentManager
                .beginTransaction()
                .replace(R.id.content_frame,ImportExportController.newInstance(),"importExport")
                .commit()
    }


    private fun signIn(){
        if(mAuth.currentUser == null){
            val email = view!!.input_email.text.toString()
            val password = view!!.input_password.text.toString()


            if(email != "" && password != "") {
                mAuth
                        .signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(activity) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("Firebase", "signUserWithEmail:success")
                                fragmentManager
                                        .beginTransaction()
                                        .replace(R.id.content_frame, IEMenuFragment.newInstance(),"importExport")
                                        .commit()
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("Firebase", "signUserWithEmail:failure")
                                Toast.makeText(context, "Anmeldung fehlgeschlagen.",
                                        Toast.LENGTH_LONG).show()
                            }
                        }
            }
        }
    }

    private fun signUpDialog(){
        if (mAuth.currentUser == null){
            var dialog = AlertDialog.Builder(context)
            var view = layoutInflater.inflate(R.layout.import_export_signup_dialog,null)

            view.btn_signup.setOnClickListener {
                val email = view!!.email.text.toString()
                val password = view!!.password.text.toString()
                if(email != "" && password != "") {
                    mAuth
                            .createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(activity) { task ->
                                if (task.isSuccessful) {
                                    fragmentManager
                                            .beginTransaction()
                                            .replace(R.id.content_frame, IEMenuFragment.newInstance(),"iemenu")
                                            .commit()
                                } else {
                                    Log.w("Firebase", "createUserWithEmail:failure")
                                    Toast.makeText(context, "Registrierung fehlgeschlagen.",
                                            Toast.LENGTH_LONG).show()
                                }
                            }
                }
            }

            dialog.setView(view)



            val b = dialog.create()
            b.show()
        }
    }
}