package unpas.ac.mydb

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import unpas.ac.mydb.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //fungsi load session shared preferences
        if (loadSessionLogin()){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
            finish()
        }
        //fungsi click button login
        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        var username:String  = binding.usernameInput.text.toString()
        var password:String  = binding.passwordInput.text.toString()

        //SharedPreference
        val sharedPreference : SharedPreferences = getSharedPreferences("Login",Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor = sharedPreference.edit()
        editor.apply{
            putString("getUsername",username)
            putString("getPassword",password)
        }.apply()
        val intent = Intent(this ,MainActivity::class.java)
        startActivity(intent)
    }
    //fungsi check data session
    private fun loadSessionLogin():Boolean{
        val getSharedPreferences:SharedPreferences= getSharedPreferences("Login",Context.MODE_PRIVATE)
        val savedDataUsername:String ?= getSharedPreferences.getString("getUsername",null)
        val savedDataPassword:String ?= getSharedPreferences.getString("getPassword",null)
        return savedDataPassword!=null && savedDataUsername!=null
    }
}