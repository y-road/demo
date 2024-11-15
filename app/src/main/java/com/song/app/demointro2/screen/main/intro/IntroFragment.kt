package com.song.app.demointro2.screen.main.intro

import android.annotation.SuppressLint
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.song.app.demointro2.data.entity.intro.IntroEntity
import com.song.app.demointro2.databinding.FragmentIntroBinding
import com.song.app.demointro2.screen.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroFragment: BaseFragment<IntroViewModel, FragmentIntroBinding>() {

    override val viewModel by viewModels<IntroViewModel>()

    override fun getViewBinding() = FragmentIntroBinding.inflate(layoutInflater)

    override fun initViews() {
        initTextView()
    }

    override fun observeData() = viewModel.introStateLiveData.observe(requireActivity()) {
        when (it) {
            is IntroState.Uninitialized -> {

            }
            is IntroState.Loading -> {
                handleLoading()
            }
            is IntroState.Success -> {
                handleSuccess(it)
            }
            is IntroState.Failed -> {

            }
        }
    }

    private fun initTextView() = with(binding) {
        tv1Content.text = "-"
        tv2Content.text = "-"
        tv3Content.text = "-"
        tv4Content.text = "-"
        tv5Content.text = "-"
        tv6Content.text = "-"
        tv7Content.text = "-"
        tv8Content.text = "-"
        tv9Content.text = "-"
        tv10Content.text = "-"
    }


    private fun handleLoading() = with(binding) {
        progressBar.isVisible = true
    }

    @SuppressLint("SetTextI18n")
    private fun handleSuccess(state: IntroState.Success) = with(binding) {
        progressBar.isGone = true

        val introEntity = state.introEntity
        tv2Content.text = "${introEntity.estimatedFundingRate}%"
        tv3Content.text = introEntity.remainTime
        tv4Content.text = "${introEntity.fundingRate}%"
        tv7Content.text = "${introEntity.transactionAmount} USDT"
        tv8Content.text = "${introEntity.transactionVolume} Cont"
    }

    companion object {

        const val TAG = "IntroFragment"

        fun newInstance() = IntroFragment()

    }

}
