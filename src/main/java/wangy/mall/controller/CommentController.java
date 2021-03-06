package wangy.mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wangy.mall.entity.Comment;
import wangy.mall.entity.User;
import wangy.mall.service.CommentService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    //添加评论
    @PostMapping
    public Comment addComment(@RequestBody Comment comment, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        comment.setUserId(user.getId());
        return commentService.addComment(comment);
    }

    //查询某个商品评论
    @GetMapping("{goodsId}")
    public List<Comment> queryAllComments(@PathVariable int goodsId) {
        return commentService.queryAllComments(goodsId);
    }


    //删除一项评论
    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable int id) {
        commentService.deleteComment(id);
    }
}
