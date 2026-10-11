package cn.edu.sicnu.cs.lrj.second

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cn.edu.sicnu.cs.lrj.second.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.project_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSelect.adapter = adapter

        binding.button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val newTv = TextView(this@MainActivity)
                newTv.text = getString(R.string.btn_add_text)
                newTv.textSize = 22f
                binding.LinearLayout.addView(newTv)
                binding.scrollView.fullScroll(android.widget.ScrollView.FOCUS_DOWN)
            }
        })
        binding.btnQuery.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val selectedText = binding.spinnerSelect.selectedItem.toString()
                val keyGame = getString(R.string.key_game)
                val keyWeb = getString(R.string.key_web)
                val keyMobile = getString(R.string.key_mobile)
                val strResId = Program().getAdvice(selectedText, keyGame, keyWeb, keyMobile)
                binding.tvResult.text = getString(strResId)
            }
        })
    }
}
