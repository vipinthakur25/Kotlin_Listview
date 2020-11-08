package com.example.kotlinlistview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        listView = findViewById(R.id.listView)
        var listData = arrayListOf<String>()
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData)
        listView.adapter = adapter
        button.setOnClickListener {
            var str = editText.text.toString()
            if (str.isEmpty()) {
                editText.setError("enter Item")
            } else {
                listData.add(str)
            }

            adapter.notifyDataSetChanged()

        }

        listView.setOnItemClickListener { parent, view, position, id ->
            listData.removeAt(position)
            adapter.notifyDataSetChanged()
        }
    }

}
