package com.example.issuetrackerrest.service;

import com.example.issuetrackerrest.entity.*;
import com.example.issuetrackerrest.repository.AttachmentRepository;
import com.example.issuetrackerrest.repository.IssueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService {


    @Autowired
    private AttachmentRepository mAttachmentRepository;

    @Override
    public Attachment saveAttachment(Attachment att) {
        return mAttachmentRepository.save(att);
    }

    @Override
    public Attachment findById(Long id) {
        return mAttachmentRepository.findById(id).get();
    }

    @Override
    public void deleteAttachment(Long id) {
        mAttachmentRepository.deleteById(id);
    }
}
