package com.udemy.ltp.spring_boot_camp.contacts.service;

import java.util.List;
import java.util.stream.IntStream;

import com.udemy.ltp.spring_boot_camp.contacts.pojo.Contact;
import com.udemy.ltp.spring_boot_camp.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImplementation implements ContactService {
	@Autowired
	private ContactRepository contactRepository;

	private int findIndexById(String id) {
		return IntStream.range(0, contactRepository.getContacts().size())
										.filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
										.findFirst()
										.orElseThrow();
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.getContacts();
	}

	@Override
	public Contact getContactById(String id) {
		return contactRepository.getContact(findIndexById(id));
	}

	@Override
	public void saveContact(Contact contact) {
		contactRepository.saveContact(contact);
	}

	@Override
	public void updateContact(String id, Contact contact) {
		contactRepository.updateContact(findIndexById(id), contact);
	}

	@Override
	public void deleteContact(String id) {
		contactRepository.deleteContact(findIndexById(id));
	}

	@Override
	public void deleteAllContacts() {
		contactRepository.deleteContacts();
	}
}
