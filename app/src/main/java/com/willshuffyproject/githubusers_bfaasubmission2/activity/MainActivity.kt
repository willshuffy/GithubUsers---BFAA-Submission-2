package com.willshuffyproject.githubusers_bfaasubmission2.activity

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.view.animation.AnimationUtils
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.willshuffyproject.githubusers_bfaasubmission2.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.iv_back
import kotlinx.android.synthetic.main.activity_main.iv_menu
import kotlinx.android.synthetic.main.exit_dialog.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initStatusBar()
        initTransition()
        initListener()

    }

    private fun initListener(){

        iv_menu.setOnClickListener {
            showPopUp(iv_menu)
        }

    }

    private fun initTransition(){
        //load animation

        val apps_logo = AnimationUtils.loadAnimation(this,
            R.anim.alpha_with_scale
        )
        val text_logo = AnimationUtils.loadAnimation(this,
            R.anim.alpha_with_scale
        )


        //run animation

        iv_logo.startAnimation(apps_logo)
        tv_logo.startAnimation(text_logo)

        iv_back.setOnClickListener{
            finish()
        }

    }

    private fun showPopUp(view: View){

        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.main_menu)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId){

                R.id.action_exit -> {
                    val view = LayoutInflater.from(this).inflate(R.layout.exit_dialog, null)
                    val alert = AlertDialog.Builder(this,
                        R.style.CustomAlertDialog
                    )
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

    private fun initStatusBar(){

        //statusbar transparant

        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

    // fungsi untuk keluar aplikasi

    private var mExitTime = 0L
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 500) {
                Toast.makeText(this, "Click twice to exit app", Toast.LENGTH_SHORT).show()
                mExitTime = System.currentTimeMillis()
            } else {
                finishAffinity()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}
