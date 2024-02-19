package com.aytachuseynli.instagramclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.aytachuseynli.instagramclone.databinding.ActivityFeedBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class FeedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.insta_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_post -> {
                val intent = Intent(this, UploadActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.signout -> {
                auth.signOut()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}