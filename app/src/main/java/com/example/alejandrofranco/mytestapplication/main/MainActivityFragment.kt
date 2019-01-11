package com.example.alejandrofranco.mytestapplication.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alejandrofranco.mytestapplication.R
import com.example.alejandrofranco.mytestapplication.model.YouTubeResponse
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.inject

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment(), MainPresenter.View {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private lateinit var adapter : MainAdapter
    private val presenter: MainPresenter by inject()


    companion object {
        fun newInstance() = MainActivityFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.view = this
        init()
    }

    fun init () {
        adapter = MainAdapter(emptyList())
        recycler.adapter = adapter
        compositeDisposable.add(
            presenter.getDefault()
        )
    }

    fun search(query : String) {
        compositeDisposable.add(
            presenter.searchVideo(query)
        )
    }

    override fun updateData(media: List<YouTubeResponse.Items>) {
        adapter.data = media
    }
}
