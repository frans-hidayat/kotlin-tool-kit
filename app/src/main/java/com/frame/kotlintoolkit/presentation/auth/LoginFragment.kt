package com.frame.kotlintoolkit.presentation.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.frame.kotlintoolkit.R
import com.frame.kotlintoolkit.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login), View.OnClickListener {
    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(loginViewModel) {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        binding.buttonLogin.setOnClickListener(this)
        binding.buttonRegister.setOnClickListener(this)
//        val user = FirebaseAuth.getInstance().currentUser
//
//        val db = FirebaseFirestore.getInstance()
//        val docRef = db.collection("users")
//        docRef.get().addOnSuccessListener { documentSnapshot ->
//            documentSnapshot.forEach {
//                Log.d("User", it.toObject(UserEntity::class.java).toString())
//            }
//        }
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.buttonLogin -> doLogin()
            R.id.buttonRegister -> doRegister()
        }
    }

    private fun doRegister() {

    }

    private fun doLogin() {

    }
}