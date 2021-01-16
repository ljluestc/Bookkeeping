package com.hannah.demo.ui.mine.feedback

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.hannah.demo.databinding.FragmentFeedbackBinding

/**
 * AUTHOR: hannah
 * DATE: 07/01/21
 */
class FeedbackFragment : Fragment() {

    private val feedbackViewModel by viewModels<FeedbackViewModel>()
    private lateinit var fragmentFeedbackBinding: FragmentFeedbackBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFeedbackBinding =
            FragmentFeedbackBinding.inflate(inflater, container, false).apply {
                viewmodel = feedbackViewModel
            }
        return fragmentFeedbackBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        feedbackViewModel.submitStatus.observe(viewLifecycleOwner, Observer { isSubmitSuccess ->
            if (isSubmitSuccess) {
                Toast.makeText(
                    requireContext(),
                    "Your feedback submitted successfully!",
                    Toast.LENGTH_SHORT
                ).show()
                Navigation.findNavController(fragmentFeedbackBinding.root).navigateUp()
            }
        })
    }

}