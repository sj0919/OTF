package com.example.week1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.week1.R
import com.example.week1.data.Contact
import com.example.week1.databinding.DialogContactDetailsBinding

class ContactDetailsDialogFragment : DialogFragment() {

    private var _binding: DialogContactDetailsBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_CONTACT = "contact"

        fun newInstance(contact: Contact): ContactDetailsDialogFragment {
            val fragment = ContactDetailsDialogFragment()
            val bundle = Bundle().apply {
                putParcelable(ARG_CONTACT, contact)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = DialogContactDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contact = arguments?.getParcelable<Contact>(ARG_CONTACT)

        if (contact != null) {
            binding.contactName.text=contact.name
            binding.contactImage.setImageResource(contact.image)
            if (contact.recommendedMenu.isNotEmpty()) {
                binding.recommendedMenu.text = contact.recommendedMenu.joinToString("\n") { "$it" }
            } else {
                binding.recommendedMenu.text = "No recommended menu available."
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
