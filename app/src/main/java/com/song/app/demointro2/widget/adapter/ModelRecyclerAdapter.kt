package com.song.app.demointro2.widget.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.song.app.demointro2.model.CellType
import com.song.app.demointro2.model.Model
import com.song.app.demointro2.screen.base.BaseViewModel
import com.song.app.demointro2.util.mapper.ModelViewHolderMapper
import com.song.app.demointro2.util.provider.ResourcesProvider
import com.song.app.demointro2.widget.adapter.listener.AdapterListener
import com.song.app.demointro2.widget.adapter.viewholder.ModelViewHolder

class ModelRecyclerAdapter<M: Model, VM: BaseViewModel>(
    private var modelList: List<Model>,
    private var viewModel: VM,
    private val resourcesProvider: ResourcesProvider,
    private val adapterListener: AdapterListener
): ListAdapter<Model, ModelViewHolder<M>>(Model.DIFF_CALLBACK) {

    override fun getItemCount(): Int = modelList.size

    override fun getItemViewType(position: Int): Int = modelList[position].type.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder<M> {
        return ModelViewHolderMapper.map(parent, CellType.entries[viewType], viewModel, resourcesProvider)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: ModelViewHolder<M>, position: Int) {
        with(holder) {
            bindData(modelList[position] as M)
            bindViews(modelList[position] as M, adapterListener)
        }
    }

    override fun submitList(list: MutableList<Model>?) {
        list?.let { modelList = it }
        super.submitList(list)
    }


}
