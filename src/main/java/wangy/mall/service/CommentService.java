package wangy.mall.service;

import wangy.mall.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment addComment(Comment comment);

    List<Comment> queryAllComments(int goodsId);

    void deleteComment(int id);

}
