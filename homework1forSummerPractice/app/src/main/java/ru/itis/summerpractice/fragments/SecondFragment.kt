package ru.itis.summerpractice.fragments

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.summerpractice.R

class SecondFragment : Fragment() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var continueButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.second_fragment, container, false)

        emailEditText = view.findViewById(R.id.emailET)
        passwordEditText = view.findViewById(R.id.passwordET)
        continueButton = view.findViewById(R.id.continueButton)

        emailEditText.addTextChangedListener { checkFields() }
        passwordEditText.addTextChangedListener { checkFields() }

        continueButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            val bundle = Bundle().apply {
                putString("email", email)
                putString("password", password)
            }
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
        }

        return view
    }

    private fun checkFields() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        continueButton.isEnabled = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8 &&
                password.any { it.isDigit() } &&
                password.any { it.isLowerCase() } &&
                password.any { it.isUpperCase() }
    }
}