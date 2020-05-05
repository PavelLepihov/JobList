package com.blindfalcon.joblist.presentation.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.blindfalcon.joblist.R
import com.blindfalcon.joblist.ext.replaceChildFragment
import com.blindfalcon.joblist.presentation.screens.main.details.DetailsFragment
import com.blindfalcon.joblist.presentation.screens.main.search.SearchFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFlowFragment : Fragment() {

    private val viewModel: MainFlowViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main_flow, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.screenState.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is MainFlowScreenState.SearchScreen -> replaceFragment(SearchFragment())
                is MainFlowScreenState.DetailsScreen -> replaceFragment(DetailsFragment())
            }
        })
        viewModel.navigateToScreen(MainFlowScreenState.SearchScreen)
    }

    private fun replaceFragment(fragment: Fragment) {
        replaceChildFragment(fragment, R.id.screen_fragment_container)
    }
}