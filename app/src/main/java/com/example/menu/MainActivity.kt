package com.example.menu

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nome: String ="Ana Karen"

        //Lista de sexos
        val items = listOf("masculino","feminino")

        //acessando o spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,items)

        binding.spinnerSexo.adapter = adapter

        binding.button.setOnClickListener{
            val sexoselecionado =  binding.spinnerSexo.selectedItem as String
            val idade = binding.editTextIdade.text.toString().toLong()

            var resultado: Long
            if ( idade != null){
                if (sexoselecionado=="masculino"){
                    resultado =65-idade
                }else{
                    resultado = 62 - idade
                }
                binding.textViewResultado.text="Faltam $resultado para vocÊ se aposentar."
            }else{
                binding.textViewResultado.text="Idade deve ser preenchida."
            }
        }
    }



}