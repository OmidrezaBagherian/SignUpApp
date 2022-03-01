package ir.omidrezabagherian.quiz3app

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ir.omidrezabagherian.quiz3app.databinding.FragmentProfileBinding
import ir.omidrezabagherian.testapplicationfive.Data.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    lateinit var profileBinding: FragmentProfileBinding
    lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileBinding = FragmentProfileBinding.bind(view)

        val navHostFragment =
            activity!!.supportFragmentManager.findFragmentById(R.id.fragmentContainerViewMain) as NavHostFragment

        navController = navHostFragment.navController

        val listHobbies = mutableListOf<String>()

        profileBinding.checkboxCoding.setOnClickListener { check ->
            if (check.isClickable) {
                listHobbies.add("Coding")
            } else {
                listHobbies.remove("Coding")
            }
        }
        profileBinding.checkboxFootbal.setOnClickListener { check ->
            if (check.isClickable) {
                listHobbies.add("Footbal")
            } else {
                listHobbies.remove("Footbal")
            }
        }
        profileBinding.checkboxSwimming.setOnClickListener { check ->
            if (check.isClickable) {
                listHobbies.add("Swimming")
            } else {
                listHobbies.remove("Swimming")
            }
        }
        profileBinding.checkboxCoding.setOnClickListener { check ->
            if (check.isClickable) {
                listHobbies.add("Coding")
            } else {
                listHobbies.remove("Coding")
            }
        }
        profileBinding.checkboxMovie.setOnClickListener { check ->
            if (check.isClickable) {
                listHobbies.add("Movie")
            } else {
                listHobbies.remove("Movie")
            }
        }
        profileBinding.checkboxFencing.setOnClickListener { check ->
            if (check.isClickable) {
                listHobbies.add("Fencing")
            } else {
                listHobbies.remove("Fencing")
            }
        }
        profileBinding.checkboxDigitalGames.setOnClickListener { check ->
            if (check.isClickable) {
                listHobbies.add("Digital games")
            } else {
                listHobbies.remove("Digital games")
            }
        }
        profileBinding.checkboxCooking.setOnClickListener { check ->
            if (check.isClickable) {
                listHobbies.add("Cooking")
            } else {
                listHobbies.remove("Cooking")
            }
        }
        profileBinding.checkboxPuzzles.setOnClickListener { check ->
            if (check.isClickable) {
                listHobbies.add("Puzzles")
            } else {
                listHobbies.remove("Puzzles")
            }
        }
        profileBinding.checkboxFishind.setOnClickListener { check ->
            if (check.isClickable) {
                listHobbies.add("Fishind")
            } else {
                listHobbies.remove("Fishind")
            }
        }
        profileBinding.checkboxHiking.setOnClickListener { check ->
            if (check.isClickable) {
                listHobbies.add("Hiking")
            } else {
                listHobbies.remove("Hiking")
            }
        }
        profileBinding.checkboxDrawing.setOnClickListener { check ->
            if (check.isClickable) {
                listHobbies.add("Drawing")
            } else {
                listHobbies.remove("Drawing")
            }
        }

        profileBinding.buttonSend.setOnClickListener {
            val name = profileBinding.edittextName.text.toString()
            val family = profileBinding.edittextFamily.text.toString()
            val nationalCode = profileBinding.edittextNationalCode.text.toString()

            NetworkManager.userService.createUser(
                CreateUser(
                    name,
                    family,
                    nationalCode,
                    listHobbies
                )
            )
                .enqueue(object : Callback<String> {
                    override fun onResponse(call: Call<String>, response: Response<String>) {
                        Toast.makeText(requireContext(), "موفقیت آمیز", Toast.LENGTH_SHORT).show()
                        val action =
                            ProfileFragmentDirections.actionProfileFragmentToUploadImageFragment(
                                response.body().toString()
                            )
                        navController.navigate(action)
                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {
                        Log.i("Error", t.toString())
                        Toast.makeText(requireContext(), "نا موفقیت", Toast.LENGTH_SHORT).show()
                    }
                })
        }


    }

}