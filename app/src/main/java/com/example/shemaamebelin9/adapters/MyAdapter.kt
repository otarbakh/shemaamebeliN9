package com.example.shemaamebelin9.adapters



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shemaamebelin9.databinding.SingleNumLayoutBinding
import com.example.shemaamebelin9.models.Password
class MyAdapter : ListAdapter<Password, MyAdapter.ConstructorsViewHolder>(
    TeamsDiffCallBack()
) {

    private lateinit var itemClickListener: (Password, Int) -> Unit

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ConstructorsViewHolder {
        val binding =
            SingleNumLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConstructorsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConstructorsViewHolder, position: Int) {
        holder.bindData()
    }


    inner class ConstructorsViewHolder(private val binding: SingleNumLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var model: Password? = null
        fun bindData() {
            model = getItem(adapterPosition)
            binding.apply {
                tvNum.text = model?.num
            }

            binding.tvNum.setOnClickListener {
                itemClickListener.invoke(model!!, adapterPosition)
            }

        }

    }

    fun setOnItemClickListener(clickListener: (Password, Int) -> Unit) {
        itemClickListener = clickListener
    }
}



class TeamsDiffCallBack : DiffUtil.ItemCallback<Password>() {
    override fun areItemsTheSame(
        oldItem: Password,
        newItem: Password
    ): Boolean {
        return oldItem.num == newItem.num
    }

    override fun areContentsTheSame(
        oldItem: Password,
        newItem: Password
    ): Boolean {
        return oldItem == newItem
    }
}