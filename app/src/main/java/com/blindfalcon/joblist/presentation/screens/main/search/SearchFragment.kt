package com.blindfalcon.joblist.presentation.screens.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blindfalcon.joblist.R
import com.blindfalcon.joblist.data.repos.entity.Vacancy
import com.blindfalcon.joblist.presentation.screens.main.MainFlowScreenState
import com.blindfalcon.joblist.presentation.screens.main.MainFlowViewModel
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.qualifier.named

class SearchFragment : Fragment() {

    private val searchViewModel: SearchScreenViewModel by lifecycleScope.viewModel(
        this,
        named<SearchFragment>()
    )

    private val mainFlowViewModel by lazy { requireParentFragment().getViewModel<MainFlowViewModel>() }

    private lateinit var vacancyAdapter: VacancyListAdapter

    private var isNotRefresh: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vacancyAdapter = VacancyListAdapter(requireContext(), searchViewModel::onVacancyClick)

        with(rv_search) {
            adapter = vacancyAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        with(searchViewModel) {
            screenState.observe(viewLifecycleOwner, Observer {
                when (it) {
                    is SearchScreenEvent.Loading -> onLoading()
                    is SearchScreenEvent.Error -> onError()
                    is SearchScreenEvent.VacancyClicked -> onItemClick(it.vacancyId)
                    is SearchScreenEvent.LoadData -> onLoadData(it.data)
                }
            })
        }

        search_button.setOnClickListener {
            isNotRefresh = true
            loadData()
        }
        srl_search.setOnRefreshListener {
            isNotRefresh = false
            loadData()
        }
    }

    private fun loadData() {
        et_search.text?.let {
            searchViewModel.loadData(it.toString())
        }
    }

    private fun onLoading() {
        tv_error.visibility = GONE
        if (isNotRefresh) {
            pb_loading.visibility = VISIBLE
        } else {
            srl_search.isRefreshing = true
        }
    }

    private fun onError() {
        rv_search.visibility = GONE
        tv_error.visibility = VISIBLE
        if (isNotRefresh) {
            pb_loading.visibility = GONE
        } else {
            srl_search.isRefreshing = false
        }
    }

    private fun onLoadData(vacancyList: List<Vacancy>) {
        tv_error.visibility = GONE
        rv_search.visibility = VISIBLE
        if (isNotRefresh) {
            pb_loading.visibility = GONE
        } else {
            srl_search.isRefreshing = false
        }
        vacancyAdapter.submitList(vacancyList)
    }

    private fun onItemClick(vacancyId: Int) {
        mainFlowViewModel.navigateToScreen(MainFlowScreenState.DetailsScreen(vacancyId))
    }
}
