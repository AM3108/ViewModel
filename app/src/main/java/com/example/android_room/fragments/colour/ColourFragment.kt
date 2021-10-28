package com.example.android_room.fragments.colour

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import com.example.android_room.R
import com.example.android_room.userModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_colour.*
import kotlinx.android.synthetic.main.fragment_colour.view.*


class ColourFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_colour, container, false)
        // UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.colourbutton.setOnClickListener {
            mUserViewModel.changeBackgroundColor()
            colourFragmentLayout.setBackgroundColor(mUserViewModel.colour)
        }



        return view
    }

    //@OnLifecycleEvent(Lifecycle.Event.ON_RESUME)

    override fun onResume() {
        super.onResume()
        // Getting last updated value from viewModel
        // So that in case of configuration change,last updated value remains with user
        colourFragmentLayout.setBackgroundColor(mUserViewModel.colour)
    }



}