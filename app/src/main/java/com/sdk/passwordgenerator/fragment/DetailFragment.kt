package com.sdk.passwordgenerator.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sdk.passwordgenerator.R
import com.sdk.passwordgenerator.activity.MainActivity
import com.sdk.passwordgenerator.database.Entity
import com.sdk.passwordgenerator.databinding.FragmentDetailBinding
import com.sdk.passwordgenerator.util.toBitmap

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private var entity: Entity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        entity = arguments?.getParcelable("entity")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root!!
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        entity?.let {
            binding.imageView.setImageBitmap(it.image.toBitmap())
            binding.textView.text = "${it.lastName} ${it.name} ${it.middleName}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}