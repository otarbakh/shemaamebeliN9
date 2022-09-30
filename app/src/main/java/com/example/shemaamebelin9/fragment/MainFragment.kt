package com.example.shemaamebelin9.fragment

import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shemaamebelin9.adapters.MyAdapter
import com.example.shemaamebelin9.models.Password
import com.example.shemaamebelin9.BaseFragment
import com.example.shemaamebelin9.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val myAdapter: MyAdapter by lazy { MyAdapter() }


    private val itemsList = mutableListOf<Password>()
    private val inputList = mutableListOf<String>()
    private val ourPass = "0934"


    override fun viewCreated() {

        setupRecycler()
        populateList()

    }

    override fun listeners() {
        inputNumber()
    }

    private fun inputNumber() {
        myAdapter.apply {
            setOnItemClickListener { num, _ ->

                val filteredNum = num.toString().filter { it.isDigit() }
                inputList.add(filteredNum)



                Log.d("bestboxer", inputList.toString())

                if (inputList.size == 4) {
                    val listAsString =
                        "${inputList[0]}${inputList[1]}${inputList[2]}${inputList[3]}"
                    Log.d("bestboxer", "$listAsString ggg")
                    if (listAsString == ourPass) {
                        Toast.makeText(requireContext(), "sucsess", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }


    private fun setupRecycler() {
        binding.rvMyrv.apply {
            adapter = myAdapter
            layoutManager =
                GridLayoutManager(
                    requireContext(), 3, GridLayoutManager.VERTICAL, false
                )
        }
        myAdapter.submitList(itemsList)
    }



    private fun populateList() {
        itemsList.add(
            Password(
                "1",
            )
        )
        itemsList.add(
            Password(
                "2",
            )
        )
        itemsList.add(
            Password(
                "3",
            )
        )
        itemsList.add(
            Password(
                "4",
            )
        )
        itemsList.add(
            Password(
                "5",
            )
        )
        itemsList.add(
            Password(
                "6",
            )
        )
        itemsList.add(
            Password(
                "7",
            )
        )
        itemsList.add(
            Password(
                "8",
            )
        )
        itemsList.add(
            Password(
                "9",
            )
        )
        itemsList.add(
            Password(
                "0",
            )
        )
    }
}
