package com.song.app.demointro2.screen.main.intro

import androidx.fragment.app.viewModels
import com.song.app.demointro2.databinding.FragmentIntroBinding
import com.song.app.demointro2.screen.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroFragment: BaseFragment<IntroViewModel, FragmentIntroBinding>() {

    override val viewModel by viewModels<IntroViewModel>()
    override fun getViewBinding() = FragmentIntroBinding.inflate(layoutInflater)

    override fun observeData() {
    }

    companion object {

        const val TAG = "IntroFragment"

        fun newInstance() = IntroFragment()

    }

}
