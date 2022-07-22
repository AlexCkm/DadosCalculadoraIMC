package com.example.dadoscalculadoraimc

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import com.example.dadoscalculadoraimc.databinding.FragmentCaculadoraBinding
import com.example.dadoscalculadoraimc.databinding.FragmentIMCBinding
import com.google.android.material.snackbar.Snackbar


class IMCFragment : Fragment() {
    private var _binding: FragmentIMCBinding? = null
    private val binding get() = _binding!!
    private var height = 150
    private var weight = 75
    private var doubleheight = 2.25
    private var IMC = 33.33


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIMCBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.sbAltura.setOnSeekBarChangeListener(object:
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?,
                                           progress: Int,
                                           fromUser: Boolean) {
                binding.tvAltura2.text = seekbar?.progress.toString().plus("/200")
                height = progress
            }


            override fun onStartTrackingTouch(seek: SeekBar?) {
            }

            override fun onStopTrackingTouch(seek: SeekBar?) {
                resultado()
            }
        })
        binding.sbPeso.setOnSeekBarChangeListener(object:
            SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekbar: SeekBar?,
                                           progress: Int,
                                           fromUser: Boolean) {
                binding.tvPeso2.text = seekbar?.progress.toString().plus("/150")
                weight = progress
            }
            override fun onStartTrackingTouch(seek: SeekBar?) {

            }

            override fun onStopTrackingTouch(seek: SeekBar?) {
                resultado()
            }
        })

    }

    fun resultado(){
        doubleheight = height.times(height)/10000.0
        IMC = Math.round((weight/doubleheight)
            .times(100))
            .div(100.0)
        binding.tvResultado.text = IMC.toString()
        calcObesidad()
    }

    fun calcObesidad () {
        var colorSnackbar = when (IMC){
            in 0.0..15.99 -> ContextCompat.getColor(requireContext(), R.color.Lila)
            in 16.0..16.99 -> ContextCompat.getColor(requireContext(), R.color.AzulOscuro)
            in 17.0..18.49 -> ContextCompat.getColor(requireContext(), R.color.AzulClaro)
            in 18.5..24.99 -> ContextCompat.getColor(requireContext(), R.color.VerdeOscuro)
            in 25.0..29.99 -> ContextCompat.getColor(requireContext(), R.color.VerdeClaro)
            in 30.0..34.99 -> ContextCompat.getColor(requireContext(), R.color.naranja)
            in 35.0..39.99 -> ContextCompat.getColor(requireContext(), R.color.naranjaOscuro)
            else -> ContextCompat.getColor(requireContext(), R.color.Rojo)
        }
        val obesidad = when (IMC){
            in 0.0..15.99 -> "DELGADEZ SEVERA"
            in 16.0..16.99 -> "DELGADEZ MODERADA"
            in 17.0..18.49 -> "DELGADEZ LEVE"
            in 18.5..24.99 -> "NORMAL"
            in 25.0..29.99 -> "PREOBESIDAD"
            in 30.0..34.99 -> "OBESIDAD LEVE"
            in 35.0..39.99 -> "OBESIDAD MEDIA"
            else -> "OBESIDAD MÓRBIDA"
        }
        val sb = Snackbar.make(binding.root, obesidad, Snackbar.LENGTH_LONG)
        sb.setTextColor(Color.WHITE)
        sb.setBackgroundTint(colorSnackbar)
        sb.setActionTextColor(Color.DKGRAY)
        sb.setAction("Ver Tabla"){
            showTable()
        }
        sb.show()
    }
    fun showTable(){
        val dialog = zzzz()
        dialog.show(requireActivity().supportFragmentManager, "TablaPeso")
    }
}

