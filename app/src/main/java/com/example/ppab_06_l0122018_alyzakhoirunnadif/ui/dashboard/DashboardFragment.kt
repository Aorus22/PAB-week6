package com.example.ppab_06_l0122018_alyzakhoirunnadif.ui.dashboard

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ppab_06_l0122018.Items
import com.example.ppab_06_l0122018_alyzakhoirunnadif.ListAdapter
import com.example.ppab_06_l0122018_alyzakhoirunnadif.R
import com.example.ppab_06_l0122018_alyzakhoirunnadif.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var rvChars: RecyclerView
    private val list = ArrayList<Items>()
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

//        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvChars = root.findViewById(R.id.rv_chars)
        rvChars.setHasFixedSize(true)

        list.addAll(getListChars())
        showRecyclerList()

        return root
    }

    private fun showRecyclerList() {
        rvChars.layoutManager = LinearLayoutManager(context)
        val listAdapter = ListAdapter(list)
        rvChars.adapter = listAdapter
    }

    private fun getListChars() : ArrayList<Items> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataImg = resources.obtainTypedArray(R.array.data_img)
        val listHero = ArrayList<Items>()
        for (i in dataName.indices) {
            val hero = Items(dataName[i], dataDesc[i], dataImg.getResourceId(i, -1))
            listHero.add(hero)
        }
        dataImg.recycle()
        return listHero
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
