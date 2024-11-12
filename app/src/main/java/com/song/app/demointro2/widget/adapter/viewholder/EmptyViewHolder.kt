package com.song.app.demointro2.widget.adapter.viewholder

import com.song.app.demointro2.databinding.ViewholderEmptyBinding
import com.song.app.demointro2.model.Model
import com.song.app.demointro2.screen.base.BaseViewModel
import com.song.app.demointro2.util.provider.ResourcesProvider
import com.song.app.demointro2.widget.adapter.listener.AdapterListener

class EmptyViewHolder(
    private val binding: ViewholderEmptyBinding,
    viewModel: BaseViewModel,
    resourcesProvider: ResourcesProvider
): ModelViewHolder<Model>(binding, viewModel, resourcesProvider) {

    override fun reset() = Unit

    override fun bindViews(model: Model, adapterListener: AdapterListener) = Unit
}