package com.blindfalcon.joblist.presentation.screens.main.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.blindfalcon.joblist.R
import com.blindfalcon.joblist.data.repos.entity.Vacancy
import com.blindfalcon.joblist.ext.getDate
import com.blindfalcon.joblist.ext.getMetro
import com.blindfalcon.joblist.ext.getSalary

class VacancyListAdapter(
    private val context: Context,
    private val onVacancyItemClickListener: (vacancyId: Int) -> Unit
) : ListAdapter<Vacancy, RecyclerView.ViewHolder>(VacancyDiffer()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.vacancy_list_item, parent, false)
        return VacancyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as VacancyViewHolder).bind(
            context,
            getItem(position),
            onVacancyItemClickListener
        )
    }
}

class VacancyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val cvItemRoot: ConstraintLayout = itemView.findViewById(R.id.cl_item_root)
    private val tvPosition: TextView = itemView.findViewById(R.id.tv_position)
    private val ivCompany: ImageView = itemView.findViewById(R.id.iv_company)
    private val tvCompany: TextView = itemView.findViewById(R.id.tv_company)
    private val ivMetro: ImageView = itemView.findViewById(R.id.iv_metro)
    private val tvMetro: TextView = itemView.findViewById(R.id.tv_metro)
    private val tvSalary: TextView = itemView.findViewById(R.id.tv_salary)
    private val tvDate: TextView = itemView.findViewById(R.id.tv_date)
    private val ivIcon: ImageView = itemView.findViewById(R.id.iv_image)
    fun bind(
        context: Context,
        item: Vacancy,
        onVacancyItemClickListener: (vacancyId: Int) -> Unit
    ) {
        tvPosition.text = item.profession
        item.client?.clientTitle?.let {
            tvCompany.text = it
            tvCompany.visibility = VISIBLE
            ivCompany.visibility = VISIBLE
        }
        item.getMetro()?.let {
            tvMetro.text = it
            tvMetro.visibility = VISIBLE
            ivMetro.visibility = VISIBLE
        }
        tvSalary.text = item.getSalary(context)
        tvDate.text = item.getDate()
        ivIcon.load(item.client?.logo)
        cvItemRoot.setOnClickListener { onVacancyItemClickListener(item.id) }
    }
}

class VacancyDiffer : DiffUtil.ItemCallback<Vacancy>() {
    override fun areItemsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean =
        oldItem == newItem
}