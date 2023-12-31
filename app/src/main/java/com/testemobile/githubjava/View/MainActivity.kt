package com.testemobile.githubjava

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.testemobile.githubjava.View.ListFragment


class MainActivity : AppCompatActivity() {

  private lateinit var  btnAnterior: Button
  private lateinit var  btnProximo: Button
  private lateinit var txtNumPage : TextView
  private lateinit var txtNum : TextView
  private var page : Int =1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAnterior = findViewById(R.id.btnAnterior)
        btnProximo =  findViewById(R.id.btnProximo)

        txtNumPage = findViewById((R.id.txtNumPage))
        txtNum =  findViewById((R.id.txtPage))

    }

    override fun onResume() {
        super.onResume()

        txtNum.text=page.toString()
        chargeRepoList(page.toString())

        btnProximo.setOnClickListener {
            page++
            txtNum.text=page.toString()
            chargeRepoList(page.toString())
        }

        btnAnterior.setOnClickListener {
            page--
            if(isMinimumPage(page)) {
                txtNum.text = page.toString()
            }else{
                txtNum.text = page.toString()
                chargeRepoList(page.toString())
            }
        }

    }

   private fun isMinimumPage(page: Int): Boolean{

        if(page<1){
            this.page =1
            return true
        }

        return false
    }

  private fun chargeRepoList(page: String){

            val fragment = ListFragment()
            val args = Bundle()
            args.putString("page",page)
            fragment.arguments = args
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
    }
}