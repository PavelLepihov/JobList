package com.blindfalcon.joblist.presentation.screens.main.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import coil.api.load
import com.blindfalcon.joblist.R
import com.blindfalcon.joblist.data.repos.entity.Client
import com.blindfalcon.joblist.data.repos.entity.Vacancy
import com.blindfalcon.joblist.ext.getDate
import com.blindfalcon.joblist.ext.getMetro
import com.blindfalcon.joblist.ext.getSalary
import com.blindfalcon.joblist.ext.switchOnSetText
import com.blindfalcon.joblist.presentation.screens.main.MainFlowScreenState
import com.blindfalcon.joblist.presentation.screens.main.MainFlowViewModel
import kotlinx.android.synthetic.main.fragment_details.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.qualifier.named

class DetailsFragment(val keyword: String, val vacancyId: Int) : Fragment() {

    private val detailsViewModel: DetailsScreenViewModel by lifecycleScope.viewModel(
        this,
        named<DetailsFragment>()
    )

    private val mainFlowViewModel by lazy { requireParentFragment().getViewModel<MainFlowViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    detailsViewModel.onBackPressed()
                }
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(detailsViewModel) {
            screenState.observe(viewLifecycleOwner, Observer {
                when (it) {
                    is DetailsScreenEvent.LoadData -> setupUI(it.data)
                    is DetailsScreenEvent.Loading -> onLoading()
                    is DetailsScreenEvent.Error -> onError()
                    is DetailsScreenEvent.BackPressed -> onBack()
                }
            })
        }

        detailsViewModel.loadData(vacancyId)
        btn_refresh.setOnClickListener { detailsViewModel.loadData(vacancyId) }
    }

    private fun setupUI(vacancy: Vacancy) {
        pb_item_loading.visibility = GONE
        cl_data_container.visibility = VISIBLE
        with(vacancy) {
            tv_vacancy_date.text = getDate()
            tv_vacancy_position.text = profession
            getMetro()?.let {
                iv_vacancy_metro.visibility = VISIBLE
                tv_vacancy_metro.switchOnSetText(it)
            }
            tv_vacancy_salary.text = getSalary(requireContext())
            setupCompany(client)
            setupDuties(duties)
            setupRequirements(requirements)
            setupConditions(conditions)
        }
    }

    private fun onLoading() {
        cl_error_container.visibility = GONE
        pb_item_loading.visibility = VISIBLE
    }

    private fun onError() {
        pb_item_loading.visibility = GONE
        cl_data_container.visibility = GONE
        cl_error_container.visibility = VISIBLE
    }

    private fun onBack() {
        mainFlowViewModel.navigateToScreen(MainFlowScreenState.SearchScreen(keyword, true))
    }

    private fun setupCompany(client: Client?) {
        client?.let {
            it.clientTitle?.let { title ->
                first_divider.visibility = VISIBLE
                tv_vacancy_company.switchOnSetText(title)
                iv_vacancy_company.visibility = VISIBLE
                setupClientLogo(it.logo)
            }
        }
    }

    private fun setupClientLogo(logo: String?) {
        logo?.let {
            iv_vacancy_company.visibility = GONE
            iv_company_logo.visibility = VISIBLE
            iv_company_logo.load(it)
        }
    }

    private fun setupDuties(duties: String?) {
        duties?.let {
            tv_vacancy_duties_title.visibility = VISIBLE
            tv_vacancy_duties_details.switchOnSetText(it)
        }
    }

    private fun setupRequirements(requirements: String?) {
        requirements?.let {
            tv_vacancy_requirements_title.visibility = VISIBLE
            tv_vacancy_requirements_details.switchOnSetText(it)
        }
    }

    private fun setupConditions(conditions: String?) {
        conditions?.let {
            tv_vacancy_conditions_title.visibility = VISIBLE
            tv_vacancy_conditions_details.switchOnSetText(it)
        }
    }

}
