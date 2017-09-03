package com.github.takahirom.constraint_layout_samples

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.takahirom.constraint_layout_samples.databinding.ItemRowBinding
import com.github.takahirom.constraint_layout_samples.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))

            adapter = Adapter(listOf(
                    Item("Bias", BiasActivity::class.java),
                    Item("Chain", ChainActivity::class.java),
                    Item("Barrier", BarrierActivity::class.java),
                    Item("Group", GroupActivity::class.java),
                    Item("PlaceHolder", PlaceHolderActivity::class.java),
                    Item("PercentDimension", PercentDimensionActivity::class.java),
                    Item("Google I/O", MainActivity::class.java)
            ))
        }

    }

    data class Item(val name: String, val activityClass: Class<*>)

    class Adapter(val items: List<Item>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
            parent!!
            val itemRowDataBinding = DataBindingUtil.inflate<ItemRowBinding>(LayoutInflater.from(parent.context), R.layout.item_row, parent, false)
            return ViewHolder(itemRowDataBinding.root)
        }

        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            holder ?: return
            val itemView = holder.itemView
            val itemRowBinding: ItemRowBinding = DataBindingUtil.bind<ItemRowBinding>(itemView)
            val item = items[position]
            itemRowBinding.textView.text = item.name
            itemRowBinding.root.setOnClickListener {
                val context = itemRowBinding.root.context
                context.startActivity(Intent(context, item.activityClass))
            }
        }

        override fun getItemCount(): Int = items.size


        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        }
    }
}
