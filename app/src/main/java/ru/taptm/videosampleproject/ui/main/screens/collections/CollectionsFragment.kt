package ru.taptm.videosampleproject.ui.main.screens.collections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.taptm.videosampleproject.R
import ru.taptm.videosampleproject.ui.main.common.extensions.gone
import ru.taptm.videosampleproject.ui.main.common.extensions.itemPadding
import ru.taptm.videosampleproject.ui.main.common.extensions.visible
import ru.taptm.videosampleproject.ui.main.models.RowCollection
import ru.taptm.videosampleproject.ui.main.repository.network.commons.Resource
import ru.taptm.videosampleproject.ui.main.repository.network.commons.Status
import ru.taptm.videosampleproject.ui.main.screens.collections.adapters.RowCollectionAdapter

class CollectionsFragment : Fragment() {
    private val collectionsViewModel: CollectionsViewModel by viewModel()

    private val observer = Observer<Resource<List<RowCollection>>> {
        when (it.status) {
            Status.SUCCESS -> updateCollectionList(it.data)
            Status.ERROR -> showError(it.message)
            Status.LOADING -> showLoading()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupScreen()
        initData()
    }

    private fun setupScreen() {
        rv_collections.itemPadding(bottom = PADDING_COLLECTION, top = 0)
        refresh.setOnRefreshListener {
            collectionsViewModel.getFilms()
        }
    }

    private fun initData() {
        collectionsViewModel.collections.observe(this, observer)
        collectionsViewModel.getFilms()
    }

    private fun updateCollectionList(data: List<RowCollection>?) {
        refresh.isRefreshing = false
        if (!data.isNullOrEmpty()) {
            frame_no_loaded_collections.gone()
            rv_collections.adapter = RowCollectionAdapter(data)
        } else {
            frame_no_loaded_collections.visible()
        }
    }

    private fun showError(message: String?) {
        refresh.isRefreshing = false
        frame_no_loaded_collections.visible()
        Toast.makeText(requireContext(), "Error: $message", Toast.LENGTH_SHORT).show()
    }

    private fun showLoading() {
        frame_no_loaded_collections.gone()
        refresh.post {
            refresh.isRefreshing = true
        }
    }

    companion object {
        private const val PADDING_COLLECTION = 32

        fun newInstance(): CollectionsFragment {
            return CollectionsFragment()
        }
    }
}