package com.example.sqldb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var Name:EditText
    lateinit var Email:EditText
    lateinit var ID:EditText
    lateinit var Save_btn:Button
    lateinit var View_btn:Button
    lateinit var Del_btn:Button

    lateinit var db:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Name = findViewById(R.id.Name_plate)
        Email = findViewById(R.id.Email_field)
        ID = findViewById(R.id.ID_no)
        Save_btn = findViewById(R.id.save_btn)
        View_btn = findViewById(R.id.view_btn)
        Del_btn = findViewById(R.id.del_btn)

    //creating database
        db = openOrCreateDatabase("Android_DB", Context.MODE_PRIVATE, null)

        //creating a table
        db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, mail VARCHAR, id VARCHAR)")

        Save_btn.setOnClickListener {
            var name_edt = Name.text.toString().trim()
            var mail_edt = Email.text.toString().trim()
            var id_edt = ID.text.toString().trim()


            //Validating edit texts
            if (name_edt.isEmpty() || mail_edt.isEmpty() || id_edt.isEmpty()){
                Toast.makeText(this, "Cannot submit an empty field", Toast.LENGTH_SHORT).show()


            }
            // inset data
            else{
                db.execSQL("INSERT INTO users VALUES( '\"+name_edt+','\"+mail_edt+','\"+id_edt+')")
                Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()

            }

        }

    }
}