package com.example.daumpostcodeexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private var et_address: EditText? = null


    @Override
    protected fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_address = findViewById(R.id.et_address) as EditText

        val btn_search = findViewById(R.id.button) as Button

        if (btn_search != null)
            btn_search!!.setOnClickListener(object : View.OnClickListener() {
                @Override
                fun onClick(v: View) {
                    val i = Intent(this@MainActivity, WebViewActivity::class.java)
                    startActivityForResult(i, SEARCH_ADDRESS_ACTIVITY)
                }
            })

    }

    fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent) {

        super.onActivityResult(requestCode, resultCode, intent)

        when (requestCode) {

            SEARCH_ADDRESS_ACTIVITY ->

                if (resultCode == RESULT_OK) {

                    val data = intent.getExtras().getString("data")
                    if (data != null)
                        et_address!!.setText(data)

                }
        }

    }

    companion object {


        private val SEARCH_ADDRESS_ACTIVITY = 10000
    }
}
