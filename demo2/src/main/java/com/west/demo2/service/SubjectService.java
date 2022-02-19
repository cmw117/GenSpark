package com.west.demo2.service;

import com.west.demo2.bean.Subject;
import com.west.demo2.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    public SubjectRepository subjectRepo;

    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        subjectRepo.findAll().forEach(subjects::add);
        return subjects;
    }


    public void addSubject(Subject subject) {

        subjectRepo.save(subject);
    }

    public void updateSubject(Long id, Subject subject) {
        subjectRepo.save(subject);
    }

    public void deleteSubject(Long id) {

        subjectRepo.deleteById(id);
    }
}
