package com.willshuffyproject.githubusers_bfaasubmission2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.iv_back
import kotlinx.android.synthetic.main.activity_main.iv_menu
import kotlinx.android.synthetic.main.exit_dialog.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load animation

        val apps_logo = AnimationUtils.loadAnimation(this, R.anim.alpha_with_scale)
        val text_logo = AnimationUtils.loadAnimation(this, R.anim.alpha_with_scale)


        //run animation

        iv_logo.startAnimation(apps_logo)
        tv_logo.startAnimation(text_logo)

        iv_back.setOnClickListener{
            finish()
        }

        iv_menu.setOnClickListener {
            showPopUp(iv_menu)
        }
    }

    private fun showPopUp(view: View){

        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.main_menu)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId){

                R.id.action_exit -> {
                    val view = LayoutInflater.from(this).inflate(R.layout.exit_dialog, null)
                    val alert = AlertDialog.Builder(this, R.style.CustomAlertDialog)
                        .setView(view)
                        .setCancelable(false)

                    val mAlertDialog = alert.show()
                    mAlertDialog?.window?.setLayout(700, 500)

                    view.btn_iya.setOnClickListener{
                        finishAffinity()
                    }
                    view.btn_tidak.setOnClickListener {
                        mAlertDialog.dismiss()
                    }
                }
            }
            true
        })
        popup.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
