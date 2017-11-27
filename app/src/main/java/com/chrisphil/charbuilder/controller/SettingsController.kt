package com.chrisphil.charbuilder.controller

import android.os.Bundle
import android.support.v7.preference.PreferenceFragmentCompat
import com.chrisphil.charbuilder.R

/**
 * Created by Phil on 24.11.2017.
 */
class SettingsController : PreferenceFragmentCompat(){
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences,rootKey)
    }

    companion object {
        fun newInstance(): SettingsController {
            return SettingsController()
        }
    }

}