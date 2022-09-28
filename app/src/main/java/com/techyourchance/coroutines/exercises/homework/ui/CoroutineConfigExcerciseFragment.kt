package com.techyourchance.coroutines.exercises.homework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.techyourchance.coroutines.R
import com.techyourchance.coroutines.common.BaseFragment
import com.techyourchance.coroutines.exercises.homework.useCase.EmulateNetworkCallUseCase
import kotlinx.coroutines.*

class CoroutineConfigExcerciseFragment : BaseFragment() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)

    private lateinit var emulateNetworkCallUseCase: EmulateNetworkCallUseCase
    private lateinit var recyclerExerciese: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        emulateNetworkCallUseCase = compositionRoot.emulateNetworkCallUseCase
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_coroutine_exercise, container, false)
        view.apply {
            recyclerExerciese = findViewById(R.id.exercise_recycler_view)
            progressBar = findViewById(R.id.progress_bar)
        }

        with(recyclerExerciese){
            layoutManager = LinearLayoutManager(context)
        }
        initValues()

        return view
    }

    private fun initValues(){
        coroutineScope.launch{
            withContext(CoroutineName("init coroutine")){
                progressBar.visibility = View.VISIBLE
                recyclerExerciese.adapter = ExerciseAdapter(getValues())
                progressBar.visibility = View.INVISIBLE
            }
        }
    }

    private suspend fun getValues(): List<String> = emulateNetworkCallUseCase.emulateNetworkCall()

    companion object {
        fun newInstance(): Fragment {
            return CoroutineConfigExcerciseFragment()
        }
    }

}