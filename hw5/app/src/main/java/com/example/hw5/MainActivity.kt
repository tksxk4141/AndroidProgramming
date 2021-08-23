package com.example.hw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.hw5.databinding.ActivityMainBinding
import com.example.hw5.databinding.HomeFragmentBinding
import com.example.hw5.databinding.Nav1FragmentBinding
import com.example.hw5.databinding.Nav2FragmentBinding

class MyViewModel() : ViewModel() {
    val testLiveData = MutableLiveData<Int>()
    init{
        testLiveData.value=0
    }

    fun increase(){
        testLiveData.value=(testLiveData.value ?:0) + 1
    }
}

class HomeFragment : Fragment(R.layout.home_fragment) {
    private val viewModel: MyViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = HomeFragmentBinding.bind(view)
        viewModel.testLiveData.observe(viewLifecycleOwner, Observer {
            binding.textView.text = "$it"
        })
        binding.button.setOnClickListener{
            viewModel.increase()
            findNavController().navigate(R.id.action_homeFragment_to_nav1Fragment)
        }
    }
}

class Nav1Fragment : Fragment(R.layout.nav1_fragment) {
    private val viewModel: MyViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = Nav1FragmentBinding.bind(view)
        viewModel.testLiveData.observe(viewLifecycleOwner, Observer {
            binding.textView2.text = "$it"
        })
        binding.button2.setOnClickListener{
            viewModel.increase()
            findNavController().navigate(R.id.action_nav1Fragment_to_nav2Fragment)
        }
    }
}

class Nav2Fragment : Fragment(R.layout.nav2_fragment) {
    private val viewModel: MyViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = Nav2FragmentBinding.bind(view)
        viewModel.testLiveData.observe(viewLifecycleOwner, Observer {
            binding.textView6.text = "$it"
        })
        binding.button3.setOnClickListener{
            viewModel.increase()
            findNavController().navigate(R.id.action_nav2Fragment_to_homeFragment)
        }
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
