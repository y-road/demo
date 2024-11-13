package com.song.app.demointro2.screen.main.trade

import androidx.fragment.app.viewModels
import com.song.app.demointro2.databinding.FragmentTradeBinding
import com.song.app.demointro2.screen.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TradeFragment: BaseFragment<TradeViewModel, FragmentTradeBinding>() {

    override val viewModel by viewModels<TradeViewModel> ()

    override fun getViewBinding() = FragmentTradeBinding.inflate(layoutInflater)

    override fun observeData() {
    }

    companion object {

        const val TAG = "TradeFragment"

        fun newInstance() = TradeFragment()

    }

}
