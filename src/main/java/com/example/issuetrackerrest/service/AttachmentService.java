package com.example.issuetrackerrest.service;

import com.example.issuetrackerrest.entity.Attachment;

public interface AttachmentService {

    Attachment saveAttachment(Attachment att);

    Attachment findById(Long id);

    void deleteAttachment(Long id);
}
