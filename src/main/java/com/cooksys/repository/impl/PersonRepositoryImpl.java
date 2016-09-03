//package com.cooksys.repository.impl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.cooksys.entity.AppPerson;
//import com.cooksys.model.GetAllPeopleResponse;
//import com.cooksys.repository.PersonRepository;
//
//@Repository
//public class PersonRepositoryImpl implements PersonRepository {
//
//	@Autowired
//	EntityManager em;
//	
//    @Override
//    public AppPerson get(long id) {
//        return em.createQuery("select user from AppUser user where user.id = :id", AppPerson.class)
//                .setParameter("id", id)
//                .getSingleResult();
//    }
//
//    @Override
//    public List<GetAllPeopleResponse> getAll() {
//        return em.createQuery("select new com.cooksys.model.GetAllPeopleResponse(person.id, person.name) from AppPerson person", GetAllPeopleResponse.class).getResultList();
//    }
//
//}
