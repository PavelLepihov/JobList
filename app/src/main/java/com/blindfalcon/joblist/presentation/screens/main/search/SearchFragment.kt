package com.blindfalcon.joblist.presentation.screens.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.blindfalcon.joblist.R
import com.blindfalcon.joblist.presentation.screens.main.MainFlowViewModel
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.compat.SharedViewModelCompat.sharedViewModel
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.qualifier.named

class SearchFragment : Fragment() {

    private val searchViewModel: SearchScreenViewModel by lifecycleScope.viewModel(
        this,
        named<SearchFragment>()
    )

    private val mainFlowViewModel: MainFlowViewModel by sharedViewModel(
        this,
        MainFlowViewModel::class.java
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
