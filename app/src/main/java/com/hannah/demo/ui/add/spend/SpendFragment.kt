package com.hannah.demo.ui.add.spend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hannah.demo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpendFragment : Fragment() {

//    private lateinit var spendViewModel: SpendViewModel

    private val spendViewModel by viewModels<SpendViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        spendViewModel = ViewModelProvider(this).get(SpendViewModel::class.java).apply {
//            setIndex(1)
//        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_tab, container, false)
        val textView: TextView = root.findViewById(R.id.section_label)
        spendViewModel.text.observe(viewLifecycleOwner, Observer<String> {
            textView.text = it
        })
        return root
    }

}