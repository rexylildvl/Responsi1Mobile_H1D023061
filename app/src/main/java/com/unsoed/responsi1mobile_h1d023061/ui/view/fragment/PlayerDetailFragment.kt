package com.unsoed.responsi1mobile_h1d023061.ui.view.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.unsoed.responsi1mobile_h1d023061.R
import com.unsoed.responsi1mobile_h1d023061.data.model.Player
import com.unsoed.responsi1mobile_h1d023061.databinding.FragmentPlayerDetailBinding

class PlayerDetailFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentPlayerDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val player = arguments?.getSerializable("player") as? Player
        player?.let {
            binding.tvPlayerName.text = it.name
            binding.tvPlayerBirth.text = it.birthDate
            binding.tvPlayerCountry.text = it.country
            binding.tvPlayerPosition.text = it.position
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(player: Player): PlayerDetailFragment {
            val fragment = PlayerDetailFragment()
            val bundle = Bundle()
            bundle.putSerializable("player", player)
            fragment.arguments = bundle
            return fragment
        }
    }
}
