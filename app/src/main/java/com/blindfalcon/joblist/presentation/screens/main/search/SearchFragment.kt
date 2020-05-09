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
import com.blindfalcon.joblist.ext.hideSoftKeyboardOnFocusLostEnabled
import com.blindfalcon.joblist.presentation.screens.main.MainFlowScreenState
import com.blindfalcon.joblist.presentation.screens.main.MainFlowViewModel
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.qualifier.named

class SearchFragment(
    private val keyword: String,
    private val shouldLoad: Boolean
) : Fragment() {

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
        et_search.setText(keyword)
        et_search.hideSoftKeyboardOnFocusLostEnabled(true)
        if (shouldLoad) loadData()

        search_button.setOnClickListener {
            et_search.clearFocus()
            isNotRefresh = true
            loadData()
        }
        srl_search.setOnRefreshListener {
            et_search.clearFocus()
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
        setLoadingVisibility(true)
    }

    private fun onError() {
        rv_search.visibility = GONE
        tv_error.visibility = VISIBLE
        setLoadingVisibility(false)
    }

    private fun onLoadData(vacancyList: List<Vacancy>) {
        tv_error.visibility = GONE
        rv_search.visibility = VISIBLE
        setLoadingVisibility(false)
        vacancyAdapter.submitList(vacancyList)
    }

    private fun setLoadingVisibility(isVisible: Boolean) {
        if (isNotRefresh) {
            pb_loading.visibility = if (isVisible) VISIBLE else GONE
        } else {
            srl_search.isRefreshing = isVisible
        }
    }

    private fun onItemClick(vacancyId: Int) {
        val keyword = et_search.text?.toString()
        mainFlowViewModel.navigateToScreen(
            MainFlowScreenState.DetailsScreen(
                keyword ?: "",
                vacancyId
            )
        )
    }
}
