package com.hannah.demo.ui.mine.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hannah.demo.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private val settingViewModel by viewModels<SettingViewModel>()
    private lateinit var fragmentSettingBinding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSettingBinding =
            FragmentSettingBinding.inflate(layoutInflater, container, false).apply {
                viewmodel = settingViewModel
            }
        return fragmentSettingBinding.root
    }
}