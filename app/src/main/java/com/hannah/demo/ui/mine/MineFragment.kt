package com.hannah.demo.ui.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.hannah.demo.R
import com.hannah.demo.databinding.FragmentMineBinding
import com.hannah.demo.entity.EventObserver

class MineFragment : Fragment() {

    private val mineViewModel by viewModels<MineViewModel>()
    private val args: MineFragmentArgs by navArgs()
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
        mineViewModel.openLoginRegister.observe(viewLifecycleOwner, EventObserver {
            navigateToLoginRegister()
        })
        mineViewModel.openCommonQuestion.observe(viewLifecycleOwner, EventObserver {
            navigateToCommonQuestionPage()
        })
        mineViewModel.openFeedback.observe(viewLifecycleOwner, EventObserver {
            navigateToFeedback()
        })
        mineViewModel.openSetting.observe(viewLifecycleOwner, EventObserver {
            navigateToSetting()
        })
        args.user.apply {
            mineViewModel.updateUser(args.user)
            mineViewModel.avatarUrl.observe(viewLifecycleOwner, Observer {
                updateAvatar(it)
            })
        }
    }

    private fun navigateToSetting() {
        val action = MineFragmentDirections.actionMineFragmentToSettingFragment()
        findNavController().navigate(action)
    }

    private fun navigateToFeedback() {
        val action = MineFragmentDirections.actionMineFragmentToFeedbackFragment()
        findNavController().navigate(action)
    }

    private fun navigateToLoginRegister() {
        val action = MineFragmentDirections.actionMineFragmentToLoginFragment()
        findNavController().navigate(action)
    }

    private fun navigateToCommonQuestionPage() {
        val action = MineFragmentDirections.actionMineFragmentToCommonQuestionFragment()
        findNavController().navigate(action)
    }

    private fun updateAvatar(imageUrl: String) {
        Glide
            .with(this)
            .load(imageUrl)
            .circleCrop()
            .placeholder(R.mipmap.ic_launcher_round)
            .into(fragmentMineBinding.imgAvatar)
    }

}