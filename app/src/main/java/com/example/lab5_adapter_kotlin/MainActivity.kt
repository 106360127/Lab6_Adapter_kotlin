package com.example.lab5_adapter_kotlin

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
     class Data {
        var photo: Int = 0
        var name: String? = null
    }
     inner class MyAdapter(private val data: Array<MainActivity.Data?>, private val veiw: Int) :
        BaseAdapter() {
        override fun getCount(): Int {
            return data.size
        }
        override fun getItem(position: Int): Data? {
            return data[position]
        }
        override fun getItemId(position: Int): Long {
            return 0
        }

         override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
             val x = layoutInflater.inflate(veiw,parent,false)
             val name = x.findViewById(R.id.name)as TextView
             name.text= data[position]?.name
             val imageView = x.findViewById(R.id.imageView) as ImageView
             imageView.setImageResource(data[position]?.photo!!)
             return x
         }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transNameArray = arrayListOf("腳踏車","機車","汽車","巴士")
        val transPhotoArray = intArrayOf(R.drawable.trans1, R.drawable.trans2, R.drawable.trans3, R.drawable.trans4,R.drawable.trans5,R.drawable.trans6)
        val transData = arrayOfNulls<Data>(transNameArray.size)
        for (i in transData.indices) {
            transData[i] = Data()
            transData[i]?.name = transNameArray[i]
            transData[i]?.photo = transPhotoArray[i]
        }
        val transAdapter = MyAdapter(transData, R.layout.trans_list)
        spinner.adapter= transAdapter

        val messageArray = arrayListOf("訊息1","訊息2","訊息3","訊息4","訊息5","訊息6")
        val messageAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,messageArray)

        listView.adapter = messageAdapter

        val cubeeNameArray = arrayListOf("哭哭","發抖","再見","生氣","昏倒","竊笑","很棒","你好","驚嚇","大笑")
        val cubeePhotoIdArray = intArrayOf(R.drawable.cubee1,R.drawable.cubee2,R.drawable.cubee3,R.drawable.cubee4,
            R.drawable.cubee5,R.drawable.cubee6,R.drawable.cubee7,R.drawable.cubee8,R.drawable.cubee9,R.drawable.cubee10)
        val cubeeData = arrayOfNulls<Data>(cubeeNameArray.size)
        for (i in cubeeData.indices) {
            cubeeData[i] = Data()
            cubeeData[i]?.name = cubeeNameArray[i]
            cubeeData[i]?.photo  = cubeePhotoIdArray[i]
        }
        val cubeeAdapter = MyAdapter(cubeeData, R.layout.cubee_list)

        gridView.adapter = cubeeAdapter
        gridView.numColumns = 3

    }
}
