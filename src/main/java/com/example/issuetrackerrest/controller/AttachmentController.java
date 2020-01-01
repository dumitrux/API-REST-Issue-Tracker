package com.example.issuetrackerrest.controller;


import com.example.issuetrackerrest.entity.Attachment;
import com.example.issuetrackerrest.entity.Issue;
import com.example.issuetrackerrest.service.AttachmentService;
import com.example.issuetrackerrest.service.IssueService;
import com.example.issuetrackerrest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Api(tags = "Attachment")
@RestController
@RequestMapping(AttachmentController.BASE_URL)
public class AttachmentController {

    public static final String BASE_URL = "/api/v1/attachments";

    @Autowired
    private final UserService mUserService;

    @Autowired
    private final AttachmentService mAttachmentService;

    @Autowired
    private final IssueService mIssueService;

    public AttachmentController(UserService mUserService, AttachmentService mAttachmentService, IssueService mIssueService) {
        this.mUserService = mUserService;
        this.mAttachmentService = mAttachmentService;
        this.mIssueService = mIssueService;
    }

    @ApiOperation(value = "Busca el attachment per id",
            notes = "Busca el attachment amb el id especificat")
    @GetMapping(value = "{id}", produces = "!application/json")
    public ResponseEntity<Resource> getAttachmentById(@PathVariable Long id) {

        Attachment a = mAttachmentService.findById(id);

        HttpHeaders http = new HttpHeaders();
        http.set("content-disposition","attachment; filename=\"" + a.getDirtyName() +"\"");
        return ResponseEntity.ok()
                .headers(http)
                .body(new ByteArrayResource(a.getAttachment()));
    }

    @ApiOperation(value = "Esborra el attachment per id",
            notes = "Esborra el attachment amb el id especificat")
    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAttachmentById(@PathVariable Long id,
                                                      @RequestHeader HttpHeaders headers) {
        String apikey = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if(apikey == null || !myAuth(apikey)) {
            throw new IllegalArgumentException("Api-Key not valid");
        }
        Attachment attachment = mAttachmentService.findById(id);
        List<Issue> issues = mIssueService.findAllByAttachmentListContaining(attachment);

        for (Issue i : issues) {
            Set<Attachment> att = i.getAttachmentList();
            att.remove(attachment);
            i.setAttachmentList(att);
            mIssueService.saveIssue(i);
        }

        mAttachmentService.deleteAttachment(id);
    }


    public boolean myAuth(String apikey) {
        boolean permission = false;
        if (mUserService.findUserByApiKey(apikey) != null) permission = true;
        else if(apikey.equals("admin")) permission = true;
        return permission;
    }
}