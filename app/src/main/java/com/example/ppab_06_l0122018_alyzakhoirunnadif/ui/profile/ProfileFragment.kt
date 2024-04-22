package com.example.ppab_06_l0122018_alyzakhoirunnadif.ui.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.ppab_06_l0122018_alyzakhoirunnadif.R
import com.example.ppab_06_l0122018_alyzakhoirunnadif.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnGithub = root.findViewById<Button>(R.id.btn_go_to_web)
        btnGithub.setOnClickListener {
            val webpage = Uri.parse("https://enka.network/hsr/804321508/")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }

//        val textView: TextView = binding.textNotifications
//        notificationsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        return root
    }

    private fun openWebPage(url: String) {
        try {
            val webpage = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        } catch (e: Exception) {
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
