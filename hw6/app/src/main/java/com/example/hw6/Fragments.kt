package com.example.hw6

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.hw6.databinding.FragmentLayoutBinding

class MyDialogFragment : Fragment(){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentLayoutBinding.bind(view)
        binding.textView2.text="DialFragment"
    }
}

class HomeFragment: Fragment(R.layout.fragment_layout){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentLayoutBinding.bind(view)
        binding.textView2.text="HomeFragment"
    }
}

class Page1Fragment: Fragment(R.layout.fragment_layout){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentLayoutBinding.bind(view)
        binding.textView2.text="Page1Fragment"
    }
}

class Page2Fragment: Fragment(R.layout.fragment_layout){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentLayoutBinding.bind(view)
        binding.textView2.text="Page2Fragment"
    }
}