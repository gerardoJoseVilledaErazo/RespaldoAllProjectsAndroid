package com.example.recyclerviewcrud

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewcrud.Adapter.MyAdapter
import com.example.recyclerviewcrud.Interface.ItemClickListener
import com.example.recyclerviewcrud.Model.UserData
import java.util.regex.Pattern


class MainActivity : AppCompatActivity()/*, View.OnClickListener*/  {
    private lateinit var userData: UserData

    private lateinit var et_name: EditText
    private lateinit var et_email:EditText
    lateinit var et_update_name:EditText
    lateinit var et_update_email:EditText
    lateinit var add: Button
    lateinit var btn_update:Button
    lateinit var btn_cancel:Button
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    var list: MutableList<UserData> = ArrayList()

    lateinit var builder: AlertDialog.Builder

    lateinit var dialog: AlertDialog

    lateinit var name: String
    lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);

        add = findViewById(R.id.btn_add);

        configRecyclerView()

        add.setOnClickListener(){
            name = et_name!!.text.toString()
            email = et_email!!.text.toString()

            userData = UserData(name = name, email = email)

            list.add(userData)
            myAdapter!!.notifyDataSetChanged()
            Toast.makeText(this.applicationContext, "User Add Success...", Toast.LENGTH_SHORT).show()

            et_name!!.setText("")
            et_email!!.setText("")
        }
        myAdapter.setOnItemClickListener(object : ItemClickListener {
            override fun OnItemClick(position: Int, userData: UserData?) {
                builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("Update User Info");
                builder.setCancelable(false);
                val view = LayoutInflater.from(this@MainActivity).inflate(R.layout.dialog_update,null,false);
                InitUpdateDialog(position,view);
                builder.setView(view);
                dialog = builder.create();
                dialog.show();
            }
        })
    }


    private fun InitUpdateDialog(position:Int, view: View) {
        et_update_name = view.findViewById(R.id.et_update_name);
        et_update_email = view.findViewById(R.id.et_update_email);
        btn_update = view.findViewById(R.id.btn_update_user);
        btn_cancel = view.findViewById(R.id.btn_update_cancel);

        et_update_name.setText(name)
        et_update_email.setText(email)

        btn_update.setOnClickListener(){
            name = et_update_name!!.text.toString()
            email = et_update_email!!.text.toString()

            userData = UserData(name = name, email = email)

            myAdapter?.UpdateData(position,userData);
            Toast.makeText(this.applicationContext,"User Updated..",Toast.LENGTH_SHORT).show();

        }

        btn_cancel.setOnClickListener(){
            dialog.dismiss();
        }

    }


    // Metodo que permite configurar el RecyclerView
    private fun configRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = manager

        //instanciando adaptador
        myAdapter = MyAdapter(list,this)

        //asignando adaptador a recyclerView
        recyclerView.adapter = myAdapter
        recyclerView.addItemDecoration(decoration)
    }

//    override fun onClick(p0: View?) {
//        when(p0!!.id){
//            R.id.btn_add->{
//                name = et_name!!.text.toString()
//                email = et_email!!.text.toString()
//
//                userData = UserData(name = name, email = email)
//
//                list.add(userData)
//                adapter!!.notifyDataSetChanged()
//                Toast.makeText(this@MainActivity, "User Add Success...", Toast.LENGTH_SHORT).show()
//
//                et_name!!.setText("")
//                et_email!!.setText("")
//            }
//        }
//    }

    private fun verifyTextPersonName(editText: EditText): Boolean {
        if (editText.text.toString().isEmpty()){
            editText.error = "Required field"
            editText.requestFocus()
            return false
        } else if (!verifyChars(editText)) {
            editText.error = "Just letters are allowed"
            editText.requestFocus()
            return false
        }
        return true

    }

    fun verifyChars(editText: EditText): Boolean
    {
        //Validamos solo caracteres Expresion regular
//        Pattern.compile("^[a-zA-Z ]+$").matcher(editText.text.toString()).matches()

        return Pattern.compile("^[a-zA-Z ]+$").matcher(editText.text.toString()).matches()
    }
    fun verifyEmpty(editText: EditText): Boolean
    {
        if (editText.text.toString().isEmpty()){
            editText.error = "Required field"
            editText.requestFocus()
            return false
        }
        return true
    }
}