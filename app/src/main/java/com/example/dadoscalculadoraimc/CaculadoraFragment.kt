package com.example.dadoscalculadoraimc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.textclassifier.TextClassifier.NO_OP
import android.widget.Button
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

        binding.buttonClear.setOnClickListener {
            binding.tvResultado.text = "0"
            n1 = 0
            n2 = 0

        }
        //Estas son las operaciones
        binding.opSum.setOnClickListener {
            n1 = binding.tvResultado.text.toString().toInt()
            op = SUMA
            binding.tvResultado.text = "0"
        }
        binding.opRest.setOnClickListener {
            n1 = binding.tvResultado.text.toString().toInt()
            op = RESTA
            binding.tvResultado.text = "0"
        }
        binding.opMult.setOnClickListener {
            n1 = binding.tvResultado.text.toString().toInt()
            op = MULTIPLICACION
            binding.tvResultado.text = "0"
        }
        binding.opDiv.setOnClickListener {
            n1 = binding.tvResultado.text.toString().toInt()
            op = DIVISION
            binding.tvResultado.text = "0"
        }
        //Esta es la operacion final
        binding.opResultado.setOnClickListener {
            n2 = binding.tvResultado.text.toString().toInt()
            val result = when (op) {
                SUMA -> n1 + n2
                RESTA -> n1 - n2
                MULTIPLICACION -> n1 * n2
                DIVISION -> n1 / n2
                else -> 0
            }
            n1 = 0
            n2 = 0
            op = NO_OP
            binding.tvResultado.text = result.toString()
        }
        binding.button0.setOnClickListener {
            pressNum("0")
        }
        binding.button1.setOnClickListener {
            pressNum("1")
        }
        binding.button2.setOnClickListener {
            pressNum("2")
        }
        binding.button3.setOnClickListener {
            pressNum("3")
        }
        binding.button4.setOnClickListener {
            pressNum("4")
        }
        binding.button5.setOnClickListener {
            pressNum("5")
        }
        binding.button6.setOnClickListener {
            pressNum("6")
        }
        binding.button7.setOnClickListener {
            pressNum("7")
        }
        binding.button8.setOnClickListener {
            pressNum("8")
        }
        binding.button9.setOnClickListener {
            pressNum("9")
        }
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OP = 0
    }

    fun pressNum(n: String) {
        if (binding.tvResultado.text.length < 9)
            binding.tvResultado.text = binding.tvResultado.text.toString().plus(n).toInt().toString()
    }

}

