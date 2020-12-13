package com.hannah.demo.ui.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hannah.demo.databinding.FragmentMineBinding

class MineFragment : Fragment() {

    private val mineViewModel by viewModels<MineViewModel>()

    private lateinit var fragmentMineBinding: FragmentMineBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        fragmentMineBinding = FragmentMineBinding.inflate(layoutInflater, container, false).apply {
            viewmodel = mineViewModel
        }
        return fragmentMineBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        mineViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
    }


}