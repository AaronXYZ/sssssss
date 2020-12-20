package com.example.tabledemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recycler_view.adapter = MyAdapter()
    }

    class MyAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val resourceId = if (viewType == 2) R.layout.item_table_row else R.layout.item_table_header
            val view: View =
                LayoutInflater.from(parent.context).inflate(resourceId, parent, false)
            return if (viewType == 2) MyViewHolder(view) else HeaderViewHolder(view)
        }

        override fun getItemCount(): Int {
            return 20
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        }

        override fun getItemViewType(position: Int): Int {
            if (position == 0){
                return 1
            }
            return 2
        }

    }

    class MyViewHolder(private val view:View): RecyclerView.ViewHolder(view) {

    }

    class HeaderViewHolder(private val view:View): RecyclerView.ViewHolder(view){
        private val tvShopName = view.findViewById<TextView>(R.id.tv_shop_name)
        private val ivShopName = view.findViewById<ImageView>(R.id.iv_shop_name)
        private val tvAgentName = view.findViewById<TextView>(R.id.tv_agent_name)
        private val ivAgentName = view.findViewById<ImageView>(R.id.iv_agent_name)

        init {
            tvShopName.setOnClickListener {
                showShopNameList()
            }
            ivShopName.setOnClickListener {
                showShopNameList()
            }
        }

        private fun showShopNameList(){
            val popupWindow = ExampleCardPopup(view.context)
            popupWindow.showOnAnchor(tvShopName, RelativePopupWindow.VerticalPosition.BELOW, RelativePopupWindow.HorizontalPosition.CENTER)
        }
    }
}