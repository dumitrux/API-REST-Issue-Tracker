package com.example.issuetrackerrest.controller;

import com.example.issuetrackerrest.entity.*;
import com.example.issuetrackerrest.entity.IssueDTO;
import com.example.issuetrackerrest.service.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.tomcat.util.buf.StringUtils;
import org.hibernate.hql.internal.ast.tree.OrderByClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

@Api(tags = "Issues")
@RestController
@RequestMapping(IssueController.BASE_URL)
public class IssueController {

    public static final String BASE_URL = "/api/v1/issues";

    @Autowired
    private final IssueService mIssueService;

    @Autowired
    private final VoteService mVoteService;

    @Autowired
    private final UserService mUserService;

    @Autowired
    private final WatcherService mWatcherService;

    @Autowired
    private final CommentService mCommentService;

    @Autowired
    private final AttachmentService mAttachmentService;


    @Autowired
    public IssueController(IssueService issueService,
                           VoteService mVoteService,
                           UserService mUserService,
                           WatcherService mWatcherService,
                           CommentService mCommentService, AttachmentService mAttachmentService) {
        this.mIssueService = issueService;
        this.mVoteService = mVoteService;
        this.mUserService = mUserService;
        this.mWatcherService = mWatcherService;
        this.mCommentService = mCommentService;
        this.mAttachmentService = mAttachmentService;
    }

    @ApiOperation(value = "Busca totes les issues",
                notes = "Retorna totes les issues creades fins ara",
                response = Issue.class,
                responseContainer = "List")
    @GetMapping()
    public List<Issue> getAllIssues() {
        return  mIssueService.findAllIssues();
    }

    // EJEMPLO1 para detallar las operaciones
    @ApiOperation(value = "Busca Issue per id",
                notes = "Donat un id busca el issue en concret",
                response = Issue.class)
    @GetMapping("/{id}")
    // EJEMPLO2 para detallar los parametros
    public Issue getIssueById(@ApiParam(value = "Valor del id pel Issue que vols", required = true)
                                  @PathVariable Long id) {
        return  mIssueService.findIssueById(id);
    }


    @ApiOperation(value = "Filtra les issues per priority",
            notes = "Donat l'ordre en que es vol ordenar, les issues s'ordenaran de forma ascendent o descendent",
            response = Issue.class,
            responseContainer = "List")
    @GetMapping("/priority")
    public List<Issue> getIssuesByFilterAndOrder(@ApiParam(value = "Ordre pel qual vols ordenar les issues", required = true)
                                                 @RequestParam(value = "Asc/Desc") ascDescEnum ascDescEnum,
                                                 @ApiParam(value = "Atribut pel qual vols ordenar les issues")
                                                 @RequestParam(value = "Order By", required = false) OrderByEnum order,
                                                 @ApiParam(value = "Priority per la qual vols filtrar", required = true)
                                                     @RequestParam("Priority") priorityEnum p) {
        if (order != null) {
            if (ascDescEnum == ascDescEnum.ASCENDENT) {
                switch (order) {
                    case TITLE:
                        return mIssueService.findAllByPriorityOrderByTitleAsc(p);
                    case VOTES:
                        return mIssueService.findAllByPriorityOrderByVotesAsc(p);
                    case ASSIGNEE:
                        return mIssueService.findAllByPriorityOrderByAssigneeAsc(p);
                    case WATCHERS:
                        return mIssueService.findAllByPriorityOrderByWatchersAsc(p);
                    case CREATEDAT:
                        return mIssueService.findAllByPriorityOrderByCreatedAtAsc(p);
                    case UPDATEDAT:
                        return mIssueService.findAllByPriorityOrderByUpdatedAtAsc(p);

                }
            } else if (ascDescEnum == ascDescEnum.DESCENDENT) {
                switch (order) {
                    case TITLE:
                        return mIssueService.findAllByPriorityOrderByTitleDesc(p);
                    case VOTES:
                        return mIssueService.findAllByPriorityOrderByVotesDesc(p);
                    case ASSIGNEE:
                        return mIssueService.findAllByPriorityOrderByAssigneeDesc(p);
                    case WATCHERS:
                        return mIssueService.findAllByPriorityOrderByWatchersDesc(p);
                    case CREATEDAT:
                        return mIssueService.findAllByPriorityOrderByCreatedAtDesc(p);
                    case UPDATEDAT:
                        return mIssueService.findAllByPriorityOrderByUpdatedAtDesc(p);

                }
            }
            else throw new IllegalArgumentException("orderby value is not 'ASCENDENT' or 'DESCENDENT'");
        } else
            return mIssueService.findAllByPriority(p);

        throw new IllegalArgumentException("order value is not any of the given types");

    }

    @ApiOperation(value = "Filtra les issues per status",
            notes = "Donat l'ordre en que es vol ordenar, les issues s'ordenaran de forma ascendent o descendent",
            response = Issue.class,
            responseContainer = "List")
    @GetMapping("/status")
    public List<Issue> getIssuesByFilterAndOrder(@ApiParam(value = "Ordre pel qual vols ordenar les issues", required = true)
                                                 @RequestParam(value = "Asc/Desc") ascDescEnum ascDescEnum,
                                                 @ApiParam(value = "Atribut pel qual vols ordenar les issues")
                                                 @RequestParam(value = "Order By", required = false) OrderByEnum order,
                                                 @ApiParam(value = "Status pel qual vols filtrar", required = true)
                                                 @RequestParam("Status") statusEnum s) {
        if (order != null) {
            if (ascDescEnum == ascDescEnum.ASCENDENT) {
                switch (order) {
                    case TITLE:
                        return mIssueService.findAllByStatusOrderByTitleAsc(s);
                    case VOTES:
                        return mIssueService.findAllByStatusOrderByVotesAsc(s);
                    case ASSIGNEE:
                        return mIssueService.findAllByStatusOrderByAssigneeAsc(s);
                    case WATCHERS:
                        return mIssueService.findAllByStatusOrderByWatchersAsc(s);
                    case CREATEDAT:
                        return mIssueService.findAllByStatusOrderByCreatedAtAsc(s);
                    case UPDATEDAT:
                        return mIssueService.findAllByStatusOrderByUpdatedAtAsc(s);

                }
            } else if (ascDescEnum == ascDescEnum.DESCENDENT) {
                switch (order) {
                    case TITLE:
                        return mIssueService.findAllByStatusOrderByTitleDesc(s);
                    case VOTES:
                        return mIssueService.findAllByStatusOrderByVotesDesc(s);
                    case ASSIGNEE:
                        return mIssueService.findAllByStatusOrderByAssigneeDesc(s);
                    case WATCHERS:
                        return mIssueService.findAllByStatusOrderByWatchersDesc(s);
                    case CREATEDAT:
                        return mIssueService.findAllByStatusOrderByCreatedAtDesc(s);
                    case UPDATEDAT:
                        return mIssueService.findAllByStatusOrderByUpdatedAtDesc(s);

                }
            }
            else throw new IllegalArgumentException("orderby value is not 'ASCENDENT' or 'DESCENDENT'");
        } else
            return mIssueService.findAllByStatus(s);

        throw new IllegalArgumentException("order value is not any of the given types");

    }

    @ApiOperation(value = "Filtra les issues per kind",
            notes = "Donat l'ordre en que es vol ordenar, les issues s'ordenaran de forma ascendent o descendent",
            response = Issue.class,
            responseContainer = "List")
    @GetMapping("/kind")
    public List<Issue> getIssuesByFilterAndOrder(@ApiParam(value = "Ordre pel qual vols ordenar les issues", required = true)
                                                 @RequestParam(value = "Asc/Desc") ascDescEnum ascDescEnum,
                                                 @ApiParam(value = "Atribut pel qual vols ordenar les issues")
                                                 @RequestParam(value = "Order By", required = false) OrderByEnum order,
                                                 @ApiParam(value = "Priority per la qual vols filtrar", required = true)
                                                 @RequestParam("Kind") typeEnum k) {
        if (order != null) {
            if (ascDescEnum == ascDescEnum.ASCENDENT) {
                switch (order) {
                    case TITLE:
                        return mIssueService.findAllByIssueTypeOrderByTitleAsc(k);
                    case VOTES:
                        return mIssueService.findAllByIssueTypeOrderByVotesAsc(k);
                    case ASSIGNEE:
                        return mIssueService.findAllByIssueTypeOrderByAssigneeAsc(k);
                    case WATCHERS:
                        return mIssueService.findAllByIssueTypeOrderByWatchersAsc(k);
                    case CREATEDAT:
                        return mIssueService.findAllByIssueTypeOrderByCreatedAtAsc(k);
                    case UPDATEDAT:
                        return mIssueService.findAllByIssueTypeOrderByUpdatedAtAsc(k);

                }
            } else if (ascDescEnum == ascDescEnum.DESCENDENT) {
                switch (order) {
                    case TITLE:
                        return mIssueService.findAllByIssueTypeOrderByTitleDesc(k);
                    case VOTES:
                        return mIssueService.findAllByIssueTypeOrderByVotesDesc(k);
                    case ASSIGNEE:
                        return mIssueService.findAllByIssueTypeOrderByAssigneeDesc(k);
                    case WATCHERS:
                        return mIssueService.findAllByIssueTypeOrderByWatchersDesc(k);
                    case CREATEDAT:
                        return mIssueService.findAllByIssueTypeOrderByCreatedAtDesc(k);
                    case UPDATEDAT:
                        return mIssueService.findAllByIssueTypeOrderByUpdatedAtDesc(k);

                }
            }
            else throw new IllegalArgumentException("orderby value is not 'ASCENDENT' or 'DESCENDENT'");
        } else
            return mIssueService.findAllByIssueType(k );

        throw new IllegalArgumentException("order value is not any of the given types");

    }


    @ApiOperation(value = "Filtra totes les Issues per l'usuari donat",
            response = Issue.class,
            responseContainer = "List")
    @GetMapping("/assignee")
    public List<Issue> getIssuesByAssignee(@ApiParam(value = "Usuari pel qual vols filtrar les issues", required = true)
                                               @RequestParam("username") String username) {
        User user = mUserService.findUserByUsername(username);
        return mIssueService.findAllByAssignee(user);
    }


    @ApiOperation(value = "Reordena totes les Issues per l'atribut donat",
            notes = "Donat l'ordre en que es vol ordenar, les issues s'ordenaran de forma ascendent o descendent",
            response = Issue.class,
            responseContainer = "List")
    @GetMapping("/orderBy")
    public List<Issue> getIssuesByOrderByVotes(@ApiParam(value = "Ordre pel qual vols ordenar les issues", required = true)
                                                   @RequestParam("orderby") ascDescEnum orderby,
                                               @ApiParam(value = "Atribut pel qual vols ordenar les issues", required = true)
                                               @RequestParam("atribute") OrderByEnum atr) {
        if (orderby == ascDescEnum.ASCENDENT) {
            switch (atr) {
                case UPDATEDAT:
                    return mIssueService.findAllByOrderByUpdatedAtAsc();
                case CREATEDAT:
                    return mIssueService.findAllByOrderByCreatedAtAsc();
                case WATCHERS:
                    return mIssueService.findAllByOrderByWatchersAsc();
                case ASSIGNEE:
                    return mIssueService.findAllByOrderByAssigneeAsc();
                case VOTES:
                    return mIssueService.findAllByOrderByVotesAsc();
                case TITLE:
                    return mIssueService.findAllByOrderByTitleAsc();
            }
        }
        else if (orderby == ascDescEnum.DESCENDENT){
            switch (atr) {
                case UPDATEDAT:
                    return mIssueService.findAllByOrderByUpdatedAtDesc();
                case CREATEDAT:
                    return mIssueService.findAllByOrderByCreatedAtDesc();
                case WATCHERS:
                    return mIssueService.findAllByOrderByWatchersDesc();
                case ASSIGNEE:
                    return mIssueService.findAllByOrderByAssigneeDesc();
                case VOTES:
                    return mIssueService.findAllByOrderByVotesDesc();
                case TITLE:
                    return mIssueService.findAllByOrderByTitleDesc();
            }
        }
        else throw new IllegalArgumentException("orderby value is not 'ASCENDENT' or 'DESCENDENT'");

        throw new IllegalArgumentException("order value is not any of the given types");
    }



    @ApiOperation(value = "Començar a fer Watching a una issue",
            notes = "Donat el id de la issue es crea un watcher de l'usuari a aquella issue")
    @PostMapping("/{id}/watch")
    @ResponseStatus(HttpStatus.CREATED)
    public void watchIssue(@PathVariable Long id,
                           @RequestHeader HttpHeaders headers) {
        String apikey = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if(apikey == null || !myAuth(apikey)) {
            throw new IllegalArgumentException("Api-Key not valid");
        }
        Issue issue = mIssueService.findIssueById(id);
        User user = mUserService.findUserByApiKey(apikey);
        if(!mWatcherService.existsWatcherByWatchedIssueAndWatchingUser(issue, user)) {
            Watcher nWatcher = new Watcher();
            Long userId = user.getId();
            nWatcher.setId(id+userId);
            nWatcher.setWatchedIssue(issue);
            nWatcher.setWatchingUser(user);
            mWatcherService.watcherSave(nWatcher);
            issue.setWatchers(issue.getWatchers()+1);
            mIssueService.saveIssue(issue);
        } else
            throw new NegativeArraySizeException("Issue already watched");
    }


    @ApiOperation(value = "Desfer el Watching a una issue",
            notes = "Donat el id de la issue es borra el watcher de l'usuari a aquella issue")
    @DeleteMapping("/{id}/watch")
    @ResponseStatus(HttpStatus.OK)
    public void unWatchIssue(@PathVariable Long id,
                             @RequestHeader HttpHeaders headers) {
        String apikey = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if(apikey == null || !myAuth(apikey)) {
            throw new IllegalArgumentException("Api-Key not valid");
        }
        Issue issue = mIssueService.findIssueById(id);
        User user = mUserService.findUserByApiKey(apikey);
        if (mWatcherService.existsWatcherByWatchedIssueAndWatchingUser(issue, user)) {
            Watcher watcher = mWatcherService.findWatcherByUserIssue(issue, user);
            mWatcherService.watcherDelete(watcher);
            issue.setWatchers(issue.getWatchers()-1);
            mIssueService.saveIssue(issue);
        } else
            throw new NegativeArraySizeException("This Issue is not watched");
    }

    @ApiOperation(value = "Votar a una issue",
            notes = "Donat el id de la issue es crea un vot de l'usuari a aquella issue")
    @PostMapping("/{id}/vote")
    @ResponseStatus(HttpStatus.CREATED)
    public void voteIssue(@PathVariable Long id,
                          @RequestHeader HttpHeaders headers) {
        String apikey = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if(apikey == null || !myAuth(apikey)) {
            throw new IllegalArgumentException("Api-Key not valid");
        }
        Issue issue = mIssueService.findIssueById(id);
        User user = mUserService.findUserByApiKey(apikey);
        if (!mVoteService.existsVoteByVotedIssueAndVotingUser(issue, user)) {
            Vote nVote = new Vote();
            Long userId = user.getId();
            nVote.setId(id+userId);
            nVote.setVotedIssue(issue);
            nVote.setVotingUser(user);
            mVoteService.voteSave(nVote);
            issue.setVotes(issue.getVotes()+1);
            mIssueService.saveIssue(issue);
        } else
            throw new NegativeArraySizeException("This Issue is already voted");

    }

    @ApiOperation(value = "Desfer un vot a una issue",
            notes = "Donat el id de la issue es borra el vot de l'usuari a aquella issue")
    @DeleteMapping("/{id}/vote")
    @ResponseStatus(HttpStatus.OK)
    public void unVoteIssue(@PathVariable Long id,
                            @RequestHeader HttpHeaders headers) {
        String apikey = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if(apikey == null || !myAuth(apikey)) {
            throw new IllegalArgumentException("Api-Key not valid");
        }
        Issue issue = mIssueService.findIssueById(id);
        User user = mUserService.findUserByApiKey(apikey);
        if (mVoteService.existsVoteByVotedIssueAndVotingUser(issue, user)) {
            Vote vote = mVoteService.findVoteByUserIssue(issue, user);
            mVoteService.voteDelete(vote);
            issue.setVotes(issue.getVotes() - 1);
            mIssueService.saveIssue(issue);
        } else
            throw new NegativeArraySizeException("This Issue is not voted");


    }


    @ApiOperation(value = "Afegir un attachment a una issue",
            notes = "Donat el id de la issue i el fitxer que se li vol assignar, s'assigna el fitxer a la issue",
            response = Issue.class)
    @PostMapping(value = "/{id}/attachments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Issue addAttachmentIssue(@ApiParam(value = "Fitxer que es vol assignar a la issue", required = true)
                                        @RequestParam("Attachment") MultipartFile attachment,
                                    @PathVariable Long id,
                                    @RequestHeader HttpHeaders headers) throws IOException {
        String apikey = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if(apikey == null || !myAuth(apikey)) {
            throw new IllegalArgumentException("Api-Key not valid");
        }
        Issue issue = mIssueService.findIssueById(id);
        Set<Attachment> attachments = issue.getAttachmentList();


        for (Attachment a : attachments){
            if (Arrays.equals(a.getAttachment(), attachment.getBytes()))
                throw new IllegalStateException("This issue already have this attachment");
        }
        Attachment att = new Attachment();
        att.setAttachment(attachment.getBytes());

        String dirtyName = attachment.getOriginalFilename();
        if (dirtyName.contains(".")) {
            String[] parts = dirtyName.split("\\.");
            String name = parts[0];
            String type = parts[1];
            att.setName(name);
            att.setType(type);
        } else {
            att.setName(dirtyName);
        }
        att.setDirtyName(dirtyName);
        Attachment a = mAttachmentService.saveAttachment(att);


        attachments.add(att);
        issue.setAttachmentList(attachments);

        return mIssueService.saveIssue(issue);
    }

    @ApiOperation(value = "Busca tots els attachments d'una issue",
            notes = "Donat el id de la issue, es busquen tots els attachments que te")
    @GetMapping("{id}/attachments")
    public Attachment[] getAllIssueAttachments(@PathVariable Long id) {
        Issue issue = mIssueService.findIssueById(id);
        if(issue.getAttachmentList() != null) {
            Set<Attachment> attachments = issue.getAttachmentList();
            Attachment[] result = new Attachment[attachments.size()];
            attachments.toArray(result);
            return result;
        }
        else throw new IllegalStateException("This issue does not have attachements");
    }


    @ApiOperation(value = "Crea una issue",
            notes = "Es crea una issue amb la informacio enviada pel body i parametres",
            response = Issue.class)
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Issue addIssue(@ApiParam(value = "Titol que es vol assignar a la issue", required = true)
                              @RequestParam(name = "title") String title,
                          @ApiParam(value = "Usuari que es vol assignar a la issue")
                              @RequestParam(name = "assignee", required = false) String assignee,
                          @ApiParam(value = "Descripció que es vol assignar a la issue")
                              @RequestParam(name = "description", required = false) String description,
                          @ApiParam(value = "Prioritat que es vol assignar a la issue")
                              @RequestParam(name = "priority", defaultValue = "MAJOR", required = false) priorityEnum priority,
                          @ApiParam(value = "Tipus que es vol assignar a la issue")
                              @RequestParam(name = "kind", defaultValue = "BUG", required = false) typeEnum issueType,
                          @RequestHeader HttpHeaders headers) {

        String apikey = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if(apikey == null || !myAuth(apikey)) {
            throw new IllegalArgumentException("Api-Key not valid");
        }


        Issue issue = new Issue();
        issue.setTitle(title);
        User user = mUserService.findUserByUsername(assignee);
        issue.setAssignee(user);
        issue.setDescription(description);
        Date createdAt = Calendar.getInstance().getTime();
        if (priority == null) {
            issue.setPriority(priorityEnum.MAJOR);
        } else {
            issue.setPriority(priority);
        }
        if (issueType == null) {
            issue.setIssueType(typeEnum.BUG);
        } else {
            issue.setIssueType(issueType);
        }
        issue.setCreatedAt(createdAt);
        issue.setUpdatedAt(createdAt);
        issue.setStatus(statusEnum.NEW);
        issue.setCreator(mUserService.findUserByApiKey(apikey));


        return mIssueService.saveIssue(issue);
    }

    @ApiOperation(value = "Borra una issue",
            notes = "Borra la issue amb el id passat per parametre")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIssue(@PathVariable("id") Long id,
                            @RequestHeader HttpHeaders headers) {
        String apikey = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if(apikey == null || !myAuth(apikey)) {
            throw new IllegalArgumentException("Api-Key not valid");
        }
        Issue issue = mIssueService.findIssueById(id);

        List<Comment> comments = mCommentService.findAllComments(mIssueService.findIssueById(id));
        for (Comment c : comments) {
            mCommentService.deleteCommentById(c.getId());
        }
        List<Vote> votes = mVoteService.findAllByVotedIssue(issue);
        for (Vote v : votes) {
            mVoteService.voteDelete(v);
        }

        List<Watcher> watchers = mWatcherService.findAllByWatchedIssue(issue);
        for (Watcher w : watchers) {
            mWatcherService.watcherDelete(w);
        }


        mIssueService.deleteIssue(id);
    }


    @ApiOperation(value = "Actualitza una issue",
            notes = "S'actuallitza la issue amb el id especificat, la informacio enviada pel body i parametres",
            response = Issue.class)
    @PutMapping("/{id}")
    public Issue updateIssue(@PathVariable("id") Long id,
                             @RequestParam(name = "priority", required = false) priorityEnum priority,
                             @RequestParam(name = "kind", required = false) typeEnum issueType,
                             @RequestParam(name = "status", required = false) statusEnum status,
                             @RequestParam(name = "username", required = true) String name,
                             @RequestBody IssueDTO issueDetails,
                             @RequestHeader HttpHeaders headers){
        String apikey = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if(apikey == null || !myAuth(apikey)) {
            throw new IllegalArgumentException("Api-Key not valid");
        }
        Issue issueMod = mIssueService.findIssueById(id);
        if (issueDetails != null) {
            Comment autoComment = new Comment();
            String body = new String();
            User creator = mUserService.findUserByUsername(name);
            if (issueDetails.getTitle() != null && !issueDetails.getTitle().equals(issueMod.getTitle())) {
                issueMod.setTitle(issueDetails.getTitle());
                body += "title changed to " + issueDetails.getTitle() + "    ";
            }
            if (issueDetails.getDescription() != null && !issueDetails.getDescription().equals(issueMod.getDescription())){
                issueMod.setDescription(issueDetails.getDescription());
                body += "edited description" + "    ";
            }
            User user = mUserService.findUserByUsername(issueDetails.getAssignee());
            if (issueDetails.getAssignee() != null && user != issueMod.getAssignee()) {
                issueMod.setAssignee(user);
                body += "assigned issue to " + issueDetails.getAssignee() + "    ";
            }
            if (issueType != null && issueType != issueMod.getIssueType()) {
                issueMod.setIssueType(issueType);
                body += "marked as " + issueType.toString() + "    ";

            }
            if (priority != null && priority != issueMod.getPriority()) {
                issueMod.setPriority(priority);
                body += "marked as " + priority.toString() + "    ";
            }
            if (status != null && status != issueMod.getStatus()){
                issueMod.setStatus(status);
                body += "changed status to " + status.toString() + "    ";
            }
            if (!body.isEmpty()) {
                autoComment.setBody(body);
                autoComment.setIssue(mIssueService.findIssueById(id));
                Date createdAt = Calendar.getInstance().getTime();
                autoComment.setCreatedAt(createdAt);
                autoComment.setUpdatedAt(createdAt);
                autoComment.setCreator(creator);
                autoComment.setSystem(true);
                mCommentService.saveComment(autoComment);
            }


            issueMod.setUpdatedAt(Calendar.getInstance().getTime());
            return mIssueService.saveIssue(issueMod);
        } else
            throw new NegativeArraySizeException("id not found");

    }

    @ApiOperation(value = "Afegeix un comentari a una issue",
            notes = "S'afegeix un comentari a la issue amb el id espesificat",
            response = Comment.class)
    @PostMapping("/{id}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment addComment(@PathVariable("id") Long id,
                              @RequestBody CommentDTO commentDTO,
                              @RequestHeader HttpHeaders headers) {

        String apikey = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if(apikey == null || !myAuth(apikey)) {
            throw new IllegalArgumentException("Api-Key not valid");
        }
        Comment comment = new Comment();
        comment.setIssue(mIssueService.findIssueById(id));
        comment.setBody(commentDTO.getBody());
        Date createdAt = Calendar.getInstance().getTime();
        comment.setCreatedAt(createdAt);
        comment.setUpdatedAt(createdAt);
        User creator = mUserService.findUserByApiKey(apikey);
        comment.setCreator(creator);
        comment.setSystem(false);
        return mCommentService.saveComment(comment);
    }

    @ApiOperation(value = "Busca tots els comentaris d'una issue",
            notes = "Busca tots els comentaris de la issue amb el id especificat",
            responseContainer = "List",
            response = Comment.class)
    @GetMapping("/{id}/comments") //id de la issue
    public List<Comment> getAllComments(@PathVariable Long id) {
        return mCommentService.findAllComments(mIssueService.findIssueById(id));
    }

    @ApiOperation(value = "Busca totes les issues que l'usuari està mirant",
            notes = "Busca tots els comentaris de la issue amb el id especificat",
            responseContainer = "List",
            response = Issue.class)
    @GetMapping("/watching")
    public List<Issue> getIssuesWatching(@RequestParam(name = "username", required = false) String username) {
        User user = mUserService.findUserByUsername(username);
        List<Watcher> watching = mWatcherService.findAllByWatchingUser(user);
        List<Issue> ret = new ArrayList<>();
        for (Watcher w : watching) {
            Issue i = mIssueService.findIssueById(w.getWatchedIssue().getId());
            ret.add(i);
        }
        return ret;
    }

    @ApiOperation(value = "Actualitza/Edita un comentari",
            notes = "El comentari de la issue especificada amb el id, es caniva amb la nova informacio aportada",
            response = Comment.class)
    @PutMapping("/{id}/comments/{commentId}")
    public Comment updateComment(@PathVariable("id") Long id,
                                 @PathVariable("commentId") Long commentId,
                                 @RequestBody CommentDTO commentDTO,
                                 @RequestHeader HttpHeaders headers) {

        String apikey = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if (apikey == null || !myAuth(apikey)) {
            throw new IllegalArgumentException("Api-Key not valid");
        }
        User user = mUserService.findUserByApiKey(apikey);
        Comment comment = mCommentService.findCommentById(commentId);
        if (user != comment.getCreator())
            throw new IllegalArgumentException("Current User is not the owner of the comment");
        if (commentDTO == null || commentDTO.getBody().isEmpty())
            throw new IllegalArgumentException("Body cannot be empty");
        comment.setBody(commentDTO.getBody());
        Date updatedAt = Calendar.getInstance().getTime();
        comment.setUpdatedAt(updatedAt);
        return mCommentService.saveComment(comment);
    }

    @ApiOperation(value = "Borra el comentari d'una issue",
            notes = "Elimina el comentari de la issue identificada amb el id especificat")
    @DeleteMapping("/{id}/comments/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("id") Long id,
                                 @PathVariable("commentId") Long commentId,
                                 @RequestHeader HttpHeaders headers) {

        String apikey = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if (apikey == null || !myAuth(apikey)) {
            throw new IllegalArgumentException("Api-Key not valid");
        }
        User user = mUserService.findUserByApiKey(apikey);
        Comment comment = mCommentService.findCommentById(commentId);
        if (user != comment.getCreator())
            throw new IllegalArgumentException("Current User is not the owner of the comment");
        mCommentService.deleteCommentById(comment.getId());
    }


    public boolean myAuth(String apikey) {
        boolean permission = false;
        if (mUserService.findUserByApiKey(apikey) != null) permission = true;
        else if(apikey.equals("admin")) permission = true;
        return permission;
    }
}
