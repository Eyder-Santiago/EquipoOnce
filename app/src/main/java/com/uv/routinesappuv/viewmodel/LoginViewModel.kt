package com.uv.routinesappuv.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.uv.routinesappuv.repository.RutinasRepository
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    val context = getApplication<Application>()
    private val repository = RutinasRepository(context)

    //registerUser se comunica con el repository
    fun registerUser(email: String, pass: String, isRegister: (Boolean) -> Unit) {
        Log.e("testregistro", "$email------$pass")
        repository.registerUser(email, pass) { response ->
            Log.e("testregistro", "$response")
            isRegister(response)
        }
    }

    fun loginUser(email: String, pass: String, isLogin: (Boolean) -> Unit) {
        repository.loginUser(email, pass) { response ->
            isLogin(response)
        }
    }

    fun sesion(email: String?, isEnableView: (Boolean) -> Unit) {
        if (email != null) {
            isEnableView(true)
        } else {
            isEnableView(false)
        }
    }
}