package com.videochat.architecture.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import androidx.viewbinding.ViewBinding
import com.videochat.architecture.presentation.viewmodel.BaseViewModel
import com.videochat.architecture.ui.binder.ViewStateBinder
import com.videochat.architecture.ui.binder.ViewsProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseFragment<VIEW_STATE : Any,VIEWS_PROVIDER : ViewsProvider,BINDING : ViewBinding> :
    Fragment,
    ViewsProvider {
    constructor() : super()
    constructor(@LayoutRes layoutResourceId: Int) : super(layoutResourceId)

/*    open val navController: NavController
        get() = findNavController()*/

    abstract val viewModel: BaseViewModel<VIEW_STATE>

    abstract val viewStateBinder: ViewStateBinder<VIEW_STATE, VIEWS_PROVIDER>

    private var _binding: BINDING? = null
    protected val binding: BINDING
        get() = _binding!!

    private var uiStateJob: Job? = null
    private var destinationJob: Job? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = initializeBinding(inflater, container)
        Log.d("BASE FRAGMENT", binding.toString())
        val view = binding.root

        view.bindViews()
        observeViewModel()
        return view
    }

    abstract fun initializeBinding(inflater: LayoutInflater, container: ViewGroup?): BINDING

    abstract fun View.bindViews()

    abstract fun setupViews()

    private fun observeViewModel() {
        uiStateJob = performOnStartedLifecycleEvent {
            viewModel.uiState.collectLatest { viewState ->
                applyViewState(viewState)
            }
        }
    }

    private fun performOnStartedLifecycleEvent(block: suspend CoroutineScope.() -> Unit): Job? {
        return lifecycleScope.launch {
            viewLifecycleOwner.whenStarted(block)
        }
    }

    fun applyViewState(viewState: VIEW_STATE) {
        with(viewStateBinder) {
            bind(viewState)
        }
    }
    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun setupBackAction(action:()-> Unit){
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                action()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this,callback)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        uiStateJob?.cancel()
        destinationJob?.cancel()
        _binding = null
    }
}
