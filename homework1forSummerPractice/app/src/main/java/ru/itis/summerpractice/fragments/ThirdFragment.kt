package ru.itis.summerpractice.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.itis.summerpractice.R

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = requireArguments()
        val email = args.getString("email")!!
        val password = args.getString("password")!!

        val emailText = view.findViewById<TextView>(R.id.email_tv)
        val passwordText = view.findViewById<TextView>(R.id.password_tv)

        emailText.text = "Email: $email"
        passwordText.text = "Password: $password"
    }
}