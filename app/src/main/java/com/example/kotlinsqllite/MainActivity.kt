package com.example.kotlinsqllite

import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlinsqllite.db.MyDbManager

class MainActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
        val dataList = MyDbManager.readDbData()
        for (item in dataList){
            tvTest.append(item)
            tvTest.append("\n")
        }
    }

    fun onClickSave(view: View) {
        tvTest.text = ""
        myDbManager.insertToDb(edTitle.text.toString() , edContext.text.toString())
        val dataList = MyDbManager.readDbData()
        for (item in dataList){
            tvTest.append(item)
            tvTest.append("\n")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDB()
    }
}