package com.example.android.navigation


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    //Similar to onCreate on MainActivity
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title,container,false)
        binding.playButton.setOnClickListener{
            view : View -> view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }
        setHasOptionsMenu(true)
        return binding.root     //Return inflate output
    }

    override fun onCreate() {
        super.onCreate()
        
        Timber.i("called onCreate")
    }
    
    override fun onStart() {
        super.onStart()

        Timber.i("called onStart")
    }

    override fun onRestart() {
        super.onRestart()

        Timber.i("called onRestart")
    }

    override fun onResume() {
        super.onResume()

        Timber.i("called onResume")
    }

    override fun onPause() {
        super.onPause()

        Timber.i("called onPause")
    }

    override fun onStop() {
        super.onStop()

        Timber.i("called onStop")
    }
    
    override fun onDestroy() {
        super.onDestroy()

        Timber.i("called onDestroy")
    }
    
}
