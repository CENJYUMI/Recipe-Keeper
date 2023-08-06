package com.example.recipekeeper

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recipekeeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Button click listeners
        binding.btnAddRecipe.setOnClickListener {
            val recipeName = binding.edtRecipeName.text.toString()
            binding.txtRecipeArea.append("$recipeName\n\n")

        }

        binding.btnAddIngredients.setOnClickListener {
            val ingredients = binding.edtIngredients2.text.toString()
            binding.txtRecipeArea.append("$ingredients\n")

        }

        binding.btnAddInstruction.setOnClickListener {
            val instructions = binding.edtInstruction.text.toString()
            binding.txtRecipeArea.append("$instructions\n")

        }

        binding.btnSaveRecipe.setOnClickListener {
            val recipeName = binding.edtRecipeName.text.toString()
            val ingredients = binding.edtIngredients2.text.toString()
            val instructions = binding.edtInstruction.text.toString()

            if (recipeName.isNotEmpty() && ingredients.isNotEmpty() && instructions.isNotEmpty()) {
                Toast.makeText(this, "Recipe Saved", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(
                    this,
                    "Please complete all Required Information",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

        binding.btnClear.setOnClickListener {
            binding.edtRecipeName.text.clear()
            binding.edtIngredients2.text.clear()
            binding.edtInstruction.text.clear()
            binding.txtRecipeArea.text = ""
        }
    }
}
