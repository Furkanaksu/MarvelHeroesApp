package com.furkan.marvel.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.furkan.marvel.R
import com.furkan.marvel.adapters.ItemListAdapter
import com.furkan.marvel.viewmodels.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharactersFragment : Fragment() {


    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val page = inflater.inflate(R.layout.fragment_characters, container, false)

        val recycView = page.findViewById<RecyclerView>(R.id.recycView)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)



        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getData()
        }

        viewModel.users.observe(activity!!, Observer { userList ->
            Log.w("denemeee3", "${userList}")

            for (i in userList?.data?.results!!.indices) {

                recycView.layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false
                )

                val adapter = ItemListAdapter(userList.data)

                recycView.adapter = adapter
            }
        })
        return page
    }

}