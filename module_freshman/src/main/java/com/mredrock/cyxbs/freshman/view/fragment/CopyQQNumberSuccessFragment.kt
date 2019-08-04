package com.mredrock.cyxbs.freshman.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.view.widget.SuccessView

/**
 * Create by yuanbing
 * on 2019/8/4
 */
class CopyQQNumberSuccessFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.freshman_fragment_copy_qq_number_copy_success, container,
                false)
        val successView: SuccessView = view.findViewById(R.id.success_view_copy_qq_number_success)
        successView.setOnAnimationFinish { activity?.finish() }
        return view
    }
}