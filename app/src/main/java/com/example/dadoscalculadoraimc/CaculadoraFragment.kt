package com.example.dadoscalculadoraimc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.textclassifier.TextClassifier.NO_OP
import com.example.dadoscalculadoraimc.databinding.FragmentCaculadoraBinding
import com.example.dadoscalculadoraimc.databinding.FragmentDadosBinding


class CaculadoraFragment : Fragment() {
    private var _binding: FragmentCaculadoraBinding? = null
    private val binding get() = _binding!!
    private var n1 = 0
    private var n2 = 0
    private var op = NO_OP
    private var SUMA = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCaculadoraBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}