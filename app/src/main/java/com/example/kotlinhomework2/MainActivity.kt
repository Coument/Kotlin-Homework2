package com.example.kotlinhomework2

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setTitle("請選擇功能")
            alert.setMessage("請根據下方按鈕選擇要顯示的物件")
            alert.setNeutralButton(
                "取消"
            ) { dialogInterface, i ->
                Toast.makeText(
                    this@MainActivity,
                    "dialog關閉",
                    Toast.LENGTH_SHORT
                ).show()
            }
            alert.setNegativeButton(
                "Toast"
            ) { dialogInterface, i -> showToast() }
            alert.setPositiveButton(
                "List"
            ) { dialogInterface, i -> showList_dialog() }
            alert.show()
        }
    }

    private fun showToast() {
        val toast = Toast(this@MainActivity)
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.duration = Toast.LENGTH_SHORT
        val inflater = layoutInflater
        val layout: View =
            inflater.inflate(R.layout.toast, findViewById<View>(R.id.toast_) as ViewGroup)
        toast.setView(layout)
        toast.show()
    }

    private fun showList_dialog() {
        val list = arrayOf("message1", "message2", "message3", "message4", "message5")
        val dialog_list = AlertDialog.Builder(this@MainActivity)
        dialog_list.setTitle("使用LIST呈現")
        dialog_list.setItems(
            list
        ) { dialogInterface, i ->
            Toast.makeText(
                this@MainActivity,
                "你選的是" + list[i],
                Toast.LENGTH_SHORT
            ).show()
        }
        dialog_list.show()
    }
}