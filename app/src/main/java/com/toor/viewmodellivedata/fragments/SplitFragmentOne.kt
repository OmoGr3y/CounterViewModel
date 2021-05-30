package com.toor.viewmodellivedata.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.toor.viewmodellivedata.R
import com.toor.viewmodellivedata.TotalsViewModel


class SplitFragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_split_one, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        view.findViewById<TextView>(R.id.fragment_split_one_text_view).text = getString(R.string.total, 0)
        prepareViewModel()
    }


    private fun prepareViewModel(){
        val totalsViewModel = ViewModelProvider(requireActivity()).get(TotalsViewModel::class.java)
        totalsViewModel.getTotal().observe(viewLifecycleOwner,  {
            updateText(it)
        })
        view?.findViewById<Button>(R.id.fragment_split_one_button)?.setOnClickListener {
            totalsViewModel.increaseTotal()
        }


    }

    private fun updateText(total: Int) {
        view?.findViewById<TextView>(R.id.fragment_split_one_text_view)?.text =
            getString(R.string.total, total)

    }


}