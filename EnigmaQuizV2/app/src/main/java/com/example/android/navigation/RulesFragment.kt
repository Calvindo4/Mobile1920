/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.navigation.MyApplication
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentRulesBinding
import timber.log.Timber

class RulesFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Timber.d(MyApplication.ON_ATTACH_CALLED)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onDestroy(savedInstanceState)

        Timber.d(MyApplication.ON_CREATE_CALLED)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rules, container, false)
    }

    override fun onStart() {
        super.onStart()

        Timber.d(MyApplication.ON_START_CALLED)
    }

    override fun onPause() {
        super.onPause()

        Timber.d(MyApplication.ON_PAUSE_CALLED)
    }

    override fun onStop() {
        super.onStop()

        Timber.d(MyApplication.ON_STOP_CALLED)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Timber.d(MyApplication.ON_DESTROY_VIEW__CALLED)
    }

    override fun onDetach() {
        super.onDetach()

        Timber.d(MyApplication.ON_DETACH_CALLED)
    }
}
