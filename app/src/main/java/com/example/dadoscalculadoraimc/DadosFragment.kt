package com.example.dadoscalculadoraimc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dadoscalculadoraimc.databinding.FragmentDadosBinding
import kotlin.contracts.contract
import kotlin.random.Random


class DadosFragment : Fragment() {
    private var _binding:FragmentDadosBinding? = null
    private val binding get() = _binding!!
    private val dados =  arrayOf(
        R.drawable.dice1, //entero
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDadosBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView.setOnClickListener {
            val num = Random.nextInt(1,7)
            val num2 = Random.nextInt(1,7)
            binding.imageView.setImageResource(dados[num-1])
            binding.imageView2.setImageResource(dados[num2-1])
            binding.tvResultado.text = (num+num2).toString()
        }

        binding.imageView2.setOnClickListener {
            val num = Random.nextInt(1,7)
            val num2 = Random.nextInt(1,7)
            binding.imageView.setImageResource(dados[num-1])
            binding.imageView2.setImageResource(dados[num2-1])
            binding.tvResultado.text = (num+num2).toString()
        }

    }

}


