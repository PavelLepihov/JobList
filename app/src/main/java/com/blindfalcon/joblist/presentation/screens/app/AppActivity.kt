package com.blindfalcon.joblist.presentation.screens.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.blindfalcon.joblist.R
import com.blindfalcon.joblist.ext.replaceFragment
import com.blindfalcon.joblist.presentation.screens.main.MainFlowFragment
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class AppActivity : AppCompatActivity() {

    val viewModel: AppActivityViewModel by lifecycleScope.viewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        onChangeState(this)
        viewModel.navigateToScreen(AppActivityViewModel.AppScreens.MAIN_FLOW_SCREEN)
    }

    private fun onChangeState(activity: AppCompatActivity) {
        with(viewModel) {
            screenState.observe(activity, Observer {
                when (it) {
                    is AppActivityScreenState.MainFlowScreen ->
                        replaceFragment(MainFlowFragment(), R.id.main_flow_container)
                }
            })
        }
    }
}
